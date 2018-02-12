package model.database.sql;

import model.TaxiImpl;
import model.database.DaoFactory;
import model.database.DaoFactoryImpl;
import model.database.TaxiDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class SqlTaxiDao implements TaxiDao {

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String name = "artiom";
    private String password = "artiom";
    private static String driver = "oracle.jdbc.driver.OracleDriver";

    private DaoFactory daoFactory = new DaoFactoryImpl();

    private static Connection connection = null;

    SqlTaxiDao(){
        try {
            Locale.setDefault(Locale.ENGLISH);
            Class.forName(driver);
            connection = DriverManager.getConnection(url, name, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public TaxiImpl getByID(String id) {
        TaxiImpl taxi = null;
        String sql = "SELECT * FROM Taxi WHERE ID = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next() == true) {
                taxi = new TaxiImpl();
                taxi.setId(result.getString("ID"));
                taxi.setDriverName(result.getString("DriverName"));
                taxi.setCarNumber(result.getString("CarNumber"));
                taxi.setCarModel(result.getString("CarModel"));
            }
            connection.close();
            return taxi;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TaxiImpl> getByDriverName(String driverName) {
        TaxiImpl taxi;
        List<TaxiImpl> taxis = new ArrayList<>();
        String sql = "SELECT * FROM Taxi WHERE DriverName = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, driverName);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                taxi = new TaxiImpl();
                taxi.setId(result.getString("ID"));
                taxi.setDriverName(result.getString("DriverName"));
                taxi.setCarNumber(result.getString("CarNumber"));
                taxi.setCarModel(result.getString("CarModel"));
                taxis.add(taxi);
            }
            connection.close();
            return taxis;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getLeastLoadId() {
        String taxi = null;
        String sql = "Select TaxiId from (Select TaxiId, count(Id) as callsCount " +
                "From Call " +
                "Group by TAXIID " +
                "Order by callsCount ASC) " +
                "where rownum <=1";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            if (result.next() == true) {
                taxi = result.getString(1);
            }
            connection.close();
            return taxi;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TaxiImpl getByCarNumber(String carNumber) {
        TaxiImpl taxi = null;
        String sql = "SELECT * FROM Taxi WHERE CarNumber = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carNumber);

            ResultSet result = statement.executeQuery();

            if (result.next() == true) {
                taxi = new TaxiImpl();
                taxi.setId(result.getString("ID"));
                taxi.setDriverName(result.getString("DriverName"));
                taxi.setCarNumber(result.getString("CarNumber"));
                taxi.setCarModel(result.getString("CarModel"));
            }
            connection.close();
            return taxi;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TaxiImpl> getByCarModel(String carModel) {
        TaxiImpl taxi;
        List<TaxiImpl> taxis = new ArrayList<>();
        String sql = "SELECT * FROM Taxi WHERE CarModel = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, carModel);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                taxi = new TaxiImpl();
                taxi.setId(result.getString("ID"));
                taxi.setDriverName(result.getString("DriverName"));
                taxi.setCarNumber(result.getString("CarNumber"));
                taxi.setCarModel(result.getString("CarModel"));
                taxis.add(taxi);
            }
            connection.close();
            return taxis;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(String driverName, String carNumber, String carModel) {
        String sql = "INSERT INTO Taxi VALUES (?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, driverName);
            statement.setString(3, carNumber);
            statement.setString(4, carModel);
            statement.executeUpdate();
            statement.close();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void update(TaxiImpl taxi) {

    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Taxi WHERE ID = ?";
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.executeUpdate();
            statement.close();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<TaxiImpl> getAll() {
        TaxiImpl taxi;
        List<TaxiImpl> taxis = new ArrayList<>();
        String sql = "SELECT * FROM Taxi";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                taxi = new TaxiImpl();
                taxi.setId(result.getString("ID"));
                taxi.setDriverName(result.getString("DriverName"));
                taxi.setCarNumber(result.getString("CarNumber"));
                taxi.setCarModel(result.getString("CarModel"));
                taxis.add(taxi);
            }
            connection.close();
            return taxis;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
