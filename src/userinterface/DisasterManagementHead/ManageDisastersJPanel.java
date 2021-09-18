/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DisasterManagementHead;

import Business.EcoSystem;
import Business.Enterprise.EmergencyResponseUnit;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.EmergencyResponseUnit;
import Business.Network.Network;
import Business.Organization.DisasterManagementOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DisasterHeadWorkRequest;
import Business.WorkQueue.EmergencyResponseUnitRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rtspi
 */
public class ManageDisastersJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;
    Organization organization;
    Network network;
    UserAccount account;
    /**
     * Creates new form ManageDisastersJPanel
     * 
     */
    public ManageDisastersJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system, Organization organization, Network network,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.organization = organization;
        this.network = network;
        this.account = account;
        populateNetworkComboBox();
        populateDisasterTable();
    }
    
    public void populateDisasterTable(){
        DefaultTableModel model = (DefaultTableModel) disasterJTable.getModel();
        
        model.setRowCount(0);
        for (WorkRequest workrequest : account.getWorkQueue().getWorkRequestList()){
            
            if (workrequest instanceof EmergencyResponseUnitRequest) {
                Object[] row = new Object[8];
                
                row[0] = ((EmergencyResponseUnitRequest) workrequest).getId();
                row[1] = ((EmergencyResponseUnitRequest) workrequest).getDisasterType();
                row[2] = ((EmergencyResponseUnitRequest) workrequest).getSenderNetwork();
                row[3] = ((EmergencyResponseUnitRequest) workrequest).getZipCode();
                row[4] = ((EmergencyResponseUnitRequest) workrequest).getCasualties();
                row[6] = ((EmergencyResponseUnitRequest) workrequest).getStatus();
                row[5] = ((EmergencyResponseUnitRequest) workrequest).getRequestDate();
                //row[7] = ((EmergencyResponseUnitRequest) workrequest).getMessage();
                //row[2] = org.getPosition();
                model.addRow(row);
            }
    }
    }
        
        private void populateNetworkComboBox(){
            networkJComboBox.removeAllItems();
               
            for (Network network1 : system.getNetworkList()){
                networkJComboBox.addItem(network1);
//                networkJComboBox.addItem("Massachussets");
//                networkJComboBox.addItem("New Jersey");
//                networkJComboBox.addItem("New York");
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
        disasterJTable = new javax.swing.JTable();
        txtCasualties = new javax.swing.JTextField();
        txtDisasterType = new javax.swing.JTextField();
        txtZipCode = new javax.swing.JTextField();
        lblCasualties = new javax.swing.JLabel();
        lblDisasterType = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblZipcode = new javax.swing.JLabel();
        btnReport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        networkJComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        disasterJTable.setBackground(new java.awt.Color(0, 0, 0));
        disasterJTable.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        disasterJTable.setForeground(new java.awt.Color(255, 255, 255));
        disasterJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Disaster ID", "Disaster Type", "Location", "Zipcode", "Casualties", "Date", "Status"
            }
        ));
        jScrollPane1.setViewportView(disasterJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 870, 100));

        txtCasualties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCasualtiesActionPerformed(evt);
            }
        });
        add(txtCasualties, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 210, 30));

        txtDisasterType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisasterTypeActionPerformed(evt);
            }
        });
        add(txtDisasterType, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 210, 30));

        txtZipCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZipCodeActionPerformed(evt);
            }
        });
        add(txtZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 210, 30));

        lblCasualties.setBackground(new java.awt.Color(0, 0, 0));
        lblCasualties.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblCasualties.setForeground(new java.awt.Color(255, 255, 255));
        lblCasualties.setText("Casualties");
        add(lblCasualties, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, -1, 30));

        lblDisasterType.setBackground(new java.awt.Color(0, 0, 0));
        lblDisasterType.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblDisasterType.setForeground(new java.awt.Color(255, 255, 255));
        lblDisasterType.setText("Disaster Type");
        add(lblDisasterType, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 20));

        lblLocation.setBackground(new java.awt.Color(0, 0, 0));
        lblLocation.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblLocation.setForeground(new java.awt.Color(255, 255, 255));
        lblLocation.setText("Location");
        add(lblLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, 30));

        lblZipcode.setBackground(new java.awt.Color(0, 0, 0));
        lblZipcode.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblZipcode.setForeground(new java.awt.Color(255, 255, 255));
        lblZipcode.setText("ZipCode");
        add(lblZipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, 30));

        btnReport.setBackground(new java.awt.Color(0, 0, 0));
        btnReport.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setText("Report Disaster");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 140, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REPORT A DISASTER");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 270, 30));

        networkJComboBox.setBackground(new java.awt.Color(0, 0, 0));
        networkJComboBox.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        networkJComboBox.setForeground(new java.awt.Color(255, 255, 255));
        networkJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkJComboBoxActionPerformed(evt);
            }
        });
        add(networkJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 210, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCasualtiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCasualtiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCasualtiesActionPerformed

    private void txtDisasterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisasterTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisasterTypeActionPerformed

    private void txtZipCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZipCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZipCodeActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        Network network2 = (Network) networkJComboBox.getSelectedItem();
        String net = String.valueOf(network2);
        if(network ==null){
            JOptionPane.showMessageDialog(null, "Please select a location");
        }
        
        if(txtDisasterType.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Disaster Type cannot be empty");
        }else if(txtZipCode.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Zipcode cannot be empty");
        }else if(txtCasualties.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Casualties cannot be empty");
        }else{
            try{
                int zipCode = Integer.parseInt(txtZipCode.getText());
                int casualties = Integer.parseInt(txtCasualties.getText());
                
                EmergencyResponseUnitRequest request = new EmergencyResponseUnitRequest();
                request.setDisasterType(txtDisasterType.getText());
                request.setZipCode(txtZipCode.getText());
                request.setCasualties(casualties);
                request.setSenderNetwork(network2);
                request.setStatus("Requested");  
                request.setSender(account);
                organization.getWorkQueue().getWorkRequestList().add(request);
                System.out.println("request" + request);
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    System.out.println("Getting enterprise directory" +ent.toString());
                    
                    
                        System.out.println("Getting organization directory" + organization.toString());
                        if (ent instanceof  EmergencyResponseUnit) {
                             ent.getWorkQueue().getWorkRequestList().add(request);
                        }
                    
                }
                txtDisasterType.setText("");
                txtZipCode.setText("");
                txtCasualties.setText("");
                populateDisasterTable();
            }
            catch(NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Please enter numbers in ZipCode/Casualties");
            }
        }
    }//GEN-LAST:event_btnReportActionPerformed

    private void networkJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkJComboBoxActionPerformed
        // TODO add your handling code here:
//        Network net = (Network) networkJComboBox.getSelectedItem();
//        if (net != null){
//            populateNetworkComboBox();
//        }
    }//GEN-LAST:event_networkJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReport;
    private javax.swing.JTable disasterJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCasualties;
    private javax.swing.JLabel lblDisasterType;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblZipcode;
    private javax.swing.JComboBox<Object> networkJComboBox;
    private javax.swing.JTextField txtCasualties;
    private javax.swing.JTextField txtDisasterType;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}