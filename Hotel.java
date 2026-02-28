public class Hotel {
    int RoomNumber;
    String guestName;
    String RoomType;
    float PricePerNight;
    boolean isBooked;

    public Hotel(int RoomNumber, String guestName, String RoomType, float PricePerNight, boolean isBooked){
        this.RoomNumber = RoomNumber;
        this.guestName = "";
        this.RoomType = RoomType;
        this.PricePerNight = PricePerNight;
        this.isBooked = false;
    }
    public double RoomReservation(int NumberOfDays , String Name){
        if (!isBooked){
            isBooked = true;
            guestName = Name;
            float TotalPrice = PricePerNight*NumberOfDays;
            System.out.println("Room booked successfully");
            System.out.println("Total Price : " + TotalPrice);
            return TotalPrice;
        }
        else {
            System.out.println("Room is already booked!");
            return 0;
        }
    }
    public void cancelReservation(){
        if (isBooked){
            isBooked = false;
            System.out.println("Reservation for " + guestName + " has been cancelled");
            guestName = "";
        }
        else {
            System.out.println("This room is not booked ");
        }
    }
    public void displayRoom(){
        System.out.println("Room Number: " + RoomNumber);
        System.out.println("Room Type: " + RoomType);
        System.out.println("Price Per Night: " + PricePerNight);
        if (isBooked) {
            System.out.println("Status: Booked");
            System.out.println("Guest Name: " + guestName);
        } else {
            System.out.println("Status: Available");
        }
    }
}


