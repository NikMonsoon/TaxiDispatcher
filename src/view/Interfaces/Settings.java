package view.Interfaces;

import model.ClientImpl;
import model.database.DaoFactoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    private JPanel mainPanel;
    private JLabel lbLogin;
    private JLabel lbPassword;
    private JLabel lbBirthday;
    private JTextField tfLogin;
    private JTextField tfPassword;
    private JTextField tfBirthday;
    private JButton btCancel;
    private JButton btSave;
    private JTextField tfPhoneNumber;
    private JLabel lbPhoneNumber;
    private JLabel lbAgainPassword;
    private JTextField tfAgainPassword;
    private JLabel lbName;
    private JTextField tfName;
    private JButton buttonOK;
    private JButton buttonCancel;

    ClientImpl currentClient;

    public Settings(ClientImpl currentClient) {
        this();
        this.currentClient = currentClient;

        //Заполняем поля данныйми текущего пользователя
        tfLogin.setText(currentClient.getLogin());
        tfPassword.setText(currentClient.getPass());
        tfAgainPassword.setText(currentClient.getPass());
        tfName.setText(currentClient.getName());
        tfBirthday.setText(currentClient.getBornDate());
        tfPhoneNumber.setText(currentClient.getPhoneNumber());
    }

    public Settings() {
        super("Settings");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setResizable(false);
        setContentPane(mainPanel);
        setLocation((int) screenSize.getWidth() / 2 - (int) getPreferredSize().getWidth() / 2,
                (int) screenSize.getHeight() / 2 - (int) getPreferredSize().getHeight() / 2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        btSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OnSaveButtonClicked(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OnCancelButtonClicked(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void OnSaveButtonClicked(ActionEvent e){
        DaoFactoryImpl dfi = new DaoFactoryImpl();
        try {
            if (tfPassword.getText().equals(tfAgainPassword.getText()) == true) {
                if (tfLogin.getText() != null && tfPassword.getText() != null && tfName.getText() != null && tfBirthday.getText() != null && tfPhoneNumber.getText() != null) {
                    if (tfLogin.getText().equals(currentClient.getLogin()) || dfi.client().getByLogin(tfLogin.getText()) == null) {
                        //Удаляем текущую версию клиента
                        dfi.client().delete(currentClient.getId());
                        //Создаём нового клиента
                        dfi.client().change(currentClient.getId(), tfLogin.getText(), tfPassword.getText(), tfName.getText(), tfBirthday.getText(), tfPhoneNumber.getText());
                        currentClient = dfi.client().getByLogin(tfLogin.getText());
                        Personal_Area PersonalAreaFrame = new Personal_Area(currentClient);
                        PersonalAreaFrame.setVisible(true);
                        setVisible(false);
                    } else {
                        tfLogin.setText("Such Login is in use");
                    }
                } else {
                    tfLogin.setText("Empty fields");
                }
            } else {
                tfAgainPassword.setText("Wrong Password");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void OnCancelButtonClicked(ActionEvent e) throws Exception {
        Personal_Area PersonalAreaFrame = new Personal_Area(currentClient);
        PersonalAreaFrame.setVisible(true);
        PersonalAreaFrame.UpdateTrainHistory();
        setVisible(false);
    }
}
