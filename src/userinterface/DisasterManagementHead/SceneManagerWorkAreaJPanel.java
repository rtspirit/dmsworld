/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DisasterManagementHead;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MitigationUnit;
import Business.Enterprise.RecoveryUnit;
import Business.Network.Network;
import Business.Organization.DisasterManagementOrganization;
import Business.Organization.DisasterReportingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Utility.SendEmailUtility;
import Business.WorkQueue.BroadcastAlertRequest;
import Business.WorkQueue.EmergencyResponseUnitRequest;
import Business.WorkQueue.MitigationUnitAdminRequest;
import Business.WorkQueue.UserRegistrationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author dhankuwarsisodiya
 */
public class SceneManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SceneManagerWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    EcoSystem business;
    Organization organization;
    MitigationUnitAdminRequest selectedWorkReq;
    
    public SceneManagerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.enterprise = enterprise;
        this.network = network;
        this.organization = organization;
        selectedWorkReq = null;
        populateSceneTable();
        populateStatusTable();
    }

    private void populateStatusTable() {

        DefaultTableModel model = (DefaultTableModel) statusTable.getModel();
        model.setRowCount(0);
        for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()) {            
            if(wr instanceof EmergencyResponseUnitRequest && null != selectedWorkReq) {//selectedWorkReq.getSceneId().equals(((EmergencyUnitRequest) wr).getSceneId())) {
                
                if(selectedWorkReq.getId().equals(((EmergencyResponseUnitRequest) wr).getId())) {
                    Object[] row = new Object[model.getColumnCount()];                
                    row[0] = ((EmergencyResponseUnitRequest) wr);
                    row[1] = ((EmergencyResponseUnitRequest) wr).getStatus();
                    row[2] = ((EmergencyResponseUnitRequest) wr).getRecieverOrganization().getName();
                    row[3] = ((EmergencyResponseUnitRequest) wr).getRequestDate();
                    row[4] = ((EmergencyResponseUnitRequest) wr).getSender().getEmployee().getName();
                    row[5] = ((EmergencyResponseUnitRequest) wr).getMessage();
                    row[6] = ((EmergencyResponseUnitRequest) wr).getId();
                    row[7] = ((EmergencyResponseUnitRequest) wr).getRecieverNetwork().getName();
                    model.addRow(row);
                }
            }            
        }
        /*commented by mayank for (Network network : business.getNetworkList()) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if ((!(o instanceof DisasterOrganization)) && (!(o instanceof IncidentManagementOrganization))) {
                        for (WorkRequest wr : o.getWorkQueue().getWorkRequestList()) {
                            if(((EmergencyUnitRequest) wr).getSceneManager() != null && ((EmergencyUnitRequest) wr).getSceneManager().equals(account.getEmployee())){
                                Object[] row = new Object[7];
                                row[0] = o.getName();
                                row[1] = ((EmergencyUnitRequest) wr).getStatus();
                                row[2] = o.getName();
                                row[3] = wr.getRequestDate();
                                row[4] = ((EmergencyUnitRequest) wr).getSender();
                                row[5] = ((EmergencyUnitRequest) wr).getMessage();
                                row[6] = ((EmergencyUnitRequest) wr).getSceneId();
                                model.addRow(row);
                            }
                        }
                    }
                }
            }
        }*/
    }

    private void populateSceneTable() {
     
        DefaultTableModel model = (DefaultTableModel) sceneTable.getModel();
        model.setRowCount(0);
        
        for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()) {
            if(wr instanceof MitigationUnitAdminRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = ((MitigationUnitAdminRequest) wr);
                row[1] = ((MitigationUnitAdminRequest) wr).getSceneName();
                row[2] = ((MitigationUnitAdminRequest) wr).getNoOfVictims();
                row[3] = ((MitigationUnitAdminRequest) wr).getSceneZipcode();
                row[4] = ((MitigationUnitAdminRequest) wr).getSender();
                row[5] = ((MitigationUnitAdminRequest) wr).getStatus();
                row[6] = ((MitigationUnitAdminRequest) wr).getRequestDate();
                row[7] = ((MitigationUnitAdminRequest) wr).getMessage();
                model.addRow(row);
            }
        }
        
        /* commented by mayank for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                if (o instanceof DisasterOrganization) {
                    for (WorkRequest wr : o.getWorkQueue().getWorkRequestList()) {
                        if (wr instanceof ReportingAdminSceneRequest ){//&& ((ReportingAdminSceneRequest) wr).getSceneManager().equals(account.getEmployee())) {
=======
//        for(WorkRequest wr: account.getWorkQueue().getWorkRequestList()){
//            Object[] row = new Object[5];
//                            row[0] = ((ReportingAdminSceneRequest) wr).getSceneId();
//                            row[1] = ((ReportingAdminSceneRequest) wr).getSceneName();
//                            row[2] = ((ReportingAdminSceneRequest) wr).getNoOfVictims();
//                            row[3] = ((ReportingAdminSceneRequest) wr).getSceneZipcode();
//                            row[4] = ((ReportingAdminSceneRequest) wr).getSender();
//
//                            model.addRow(row);
//        }
//        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
//            for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
//                
//                if (o instanceof DisasterOrganization) {
                    for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
                        if (wr instanceof ReportingAdminSceneRequest &&((ReportingAdminSceneRequest) wr).getSceneManager() != null && ((ReportingAdminSceneRequest) wr).getSceneManager().equals(account.getEmployee())) {
                            Object[] row = new Object[5];
                            row[0] = ((ReportingAdminSceneRequest) wr).getSceneId();
                            row[1] = ((ReportingAdminSceneRequest) wr).getSceneName();
                            row[2] = ((ReportingAdminSceneRequest) wr).getNoOfVictims();
                            row[3] = ((ReportingAdminSceneRequest) wr).getSceneZipcode();
                            row[4] = ((ReportingAdminSceneRequest) wr).getSender();

                            model.addRow(row);
                        }
                    }
                }
            }

        }*/
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
        sceneTable = new javax.swing.JTable();
        nearestOrgSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        statusTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        processBtn = new javax.swing.JButton();
        cancelReqBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1338, 840));
        setPreferredSize(new java.awt.Dimension(1338, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sceneTable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        sceneTable.setForeground(new java.awt.Color(25, 56, 82));
        sceneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Scene Id", "Scene Name", "Victims", "ZipCode", "Sender", "Status", "Created Date", "Additional Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sceneTable.setSelectionBackground(new java.awt.Color(56, 90, 174));
        sceneTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sceneTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sceneTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 1250, 101));

        nearestOrgSearch.setBackground(new java.awt.Color(255, 255, 255));
        nearestOrgSearch.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        nearestOrgSearch.setForeground(new java.awt.Color(25, 56, 82));
        nearestOrgSearch.setText("Search for nearest Organization");
        nearestOrgSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nearestOrgSearchActionPerformed(evt);
            }
        });
        add(nearestOrgSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, -1));

        statusTable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        statusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Emergency Req#", "Status", "Reciever Org", "Request Date", "Sender", "Message", "Scene Id", "Reciever Network"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        statusTable.setSelectionBackground(new java.awt.Color(56, 90, 174));
        jScrollPane2.setViewportView(statusTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 1250, 129));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 56, 82));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(25, 56, 82));
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(25, 56, 82));
        jButton3.setText("Mark Resolved");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 290, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(25, 56, 82));
        jButton4.setText("Broadcast Alerts");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        processBtn.setBackground(new java.awt.Color(255, 255, 255));
        processBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        processBtn.setForeground(new java.awt.Color(25, 56, 82));
        processBtn.setText("Process");
        processBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processBtnActionPerformed(evt);
            }
        });
        add(processBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, -1, -1));

        cancelReqBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelReqBtn.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        cancelReqBtn.setForeground(new java.awt.Color(25, 56, 82));
        cancelReqBtn.setText("Cancel Request");
        cancelReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelReqBtnActionPerformed(evt);
            }
        });
        add(cancelReqBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 560, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 56, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MANAGE SCENE WORK AREA");
        jLabel1.setToolTipText("");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 730, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/manager128x.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/disasterNaturalOpaque.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 56, 82));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SCENE LIST");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 780, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(25, 56, 82));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("EMERGENCY REQUEST LIST");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 380, 850, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nearestOrgSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nearestOrgSearchActionPerformed
        // TODO add your handling code here:
        int selectedRow = sceneTable.getSelectedRow();        
        MitigationUnitAdminRequest selectedScene = null;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the row to view nearest organizations", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            selectedScene = (MitigationUnitAdminRequest) sceneTable.getValueAt(selectedRow, 0);
            /*for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if (o instanceof DisasterOrganization) {
                        for (WorkRequest wr : o.getWorkQueue().getWorkRequestList()) {
                            if (wr instanceof ReportingAdminSceneRequest && ((ReportingAdminSceneRequest) wr).getSceneManager().equals(account.getEmployee()) && ((ReportingAdminSceneRequest) wr).getSceneId() != null && ((ReportingAdminSceneRequest) wr).getSceneId().equals(id)) {
                                selectedScene = wr;
                            }
                        }
                    }
                }
            }*/
            if(selectedScene.getStatus().equals("Resolved")) {
                JOptionPane.showMessageDialog(null, "Scene is already Resolved");
            }else if(selectedScene.getStatus().equals("Scene Manager Assigned")) {
                JOptionPane.showMessageDialog(null, "Please process the scene before sending emergency requests to organizations");
            }
        }
    }//GEN-LAST:event_nearestOrgSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        populateSceneTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        populateStatusTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = sceneTable.getSelectedRow();        
        MitigationUnitAdminRequest selectedScene = null;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a Scene", "Warning", JOptionPane.WARNING_MESSAGE);
        }else {
            boolean isReqCompleted = true;
            for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()) {            
                if(wr instanceof EmergencyResponseUnitRequest && null != selectedWorkReq) {
                    if(selectedWorkReq.getId().equals(((EmergencyResponseUnitRequest) wr).getId())) {
                        if(!((EmergencyResponseUnitRequest)wr).getStatus().equals("Completed") && !((EmergencyResponseUnitRequest)wr).getStatus().equals("Cancelled") && !((EmergencyResponseUnitRequest)wr).getStatus().equals("Rejected")) {
                            isReqCompleted = false;
                            break;
                        }
                    }
                }            
            }
            
            if(isReqCompleted) {
                MitigationUnitAdminRequest sScene = (MitigationUnitAdminRequest) sceneTable.getValueAt(selectedRow, 0);
                if(sScene.getStatus().equals("Resolved")) {
                    JOptionPane.showMessageDialog(null, "Scene is already Resolved");
                }else if(sScene.getStatus().equals("Scene Manager Assigned")) {
                    JOptionPane.showMessageDialog(null, "Please process the scene before marking resolved");
                }else {
                    String msg = JOptionPane.showInputDialog("Additional Message");                    
                    sScene.setStatus("Resolved");
                    sScene.setMessage(msg);
                }
                
            }else {
                JOptionPane.showMessageDialog(null, "There are pending emergency requests for this scene. Please wait for them to be completed before marking resolved.");
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sceneTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sceneTableMouseClicked
        
        int selectedReq = sceneTable.getSelectedRow();
        if(selectedReq >= 0){
        selectedWorkReq = (MitigationUnitAdminRequest)sceneTable.getValueAt(selectedReq, 0);
        populateStatusTable();
        }
    }//GEN-LAST:event_sceneTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //String text = "one two three four five six seven eight nine ten ";
        String emailIds = "";
        String contacts = "";
        JTextArea textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setRows(5);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setSize(textArea.getPreferredSize().width, 1);
        int result = JOptionPane.showConfirmDialog(null, new JScrollPane(textArea), "Enter Alert to be broadcasted!", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            BroadcastAlertRequest alertRequest = new BroadcastAlertRequest();
            alertRequest.setAlertMessage(textArea.getText());
            alertRequest.setSender(account);
            alertRequest.setRequestDate(new Date());
            alertRequest.setInNetwork(network);
            
            for(Network n : business.getNetworkList()) {
                for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                    System.out.println("1===--->> " + e.getName());
                    for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                        o.getWorkQueue().getWorkRequestList().add(alertRequest);
                    }
                    if(e instanceof RecoveryUnit) {
                        System.out.println("2===--->> " + e.getName());
                        for(WorkRequest wr : e.getWorkQueue().getWorkRequestList()) {
                            System.out.println("3===--->> " + e.getName());
                            if(wr instanceof UserRegistrationRequest) {
                                System.out.println("4===--->> " + e.getName());
                                emailIds += ((UserRegistrationRequest) wr).getUserEmailId() + ",";
                                
                            }
                        }
                    }
                }
            }
            
            String broadcastMsg = new Date() + "; Broadcasted by: " + account.getEmployee().getName() + "(Scene Manager)\n";
            broadcastMsg += "Alert Message: " + textArea.getText();
            
            
            JOptionPane.showMessageDialog(null, "Alert has been broadcasted successfully");
        } else {
            System.out.println("Canceled");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void processBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processBtnActionPerformed
        int selectedRow = sceneTable.getSelectedRow();        
        MitigationUnitAdminRequest selectedScene = null;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the scene", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            selectedScene = (MitigationUnitAdminRequest) sceneTable.getValueAt(selectedRow, 0);
            if(selectedScene.getStatus().equals("Processing")) {
                JOptionPane.showMessageDialog(null, "Scene is already in Processing state");
            }else if(selectedScene.getStatus().equals("Resolved")) {
                JOptionPane.showMessageDialog(null, "Scene is already Resolved");
            }else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                selectedScene.setStatus("Processing");
                selectedScene.setMessage(msg);
                populateSceneTable();
            }
            
        }
    }//GEN-LAST:event_processBtnActionPerformed

    private void cancelReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelReqBtnActionPerformed
        int selectedRow = statusTable.getSelectedRow();        
        EmergencyResponseUnitRequest selectedReq = null;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            selectedReq = (EmergencyResponseUnitRequest) statusTable.getValueAt(selectedRow, 0);
            if(selectedReq.getStatus().equals("Processing") || selectedReq.getStatus().equals("Completed")) {
                JOptionPane.showMessageDialog(null, "This request canot be cancelled");
            }else if(selectedReq.getStatus().equals("Cancelled")) {
                JOptionPane.showMessageDialog(null, "This request is already cancelled");
            }else if(selectedReq.getStatus().equals("Rejected")) {
                JOptionPane.showMessageDialog(null, "This request has already been rejected");
            } else {
                String msg = JOptionPane.showInputDialog("Additional Message");
                selectedReq.setStatus("Cancelled");
                selectedReq.setMessage(msg);
                JOptionPane.showMessageDialog(null, "This request has been cancelled");
                populateStatusTable();
            }            
        }
    }//GEN-LAST:event_cancelReqBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelReqBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nearestOrgSearch;
    private javax.swing.JButton processBtn;
    private javax.swing.JTable sceneTable;
    private javax.swing.JTable statusTable;
    // End of variables declaration//GEN-END:variables
}
