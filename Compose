package javaswingtest;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
     * The main method initializes and runs the application using the EventQueue to ensure thread safety for GUI operations.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tabbedpane tabbedPane = new tabbedpane();  // Create the main tabbed pane frame
                    tabbedPane.setVisible(false);  // Initially hide the tabbed pane
                    ManagementFrame frame = new ManagementFrame(tabbedPane);  // Create the ManagementFrame for composing messages
                    frame.setVisible(true);  // Make the ManagementFrame visible
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * This constructor sets up the JFrame, initializes the components, and adds event listeners to buttons.
     */
    public ManagementFrame(tabbedpane tabbedPane) {
        this.tabbedPane = tabbedPane;  // Reference to the main tabbed pane frame
        setTitle("Compose your mail here");  // Set the title of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Define the close operation
        setBounds(100, 100, 840, 649);  // Set the position and size of the window
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));  // Set the border for the content pane
        setContentPane(contentPane);  // Set the content pane of the frame
        contentPane.setLayout(null);  // Use absolute positioning

        // ComboBox for selecting message type
        JComboBox<String> message_type = new JComboBox<>();
        message_type.setFont(new Font("Tahoma", Font.PLAIN, 20));
        message_type.setBounds(220, 154, 531, 34);
        contentPane.add(message_type);
        message_type.addItem("Inbox");
        message_type.addItem("Promotional");
        message_type.addItem("Urgent");
        message_type.addItem("Spam");
        message_type.addItem("Important");

        // Text field for sender
        sender = new JTextField();
        sender.setFont(new Font("Tahoma", Font.PLAIN, 15));
        sender.setBounds(159, 49, 219, 34);
        contentPane.add(sender);
        sender.setColumns(10);

        // Text field for receiver
        receiver = new JTextField();
        receiver.setFont(new Font("Tahoma", Font.PLAIN, 15));
        receiver.setColumns(10);
        receiver.setBounds(513, 49, 230, 34);
        contentPane.add(receiver);

        // Label for sender field
        JLabel sender_title = new JLabel("Sender:");
        sender_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        sender_title.setBounds(75, 49, 74, 34);
        contentPane.add(sender_title);

        // Label for receiver field
        JLabel receiver_title = new JLabel("Receiver:");
        receiver_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        receiver_title.setBounds(423, 49, 116, 34);
        contentPane.add(receiver_title);

        // Label for message type selection
        JLabel message_type_title = new JLabel("Message type:");
        message_type_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        message_type_title.setBounds(75, 154, 150, 34);
        contentPane.add(message_type_title);

        // Label for compose message area
        JLabel message_title = new JLabel("Compose your mail here");
        message_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        message_title.setBounds(291, 198, 279, 34);
        contentPane.add(message_title);

        // Button for sending message
        JButton Send_btn = new JButton("Send");
        Send_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Send_btn.setBounds(85, 562, 152, 40);
        contentPane.add(Send_btn);
        Send_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get and format date components
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

                // Combine date components into a formatted date string
                String date = month + "/" + day + "/" + year;

                // Get the selected message type
                String messageType = (String) message_type.getSelectedItem();

                // Update the outbox with the new message
                tabbedPane.updateOutbox(name, email, date, messageType);

                // Hide the ManagementFrame and show the Outbox tab
                setVisible(false);
                tabbedPane.showOutboxTab();

                // Make the main tabbed pane visible if it's not already
                if (!tabbedPane.isVisible()) {
                    tabbedPane.setVisible(true);
                }
            }
        });

        // Button for saving message as a draft
        JButton draft_btn = new JButton("Draft");
        draft_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        draft_btn.setBounds(341, 562, 152, 40);
        contentPane.add(draft_btn);
        draft_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get and format date components
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

                // Combine date components into a formatted date string
                String date = month + "/" + day + "/" + year;

                // Get the selected message type
                String messageType = (String) message_type.getSelectedItem();

                // Update the drafts with the new message
                tabbedPane.updateDrops(name, email, date, messageType);

                // Hide the ManagementFrame
                setVisible(false);

                // Make the main tabbed pane visible if it's not already
                if (!tabbedPane.isVisible()) {
                    tabbedPane.setVisible(true);
                }
            }
        });

        // Scroll pane for the message text area
        JScrollPane message_scrollPane = new JScrollPane();
        message_scrollPane.setBounds(59, 242, 708, 294);
        contentPane.add(message_scrollPane);

        // Text area for composing the message
        JTextArea message_area = new JTextArea();
        message_scrollPane.setViewportView(message_area);
        message_area.setLineWrap(true);
        message_area.setFont(new Font("Monospaced", Font.PLAIN, 23));

        // Button for discarding the message
        JButton Discard_btn = new JButton("Discard");
        Discard_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Discard_btn.setBounds(593, 562, 152, 40);
        contentPane.add(Discard_btn);
        Discard_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all input fields
                sender.setText("");
                receiver.setText("");
                message_area.setText("");
                day_selection.setSelectedIndex(0);
                month_selection.setSelectedIndex(0);
                year_selection.setSelectedIndex(0);
                message_type.setSelectedIndex(0);  // Reset message type if needed
            }
        });

        // Label for year selection
        JLabel Year_title = new JLabel("Year:");
        Year_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Year_title.setBounds(529, 110, 82, 34);
        contentPane.add(Year_title);

        // ComboBox for day selection
        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        day_selection = new JComboBox<>(days);
        day_selection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        day_selection.setBounds(439, 110, 69, 34);
        contentPane.add(day_selection);

        // Label for day selection
        JLabel day_title = new JLabel("Day:");
        day_title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        day_title.setBounds(365, 110, 82, 34);
        contentPane.add(day_title);

        // ComboBox for month selection
        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        month_selection = new JComboBox<>(months);
        month_selection.setFont(new Font("Tahoma", Font.PLAIN, 20));
        month_selection.setBounds(167, 110, 179, 34);
        contentPane.add(month_selection);

        // Label for month selection
        JLabel day_title_1 = new JLabel("Month:");
        day_title_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        day_title_1.setBounds(75, 110, 82, 34);
        contentPane.add(day_title_1);

        // ComboBox for year selection
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
