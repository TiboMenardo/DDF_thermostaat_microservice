package be.odisee.ti2.ddf.timesheet.errors;

public class ThermostaatNotAuthorizedException extends Exception {

    public ThermostaatNotAuthorizedException(long id) {
        super("Thermostaat id "+id+" not authorized");
    }

}
