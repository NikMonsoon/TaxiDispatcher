package view.Interfaces;

import model.ClientImpl;
import model.database.DaoFactoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Artem on 02.12.2017.
 */
public class Route extends JFrame{
    private JPanel mainPanel;
    private JLabel lbMakeTrain;
    private JLabel lbStartPoint;
    private JTextField tfStartPoint;
    private JLabel lbDestination;
    private JTextField tfDestination;
    private JLabel lbDate;
    private JTextField tfDate;
    private JButton btConfirm;
    private JButton btBack;

    ClientImpl currentClient;

    public Route(ClientImpl currentClient) {
        this();
        this.currentClient = currentClient;
    }

    public Route(){
        super("Route");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setResizable(false);
        setContentPane(mainPanel);
        setLocation((int) screenSize.getWidth() / 2 - (int) getPreferredSize().getWidth() / 2,
                (int) screenSize.getHeight() / 2 - (int) getPreferredSize().getHeight() / 2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        btBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OnBackButtonClicked(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        btConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnConfirmButtonClicked(e);
            }
        });
    }

    private void OnBackButtonClicked(ActionEvent e){
        Personal_Area PersonalAreaFrame = new Personal_Area(currentClient);
        PersonalAreaFrame.setVisible(true);
        setVisible(false);
    }

    private void OnConfirmButtonClicked(ActionEvent e){
        DaoFactoryImpl dfi = new DaoFactoryImpl();
        /*
        //Поиск наименее загруженной машины
        try {
            TaxiImpl taxiF149OP = dfi.taxi().getByCarNumber("F149OP");
            TaxiImpl taxiY457ER = dfi.taxi().getByCarNumber("Y457ER");

            if (taxiF149OP != null && taxiY457ER != null) {
                java.util.List<CallImpl> carF149OP = dfi.call().getByTaxiId(taxiF149OP.getId());
                java.util.List<CallImpl> carY457ER = dfi.call().getByTaxiId(taxiY457ER.getId());

                System.out.println(taxiF149OP + " " + taxiY457ER);
                if (carF149OP.size() > carY457ER.size()) {
                    dfi.client().doCall(currentClient.getId(), dfi.taxi().getByCarNumber("Y457ER").getId(), tfStartPoint.getText(), tfDestination.getText());
                } else if (carF149OP.size() < carY457ER.size()) {
                    dfi.client().doCall(currentClient.getId(), dfi.taxi().getByCarNumber("F149OP").getId(), tfStartPoint.getText(), tfDestination.getText());
                } else {
                    dfi.client().doCall(currentClient.getId(), dfi.taxi().getByCarNumber("Y457ER").getId(), tfStartPoint.getText(), tfDestination.getText());
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        */
        try {
            dfi.client().doCall(currentClient.getId(), dfi.taxi().getLeastLoadId(), tfStartPoint.getText(), tfDestination.getText());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        Personal_Area PersonalAreaFrame = new Personal_Area(currentClient);
        PersonalAreaFrame.setVisible(true);
        setVisible(false);
    }
}
