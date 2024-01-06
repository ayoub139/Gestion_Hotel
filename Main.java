import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Calendar;

public class Main {
    public static Integer getInt(Scanner scanner) {
        try {
            int input = scanner.nextInt();
            return input;
        } catch (InputMismatchException e) {
            return null;
        }
    }

    private static void roomInformations(Hotel hotel, Scanner scanner) {
        String input;
        boolean goBack = false;

        while (goBack == false) {
            System.out.println("-----Manage rooms-----");
            System.out.println("1: Room details");
            System.out.println("2: Available rooms");
            System.out.println("3: Go back");
            System.out.println("-------------------------");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    List<Room> rooms = hotel.getRooms();
                    System.out.println("Here are all the rooms :");
                    for (Room room : rooms) {
                        System.out.println("Room ID: " + room.getId() + ", Category: " + room.getCategoryName()
                                + ", Price: " + room.getPrice());
                    }
                    System.out.println("Please enter the room ID:");
                    input = scanner.nextLine();
                    Room selectedRoom = hotel.getRoomById(Integer.parseInt(input));
                    if (selectedRoom == null) {
                        System.err.println("There is no room corresponding to this room ID");
                        break;
                    }
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
                case "3":
                    goBack = true;
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }
        }
    }

    private static void manageBookings(Hotel hotel, Scanner scanner) {
        Random rand = new Random();
        boolean isAvailable = false;
        boolean editingBooking = true;
        boolean goBack = false;
        Calendar calendar = Calendar.getInstance();
        Room selectedRoom = null;
        String input;
        List<Booking> bookings = null;
        int roomId;

        while (goBack == false) {
            System.out.println("-----Manage bookings-----");
            System.out.println("1: Book a room");
            System.out.println("2: Edit a booking");
            System.out.println("3: Cancel/delete a booking");
            System.out.println("4: List bookings");
            System.out.println("5: Go back");
            System.out.println("-------------------------");
            isAvailable = false;
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    List<Room> availableRooms = hotel.getAvailableRooms();
                    System.out.println("Here are the available rooms :");
                    for (Room room : availableRooms) {
                        System.out.println("Room ID: " + room.getId() + ", Category: " + room.getCategoryName()
                                + ", Price: " + room.getPrice());
                    }
                    while (isAvailable == false) {
                        System.out.println("Please enter the room ID you want to book:");
                        roomId = scanner.nextInt();
                        scanner.nextLine();
                        selectedRoom = hotel.getRoomById(roomId);
                        if (selectedRoom == null) {
                            System.out.println("There is no room corresponding to this room ID");
                        } else if (selectedRoom.getAvailability() == false) {
                            System.out.println("This room is not available");
                        } else {
                            isAvailable = true;
                        }
                    }
                    System.out.println("The id of the selected room is " + selectedRoom.getId());
                    System.out.println("How many days do you want to book the room for?");
                    Integer days = getInt(scanner);
                    scanner.nextLine();
                    if (days == null) {
                        System.out.println("The input is not a number please try to book again");
                        break;
                    }
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

                    Booking newBooking = new Booking(
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
                    hotel.addBooking(newBooking);
                    selectedRoom.setAvailability(false);
                    break;
                case "2":
                    bookings = hotel.getBookings();
                    System.out.println("Bookings :");
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                                + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                                + " " + booking.getClient().getLastName() + ", Start date: "
                                + booking.getStartDate() + ", End date: " + booking.getEndDate());
                    }
                    System.out.println("Please enter the booking ID you want to edit:");
                    int bookingId = scanner.nextInt();
                    scanner.nextLine();
                    Booking selectedBooking = hotel.getBookingById(bookingId);
                    if (selectedBooking == null) {
                        System.out.println("There is no booking corresponding to this booking ID");
                        break;
                    }
                    while (editingBooking == true) {
                        System.out.println("1: Edit the room associated");
                        System.out.println("2: Edit the end date associated");
                        System.out.println("3: Edit the client");
                        System.out.println("4: Go back");

                        input = scanner.nextLine();
                        switch (input) {
                            case "1":
                                System.out.println("Please enter the room ID you want to book:");
                                roomId = scanner.nextInt();
                                scanner.nextLine();
                                selectedRoom = hotel.getRoomById(roomId);
                                if (selectedRoom == null) {
                                    System.err.println("There is no room corresponding to this room ID");
                                    break;
                                }
                                if (selectedRoom.getId() == selectedBooking.getRoom().getId()) {
                                    System.out.println("The room is already associated with the booking");
                                    break;
                                }
                                if (selectedRoom.getAvailability() == false) {
                                    System.out.println("This room is not available");
                                    break;
                                }
                                selectedBooking.getRoom().setAvailability(true);
                                selectedBooking.setRoom(selectedRoom);
                                break;
                            case "2":
                                System.out.println("How many days do you want to book the room for?");
                                days = scanner.nextInt();
                                scanner.nextLine();
                                calendar.setTime(selectedBooking.getStartDate());
                                calendar.add(Calendar.DATE, days);
                                endDate = calendar.getTime();
                                selectedBooking.setEndDate(endDate);
                                break;
                            case "3":
                                System.out.println("What is the first name of the client?");
                                firstName = scanner.nextLine();
                                System.out.println("firstname == " + firstName);
                                System.out.println("What is the last name of the client?");
                                lastName = scanner.nextLine();
                                System.out.println("What is the phone number of the client?");
                                phoneNumber = scanner.nextLine();
                                System.out.println("What is the mail of the client?");
                                mail = scanner.nextLine();
                                selectedBooking.getClient().setFirstName(firstName);
                                selectedBooking.getClient().setLastName(lastName);
                                selectedBooking.getClient().setPhoneNumber(phoneNumber);
                                selectedBooking.getClient().setMail(mail);
                                break;
                            case "4":
                                editingBooking = false;
                                break;
                            default:
                                System.out.println("Please enter a valid input");
                        }
                    }
                    break;
                case "3":
                    bookings = hotel.getBookings();
                    System.out.println("Bookings :");
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                                + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                                + " " + booking.getClient().getLastName() + ", Start date: "
                                + booking.getStartDate() + ", End date: " + booking.getEndDate());
                    }
                    System.out.println("Please enter the booking ID you want to cancel:");
                    bookingId = scanner.nextInt();
                    scanner.nextLine();
                    selectedBooking = hotel.getBookingById(bookingId);
                    if (selectedBooking == null) {
                        System.err.println("There is no booking corresponding to this booking ID");
                        break;
                    }
                    hotel.removeBooking(selectedBooking);
                    break;
                case "4":
                    bookings = hotel.getBookings();
                    System.out.println("Bookings :");
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                                + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                                + " " + booking.getClient().getLastName() + ", Start date: "
                                + booking.getStartDate() + ", End date: " + booking.getEndDate());
                    }
                    break;
                case "5":
                    goBack = true;
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }
        }
    }

    private static void manageOrder(Hotel hotel, Scanner scanner) {
        boolean goBack = false;
        Random rand = new Random();
        List<Booking> bookings = null;
        String input;

        while (goBack == false) {
            System.out.println("-----Manage orders-----");
            System.out.println("1: create an order");
            System.out.println("2: edit an order");
            System.out.println("3: delete an order");
            System.out.println("4: list orders");
            System.out.println("5: go back");
            System.out.println("-------------------------");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    bookings = hotel.getBookings();
                    System.out.println("Bookings :");
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                                + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                                + " " + booking.getClient().getLastName() + ", Start date: "
                                + booking.getStartDate() + ", End date: " + booking.getEndDate());
                    }
                    System.out.println("Please enter the booking ID you want to add an order to:");
                    int bookingId = scanner.nextInt();
                    scanner.nextLine();
                    Booking selectedBooking = hotel.getBookingById(bookingId);
                    if (selectedBooking == null) {
                        System.err.println("There is no booking corresponding to this booking ID");
                        break;
                    }
                    System.out.println("Please enter the order name:");
                    String name = scanner.nextLine();
                    System.out.println("Please enter the order price:");
                    int price = scanner.nextInt();
                    scanner.nextLine();
                    Order newOrder = new Order(
                            rand.nextInt(9999) + 1,
                            price,
                            name);
                    selectedBooking.addOrder(newOrder);
                    break;
                case "2":
                    bookings = hotel.getBookings();
                    System.out.println("Bookings :");
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                                + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                                + " " + booking.getClient().getLastName() + ", Start date: "
                                + booking.getStartDate() + ", End date: " + booking.getEndDate());
                    }
                    System.out.println("Please enter the the booking ID you want to edit an order from:");
                    bookingId = scanner.nextInt();
                    scanner.nextLine();
                    selectedBooking = hotel.getBookingById(bookingId);
                    if (selectedBooking == null) {
                        System.err.println("There is no booking corresponding to this booking ID");
                        break;
                    }
                    System.out.println("Here are the orders of this booking:");
                    List<Order> orders = selectedBooking.getOrders();
                    for (Order order : orders) {
                        System.out.println("Order ID: " + order.getId() + ", Name: " + order.getName()
                                + ", Price: " + order.getPrice());
                    }
                    System.out.println("Please enter the order ID you want to edit:");
                    int orderId = scanner.nextInt();
                    scanner.nextLine();
                    Order selectedOrder = selectedBooking.getOrderById(orderId);
                    if (selectedOrder == null) {
                        System.err.println("There is no order corresponding to this order ID");
                        break;
                    }
                    System.out.println("Please enter the order name:");
                    name = scanner.nextLine();
                    System.out.println("Please enter the order price:");
                    price = scanner.nextInt();
                    scanner.nextLine();
                    selectedOrder.setName(name);
                    selectedOrder.setPrice(price);
                    break;
                case "3":
                    bookings = hotel.getBookings();
                    System.out.println("Bookings :");
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                                + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                                + " " + booking.getClient().getLastName() + ", Start date: "
                                + booking.getStartDate() + ", End date: " + booking.getEndDate());
                    }
                    System.out.println("Please enter the the booking ID you want to delete an order from:");
                    bookingId = scanner.nextInt();
                    scanner.nextLine();
                    selectedBooking = hotel.getBookingById(bookingId);
                    if (selectedBooking == null) {
                        System.err.println("There is no booking corresponding to this booking ID");
                        break;
                    }
                    System.out.println("Here are the orders of this booking:");
                    orders = selectedBooking.getOrders();
                    for (Order order : orders) {
                        System.out.println("Order ID: " + order.getId() + ", Name: " + order.getName()
                                + ", Price: " + order.getPrice());
                    }
                    System.out.println("Please enter the order ID you want to delete:");
                    orderId = scanner.nextInt();
                    scanner.nextLine();
                    selectedOrder = selectedBooking.getOrderById(orderId);
                    if (selectedOrder == null) {
                        System.err.println("There is no order corresponding to this order ID");
                        break;
                    }
                    selectedBooking.removeOrder(selectedOrder);
                    break;
                case "4":
                    bookings = hotel.getBookings();
                    System.out.println("Bookings :");
                    for (Booking booking : bookings) {
                        System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                                + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                                + " " + booking.getClient().getLastName() + ", Start date: "
                                + booking.getStartDate() + ", End date: " + booking.getEndDate());
                    }
                    System.out.println("Please enter the the booking ID you want to list the orders from:");
                    bookingId = scanner.nextInt();
                    scanner.nextLine();
                    selectedBooking = hotel.getBookingById(bookingId);
                    if (selectedBooking == null) {
                        System.err.println("There is no booking corresponding to this booking ID");
                        break;
                    }
                    System.out.println("Here are the orders of this booking:");
                    orders = selectedBooking.getOrders();
                    for (Order order : orders) {
                        System.out.println("Order ID: " + order.getId() + ", Name: " + order.getName()
                                + ", Price: " + order.getPrice());
                    }
                    break;
                case "5":
                    goBack = true;
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }
        }
    }

    private static void generateBill(Hotel hotel, Scanner scanner) {
        Random rand = new Random();
        List<Booking> bookings = hotel.getBookings();
        System.out.println("Bookings :");
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getId() + ", Room ID: "
                    + booking.getRoom().getId() + ", Client: " + booking.getClient().getFirstName()
                    + " " + booking.getClient().getLastName() + ", Start date: "
                    + booking.getStartDate() + ", End date: " + booking.getEndDate());
        }
        System.out.println("Please enter the booking ID you want to close");
        Integer bookingId = getInt(scanner);
        scanner.nextLine();
        if (bookingId == null) {
            System.out.println("The input is not a number please try to generate a new bill");
            return;
        }
        Booking selectedBooking = hotel.getBookingById(bookingId);
        if (selectedBooking == null) {
            System.err.println("There is no booking corresponding to this booking ID");
            return;
        }
        int totalPrice = 0;
        for (Order order : selectedBooking.getOrders()) {
            totalPrice += order.getPrice();
        }
        Bill newBill = new Bill(
                rand.nextInt(9999) + 1,
                selectedBooking,
                totalPrice);
        hotel.addBill(newBill);
        hotel.removeBooking(selectedBooking);
    }

    private static void manageBills(Hotel hotel, Scanner scanner) {
        String input;
        boolean goBack = false;
        List<Bill> bills = null;

        while (goBack == false) {
            System.out.println("-----Manage bills-----");
            System.out.println("1: Generate new bill");
            System.out.println("2: List bills");
            System.out.println("3: Delete a bill");
            System.out.println("4: Go back");
            System.out.println("-------------------------");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    generateBill(hotel, scanner);
                    break;
                case "2":
                    bills = hotel.getBills();
                    System.out.println("Bills :");
                    for (Bill bill : bills) {
                        System.out.println(
                                "Bill ID: " + bill.getId() + ", Reservation ID associated: " + bill.getBooking().getId()
                                        + ", Total: " + bill.getTotal());
                    }
                    break;
                case "3":
                    bills = hotel.getBills();
                    System.out.println("Bills :");
                    for (Bill bill : bills) {
                        System.out.println(
                                "Bill ID: " + bill.getId() + ", Reservation ID associated: " + bill.getBooking().getId()
                                        + ", Total: " + bill.getTotal());
                    }
                    System.out.println("Please enter the bill ID you want to delete");
                    Integer billId = getInt(scanner);
                    scanner.nextLine();
                    if (billId == null) {
                        System.out.println("The input is not a number please try to delete the bill again");
                        break;
                    }
                    Bill selectedBill = hotel.getBillById(billId);
                    if (selectedBill == null) {
                        System.err.println("There is no bill corresponding to this bill ID");
                        break;
                    }
                    hotel.removeBill(selectedBill);
                case "4":
                    goBack = true;
                    break;
                default:
                    System.out.println("Please enter a valid input");
            }
        }
    }

    public static Hotel initializeHotel() {
        List<Booking> bookingList = new ArrayList<>();
        List<Room> roomList = new ArrayList<>();
        List<Bill> billList = new ArrayList<>();
        Hotel hotel = new Hotel(bookingList, roomList, billList);
        hotel.addRoom(new LuxuryDouble(1500, true, true));
        hotel.addRoom(new LuxurySimple(1000, true, true));
        hotel.addRoom(new NormalDouble(500, true));
        hotel.addRoom(new NormalSimple(250, true));
        return hotel;
    }

    public static void main(String[] args) {
        System.out.println("Initializing hotel...");
        Hotel ritz = initializeHotel();

        System.out.println("Hello! Welcome to your hotel management application.");
        System.out.println("What would you like to do ?");
        Scanner scanner = new Scanner(System.in);
        String input;

        try {
            while (true) {
                System.out.println("-----Home menu-----");
                System.out.println("1: Manage Rooms");
                System.out.println("2: Manage bookings");
                System.out.println("3: Manage orders");
                System.out.println("4: Manage bills");
                System.out.println("-------------------------");
                input = scanner.nextLine();
                switch (input) {
                    case "1":
                        roomInformations(ritz, scanner);
                        break;
                    case "2":
                        manageBookings(ritz, scanner);
                        break;
                    case "3":
                        manageOrder(ritz, scanner);
                        break;
                    case "4":
                        manageBills(ritz, scanner);
                    default:
                        System.out.println("Please enter a valid input");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
