package salomia.zk.tsinjo.repository.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "beneficiaries")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeneficiaryDao {
    @Id
    private String id;
    private String name;
    private String email;
}
