package salomia.zk.tsinjo.modele;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public class Donor {
    private final String id;
    private final String name;
    private final String email;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
