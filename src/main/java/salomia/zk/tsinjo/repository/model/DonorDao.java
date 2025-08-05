package salomia.zk.tsinjo.repository.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "donors")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonorDao {
    @Id
    private String id;
    private String name;
    private String email;
}
