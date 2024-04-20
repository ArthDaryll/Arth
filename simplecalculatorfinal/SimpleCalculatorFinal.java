package simplecalculatorfinal;
import java.awt.*;
import javax.swing.*;

public class SimpleCalculatorFinal extends javax.swing.JFrame {

    double num1, num2, result;
    String op;
    public SimpleCalculatorFinal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtxtResult = new javax.swing.JTextField();
        jbtnDel = new javax.swing.JButton();
        jbtnCe = new javax.swing.JButton();
        jbtnC = new javax.swing.JButton();
        jbtnPM = new javax.swing.JButton();
        jbtnPlus = new javax.swing.JButton();
        jbtnDigit9 = new javax.swing.JButton();
        jbtnDigit8 = new javax.swing.JButton();
        jbtnDigit7 = new javax.swing.JButton();
        jbtnDigit4 = new javax.swing.JButton();
        jbtnDigit1 = new javax.swing.JButton();
        jbtnDigit0 = new javax.swing.JButton();
        jbtnDot = new javax.swing.JButton();
        jbtnDigit2 = new javax.swing.JButton();
        jbtnDigit5 = new javax.swing.JButton();
        jbtnDigit6 = new javax.swing.JButton();
        jbtnDigit3 = new javax.swing.JButton();
        jbtnEquals = new javax.swing.JButton();
        jbtnDiv = new javax.swing.JButton();
        jbtnMult = new javax.swing.JButton();
        jbtnMinus = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jbtSqu = new javax.swing.JButton();
        jbtRoot = new javax.swing.JButton();
        jbtNeg = new javax.swing.JButton();
        jbtRep = new javax.swing.JButton();
        jbtMod = new javax.swing.JButton();
        jbtFac = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simple Calculator");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(java.awt.Color.black);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jtxtResult.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        jtxtResult.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtResult.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtxtResult.setCaretColor(new java.awt.Color(102, 255, 0));
        jtxtResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtResultActionPerformed(evt);
            }
        });

        jbtnDel.setBackground(new java.awt.Color(255, 102, 0));
        jbtnDel.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDel.setText("DEL");
        jbtnDel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDelActionPerformed(evt);
            }
        });

        jbtnCe.setBackground(new java.awt.Color(255, 153, 51));
        jbtnCe.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnCe.setText("CE");
        jbtnCe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnCe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCeActionPerformed(evt);
            }
        });

        jbtnC.setBackground(new java.awt.Color(255, 153, 51));
        jbtnC.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnC.setText("C");
        jbtnC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCActionPerformed(evt);
            }
        });

        jbtnPM.setBackground(new java.awt.Color(204, 204, 204));
        jbtnPM.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnPM.setText("±");
        jbtnPM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnPM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPMActionPerformed(evt);
            }
        });

        jbtnPlus.setBackground(new java.awt.Color(204, 204, 204));
        jbtnPlus.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnPlus.setText("+");
        jbtnPlus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPlusActionPerformed(evt);
            }
        });

        jbtnDigit9.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit9.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit9.setText("9");
        jbtnDigit9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit9ActionPerformed(evt);
            }
        });

        jbtnDigit8.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit8.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit8.setText("8");
        jbtnDigit8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit8ActionPerformed(evt);
            }
        });

        jbtnDigit7.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit7.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit7.setText("7");
        jbtnDigit7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit7ActionPerformed(evt);
            }
        });

        jbtnDigit4.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit4.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit4.setText("4");
        jbtnDigit4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit4ActionPerformed(evt);
            }
        });

        jbtnDigit1.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit1.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit1.setText("1");
        jbtnDigit1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit1ActionPerformed(evt);
            }
        });

        jbtnDigit0.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit0.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit0.setText("0");
        jbtnDigit0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit0ActionPerformed(evt);
            }
        });

        jbtnDot.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDot.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDot.setText(".");
        jbtnDot.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDotActionPerformed(evt);
            }
        });

        jbtnDigit2.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit2.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit2.setText("2");
        jbtnDigit2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit2ActionPerformed(evt);
            }
        });

        jbtnDigit5.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit5.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit5.setText("5");
        jbtnDigit5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit5ActionPerformed(evt);
            }
        });

        jbtnDigit6.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit6.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit6.setText("6");
        jbtnDigit6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit6ActionPerformed(evt);
            }
        });

        jbtnDigit3.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDigit3.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDigit3.setText("3");
        jbtnDigit3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDigit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDigit3ActionPerformed(evt);
            }
        });

        jbtnEquals.setBackground(new java.awt.Color(204, 204, 204));
        jbtnEquals.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnEquals.setText("=");
        jbtnEquals.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEqualsActionPerformed(evt);
            }
        });

        jbtnDiv.setBackground(new java.awt.Color(204, 204, 204));
        jbtnDiv.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnDiv.setText("÷");
        jbtnDiv.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDivActionPerformed(evt);
            }
        });

        jbtnMult.setBackground(new java.awt.Color(204, 204, 204));
        jbtnMult.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnMult.setText("*");
        jbtnMult.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMultActionPerformed(evt);
            }
        });

        jbtnMinus.setBackground(new java.awt.Color(204, 204, 204));
        jbtnMinus.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtnMinus.setText("-");
        jbtnMinus.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMinusActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 255, 0));
        jTextField1.setText("Simple Calculator");
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jbtSqu.setBackground(new java.awt.Color(204, 204, 204));
        jbtSqu.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtSqu.setText("^2");
        jbtSqu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtSqu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSquActionPerformed(evt);
            }
        });

        jbtRoot.setBackground(new java.awt.Color(204, 204, 204));
        jbtRoot.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtRoot.setText("√");
        jbtRoot.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRootActionPerformed(evt);
            }
        });

        jbtNeg.setBackground(new java.awt.Color(204, 204, 204));
        jbtNeg.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtNeg.setText("(-)");
        jbtNeg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtNeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNegActionPerformed(evt);
            }
        });

        jbtRep.setBackground(new java.awt.Color(204, 204, 204));
        jbtRep.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtRep.setText("reciprocal");
        jbtRep.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRepActionPerformed(evt);
            }
        });

        jbtMod.setBackground(new java.awt.Color(204, 204, 204));
        jbtMod.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtMod.setText("%");
        jbtMod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtModActionPerformed(evt);
            }
        });

        jbtFac.setBackground(new java.awt.Color(204, 204, 204));
        jbtFac.setFont(new java.awt.Font("Source Code Pro", 1, 18)); // NOI18N
        jbtFac.setText("n!");
        jbtFac.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbtFac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFacActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtnDigit0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtFac, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtnDigit1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnDigit2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnDigit3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbtnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbtnCe, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbtnPM, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jbtnDigit7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbtnDigit8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbtnDigit9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jbtnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtSqu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtnDigit4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnDigit5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnDigit6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jbtnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtxtResult)
                    .addComponent(jbtRep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCe, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnPM, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtMod, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnDigit7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDigit8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDigit9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtSqu, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnDigit4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDigit5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDigit6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnDigit1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDigit2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDigit3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtNeg, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnDigit0, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtFac, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtRep, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterNumbers(String q){
    String Nums = jtxtResult.getText() + q;
    jtxtResult.setText(Nums);
    }
    
    private void jbtnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCActionPerformed
jtxtResult.setText("");        
    }//GEN-LAST:event_jbtnCActionPerformed

    private void jbtnPMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPMActionPerformed
double nums = Double.parseDouble(String.valueOf(jtxtResult.getText()));
nums = nums * (-1);
jtxtResult.setText(String.valueOf(nums));
    }//GEN-LAST:event_jbtnPMActionPerformed

    private void jbtnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDelActionPerformed
String delete = null;
if(jtxtResult.getText().length() > 0) {
StringBuilder sb = new StringBuilder(jtxtResult.getText());
sb.deleteCharAt(jtxtResult.getText().length() - 1);
delete = sb.toString();
jtxtResult.setText(delete);
}
    }//GEN-LAST:event_jbtnDelActionPerformed

    private void jbtnDigit7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit7ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("7")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit7ActionPerformed

    private void jbtnDigit8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit8ActionPerformed
 String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("8")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }       
    }//GEN-LAST:event_jbtnDigit8ActionPerformed

    private void jbtnDigit9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit9ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("9")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit9ActionPerformed

    private void jbtnDigit4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit4ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("4")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit4ActionPerformed

    private void jbtnDigit5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit5ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("5")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit5ActionPerformed

    private void jbtnDigit6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit6ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("6")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit6ActionPerformed

    private void jbtnDigit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit1ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("1")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit1ActionPerformed

    private void jbtnDigit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit2ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("2")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit2ActionPerformed

    private void jbtnDigit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit3ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("3")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit3ActionPerformed

    private void jbtnDigit0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDigit0ActionPerformed
String digit = ((JButton)evt.getSource()).getText();
    String currentText = jtxtResult.getText();
    if (currentText.equals("0")) { 
        jtxtResult.setText(digit);
    } else { 
        jtxtResult.setText(currentText + digit);
    }        
    }//GEN-LAST:event_jbtnDigit0ActionPerformed

    private void jbtnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDivActionPerformed
num1 = Double.parseDouble(jtxtResult.getText());
jtxtResult.setText("");
op = "÷";
    }//GEN-LAST:event_jbtnDivActionPerformed

    private void jbtnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMultActionPerformed
num1 = Double.parseDouble(jtxtResult.getText());
jtxtResult.setText("");
op = "*";        
    }//GEN-LAST:event_jbtnMultActionPerformed

    private void jbtnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMinusActionPerformed
num1 = Double.parseDouble(jtxtResult.getText());
jtxtResult.setText("");
op = "-";        
    }//GEN-LAST:event_jbtnMinusActionPerformed

    private void jbtnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPlusActionPerformed
num1 = Double.parseDouble(jtxtResult.getText());
jtxtResult.setText("");
op = "+";        
    }//GEN-LAST:event_jbtnPlusActionPerformed

    private void jbtnCeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCeActionPerformed
jtxtResult.setText("");
String firstNum, secondNum;
firstNum = String.valueOf(num1);
secondNum = String.valueOf(num2);
firstNum = ""; 
secondNum = "";
    }//GEN-LAST:event_jbtnCeActionPerformed

    private void jbtnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDotActionPerformed
if(!jtxtResult.getText().contains(".")) {
jtxtResult.setText(jtxtResult.getText() + jbtnDot.getText());
}        
    }//GEN-LAST:event_jbtnDotActionPerformed

    private void jbtnEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEqualsActionPerformed
num2 = Double.parseDouble(jtxtResult.getText());
switch(op) {
    case"+": result = num1 + num2; jtxtResult.setText(String.valueOf(result)); break;
    case"-": result = num1 - num2; jtxtResult.setText(String.valueOf(result)); break;
    case"*": result = num1 * num2; jtxtResult.setText(String.valueOf(result)); break;
    case"%": result = num1 % num2; jtxtResult.setText(String.valueOf(result)); break;
    case"÷": if(num2 !=0) {
        result = num1 / num2;
    jtxtResult.setText(String.valueOf(result));
    } else {
    jtxtResult.setText("Error: Cannot divide by zero");
    jtxtResult.setForeground(Color.RED);
    jtxtResult.setFont(new Font("Arial", Font.BOLD, 16));
    }
    break;
}
    }//GEN-LAST:event_jbtnEqualsActionPerformed

    private void jtxtResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtResultActionPerformed
        
    }//GEN-LAST:event_jtxtResultActionPerformed

    private void jbtSquActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSquActionPerformed
 double num = Double.parseDouble(jtxtResult.getText());
    double square = num * num;
    jtxtResult.setText(String.valueOf(square));        
    }//GEN-LAST:event_jbtSquActionPerformed

    private void jbtRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRootActionPerformed
double num = Double.parseDouble(jtxtResult.getText());
    double squareRoot = Math.sqrt(num);
    jtxtResult.setText(String.valueOf(squareRoot));        
    }//GEN-LAST:event_jbtRootActionPerformed

    private void jbtNegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNegActionPerformed
double num = Double.parseDouble(jtxtResult.getText());
    double negative = -num;
    jtxtResult.setText(String.valueOf(negative));        
    }//GEN-LAST:event_jbtNegActionPerformed

    private void jbtRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRepActionPerformed
 double num = Double.parseDouble(jtxtResult.getText());
    double reciprocal = 1 / num;
    jtxtResult.setText(String.valueOf(reciprocal));        
    }//GEN-LAST:event_jbtRepActionPerformed

    private void jbtModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtModActionPerformed
num1 = Double.parseDouble(jtxtResult.getText());
    jtxtResult.setText("");
    op = "%";        
    }//GEN-LAST:event_jbtModActionPerformed

    private void jbtFacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFacActionPerformed
int num = Integer.parseInt(jtxtResult.getText());
    int factorial = 1;
    for (int i = 1; i <= num; i++) {
        factorial *= i;
    }
    jtxtResult.setText(String.valueOf(factorial));        
    }//GEN-LAST:event_jbtFacActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimpleCalculatorFinal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtFac;
    private javax.swing.JButton jbtMod;
    private javax.swing.JButton jbtNeg;
    private javax.swing.JButton jbtRep;
    private javax.swing.JButton jbtRoot;
    private javax.swing.JButton jbtSqu;
    private javax.swing.JButton jbtnC;
    private javax.swing.JButton jbtnCe;
    private javax.swing.JButton jbtnDel;
    private javax.swing.JButton jbtnDigit0;
    private javax.swing.JButton jbtnDigit1;
    private javax.swing.JButton jbtnDigit2;
    private javax.swing.JButton jbtnDigit3;
    private javax.swing.JButton jbtnDigit4;
    private javax.swing.JButton jbtnDigit5;
    private javax.swing.JButton jbtnDigit6;
    private javax.swing.JButton jbtnDigit7;
    private javax.swing.JButton jbtnDigit8;
    private javax.swing.JButton jbtnDigit9;
    private javax.swing.JButton jbtnDiv;
    private javax.swing.JButton jbtnDot;
    private javax.swing.JButton jbtnEquals;
    private javax.swing.JButton jbtnMinus;
    private javax.swing.JButton jbtnMult;
    private javax.swing.JButton jbtnPM;
    private javax.swing.JButton jbtnPlus;
    private javax.swing.JTextField jtxtResult;
    // End of variables declaration//GEN-END:variables
}
