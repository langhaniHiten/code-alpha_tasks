
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private String roomNumber;
    private String category;
    private boolean isAvailable;
    public Room(String roomNumber, String category, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = isAvailable;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public String getCategory() {
        return category;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void reserve() {
        isAvailable = false;
    }
    public void release() {
        isAvailable = true;
    }
    public String printInfo() {
        return "Room Number:"+ roomNumber+",Category:"+category+",Available:"+isAvailable;
    }
}
class Reservation {
    private Room room;
    private String guestName;
    public Reservation(Room room, String guestName) {
        this.room = room;
        this.guestName = guestName;
    }
    public Room getRoom() {
        return room;
    }
    public String getGuestName() {
        return guestName;
    }
    public String printInfo() {
        return "Reservation for " + guestName + ": " + room.printInfo();
    }
}
class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> searchAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public void makeReservation(String guestName, Room room) {
        if (room.isAvailable()) {
            reservations.add(new Reservation(room, guestName));
            room.reserve();
            System.out.println("Reservation successful for " + guestName);
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is not available.");
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No current reservations.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.printInfo());
            }
        }
    }
}
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room("A16", "Single", true));
        hotel.addRoom(new Room("B17", "Single", true));
        hotel.addRoom(new Room("C10", "Double", true));
        while (true) {
            System.out.println("\nWelcome to the Hotel Reservation System");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    List<Room> availableRooms = hotel.searchAvailableRooms();
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms.");
                    } else {
                        System.out.println("Available Rooms:");
                        for (Room room : availableRooms) {
                            System.out.println(room.printInfo());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter room number to book: ");
                    String roomNumber = scanner.nextLine();
                    Room roomToBook = null;

                    for (Room room : hotel.searchAvailableRooms()) {
                        if (room.getRoomNumber().equals(roomNumber)) {
                            roomToBook = room;
                            break;
                        }
                    }
                    if (roomToBook != null) {
                        hotel.makeReservation(name, roomToBook);
                    } else {
                        System.out.println("Room not found or not available.");
                    }
                    break;

                case 3:
                    hotel.viewReservations();
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



