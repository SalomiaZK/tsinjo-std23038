package salomia.zk.tsinjo.repository.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import salomia.zk.tsinjo.modele.Payment;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private Payment payment;
}
