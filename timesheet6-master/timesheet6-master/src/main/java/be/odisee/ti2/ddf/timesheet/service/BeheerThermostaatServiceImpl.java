package be.odisee.ti2.ddf.timesheet.service;

import be.odisee.ti2.ddf.timesheet.dao.ThermostaatRepository;
import be.odisee.ti2.ddf.timesheet.domain.Thermostaat;
import be.odisee.ti2.ddf.timesheet.service.BeheerThermostaatService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BeheerThermostaatServiceImpl implements BeheerThermostaatService{

    @Autowired
    private ThermostaatRepository thermostaatRepository;

    @Override
    public List<Thermostaat> GetAllThermostaten() {
        return thermostaatRepository.findAll();
    }

    @Override
    public Thermostaat getThermostaatFromID(int id) {
        return thermostaatRepository.findById(id);
    }

    @Override
    public List<Thermostaat> getThermostatenfromKlantID(int id) {
        List<Thermostaat> thermostaatList = thermostaatRepository.findAllByKlantID(id);
        return thermostaatList;
    }

    @Override
    public void deleteThermostaat(int id) {
        Thermostaat thermostaat =thermostaatRepository.findById(id);
        thermostaatRepository.delete(thermostaat);
    }

    @Override
    public boolean updateThermostaat(int id, Thermostaat thermostaatData) {
        Thermostaat existingThermostaat = thermostaatRepository.findById(id);

        if (existingThermostaat != null) {
            existingThermostaat.setKlantID(thermostaatData.getKlantID());
            existingThermostaat.setDatum_geinstalleerd(thermostaatData.getDatum_geinstalleerd());
            existingThermostaat.setDatum_laatste_onderhoud(thermostaatData.getDatum_laatste_onderhoud());
            existingThermostaat.setLeverancier(thermostaatData.getLeverancier());
            existingThermostaat.setAdres(thermostaatData.getAdres());

            thermostaatRepository.save(existingThermostaat);
            return true;
        }
        return false;
    }

    @Override
    public void addThermostaat(Thermostaat thermostaat){
        thermostaatRepository.save(thermostaat);
    }

}
