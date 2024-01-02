import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.util.Calendar;

public class Main {
    private static void roomInformations(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("1: Room details");
        System.out.println("2: Available rooms");

        try {
            while (true) {
                input = scanner.nextLine();
                switch (input) {
                    case "1":
                        System.out.println("Please enter the room ID:");
                        input = scanner.nextLine();
                        Room selectedRoom = hotel.getRoomById(Integer.parseInt(input));
                        selectedRoom.getRoomDetails();
                        break;
                    case "2":
                        List<Room> availableRooms = hotel.getAvailableRooms();
                        System.out.println("Available rooms :");
                        for (Room room : availableRooms) {
                            System.out.println("Room ID: " + room.getId() + ", Category: " + room.getCategoryName()
                                    + ", Price: " + room.getPrice());
                        }
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void manageBookings(Hotel hotel) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Calendar calendar = Calendar.getInstance();
        String input;
        System.out.println("1: Book a room");
        System.out.println("2: Edit a booking");
        System.out.println("3: Cancel/delete a booking");
        System.out.println("4: List bookings");

        try {
            while (true) {
                input = scanner.nextLine();
                switch (input) {
                    case "1":
                        System.out.println("Please enter the room ID you want to book:");
                        int roomId = scanner.nextInt();
                        Room selectedRoom = hotel.getRoomById(roomId);
                        System.out.println("How many days do you want to book the room for?");
                        int days = scanner.nextInt();
                        Date startDate = new Date();
                        calendar.setTime(startDate);
                        calendar.add(Calendar.DATE, days);
                        Date endDate = calendar.getTime();
                        System.out.println("What is the first name of the client?");
                        String firstName = scanner.nextLine();
                        System.out.println("What is the last name of the client?");
                        String lastName = scanner.nextLine();
                        System.out.println("What is the phone number of the client?");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("What is the mail of the client?");
                        String mail = scanner.nextLine();
                        List<Order> orders = new ArrayList<>();

                        Booking booking = new Booking(
                                rand.nextInt(9999) + 1,
                                selectedRoom,
                                startDate,
                                endDate,
                                new Client(
                                        rand.nextInt(9999) + 1,
                                        firstName,
                                        lastName,
                                        phoneNumber,
                                        mail),
                                orders);
                        hotel.addBooking(booking);
                        break;
                    case "2":
                        System.out.println("Please enter the booking ID you want to edit:");
                        int bookingId = scanner.nextInt();
                        Booking selectedBooking = hotel.getBookingById(bookingId);
                        Room selectedRoom = hotel.getRoomById(roomId);
                        System.out.println("How many days do you want to book the room for?");
                        int days = scanner.nextInt();
                        Date startDate = new Date();
                        calendar.setTime(startDate);
                        calendar.add(Calendar.DATE, days);
                        Date endDate = calendar.getTime();
                        System.out.println("What is the first name of the client?");
                        String firstName = scanner.nextLine();
                        System.out.println("What is the last name of the client?");
                        String lastName = scanner.nextLine();
                        System.out.println("What is the phone number of the client?");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("What is the mail of the client?");
                        String mail = scanner.nextLine();
                        List<Order> orders = new ArrayList<>();

                        Booking booking = new Booking(
                                rand.nextInt(9999) + 1,
                                selectedRoom,
                                startDate,
                                endDate,
                                new Client(
                                        rand.nextInt(9999) + 1,
                                        firstName,
                                        lastName,
                                        phoneNumber,
                                        mail),
                                orders);
                        hotel.addBooking(booking);
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void manageOrder(Booking booking) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: order a breakfast");
        System.out.println("2: order a lunch");
        System.out.println("3: order a dinner");
        System.out.println("4: order a massage");
        String input;

        try{
            while (true) {
                input = scanner.nextLine();
                switch (input) {
                    case "1":
                        
                        break;
                
                    default:
                        break;
                }
                
            }
        }
        


    }

    public static void main(String[] args) {
        System.out.println("Hello! Welcome to your hotel management application.");
        System.out.println("What would you like to do ?");
        Scanner scanner = new Scanner(System.in);
        String input;
        //list initialisation
        List<Booking> bookingList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();
        List<Bill> billList = new ArrayList<>();
        //Hotel initialisation
        Hotel ritz = new Hotel(bookingList, roomList, billList);
        //Order initialisation
        Order breakfastOrder = new Order(1,5,"breakfast");
        Order lunchOrder = new Order(1,5,"lunch");
        Order dinerOrder = new Order(1,5,"diner");
        Order massOrder = new Order(1,5,"massage");
        

        while (true) {
            System.out.println("--Home menu--");
            System.out.println("1: Initialize hotel");
            System.out.println("2: Room informations");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    ritz.addRoom(new LuxuryDouble(1500, new ArrayList<>(), true, true));
                    ritz.addRoom(new LuxurySimple(1000, new ArrayList<>(), true, true));
                    ritz.addRoom(new NormalDouble(500, new ArrayList<>(), true));
                    ritz.addRoom(new NormalSimple(250, new ArrayList<>(), true));
                    break;
                case "get room":
                    System.out.println(ritz.getRooms().size());
                    break;
                case "2":
                    roomInformations(ritz);
                    // System.out.println("Menu informations :");
                    // System.out.println(
                    // "For room details tap 1 \nFor available room press 2\nFor availability of the
                    // rooms tap 3");
                    // String input2 = scanner.nextLine();
                    // switch (input2) {
                    // case "1":
                    // System.out.println("room details");

                    // break;

                    // case "2":
                    // System.out.println("available room");
                    // List<Room> availableRooms = ritz.getAvailableRooms();
                    // System.out.println("Available rooms :");
                    // for (Room room : availableRooms) {
                    // System.out.println("Room ID: " + room.getId() + ", Category: " +
                    // room.getCategoryName()
                    // + ", Price: " + room.getPrice());
                    // }

                    // break;
                    // case "3":
                    // ritz.displayRoomAvailability();
                    // break;

                    // default:
                    // System.out.println("no case in room");
                    // }

                    break;
                default:
                    System.out.println("no case");

            }

        }

    }

}
