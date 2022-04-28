package subsystems;

public class Notifier {
    Emailer emailer;
    public Notifier(Emailer emailer) {
        this.emailer = emailer;
    }
    public void remind(String recipient) {
        emailer.email(recipient,"IMPORTANT REMINDER","You're awesome");
    }
}