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
import userinterface.FireSafetyWorkArea.FireSafetyAdminWorkAreaJPanel;

/**
 *
 * @author rtspi
 */
public class FireSafetyAdmin extends Role {
    
    public FireSafetyAdmin(){
    
    this.type = Role.RoleType.FireAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        this.type = Role.RoleType.FireAdmin;
        return new FireSafetyAdminWorkAreaJPanel(userProcessContainer,account, organization,enterprise, network,system); //To change body of generated methods, choose Tools | Templates.
    }
}
