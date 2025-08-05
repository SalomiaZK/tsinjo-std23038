package salomia.zk.tsinjo.repository.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "donations")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonationDao {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private DonorDao donor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentDao payment;
}
