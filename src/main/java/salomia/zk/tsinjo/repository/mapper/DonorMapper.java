package salomia.zk.tsinjo.repository.mapper;

import salomia.zk.tsinjo.modele.Donor;
import salomia.zk.tsinjo.repository.model.DonorDao;

public class DonorMapper {
    public static DonorDao toDao(Donor dto) {
        return new DonorDao(dto.getId(), dto.getName(), dto.getEmail());
    }

    public static Donor toDto(DonorDao dao) {
        return new Donor(dao.getId(), dao.getName(), dao.getEmail());
    }
}
