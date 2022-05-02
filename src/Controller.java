import java.sql.SQLException;

import javax.swing.JFrame;

import subsystems.*;

public class Controller {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Database database = new Database();
        Emailer emailer = new Emailer();
        Notifier reminder = new Notifier(emailer);
        reminder.remind("jerry.flores@boerneisd.net", 5, 2, 2022, "hp laptop");
        //Coded from Jerry
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }

}
