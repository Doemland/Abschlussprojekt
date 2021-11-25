package at.wifi.bakeryservice.model.entity;

import at.wifi.bakeryservice.model.entity.enums.Allergene;
import at.wifi.bakeryservice.model.entity.enums.Einheit;
import at.wifi.bakeryservice.model.entity.enums.ProduktTyp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUKT", schema = "BAKERIES")
public class Produkt extends DBO{

    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SEQ_PRODUKT_ID")
    @SequenceGenerator(name = "GEN_SEQ_PRODUKT_ID", sequenceName = "SEQ_PRODUKT_ID", schema = "BAKERIES")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_BAKERY_ID", nullable = false, updatable = false)
    private Bakery bakery;

    @ElementCollection(targetClass = Allergene.class)
    @JoinTable(name = "PRODUKT_TO_ALERGENE", joinColumns = @JoinColumn(name = "FK_PRODUKT_ID"), schema = "BAKERIES")
    @Column(name = "allergene", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Allergene> allergeneList;

    @Column(name = "EINZELPREIS",nullable = false)
    private BigDecimal einzelPreis;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRODUKTTYP",nullable = false)
    private ProduktTyp produktTyp;

    @Column(name = "EINHEIT",nullable = false)
    private Einheit einheit;
}
