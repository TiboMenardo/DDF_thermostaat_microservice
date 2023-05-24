package be.odisee.ti2.ddf.timesheet.dao;

import be.odisee.ti2.ddf.timesheet.domain.Thermostaat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThermostaatRepository extends JpaRepository<Thermostaat, Integer> {
    List<Thermostaat> findAll();
    Thermostaat findById(int id);
    List<Thermostaat> findAllByKlantID(int id);
    Thermostaat findFirstByOrderByIdDesc();
}
