package Form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomTypeForm extends JFrame {
    private JLabel firstRoomTypeLabel;
    private JLabel secondRoomTypeLabel;
    private JLabel roomTypeLabel;
    private JTextField inputRoomTypeTxt;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel marginLeftPanel;
    private JPanel marginCenterPanel;
    private JPanel marginRightPanel;
    private JPanel menuPanel;
    private JPanel marginMenuPanel;
    private JPanel inputPanel;
    private JPanel buttonPanel;
    private JPanel marginBottomPanel;
    private JPanel mainPanel;
    private String roomType;
    public JFrame frame = new JFrame();

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType.trim();
    }



    public RoomTypeForm(){

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setRoomType(inputRoomTypeTxt.getText());
                RoomNumberForm roomNumberForm = new RoomNumberForm(roomType);
                roomNumberForm.startRoomNumberForm(roomType);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
            }
        });
    }

    public void startRoomTypeForm() {
        frame = new JFrame("Main");
        frame.setContentPane(new RoomTypeForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
