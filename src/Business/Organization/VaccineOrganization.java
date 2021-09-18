/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.VaccineAdmin;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class VaccineOrganization extends Organization{
    
    public String vaccineOrg;
    
    public VaccineOrganization(String name){
        
        super(name);
        this.vaccineOrg = name;
    }

    public String getVaccineOrg() {
        return vaccineOrg;
    }

    public void setVaccineOrg(String vaccineOrg) {
        this.vaccineOrg = vaccineOrg;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new VaccineAdmin());
        return roles ;
    }

    @Override
    public Type getType() {
        return Organization.Type.Vaccine; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
