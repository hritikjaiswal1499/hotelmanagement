import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {

    static class Room {
        private int roomNumber;
        private String roomType;
        private boolean isReserved;

        public Room(int roomNumber, String roomType) {
            this.roomNumber = roomNumber;
            this.roomType = roomType;
            this.isReserved = false;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public String getRoomType() {
            return roomType;
        }

        public boolean isReserved() {
            return isReserved;
        }

        public void reserveRoom() {
            if (!isReserved) {
                isReserved = true;
                System.out.println("Room " + roomNumber + " has been reserved.");
            } else {
                System.out.println("Room " + roomNumber + " is already reserved.");
            }
        }

        public void cancelReservation() {
            if (isReserved) {
                isReserved = false;
                System.out.println("Reservation for Room " + roomNumber + " has been canceled.");
            } else {
                System.out.println("Room " + roomNumber + " was not reserved.");
            }
        }

        @Override
        public String toString() {
            return "Room Number: " + roomNumber + ", Type: " + roomType + (isReserved ? " [Reserved]" : " [Available]");
        }
    }

    private ArrayList<Room> rooms = new ArrayList<>();

    public HotelReservationSystem() {
        // Predefined rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Single"));
        rooms.add(new Room(201, "Double"));
        rooms.add(new Room(202, "Double"));
        rooms.add(new Room(301, "Suite"));
        rooms.add(new Room(302, "Suite"));
    }

    public void addRoom(int roomNumber, String roomType) {
        rooms.add(new Room(roomNumber, roomType));
        System.out.println("Room added successfully.");
    }

    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    public void reserveRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.reserveRoom();
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public void cancelReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                room.cancelReservation();
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public void searchRoomByType(String roomType) {
        boolean found = false;
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && !room.isReserved()) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available rooms found for the given type.");
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Room");
            System.out.println("2. Display Rooms");
            System.out.println("3. Reserve Room");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Search Room by Type");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Room Number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Room Type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();
                    hotel.addRoom(roomNumber, roomType);
                    break;
                case 2:
                    hotel.displayRooms();
                    break;
                case 3:
                    System.out.print("Enter Room Number to Reserve: ");
                    int reserveRoomNumber = scanner.nextInt();
                    hotel.reserveRoom(reserveRoomNumber);
                    break;
                case 4:
                    System.out.print("Enter Room Number to Cancel Reservation: ");
                    int cancelRoomNumber = scanner.nextInt();
                    hotel.cancelReservation(cancelRoomNumber);
                    break;
                case 5:
                    System.out.print("Enter Room Type to Search: ");
                    String searchRoomType = scanner.nextLine();
                    hotel.searchRoomByType(searchRoomType);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
