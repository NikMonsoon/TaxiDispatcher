package control;

import view.Interfaces.Log_Regist;

import javax.swing.*;

public class Main {

    public static void main(String[] args){
        setLookAndFeel("Nimbus");
        Log_Regist LogFrame = new Log_Regist();
    }

    private static void checkDriver()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }
    }


    public static void setLookAndFeel(String style)
    {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (style.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
