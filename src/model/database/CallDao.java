package model.database;

import model.CallImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface CallDao {

    CallImpl getByID(String id) throws SAXException, ParserConfigurationException, IOException;

    List<CallImpl> getByDate(String date) throws IOException, SAXException, ParserConfigurationException;

    List<CallImpl> getByClientId(String clientId) throws IOException, SAXException, ParserConfigurationException;

    List<CallImpl> getByTaxiId(String taxiId) throws IOException, SAXException, ParserConfigurationException;

    List<CallImpl> getByStartPoint(String startPoint) throws IOException, SAXException, ParserConfigurationException;

    List<CallImpl> getByDestination(String destination) throws IOException, SAXException, ParserConfigurationException;

    void update(CallImpl call);

    void delete(String id) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    List<CallImpl> getAll() throws ParserConfigurationException, IOException, SAXException;

}
