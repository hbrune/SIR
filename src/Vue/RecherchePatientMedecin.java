/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vue;

import Controleur.LoginController;
import Controleur.ManipAndPhController;
import Modele.Login;
import Modele.Patient;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.table.*;
import java.awt.Component;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saman
 */
public class RecherchePatientMedecin extends javax.swing.JFrame {

    Controleur.ManipAndPhController mc;
    Modele.Login user;
    DefaultTableModel patientsModel;
    
 public RecherchePatientMedecin(Login user, ManipAndPhController mc,  ArrayList<Patient> patients) {
     
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    
        
        this.mc = mc;
        this.user = user;
        this.updatePatients(patients);
        accesDmrButton.setEnabled(false);
        
    }

    public abstract class RendererAndEditor implements TableCellRenderer, TableCellEditor {

        private JButton acces;

        RendererAndEditor() {
            acces = new JButton("Accès");
            acces.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("button clicked");
                }
            });
        }
    
   
        @Override
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {
    return acces;
  }


        @Override
  public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                                                        int column) {
    return acces;
  }


        @Override
  public Object getCellEditorValue() {
    return null;
  }


  public boolean isCellEditable(EventObject anEvent) {
    return true;
  }


        @Override
  public boolean shouldSelectCell(EventObject anEvent) {
    return true;
  }

 
        @Override
  public boolean stopCellEditing() {
    return true;
  }


        @Override
  public void cancelCellEditing() { }


        @Override
  public void addCellEditorListener(CellEditorListener l) { }

    }
  public void removeCellEditorListener(CellEditorListener l) { }

   
   
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        critere = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JRecherche = new javax.swing.JTable();
        rechercheText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rechercheButton = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        accesDmrButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        decoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("choisissez un critère de rechercher");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N

        critere.setEditable(true);
        critere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Patient", "Nom", "Prénom", "Date de naissance", "Sexe" }));
        critere.setToolTipText("choisissez un critère de recherche");
        critere.setBorder(null);

        JRecherche.setBackground(new java.awt.Color(193, 216, 239));
        JRecherche.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"d00bf4b4-96dc-474a-b18a-29b20196574b", "Titi", "Titi", "01/01/2001", "F"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID patient", "Nom", "Prénom", "Date  de naissance", "Sexe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JRecherche.setFocusable(false);
        JRecherche.setRowHeight(30);
        JRecherche.setRowMargin(5);
        JRecherche.setSelectionBackground(new java.awt.Color(102, 153, 255));
        JRecherche.setSelectionForeground(new java.awt.Color(0, 0, 0));
        JRecherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JRechercheMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JRecherche);
        JRecherche.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        rechercheText.setFont(new java.awt.Font("Yu Gothic UI Light", 2, 12)); // NOI18N
        rechercheText.setText("recherche selon le critère selectionné");
        rechercheText.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        rechercheText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechercheTextMouseClicked(evt);
            }
        });
        rechercheText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheTextActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_Search_Contacts_40px.png"))); // NOI18N
        jLabel1.setText("Rechercher un patient : ");

        rechercheButton.setBackground(new java.awt.Color(255, 255, 255));
        rechercheButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        rechercheButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_search_40px_2.png"))); // NOI18N
        rechercheButton.setText("Recherche");
        rechercheButton.setBorder(null);
        rechercheButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheButtonActionPerformed(evt);
            }
        });

        error.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        error.setForeground(new java.awt.Color(255, 51, 0));

        accesDmrButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        accesDmrButton.setText("Accès DMR");
        accesDmrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accesDmrButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(accesDmrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(critere, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rechercheText, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rechercheButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(critere, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(error))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rechercheButton)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(rechercheText)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(accesDmrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        backButton.setBackground(new java.awt.Color(153, 204, 255));
        backButton.setFont(new java.awt.Font("Yu Gothic UI", 0, 13)); // NOI18N
        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/icons8_back_40px.png"))); // NOI18N
        backButton.setText("Retour");
        backButton.setBorder(null);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(820, Short.MAX_VALUE)
                    .addComponent(decoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(decoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        mc.displayDashboard();
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void decoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decoButtonActionPerformed
        user = null;
        try {
            LoginController lc = new LoginController();
            this.dispose();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_decoButtonActionPerformed

    private void rechercheButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheButtonActionPerformed
        String critereToFind = "";
        switch(String.valueOf(critere.getSelectedItem())) {
            case ("ID Patient"):
                critereToFind = "patientId";
                break;
            case("Prénom"):
                critereToFind = "firstNameP";
                break;
            case ("Nom"):
                critereToFind = "lastNameP";
                break;
            case ("Sexe"):
                System.out.println("gender");
                break;
            case("Date de naissance"):
                critereToFind = "birthDate";
                break;   
        }
        if(critereToFind.equals("birthDate")) {
            //TODO : recherche avec date
        } else {
           try {
               mc.recherchePatient(critereToFind, rechercheText.getText().toLowerCase());
           } catch (SQLException ex) {
               Logger.getLogger(RecherchePatientSecretaire.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        error.setText(mc.getError());
    }//GEN-LAST:event_rechercheButtonActionPerformed

    private void rechercheTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheTextActionPerformed
        
    }//GEN-LAST:event_rechercheTextActionPerformed

    private void rechercheTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechercheTextMouseClicked
        rechercheText.setText("");
    }//GEN-LAST:event_rechercheTextMouseClicked

    private void accesDmrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesDmrButtonActionPerformed
        int row = JRecherche.getSelectedRow();
        String idPatient = JRecherche.getModel().getValueAt(row, 0).toString();
        
        if (idPatient != null){
            try {
            mc.displayDossierPatient(idPatient);
            } catch (SQLException ex) {
            Logger.getLogger(RecherchePatientMedecin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();
    }//GEN-LAST:event_accesDmrButtonActionPerformed

    private void JRechercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JRechercheMouseClicked
        accesDmrButton.setEnabled(true);
    }//GEN-LAST:event_JRechercheMouseClicked

    public void updatePatients(ArrayList<Patient> patients) {
        String col[] = {"Identifiant","Nom","Prénom", "Adresse", "Date de naissance", "Sexe"};

        this.patientsModel = new DefaultTableModel(col, 0);

        JRecherche.setModel(patientsModel);
        
        for (int i = 0; i < patients.size(); i++) {
            String id = patients.get(i).getPatientId().trim();
            String lastName = patients.get(i).getLastNameP().toUpperCase().trim();
            String firstName = patients.get(i).getFirstNameP().substring(0, 1).toUpperCase() + patients.get(i).getFirstNameP().substring(1).trim();
            String adress = patients.get(i).getAdress().trim();
            Date bod = patients.get(i).getDdn();
            String gender = patients.get(i).getGender();
            Object[] data = {id , lastName, firstName, adress, bod, gender};
            /*JRecherche.getColumn("Accès DMR").setCellRenderer(new RendererAndEditor() {
                @Override
                public void removeCellEditorListener(CellEditorListener l) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
                });
                JRecherche.getColumn("Accès DMR").setCellEditor(new RendererAndEditor() {
                @Override
                    public void removeCellEditorListener(CellEditorListener l) {
                    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                }
            });*/

            patientsModel.addRow(data);
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(RecherchePatientMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecherchePatientMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecherchePatientMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecherchePatientMedecin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTable JRecherche;
    private javax.swing.JButton accesDmrButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> critere;
    private javax.swing.JButton decoButton;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rechercheButton;
    private javax.swing.JTextField rechercheText;
    // End of variables declaration//GEN-END:variables
}
   
