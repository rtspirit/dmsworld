/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PoliceAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class PoliceOrganization extends Organization{
    
    public String policename;
    
    public PoliceOrganization(String name){
        super(name);
        this.policename = name;
    }

    public String getPolicename() {
        return policename;
    }

    public void setPolicename(String policename) {
        this.policename = policename;
    }
    
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PoliceAdmin());
        return roles;
    }

    @Override
    public Type getType() {
        return Organization.Type.PoliceDepartment; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
