package model.database;

public interface DaoFactory {

    ClientDao client() throws Exception;

    CallDao call() throws Exception;

    TaxiDao taxi() throws Exception;

}
