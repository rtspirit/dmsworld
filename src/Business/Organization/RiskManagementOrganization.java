/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FinanceAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class RiskManagementOrganization extends Organization {
    
    public String managementOrg;
    
    public RiskManagementOrganization(String name){
        super(name);
        this.managementOrg = name;
        
    }

    public String getManagementOrg() {
        return managementOrg;
    }

    public void setManagementOrg(String managementOrg) {
        this.managementOrg = managementOrg;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FinanceAdmin());
        return roles;
    }

    @Override
    public Type getType() {
        return Organization.Type.Management; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
