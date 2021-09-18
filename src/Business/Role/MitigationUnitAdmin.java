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
import userinterface.MitigationUnitWorkArea.MitigationUnitAdminJPanel;

/**
 *
 * @author rtspi
 */
public class MitigationUnitAdmin extends Role {

    public MitigationUnitAdmin() {
        
        this.type = Role.RoleType.MitigationUnitAdmin; 
    }
    
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        this.type = Role.RoleType.MitigationUnitAdmin;
        return new MitigationUnitAdminJPanel(userProcessContainer, enterprise,system, organization);
    }
    
}
