package salomia.zk.tsinjo.repository.mapper;


import salomia.zk.tsinjo.modele.Donation;
import salomia.zk.tsinjo.repository.model.DonationDao;

public class DonationMapper {

    public static DonationDao toDao(Donation dto) {
        return new DonationDao(
                dto.getId(),
                DonorMapper.toDao(dto.getDonor()),
                PaymentMapper.toDao(dto.getPayment())
        );
    }

    public static Donation toDto(DonationDao dao) {
        return new Donation(
                dao.getId(),
                DonorMapper.toDto(dao.getDonor()),
                PaymentMapper.toDto(dao.getPayment())
        );
    }
}
