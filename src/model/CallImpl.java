package model;

public class CallImpl implements Call {

    private String id;
    private String date;
    private String clientId;
    private String taxiId;
    private String startPoint;
    private String destination;

    public CallImpl(){}

    public CallImpl(String id, String date, String clientId, String taxiId, String startPoint, String destination){
        this.id = id;
        this.date = date;
        this.clientId = clientId;
        this.taxiId = taxiId;
        this.startPoint = startPoint;
        this.destination = destination;
    }


    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

    @Override
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public void setDestination(String destination) {
        this.destination = destination;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public String getTaxiId() {
        return taxiId;
    }

    @Override
    public String getStartPoint() {
        return startPoint;
    }

    @Override
    public String getDestination() {
        return destination;
    }

}
