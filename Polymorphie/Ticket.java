package Helpdesk.Polymorphie;

public class Ticket {

    private int number;
    private String title;
    private String reporter;

    public Ticket(int number, String title, String reporter) {
        this.number = number;
        this.title = title;
        this.reporter = reporter;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getReporter() {
        return reporter;
    }

    public String getInfo() {
        return "#" + number + " " + title + " (" + reporter + ")";
    }

    //neu
    public int getResponseTime() {
        return 48;
    }
}
