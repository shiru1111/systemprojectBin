package javaswingtest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class tabbedpane extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel dropsTableModel;

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
        setBounds(100, 100, 490, 430);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        String[] columnNames = {"Name", "Email", "Date"};

        Object[][] inboxData = {
            {"Ruka300ms", "onlyme@", "1/24/24"},
            {"myzkaji", "onlyme@", "1/24/24"},
            {"Shiru", "onlyme@", "1/24/24"},
            {"Rare", "onlyme@", "1/24/24"},
            {"Espidider", "onlyme@", "1/24/24"},
        };

        JPanel inboxPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Inbox", inboxPanel);

        DefaultTableModel inboxTableModel = new DefaultTableModel(inboxData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable inboxTable = new JTable(inboxTableModel);
        inboxTable.setPreferredScrollableViewportSize(new Dimension(550, 400));
        JScrollPane inboxScrollPane = new JScrollPane(inboxTable);
        inboxPanel.add(inboxScrollPane, BorderLayout.CENTER);

        Object[][] outboxData = {
            {"Alice", "alice@example.com", "1/23/24"},
            {"Bob", "bob@example.com", "1/23/24"},
            {"Charlie", "charlie@example.com", "1/23/24"},
            {"David", "david@example.com", "1/23/24"},
            {"Eve", "eve@example.com", "1/23/24"},
        };

        JPanel outboxPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Outbox", outboxPanel);

        DefaultTableModel outboxTableModel = new DefaultTableModel(outboxData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable outboxTable = new JTable(outboxTableModel);
        outboxTable.setPreferredScrollableViewportSize(new Dimension(550, 400));
        JScrollPane outboxScrollPane = new JScrollPane(outboxTable);
        outboxPanel.add(outboxScrollPane, BorderLayout.CENTER);



        Object[][] dropsData = {
            {"John", "john@example.com", "1/22/24"},
            {"Jane", "jane@example.com", "1/22/24"},
            {"Jack", "jack@example.com", "1/22/24"},
            {"Jill", "jill@example.com", "1/22/24"},
            {"Jim", "jim@example.com", "1/22/24"},
        };

        JPanel dropsPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("Drops", dropsPanel);

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


        centerTableHeaders(inboxTable);
        centerTableHeaders(outboxTable);
        centerTableHeaders(dropsTable);
        centerTableData(inboxTable);
        centerTableData(outboxTable);
        centerTableData(dropsTable);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton confirmButton = new JButton("Confirm");
        buttonPanel.add(confirmButton);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Message message = new Message();
                message.setVisible(true);
                dispose();
            }
        });

        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(deleteButton);

        JButton composeButton = new JButton("Compose");
        buttonPanel.add(composeButton);
    }

    public void updateDrops(String name, String email, String formattedDate) {
        dropsTableModel.addRow(new Object[]{name, email, formattedDate});
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
}
