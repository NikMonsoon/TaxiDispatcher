package model.database.xml;

import model.database.CallDao;
import model.database.TaxiDao;
import model.database.ClientDao;
import model.database.DaoFactory;

public interface XmlDaoFactory extends DaoFactory {

    ClientDao client() throws Exception;

    TaxiDao taxi() throws Exception;

    CallDao call() throws Exception;

}
