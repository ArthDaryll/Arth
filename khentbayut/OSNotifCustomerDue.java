package khentbayut;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class OSNotifCustomerDue {

    public static void sendDueReminder(String meter) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
            String query = "SELECT * FROM invoices WHERE meter_no = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, meter);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        Date dueDate = rs.getDate("due_date");
                        String invoiceNumber = rs.getString("id_no");
                        String dateIssued = rs.getString("date_issued");
                        double totalAmountDue = rs.getDouble("total_amount_due");
                        String status = rs.getString("status");

                        sendDueReminder(dueDate);
                        Date currentDate = new Date();
                    } else {
                        System.out.println("No due date found for meter number: " + meter);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error accessing database: " + e.getMessage());
        }
    }

    private static void sendDueReminder(Date dueDate) {
        String message = "";
        String title = "Payment Due Reminder";
        if (dueDate != null) {
            Date currentDate = new Date();
            long diffInMillies = dueDate.getTime() - currentDate.getTime();
            long diff = diffInMillies / (1000 * 60 * 60 * 24);
            if (diff == 0) {
                message = "This is a reminder that your bill is due today.";
            } else {
                message = "This is a reminder that your bill is due in " + diff + " days.";
            }
        } else {
            message = "Error: Due date not found.";
        }

        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("testing/labtesting.png"); // Provide path to your icon image
            TrayIcon trayIcon = new TrayIcon(image, "Notification");
            try {
                tray.add(trayIcon);
                trayIcon.displayMessage(title, message, TrayIcon.MessageType.INFO);
            } catch (AWTException e) {
                System.err.println("Error displaying OS notification: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
