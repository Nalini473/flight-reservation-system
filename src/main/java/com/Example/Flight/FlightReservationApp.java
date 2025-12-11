import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class FlightReservationApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FlightService service = new FlightService();

        service.addFlight(new Flight("AA101", "New York",
                LocalDateTime.of(2025, 1, 10, 9, 30), 10));
        service.addFlight(new Flight("BA202", "Chicago",
                LocalDateTime.of(2025, 1, 10, 14, 15), 5));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        while (true) {
            System.out.println("\n1. Search Flights\n2. Book Flight\n3. View Reservations\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter destination: ");
                    String dest = scanner.nextLine();

                    System.out.print("Enter date (yyyy-MM-dd HH:mm): ");
                    LocalDateTime dt = LocalDateTime.parse(scanner.nextLine(), formatter);

                    List<Flight> results = service.searchFlights(dest, dt);
                    results.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("Customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Flight number: ");
                    String fno = scanner.nextLine();

                    System.out.print("Seats to book: ");
                    int seats = scanner.nextInt();
                    scanner.nextLine();

                    List<Flight> flights = service.searchFlights("New York", LocalDateTime.of(2025, 1, 10, 9, 30));
                    Flight selected = flights.stream()
                            .filter(f -> f.getFlightNumber().equalsIgnoreCase(fno))
                            .findFirst()
                            .orElse(null);

                    if (selected != null) {
                        Reservation r = service.bookFlight(name, selected, seats);
                        System.out.println("Booked: " + r);
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter customer name: ");
                    service.getReservationsForCustomer(scanner.nextLine())
                            .forEach(System.out::println);
                    break;

                case 4:
                    return;
            }
        }
    }
}
