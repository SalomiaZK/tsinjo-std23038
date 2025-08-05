package salomia.zk.tsinjo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salomia.zk.tsinjo.modele.Donation;
import salomia.zk.tsinjo.repository.DonationRepository;
import salomia.zk.tsinjo.repository.mapper.DonationMapper;
import salomia.zk.tsinjo.repository.model.DonationDao;

import java.util.List;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;


    public Donation makeDonation(Donation donation) {
        var donationDao = DonationMapper.toDao(donation);
        var saveDonation = donationRepository.save(donationDao);
        return DonationMapper.toDto(saveDonation);
    }
}
