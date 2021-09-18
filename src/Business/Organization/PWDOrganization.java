/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PWDAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class PWDOrganization extends Organization{
    
    public String pwdName;
    
    public PWDOrganization(String name){
        
        super(name);
        this.pwdName = name;
    }

    public String getPwdName() {
        return pwdName;
    }

    public void setPwdName(String pwdName) {
        this.pwdName = pwdName;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PWDAdmin());
        return roles ;
        
    }
    
    @Override
    public Type getType() {
        return Organization.Type.PWDOrganization; //To change body of generated methods, choose Tools | Templates.
    }
}
