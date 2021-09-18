/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FireSafetyAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class FireSafetyOrganization extends Organization {
    
    public String fireDeptName;

    public FireSafetyOrganization(String name) {
        super(name);
        this.fireDeptName = name;
    }

    public String getFireDeptName() {
        return fireDeptName;
    }

    public void setFireDeptName(String fireDeptName) {
        this.fireDeptName = fireDeptName;
    }
    
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FireSafetyAdmin());
        return roles;
    }

    @Override
    public Type getType() {
        return Organization.Type.FireDepartment; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
