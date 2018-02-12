package model.database;

import model.TaxiImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface TaxiDao {

    TaxiImpl getByID(String id) throws IOException, SAXException, ParserConfigurationException;

    List<TaxiImpl> getByDriverName(String driverName) throws ParserConfigurationException, IOException, SAXException;

    TaxiImpl getByCarNumber(String carNumber) throws IOException, SAXException, ParserConfigurationException;

    List<TaxiImpl> getByCarModel(String carModel) throws IOException, SAXException, ParserConfigurationException;

    void create(String driverName, String carNumber, String carModel) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    void update(TaxiImpl taxi);

    void delete(String id) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    List<TaxiImpl> getAll() throws IOException, SAXException, ParserConfigurationException;

    String getLeastLoadId();

}
