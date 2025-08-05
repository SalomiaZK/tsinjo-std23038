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
        var donationDao = DonationMapper.toDao(donation);
        donationDao = donationRepository.save(donationDao);

        String paymentId = donation.getPayment().getId();

        PaymentResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/payments/{id}")
                        .build(paymentId))
                .header("Authorization", "Bearer " + System.getenv("TOKEN_VOLA"))
                .retrieve()
                .bodyToMono(PaymentResponse.class)
                .block();

        if (response != null && response.getPayment() != null) {
            Status status = response.getPayment().getStatus();

            donationDao.getPayment().setStatus(status);

            donationDao = donationRepository.save(donationDao);
        }

        return DonationMapper.toDto(donationDao);
    }
}
