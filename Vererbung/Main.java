package Helpdesk.Vererbung;

public class Main {
    public static void main(String[] args) {
        Incident incident = new Incident(1001, "Printer not printing", "M. Muster", 1);
        System.out.println("Incident Prio 1: " + incident.getResponseTime() + " h (erwartet: 1)");

        incident.setPriority(3);
        System.out.println("Incident Prio 3: " + incident.getResponseTime() + " h (erwartet: 24)");

        ServiceRequest request = new ServiceRequest(1002, "New docking station", "L. Meier", "Docking-Station");
        System.out.println("ServiceRequest: " + request.getResponseTime() + " h (erwartet: 72)");

        System.out.println(incident.getInfo());
        System.out.println(request.getInfo());
    }
}
