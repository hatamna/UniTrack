
import java.awt.Canvas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.swing.JFrame;

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
    private User user;
    private UniCourse course;
    
    
    public void setCodeAreaText(){
        
    }
    
    public CourseScreen(User u, UniCourse c) throws IOException {
        user=u;
        course=c;
        initComponents();
        CourseNameLabel.setText(course.getName());
        updateJTextAreaContents();
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
        graphView = new javax.swing.JButton();

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
        ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backButton.png"))); // NOI18N
        ExitButton.setBorder(null);
        ExitButton.setContentAreaFilled(false);
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
        codeArea.setOpaque(false);
        codeArea.setRequestFocusEnabled(false);

        percentArea.setBackground(new java.awt.Color(0, 0, 128));
        percentArea.setColumns(20);
        percentArea.setForeground(new java.awt.Color(255, 255, 255));
        percentArea.setRows(5);
        percentArea.setOpaque(false);
        percentArea.setRequestFocusEnabled(false);

        weightArea.setBackground(new java.awt.Color(0, 0, 128));
        weightArea.setColumns(20);
        weightArea.setForeground(new java.awt.Color(255, 255, 255));
        weightArea.setRows(5);
        weightArea.setOpaque(false);
        weightArea.setRequestFocusEnabled(false);

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

        graphView.setText("Graph View");
        graphView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphViewActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(graphView)
                .addGap(18, 18, 18)
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
                            .addComponent(percentArea, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
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
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AddButton)
                        .addComponent(graphView)))
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
            screen = new MainScreen(user);
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
        UniAssignment ass;
        for(int x=0; x<=course.getAssignments().size()-1;x++){
            ass = course.getAssignments().get(x);
            codeArea.setText(codeArea.getText()+(ass.getName()+"\n"));
            percentArea.setText(percentArea.getText()+(ass.getGrade()+"\n"));
            weightArea.setText(weightArea.getText()+(ass.getWeight()+"\n"));
        }
        jLabel6.setText(String.format("%.2f", (course.updateAverage())));
        jLabel7.setText(String.valueOf(course.getWeight()));
        revalidate();
        repaint();
    }
    
    
    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String code = CodeField.getText().trim();
        String percent = PercentField.getText().trim();
        String weight = WeightField.getText().trim();

        if (!code.isEmpty() && !percent.isEmpty() && !weight.isEmpty()) {
            course.addAssignment(new UniAssignment(code,parseDouble(percent), parseInt(weight)));
        } else {
            AddButton.setText("Fill All Fields");
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void graphViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphViewActionPerformed
    JFrame graphFrame = new JFrame();
        graphFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Canvas for drawing
        Canvas graphCanvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g); // Clear the canvas
                
                int[] coordsX = new int[course.getAssignments().size()-1];
                int[] coordsY = new int[course.getAssignments().size()-1];
                
                for (int x = 0; x < course.getAssignments().size()-1; x++) {
                    weightSum = 0;
                    weightedGradeSum = 0;
                    
                    for (int y = 0; y < x; y++) {
                        try {
                            weightSum += course.getAssignments().get(y).getWeight();
                            weightedGradeSum += course.getAssignments().get(y).getWeight() * course.getAssignments().get(y).getWeight();
                        } catch (NumberFormatException ex) {
                            Logger.getLogger(CourseScreen.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    if (weightSum == 0) continue;
                    
                    int xPos = 50 + 50 * x; // Adjust the x position based on your needs
                    int yPos = 300 - weightedGradeSum / weightSum; // Adjust the y position based on your needs
                    
                    coordsX[x] = xPos;
                    coordsY[x] = yPos;
                    
                    g.setColor(Color.RED);
                    g.fillOval(xPos, yPos, 5, 5); // Adjust the size of the oval
                }
                
                g.setColor(Color.BLUE);
                for (int z = 0; z < coordsX.length-1; z++) {
                    g.drawLine(coordsX[z], coordsY[z], coordsX[z + 1], coordsY[z + 1]);
                }
            }
        };
        
        graphFrame.add(graphCanvas);
        graphCanvas.setPreferredSize(new Dimension(600, 400)); // Set the preferred size of the canvas
        graphFrame.pack(); // Pack the frame to fit the canvas
        graphFrame.setLocationRelativeTo(null);
        graphFrame.setVisible(true);
    }//GEN-LAST:event_graphViewActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField CodeField;
    private javax.swing.JLabel CourseNameLabel;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField PercentField;
    private javax.swing.JTextField WeightField;
    private javax.swing.JTextArea codeArea;
    private javax.swing.JButton graphView;
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
