package be.odisee.jzzz.service;

import be.odisee.jzzz.domain.Thermostaat;

import java.util.List;

public interface ThermostaatService {
    public List<Thermostaat> GetAllThermostaten();
    public Thermostaat getThermostaatFromID(int id);
    public List<Thermostaat> getThermostatenfromKlantID(int id);
    public void deleteThermostaat(int id);
    public boolean updateThermostaat(int id, Thermostaat thermostaatData);
    public void addThermostaat(Thermostaat thermostaat);
}
