/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.ContractorAdmin;
import Business.Role.PWDAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class MitigationUnit extends Enterprise{
    
    public MitigationUnit(String name){
    super(name, Enterprise.EnterpriseType.MitigationUnit);
}

    @Override
    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new PWDAdmin());
        roles.add(new ContractorAdmin());
        return roles;
    }
    
}
