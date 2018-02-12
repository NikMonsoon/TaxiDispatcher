package model.database.xml;

public class XmlDaoFactoryImpl implements XmlDaoFactory{

    @Override
    public XmlClientDao client() {
        return new XmlClientDao();
    }

    @Override
    public XmlCallDao call() {
        return new XmlCallDao();
    }

    @Override
    public XmlTaxiDao taxi(){
        return new XmlTaxiDao();
    }
}
