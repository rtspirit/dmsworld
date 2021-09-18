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
import userinterface.RMUnitWorkArea.ResourceUnitAdminJPanel;

/**
 *
 * @author rtspi
 */
public class ResourceManagementUnitAdmin extends Role{

    public ResourceManagementUnitAdmin() {
        
        this.type = Role.RoleType.ResourceManagementUnitAdmin; 
    }
    
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        this.type = Role.RoleType.ResourceManagementUnitAdmin; 
        return new ResourceUnitAdminJPanel(userProcessContainer, enterprise,system);
    }
    
}
