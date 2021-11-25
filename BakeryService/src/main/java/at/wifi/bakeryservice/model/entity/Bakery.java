package at.wifi.bakeryservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("BAKERY")
public class Bakery extends Unternehmen{

    @OneToMany(mappedBy = "auftragnehmer", orphanRemoval = true)
    private List<Auftrag> rechnungen;

    @OneToMany(mappedBy = "bakery", orphanRemoval = true)
    private List<Produkt> produkt;

}
