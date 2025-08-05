package salomia.zk.tsinjo.modele;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Payment {
    private final String id;
    private final LocalDate date;
    private final long amount;
    private final String paymentType;
}
