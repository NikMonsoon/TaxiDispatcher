package model.database.sql;

import model.database.DaoFactory;

public interface SqlDaoFactory extends DaoFactory {

    boolean getConnecting();

    String getConnectException();

    SqlClientDao client();

    SqlCallDao call();

    SqlTaxiDao taxi();

}
