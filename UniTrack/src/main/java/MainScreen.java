
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yahya
 */
public class MainScreen extends javax.swing.JFrame {
    public JLabel[] top6;
    public JLabel[] avgLabels;
    public ArrayList<String> avgValues = new ArrayList();
    public double CurrentAverage = 0.00;
    
    private int x = 0;
    
    public void setButtonText(String un) throws IOException{
        class1.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(2));
        avg1.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(3)+"%");
        class2.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(8));
        avg2.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(9)+"%");
        class3.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(14));
        avg3.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(15)+"%");
        class4.setText(Files.readAllLines(Paths.get("" +un + ".txt")).get(20));
        avg4.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(21)+"%");
        class5.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(26));
        avg5.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(27)+"%");
        class6.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(32));
        avg6.setText(Files.readAllLines(Paths.get("" + un + ".txt")).get(33)+"%");
    }
    
    public MainScreen() throws IOException { 
        initComponents();
        avg1.setHorizontalAlignment(SwingConstants.CENTER);
        avg1.setVerticalAlignment(SwingConstants.CENTER);
        avg2.setHorizontalAlignment(SwingConstants.CENTER);
        avg2.setVerticalAlignment(SwingConstants.CENTER);
        avg3.setHorizontalAlignment(SwingConstants.CENTER);
        avg3.setVerticalAlignment(SwingConstants.CENTER);
        avg4.setHorizontalAlignment(SwingConstants.CENTER);
        avg4.setVerticalAlignment(SwingConstants.CENTER);
        avg5.setHorizontalAlignment(SwingConstants.CENTER);
        avg5.setVerticalAlignment(SwingConstants.CENTER);
        avg6.setHorizontalAlignment(SwingConstants.CENTER);
        avg6.setVerticalAlignment(SwingConstants.CENTER);
        class1.setHorizontalAlignment(SwingConstants.CENTER);
        class1.setVerticalAlignment(SwingConstants.CENTER);
        class2.setHorizontalAlignment(SwingConstants.CENTER);
        class2.setVerticalAlignment(SwingConstants.CENTER);
        class3.setHorizontalAlignment(SwingConstants.CENTER);
        class3.setVerticalAlignment(SwingConstants.CENTER);
        class4.setHorizontalAlignment(SwingConstants.CENTER);
        class4.setVerticalAlignment(SwingConstants.CENTER);
        class5.setHorizontalAlignment(SwingConstants.CENTER);
        class5.setVerticalAlignment(SwingConstants.CENTER);
        class6.setHorizontalAlignment(SwingConstants.CENTER);
        class6.setVerticalAlignment(SwingConstants.CENTER);
        currentAvgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        currentAvgLabel.setVerticalAlignment(SwingConstants.CENTER);
        if (SignInScreen.signedIn == true){
            for (int i = 3; i < 36; i+=6){
                System.out.println("LOG IN");
                CurrentAverage += Double.parseDouble(Files.readAllLines(Paths.get("" + SignInScreen.username + ".txt")).get(i));
            }
        } else {
            for (int i = 3; i < 36; i+=6){
                System.out.println("Acc Creation");
                CurrentAverage += Double.parseDouble(Files.readAllLines(Paths.get("" + User.username + ".txt")).get(i));
            }
        }
        CurrentAverage = Double.parseDouble(String.format("%.2f", CurrentAverage/6));
        currentAvgLabel.setText(String.valueOf(CurrentAverage) + "%");
        this.top6 = new JLabel[]{class1, class2, class3, class4, class5, class6};
        this.avgLabels = new JLabel[]{avg1, avg2, avg3, avg4, avg5, avg6};
        if (SettingsScreen.centerButtonColour == 0){
            MainScreen.CenterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowCenterButton.png/")));
        } else if (SettingsScreen.centerButtonColour == 1){
            MainScreen.CenterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redCenterButton.png/")));
        } else if (SettingsScreen.centerButtonColour == 2){
            MainScreen.CenterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenCenterButton.png/")));
        }
        for (String i : ManualAddSpecifics.course_Avg.values()){
            avgValues.add(i);
        }
        for (int i = 0; i < AddClassScreen.courseNames.length; i++) {
            top6[i].setText(AddClassScreen.courseNames[i]);
        }
        try{
            setButtonText(User.username);
        } catch (IndexOutOfBoundsException e){
            setButtonText(SignInScreen.username);
        }
        if (parseDouble(avg1.getText().replace("%", "")) > SettingsScreen.currentGoal + 2){
            surroundButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenSurroundButton_v2.png/")));
        } else if ((parseDouble(avg1.getText().replace("%", "")) > SettingsScreen.currentGoal - 2) && (parseDouble(avg1.getText()) < SettingsScreen.currentGoal + 2)){
            surroundButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowSurroundButton_v2.png/")));
        } else {
            surroundButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redSurroundButton_v2.png/")));
        }
    }
    
    public void openCourseScreen() throws IOException{
        CourseScreen screen = new CourseScreen();
        screen.setVisible(true);
        screen.toFront();
        dispose();
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        surroundButton1 = new javax.swing.JButton();
        surroundButton2 = new javax.swing.JButton();
        surroundButton3 = new javax.swing.JButton();
        CenterButton = new javax.swing.JButton();
        surroundButton5 = new javax.swing.JButton();
        surroundButton4 = new javax.swing.JButton();
        surroundButton6 = new javax.swing.JButton();
        class1 = new javax.swing.JLabel();
        class2 = new javax.swing.JLabel();
        class3 = new javax.swing.JLabel();
        class4 = new javax.swing.JLabel();
        class5 = new javax.swing.JLabel();
        class6 = new javax.swing.JLabel();
        currentAvgLabel = new javax.swing.JLabel();
        avg1 = new javax.swing.JLabel();
        avg2 = new javax.swing.JLabel();
        avg3 = new javax.swing.JLabel();
        avg4 = new javax.swing.JLabel();
        avg5 = new javax.swing.JLabel();
        avg6 = new javax.swing.JLabel();
        UniTrack = new javax.swing.JLabel();
        GoldenExperience = new javax.swing.JLabel();
        signOutButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UniTrack");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(21, 25, 56));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBackground(new java.awt.Color(21, 25, 56));
        jLayeredPane1.setForeground(new java.awt.Color(21, 25, 56));

        surroundButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redSurroundButton_v2.png"))); // NOI18N
        surroundButton1.setBorder(null);
        surroundButton1.setBorderPainted(false);
        surroundButton1.setContentAreaFilled(false);
        surroundButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surroundButton1ActionPerformed(evt);
            }
        });

        surroundButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowSurroundButton_v2.png"))); // NOI18N
        surroundButton2.setBorder(null);
        surroundButton2.setBorderPainted(false);
        surroundButton2.setContentAreaFilled(false);
        surroundButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surroundButton2ActionPerformed(evt);
            }
        });

        surroundButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenSurroundButton_v2.png"))); // NOI18N
        surroundButton3.setBorder(null);
        surroundButton3.setBorderPainted(false);
        surroundButton3.setContentAreaFilled(false);
        surroundButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surroundButton3ActionPerformed(evt);
            }
        });

        CenterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenCenterButton.png"))); // NOI18N
        CenterButton.setBorder(null);
        CenterButton.setBorderPainted(false);
        CenterButton.setContentAreaFilled(false);
        CenterButton.setRolloverEnabled(false);
        CenterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CenterButtonActionPerformed(evt);
            }
        });

        surroundButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenSurroundButton_v2.png"))); // NOI18N
        surroundButton5.setBorder(null);
        surroundButton5.setBorderPainted(false);
        surroundButton5.setContentAreaFilled(false);
        surroundButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surroundButton5ActionPerformed(evt);
            }
        });

        surroundButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenSurroundButton_v2.png"))); // NOI18N
        surroundButton4.setBorder(null);
        surroundButton4.setBorderPainted(false);
        surroundButton4.setContentAreaFilled(false);
        surroundButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surroundButton4ActionPerformed(evt);
            }
        });

        surroundButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenSurroundButton_v2.png"))); // NOI18N
        surroundButton6.setBorder(null);
        surroundButton6.setBorderPainted(false);
        surroundButton6.setContentAreaFilled(false);
        surroundButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surroundButton6ActionPerformed(evt);
            }
        });

        class1.setForeground(new java.awt.Color(255, 255, 255));
        class1.setText("CLASS");

        class2.setForeground(new java.awt.Color(255, 255, 255));
        class2.setText("ABC4U");

        class3.setForeground(new java.awt.Color(255, 255, 255));
        class3.setText("ABC4U");

        class4.setForeground(new java.awt.Color(255, 255, 255));
        class4.setText("ABC4U");

        class5.setForeground(new java.awt.Color(255, 255, 255));
        class5.setText("ABC4U");

        class6.setForeground(new java.awt.Color(255, 255, 255));
        class6.setText("ABC4U");

        currentAvgLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        currentAvgLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentAvgLabel.setText("90.00%");

        avg1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avg1.setForeground(new java.awt.Color(255, 255, 255));
        avg1.setText("00.00%");

        avg2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avg2.setForeground(new java.awt.Color(255, 255, 255));
        avg2.setText("00.00%");

        avg3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avg3.setForeground(new java.awt.Color(255, 255, 255));
        avg3.setText("00.00%");

        avg4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avg4.setForeground(new java.awt.Color(255, 255, 255));
        avg4.setText("00.00%");

        avg5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avg5.setForeground(new java.awt.Color(255, 255, 255));
        avg5.setText("00.00%");

        avg6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        avg6.setForeground(new java.awt.Color(255, 255, 255));
        avg6.setText("00.00%");

        UniTrack.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        UniTrack.setForeground(new java.awt.Color(255, 255, 255));
        UniTrack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newLogoSmall.png"))); // NOI18N

        GoldenExperience.setBackground(new java.awt.Color(255, 255, 255));
        GoldenExperience.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        GoldenExperience.setForeground(new java.awt.Color(255, 255, 255));
        GoldenExperience.setText("By GoldExperience");

        signOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SignOutIcon.png"))); // NOI18N
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exitButton.png"))); // NOI18N
        exitButton.setBorder(null);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(surroundButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(surroundButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(surroundButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(CenterButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(surroundButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(surroundButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(surroundButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(class1, javax.swing.JLayeredPane.MODAL_LAYER);
        jLayeredPane1.setLayer(class2, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(class3, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(class4, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(class5, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(class6, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(currentAvgLabel, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(avg1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(avg2, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(avg3, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(avg4, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(avg5, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(avg6, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(UniTrack, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(GoldenExperience, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(signOutButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(exitButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(surroundButton3)
                            .addComponent(surroundButton6))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(surroundButton1))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(CenterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(surroundButton5)
                                .addGap(0, 136, Short.MAX_VALUE))
                            .addComponent(surroundButton2)))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(UniTrack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GoldenExperience)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signOutButton)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(surroundButton4)
                .addGap(347, 347, 347))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(371, 371, 371)
                    .addComponent(class1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(365, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(570, 570, 570)
                    .addComponent(class2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(152, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(572, 572, 572)
                    .addComponent(class3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(152, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(356, 356, 356)
                    .addComponent(class4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(359, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(176, 176, 176)
                    .addComponent(class5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(555, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(171, 171, 171)
                    .addComponent(class6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(555, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(331, 331, 331)
                    .addComponent(currentAvgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(320, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(355, 355, 355)
                    .addComponent(avg1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(347, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(560, 560, 560)
                    .addComponent(avg2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(138, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(561, 561, 561)
                    .addComponent(avg3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(350, 350, 350)
                    .addComponent(avg4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addComponent(avg5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(541, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(160, 160, 160)
                    .addComponent(avg6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(538, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(surroundButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(surroundButton3))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(surroundButton2)
                                .addGap(104, 104, 104)
                                .addComponent(surroundButton5)))
                        .addGap(123, 123, 123)
                        .addComponent(signOutButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(exitButton)
                                .addGap(26, 26, 26)
                                .addComponent(surroundButton1))
                            .addComponent(UniTrack))
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(CenterButton)
                                .addGap(84, 84, 84)
                                .addComponent(surroundButton4))
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addGap(413, 413, 413)
                                .addComponent(GoldenExperience, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(106, 106, 106))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(class1)
                    .addContainerGap(604, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(157, 157, 157)
                    .addComponent(class2)
                    .addContainerGap(516, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(358, 358, 358)
                    .addComponent(class3)
                    .addContainerGap(315, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(474, 474, 474)
                    .addComponent(class4)
                    .addContainerGap(199, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(353, 353, 353)
                    .addComponent(class5)
                    .addContainerGap(320, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(class6)
                    .addContainerGap(524, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(262, 262, 262)
                    .addComponent(currentAvgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(388, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(avg1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(556, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(avg2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(470, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(385, 385, 385)
                    .addComponent(avg3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(499, 499, 499)
                    .addComponent(avg4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(148, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(383, 383, 383)
                    .addComponent(avg5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(266, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(182, 182, 182)
                    .addComponent(avg6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(473, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CenterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CenterButtonActionPerformed
        SettingsScreen screen = new SettingsScreen();
        screen.setVisible(true);
        screen.toFront();
        dispose();
    }//GEN-LAST:event_CenterButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        JFrame quitConfirm = new JFrame();
        if(JOptionPane.showConfirmDialog(quitConfirm, "Are you sure you want to quit?", "QUIT", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitButtonActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
        profileSelectScreen screen = new profileSelectScreen();
        screen.setVisible(true);
        screen.toFront();
        dispose();
    }//GEN-LAST:event_signOutButtonActionPerformed

    private void surroundButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surroundButton2ActionPerformed
        CourseScreen.courseNumber = 2;
        try {
            openCourseScreen();
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_surroundButton2ActionPerformed

    private void surroundButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surroundButton1ActionPerformed
        CourseScreen.courseNumber = 1;
        try {
            openCourseScreen();
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_surroundButton1ActionPerformed

    private void surroundButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surroundButton5ActionPerformed
        CourseScreen.courseNumber = 3;
        try {
            openCourseScreen();
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_surroundButton5ActionPerformed

    private void surroundButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surroundButton4ActionPerformed
        CourseScreen.courseNumber = 4;
        try {
            openCourseScreen();
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_surroundButton4ActionPerformed

    private void surroundButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surroundButton3ActionPerformed
        CourseScreen.courseNumber = 5;
        try {
            openCourseScreen();
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_surroundButton3ActionPerformed

    private void surroundButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surroundButton6ActionPerformed
        CourseScreen.courseNumber = 6;
        try {
            openCourseScreen();
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_surroundButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainScreen().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton CenterButton;
    private javax.swing.JLabel GoldenExperience;
    private javax.swing.JLabel UniTrack;
    private javax.swing.JLabel avg1;
    private javax.swing.JLabel avg2;
    private javax.swing.JLabel avg3;
    private javax.swing.JLabel avg4;
    private javax.swing.JLabel avg5;
    private javax.swing.JLabel avg6;
    private javax.swing.JLabel class1;
    private javax.swing.JLabel class2;
    private javax.swing.JLabel class3;
    private javax.swing.JLabel class4;
    private javax.swing.JLabel class5;
    private javax.swing.JLabel class6;
    private javax.swing.JLabel currentAvgLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton signOutButton;
    private javax.swing.JButton surroundButton1;
    private javax.swing.JButton surroundButton2;
    private javax.swing.JButton surroundButton3;
    private javax.swing.JButton surroundButton4;
    private javax.swing.JButton surroundButton5;
    private javax.swing.JButton surroundButton6;
    // End of variables declaration//GEN-END:variables
}
