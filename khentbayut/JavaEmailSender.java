package khentbayut;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;

public class JavaEmailSender {
    
    private static String meter;
    public JavaEmailSender(String meter, String receiptNo) {
        this.meter = meter;
    }
    static String getRecipientEmail(String meter) {
    String recipientEmail = "";

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
        String query = "SELECT email FROM customerf WHERE meter_no = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, meter);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    recipientEmail = rs.getString("email");
                }
            }
        }
    } catch (SQLException e) {
        System.err.println("Error fetching recipient email: " + e.getMessage());
    }

    return recipientEmail;
    }

    public static void sendNotification(String recipientEmail, String senderName, String senderEmail, String senderPassword, String subject, String body) throws UnsupportedEncodingException {
        // Set up mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Authenticate sender's email and password
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail, senderName)); // Set sender name here
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(body);

            // Send the message
            Transport.send(message);

            System.out.println("Email notification sent successfully to " + recipientEmail);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    
    static String fetchReceiptDetails(String receiptNo) {
    StringBuilder details = new StringBuilder();

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
        String query = "SELECT * FROM receipts WHERE receipt_no = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, receiptNo);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    details.append("Receipt Number: ").append(rs.getString("receipt_no")).append("\n")
                           .append("Amount Paid: ").append(rs.getDouble("amount_paid")).append("\n")
                           .append("Payment Date: ").append(rs.getDate("payment_date")).append("\n")
                           .append("Payment Method: ").append(rs.getString("method")).append("\n")
                           .append("Status: ").append(rs.getString("status")).append("\n");
                }
            }
        }
    } catch (SQLException e) {
        System.err.println("Error fetching receipt details: " + e.getMessage());
    }

    return details.toString();
    }

    public static void main(String[] args, String receiptNo) throws UnsupportedEncodingException {
        String recipientEmail = getRecipientEmail(meter);
        String receiptDetails = fetchReceiptDetails(receiptNo);
        String senderName = "Electricity Bill Service";
        String senderEmail = "dickf1682@gmail.com";
        String senderPassword = "drhq tcxw zpgf olbb";
        String subject = "Electricity Bill Paymet Successful";
        String body = "Dear Customer,\n\nThis is to confirm that your payment for receipt number " +receiptNo+ ". has been received and processed.\\n\\nReceipt Details:\\n\" "+ receiptDetails +" \\\n\\nThank you for your payment.\\n\\nRegards,\\nElectricity Bill Service\"";

        sendNotification(recipientEmail, senderName, senderEmail, senderPassword, subject, body);
    }
    
}
