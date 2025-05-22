class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets;
    private boolean[] seats;
    private int numTickets;

    public BookingSystem() {
        tickets = new Ticket[10];
        seats = new boolean[10];
        numTickets = 0;
    }

    public boolean bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (numTickets >= 10) {
            System.out.println("All seats are booked.");
            return false;
        }
        
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Must be between 1 and 10.");
            return false;
        }
        
        if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        }
        
        tickets[numTickets] = new Ticket(ticketNumber, customerName, seatNumber);
        seats[seatNumber - 1] = true;
        numTickets++;
        return true;
    }

    public boolean cancelTicket(int ticketNumber) {
        for (int i = 0; i < numTickets; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                int seatNum = tickets[i].getSeatNumber();
                seats[seatNum - 1] = false;
                               
                for (int j = i; j < numTickets - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[numTickets - 1] = null;
                numTickets--;
                return true;
            }
        }
        System.out.println("Ticket with number " + ticketNumber + " not found.");
        return false;
    }

    public void displayAllBookings() {
        if (numTickets == 0) {
            System.out.println("No tickets booked yet.");
            return;
        }
        
        System.out.println("Ticket \tCustomer\tSeat ");
        System.out.println("--------------------------------");
        for (int i = 0; i < numTickets; i++) {
            System.out.println(tickets[i].getTicketNumber() + "\t\t" + 
                             tickets[i].getCustomerName() + "\t\t" + 
                             tickets[i].getSeatNumber());
        }
    }
}

public class MovieBookSystem {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
       
        bookingSystem.bookTicket(1, "Customer 1", 1);
        bookingSystem.bookTicket(2, "Customer 2", 2);
        bookingSystem.bookTicket(3, "Customer 3", 3);
       
        bookingSystem.cancelTicket(2);
       
        bookingSystem.bookTicket(4, "Customer 4", 2);
        
        bookingSystem.displayAllBookings();
    }
}