package be.odisee.ti2.ddf.timesheet.errors;

public class ThermostaatNotFoundException extends Exception {

    public ThermostaatNotFoundException(long id) {
        super("Thermostaat not found for id "+id);
    }
}
