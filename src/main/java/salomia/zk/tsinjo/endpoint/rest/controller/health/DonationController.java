package salomia.zk.tsinjo.endpoint.rest.controller.health;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import salomia.zk.tsinjo.modele.Donation;
import salomia.zk.tsinjo.repository.model.DonationDao;
import salomia.zk.tsinjo.service.DonationService;

import java.util.List;

@RestController
public class DonationController {
    @Autowired
    DonationService donationService;

    @GetMapping("/donation")
    public List<DonationDao> getDonations() {
        return donationService.getDonations();
    }

}

