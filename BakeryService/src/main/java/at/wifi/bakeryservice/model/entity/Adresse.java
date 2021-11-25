package at.wifi.bakeryservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADRESSE", schema = "BAKERIES")
public class Adresse extends DBO {


    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_ADRESSE_ID")
    @SequenceGenerator(name = "GEN_SEQ_ADRESSE_ID", sequenceName = "SEQ_ADRESSE_ID")
    private Long id;

    @Column(name = "STRASSE", nullable = false)
    private String strasse;

    @Column(name = "HAUSNUMMER", nullable = false)
    private String hausnummer;

    @Column(name = "ZUSATZ")
    private String zusatz;

    @Column(name = "PLZ", nullable = false)
    private String plz;

    @Column(name = "ORTSCHAFT", nullable = false)
    private String ortschaft;

}
