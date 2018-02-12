package model;

public interface Client {

    void setId(String id);

    void setLogin(String login);

    void setPass(String pass);

    void setName(String name);

    void setBornDate(String bornDate);

    void setPhoneNumber(String phoneNumber);

    String getId();

    String getLogin();

    String getPass();

    String getName();

    String getBornDate();

    String getPhoneNumber();
}
