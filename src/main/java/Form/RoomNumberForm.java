package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomNumberForm extends JFrame{
    private JLabel roomNumberLabel;
    private JTextField inputRoomNumberTxt;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel marginLeftPanel;
    private JPanel marginCenterPanel;
    private JPanel marginRightPanel;
    private JPanel centerPanel;
    private JPanel marginBottomPanel;
    private JPanel marginButtonPanel;
    private JPanel mainPanel;
    public JFrame frame = new JFrame("Main");
    private String roomNumber;
    private String roomType;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        roomNumber = roomNumber.trim();
        if(roomNumber != null && roomNumber.length()>0){
            int convert = Integer.parseInt(roomNumber);
            this.roomNumber = String.valueOf(convert);
        }else{
            this.roomNumber = "";
        }

    }

    public RoomNumberForm(String roomTypeParam) {
        setRoomType(roomTypeParam);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setRoomNumber(inputRoomNumberTxt.getText());
                inputRoomNumberTxt.setText("");
                if(getRoomNumber() == null || getRoomNumber().length()==0){
                    JOptionPane.showMessageDialog(null,
                            "Please input room number",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }else if(getRoomNumber().equalsIgnoreCase("0")||Integer.parseInt(getRoomNumber())>500){
                    JOptionPane.showMessageDialog(null,
                            "Please input room number between 0 to 500",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }else{
//                    String totalPrice = calculateRoomPrice(getRoomNumber());
                    JOptionPane.showMessageDialog(null,
                            "--Rooms Booked out--\n\n" +
                                    "Room No. "+getRoomNumber()+"\n" +
                                    "Nightly Rate $"+0,
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public void startRoomNumberForm(String roomTypeParam){
        frame.setContentPane(new RoomNumberForm(roomTypeParam).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }



}
