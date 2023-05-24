package be.odisee.ti2.ddf.timesheet.service;

import be.odisee.ti2.ddf.timesheet.domain.Thermostaat;
import jakarta.validation.Valid;

import java.util.List;

public interface BeheerThermostaatService {
    public List<Thermostaat> GetAllThermostaten();
    public Thermostaat getThermostaatFromID(int id);
    public List<Thermostaat> getThermostatenfromKlantID(int id);
    public void deleteThermostaat(int id);
    public boolean updateThermostaat(int id, Thermostaat thermostaatData);
    public void addThermostaat(Thermostaat thermostaat);
}
