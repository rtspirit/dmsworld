/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.HospitalAdmin;
import Business.Role.Role;
import Business.Role.VolunteerAdmin;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class RecoveryUnit extends Enterprise{
    
    public RecoveryUnit(String name){
        
        super(name, Enterprise.EnterpriseType.RecoveryUnit);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new HospitalAdmin());
        roles.add(new VolunteerAdmin());
        return roles;
    }
    
}
