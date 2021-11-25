package at.wifi.bakeryservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "RECHNUNG", schema = "BAKERIES")
public class Rechnung extends Auftrag{

    @Column(name = "BETRAG", nullable = false)
    private BigDecimal betrag;

    @Column(name = "FAELLIGAM", nullable = false)
    private LocalDate faelligAm;

}
