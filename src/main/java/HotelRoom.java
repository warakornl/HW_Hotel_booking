import javax.swing.*;

public class HotelRoom {

    public Double calculateRoomPrice(String roomNumber, String roomType) {
        Double price;
        int rm = Integer.parseInt(roomNumber);
        if (rm < 300) {
            price = 69.95;
        } else {
            price = 89.95;
        }
        if (roomType.equalsIgnoreCase("2")) {
            price = price + increaseRate();
        }

        JOptionPane.showMessageDialog(null,
                "--Rooms Booked out--\n\n" +
                        "Room No. " + roomNumber + "\n" +
                        "Nightly Rate $" + price,
                "Message",
                JOptionPane.INFORMATION_MESSAGE);
        return price;
    }

    public Double increaseRate(){
        Suite suite = new Suite();
        return suite.getSurcharge();
    }
}
