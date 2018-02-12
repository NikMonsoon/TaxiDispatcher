package view.Interfaces;

import model.CallImpl;
import model.ClientImpl;
import model.database.DaoFactoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/*
 * Created by Artem on 30.11.2017.
 */

public class Personal_Area extends JFrame {
    private JPanel mainPanel;
    private JButton btTrainHistory;
    private JButton btRemoveNote;
    private JButton btMakeCall;
    private JLabel lbNameSurname;
    private JButton btSettings;
    private JLabel lbHello;
    private JTextArea taMyTrainStory;

    ClientImpl currentClient;

    public Personal_Area(ClientImpl currentClient) {
        this();
        this.currentClient = currentClient;
        lbNameSurname.setText(currentClient.getName());
        try {
            UpdateTrainHistory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Personal_Area(){
        super("Personal Area");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setResizable(false);
        setContentPane(mainPanel);
        setLocation((int) screenSize.getWidth() / 2 - (int) getPreferredSize().getWidth() / 2,
                (int) screenSize.getHeight() / 2 - (int) getPreferredSize().getHeight() / 2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        btMakeCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnMakeCallButtonClicked(e);
            }
        });

        btSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnSettingsButtonClicked(e);
            }
        });

    }

    private void OnMakeCallButtonClicked(ActionEvent e){
        Route RouteFrame = new Route(currentClient);
        RouteFrame.setVisible(true);
        setVisible(false);
    }

    private void OnSettingsButtonClicked(ActionEvent e){
        Settings SettingsFrame = new Settings(currentClient);
        SettingsFrame.setVisible(true);
        setVisible(false);
    }

    public void UpdateTrainHistory() throws Exception
    {
        DaoFactoryImpl dfi = new DaoFactoryImpl();
        List<CallImpl> calls = dfi.call().getByClientId(currentClient.getId());
        String title = "Дата поездки" + "\t" + "Откуда" + "\t\t" + "Куда" + "\n";
        taMyTrainStory.setText(title);
        for (int i = 0; i < calls.size(); i++) {
            String element = calls.get(i).getDate() + "\t" + calls.get(i).getStartPoint() + "\t" + calls.get(i).getDestination() + "\n";
            taMyTrainStory.append(element);
        }
    }

}
