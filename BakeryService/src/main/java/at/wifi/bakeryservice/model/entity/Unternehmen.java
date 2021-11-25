package at.wifi.bakeryservice.model.entity;


import at.wifi.bakeryservice.model.entity.enums.Rechtsform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="UNTERNEHMEN_TYP", discriminatorType = DiscriminatorType.STRING)
@Table(name = "UNTERNEHMEN", schema = "BAKERIES")
public abstract class Unternehmen extends DBO {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_UNTERNEHMEN_ID")
    @SequenceGenerator(name = "GEN_SEQ_UNTERNEHMEN_ID", sequenceName = "SEQ_UNTERNEHMEN_ID", schema = "BAKERIES")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToOne
    @JoinColumn(name = "FK_ADRESSE_ID", referencedColumnName = "ID", nullable = false)
    private Adresse adresse;

    @Column(name = "GRUENDUNGSJAHR")
    private LocalDate gruendungsJahr;

    @Column(name = "RECHTSFORM")
    @Enumerated(value = EnumType.STRING)
    private Rechtsform rechtsform;

    @OneToOne
    @JoinColumn(name = "FK_KONTAKTDATEN_ID", referencedColumnName = "ID")
    private KontaktDaten kontaktDaten;
}
