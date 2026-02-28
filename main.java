import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Hotel> hotelRooms = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Hotel[]rooms = {
        new Hotel(1001, "", "Single", 6000, false),
        new Hotel(1002, "", "Single", 6000, false),
        new Hotel(1003, "", "Single", 6000, false),
        new Hotel(1004, "", "Double", 8000, false),
        new Hotel(1005, "", "Double", 8000, false),
        new Hotel(1006, "", "Double", 8000, false),
        new Hotel(1007, "", "Triple", 10000, false),
        new Hotel(1008, "", "Triple", 10000, false),
        new Hotel(1009, "", "Triple", 10000, false),
        new Hotel(1010, "", "Suite", 15000, false),
        new Hotel(1011, "", "Suite", 15000, false),
        };
        for(Hotel room : hotelRooms){
            room.displayRoom();
        }
        int choices;
        Boolean running = true;
        while (running){
            System.out.println("====================================================");
            System.out.println("           Welcome to White Island Hotel             ");
            System.out.println("====================================================");
            System.out.println("Please choose from the following options:");
            System.out.println("1. Display all rooms");
            System.out.println("2. Reserve a room");
            System.out.println("3. Cancel reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choices = input.nextInt();

            switch (choices){
                case 1:
                    for (Hotel room : rooms){
                        System.out.println("------------------------------------------------------------------");
                        room.displayRoom();
                    }
                    System.out.println("------------------------------------------------------------------");
                case 2:
                    System.out.println("Enter room number to reserve: ");
                    int RoomNumber = input.nextInt();
                    System.out.println("Enter the guest name: ");
                    String GuestName = input.next();
                    System.out.println("Enter the number of nights you want to reserve:");
                    int NightsNumber = input.nextInt();

                    boolean found = false;
                    for (Hotel room : rooms){
                        if(room.RoomNumber == RoomNumber){
                            room.RoomReservation(NightsNumber,GuestName);
                            found = true;
                            System.out.print("\nWould you like any other services? (yes/no): ");
                            String again = input.next();
                            if (again.equalsIgnoreCase("no")) {
                                System.out.println("Thank you for visiting White Island Hotel!");
                                running = false;
                            }

                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Room not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter room number to cancel reservation: ");
                    int Cancel = input.nextInt();
                    found = false;
                    for (Hotel room : rooms) {
                        if (room.RoomNumber == Cancel) {
                            room.cancelReservation();
                            found = true;
                            System.out.print("\nWould you like any other services? (yes/no): ");
                            String again = input.next();
                            if (again.equalsIgnoreCase("no")) {
                                System.out.println("Thank you for visiting White Island Hotel!");
                                running = false;
                            }

                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Room not found");
                    }
                    break;
                case 4:
                    System.out.println("Exiting system... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again");

            }
        }input.close();
    }
}
