package at.wifi.bakeryservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUFTRAGSZEILE", schema = "BAKERIES")
public class Auftragszeile {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_AUFTRAGSZEILE_ID")
    @SequenceGenerator(name = "GEN_SEQ_AUFTRAGSZEILE_ID", sequenceName = "SEQ_AUFTRAGSZEILE_ID", schema = "BAKERIES")
    private Long id;

    @OneToOne
    @JoinColumn(name = "FK_PRODUKT_ID", referencedColumnName = "ID", nullable = false)
    private Produkt produkt;

    @Column(name = "MENGE",nullable = false)
    private int menge;

    @ManyToOne
    @JoinColumn(name = "FK_AUFTRAG_ID", referencedColumnName = "ID")
    private Auftrag auftrag;

}
