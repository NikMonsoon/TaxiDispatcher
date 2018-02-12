package model.database.xml;

import model.TaxiImpl;
import model.database.TaxiDao;
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
import java.util.UUID;

public class XmlTaxiDao implements TaxiDao {

    @Override
    public TaxiImpl getByID(String id) throws IOException, SAXException, ParserConfigurationException {
        TaxiImpl taxi = new TaxiImpl();

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
                if (eElement.getChildNodes().toString().equals("[taxi: null]")) {
                    if (eElement.getAttribute("ID").equals(id)) {
                        taxi.setId(eElement.getAttribute("ID"));
                        taxi.setDriverName(eElement.getAttribute("DriverName"));
                        taxi.setCarNumber(eElement.getAttribute("CarNumber"));
                        taxi.setCarModel(eElement.getAttribute("CarModel"));
                    }
                }
            }
        }
        return taxi;
    }

    @Override
    public List<TaxiImpl> getByDriverName(String driverName) throws ParserConfigurationException, IOException, SAXException {
        TaxiImpl taxi = new TaxiImpl();
        List<TaxiImpl> taxis = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[taxi: null]")) {
                    if (eElement.getAttribute("DriverName").equals(driverName)) {
                        taxi.setId(eElement.getAttribute("ID"));
                        taxi.setDriverName(eElement.getAttribute("DriverName"));
                        taxi.setCarNumber(eElement.getAttribute("CarNumber"));
                        taxi.setCarModel(eElement.getAttribute("CarModel"));
                        taxis.add(taxi);
                    }
                }
            }
        }
        return taxis;
    }

    @Override
    public TaxiImpl getByCarNumber(String carNumber) throws IOException, SAXException, ParserConfigurationException {
        TaxiImpl taxi = new TaxiImpl();

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
                if (eElement.getChildNodes().toString().equals("[taxi: null]")) {
                    if (eElement.getAttribute("CarNumber").equals(carNumber)) {
                        taxi.setId(eElement.getAttribute("ID"));
                        taxi.setDriverName(eElement.getAttribute("DriverName"));
                        taxi.setCarNumber(eElement.getAttribute("CarNumber"));
                        taxi.setCarModel(eElement.getAttribute("CarModel"));
                    }
                }
            }
        }
        return taxi;
    }

    @Override
    public List<TaxiImpl> getByCarModel(String carModel) throws ParserConfigurationException, IOException, SAXException {
        TaxiImpl taxi = new TaxiImpl();
        List<TaxiImpl> taxis = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[taxi: null]")) {
                    if (eElement.getAttribute("CarDriver").equals(carModel)) {
                        taxi.setId(eElement.getAttribute("ID"));
                        taxi.setDriverName(eElement.getAttribute("DriverName"));
                        taxi.setCarNumber(eElement.getAttribute("CarNumber"));
                        taxi.setCarModel(eElement.getAttribute("CarModel"));
                        taxis.add(taxi);
                    }
                }
            }
        }
        return taxis;
    }

    @Override
    public void create(String driverName, String carNumber, String carModel) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse("dataBase.xml");

        Element taxi = document.createElement("taxi");
        document.getFirstChild().appendChild(taxi);
        taxi.setAttribute("ID", UUID.randomUUID().toString());
        taxi.setAttribute("DriverName", driverName);
        taxi.setAttribute("CarNumber", carNumber);
        taxi.setAttribute("CarModel", carModel);

        Transformer tr = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = new FileOutputStream("dataBase.xml");
        StreamResult result = new StreamResult(fos);
        tr.transform(source, result);
    }

    @Override
    public void update(TaxiImpl book) {

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
                if (eElement.getChildNodes().toString().equals("[taxi: null]")) {
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
    public List<TaxiImpl> getAll() throws IOException, SAXException, ParserConfigurationException {
        TaxiImpl taxi = new TaxiImpl();
        List<TaxiImpl> taxis = new ArrayList<>();

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
                if (eElement.getChildNodes().toString().equals("[book: null]")) {
                    taxi.setId(eElement.getAttribute("ID"));
                    taxi.setDriverName(eElement.getAttribute("DriverName"));
                    taxi.setCarNumber(eElement.getAttribute("CarNumber"));
                    taxi.setCarModel(eElement.getAttribute("CarModel"));
                    taxis.add(taxi);
                }
            }
        }
        return taxis;
    }

    @Override
    public String getLeastLoadId() {
        return null;
    }
}
