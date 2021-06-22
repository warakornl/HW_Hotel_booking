import Form.HomeForm;
import Form.RoomNumberForm;

import javax.swing.*;
import java.util.ArrayList;

public class HotelBookings {
    private static double currentlyPrice;
    public static void main(String args[]){
//        HomeForm homeForm = new HomeForm();
//        homeForm.startHomeFrame();

        ArrayList<String> roomsBooked = new ArrayList<String>();
        String mainMenuChoice = "";

        boolean mainPageFlag = true;
        do{
            mainMenuChoice = (String) JOptionPane.showInputDialog(
                    null,
                    "--HOTEL RENTAL SYSTEM--\n\n" +
                            "1.Choose a room type\n" +
                            "2.Room rates information\n" +
                            "3.Rooms currently booked\n\n" +
                            "4.Exit",
                    "Input",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    "");
            if(mainMenuChoice == null){
                mainPageFlag = false;
            }else if(mainMenuChoice.equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null,
                        "Please insert input",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }else if(mainMenuChoice.equalsIgnoreCase("1")){
                boolean breakFlag = true;
                String roomType = "";
                String roomNumber = "";
                try {
                    do {
                        roomType = (String) JOptionPane.showInputDialog(
                                null,
                                "1.Normal Hotel room\n" +
                                        "2.Suite\n\n" +
                                        "Choose room type",
                                "Input",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                null,
                                "");
                        if (roomType.equalsIgnoreCase("")) {
                            JOptionPane.showMessageDialog(null,
                                    "Please insert input",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (roomType.equalsIgnoreCase("1") || roomType.equalsIgnoreCase("2")) {
                            breakFlag = false;
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Wrong input",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } while (breakFlag);

                    breakFlag = true;

                    do {
                        roomNumber = (String) JOptionPane.showInputDialog(
                                null,
                                "Enter room number",
                                "Input",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                null,
                                "");
                        if (roomNumber.equalsIgnoreCase("")) {
                            JOptionPane.showMessageDialog(null,
                                    "Please insert input",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else if (roomNumber.equalsIgnoreCase("0") || Integer.parseInt(roomNumber) > 500) {
                            JOptionPane.showMessageDialog(null,
                                    "Please input room number between 0 to 500",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            if(roomsBooked.contains(roomNumber)){
                                JOptionPane.showMessageDialog(null,
                                        "Room number : "+roomNumber+" booked",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }else{
                                roomsBooked.add(roomNumber);
                                breakFlag = false;
                            }
                        }
                    } while (breakFlag);
                    HotelRoom hotelRoom = new HotelRoom();
                    Double price = hotelRoom.calculateRoomPrice(roomNumber, roomType);
                    currentlyPrice = currentlyPrice + price;
                } catch (NullPointerException exception) {
                    exception.printStackTrace();
                }
            }else if(mainMenuChoice.equalsIgnoreCase("2")){
                JOptionPane.showMessageDialog(null,
                        "NIGHTLY ROOM RATES\n\n" +
                                "Rooms number 1 - 299 = $69.95\n" +
                                "All other rooms are $89.95\n\n" +
                                "Suites have an extra $40 surcharge applied",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }else if(mainMenuChoice.equalsIgnoreCase("3")){
                JOptionPane.showMessageDialog(null,
                        "ROOM CURRENTLY BOOKED\n\n" +
                                "Rooms number : "+roomsBooked.toString()+"\n" +
                                "Total price : $"+currentlyPrice+"",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }else if(mainMenuChoice.equalsIgnoreCase("4")){
                System.exit(0);
            }else{

            }
        }while (mainPageFlag);
    }
}
