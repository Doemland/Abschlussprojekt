package at.wifi.bakeryservice.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue(value = "HOTEL")
public class Hotel extends Unternehmen{

    @OneToMany(mappedBy = "auftragsteller")
    private List<Auftrag> rechnungen;
}
