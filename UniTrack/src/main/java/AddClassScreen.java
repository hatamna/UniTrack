import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AddClassScreen extends javax.swing.JFrame {
    public ArrayList<String> mandatoryCourses = new ArrayList();
    public String programName = null;
    public JLabel[] labels;
    private User user;

    private String university;
    private String program;

    public static String one = "Add Class";
    public static String two = "Add Class";
    public static String three = "Add Class";
    public static String four = "Add Class";
    public static String five = "Add Class";
    public static String six = "Add Class";
        
    public void openSpecifics(int num){
        ManualAddSpecifics screen = new ManualAddSpecifics(user, num);
        screen.setVisible(true);
        screen.toFront();
        dispose();
    }

    public AddClassScreen(User u){
        user=u;
        initComponents();
        labels = new JLabel[]{jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};
        for (String i: UniTrack.getUniversityNames()){
            uniDropDown.addItem(i);
        }
        for (Program i: UniTrack.getUniversities()[0].getPrograms()){
            programDropDown.addItem(i.getName());
        }
        if (university != null && program != null) {
            uniDropDown.setSelectedItem(university);
            programDropDown.setSelectedItem(program);
        }

        for (int i = 0; i < user.getCourseNames().size()-1; i++) {
            String courseName = user.getCourseNames().get(i);
            JButton button = null;
            switch (i) {
                case 0:
                    button = AddButton1;
                    one = courseName;
                    //UniTrack.getTop6Courses()[i] = courseName;
                    break;
                case 1:
                    button = AddButton2;
                    //UniTrack.getTop6Courses()[i] = courseName;
                    two = courseName;
                    break;
                case 2:
                    button = AddButton3;
                    //UniTrack.getTop6Courses()[i] = courseName;
                    three = courseName;
                    break;
                case 3:
                    button = AddButton4;
                    four = courseName;
                    //UniTrack.getTop6Courses()[i] = courseName;
                    break;
                case 4:
                    button = AddButton5;
                    //UniTrack.getTop6Courses()[i] = courseName;
                    five = courseName;
                    break;
                case 5:
                    button = AddButton6;
                    //UniTrack.getTop6Courses()[i] = courseName;
                    six = courseName;
                    break;
            }

            if (button != null) {
                button.setText(courseName);
            }
        }
    }
    
    public void choiceTrack() {
        String universityName = String.valueOf(uniDropDown.getSelectedItem());
        String programName = String.valueOf(programDropDown.getSelectedItem());

        University university = UniTrack.getUniversity(universityName);
        if (university == null) {
            System.out.println("Error: Invalid university selected.");
            return;
        }

        Program selectedProgram = null;
        for (Program program : university.getPrograms()) {
            if (program.getName().equals(programName)) {
                selectedProgram = program;
                break;
            }
        }

        if (selectedProgram == null) {
            System.out.println("Error: Invalid program selected for " + universityName + ".");
            return;
        }

        mandatoryCourses.clear();
        for (String course : selectedProgram.getRequiredCourses()) {
            mandatoryCourses.add(course);
        }

        for (int j = 0; j < labels.length-1; j++) {
            if (j < mandatoryCourses.size()-1) {
                labels[j].setVisible(true);
                labels[j].setText(mandatoryCourses.get(j));
            } else {
                labels[j].setVisible(false);
            }
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
        nextButton = new javax.swing.JButton();
        programDropDown = new javax.swing.JComboBox<>();
        uniDropDown = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        AddButton1 = new javax.swing.JButton();
        AddButton2 = new javax.swing.JButton();
        AddButton3 = new javax.swing.JButton();
        AddButton4 = new javax.swing.JButton();
        AddButton5 = new javax.swing.JButton();
        AddButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 128));

        nextButton.setText("NEXT");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        programDropDown.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                programDropDownMouseMoved(evt);
            }
        });
        programDropDown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                programDropDownMouseClicked(evt);
            }
        });
        programDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programDropDownActionPerformed(evt);
            }
        });

        uniDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniDropDownActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        AddButton1.setText("Add Class");
        AddButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton1ActionPerformed(evt);
            }
        });

        AddButton2.setText("Add Class");
        AddButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton2ActionPerformed(evt);
            }
        });

        AddButton3.setText("Add Class");
        AddButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton3ActionPerformed(evt);
            }
        });

        AddButton4.setText("Add Class");
        AddButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton4ActionPerformed(evt);
            }
        });

        AddButton5.setText("Add Class");
        AddButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton5ActionPerformed(evt);
            }
        });

        AddButton6.setText("Add Class");
        AddButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(171, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddButton6)
                            .addComponent(AddButton5))
                        .addGap(99, 99, 99))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(AddButton1))
                    .addComponent(programDropDown, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uniDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(346, 346, 346))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(357, 357, 357)
                        .addComponent(AddButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nextButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(151, 151, 151))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AddButton1)
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddButton2)
                            .addComponent(AddButton6))
                        .addGap(25, 25, 25)
                        .addComponent(programDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)))
                .addComponent(uniDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton3)
                    .addComponent(AddButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(AddButton4)
                .addGap(88, 88, 88)
                .addComponent(nextButton)
                .addContainerGap())
        );

        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);

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

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
         if (user.isValidAmount()) {
            nextButton.setText("ENTER AT LEAST 6 COURSES");
            return;
        }

        if (!mandatoryCourses.isEmpty()) {
            boolean allMandatorySelected = true;
            for (String course : mandatoryCourses) {
                boolean found = false;
                for (String selectedCourse : user.getCourseNames()) {
                    if (selectedCourse.equals(course)) {
                    found = true;
                    break;
                    }
                }
                if (!found) {
                allMandatorySelected = false;
                break;
                }
            }
            if (!allMandatorySelected) {
                nextButton.setText("SELECT ALL MANDATORY COURSES");
                return;
            }
        }   
        //String[] top6Courses = UniTrack.getTop6();  

        MainScreen screen;
        try {
            screen = new MainScreen(user);
            screen.setVisible(true);
            screen.toFront();
            dispose();
        } 
        catch (IOException ex) {
            Logger.getLogger(AddClassScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void programDropDownMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programDropDownMouseMoved
      
    }//GEN-LAST:event_programDropDownMouseMoved

    private void programDropDownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programDropDownMouseClicked

    }//GEN-LAST:event_programDropDownMouseClicked

    private void programDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programDropDownActionPerformed
        choiceTrack();
    }//GEN-LAST:event_programDropDownActionPerformed

    private void uniDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniDropDownActionPerformed
        choiceTrack();
    }//GEN-LAST:event_uniDropDownActionPerformed

    private void AddButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton1ActionPerformed
        if (!AddButton1.equals("Add Class")){
            //ManualAddSpecifics.setOldCourse(AddButton1.getText());
        }
        openSpecifics(0);

    }//GEN-LAST:event_AddButton1ActionPerformed

    private void AddButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton2ActionPerformed
        if (!AddButton2.equals("Add Class")){
            //ManualAddSpecifics.setOldCourse(AddButton1.getText());
        }
        openSpecifics(1);

    }//GEN-LAST:event_AddButton2ActionPerformed

    private void AddButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton3ActionPerformed
    if (!AddButton3.equals("Add Class")){
            //ManualAddSpecifics.setOldCourse(AddButton1.getText());
        }       
        openSpecifics(2);

    }//GEN-LAST:event_AddButton3ActionPerformed

    private void AddButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton4ActionPerformed
        if (!AddButton4.equals("Add Class")){
            //ManualAddSpecifics.setOldCourse(AddButton1.getText());
        }       
        openSpecifics(3);

    }//GEN-LAST:event_AddButton4ActionPerformed

    private void AddButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton5ActionPerformed
        if (!AddButton5.equals("Add Class")){
            //ManualAddSpecifics.setOldCourse(AddButton1.getText());
        }
        openSpecifics(4);
    }//GEN-LAST:event_AddButton5ActionPerformed

    private void AddButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButton6ActionPerformed
    if (!AddButton6.equals("Add Class")){
            //ManualAddSpecifics.setOldCourse(AddButton1.getText());
        }       
        openSpecifics(5);
    }//GEN-LAST:event_AddButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton1;
    private javax.swing.JButton AddButton2;
    private javax.swing.JButton AddButton3;
    private javax.swing.JButton AddButton4;
    private javax.swing.JButton AddButton5;
    private javax.swing.JButton AddButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox<String> programDropDown;
    private javax.swing.JComboBox<String> uniDropDown;
    // End of variables declaration//GEN-END:variables
}
