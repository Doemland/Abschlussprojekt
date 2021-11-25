package at.wifi.bakeryservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUFTRAG", schema = "BAKERIES")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Auftrag {

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_AUFTRAG_ID")
    @SequenceGenerator(name = "GEN_SEQ__AUFTRAG_ID", sequenceName = "SEQ_AUFTRAG_ID", schema = "BAKERIES")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "FK_UNTERNEHMEN_AS_ID")
    private Unternehmen auftragsteller;

    @ManyToOne()
    @JoinColumn(name = "FK_UNTERNEHMEN_AN_ID")
    private Unternehmen auftragnehmer;

    @Column(name = "ERSTELLTAM",nullable = false)
    private LocalDate erstelltAm;

    @OneToMany(mappedBy = "auftrag", orphanRemoval = true)
    private List<Auftragszeile> auftragsZeilen;
}
