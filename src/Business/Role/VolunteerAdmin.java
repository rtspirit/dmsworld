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
import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

/**
 *
 * @author rtspi
 */
public class VolunteerAdmin extends Role {
    
    public VolunteerAdmin(){
        
        this.type= Role.RoleType.VolunteersAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        this.type= Role.RoleType.VolunteersAdmin;
        return new SystemAdminWorkAreaJPanel(userProcessContainer, account, system);  //To change body of generated methods, choose Tools | Templates.
    }
    
}
