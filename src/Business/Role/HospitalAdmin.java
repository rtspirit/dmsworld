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
import userinterface.HospitalWorkArea.HospitalAdminWorkAreaJPanel;

/**
 *
 * @author rtspi
 */
public class HospitalAdmin extends Role{
    
    public HospitalAdmin(){
    
        this.type = Role.RoleType.HospitalAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        
        this.type = Role.RoleType.HospitalAdmin;
        return new HospitalAdminWorkAreaJPanel(userProcessContainer, account, organization, enterprise, network, business);
    }
        
}
