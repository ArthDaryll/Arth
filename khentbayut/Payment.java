/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package khentbayut;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author user
 */
public class Payment extends javax.swing.JFrame {

    /**
     * Creates new form Payment
     */
    private static String meter;
    public Payment(String meter) {
        this.meter = meter;
        initComponents();
        fetchInvoices();
        fetchBalances();
        fetchReceipts();
    }
    
    private void fetchInvoices() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
            String query = "SELECT id_no FROM invoices WHERE meter_no = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, meter);
                try (ResultSet rs = pst.executeQuery()) {
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    while (rs.next()) {
                        model.addElement(rs.getString("id_no"));
                    }
                    invoicesC.setModel(model);
                }
            }
        } catch (Exception e) {
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
                        invoicedetailsT.setText(details);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching invoice details: " + e.getMessage());
        }
    }
    private void fetchBalances() {
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
        String query = "SELECT credit_debit, bank_transfer, gcash FROM bank WHERE meter_no = ?";
        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, meter);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    creditdebitT.setText(String.valueOf(rs.getDouble("credit_debit")));
                    bankT.setText(String.valueOf(rs.getDouble("bank_transfer")));
                    gcashT.setText(String.valueOf(rs.getDouble("gcash")));
                }
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error fetching balances: " + e.getMessage());
    }
    }
    private void fetchReceipts() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
            String query = "SELECT receipt_no FROM receipts WHERE meter_no = ?";
            try (PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, meter);
                try (ResultSet rs = pst.executeQuery()) {
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                    while (rs.next()) {
                        model.addElement(rs.getString("receipt_no"));
                    }
                    receiptsC.setModel(model);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching receipts: " + e.getMessage());
        }
    }
    private String getSelectedReceiptNo() {
        return (String) receiptsC.getSelectedItem();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoicedetailsT = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        methodC = new javax.swing.JComboBox<>();
        amountT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        invoicesC = new javax.swing.JComboBox<>();
        confirmpaymentB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        receiptsC = new javax.swing.JComboBox<>();
        viewreceiptB = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        creditdebitT = new javax.swing.JTextField();
        bankT = new javax.swing.JTextField();
        gcashT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicedetailsT.setColumns(20);
        invoicedetailsT.setRows(5);
        jScrollPane1.setViewportView(invoicedetailsT);

        jLabel1.setText("Amount");

        jLabel2.setText("Method");

        methodC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credit/Debit Card", "Bank Transfer", "Gcash" }));

        amountT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountTActionPerformed(evt);
            }
        });

        jLabel3.setText("Invoices");

        invoicesC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoicesCActionPerformed(evt);
            }
        });

        confirmpaymentB.setText("Confirm Payment");
        confirmpaymentB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpaymentBActionPerformed(evt);
            }
        });

        jLabel4.setText("Invoice Details");

        receiptsC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiptsCActionPerformed(evt);
            }
        });

        viewreceiptB.setText("View Receipt");
        viewreceiptB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewreceiptBActionPerformed(evt);
            }
        });

        jLabel5.setText("Receipts");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel6.setText("Current Balance");

        jLabel7.setText("Credit/Debit");

        jLabel8.setText("Bank");

        jLabel9.setText("Gcash");

        creditdebitT.setEditable(false);

        bankT.setEditable(false);

        gcashT.setEditable(false);

        jButton1.setText("Refresh ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addComponent(invoicesC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(amountT))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(confirmpaymentB, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(methodC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewreceiptB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(receiptsC, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(creditdebitT)
                                .addComponent(bankT)
                                .addComponent(gcashT)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(creditdebitT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(bankT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(gcashT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(receiptsC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewreceiptB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(13, 13, 13))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invoicesC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(amountT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(methodC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmpaymentB)))
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountTActionPerformed

    private void invoicesCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoicesCActionPerformed
        String selectedInvoice = (String) invoicesC.getSelectedItem();
        if (selectedInvoice != null) {
            fetchInvoiceDetails(selectedInvoice);
        }
    }//GEN-LAST:event_invoicesCActionPerformed

    private void confirmpaymentBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpaymentBActionPerformed
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arth", "arth", "arth123")) {
        // Step 1: Retrieve the selected invoice number
        String selectedInvoice = (String) invoicesC.getSelectedItem();
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
                    String paymentMethod = (String) methodC.getSelectedItem();
                    String updateBankQuery = "";
                    switch (paymentMethod) {
                        case "Credit/Debit Card":
                            updateBankQuery = "UPDATE bank SET credit_debit = credit_debit - ? WHERE meter_no = ?";
                            break;
                        case "Bank Transfer":
                            updateBankQuery = "UPDATE bank SET bank_transfer = bank_transfer - ? WHERE meter_no = ?";
                            break;
                        case "Gcash":
                            updateBankQuery = "UPDATE bank SET gcash = gcash - ? WHERE meter_no = ?";
                            break;
                    }
                    if (!updateBankQuery.isEmpty()) {
                        try (PreparedStatement pstUpdateBank = conn.prepareStatement(updateBankQuery)) {
                            pstUpdateBank.setDouble(1, amountPaid);
                            pstUpdateBank.setString(2, meter);
                            pstUpdateBank.executeUpdate();
                        }
                    }

                    // Handle surplus: Update the corresponding method in bank table
                    if (surplus > 0) {
                        switch (paymentMethod) {
                            case "Credit/Debit Card":
                                updateBankQuery = "UPDATE bank SET credit_debit = credit_debit + ? WHERE meter_no = ?";
                                break;
                            case "Bank Transfer":
                                updateBankQuery = "UPDATE bank SET bank_transfer = bank_transfer + ? WHERE meter_no = ?";
                                break;
                            case "Gcash":
                                updateBankQuery = "UPDATE bank SET gcash = gcash + ? WHERE meter_no = ?";
                                break;
                        }
                        if (!updateBankQuery.isEmpty()) {
                            try (PreparedStatement pstUpdateBank = conn.prepareStatement(updateBankQuery)) {
                                pstUpdateBank.setDouble(1, surplus);
                                pstUpdateBank.setString(2, meter);
                                pstUpdateBank.executeUpdate();
                            }
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
                            String queryInsertReceipt = "INSERT INTO receipts (receipt_no, id_no, amount_paid, payment_date, method, status, meter_no, details) VALUES (?, ?, ?, CURDATE(), ?, ?, ?, ?)";
                            try (PreparedStatement pstInsertReceipt = conn.prepareStatement(queryInsertReceipt)) {
                                pstInsertReceipt.setString(1, newReceiptNo);
                                pstInsertReceipt.setString(2, selectedInvoice);
                                pstInsertReceipt.setDouble(3, amountPaid);
                                pstInsertReceipt.setString(4, paymentMethod);
                                pstInsertReceipt.setString(5, status);
                                pstInsertReceipt.setString(6, meter);
                                pstInsertReceipt.setString(7, details);
                                pstInsertReceipt.executeUpdate();
                            }
                            // Step 8: Show confirmation dialog
                            JOptionPane.showMessageDialog(this, "Payment confirmed! Receipt Number: " + newReceiptNo);
                            JavaEmailSender emailSender = new JavaEmailSender(meter, newReceiptNo);
                            String recipientEmail = emailSender.getRecipientEmail(meter);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fetchBalances();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewreceiptBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewreceiptBActionPerformed
        String receiptNo = getSelectedReceiptNo();
    if (receiptNo != null) {
        new ReceiptForm(receiptNo).setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Please select a receipt.");
    }
    }//GEN-LAST:event_viewreceiptBActionPerformed

    private void receiptsCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiptsCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiptsCActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment(meter).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountT;
    private javax.swing.JTextField bankT;
    private javax.swing.JButton confirmpaymentB;
    private javax.swing.JTextField creditdebitT;
    private javax.swing.JTextField gcashT;
    private javax.swing.JTextArea invoicedetailsT;
    private javax.swing.JComboBox<String> invoicesC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> methodC;
    private javax.swing.JComboBox<String> receiptsC;
    private javax.swing.JButton viewreceiptB;
    // End of variables declaration//GEN-END:variables
}
