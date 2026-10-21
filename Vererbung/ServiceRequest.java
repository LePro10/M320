package Helpdesk.Vererbung;

public class ServiceRequest extends Ticket {

    private String item;

    public ServiceRequest(int number, String title, String reporter, String item) {
        super(number, title, reporter);
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getResponseTime() {
        return 72;
    }
}
