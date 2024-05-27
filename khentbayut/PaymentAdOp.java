/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package khentbayut;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class PaymentAdOp extends javax.swing.JFrame {

    /**
     * Creates new form PaymentAdOp
     */
    private static final String URL = "jdbc:mysql://localhost:3306/arth";
    private static final String USERNAME = "arth";
    private static final String PASSWORD = "arth123";

    // JDBC variables for opening, closing and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String meterNumbers;

    public PaymentAdOp() {
        initComponents();
        getAllMeterNumbers();
    }
    private void getAllMeterNumbers() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
            String query = "SELECT meter_no FROM customerf";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                try (ResultSet rs = pst.executeQuery()) {
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    while (rs.next()) {
                        model.addElement(rs.getString("meter_no"));
                    }
                    meternumC.setModel(model);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching invoices: " + e.getMessage());
        }
    }
    private void fetchInvoices(String selectedMeterNumber) {
    if (selectedMeterNumber == null || selectedMeterNumber.isEmpty()) {
        // No meter number selected, do nothing
        return;
    }
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
        String query = "SELECT id_no FROM invoices WHERE meter_no = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, selectedMeterNumber);
            try (ResultSet rs = pst.executeQuery()) {
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                while (rs.next()) {
                    model.addElement(rs.getString("id_no"));
                }
                invoiceC.setModel(model);
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching invoices: " + e.getMessage());
    }
    }
    private void fetchInvoiceDetails(String invoiceNumber) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
            String query = "SELECT * FROM invoices WHERE id_no = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, invoiceNumber);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String details = "Invoice Number: " + rs.getString("id_no") + "\n"
                                       + "Meter Number: " + rs.getString("meter_no") + "\n"
                                       + "Total Amount Due: " + rs.getDouble("total_amount_due") + "\n"
                                       + "Due Date: " + rs.getDate("due_date") + "\n"
                                       + "Date Issued: " + rs.getDate("date_issued");
                        jTextArea1.setText(details);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching invoice details: " + e.getMessage());
        }
    }
    private void fetchReceipts(String selectedMeterNumber) {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
        String query = "SELECT receipt_no FROM receipts WHERE meter_no = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, selectedMeterNumber);
            try (ResultSet rs = pst.executeQuery()) {
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                while (rs.next()) {
                    model.addElement(rs.getString("receipt_no"));
                }
                receiptsC.setModel(model);
            } catch (SQLException rsEx) {
                JOptionPane.showMessageDialog(this, "Error fetching receipt data: " + rsEx.getMessage());
                rsEx.printStackTrace(); // Log the exception
            }
        } catch (SQLException pstEx) {
            JOptionPane.showMessageDialog(this, "Error preparing statement: " + pstEx.getMessage());
            pstEx.printStackTrace(); // Log the exception
        }
    } catch (SQLException connEx) {
        JOptionPane.showMessageDialog(this, "Error connecting to the database: " + connEx.getMessage());
        connEx.printStackTrace(); // Log the exception
    }
}


    private String getSelectedReceiptNo() {
        return (String) receiptsC.getSelectedItem();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        meternumC = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        invoiceC = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        receiptsC = new javax.swing.JComboBox<>();
        viewreceiptsB = new javax.swing.JButton();
        backB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        amountT = new javax.swing.JTextField();
        confirmpaymentB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Meter #");

        meternumC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meternumCActionPerformed(evt);
            }
        });

        jLabel2.setText("Invoices");

        invoiceC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceCActionPerformed(evt);
            }
        });

        jLabel3.setText("Invoice Details");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("Receipts");

        viewreceiptsB.setText("View Receipts");
        viewreceiptsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewreceiptsBActionPerformed(evt);
            }
        });

        backB.setText("Back");
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });

        jLabel5.setText("Amount");

        confirmpaymentB.setText("Confirm Payment");
        confirmpaymentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpaymentBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel5))
                            .addGap(29, 29, 29)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(meternumC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(invoiceC, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(amountT, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                    .addComponent(receiptsC, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(backB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(viewreceiptsB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmpaymentB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(meternumC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(amountT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(confirmpaymentB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(receiptsC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewreceiptsB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backB)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void invoiceCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceCActionPerformed
        String selectedInvoice = (String) invoiceC.getSelectedItem();
        if (selectedInvoice != null) {
            fetchInvoiceDetails(selectedInvoice);
        }
    }//GEN-LAST:event_invoiceCActionPerformed

    private void viewreceiptsBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewreceiptsBActionPerformed
        String receiptNo = getSelectedReceiptNo();
    if (receiptNo != null) {
        new ReceiptForm(receiptNo).setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a receipt.");
    }
    }//GEN-LAST:event_viewreceiptsBActionPerformed

    private void meternumCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meternumCActionPerformed
        String selectedMeterNumber = (String) meternumC.getSelectedItem();
        fetchInvoices(selectedMeterNumber);
        fetchReceipts(selectedMeterNumber);
    }//GEN-LAST:event_meternumCActionPerformed

    private void confirmpaymentBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpaymentBActionPerformed
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
        // Step 1: Retrieve the selected invoice number
        String selectedInvoice = (String) invoiceC.getSelectedItem();
        if (selectedInvoice == null || selectedInvoice.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an invoice.");
            return;
        }
        
        // Step 2: Retrieve the payment amount
        double amountPaid;
        try {
            amountPaid = Double.parseDouble(amountT.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            return;
        }

        // Step 3: Retrieve the details of the selected invoice
        String queryInvoice = "SELECT * FROM invoices WHERE id_no = ?";
        try (PreparedStatement pstInvoice = conn.prepareStatement(queryInvoice)) {
            pstInvoice.setString(1, selectedInvoice);
            try (ResultSet rsInvoice = pstInvoice.executeQuery()) {
                if (rsInvoice.next()) {
                    double totalAmountDue = rsInvoice.getDouble("total_amount_due");

                    if (totalAmountDue <= 0) {
                        JOptionPane.showMessageDialog(this, "The invoice is already fully paid. No payment needed.");
                        return;
                    }

                    double newTotalAmountDue = totalAmountDue - amountPaid;
                    String status = newTotalAmountDue <= 0 ? "paid" : "unpaid";
                    double surplus = 0;
                    if (newTotalAmountDue < 0) {
                        surplus = Math.abs(newTotalAmountDue);
                        newTotalAmountDue = 0;
                    }

                    // Step 4: Update the invoices table
                    String queryUpdateInvoice = "UPDATE invoices SET total_amount_due = ?, status = ? WHERE id_no = ?";
                    try (PreparedStatement pstUpdateInvoice = conn.prepareStatement(queryUpdateInvoice)) {
                        pstUpdateInvoice.setDouble(1, newTotalAmountDue);
                        pstUpdateInvoice.setString(2, status);
                        pstUpdateInvoice.setString(3, selectedInvoice);
                        pstUpdateInvoice.executeUpdate();
                    }

                    // Step 5: Update the corresponding payment method in the bank table
                    String updateBankQuery = "UPDATE adopmoney SET cheatmoney = cheatmoney - ?";
                    try (PreparedStatement pstUpdateBank = conn.prepareStatement(updateBankQuery)) {
                        pstUpdateBank.setDouble(1, amountPaid);
                        pstUpdateBank.executeUpdate();
                    }

                    // Handle surplus: Update the corresponding method in bank table
                    if (surplus > 0) {
                        String updateSurplusQuery = "UPDATE adopmoney SET cheatmoney = cheatmoney + ?";
                        try (PreparedStatement pstUpdateSurplus = conn.prepareStatement(updateSurplusQuery)) {
                            pstUpdateSurplus.setDouble(1, surplus);
                            pstUpdateSurplus.executeUpdate();
                        }
                    }

                    // Step 6: Generate a new receipt number
                    String queryReceipt = "SELECT MAX(receipt_no) FROM receipts";
                    try (PreparedStatement pstReceipt = conn.prepareStatement(queryReceipt)) {
                        try (ResultSet rsReceipt = pstReceipt.executeQuery()) {
                            int maxReceiptNo = 0;
                            if (rsReceipt.next()) {
                                maxReceiptNo = rsReceipt.getInt(1);
                            }
                            String newReceiptNo = String.format("%06d", maxReceiptNo + 1);

                            // Step 7: Update the receipts table
                            String details = "Payment";
                            String method = "Cash";
                            String queryInsertReceipt = "INSERT INTO receipts (receipt_no, id_no, amount_paid, payment_date, method, status, meter_no, details) VALUES (?, ?, ?, CURDATE(), ?, ?, ?, ?)";
                            try (PreparedStatement pstInsertReceipt = conn.prepareStatement(queryInsertReceipt)) {
                                pstInsertReceipt.setString(1, newReceiptNo);
                                pstInsertReceipt.setString(2, selectedInvoice);
                                pstInsertReceipt.setDouble(3, amountPaid);
                                pstInsertReceipt.setString(4, method);
                                pstInsertReceipt.setString(5, status);
                                pstInsertReceipt.setString(6, meterNumbers);
                                pstInsertReceipt.setString(7, details);
                                pstInsertReceipt.executeUpdate();
                            }
                            // Step 8: Show confirmation dialog
                            JOptionPane.showMessageDialog(this, "Payment confirmed! Receipt Number: " + newReceiptNo);
                            JavaEmailSender emailSender = new JavaEmailSender(meterNumbers, newReceiptNo);
                            String recipientEmail = emailSender.getRecipientEmail(meterNumbers);
                            String receiptDetails = emailSender.fetchReceiptDetails(newReceiptNo);
                            String senderName = "Electricity Bill Service";
                            String senderEmail = "dickf1682@gmail.com";
                            String senderPassword = "drhq tcxw zpgf olbb";
                            String subject = "Electricity Bill Payment Successful";
                            String body = "Dear Customer,\n\nThis is to confirm that your payment for receipt number " + newReceiptNo + " has been received and processed.\n\nReceipt Details:\n" + receiptDetails + "\n\nThank you for your payment.\n\nRegards,\nElectricity Bill Service";
                            try {
                                emailSender.sendNotification(recipientEmail, senderName, senderEmail, senderPassword, subject, body);
                            } catch (UnsupportedEncodingException ex) {
                                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            OSNotificationSender.sendNotification("Payment Confirmation", "Payment for receipt number " + newReceiptNo + " has been received and processed.", receiptDetails);
                        }
                    }
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error confirming payment: " + e.getMessage());
    }
    }//GEN-LAST:event_confirmpaymentBActionPerformed

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBActionPerformed
        this.dispose();
    }//GEN-LAST:event_backBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentAdOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentAdOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentAdOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentAdOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentAdOp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountT;
    private javax.swing.JButton backB;
    private javax.swing.JButton confirmpaymentB;
    private javax.swing.JComboBox<String> invoiceC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> meternumC;
    private javax.swing.JComboBox<String> receiptsC;
    private javax.swing.JButton viewreceiptsB;
    // End of variables declaration//GEN-END:variables
}
