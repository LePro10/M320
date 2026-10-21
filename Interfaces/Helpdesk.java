package Helpdesk.Interfaces;

import java.util.ArrayList;

public class Helpdesk {

    private ArrayList<Ticket> tickets = new ArrayList<>();
    private INotifier notifier;

    public Helpdesk(INotifier notifier) {
        this.notifier = notifier;
    }

    public void setNotifier(INotifier notifier) {
        this.notifier = notifier;
    }

    public void add(Ticket ticket) {
        tickets.add(ticket);
        notifier.send(ticket.getReporter(),
                "Ticket #" + ticket.getNumber() + " created. Response within " + ticket.getResponseTime() + " h.");
    }

    public void printOverview() {
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getInfo() + " -> response within " + ticket.getResponseTime() + " h");
        }
    }

    // Überladung: nur Tickets mit Reaktionszeit <= maxHours
    public void printOverview(int maxHours) {
        for (Ticket ticket : tickets) {
            if (ticket.getResponseTime() <= maxHours) {
                System.out.println(ticket.getInfo() + " -> response within " + ticket.getResponseTime() + " h");
            }
        }
    }
}
