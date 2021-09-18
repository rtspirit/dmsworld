/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.ContractorAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class PrivateContractorOrganization extends Organization {
    
    public String contractorName;
    
    public PrivateContractorOrganization(String name){
        super(name);
        this.contractorName=name;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ContractorAdmin());
        return roles ;
    }

    @Override
    public Type getType() {
        return Organization.Type.Contractor; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
