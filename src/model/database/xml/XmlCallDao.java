package model.database.xml;

import model.CallImpl;
import model.database.CallDao;
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
import java.util.ArrayList;
import java.util.List;

public class XmlCallDao implements CallDao {

    @Override
    public CallImpl getByID(String id) throws SAXException, ParserConfigurationException, IOException {
        CallImpl call = new CallImpl();

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
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    if (eElement.getAttribute("ID").equals(id)) {
                        call.setId(eElement.getAttribute("ID"));
                        call.setDate(eElement.getAttribute("TravelDate"));
                        call.setClientId(eElement.getAttribute("ClientId"));
                        call.setTaxiId(eElement.getAttribute("TaxiId"));
                        call.setStartPoint(eElement.getAttribute("StartPoint"));
                        call.setDestination(eElement.getAttribute("Destination"));
                    }
                }
            }
        }
        return call;
    }

    @Override
    public List<CallImpl> getByDate(String date) throws IOException, SAXException, ParserConfigurationException {
        CallImpl call = new CallImpl();
        List<CallImpl> calls = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    if (eElement.getAttribute("Date").equals(date)) {
                        call.setId(eElement.getAttribute("ID"));
                        call.setDate(eElement.getAttribute("TravelDate"));
                        call.setClientId(eElement.getAttribute("ClientId"));
                        call.setTaxiId(eElement.getAttribute("TaxiId"));
                        call.setStartPoint(eElement.getAttribute("StartPoint"));
                        call.setDestination(eElement.getAttribute("Destination"));
                        calls.add(call);
                    }
                }
            }
        }
        return calls;
    }

    @Override
    public List<CallImpl> getByClientId(String clientId) throws IOException, SAXException, ParserConfigurationException {
        CallImpl call = new CallImpl();
        List<CallImpl> calls = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    if (eElement.getAttribute("ClientId").equals(clientId)) {
                        call.setId(eElement.getAttribute("ID"));
                        call.setDate(eElement.getAttribute("TravelDate"));
                        call.setClientId(eElement.getAttribute("ClientId"));
                        call.setTaxiId(eElement.getAttribute("TaxiId"));
                        call.setStartPoint(eElement.getAttribute("StartPoint"));
                        call.setDestination(eElement.getAttribute("Destination"));
                        calls.add(call);
                    }
                }
            }
        }
        return calls;
    }

    @Override
    public List<CallImpl> getByTaxiId(String taxiId) throws IOException, SAXException, ParserConfigurationException {
        CallImpl call = new CallImpl();
        List<CallImpl> calls = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    if (eElement.getAttribute("TaxiId").equals(taxiId)) {
                        call.setId(eElement.getAttribute("ID"));
                        call.setDate(eElement.getAttribute("TravelDate"));
                        call.setClientId(eElement.getAttribute("ClientId"));
                        call.setTaxiId(eElement.getAttribute("TaxiId"));
                        call.setStartPoint(eElement.getAttribute("StartPoint"));
                        call.setDestination(eElement.getAttribute("Destination"));
                        calls.add(call);
                    }
                }
            }
        }
        return calls;
    }

    @Override
    public List<CallImpl> getByStartPoint(String startPoint) throws IOException, SAXException, ParserConfigurationException {
        CallImpl call = new CallImpl();
        List<CallImpl> calls = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    if (eElement.getAttribute("StartPoint").equals(startPoint)) {
                        call.setId(eElement.getAttribute("ID"));
                        call.setDate(eElement.getAttribute("TravelDate"));
                        call.setClientId(eElement.getAttribute("ClientId"));
                        call.setTaxiId(eElement.getAttribute("TaxiId"));
                        call.setStartPoint(eElement.getAttribute("StartPoint"));
                        call.setDestination(eElement.getAttribute("Destination"));
                        calls.add(call);
                    }
                }
            }
        }
        return calls;
    }

    @Override
    public List<CallImpl> getByDestination(String destination) throws IOException, SAXException, ParserConfigurationException {
        CallImpl call = new CallImpl();
        List<CallImpl> calls = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    if (eElement.getAttribute("Destination").equals(destination)) {
                        call.setId(eElement.getAttribute("ID"));
                        call.setDate(eElement.getAttribute("TravelDate"));
                        call.setClientId(eElement.getAttribute("ClientId"));
                        call.setTaxiId(eElement.getAttribute("TaxiId"));
                        call.setStartPoint(eElement.getAttribute("StartPoint"));
                        call.setDestination(eElement.getAttribute("Destination"));
                        calls.add(call);
                    }
                }
            }
        }
        return calls;
    }

    @Override
    public void update(CallImpl call) {

    }

    @Override
    public void delete(String callId) throws ParserConfigurationException, IOException, SAXException, TransformerException {

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
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    if (eElement.getAttribute("ID").equals(callId)) {
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
    public List<CallImpl> getAll() throws ParserConfigurationException, IOException, SAXException {
        CallImpl call = new CallImpl();
        List<CallImpl> calls = new ArrayList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse("dataBase.xml");
        document.getDocumentElement().normalize();

        Node root = document.getDocumentElement();
        NodeList group = root.getChildNodes();

        for (int i = 0; i < group.getLength(); i++) {
            Node library = group.item(i);
            if (library.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) library;
                if (eElement.getChildNodes().toString().equals("[call: null]")) {
                    call.setId(eElement.getAttribute("ID"));
                    call.setDate(eElement.getAttribute("TravelDate"));
                    call.setClientId(eElement.getAttribute("ClientId"));
                    call.setTaxiId(eElement.getAttribute("TaxiId"));
                    call.setStartPoint(eElement.getAttribute("StartPoint"));
                    call.setDestination(eElement.getAttribute("Destination"));
                    calls.add(call);
                }
            }
        }
        return calls;
    }
}
