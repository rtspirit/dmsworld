/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DisasterManagementHead.DisasterManagmentHeadAdminJPanel;
import userinterface.DisasterManagementHead.ManageDisastersJPanel;

/**
 *
 * @author rtspi
 */
public class DisasterManagementHead extends Role{
    
    public DisasterManagementHead(){
        
        this.type = Role.RoleType.DisasterManagementHead;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        this.type = Role.RoleType.DisasterManagementHead;
        return new DisasterManagmentHeadAdminJPanel(userProcessContainer,enterprise,system,organization,network, account);

    }
    
}
