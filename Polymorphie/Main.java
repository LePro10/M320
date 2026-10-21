package Helpdesk.Polymorphie;

public class Main {
    public static void main(String[] args) {
        // Test 1: statisch, dynamisch
        Ticket incident = new Incident(1001, "Printer not printing", "M. Muster", 2);
        System.out.println("Test 1 Incident Prio 2: " + incident.getResponseTime() + " h (erwartet: 4)");

        // Test 2: statischer Typ Ticket, dynamischer Typ ServiceRequest
        Ticket request = new ServiceRequest(1002, "New docking station", "L. Meier", "Docking-Station");
        System.out.println("Test 2 ServiceRequest: " + request.getResponseTime() + " h (erwartet: 72)");

        // Test 3. 3 Tickets
        System.out.println("\nTest 3: Übersicht");
        Helpdesk helpdesk = new Helpdesk();
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
    }
}
