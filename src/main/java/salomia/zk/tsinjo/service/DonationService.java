package salomia.zk.tsinjo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salomia.zk.tsinjo.modele.Donation;
import salomia.zk.tsinjo.modele.Payment;
import salomia.zk.tsinjo.modele.Status;
import salomia.zk.tsinjo.repository.DonationRepository;
import salomia.zk.tsinjo.repository.mapper.DonationMapper;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import salomia.zk.tsinjo.repository.model.PaymentResponse;

@Service
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private WebClient webClient;

    public Donation makeDonation(Donation donation) {
        // Sauvegarde initiale en DAO
        var donationDao = DonationMapper.toDao(donation);
        donationDao = donationRepository.save(donationDao);

        // Appel GET à Vola pour vérifier le paiement
        String paymentId = donation.getPayment().getId();  // Assume que le Payment a déjà un ID

        PaymentResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/payments/{id}")
                        .build(paymentId))
                .header("Authorization", "Bearer " + System.getenv("TOKEN_VOLA"))
                .retrieve()
                .bodyToMono(PaymentResponse.class)
                .block();

        if (response != null && response.getPayment() != null) {
            // Récupérer le status
            Status status = response.getPayment().getStatus();

            // Mettre à jour l'état du paiement dans la donation DAO
            donationDao.getPayment().setStatus(status);

            // Re-sauvegarder la donation avec paiement à jour
            donationDao = donationRepository.save(donationDao);
        }

        return DonationMapper.toDto(donationDao);
    }
}
