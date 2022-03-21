/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vue;

import Controleur.LoginController;
import Controleur.ManipAndPhController;
import Modele.Login;
import Modele.TypeUtilisateur;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author saman
 */
public class Dashboard extends javax.swing.JFrame {

    Login user;
    ManipAndPhController mc;
    /**
     * Creates new form dashboard
     */
    public Dashboard(Login user, ManipAndPhController mc) {
        initComponents();
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.user = user;
        lastName.setText(user.getLastName().toUpperCase());
        firstName2.setText(user.getFirstName().substring(0, 1).toUpperCase() + user.getFirstName().substring(1).trim());
        firstName1.setText(user.getFirstName().substring(0, 1).toUpperCase() + user.getFirstName().substring(1).trim());
        if(user.getFunction() == 1 || user.getFunction() == 2) {
            function.setText("Praticien hospitalier");
        } else {
            function.setText("Manipulateur radio");
        }
        
        if(user.getFunction() == 3) {
            completeExamIcon.setVisible(false);
            completeExamButton.setVisible(false);
        }
        
        this.mc = mc;
        this.setLocationRelativeTo(null);
        
        
  
        final DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                String timeNow = timeFormat.format(date);
                time.setText(timeNow);
            }
        };
        Timer timer = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        timer.setInitialDelay(0);
        timer.start();
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
        decoButton = new javax.swing.JButton();
        lastName = new javax.swing.JLabel();
        firstName1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        function = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        firstName2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        recherchePatientButton = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel8 = new javax.swing.JLabel();
        completeExamButton = new javax.swing.JButton();
        recherchePatientButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        completeExamIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        decoButton.setBackground(new java.awt.Color(153, 204, 255));
        decoButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        decoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_sign_out_40px_3.png"))); // NOI18N
        decoButton.setText("Déconnexion");
        decoButton.setBorder(null);
        decoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decoButtonActionPerformed(evt);
            }
        });

        lastName.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        lastName.setText("last name");

        firstName1.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        firstName1.setText("first name");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_Male_User_64px.png"))); // NOI18N

        function.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstName1)
                            .addComponent(lastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 672, Short.MAX_VALUE)
                        .addComponent(decoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(function, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(decoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lastName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstName1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(function)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        dateLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setText("Il est ");

        time.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        time.setText("HH");

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel9.setText("Bienvenue sur LogiX,");

        firstName2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        firstName2.setText("Prénom");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_Search_Contacts_40px.png"))); // NOI18N

        recherchePatientButton.setBackground(new java.awt.Color(255, 255, 255));
        recherchePatientButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        recherchePatientButton.setText("Rechercher un patient");
        recherchePatientButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        recherchePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recherchePatientButtonActionPerformed(evt);
            }
        });

        jCalendar1.setBackground(new java.awt.Color(153, 204, 255));
        jCalendar1.setForeground(new java.awt.Color(0, 153, 153));
        jCalendar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(153, 204, 255));
        jCalendar1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jCalendar1.setSundayForeground(new java.awt.Color(255, 255, 102));
        jCalendar1.setTodayButtonVisible(true);
        jCalendar1.setVerifyInputWhenFocusTarget(false);
        jCalendar1.setWeekdayForeground(new java.awt.Color(204, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_baby_calendar_64px.png"))); // NOI18N

        completeExamButton.setBackground(new java.awt.Color(255, 255, 255));
        completeExamButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        completeExamButton.setText("Examens à compléter ");
        completeExamButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        completeExamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeExamButtonActionPerformed(evt);
            }
        });

        recherchePatientButton2.setBackground(new java.awt.Color(255, 255, 255));
        recherchePatientButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        recherchePatientButton2.setText("Examens à réaliser");
        recherchePatientButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        recherchePatientButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recherchePatientButton2ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_treatment_40px_1.png"))); // NOI18N

        completeExamIcon.setBackground(new java.awt.Color(255, 255, 255));
        completeExamIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_tick_box_40px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(598, 598, 598)
                                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(firstName2, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(time))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(305, 656, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(recherchePatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(69, 69, 69)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(recherchePatientButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(67, 67, 67)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(completeExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(completeExamIcon)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(time)
                            .addComponent(dateLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(firstName2))
                        .addGap(90, 90, 90)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(completeExamIcon))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recherchePatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(recherchePatientButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(completeExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decoButtonActionPerformed
        user = null;
        try {
            LoginController lc = new LoginController();
            this.dispose();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_decoButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void recherchePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recherchePatientButtonActionPerformed
        try {
            mc.displayRecherchePatient();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_recherchePatientButtonActionPerformed

    private void completeExamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeExamButtonActionPerformed
        try {
            mc.displayListExamToComplete();
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_completeExamButtonActionPerformed

    private void recherchePatientButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recherchePatientButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recherchePatientButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton completeExamButton;
    private javax.swing.JLabel completeExamIcon;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton decoButton;
    private javax.swing.JLabel firstName1;
    private javax.swing.JLabel firstName2;
    private javax.swing.JLabel function;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lastName;
    private javax.swing.JButton recherchePatientButton;
    private javax.swing.JButton recherchePatientButton2;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
