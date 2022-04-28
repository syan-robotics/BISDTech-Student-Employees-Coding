import subsystems.*;

public class Controller {
    public static void main(String[] args) {
        Emailer emailer = new Emailer();
        Notifier notify = new Notifier(emailer);
        notify.remind("austinws43@boerneisd.net");
    }
}
