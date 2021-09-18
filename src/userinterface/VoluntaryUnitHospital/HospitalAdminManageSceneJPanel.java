/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VoluntaryUnitHospital;

import userinterface.voluntaryUnitPersonal.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MitigationUnit;
import Business.Network.Network;
import Business.Organization.DisasterManagementOrganization;
import Business.Organization.DisasterReportingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MitigationUnitAdminRequest;
import Business.WorkQueue.VolunteerUnitRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivibhatt
 */
public class HospitalAdminManageSceneJPanel extends javax.swing.JPanel {

    /**
     * Creates new form IndividualAdminManageSceneJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;
    Organization organization;
    Network network;
    UserAccount account;

    public HospitalAdminManageSceneJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system, Organization organization, Network network, UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.organization = organization;
        this.network = network;
        this.account = account;
        populateSceneTable();
    }

    private void populateSceneTable() {

        DefaultTableModel model = (DefaultTableModel) tblScene.getModel();

        model.setRowCount(0);

        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {

            if (wr instanceof VolunteerUnitRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = wr;
                row[1] = ((VolunteerUnitRequest) wr).getSceneName();
                row[2] = ((VolunteerUnitRequest) wr).getSceneZipcode();
                //row[3] = ((VolunteerUnitRequest) wr).getSceneLocationPoint();
                row[4] = ((VolunteerUnitRequest) wr).getNoOfVictims();
                row[5] = ((VolunteerUnitRequest) wr).getEstimatedLoss();
                row[6] = ((VolunteerUnitRequest) wr).getStatus();
                row[7] = ((VolunteerUnitRequest) wr).getRequestDate();
                row[8] = ((VolunteerUnitRequest) wr).getMessage();
                //row[2] = org.getPosition();
                model.addRow(row);
            }

            /*Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            
            model.addRow(row);*/
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblScene = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sceneName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sceneZipCode = new javax.swing.JTextField();
        noOfVictims = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estimatedLoss = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        createSceneBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1058, 840));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblScene.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tblScene.setForeground(new java.awt.Color(25, 56, 82));
        tblScene.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Scene #", "Scene Name", "Zip Code", "Location", "# of Victims", "Estimated Loss", "Status", "Created Date", "Additional Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblScene.setSelectionBackground(new java.awt.Color(56, 90, 174));
        jScrollPane1.setViewportView(tblScene);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1000, 146));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(25, 56, 82));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MANAGE HOSPITAL SCENE");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 6, 849, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 56, 82));
        jLabel1.setText("Scene Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 204, -1, -1));

        sceneName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sceneName.setForeground(new java.awt.Color(25, 56, 82));
        sceneName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                sceneNameFocusLost(evt);
            }
        });
        sceneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceneNameActionPerformed(evt);
            }
        });
        add(sceneName, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 199, 188, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 56, 82));
        jLabel2.setText("Zip Code");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 248, -1, -1));

        sceneZipCode.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sceneZipCode.setForeground(new java.awt.Color(25, 56, 82));
        add(sceneZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 243, 188, -1));

        noOfVictims.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noOfVictimsKeyPressed(evt);
            }
        });
        add(noOfVictims, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 287, 188, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 56, 82));
        jLabel4.setText("# of victims");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 292, -1, -1));

        estimatedLoss.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        estimatedLoss.setForeground(new java.awt.Color(25, 56, 82));
        estimatedLoss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                estimatedLossKeyPressed(evt);
            }
        });
        add(estimatedLoss, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 331, 188, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(25, 56, 82));
        jLabel5.setText("Estimated Loss");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 336, -1, -1));

        createSceneBtn.setBackground(new java.awt.Color(255, 255, 255));
        createSceneBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        createSceneBtn.setForeground(new java.awt.Color(25, 56, 82));
        createSceneBtn.setText("Create Scene");
        createSceneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSceneBtnActionPerformed(evt);
            }
        });
        add(createSceneBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 210, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 56, 82));
        jButton1.setText("Cancel Scene");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/medical.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void sceneNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sceneNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sceneNameActionPerformed

    private void createSceneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSceneBtnActionPerformed
        int zipCode, victimCount, loss;
        if("".equals(sceneName.getText())){
            JOptionPane.showMessageDialog(null, "Scene Name is mandatory");
        }else if("".equals(sceneZipCode.getText())){
            JOptionPane.showMessageDialog(null, "Scene Zip Code is mandatory");
        }else if(!Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$").matcher(sceneZipCode.getText()).matches()) {
            JOptionPane.showMessageDialog(null, "Scene Zip Code is not in the correct format");
        }else if("".equals(noOfVictims.getText())){
            JOptionPane.showMessageDialog(null, "No of victims is mandatory");
        }else if("".equals(estimatedLoss.getText())){
            JOptionPane.showMessageDialog(null, "Estimated Loss is mandatory");
        }else {
            try {
                zipCode = Integer.parseInt(sceneZipCode.getText());
                victimCount = Integer.parseInt(noOfVictims.getText());
                loss = Integer.parseInt(estimatedLoss.getText());
            String msg = JOptionPane.showInputDialog("Additional Message");
            VolunteerUnitRequest sceneReq = new VolunteerUnitRequest();
            sceneReq.setSceneName(sceneName.getText());
            sceneReq.setSceneZipcode(sceneZipCode.getText());
            sceneReq.setNoOfVictims(Integer.parseInt(noOfVictims.getText()));
            sceneReq.setEstimatedLoss(estimatedLoss.getText());
            sceneReq.setRequestDate(new Date());
            sceneReq.setMessage(msg);
            sceneReq.setStatus("Requested");
            sceneReq.setSender(account);
            organization.getWorkQueue().getWorkRequestList().add(sceneReq);
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                if(e instanceof MitigationUnit) {
                    e.getWorkQueue().getWorkRequestList().add(sceneReq);
                }
            }
            JOptionPane.showMessageDialog(null, "Scene Created Successfully");
            populateSceneTable();
            resetFields();
        }catch(NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "ZipCode, no of victimes and estimated loss need to be in integer!");
            }
        }
    }//GEN-LAST:event_createSceneBtnActionPerformed
    
    public void resetFields() {
        sceneName.setText("");
        sceneZipCode.setText("");
        noOfVictims.setText("");
        estimatedLoss.setText("");

    
    }
        
    
    private void sceneNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sceneNameFocusLost
        //JOptionPane.showMessageDialog(null, "fsff");
    }//GEN-LAST:event_sceneNameFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = tblScene.getSelectedRow();        
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a Scene", "Warning", JOptionPane.WARNING_MESSAGE);
        }else{
            VolunteerUnitRequest selectedWorkReq = (VolunteerUnitRequest)tblScene.getValueAt(selectedRow, 0);
            if(selectedWorkReq.getStatus().equals("Requested")) {
                String msg = JOptionPane.showInputDialog("Additional Message");
                selectedWorkReq.setStatus("Cancelled");
                selectedWorkReq.setMessage(msg);
                JOptionPane.showMessageDialog(null, "Scene Request has been cancelled");
            }else if(selectedWorkReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "Request has already been rejected");
            }else {
                JOptionPane.showMessageDialog(null, "Request is already processed and cannot be cancelled.");
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void noOfVictimsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noOfVictimsKeyPressed

    }//GEN-LAST:event_noOfVictimsKeyPressed

    private void estimatedLossKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estimatedLossKeyPressed

    }//GEN-LAST:event_estimatedLossKeyPressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createSceneBtn;
    private javax.swing.JTextField estimatedLoss;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField noOfVictims;
    private javax.swing.JTextField sceneName;
    private javax.swing.JTextField sceneZipCode;
    private javax.swing.JTable tblScene;
    // End of variables declaration//GEN-END:variables
}
