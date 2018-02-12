package model.database.sql;

import model.ClientImpl;
import model.database.ClientDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class SqlClientDao implements ClientDao {

    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String name = "artiom";
    private String password = "artiom";
    private static String driver = "oracle.jdbc.driver.OracleDriver";

    private static Connection connection = null;

    public SqlClientDao(){
        try {
            Locale.setDefault(Locale.ENGLISH);
            Class.forName(driver);
            connection = DriverManager.getConnection(url, name, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ClientImpl getByID(String id){
        ClientImpl client = null;
        String sql = "SELECT * FROM Client WHERE ID = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next() == true) {
                client = new ClientImpl();
                client.setId(result.getString("ID"));
                client.setLogin(result.getString("Login"));
                client.setPass(result.getString("Password"));
                client.setName(result.getString("Name"));
                client.setBornDate(result.getString("BornDate"));
                client.setPhoneNumber(result.getString("PhoneNumber"));
            }
            connection.close();
            return client;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClientImpl getByLogin(String login) {
        ClientImpl client = null;
        String sql = "SELECT * FROM Client WHERE Login = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                client = new ClientImpl();
                client.setId(result.getString("ID"));
                client.setLogin(result.getString("Login"));
                client.setPass(result.getString("Password"));
                client.setName(result.getString("Name"));
                client.setBornDate(result.getString("BornDate"));
                client.setPhoneNumber(result.getString("PhoneNumber"));
            }
            connection.close();
            return client;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClientImpl> getByName(String name) {
        ClientImpl client = new ClientImpl();
        List<ClientImpl> clients = new ArrayList<>();
        String sql = "SELECT * FROM Call WHERE Name = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                client.setId(result.getString("ID"));
                client.setLogin(result.getString("Login"));
                client.setPass(result.getString("Password"));
                client.setName(result.getString("Name"));
                client.setBornDate(result.getString("BornDate"));
                client.setPhoneNumber(result.getString("PhoneNumber"));
            }
            connection.close();
            return clients;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ClientImpl> getByBornDate(String bornDate) {
        ClientImpl client = new ClientImpl();
        List<ClientImpl> clients = new ArrayList<>();
        String sql = "SELECT * FROM Call WHERE BornDate = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bornDate);

            ResultSet result = statement.executeQuery();
            while (result.next() == true) {
                client.setId(result.getString("ID"));
                client.setLogin(result.getString("Login"));
                client.setPass(result.getString("Password"));
                client.setName(result.getString("Name"));
                client.setBornDate(result.getString("BornDate"));
                client.setPhoneNumber(result.getString("PhoneNumber"));
            }
            connection.close();
            return clients;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ClientImpl getByPhoneNumber(String phoneNumber){
        ClientImpl client = new ClientImpl();
        String sql = "SELECT * FROM Client WHERE PhoneNumber = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, phoneNumber);

            ResultSet result = statement.executeQuery();

            while (result.next() == true) {
                client.setId(result.getString("ID"));
                client.setLogin(result.getString("Login"));
                client.setPass(result.getString("Password"));
                client.setName(result.getString("Name"));
                client.setBornDate(result.getString("BornDate"));
                client.setPhoneNumber(result.getString("PhoneNumber"));
            }
            connection.close();
            return client;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void doCall(String clientId, String taxiId, String startPoint, String destination) {
        java.util.Date dateNow = new java.util.Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        String sql = "INSERT INTO Call VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, formatForDateNow.format(dateNow));
            statement.setString(3, clientId);
            statement.setString(4, taxiId);
            statement.setString(5, startPoint);
            statement.setString(6, destination);
            statement.executeUpdate();
            statement.close();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void create(String login, String pass, String name, String bornDate, String phoneNumber) {
        String sql = "INSERT INTO Client VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, login);
            statement.setString(3, pass);
            statement.setString(4, name);
            statement.setString(5, bornDate);
            statement.setString(6, phoneNumber);
            statement.executeUpdate();
            statement.close();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void change(String id, String login, String pass, String name, String bornDate, String phoneNumber) {
        String sql = "INSERT INTO Client VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, login);
            statement.setString(3, pass);
            statement.setString(4, name);
            statement.setString(5, bornDate);
            statement.setString(6, phoneNumber);
            statement.executeUpdate();
            statement.close();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Client WHERE ID = ?";
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
    public List<ClientImpl> getAll(){
        ClientImpl client = new ClientImpl();
        List<ClientImpl> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                client.setId(result.getString("ID"));
                client.setLogin(result.getString("Login"));
                client.setPass(result.getString("Password"));
                client.setName(result.getString("Name"));
                client.setBornDate(result.getString("BornDate"));
                client.setPhoneNumber(result.getString("PhoneNumber"));
                clients.add(client);
            }
            connection.close();
            return clients;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
