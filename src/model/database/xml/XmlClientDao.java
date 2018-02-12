package model.database.xml;

import model.ClientImpl;
import model.database.ClientDao;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class XmlClientDao implements ClientDao {

    @Override
    public ClientImpl getByID(String id) throws IOException, SAXException, ParserConfigurationException {
        ClientImpl client = new ClientImpl();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();

        for (int i = 0; i < group.getLength(); i++) {
            Node TaxiDispatcher = group.item(i);
            if (TaxiDispatcher.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) TaxiDispatcher;
                if (eElement.getChildNodes().toString().equals("[client: null]")) {
                    if (eElement.getAttribute("ID").equals(id)) {
                        client.setId(eElement.getAttribute("ID"));
                        client.setLogin(eElement.getAttribute("Login"));
                        client.setPass(eElement.getAttribute("Pass"));
                        client.setName(eElement.getAttribute("Name"));
                        client.setBornDate(eElement.getAttribute("BornDate"));
                        client.setPhoneNumber(eElement.getAttribute("PhoneNumber"));
                    }
                }
            }
        }
        return client;
    }

    @Override
    public ClientImpl getByLogin(String login) throws ParserConfigurationException, IOException, SAXException {
        ClientImpl client = new ClientImpl();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();
        for (int i = 0; i < group.getLength(); i++) {
            Node TaxiDispatcher = group.item(i);
            if (TaxiDispatcher.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) TaxiDispatcher;
                if (eElement.getAttribute("Login").equals(login)) {
                    client.setId(eElement.getAttribute("ID"));
                    client.setLogin(eElement.getAttribute("Login"));
                    client.setPass(eElement.getAttribute("Pass"));
                    client.setName(eElement.getAttribute("Name"));
                    client.setBornDate(eElement.getAttribute("BornDate"));
                    client.setPhoneNumber(eElement.getAttribute("PhoneNumber"));
                }
            }
        }
        return client;
    }

    @Override
    public List<ClientImpl> getByName(String name) throws ParserConfigurationException, IOException, SAXException {
        ClientImpl client = new ClientImpl();
        List<ClientImpl> clients = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();
        for (int i = 0; i < group.getLength(); i++) {
            Node TaxiDispatcher = group.item(i);
            if (TaxiDispatcher.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) TaxiDispatcher;
                if (eElement.getAttribute("Name").equals(name)) {
                    client.setId(eElement.getAttribute("ID"));
                    client.setLogin(eElement.getAttribute("Login"));
                    client.setPass(eElement.getAttribute("Pass"));
                    client.setName(eElement.getAttribute("Name"));
                    client.setBornDate(eElement.getAttribute("BornDate"));
                    client.setPhoneNumber(eElement.getAttribute("PhoneNumber"));
                    clients.add(client);
                }
            }
        }
        return clients;
    }

    @Override
    public List<ClientImpl> getByBornDate(String bornDate) throws ParserConfigurationException, IOException, SAXException {
        ClientImpl client = new ClientImpl();
        List<ClientImpl> clients = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();
        for (int i = 0; i < group.getLength(); i++) {
            Node TaxiDispatcher = group.item(i);
            if (TaxiDispatcher.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) TaxiDispatcher;
                if (eElement.getAttribute("BornDate").equals(bornDate)) {
                    client.setId(eElement.getAttribute("ID"));
                    client.setLogin(eElement.getAttribute("Login"));
                    client.setPass(eElement.getAttribute("Pass"));
                    client.setName(eElement.getAttribute("Name"));
                    client.setBornDate(eElement.getAttribute("BornDate"));
                    client.setPhoneNumber(eElement.getAttribute("PhoneNumber"));
                    clients.add(client);
                }
            }
        }
        return clients;
    }

    @Override
    public ClientImpl getByPhoneNumber(String phoneNumber) throws IOException, SAXException, ParserConfigurationException {
        ClientImpl client = new ClientImpl();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();

        for (int i = 0; i < group.getLength(); i++) {
            Node TaxiDispatcher = group.item(i);
            if (TaxiDispatcher.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) TaxiDispatcher;
                if (eElement.getChildNodes().toString().equals("[client: null]")) {
                    if (eElement.getAttribute("PhoneNumber").equals(phoneNumber)) {
                        client.setId(eElement.getAttribute("ID"));
                        client.setLogin(eElement.getAttribute("Login"));
                        client.setPass(eElement.getAttribute("Pass"));
                        client.setName(eElement.getAttribute("Name"));
                        client.setBornDate(eElement.getAttribute("BornDate"));
                        client.setPhoneNumber(eElement.getAttribute("PhoneNumber"));
                    }
                }
            }
        }
        return client;
    }

    @Override
    public void doCall(String clientId, String taxiId, String startPoint, String destination) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("dataBase.xml");

        Element call = document.createElement("call");
        document.getFirstChild().appendChild(call);
        call.setAttribute("ID", UUID.randomUUID().toString());
        call.setAttribute("Date", formatForDateNow.format(dateNow));
        call.setAttribute("ClientId", clientId);
        call.setAttribute("TaxiId", taxiId);
        call.setAttribute("StartPoint", startPoint);
        call.setAttribute("Destination", destination);

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = new FileOutputStream("dataBase.xml");
        StreamResult result = new StreamResult(fos);
        tr.transform(source, result);
    }

    @Override
    public void create(String login, String pass, String name, String bornDate, String phoneNumber) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("dataBase.xml");

        Element client = document.createElement("client");
        document.getFirstChild().appendChild(client);
        client.setAttribute("ID", UUID.randomUUID().toString());
        client.setAttribute("Login", login);
        client.setAttribute("Pass", pass);
        client.setAttribute("Name", name);
        client.setAttribute("BornDate", bornDate);
        client.setAttribute("PhoneNumber", phoneNumber);

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = new FileOutputStream("dataBase.xml");
        StreamResult result = new StreamResult(fos);
        tr.transform(source, result);
    }

    @Override
    public void change(String id, String login, String pass, String name, String bornDate, String phoneNumber) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("dataBase.xml");

        Element client = document.createElement("client");
        document.getFirstChild().appendChild(client);
        client.setAttribute("ID", id);
        client.setAttribute("Login", login);
        client.setAttribute("Pass", pass);
        client.setAttribute("Name", name);
        client.setAttribute("BornDate", bornDate);
        client.setAttribute("PhoneNumber", phoneNumber);

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = new FileOutputStream("dataBase.xml");
        StreamResult result = new StreamResult(fos);
        tr.transform(source, result);
    }

    @Override
    public void delete(String id) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();

        for (int i = 0; i < group.getLength(); i++) {
            Node TaxiDispatcher = group.item(i);
            if (TaxiDispatcher.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) TaxiDispatcher;
                if (eElement.getChildNodes().toString().equals("[client: null]")) {
                    if (eElement.getAttribute("ID").equals(id)) {
                        document.getFirstChild().removeChild(group.item(i));

                        Transformer tr = TransformerFactory.newInstance().newTransformer();
                        DOMSource source = new DOMSource(document);
                        FileOutputStream fos = new FileOutputStream("dataBase.xml");
                        StreamResult result = new StreamResult(fos);
                        tr.transform(source, result);
                    }
                }
            }
        }
    }

    @Override
    public List<ClientImpl> getAll() throws ParserConfigurationException, IOException, SAXException {
        ClientImpl client = new ClientImpl();
        List<ClientImpl> clients = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();
        for (int i = 0; i < group.getLength(); i++) {
            Node TaxiDispatcher = group.item(i);
            if (TaxiDispatcher.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) TaxiDispatcher;
                if (eElement.getChildNodes().toString().equals("[client: null]")) {
                    client.setId(eElement.getAttribute("ID"));
                    client.setLogin(eElement.getAttribute("Login"));
                    client.setPass(eElement.getAttribute("Pass"));
                    client.setName(eElement.getAttribute("Name"));
                    client.setBornDate(eElement.getAttribute("BornDate"));
                    client.setPhoneNumber(eElement.getAttribute("PhoneNumber"));
                    clients.add(client);
                }
            }
        }
        return clients;
    }
}
