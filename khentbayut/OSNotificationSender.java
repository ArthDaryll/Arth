package khentbayut;

import java.awt.*;
import javax.swing.*;

public class OSNotificationSender {

    public static void sendNotification(String title, String message, String receiptDetails) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("testing/labtesting.png"); // Provide path to your icon image
            TrayIcon trayIcon = new TrayIcon(image, "Notification");
            try {
                tray.add(trayIcon);
                trayIcon.displayMessage(title, message + "\n\nReceipt Details:\n" + receiptDetails, TrayIcon.MessageType.INFO);
            } catch (AWTException e) {
                System.err.println("Error displaying OS notification: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, message + "\n\nReceipt Details:\n" + receiptDetails, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
