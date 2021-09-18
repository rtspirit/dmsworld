/*
 * To change this template, choose Tools | Templates
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
public class SystemAdminRole extends Role{

    public SystemAdminRole() {
        
        this.type = Role.RoleType.SysAdmin;
    }
    
    

  
    public JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network,
            EcoSystem system) {
        this.type = Role.RoleType.SysAdmin;
        return new SystemAdminWorkAreaJPanel(userProcessContainer, account, system); 
    }
    
}
