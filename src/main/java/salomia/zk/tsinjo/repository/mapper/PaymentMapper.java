package salomia.zk.tsinjo.repository.mapper;


import salomia.zk.tsinjo.modele.Payment;
import salomia.zk.tsinjo.repository.model.PaymentDao;

public class PaymentMapper {
    public static PaymentDao toDao(Payment dto) {
        return new PaymentDao(dto.getId(), dto.getDate(), dto.getAmount(), dto.getPaymentType(), dto.getStatus());
    }

    public static Payment toDto(PaymentDao dao) {
        return new Payment(dao.getId(), dao.getDate(), dao.getAmount(), dao.getPaymentType(),  dao.getStatus());
    }
}
