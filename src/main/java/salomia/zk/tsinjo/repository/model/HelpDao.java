package salomia.zk.tsinjo.repository.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "helps")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class HelpDao {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "beneficiary_id")
    private BeneficiaryDao beneficiary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentDao payment;

    private String accidentDescription;
}
