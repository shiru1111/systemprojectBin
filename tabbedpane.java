package javaswingtest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class tabbedpane extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel inboxTableModel;
    private DefaultTableModel outboxTableModel;
    private DefaultTableModel dropsTableModel;
    private JTabbedPane tabbedPane;
    private RecycleBin recycleBin;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	tabbedpane frame = new tabbedpane();
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
    public tabbedpane() {
        setTitle("Emails");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        recycleBin = new RecycleBin(this);

        // Column names for all tabs
        String[] columnNames = {"Sender", "Receiver", "Date", "MessageType"};

        // Inbox tab
        Object[][] inboxData = {
            {"Ruka300ms", "onlyme@", "1/24/24", "Inbox"},
            {"myzkaji", "onlyme@", "1/24/24", "Inbox"},
            {"Shiru", "onlyme@", "1/24/24", "Inbox"},
            {"Rare", "onlyme@", "1/24/24", "Inbox"},
            {"Espidider", "onlyme@", "1/24/24", "Inbox"},
        };
        JPanel inboxPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Inbox", inboxPanel);
        inboxTableModel = new DefaultTableModel(inboxData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable inboxTable = new JTable(inboxTableModel);
        inboxTable.setPreferredScrollableViewportSize(new Dimension(550, 400));
        JScrollPane inboxScrollPane = new JScrollPane(inboxTable);
        inboxPanel.add(inboxScrollPane, BorderLayout.CENTER);
        centerTableHeaders(inboxTable);
        centerTableData(inboxTable);

        // Outbox tab
        Object[][] outboxData = {
            {"Ellana", "ruka@example.com", "1/23/24", "Outbox"},
            {"Espedida", "espidider@example.com", "1/23/24", "Outbox"},
            {"Reyes", "shiru@example.com", "1/23/24", "Outbox"},

        };
        JPanel outboxPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Outbox", outboxPanel);
        outboxTableModel = new DefaultTableModel(outboxData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable outboxTable = new JTable(outboxTableModel);
        outboxTable.setPreferredScrollableViewportSize(new Dimension(550, 400));
        JScrollPane outboxScrollPane = new JScrollPane(outboxTable);
        outboxPanel.add(outboxScrollPane, BorderLayout.CENTER);
        centerTableHeaders(outboxTable);
        centerTableData(outboxTable);

        // Drafts tab
        Object[][] dropsData = {
            {"Ramos", "rere@example.com", "1/22/24", "Drafts"},
            {"Molo", "myzkaji@example.com", "1/22/24", "Drafts"},

        };
        JPanel dropsPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Drafts", dropsPanel);
        dropsTableModel = new DefaultTableModel(dropsData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable dropsTable = new JTable(dropsTableModel);
        dropsTable.setPreferredScrollableViewportSize(new Dimension(550, 400));
        JScrollPane dropsScrollPane = new JScrollPane(dropsTable);
        dropsPanel.add(dropsScrollPane, BorderLayout.CENTER);
        centerTableHeaders(dropsTable);
        centerTableData(dropsTable);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton confirmButton = new JButton("View");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tabIndex = tabbedPane.getSelectedIndex();
                JTable table = null;
                DefaultTableModel model = null;
                
                // Determine which table is currently active
                switch (tabIndex) {
                    case 0: // Inbox tab
                        table = inboxTable;
                        model = inboxTableModel;
                        break;
                    case 1: // Outbox tab
                        table = outboxTable;
                        model = outboxTableModel;
                        break;
                    case 2: // Drafts tab
                        table = dropsTable;
                        model = dropsTableModel;
                        break;
                    default:
                        break;
                }
                
                // Get selected row index
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // If a row is selected
                    // Retrieve data from selected row
                    String sender = model.getValueAt(selectedRow, 0).toString();
                    String receiver = model.getValueAt(selectedRow, 1).toString();
                    String date = model.getValueAt(selectedRow, 2).toString();
                    String messageType = model.getValueAt(selectedRow, 3).toString();
                    
                    // Construct message
                    String message = "Sender: " + sender + "\n"
                                   + "Receiver: " + receiver + "\n"
                                   + "Date: " + date + "\n"
                                   + "Message Type: " + messageType;
                    
                    // Show message in a dialog
                    JOptionPane.showMessageDialog(tabbedpane.this, message, "Message Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Inform user to select a row
                    JOptionPane.showMessageDialog(tabbedpane.this, "Please select a message to view details.", "No message selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(confirmButton);

        JButton composeButton = new JButton("Compose");
        composeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagementFrame managementFrame = new ManagementFrame(tabbedpane.this);
                managementFrame.setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(composeButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tabIndex = tabbedPane.getSelectedIndex();
                JTable table = null;
                DefaultTableModel model = null;
                
                // Determine which table is currently active
                switch (tabIndex) {
                    case 0: // Inbox tab
                        table = inboxTable;
                        model = inboxTableModel;
                        break;
                    case 1: // Outbox tab
                        table = outboxTable;
                        model = outboxTableModel;
                        break;
                    case 2: // Drafts tab
                        table = dropsTable;
                        model = dropsTableModel;
                        break;
                    default:
                        break;
                }
                
                // Get selected row index
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // If a row is selected
                    // Retrieve data from selected row
                    String sender = model.getValueAt(selectedRow, 0).toString();
                    String receiver = model.getValueAt(selectedRow, 1).toString();
                    String date = model.getValueAt(selectedRow, 2).toString();
                    String messageType = model.getValueAt(selectedRow, 3).toString();
                    
                    // Add the row to the RecycleBin
                    recycleBin.addRow(new Object[]{sender, receiver, date, messageType});
                    
                    // Remove the row from the current table
                    model.removeRow(selectedRow);
                } else {
                    // Inform user to select a row
                    JOptionPane.showMessageDialog(tabbedpane.this, "Please select a message to delete.", "No message selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        buttonPanel.add(deleteButton);

        JButton moveToBinButton = new JButton("Bin");
        moveToBinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recycleBin.setVisible(true);
                dispose();
            }
        });
        buttonPanel.add(moveToBinButton);

        // Initially select the first tab
        tabbedPane.setSelectedIndex(0);
    }

    public void updateDrops(String name, String email, String formattedDate, String messageType) {
        dropsTableModel.addRow(new Object[]{name, email, formattedDate, messageType});
    }

    public void updateOutbox(String name, String email, String formattedDate, String messageType) {
        outboxTableModel.addRow(new Object[]{name, email, formattedDate, messageType});
    }

    private void centerTableHeaders(JTable table) {
        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void centerTableData(JTable table) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    public void showOutboxTab() {
        tabbedPane.setSelectedIndex(1); // 1 corresponds to the index of the Outbox tab
    }
}
