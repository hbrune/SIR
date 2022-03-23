/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vue;

import Controleur.LoginController;
import Controleur.ManipAndPhController;
import GestionImage.Image;
import Modele.Examen;
import Modele.Login;
import Modele.Pacs;
import Modele.Patient;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saman
 */
public class AjouterImagesNumerisees extends javax.swing.JFrame {

    ManipAndPhController mc;
    Login user;
    Examen e;
    Patient p;
    //ArrayList<BufferedImage> imageToAdd;
    ArrayList<GestionImage.Image> imagesToAdd;
    DefaultListModel imagesModel;
    final int NB_IMG_MAX = 20;

    /**
     * Creates new form NewJFrame
     */
    public AjouterImagesNumerisees(ManipAndPhController mc, Login user, Examen e, Patient p, ArrayList<Image> images) {
        initComponents();
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.mc = mc;
        this.user = user;
        this.e = e;
        this.p = p;
        this.imagesToAdd = images;
        editImageButton.setEnabled(false);        
        removeImage.setVisible(false);
        this.updateImages();
        examId.setText(e.getExamId().trim());
        dateExam.setText(e.getDate().toString().trim());
        typeExam.setText(e.getType().trim());
        patientId.setText(p.getLastNameP().toUpperCase().trim() + " " + p.getFirstNameP().trim().substring(0, 1).toUpperCase() + p.getFirstNameP().substring(1).trim());
        addImagesToExamButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        backButton2 = new javax.swing.JButton();
        decoButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        addImageButton = new javax.swing.JButton();
        addImagesToExamButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        editImageButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ImagesList = new javax.swing.JList<>();
        examId = new javax.swing.JLabel();
        patientId = new javax.swing.JLabel();
        typeExam = new javax.swing.JLabel();
        dateExam = new javax.swing.JLabel();
        removeImage = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        backButton2.setBackground(new java.awt.Color(153, 204, 255));
        backButton2.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        backButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_back_40px.png"))); // NOI18N
        backButton2.setText("Retour");
        backButton2.setBorder(null);
        backButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton2ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(566, Short.MAX_VALUE)
                    .addComponent(decoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(decoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        addImageButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        addImageButton.setText("Sélectionner une nouvelle image");
        addImageButton.setFocusCycleRoot(true);
        addImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImageButtonActionPerformed(evt);
            }
        });

        addImagesToExamButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        addImagesToExamButton.setText("Valider");
        addImagesToExamButton.setFocusCycleRoot(true);
        addImagesToExamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImagesToExamButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel1.setText("Images sélectionnées :");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel2.setText("Examen : ");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setText("Patient :");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setText("Type :");

        editImageButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        editImageButton.setText("Modifier l'image");
        editImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editImageButtonActionPerformed(evt);
            }
        });

        ImagesList.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        ImagesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ImagesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ImagesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagesListMouseClicked(evt);
            }
        });
        ImagesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ImagesListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ImagesList);

        examId.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        examId.setText("Examen n° ");

        patientId.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        patientId.setText("Examen n° ");

        typeExam.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        typeExam.setText("Examen n° ");

        dateExam.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        dateExam.setText("Examen n° ");

        removeImage.setBackground(new java.awt.Color(255, 153, 153));
        removeImage.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 8)); // NOI18N
        removeImage.setForeground(new java.awt.Color(255, 255, 255));
        removeImage.setText("X");
        removeImage.setMargin(new java.awt.Insets(2, 2, 2, 2));
        removeImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeImageActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setText("Date :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeExam)
                            .addComponent(dateExam)
                            .addComponent(patientId)
                            .addComponent(examId)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(addImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(editImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addImagesToExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(406, 406, 406))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addComponent(removeImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(examId))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(typeExam)
                                .addGap(18, 18, 18)
                                .addComponent(patientId)
                                .addGap(18, 18, 18)
                                .addComponent(dateExam)))
                        .addGap(48, 48, 48)
                        .addComponent(addImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addComponent(addImagesToExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton2ActionPerformed
        try {
            mc.displayExam(e.getExamId());
        } catch (SQLException ex) {
            Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_backButton2ActionPerformed

    private void decoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decoButtonActionPerformed
        user = null;
        try {
            LoginController lc = new LoginController();
            this.dispose();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_decoButtonActionPerformed

    private void addImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImageButtonActionPerformed
        if (imagesToAdd.size() < NB_IMG_MAX) {
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            //filter the files : l'utilisateur peut choisir des .pgm uniquement
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "pgm");
            file.addChoosableFileFilter(filter);
            file.removeChoosableFileFilter(file.getFileFilter());  //remove the default file filter
            FileFilter fileFilter = new FileNameExtensionFilter("PGM file", "pgm");

            int result = file.showSaveDialog(null);
            //if the user click on save in Jfilechooser
            if (result == JFileChooser.APPROVE_OPTION) {

                File selectedFile = file.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                System.out.println(selectedFile);
                FileInputStream in = null;
                try {
                    Image im = new Image(path);
                    ByteArrayOutputStream imJpg = im.toJpg();
                    in = new FileInputStream(selectedFile);
                    BufferedImage img = ImageIO.read(new File(path));
                    mc.displayTraiterImage(im, this, true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vous ne pouvez ajouter que " + NB_IMG_MAX + " images à un examen.");
        }

    }//GEN-LAST:event_addImageButtonActionPerformed

    private void addImagesToExamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addImagesToExamButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Voulez-vous ajouter ces images ? Vous ne pourrez plus les modifier.", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        //Si l'utilisateur confirme : on ajoute les images à l'examen et on revient à la visualisation de l'examen
        if (response == JOptionPane.YES_OPTION) {
            for (int i = 0; i < imagesToAdd.size(); i++) {

                try {
                    ByteArrayOutputStream myJpg = imagesToAdd.get(i).toJpg();
                    ImageIcon icon = new ImageIcon(myJpg.toByteArray());
                    BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
                    Graphics graphics = bi.createGraphics();
                    icon.paintIcon(null, graphics, 0, 0);
                    graphics.dispose();
                    System.out.println(e.getExamId());
                    mc.addImage(bi, e.getExamId());

                } catch (IOException ex) {
                    Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                System.out.println(e.getExamId());
                mc.displayExam(e.getExamId());
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Si l'utilisateur annule (response = NO) : on ne fait rien        
    }//GEN-LAST:event_addImagesToExamButtonActionPerformed

    private void editImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editImageButtonActionPerformed
        removeImage.setVisible(false);
        int row = ImagesList.getSelectedIndex();
        Image imgToEdit = imagesToAdd.get(row);

        if (imgToEdit != null) {
            try {
                mc.displayTraiterImage(imgToEdit, this, false);
            } catch (IOException ex) {
                Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_editImageButtonActionPerformed

    private void ImagesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagesListMouseClicked

    }//GEN-LAST:event_ImagesListMouseClicked

    private void ImagesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ImagesListValueChanged
        editImageButton.setEnabled(true);
        removeImage.setVisible(true);
        
        this.setSize(1000, 600);
    }//GEN-LAST:event_ImagesListValueChanged

    private void removeImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeImageActionPerformed
        int row = ImagesList.getSelectedIndex();
        imagesToAdd.remove(row);
        updateImages();
        removeImage.setVisible(false);

    }//GEN-LAST:event_removeImageActionPerformed

    public void updateImages() {
        this.imagesModel = new DefaultListModel();

        ImagesList.setModel(imagesModel);
        for (int i = 0; i < imagesToAdd.size(); i++) {
            String num = String.valueOf(i + 1);

            imagesModel.add(i, "Image " + num);
        }
        if (imagesToAdd.size() > 0) {
            addImagesToExamButton.setEnabled(true);
        } else {
            addImagesToExamButton.setEnabled(false);
        }
    }

    public void addImage(Image img) {
        imagesToAdd.add(img);
        this.updateImages();
        removeImage.setVisible(false);
    }

    public void editImage(Image img) {
        imagesToAdd.set(ImagesList.getSelectedIndex(), img);
        this.updateImages();
        removeImage.setVisible(false);
    }

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
            java.util.logging.Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterImagesNumerisees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JList<String> ImagesList;
    private javax.swing.JButton addImageButton;
    private javax.swing.JButton addImagesToExamButton;
    private javax.swing.JButton backButton2;
    private javax.swing.JLabel dateExam;
    private javax.swing.JButton decoButton;
    private javax.swing.JButton editImageButton;
    private javax.swing.JLabel examId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel patientId;
    private javax.swing.JButton removeImage;
    private javax.swing.JLabel typeExam;
    // End of variables declaration//GEN-END:variables
}
