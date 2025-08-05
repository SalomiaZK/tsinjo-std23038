package salomia.zk.tsinjo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import salomia.zk.tsinjo.modele.Status;
import salomia.zk.tsinjo.repository.DonationRepository;
import salomia.zk.tsinjo.repository.model.DonationDao;
import salomia.zk.tsinjo.repository.model.PaymentResponse;

import java.util.List;

@Component
public class PaymentPollingService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private WebClient webClient;

    @Scheduled(fixedDelay = 30000)  // toutes les 30 secondes (ajuste selon besoin)
    public void pollPayments() {
        // Récupère les paiements à vérifier
        List<DonationDao> verifyingDonations = donationRepository.findByPaymentStatus("VERIFYING");

        for (var donationDao : verifyingDonations) {
            String paymentId = donationDao.getPayment().getId();

            PaymentResponse response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/payments/{id}")
                            .build(paymentId))
                    .header("Authorization", "Bearer " + System.getenv("TOKEN_VOLA"))
                    .retrieve()
                    .bodyToMono(PaymentResponse.class)
                    .block();

            if (response != null && response.getPayment() != null) {
                Status newStatus = response.getPayment().getStatus();

                if (!donationDao.getPayment().getStatus().equals(newStatus)) {
                    donationDao.getPayment().setStatus(newStatus);
                    donationRepository.save(donationDao);
                    // Log info ou autre action sur changement d'état
                }
            }
        }
    }
}
