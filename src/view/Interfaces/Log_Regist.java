package view.Interfaces;

import control.Main;
import model.ClientImpl;
import model.database.DaoFactoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Created by Artem on 27.11.2017.
 */

public class Log_Regist extends JFrame{

    private JPanel mainPanel;
    private JLabel lbTitle;
    private JTextField tfLogin;
    private JPasswordField pfPassword;
    private JButton btEnter;
    private JButton btCreateAcc;
    private JLabel lbLogPass;
    private JTextField tfPassword;
    private Main listener;

    ClientImpl currentClient;

    public Log_Regist(){
        super("Taxi Dispatcher");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setResizable(false);
        setContentPane(mainPanel);
        setLocation((int) screenSize.getWidth() / 2 - (int) getPreferredSize().getWidth() / 2,
                (int) screenSize.getHeight() / 2 - (int) getPreferredSize().getHeight() / 2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        btCreateAcc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnCreateAccountButtonClicked(e);
            }
        });

        btEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnEnterButtonClicked(e);
            }
        });

    }

    private void OnEnterButtonClicked(ActionEvent e){
        DaoFactoryImpl dfi = new DaoFactoryImpl();
        try {
            ClientImpl client = dfi.client().getByLogin(tfLogin.getText());
            if(client != null) {
                if(client.getPass().equals(tfPassword.getText()) == true) {
                    currentClient = dfi.client().getByLogin(tfLogin.getText());
                    Personal_Area PersonalAreaFrame = new Personal_Area(currentClient);
                    PersonalAreaFrame.setVisible(true);
                    setVisible(false);
                } else {
                    tfLogin.setText("No such Password");
                }
            } else {
                tfLogin.setText("No such Login");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void OnCreateAccountButtonClicked(ActionEvent e){
        Registration RegistrationFrame = new Registration();
        RegistrationFrame.setVisible(true);
        setVisible(false);
    }
}
