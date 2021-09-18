/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.FinanceAdmin;
import Business.Role.Role;
import Business.Role.VaccineAdmin;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class ResourceManagementUnit extends Enterprise {

    public ResourceManagementUnit(String name) {
        super(name, Enterprise.EnterpriseType.ResourceManagementUnit);
    }
    


    @Override
    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new VaccineAdmin());
        roles.add(new FinanceAdmin());
        return roles;
    }
    
}
