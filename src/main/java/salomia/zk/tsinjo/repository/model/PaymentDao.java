package salomia.zk.tsinjo.repository.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDao {
    @Id
    private String id;
    private LocalDate date;
    private long amount;
    private String paymentType;
}
