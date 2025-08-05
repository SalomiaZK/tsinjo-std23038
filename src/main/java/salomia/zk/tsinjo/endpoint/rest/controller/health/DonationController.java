package salomia.zk.tsinjo.endpoint.rest.controller.health;

import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import salomia.zk.tsinjo.modele.Donation;
import salomia.zk.tsinjo.repository.model.DonationDao;
import salomia.zk.tsinjo.service.DonationService;

import java.util.List;

@RestController
public class DonationController {
    @Autowired
    DonationService donationService;

    @PostMapping("/donation")
    public Donation getDonations(@RequestParam("Donation")  Donation donation) {
        return donationService.makeDonation(donation);
    }

}

