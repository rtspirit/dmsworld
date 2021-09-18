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
import userinterface.EmergencyResponseUnitWorkArea.EmergencyResponseUnitAdminJPanel;

/**
 *
 * @author rtspi
 */
public class EmergencyUnitAdmin extends Role {

    public EmergencyUnitAdmin() {
        
        this.type = Role.RoleType.EmergencyUnitAdmin; 
    }
    
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        this.type = Role.RoleType.EmergencyUnitAdmin;   
        return new EmergencyResponseUnitAdminJPanel(userProcessContainer, enterprise,system);
    }
    
}
