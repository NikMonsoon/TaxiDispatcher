package model.database;

import model.database.sql.SqlDaoFactoryImpl;
import model.database.xml.XmlDaoFactoryImpl;

public class DaoFactoryImpl implements DaoFactory{

    SqlDaoFactoryImpl sql = new SqlDaoFactoryImpl();
    XmlDaoFactoryImpl xml = new XmlDaoFactoryImpl();

    @Override
    public ClientDao client() throws Exception {
        if(sql.getConnecting()) {
            return sql.client();
        }else{
            return xml.client();
        }
    }

    @Override
    public CallDao call() throws Exception {
        if(sql.getConnecting()) {
            return sql.call();
        }else{
            //должно быть подключение к xml файлу и считывание книги с него
            return xml.call();
        }
    }

    @Override
    public TaxiDao taxi() throws Exception {
        if(sql.getConnecting()) {
            return sql.taxi();
        }else{
            //должно быть подключение к xml файлу и считывание автора с него
            return xml.taxi();
        }
    }
}
