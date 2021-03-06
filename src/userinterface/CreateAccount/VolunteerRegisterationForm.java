/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CreateAccount;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Utility.FormValidations;
import Business.Utility.SendEmailUtility;
import Business.WorkQueue.VolunteerRegistrationRequest;
import Business.WorkQueue.WorkQueue;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author kichl
 */
public class VolunteerRegisterationForm extends javax.swing.JPanel {

    /**
     * Creates new form VolunteerWorkArea
     */
    
    private JPanel userProcessContainer;
    private EcoSystem system;
    private DB4OUtil Db4oUtil = DB4OUtil.getInstance();
    public VolunteerRegisterationForm(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = Db4oUtil.retrieveSystem();;
        populateStateComboBox();
        populateOrgComboBox();
    }
    
    public void populateStateComboBox() {
        stateCombo.removeAllItems();
        for (Network network : system.getNetworkList()) {
            stateCombo.addItem(network);
        }
    }
    
    public void populateOrgComboBox() {
        organizationComboBox.addItem(Organization.Type.PoliceDepartment);
        organizationComboBox.addItem(Organization.Type.FireDepartment);
        organizationComboBox.addItem(Organization.Type.HospitalOrganization);
        organizationComboBox.addItem(Organization.Type.PWDOrganization);
        organizationComboBox.addItem(Organization.Type.Contractor);
        organizationComboBox.addItem(Organization.Type.Management);
        organizationComboBox.addItem(Organization.Type.Vaccine);
        organizationComboBox.addItem(Organization.Type.Volunteer);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VolunteeringFormHeaderjLabel = new javax.swing.JLabel();
        NamejLabel = new javax.swing.JLabel();
        NameJField = new javax.swing.JTextField();
        EmailjLabel = new javax.swing.JLabel();
        UsernamejLabel = new javax.swing.JLabel();
        userNameJfield = new javax.swing.JTextField();
        passwordjLabel = new javax.swing.JLabel();
        passwordJfield = new javax.swing.JTextField();
        emailJField = new javax.swing.JTextField();
        statejLabel = new javax.swing.JLabel();
        CityjLabel = new javax.swing.JLabel();
        cityJField = new javax.swing.JTextField();
        CountryjLabel = new javax.swing.JLabel();
        PhonejTextField = new javax.swing.JTextField();
        RegisterjButton = new javax.swing.JButton();
        PhonejLabel = new javax.swing.JLabel();
        stateCombo = new javax.swing.JComboBox();
        organizationComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VolunteeringFormHeaderjLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        VolunteeringFormHeaderjLabel.setForeground(new java.awt.Color(25, 56, 82));
        VolunteeringFormHeaderjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VolunteeringFormHeaderjLabel.setText("Registration Form");
        add(VolunteeringFormHeaderjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        NamejLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        NamejLabel.setForeground(new java.awt.Color(25, 56, 82));
        NamejLabel.setText("Name");
        add(NamejLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 70, 30));

        NameJField.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        NameJField.setForeground(new java.awt.Color(25, 56, 82));
        NameJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameJFieldActionPerformed(evt);
            }
        });
        NameJField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NameJFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NameJFieldKeyTyped(evt);
            }
        });
        add(NameJField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 250, 30));

        EmailjLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        EmailjLabel.setForeground(new java.awt.Color(25, 56, 82));
        EmailjLabel.setText("Email");
        add(EmailjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 50, 30));

        UsernamejLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        UsernamejLabel.setForeground(new java.awt.Color(25, 56, 82));
        UsernamejLabel.setText("Username");
        add(UsernamejLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 70, 30));

        userNameJfield.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        userNameJfield.setForeground(new java.awt.Color(25, 56, 82));
        userNameJfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameJfieldActionPerformed(evt);
            }
        });
        userNameJfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameJfieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userNameJfieldKeyTyped(evt);
            }
        });
        add(userNameJfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 250, 30));

        passwordjLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        passwordjLabel.setForeground(new java.awt.Color(25, 56, 82));
        passwordjLabel.setText("Password");
        add(passwordjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, 30));

        passwordJfield.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        passwordJfield.setForeground(new java.awt.Color(25, 56, 82));
        passwordJfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJfieldActionPerformed(evt);
            }
        });
        passwordJfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordJfieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordJfieldKeyTyped(evt);
            }
        });
        add(passwordJfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 250, 30));

        emailJField.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        emailJField.setForeground(new java.awt.Color(25, 56, 82));
        emailJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailJFieldActionPerformed(evt);
            }
        });
        emailJField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailJFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailJFieldKeyTyped(evt);
            }
        });
        add(emailJField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 250, 30));

        statejLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        statejLabel.setForeground(new java.awt.Color(25, 56, 82));
        statejLabel.setText("State");
        add(statejLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 40, 30));

        CityjLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        CityjLabel.setForeground(new java.awt.Color(25, 56, 82));
        CityjLabel.setText("City");
        add(CityjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 40, 30));

        cityJField.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        cityJField.setForeground(new java.awt.Color(25, 56, 82));
        cityJField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityJFieldActionPerformed(evt);
            }
        });
        cityJField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cityJFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cityJFieldKeyTyped(evt);
            }
        });
        add(cityJField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 250, 30));

        CountryjLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        CountryjLabel.setForeground(new java.awt.Color(25, 56, 82));
        CountryjLabel.setText("Organization");
        add(CountryjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, 30));

        PhonejTextField.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        add(PhonejTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 250, 30));

        RegisterjButton.setBackground(new java.awt.Color(0, 0, 0));
        RegisterjButton.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        RegisterjButton.setForeground(new java.awt.Color(255, 255, 255));
        RegisterjButton.setText("Create Account");
        RegisterjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterjButtonActionPerformed(evt);
            }
        });
        add(RegisterjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 130, 30));

        PhonejLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        PhonejLabel.setForeground(new java.awt.Color(25, 56, 82));
        PhonejLabel.setText("Phone No");
        add(PhonejLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, 30));

        stateCombo.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        stateCombo.setForeground(new java.awt.Color(25, 56, 82));
        stateCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                stateComboItemStateChanged(evt);
            }
        });
        stateCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboActionPerformed(evt);
            }
        });
        add(stateCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 250, 30));

        organizationComboBox.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        organizationComboBox.setForeground(new java.awt.Color(25, 56, 82));
        organizationComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                organizationComboBoxItemStateChanged(evt);
            }
        });
        organizationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationComboBoxActionPerformed(evt);
            }
        });
        add(organizationComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 250, 30));

        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/volunteering_form.PNG"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 590));
    }// </editor-fold>//GEN-END:initComponents

    private void NameJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameJFieldActionPerformed

    private void NameJFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameJFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameJFieldKeyPressed

    private void NameJFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameJFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_NameJFieldKeyTyped

    private void userNameJfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameJfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameJfieldActionPerformed

    private void userNameJfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameJfieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameJfieldKeyPressed

    private void userNameJfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameJfieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameJfieldKeyTyped

    private void passwordJfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJfieldActionPerformed

    private void passwordJfieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordJfieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJfieldKeyPressed

    private void passwordJfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordJfieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJfieldKeyTyped

    private void emailJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailJFieldActionPerformed

    private void emailJFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailJFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailJFieldKeyPressed

    private void emailJFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailJFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_emailJFieldKeyTyped

    private void cityJFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityJFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityJFieldActionPerformed

    private void cityJFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityJFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityJFieldKeyPressed

    private void cityJFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cityJFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cityJFieldKeyTyped

    private void stateComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_stateComboItemStateChanged
        // TODO add your handling code here:
        stateCombo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        stateCombo.setForeground(Color.BLACK);
    }//GEN-LAST:event_stateComboItemStateChanged

    private void stateComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboActionPerformed
        /*Network n = (Network) stateCombo.getSelectedItem();
        for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
            for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                if (o instanceof VolunteerCompanyOrganization) {
                    orgCombo.addItem(Organization.Type.Company);
                } else if (o instanceof VolunteerNGOOrganization) {
                    orgCombo.addItem(Organization.Type.NGO);
                } else if (o instanceof VolunteerPersonalOrganization) {
                    orgCombo.addItem(Organization.Type.Personal);
                } else if (o instanceof VolunteerHospitalOrganization) {
                    orgCombo.addItem(Organization.Type.Hospital);
                }
            }
        }
        */
    }//GEN-LAST:event_stateComboActionPerformed

    private void organizationComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_organizationComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationComboBoxItemStateChanged

    private void organizationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationComboBoxActionPerformed

    private void RegisterjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterjButtonActionPerformed
        // TODO add your handling code here:
        
        Network network = (Network)stateCombo.getSelectedItem();
        Organization.Type org = (Organization.Type) organizationComboBox.getSelectedItem();
        
        FormValidations validation = new FormValidations();
        validation.setName(NameJField.getText());
        validation.setUser(userNameJfield.getText());
        validation.setPass1(passwordJfield.getText());
        validation.setEmail(emailJField.getText());
        validation.setContact(PhonejTextField.getText());
        validation.setAddress(cityJField.getText());
        if(NameJField.getText().isEmpty() 
                || userNameJfield.getText().isEmpty() 
                || passwordJfield.getText().isEmpty()
                || emailJField.getText().isEmpty()
                || org == null 
                || cityJField.getText().isEmpty()
                || network == null
                || PhonejTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Complete all fields", "Blank Fields!", 2);
        }
        if(!validation.isValid()){
            
        }
        else {
        VolunteerRegistrationRequest registrationRequest = new VolunteerRegistrationRequest();
        registrationRequest.setName(NameJField.getText());
            registrationRequest.setUserName(userNameJfield.getText());
            registrationRequest.setUserPassword(passwordJfield.getText());
            registrationRequest.setUserEmailId(emailJField.getText());
            registrationRequest.setNetwork(network);
            registrationRequest.setUserCity(cityJField.getText());
            registrationRequest.setOrgType(org);
            registrationRequest.setStatus("Requested");
            registrationRequest.setUserContact(PhonejLabel.getText());
            
            String contact = "";
            
            SendEmailUtility sendemail = new SendEmailUtility();
            try {
                sendemail.sendMail(emailJField.getText());
                for (Network network1 : system.getNetworkList()) {
                for (Enterprise enterprise : network1.getEnterpriseDirectory().getEnterpriseList()) {
                    if (enterprise.getEnterpriseType() == Enterprise.EnterpriseType.MitigationUnit 
                            || enterprise.getEnterpriseType() == Enterprise.EnterpriseType.EmergencyResponseUnit
                            || enterprise.getEnterpriseType() == Enterprise.EnterpriseType.RecoveryUnit
                            || enterprise.getEnterpriseType() == Enterprise.EnterpriseType.ResourceManagementUnit) {
                        if (enterprise.getWorkQueue() == null) {
                            enterprise.setWorkQueue(new WorkQueue());
                        }
                        enterprise.getWorkQueue().getWorkRequestList().add(registrationRequest);
                        
                    }
                }
            }
            } catch (Exception ex) {
                Logger.getLogger(VolunteerRegisterationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(null,"You have been registered succesfully!", "Success",2);
            Db4oUtil.storeSystem(system);
            NameJField.setText("");
            userNameJfield.setText("");
            passwordJfield.setText("");
            emailJField.setText("");
            cityJField.setText("");
            PhonejTextField.setText("");
            
        }
    }//GEN-LAST:event_RegisterjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CityjLabel;
    private javax.swing.JLabel CountryjLabel;
    private javax.swing.JLabel EmailjLabel;
    private javax.swing.JTextField NameJField;
    private javax.swing.JLabel NamejLabel;
    private javax.swing.JLabel PhonejLabel;
    private javax.swing.JTextField PhonejTextField;
    private javax.swing.JButton RegisterjButton;
    private javax.swing.JLabel UsernamejLabel;
    private javax.swing.JLabel VolunteeringFormHeaderjLabel;
    private javax.swing.JTextField cityJField;
    private javax.swing.JTextField emailJField;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JComboBox organizationComboBox;
    private javax.swing.JTextField passwordJfield;
    private javax.swing.JLabel passwordjLabel;
    private javax.swing.JComboBox stateCombo;
    private javax.swing.JLabel statejLabel;
    private javax.swing.JTextField userNameJfield;
    // End of variables declaration//GEN-END:variables
}
