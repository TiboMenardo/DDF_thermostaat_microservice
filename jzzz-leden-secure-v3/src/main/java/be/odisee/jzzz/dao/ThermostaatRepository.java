package be.odisee.jzzz.dao;

import be.odisee.jzzz.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

public interface ThermostaatRepository extends JpaRepository<Thermostaat, Integer> {
    List<Thermostaat> findAll();
    Thermostaat findById(@Param("id")int id);
    List<Thermostaat> findAllByKlantID(@Param("id")int id);
    List<Thermostaat> findAllByKlantIDAndLeverancier(@Param("id")int id, @Param("leverancier")String leverancier);
    List<Thermostaat> findAllByLeverancier(@Param("leverancier")String leverancier);
    Thermostaat findFirstByOrderByIdDesc();
}
