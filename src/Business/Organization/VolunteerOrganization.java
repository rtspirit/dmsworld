/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.VolunteerAdmin;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class VolunteerOrganization extends Organization{
    
    public String ngoName;
    
    public VolunteerOrganization(String name){
        super(name);
        this.ngoName = name;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new VolunteerAdmin());
        return roles ;
    }

    @Override
    public Type getType() {
        return Organization.Type.Volunteer; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
