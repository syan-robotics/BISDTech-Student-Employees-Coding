package subsystems;
import java.util.GregorianCalendar;

public class Notifier {
    Emailer emailer;

    public Notifier(Emailer emailer) {
        this.emailer = emailer;
    }
    public void remind(String recipient, int month, int day, int year, String itemName) {
        emailer.email(recipient, 
        "BoerneISD Technology Department Reminder", 
        String.format("Reminder! You loaned an item from the Boerne ISD Tech department on %d/%d/%d. Please return the %s as soon as you can. Thank you.", 
            month, day, year, itemName));

    }

}