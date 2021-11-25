package at.wifi.bakeryservice.controller;

import at.wifi.bakeryservice.model.entity.Bestellung;
import at.wifi.bakeryservice.model.entity.Rechnung;
import at.wifi.bakeryservice.service.RechnungsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/app/bakery")
public class RestController {

    @Autowired
    private RechnungsService rechnungsService;

    @GetMapping(path = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> returnStatus() {
        return ResponseEntity.ok("OK!");
    }

    @PostMapping(path = "/bestellung", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rechnung> receiveBestellung(@RequestBody Bestellung bestellung) {
        return ResponseEntity.ok(rechnungsService.createRechnung(bestellung));
    }
}
