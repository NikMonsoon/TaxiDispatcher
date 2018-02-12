package model.database.sql;

import java.sql.DriverManager;
import java.util.Locale;

public class SqlDaoFactoryImpl implements SqlDaoFactory{

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String name = "artiom";
    private String password = "artiom";

    @Override
    public boolean getConnecting(){
        try {
            Locale.setDefault(Locale.ENGLISH);
            DriverManager.getConnection(url, name, password);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String getConnectException() {
        try {
            Locale.setDefault(Locale.ENGLISH);
            DriverManager.getConnection(url, name, password);
            return "Connected by second try";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public SqlClientDao client() {
        return new SqlClientDao();
    }

    @Override
    public SqlCallDao call() {
        return new SqlCallDao();
    }

    @Override
    public SqlTaxiDao taxi(){
        return new SqlTaxiDao();
    }
}
