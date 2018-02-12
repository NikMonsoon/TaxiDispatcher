package model;

public interface Call {

    void setId(String id);

    void setDate(String date);

    void setClientId(String clientId);

    void setTaxiId(String driverId);

    void setStartPoint(String startPoint);

    void setDestination(String destination);

    String getId();

    String getDate();

    String getClientId();

    String getTaxiId();

    String getStartPoint();

    String getDestination();

}
