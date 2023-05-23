package be.odisee.jzzz.controller;

import be.odisee.jzzz.dao.ThermostaatRepository;
import be.odisee.jzzz.domain.Thermostaat;
import be.odisee.jzzz.service.ThermostaatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path="/thermostaatrest", produces = "application/json")
// needed for CORS cookie passing from vue front and API tester respectively
@CrossOrigin(origins={"http://localhost:8888", "chrome-extension://aejoelaoggembcahagimdiliamlcdmfm"},
        maxAge = 3600, allowCredentials = "true")
public class ThermostaatController {
    @Autowired
    private ThermostaatRepository thermostaatRepository;

    @Autowired
    private ThermostaatService ThermostaatService;


    @GetMapping("/{id}")
    public ResponseEntity<Thermostaat> getThermostaatById(@PathVariable("id") int id) {
        Thermostaat thermostaat = ThermostaatService.getThermostaatFromID(id);

        if (thermostaat != null) {
            return new ResponseEntity<>(thermostaat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping("/thermostaten")
    public Object GetAllThermostaten(){
        return ThermostaatService.GetAllThermostaten();
    }

    @GetMapping("/thermostaten/{id}")
    public Object GetAllThermostatenKlant(@PathVariable("id") int id){
        return ThermostaatService.getThermostatenfromKlantID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateThermostaat(
            @PathVariable("id") int id,
            @RequestParam(name = "klantID", required = false) Integer klantID,
            @RequestParam(name = "datum_geinstalleerd", required = false) String datum_geinstalleerd,
            @RequestParam(name = "datum_laatste_onderhoud", required = false) String datum_laatste_onderhoud,
            @RequestParam(name = "datum_volgend_onderhoud", required = false) String datum_volgend_onderhoud,
            @RequestParam(name = "leverancier", required = false) String leverancier,
            @RequestParam(name = "adres", required = false) String adres) {

        Thermostaat thermostaat = new Thermostaat();
        if (klantID != null) {
            thermostaat.setKlantID(klantID);
        }
        if (datum_geinstalleerd != null) {
            thermostaat.setDatum_geinstalleerd(datum_geinstalleerd);
        }
        if (datum_laatste_onderhoud != null) {
            thermostaat.setDatum_laatste_onderhoud(datum_laatste_onderhoud);
        }
        if (datum_volgend_onderhoud != null) {
            thermostaat.setDatum_volgend_onderhoud(datum_volgend_onderhoud);
        }
        if (leverancier != null) {
            thermostaat.setLeverancier(leverancier);
        }
        if (adres != null) {
            thermostaat.setAdres(adres);
        }

        try {
            boolean updated = ThermostaatService.updateThermostaat(id, thermostaat);
            if (updated) {
                return new ResponseEntity<>("Thermostaat with ID " + id + " updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update thermostaat with ID " + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating thermostaat with ID " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Delete the thermostaat and prepare for creation of a new one
     * @return how the operation went
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteThermostaat(@PathVariable("id") int id) {
        ThermostaatService.deleteThermostaat(id);
        return new ResponseEntity<>("Successfully deleted thermostaat with id " + id, HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<String> addThermostaat(@RequestParam(name = "klantID", required = true) Integer klantID,
                                                 @RequestParam(name = "datum_geinstalleerd", required = true) String datum_geinstalleerd,
                                                 @RequestParam(name = "datum_laatste_onderhoud", required = false) String datum_laatste_onderhoud,
                                                 @RequestParam(name = "datum_volgend_onderhoud", required = false) String datum_volgend_onderhoud,
                                                 @RequestParam(name = "leverancier", required = true) String leverancier,
                                                 @RequestParam(name = "adres", required = true) String adres) {
        Thermostaat thermostaat = new Thermostaat();
        thermostaat.setKlantID(klantID);
        thermostaat.setDatum_geinstalleerd(datum_geinstalleerd);
        thermostaat.setDatum_laatste_onderhoud(datum_laatste_onderhoud);
        thermostaat.setDatum_volgend_onderhoud(datum_volgend_onderhoud);
        thermostaat.setLeverancier(leverancier);
        thermostaat.setAdres(adres);

        try {
            ThermostaatService.addThermostaat(thermostaat);
            return new ResponseEntity<>("Successfully added thermostat", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while adding thermostat", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
