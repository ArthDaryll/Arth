package khentbayut;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailCustomerDue {

    private static final int DAYS_BEFORE_DUE = 5; // Number of days before due date to send reminder

    public static void sendDueReminder(String meter) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
            String query = "SELECT customerf.email, invoices.due_date " +
                           "FROM customerf " +
                           "JOIN invoices ON customerf.meter_no = invoices.meter_no " +
                           "WHERE customerf.meter_no = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, meter);
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        String recipientEmail = rs.getString("email");
                        Date dueDate = rs.getDate("due_date");

                        if (dueDate != null) {
                            Date currentDate = new Date();
                            long diffInMillies = Math.abs(dueDate.getTime() - currentDate.getTime());
                            long diff = diffInMillies / (1000 * 60 * 60 * 24);

                            if (diff == DAYS_BEFORE_DUE || diff == 0) {
                                sendReminderEmail(recipientEmail, dueDate, diff == 0);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error sending due reminders: " + e.getMessage());
        }
    }

    private static void sendReminderEmail(String recipientEmail, Date dueDate, boolean isDueDate) {
        String senderName = "Electricity Bill Service";
        String senderEmail = "dickf1682@gmail.com";
        String senderPassword = "drhq tcxw zpgf olbb";
        String subject = isDueDate ? "Electricity Bill Due Today" : "Electricity Bill Reminder";
        String body = "Dear Customer,\n\n";

        if (isDueDate) {
            body += "This is a reminder that your electricity bill is due today. Please ensure timely payment to avoid any inconvenience.\n\n";
        } else {
            body += "This is a reminder that your electricity bill is due in " + DAYS_BEFORE_DUE + " days. Please ensure timely payment to avoid any inconvenience.\n\n";
        }

        body += "Due Date: " + formatDate(dueDate) + "\n\n";
        body += "Thank you.";

        try {
            sendNotification(recipientEmail, senderName, senderEmail, senderPassword, subject, body);
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error sending email reminder: " + e.getMessage());
        }
    }

    private static void sendNotification(String recipientEmail, String senderName, String senderEmail, String senderPassword, String subject, String body) throws UnsupportedEncodingException {
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail, senderName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email notification sent successfully to " + recipientEmail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
