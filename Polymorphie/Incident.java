package Helpdesk.Polymorphie;

public class Incident extends Ticket {

    private int priority;

    public Incident(int number, String title, String reporter, int priority) {
        super(number, title, reporter);
        this.priority = priority;
    }

    //überladen
    public Incident(int number, String title, String reporter) {
        this(number, title, reporter, 2);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int getResponseTime() {
        if (priority == 1) {
            return 1;
        } else if (priority == 2) {
            return 4;
        } else {
            return 24;
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Priority " + priority;
    }
}
