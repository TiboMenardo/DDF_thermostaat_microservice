package be.odisee.jzzz.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="thermostaten")
@Data
public class Thermostaat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
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
    public Thermostaat(){}
    public Thermostaat(int id, int klantID, String datum_geinstalleerd, String datum_laatste_onderhoud, String leverancier, String adres) {
        this.id = id;
        this.klantID = klantID;
        this.datum_geinstalleerd = datum_geinstalleerd;
        this.datum_laatste_onderhoud = datum_laatste_onderhoud;
        this.leverancier = leverancier;
        this.adres = adres;
    }

    public int getKlantID() {
        return klantID;
    }

    public void setKlantID(int klantID) {
        this.klantID = klantID;
    }

    public String getDatum_geinstalleerd() {
        return datum_geinstalleerd;
    }

    public void setDatum_geinstalleerd(String datum_geinstalleerd) {
        this.datum_geinstalleerd = datum_geinstalleerd;
    }

    public String getDatum_laatste_onderhoud() {
        return datum_laatste_onderhoud;
    }

    public void setDatum_laatste_onderhoud(String datum_laatste_onderhoud) {
        this.datum_laatste_onderhoud = datum_laatste_onderhoud;
    }

    public String getDatum_volgend_onderhoud() {
        return datum_volgend_onderhoud;
    }

    public void setDatum_volgend_onderhoud(String datum_volgend_onderhoud) {
        this.datum_volgend_onderhoud = datum_volgend_onderhoud;
    }

    public String getLeverancier() {
        return leverancier;
    }

    public void setLeverancier(String leverancier) {
        this.leverancier = leverancier;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
