package model.database.sql;

import model.CallImpl;
import model.database.CallDao;
import model.database.DaoFactory;
import model.database.DaoFactoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SqlCallDao implements CallDao {

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String name = "artiom";
    private String password = "artiom";
    private static String driver = "oracle.jdbc.driver.OracleDriver";

    private DaoFactory daoFactory = new DaoFactoryImpl();

    private static Connection connection = null;

    SqlCallDao(){
        try {
            Locale.setDefault(Locale.ENGLISH);
            Class.forName(driver);
            connection = DriverManager.getConnection(url, name, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public CallImpl getByID(String id) {
        CallImpl call = null;
        String sql = "SELECT * FROM Call WHERE ID = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next() == true) {
                call = new CallImpl();
                call.setId(result.getString("ID"));
                call.setDate(result.getString("TravelDate"));
                call.setClientId(result.getString("ClientId"));
                call.setTaxiId(result.getString("TaxiId"));
                call.setStartPoint(result.getString("StartPoint"));
                call.setDestination(result.getString("Destination"));
            }
            connection.close();
            return call;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CallImpl> getByDate(String date) {
        CallImpl call;
        List<CallImpl> calls = new ArrayList<>();
        String sql = "SELECT * FROM Call WHERE Date = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                call = new CallImpl();
                call.setId(result.getString("ID"));
                call.setDate(result.getString("TravelDate"));
                call.setClientId(result.getString("ClientId"));
                call.setTaxiId(result.getString("TaxiId"));
                call.setStartPoint(result.getString("StartPoint"));
                call.setDestination(result.getString("Destination"));
                calls.add(call);
            }
            connection.close();
            return calls;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CallImpl> getByClientId(String clientId) {
        CallImpl call;
        List<CallImpl> calls = new ArrayList<>();
        String sql = "SELECT * FROM Call WHERE ClientId = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, clientId);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                call = new CallImpl();
                call.setId(result.getString("ID"));
                call.setDate(result.getString("TravelDate"));
                call.setClientId(result.getString("ClientId"));
                call.setTaxiId(result.getString("TaxiId"));
                call.setStartPoint(result.getString("StartPoint"));
                call.setDestination(result.getString("Destination"));
                calls.add(call);
            }
            connection.close();
            return calls;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CallImpl> getByTaxiId(String taxiId) {
        CallImpl call;
        List<CallImpl> calls = new ArrayList<>();
        String sql = "SELECT * FROM Call WHERE TaxiId = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, taxiId);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                call = new CallImpl();
                call.setId(result.getString("ID"));
                call.setDate(result.getString("TravelDate"));
                call.setClientId(result.getString("ClientId"));
                call.setTaxiId(result.getString("TaxiId"));
                call.setStartPoint(result.getString("StartPoint"));
                call.setDestination(result.getString("Destination"));
                calls.add(call);
            }
            connection.close();
            return calls;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CallImpl> getByStartPoint(String startPoint) {
        CallImpl call;
        List<CallImpl> calls = new ArrayList<>();
        String sql = "SELECT * FROM Call WHERE StartPoint = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, startPoint);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                call = new CallImpl();
                call.setId(result.getString("ID"));
                call.setDate(result.getString("TravelDate"));
                call.setClientId(result.getString("ClientId"));
                call.setTaxiId(result.getString("TaxiId"));
                call.setStartPoint(result.getString("StartPoint"));
                call.setDestination(result.getString("Destination"));
                calls.add(call);
            }
            connection.close();
            return calls;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CallImpl> getByDestination(String destination) {
        CallImpl call;
        List<CallImpl> calls = new ArrayList<>();
        String sql = "SELECT * FROM Call WHERE Destination = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, destination);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                call = new CallImpl();
                call.setId(result.getString("ID"));
                call.setDate(result.getString("TravelDate"));
                call.setClientId(result.getString("ClientId"));
                call.setTaxiId(result.getString("TaxiId"));
                call.setStartPoint(result.getString("StartPoint"));
                call.setDestination(result.getString("Destination"));
                calls.add(call);
            }
            connection.close();
            return calls;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(CallImpl call) {

    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Call WHERE ID = ?";

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
    public List<CallImpl> getAll() {
        CallImpl call;
        List<CallImpl> calls = new ArrayList<>();
        String sql = "SELECT * FROM Call";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                call = new CallImpl();
                call.setId(result.getString("ID"));
                call.setDate(result.getString("TravelDate"));
                call.setClientId(result.getString("ClientId"));
                call.setTaxiId(result.getString("TaxiId"));
                call.setStartPoint(result.getString("StartPoint"));
                call.setDestination(result.getString("Destination"));
                calls.add(call);
            }
            connection.close();
            return calls;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
