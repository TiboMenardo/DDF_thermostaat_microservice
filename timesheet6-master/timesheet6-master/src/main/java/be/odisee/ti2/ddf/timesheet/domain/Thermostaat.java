package be.odisee.ti2.ddf.timesheet.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="thermostaten")
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
public class Thermostaat {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final int id;
    @Column
    private int klantID;
    @Column
    private String datum_geinstalleerd;
    @Column
    private String datum_laatste_onderhoud;
    @Column
    private String datum_volgend_onderhoud;
    @Column
    private String leverancier;
    @Column
    private String adres;

    public Thermostaat(int id, int klantID, String datum_geinstalleerd, String datum_laatste_onderhoud, String leverancier, String adres) {
        this.id = id;
        this.klantID = klantID;
        this.datum_geinstalleerd = datum_geinstalleerd;
        this.datum_laatste_onderhoud = datum_laatste_onderhoud;
        this.leverancier = leverancier;
        this.adres = adres;
    }

    public Thermostaat(int id, int klantID, String datum_geinstalleerd, String datum_laatste_onderhoud,String datum_volgend_onderhoud, String leverancier, String adres) {
        this.id = id;
        this.klantID = klantID;
        this.datum_geinstalleerd = datum_geinstalleerd;
        this.datum_laatste_onderhoud = datum_laatste_onderhoud;
        this.datum_volgend_onderhoud = datum_volgend_onderhoud;
        this.leverancier = leverancier;
        this.adres = adres;
    }
}
