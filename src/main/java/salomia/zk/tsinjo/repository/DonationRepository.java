package salomia.zk.tsinjo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import salomia.zk.tsinjo.repository.model.DonationDao;
import salomia.zk.tsinjo.repository.model.Dummy;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<DonationDao, String> {

    @Override
    List<DonationDao> findAll();
}
