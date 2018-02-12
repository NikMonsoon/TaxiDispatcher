package model;

public class ClientImpl implements Client{

    //Обычный класс клиента для описания его структуры и работы с данными, полученными из базы

    private String id;
    private String login;
    private String pass;
    private String name;
    private String bornDate;
    private String phoneNumber;

    public ClientImpl(){ }

    public ClientImpl(String id, String login, String pass, String name, String bornDate, String phoneNumber){

        this.id = id;
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPass() {
        return pass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBornDate() {
        return bornDate;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
