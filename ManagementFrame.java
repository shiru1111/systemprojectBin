package javaswingtest;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField sender;
    private JTextField receiver;
    private tabbedpane tabbedPane;
    private JComboBox<String> day_selection;
    private JComboBox<String> month_selection;
    private JComboBox<String> year_selection;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tabbedpane tabbedPane = new tabbedpane();
                    tabbedPane.setVisible(false);
                    ManagementFrame frame = new ManagementFrame(tabbedPane);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManagementFrame(tabbedpane tabbedPane) {
        this.tabbedPane = tabbedPane;
        setTitle("Compose your mail here");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 840, 649);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JComboBox<String> message_type = new JComboBox<>();
        message_type.setFont(new Font("Tahoma", Font.PLAIN, 20));
        message_type.setBounds(220, 154, 531, 34);
        contentPane.add(message_type);
        message_type.addItem("Inbox");
        message_type.addItem("Promotional");
        message_type.addItem("Urgent");
        message_type.addItem("Spam");
        message_type.addItem("Important");

        sender = new JTextField();
        sender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        sender.setBounds(159, 49, 219, 34);
        contentPane.add(sender);
        sender.setColumns(10);

        receiver = new JTextField();
        receiver.setFont(new Font("Tahoma", Font.PLAIN, 15));
        receiver.setColumns(10);
        receiver.setBounds(513, 49, 230, 34);
        contentPane.add(receiver);

        JLabel sender_title = new JLabel("Sender:");
        sender_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sender_title.setBounds(75, 49, 74, 34);
        contentPane.add(sender_title);

        JLabel receiver_title = new JLabel("Receiver:");
        receiver_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        receiver_title.setBounds(423, 49, 116, 34);
        contentPane.add(receiver_title);

        JLabel message_type_title = new JLabel("Message type:");
        message_type_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        message_type_title.setBounds(75, 154, 150, 34);
        contentPane.add(message_type_title);

        JLabel message_title = new JLabel("Compose your mail here");
        message_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        message_title.setBounds(291, 198, 279, 34);
        contentPane.add(message_title);

        JButton Send_btn = new JButton("Send");
        Send_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Send_btn.setBounds(85, 562, 152, 40);
        contentPane.add(Send_btn);

        JButton draft_btn = new JButton("Draft");
        draft_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = sender.getText().trim();
                String email = receiver.getText().trim(); 
                String day = (String) day_selection.getSelectedItem();
                String month = (String) month_selection.getSelectedItem();
                String year = (String) year_selection.getSelectedItem();
                
                // Format day and month to always have two digits
                day = day.length() == 1 ? "0" + day : day;
                // Get month index and add 1 to match the real month number
                int monthIndex = month_selection.getSelectedIndex() + 1;
                month = monthIndex < 10 ? "0" + monthIndex : String.valueOf(monthIndex);
                
                String date = month + "/" + day + "/" + year;
                
                tabbedPane.updateDrops(name, email, date);
                
                // Hide ManagementFrame
                setVisible(false);
                
                // Show tabbedPane if it's not visible
                if (!tabbedPane.isVisible()) {
                    tabbedPane.setVisible(true);
                }
            }
       
        });
        draft_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        draft_btn.setBounds(341, 562, 152, 40);
        contentPane.add(draft_btn);

        JButton Discard_btn = new JButton("Discard");
        Discard_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Discard_btn.setBounds(593, 562, 152, 40);
        contentPane.add(Discard_btn);

        JScrollPane message_scrollPane = new JScrollPane();
        message_scrollPane.setBounds(59, 242, 708, 294);
        contentPane.add(message_scrollPane);

        JTextArea message_area = new JTextArea();
        message_scrollPane.setViewportView(message_area);
        message_area.setLineWrap(true);
        message_area.setFont(new Font("Monospaced", Font.PLAIN, 23));

        JLabel Year_title = new JLabel("Year:");
        Year_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Year_title.setBounds(529, 110, 82, 34);
        contentPane.add(Year_title);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        day_selection = new JComboBox<>(days);
        day_selection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        day_selection.setBounds(439, 110, 69, 34);
        contentPane.add(day_selection);

        JLabel day_title = new JLabel("Day:");
        day_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        day_title.setBounds(365, 110, 82, 34);
        contentPane.add(day_title);

        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        month_selection = new JComboBox<>(months);
        month_selection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        month_selection.setBounds(167, 110, 179, 34);
        contentPane.add(month_selection);

        JLabel day_title_1 = new JLabel("Month:");
        day_title_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        day_title_1.setBounds(75, 110, 82, 34);
        contentPane.add(day_title_1);

        year_selection = new JComboBox<>();
        year_selection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        year_selection.setBounds(593, 110, 158, 33);
        contentPane.add(year_selection);
        year_selection.addItem("2022");
        year_selection.addItem("2023");
        year_selection.addItem("2024");
        year_selection.addItem("2025");
    }
}
