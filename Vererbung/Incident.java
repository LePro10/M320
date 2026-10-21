package Helpdesk.Vererbung;

public class Incident extends Ticket {

    private int priority;

    public Incident(int number, String title, String reporter, int priority) {
        super(number, title, reporter);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getResponseTime() {
        if (priority == 1) {
            return 1;
        } else if (priority == 2) {
            return 4;
        } else {
            return 24;
        }
    }
}
