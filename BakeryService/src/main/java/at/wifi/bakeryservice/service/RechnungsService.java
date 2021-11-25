package at.wifi.bakeryservice.service;

import at.wifi.bakeryservice.model.entity.Auftragszeile;
import at.wifi.bakeryservice.model.entity.Bestellung;
import at.wifi.bakeryservice.model.entity.Rechnung;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RechnungsService {

    @Transactional
    public Rechnung createRechnung(Bestellung bestellung) {

        final Rechnung rechnung = new Rechnung();
        rechnung.setAuftragnehmer(bestellung.getAuftragsteller());
        rechnung.setAuftragsteller(bestellung.getAuftragnehmer());
        rechnung.setErstelltAm(LocalDate.now());
        rechnung.setFaelligAm(LocalDate.now().plusDays(30));
        rechnung.setAuftragsZeilen(bestellung.getAuftragsZeilen());
        rechnung.setBetrag(calculateTotalPrice(bestellung.getAuftragsZeilen()));

        return rechnung;
    }

    private BigDecimal calculateTotalPrice(List<Auftragszeile> auftragszeilen) {
        BigDecimal bigDecimal = new BigDecimal("0.00");
        for (Auftragszeile az : auftragszeilen) {
            BigDecimal gesamtpreisProProdukt = az.getProdukt().getEinzelPreis().multiply(new BigDecimal(String.valueOf(az.getMenge())));
            bigDecimal = bigDecimal.add(gesamtpreisProProdukt);
        }
        return bigDecimal;
    }

}
