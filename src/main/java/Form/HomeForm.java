package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeForm extends JFrame {
    private JPanel mainPanel;
    private JPanel marginLeftPanel;
    private JLabel mainMenuLabel;
    private JPanel marginRightPanel;
    private JPanel menuPanel;
    private JLabel homeFirstMenuLabel;
    private JLabel homeSecondMenuLabel;
    private JLabel homeThirdMenuLabel;
    private JPanel inputPanel;
    private JLabel homeFourMenuLabel;
    private JTextField inputMainMenuTxt;
    private JPanel marginButtonPanel;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel marginBottomPanel;
    private JPanel marginTopPanel;
    public JFrame frame = new JFrame();

    private String choice;

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice.trim();
    }

    public HomeForm() {
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setChoice(inputMainMenuTxt.getText());
                System.out.println(choice);
                inputMainMenuTxt.setText("");
                if (choice == null || choice.length() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Please insert input",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (choice.equalsIgnoreCase("1")) {
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
                                breakFlag = false;
                            }
                        } while (breakFlag);

                        String price = calculateRoomPrice(roomNumber, roomType);
                        JOptionPane.showMessageDialog(null,
                                "--Rooms Booked out--\n\n" +
                                        "Room No. " + roomNumber + "\n" +
                                        "Nightly Rate $" + price,
                                "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (NullPointerException exception) {
                        exception.printStackTrace();
                    }
                } else if (choice.equalsIgnoreCase("4")) {
                    System.exit(0);
                } else {

                }

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void startHomeFrame() {
        frame = new JFrame("Main");
        frame.setContentPane(new HomeForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public String calculateRoomPrice(String roomNumber, String roomType) {
        Double price;
        int rm = Integer.parseInt(roomNumber);
        if (rm < 300) {
            price = 69.95;
        } else {
            price = 89.95;
        }
        if (roomType.equalsIgnoreCase("2")) {
            price = price + 40;
        }
        return String.valueOf(price);
    }
}
