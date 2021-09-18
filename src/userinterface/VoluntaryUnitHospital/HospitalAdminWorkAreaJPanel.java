/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VoluntaryUnitHospital;

import userinterface.VoluntaryUnitNGO.*;
import userinterface.voluntaryUnitPersonal.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BroadcastAlertRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author shivibhatt
 */
public class HospitalAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HospitalAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    Network network;
    Organization organization;
    EcoSystem system;
    UserAccount account;
    public HospitalAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.network = network;
        this.system = system;
        populateAlerts();
        manageScene();
    }
    
    public void populateAlerts() {
        
        JTextField txtField;
        JTextArea textArea;
        alertPanel.setLayout(new GridLayout(20, 1));
        int pos = 0;
        boolean showAlertMsg = false;
        
        ArrayList<BroadcastAlertRequest> bb = new ArrayList<>();
        for(WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if(wr instanceof BroadcastAlertRequest) {
                bb.add((BroadcastAlertRequest)wr);
            }
        }
        Collections.sort(bb, (o1, o2) -> o2.getRequestDate().compareTo(o1.getRequestDate()));
        
        for(BroadcastAlertRequest wr : bb) {
            if(wr instanceof BroadcastAlertRequest) {
                if(!((BroadcastAlertRequest) wr).isIsAlertSeen()) {
                    showAlertMsg = true;
                    ((BroadcastAlertRequest) wr).setIsAlertSeen(true);
                }
                txtField = new JTextField(wr.getRequestDate() + ": Broadcasted by: " + wr.getSender().getEmployee().getName());
                txtField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
                txtField.setEditable(false);
                txtField.setVisible(true);
                textArea = new JTextArea("Network: " + ((BroadcastAlertRequest) wr).getInNetwork().getName() + "\nAlert: " + ((BroadcastAlertRequest) wr).getAlertMessage());
                textArea.setEditable(false);
                textArea.setVisible(true);
                alertPanel.add(txtField,pos);
                alertPanel.add(textArea,++pos);
                ++pos;
            }
        }
        if(showAlertMsg) {
            JOptionPane.showMessageDialog(null, "You have a new alert broadcasted.");
        }
        
    }
      private void manageScene(){
        manageScenePanel.setBackground(new Color(236,113,107));
        manageRequestPanel.setBackground(new Color(215,81,81));
        HospitalAdminManageSceneJPanel manageScene = new HospitalAdminManageSceneJPanel( rightSystemAdminPanel,  enterprise,  system,  organization,  network, account);
        rightSystemAdminPanel.add("ManageHospitalSceneJPanel", manageScene);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }
    
    private void manageRequest(){
        manageRequestPanel.setBackground(new Color(236,113,107));
        manageScenePanel.setBackground(new Color(215,81,81));
        HospitalAdminWorkRequestJPanel manageIndividualWorkRequest = new HospitalAdminWorkRequestJPanel( rightSystemAdminPanel,  account,  organization,  enterprise,  network,  system);
        rightSystemAdminPanel.add("IndividualAdminWorkAreaJPanel", manageIndividualWorkRequest);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        systemAdminPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        manageScenePanel = new javax.swing.JPanel();
        manageSceneLabel = new javax.swing.JLabel();
        manageRequestPanel = new javax.swing.JPanel();
        manageRequestLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        alertPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        rightSystemAdminPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(215, 81, 81));
        setMinimumSize(new java.awt.Dimension(1338, 840));
        setPreferredSize(new java.awt.Dimension(1338, 840));
        setLayout(new java.awt.BorderLayout());

        systemAdminPanel.setBackground(new java.awt.Color(215, 81, 81));
        systemAdminPanel.setMinimumSize(new java.awt.Dimension(1338, 840));
        systemAdminPanel.setPreferredSize(new java.awt.Dimension(1338, 840));

        jPanel3.setBackground(new java.awt.Color(215, 81, 81));
        jPanel3.setMinimumSize(new java.awt.Dimension(280, 148));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 148));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageScenePanel.setBackground(new java.awt.Color(215, 81, 81));
        manageScenePanel.setToolTipText("");
        manageScenePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageScenePanelMousePressed(evt);
            }
        });

        manageSceneLabel.setBackground(new java.awt.Color(215, 81, 81));
        manageSceneLabel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        manageSceneLabel.setText("Manage Scene");
        manageSceneLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageSceneLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout manageScenePanelLayout = new javax.swing.GroupLayout(manageScenePanel);
        manageScenePanel.setLayout(manageScenePanelLayout);
        manageScenePanelLayout.setHorizontalGroup(
            manageScenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageScenePanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(manageSceneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        manageScenePanelLayout.setVerticalGroup(
            manageScenePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageScenePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageSceneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(manageScenePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, -1));

        manageRequestPanel.setBackground(new java.awt.Color(215, 81, 81));
        manageRequestPanel.setToolTipText("");
        manageRequestPanel.setPreferredSize(new java.awt.Dimension(264, 48));
        manageRequestPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageRequestPanelMousePressed(evt);
            }
        });

        manageRequestLabel.setBackground(new java.awt.Color(215, 81, 81));
        manageRequestLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        manageRequestLabel.setText("Manage Request");
        manageRequestLabel.setAutoscrolls(true);
        manageRequestLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                manageRequestLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout manageRequestPanelLayout = new javax.swing.GroupLayout(manageRequestPanel);
        manageRequestPanel.setLayout(manageRequestPanelLayout);
        manageRequestPanelLayout.setHorizontalGroup(
            manageRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageRequestPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(manageRequestLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );
        manageRequestPanelLayout.setVerticalGroup(
            manageRequestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageRequestPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageRequestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(manageRequestPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 280, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 280, -1));

        jLabel3.setBackground(new java.awt.Color(215, 81, 81));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("HOSPITAL ORG SYSTEM");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, 10));

        jScrollPane2.setMinimumSize(new java.awt.Dimension(240, 270));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(240, 270));

        alertPanel.setBackground(new java.awt.Color(215, 81, 81));

        javax.swing.GroupLayout alertPanelLayout = new javax.swing.GroupLayout(alertPanel);
        alertPanel.setLayout(alertPanelLayout);
        alertPanelLayout.setHorizontalGroup(
            alertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );
        alertPanelLayout.setVerticalGroup(
            alertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(alertPanel);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 240, 320));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setText("ALERTS");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 70, -1));

        rightSystemAdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightSystemAdminPanel.setMinimumSize(new java.awt.Dimension(1058, 840));
        rightSystemAdminPanel.setPreferredSize(new java.awt.Dimension(1058, 840));
        rightSystemAdminPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout systemAdminPanelLayout = new javax.swing.GroupLayout(systemAdminPanel);
        systemAdminPanel.setLayout(systemAdminPanelLayout);
        systemAdminPanelLayout.setHorizontalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(systemAdminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        systemAdminPanelLayout.setVerticalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(systemAdminPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(systemAdminPanel, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("jjpanel");
    }// </editor-fold>//GEN-END:initComponents

    private void manageSceneLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageSceneLabelMousePressed
        manageScene();
    }//GEN-LAST:event_manageSceneLabelMousePressed

    private void manageScenePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageScenePanelMousePressed
        // TODO add your handling code here:
        manageScene();
    }//GEN-LAST:event_manageScenePanelMousePressed

    private void manageRequestLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageRequestLabelMousePressed
        manageRequest();
    }//GEN-LAST:event_manageRequestLabelMousePressed

    private void manageRequestPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageRequestPanelMousePressed
        // TODO add your handling code here:
        manageRequest();
    }//GEN-LAST:event_manageRequestPanelMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alertPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel manageRequestLabel;
    private javax.swing.JPanel manageRequestPanel;
    private javax.swing.JLabel manageSceneLabel;
    private javax.swing.JPanel manageScenePanel;
    private javax.swing.JPanel rightSystemAdminPanel;
    private javax.swing.JPanel systemAdminPanel;
    // End of variables declaration//GEN-END:variables
}