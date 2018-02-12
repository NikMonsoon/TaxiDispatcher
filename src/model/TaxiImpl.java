package model;

public class TaxiImpl implements Taxi {

    private String id;
    private String driverName;
    private String carNumber;
    private String carModel;

    public TaxiImpl(){}

    public TaxiImpl(String id, String name){
        this.id = id;
        this.driverName = driverName;
        this.carNumber = carNumber;
        this.carModel = carModel;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public String getCarNumber() {
        return carNumber;
    }

    @Override
    public String getCarModel() {
        return carModel;
    }
}
