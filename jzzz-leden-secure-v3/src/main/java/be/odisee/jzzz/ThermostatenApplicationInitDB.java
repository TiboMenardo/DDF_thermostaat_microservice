package be.odisee.jzzz;

import be.odisee.jzzz.dao.ThermostaatRepository;
import be.odisee.jzzz.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class ThermostatenApplicationInitDB implements CommandLineRunner{
    @Autowired
    ThermostaatRepository thermostaatRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Thermostaat> thermostaten = Arrays.asList(
                new Thermostaat(1, 1, "2022-01-01", "2022-03-15", "Leverancier1", "Adres1"),
                new Thermostaat(2,2, "2022-02-01", "2022-04-15", "Leverancier2", "Adres2"),
                new Thermostaat(3, 2, "2022-03-01", "2022-05-15", "Leverancier3", "Adres3"),
                new Thermostaat(1, 1, "2022-01-01", "2022-03-15", "Leverancier1", "Adres1"),
                new Thermostaat(2, 2, "2022-02-01", "2022-04-15", "Leverancier2", "Adres2"),
                new Thermostaat(3, 2, "2022-03-01", "2022-05-15", "Leverancier3", "Adres3"),
                new Thermostaat(4, 1, "2022-01-01", "2022-03-15", "Leverancier4", "Adres4"),
                new Thermostaat(5, 3, "2022-02-01", "2022-04-15", "Leverancier5", "Adres5"),
                new Thermostaat(6, 2, "2022-03-01", "2022-05-15", "Leverancier6", "Adres6"),
                new Thermostaat(7, 1, "2022-01-01", "2022-03-15", "Leverancier7", "Adres7"),
                new Thermostaat(8, 2, "2022-02-01", "2022-04-15", "Leverancier8", "Adres8"),
                new Thermostaat(9, 3, "2022-03-01", "2022-05-15", "Leverancier9", "Adres9"),
                new Thermostaat(10, 1, "2022-01-01", "2022-03-15", "Leverancier10", "Adres10")
        );

        thermostaatRepository.saveAll(thermostaten);
    }
}
