package Helpdesk.Polymorphie;

import java.util.ArrayList;

public class Helpdesk {

    private ArrayList<Ticket> tickets = new ArrayList<>();

    public void add(Ticket ticket) {
        tickets.add(ticket);
    }

    public void printOverview() {
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getInfo() + " -> response within " + ticket.getResponseTime() + " h");
        }
    }

    public void printOverview(int maxHours) {
        for (Ticket ticket : tickets) {
            if (ticket.getResponseTime() <= maxHours) {
                System.out.println(ticket.getInfo() + " -> response within " + ticket.getResponseTime() + " h");
            }
        }
    }
}
