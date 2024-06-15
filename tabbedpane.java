package javaswingtest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        // Column names for all tabs
        String[] columnNames = {"Name", "Email", "Date", "MessageType"};

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
            {"Alice", "alice@example.com", "1/23/24", "Outbox"},
            {"Bob", "bob@example.com", "1/23/24", "Outbox"},
            {"Charlie", "charlie@example.com", "1/23/24", "Outbox"},
            {"David", "david@example.com", "1/23/24", "Outbox"},
            {"Eve", "eve@example.com", "1/23/24", "Outbox"},
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
            {"John", "john@example.com", "1/22/24", "Drafts"},
            {"Jane", "jane@example.com", "1/22/24", "Drafts"},
            {"Jack", "jack@example.com", "1/22/24", "Drafts"},
            {"Jill", "jill@example.com", "1/22/24", "Drafts"},
            {"Jim", "jim@example.com", "1/22/24", "Drafts"},
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

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action for Confirm button if needed
            }
        });
        buttonPanel.add(confirmButton);

        JButton movetobinButton = new JButton("Move to bin");
        movetobinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform action for Move to Bin button if needed
            }
        });
        buttonPanel.add(movetobinButton);

        JButton composeButton = new JButton("Compose");
        composeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagementFrame managementFrame = new ManagementFrame(tabbedpane.this);
                managementFrame.setVisible(true);
            }
        });
        buttonPanel.add(composeButton);

        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(deleteButton);

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
