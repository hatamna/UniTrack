
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yahya
 */
public class CourseScreen extends javax.swing.JFrame {

    private String[] codeLine;
    private String[] weightLine;
    private String[] gradeLine;
    private int weightSum;
    private int weightedGradeSum;
    private int[][] coords;
    
    public static int courseNumber;
    
    public int getNameNum(){
        switch (courseNumber){
            case 1: 
                return 2;
            case 2:
                return 8;
            case 3:
                return 14;
            case 4:
                return 20;
            case 5:
                return 26;
            case 6:
                return 32;
        }
        return 0;
    }
    
    public void setOGtext(String un) throws IOException{
        gradeLine = Files.readAllLines(Paths.get("" + un + ".txt")).get(getNameNum()+4).split(" ");
        weightLine = Files.readAllLines(Paths.get("" + un + ".txt")).get(getNameNum()+3).split(" ");
        codeLine = Files.readAllLines(Paths.get("" + un + ".txt")).get(getNameNum()+2).split(" ");
        initComponents();
        CourseNameLabel.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(getNameNum()));

        updateJTextAreaContents();
    }
    
    
    
    public void setCodeAreaText(){
        
    }
    
    public CourseScreen() throws IOException {
       try {
        setOGtext(User.username);
    } catch (IndexOutOfBoundsException e) {
        setOGtext(SignInScreen.username);
    }

    
    codeArea.setText("");
    percentArea.setText("");
    weightArea.setText("");

    
    for (String i : codeLine) {
        codeArea.append(i + "\n");
    }
    for (String i : gradeLine) {
        percentArea.append(i + "\n");
    }
    for (String i : weightLine) {
        weightArea.append(i + "\n");
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CourseNameLabel = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codeArea = new javax.swing.JTextArea();
        percentArea = new javax.swing.JTextArea();
        weightArea = new javax.swing.JTextArea();
        CodeField = new javax.swing.JTextField();
        PercentField = new javax.swing.JTextField();
        WeightField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        percentSignLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 128));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        CourseNameLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        CourseNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        CourseNameLabel.setText("COURSE");

        ExitButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ExitButton.setText("Back");
        ExitButton.setBorder(null);
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WEIGHT");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CODE");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PERCENTAGE");

        codeArea.setBackground(new java.awt.Color(0, 0, 128));
        codeArea.setColumns(20);
        codeArea.setForeground(new java.awt.Color(255, 255, 255));
        codeArea.setRows(5);

        percentArea.setBackground(new java.awt.Color(0, 0, 128));
        percentArea.setColumns(20);
        percentArea.setForeground(new java.awt.Color(255, 255, 255));
        percentArea.setRows(5);

        weightArea.setBackground(new java.awt.Color(0, 0, 128));
        weightArea.setColumns(20);
        weightArea.setForeground(new java.awt.Color(255, 255, 255));
        weightArea.setRows(5);

        CodeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodeFieldActionPerformed(evt);
            }
        });

        PercentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PercentFieldActionPerformed(evt);
            }
        });

        WeightField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeightFieldActionPerformed(evt);
            }
        });

        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        percentSignLabel.setForeground(new java.awt.Color(255, 255, 255));
        percentSignLabel.setText("%");

        jLabel1.setText("Total:");

        jLabel6.setText("99.99%");

        jLabel7.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(159, 159, 159)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addComponent(jLabel7))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(CourseNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(CodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(PercentField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(percentSignLabel)
                                .addGap(107, 107, 107))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(codeArea, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(percentArea, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(WeightField)
                            .addComponent(weightArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(AddButton)
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ExitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CourseNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(percentArea, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                            .addComponent(weightArea))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(codeArea)
                        .addGap(34, 34, 34)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(percentSignLabel)
                        .addComponent(PercentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(WeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddButton))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        MainScreen screen;
        try {
            screen = new MainScreen();
            screen.setVisible(true);
            screen.toFront();
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(CourseScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void WeightFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeightFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WeightFieldActionPerformed

    private void CodeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodeFieldActionPerformed

    private void PercentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PercentFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PercentFieldActionPerformed

    
    private void updateJTextAreaContents() {
    // Clear existing text
    codeArea.setText("");
    percentArea.setText("");
    weightArea.setText("");

    // Display original values read from file
    for (String code : codeLine) {
        codeArea.append(code + "\n");
    }
    for (String percent : gradeLine) {
        percentArea.append(percent + "\n");
    }
    for (String weight : weightLine) {
        weightArea.append(weight + "\n");
    }

    // Display manually added values
    for (String code : ManualAddSpecifics.codes) {
        codeArea.append(code + "\n");
    }
    for (Double percent : ManualAddSpecifics.percents) {
        percentArea.append(percent.toString() + "\n");
    }
    for (Integer weight : ManualAddSpecifics.weights) {
        weightArea.append(weight.toString() + "\n");
    }
}
    
    
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
         try {
        // Add values to the lists
        ManualAddSpecifics.codes.add(CodeField.getText());
        ManualAddSpecifics.percents.add(Double.parseDouble(PercentField.getText()));
        ManualAddSpecifics.weights.add(Integer.parseInt(WeightField.getText()));

        // Clear text fields after adding values
        CodeField.setText("");
        PercentField.setText("");
        WeightField.setText("");

        // Clear JTextAreas
        codeArea.setText("");
        percentArea.setText("");
        weightArea.setText("");

        // Reprint entire lists to JTextAreas
        for (String code : ManualAddSpecifics.codes) {
            codeArea.append(code + "\n");
        }
        for (Double percent : ManualAddSpecifics.percents) {
            percentArea.append(percent.toString() + "\n");
        }
        for (Integer weight : ManualAddSpecifics.weights) {
            weightArea.append(weight.toString() + "\n");
        }
    } catch (NumberFormatException e) {
        System.out.println("Error parsing input.");
    }

         
         
    }//GEN-LAST:event_AddButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CourseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CourseScreen().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(CourseScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField CodeField;
    private javax.swing.JLabel CourseNameLabel;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField PercentField;
    private javax.swing.JTextField WeightField;
    private javax.swing.JTextArea codeArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextArea percentArea;
    private javax.swing.JLabel percentSignLabel;
    private javax.swing.JTextArea weightArea;
    // End of variables declaration//GEN-END:variables
}
