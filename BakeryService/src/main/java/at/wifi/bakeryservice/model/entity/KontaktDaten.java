package at.wifi.bakeryservice.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KONTAKTDATEN", schema = "BAKERIES")
public class KontaktDaten extends DBO {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_KONTAKT_ID")
    @SequenceGenerator(name = "GEN_SEQ_KONTAKT_ID", sequenceName = "SEQ_KONTAKT_ID", schema = "BAKERIES")
    private Long id;

    @Column(name = "TELEFONNUMMER")
    private String telefonNummer;

    @Column(name = "EMAIL")
    private String email;

}
