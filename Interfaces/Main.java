package Helpdesk.Interfaces;

public class Main {
    public static void main(String[] args) {
        // Bisherige Tests, angepasst mit new Helpdesk(new EmailNotifier())

        // Test 1: statischer Typ Ticket, dynamischer Typ Incident
        Ticket incident = new Incident(1001, "Printer not printing", "M. Muster", 2);
        System.out.println("Test 1 Incident Prio 2: " + incident.getResponseTime() + " h (erwartet: 4)");

        // Test 2: statischer Typ Ticket, dynamischer Typ ServiceRequest
        Ticket request = new ServiceRequest(1002, "New docking station", "L. Meier", "Docking-Station");
        System.out.println("Test 2 ServiceRequest: " + request.getResponseTime() + " h (erwartet: 72)");

        // Test 3: Helpdesk mit drei Tickets
        System.out.println("\nTest 3: Übersicht");
        Helpdesk helpdesk = new Helpdesk(new EmailNotifier());
        helpdesk.add(incident);
        helpdesk.add(request);
        helpdesk.add(new Incident(1003, "Server down", "P. Keller", 1));
        helpdesk.printOverview();

        // Test 4: beide Überladungen
        System.out.println("\nTest 4: Incident ohne Priorität und nur dringende Tickets");
        Incident noPriority = new Incident(1004, "VPN slow", "A. Frei");
        System.out.println("Incident ohne Priorität: Priority " + noPriority.getPriority() + " (erwartet: 2)");
        helpdesk.add(noPriority);
        helpdesk.printOverview(4);

        // Test 5: ChangeRequest
        System.out.println("\nTest 5: ChangeRequest");
        ChangeRequest change = new ChangeRequest(1005, "New firewall rule", "R. Zaugg", "Firewall");
        System.out.println("ChangeRequest: " + change.getResponseTime() + " h (erwartet: 120)");
        change.setSystem("Firewall DMZ");
        System.out.println("System: " + change.getSystem() + " (erwartet: Firewall DMZ)");
        helpdesk.add(change);
        helpdesk.printOverview();

        // Neue Tests Interfaces

        // Test 6: Helpdesk mit EmailNotifier, zwei Tickets hinzufügen
        System.out.println("\nTest 6: EmailNotifier");
        Helpdesk helpdesk2 = new Helpdesk(new EmailNotifier());
        helpdesk2.add(new Incident(2001, "Monitor flickers", "S. Weber", 3));
        helpdesk2.add(new ServiceRequest(2002, "New headset", "T. Huber", "Headset"));

        // Test 7: auf TeamsNotifier wechseln, weiteres Ticket hinzufügen
        System.out.println("\nTest 7: TeamsNotifier");
        helpdesk2.setNotifier(new TeamsNotifier());
        helpdesk2.add(new ChangeRequest(2003, "Update mail server", "B. Graf", "Mailserver"));
    }
}
