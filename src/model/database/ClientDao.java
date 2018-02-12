package model.database;

import model.ClientImpl;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface ClientDao{

    ClientImpl getByID(String id) throws IOException, SAXException, ParserConfigurationException;

    ClientImpl getByLogin(String login) throws ParserConfigurationException, IOException, SAXException;

    List<ClientImpl> getByName(String name) throws ParserConfigurationException, IOException, SAXException;

    List<ClientImpl> getByBornDate(String bornDate) throws ParserConfigurationException, IOException, SAXException;

    ClientImpl getByPhoneNumber(String phoneNumber) throws ParserConfigurationException, IOException, SAXException;

    void doCall(String clientId, String taxiId, String startPoint, String destination) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    void create(String login, String pass, String name, String bornDate, String phoneNumber) throws IOException, SAXException, ParserConfigurationException, TransformerException;

    void change(String id, String login, String pass, String name, String bornDate, String phoneNumber) throws IOException, SAXException, ParserConfigurationException, TransformerException;

    void delete(String id) throws ParserConfigurationException, IOException, SAXException, TransformerException;

    List<ClientImpl> getAll() throws ParserConfigurationException, IOException, SAXException;

}
