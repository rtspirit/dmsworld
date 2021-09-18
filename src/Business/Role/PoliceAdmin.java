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
import userinterface.PoliceWorkArea.PoliceAdminWorkArea;

/**
 *
 * @author rtspi
 */
public class PoliceAdmin extends Role {
    
    public PoliceAdmin(){
        
        this.type = Role.RoleType.PoliceAdmin;
        
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        this.type = Role.RoleType.PoliceAdmin;
        return new PoliceAdminWorkArea(userProcessContainer, account, organization, enterprise, network, business);       }
    
    
}
