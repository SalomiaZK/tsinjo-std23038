package salomia.zk.tsinjo.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class Donation {
    private final String id;
    private final  Donor donor;
    private final  Payment payment;
}
