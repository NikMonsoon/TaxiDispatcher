package view.Interfaces;

import model.ClientImpl;
import model.database.DaoFactoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Created by Artem on 01.12.2017.
 */
public class Registration extends JFrame{
    private JPanel mainPanel;
    private JLabel lbLogin;
    private JLabel lbPassword;
    private JLabel lbBirthday;
    private JTextField tfLogin;
    private JTextField tfPassword;
    private JTextField tfBirthday;
    private JButton btBack;
    private JButton btCreate;
    private JTextField tfPhoneNumber;
    private JLabel lbPhoneNumber;
    private JLabel lbAgainPassword;
    private JTextField tfAgainPassword;
    private JLabel lbName;
    private JTextField tfName;

    ClientImpl currentClient;

    public Registration(){
        super("Registration");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setResizable(false);
        setContentPane(mainPanel);
        setLocation((int) screenSize.getWidth() / 2 - (int) getPreferredSize().getWidth() / 2,
                (int) screenSize.getHeight() / 2 - (int) getPreferredSize().getHeight() / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnBackButtonClicked(e);
            }
        });

        btCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnCreateButtonClicked(e);
            }
        });
    }

    private void OnCreateButtonClicked(ActionEvent e){
        DaoFactoryImpl dfi = new DaoFactoryImpl();
        try {
            if (tfPassword.getText().equals(tfAgainPassword.getText()) == true) {
                if (tfLogin.getText() != null && tfPassword.getText() != null && tfName.getText() != null && tfBirthday.getText() != null && tfPhoneNumber.getText() != null) {
                    if (dfi.client().getByLogin(tfLogin.getText()) == null) {
                        dfi.client().create(tfLogin.getText(), tfPassword.getText(), tfName.getText(), tfBirthday.getText(), tfPhoneNumber.getText());
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

    private void OnBackButtonClicked(ActionEvent e){
        Log_Regist LogFrame = new Log_Regist();
        LogFrame.setVisible(true);
        setVisible(false);
    }
}