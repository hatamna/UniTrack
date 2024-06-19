/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Dimension;
import java.awt.Point;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Yahya
 */
public class ManualAddSpecifics extends javax.swing.JFrame {
    
    public static String[] HSCourses = Arrays.stream(uniInfo.HSCourses).toArray(String[]::new);
    public static ArrayList<String> codes = new ArrayList<>();
    public static ArrayList<Double> percents = new ArrayList<>();
    public static ArrayList<Integer> weights = new ArrayList<>();
    public static HashMap<String, String> course_Avg = new HashMap<>();
    
    public static double perweightSum = 0;
    public static int weightSum = 0;
    public static double grade;
    public static String courseName = null;
    public static String oldCourse = null;
    
    private static int addCount = 0;
    
    private static double thisAvg = 0.00;
    private static int totalWeight = 0;
    
    
    public static int added = 0;
    
    public void printResults(){
        codeLabel.setText(codeLabel.getText() + "\n" + CodeField.getText());
        percentLabel.setText(percentLabel.getText() + "\n" + PercentField.getText());
        weightLabel.setText(weightLabel.getText() + "\n" + WeightField.getText());
    }

     public ManualAddSpecifics() {
        initComponents();
        thisAvg = 0;
        totalWeight = 0;
        codes.clear();
        percents.clear();
        weights.clear();
        maxMSG.setVisible(false);
        CourseCodeDropDown.removeAllItems();
        for (String i : HSCourses){
            CourseCodeDropDown.addItem(i);
        }

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CourseCode = new javax.swing.JLabel();
        CourseCodeDropDown = new javax.swing.JComboBox<>();
        CourseCode1 = new javax.swing.JLabel();
        currentAverageInput = new javax.swing.JTextField();
        CourseCode2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CodeField = new javax.swing.JTextField();
        PercentField = new javax.swing.JTextField();
        WeightField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        percentSignLabel = new javax.swing.JLabel();
        weightLabel = new javax.swing.JTextPane();
        codeLabel = new javax.swing.JTextPane();
        percentLabel = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        CAinfo = new javax.swing.JButton();
        maxMSG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 128));

        CourseCode.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CourseCode.setForeground(new java.awt.Color(255, 255, 255));
        CourseCode.setText("Course Code:");

        CourseCodeDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course" }));
        CourseCodeDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseCodeDropDownActionPerformed(evt);
            }
        });

        CourseCode1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CourseCode1.setForeground(new java.awt.Color(255, 255, 255));
        CourseCode1.setText("Current Average (Optional):");

        currentAverageInput.setText("Enter Average");
        currentAverageInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                currentAverageInputMouseClicked(evt);
            }
        });
        currentAverageInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentAverageInputActionPerformed(evt);
            }
        });

        CourseCode2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CourseCode2.setForeground(new java.awt.Color(255, 255, 255));
        CourseCode2.setText("Add Grades:");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Code");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Percentage");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Weight");

        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        nextButton.setText("NEXT");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        percentSignLabel.setForeground(new java.awt.Color(255, 255, 255));
        percentSignLabel.setText("%");

        weightLabel.setBackground(new java.awt.Color(0, 5, 128));
        weightLabel.setBorder(null);
        weightLabel.setForeground(new java.awt.Color(255, 255, 255));
        weightLabel.setSelectedTextColor(new java.awt.Color(0, 0, 128));

        codeLabel.setBackground(new java.awt.Color(0, 0, 128));
        codeLabel.setBorder(null);
        codeLabel.setForeground(new java.awt.Color(255, 255, 255));

        percentLabel.setBackground(new java.awt.Color(0, 0, 128));
        percentLabel.setBorder(null);
        percentLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Input the values and press add:");

        CAinfo.setText("?");
        CAinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAinfoActionPerformed(evt);
            }
        });

        maxMSG.setForeground(new java.awt.Color(255, 51, 51));
        maxMSG.setText("Maximum number of assignments added.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(maxMSG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(134, 134, 134)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(PercentField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(percentSignLabel))
                                    .addComponent(percentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(184, 184, 184)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(WeightField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, Short.MAX_VALUE)
                                        .addGap(81, 81, 81)
                                        .addComponent(AddButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(weightLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CourseCode)
                                        .addGap(18, 18, 18)
                                        .addComponent(CourseCodeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CourseCode2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CourseCode1)
                                        .addGap(12, 12, 12)
                                        .addComponent(currentAverageInput, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CAinfo)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(56, 56, 56))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CourseCode)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(CourseCodeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CourseCode1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(currentAverageInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CAinfo))))
                .addGap(17, 17, 17)
                .addComponent(CourseCode2)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(percentLabel)
                    .addComponent(weightLabel))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PercentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(percentSignLabel))
                    .addComponent(WeightField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(nextButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(maxMSG)))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(814, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CourseCodeDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseCodeDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseCodeDropDownActionPerformed

    private void currentAverageInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentAverageInputActionPerformed
        
    }//GEN-LAST:event_currentAverageInputActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        if (addCount < 100){
            try{
                percents.add(parseDouble(PercentField.getText()));
                weights.add(parseInt(WeightField.getText()));
                codes.add(CodeField.getText());
            } catch (NumberFormatException e){
                System.out.println("Error.");
            }
            printResults();
            addCount++;
            thisAvg += Double.parseDouble(PercentField.getText())* Integer.parseInt(WeightField.getText());
            totalWeight += Integer.parseInt(WeightField.getText());
            CodeField.setText("");
            PercentField.setText("");
            WeightField.setText("");
        } else {
            AddButton.setEnabled(false);
            maxMSG.setVisible(true);
        }       
    }//GEN-LAST:event_AddButtonActionPerformed

    private void currentAverageInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_currentAverageInputMouseClicked
        currentAverageInput.setText("");
    }//GEN-LAST:event_currentAverageInputMouseClicked

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        /*for (int i = 0; i < percents.size() && i < weights.size(); i++){
            perweightSum = perweightSum + (percents.get(i)*weights.get(i));
            weightSum = weightSum + weights.get(i);  
        }
        
        grade = perweightSum / weightSum;
        courseName = (String)CourseCodeDropDown.getSelectedItem();
        course_Avg.put(courseName, (String.format("%.2f", grade)));
        */
        if (CourseCodeDropDown.getSelectedItem().equals("Select Course")){
            nextButton.setText("Please Choose a Course");
        }
        else {
            if (!AddClassScreen.courseNames[UniTrack.universalNum].equals("Add Class")){
                ArrayList<String> list = new ArrayList<String>(Arrays.asList(HSCourses));
                oldCourse = AddClassScreen.courseNames[UniTrack.universalNum];
                AddClassScreen.courseNames[UniTrack.universalNum] = String.valueOf(CourseCodeDropDown.getSelectedItem());
                list.removeAll(Arrays.asList(CourseCodeDropDown.getSelectedItem()));
                list.add(oldCourse);
                HSCourses  = list.toArray(HSCourses);
                UniTrack.universalNum += 1;
            }
            else{
                AddClassScreen.courseNames[UniTrack.universalNum] = String.valueOf(CourseCodeDropDown.getSelectedItem());
                ArrayList<String> list = new ArrayList<String>(Arrays.asList(HSCourses));
                list.removeAll(Arrays.asList(CourseCodeDropDown.getSelectedItem()));
                HSCourses  = list.toArray(HSCourses);
                UniTrack.universalNum += 1;
            }
            
            
        String poopoo = "";
        for (String i : codes){
            poopoo += i+" ";
        }
        String poopoo2 ="";
        for(double j : percents){
            poopoo2+=j+" ";
        }
        String poopoo3=" ";
        for(int k:weights){
            poopoo3+=k+" ";
        }

        try{
            FileWriter writer = new FileWriter("" + User.username + ".txt", true);
            writer.write("\n" + UniTrack.universalNum + "\n" + CourseCodeDropDown.getSelectedItem() + "\n" + String.format("%.2f", thisAvg/totalWeight) + "\n" + poopoo + "\n" + poopoo2 + "\n" + poopoo3);
            writer.close();
        } catch (IOException a){
            System.out.println("An error has occured. ");
        }
            addCount = 0;
            AddClassScreen screen = new AddClassScreen();
            screen.setVisible(true);
            screen.toFront();
            dispose();
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void CAinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAinfoActionPerformed
        JOptionPane.showMessageDialog(this.CAinfo, "Writing in this box is optional. This overrides the calculation the app does to calculate the\naverage in case you grade has been changed and the grades do not reflect it.");
    }//GEN-LAST:event_CAinfoActionPerformed

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
            java.util.logging.Logger.getLogger(ManualAddSpecifics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManualAddSpecifics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManualAddSpecifics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManualAddSpecifics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManualAddSpecifics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CAinfo;
    private javax.swing.JTextField CodeField;
    private javax.swing.JLabel CourseCode;
    private javax.swing.JLabel CourseCode1;
    private javax.swing.JLabel CourseCode2;
    public static javax.swing.JComboBox<String> CourseCodeDropDown;
    private javax.swing.JTextField PercentField;
    private javax.swing.JTextField WeightField;
    private javax.swing.JTextPane codeLabel;
    private javax.swing.JTextField currentAverageInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel maxMSG;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextPane percentLabel;
    private javax.swing.JLabel percentSignLabel;
    private javax.swing.JTextPane weightLabel;
    // End of variables declaration//GEN-END:variables
/*
                JPanel grades = new JPanel();
                ArrayList<JLabel[]> cancer = new ArrayList<>();
                JLabel[] labels = {new JLabel(PercentField.getText()), new JLabel(WeightField.getText()), new JLabel(CodeField.getText())};
                cancer.add(labels);
                for(JLabel[] x: cancer){
                    grades.add(x[0]);
                    grades.add(x[1]);
                    grades.add(x[2]);
                }
                grades.location().x = CodeField.location().x;
                grades.location().y = CodeField.location().y - 30; //FIX
                grades.setVisible(true);
                JLayeredPane bruder = new JLayeredPane();
                jPanel1.setVisible(false);
                grades.setOpaque(false);
                bruder.add(grades, JLayeredPane.DEFAULT_LAYER);
                bruder.add(jPanel1, JLayeredPane.PALETTE_LAYER);
                revalidate();
                repaint();*/
}
