/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DisasterManagementHead;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class DisasterManagementOrganization extends Organization{
    
    String name;
    String disasterType;

    public DisasterManagementOrganization(String name) {
        super(name);
        
        this.name=name;
        this.disasterType=name;
    }
    
    


    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DisasterManagementHead());
        return roles;
    }

    @Override
    public Type getType() {
        return Organization.Type.DisasterHead; 
    }
    
    
    
}
