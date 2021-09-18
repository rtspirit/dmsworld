/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.FireSafetyAdmin;
import Business.Role.PoliceAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class EmergencyResponseUnit extends Enterprise{
    
    public EmergencyResponseUnit(String name){
        super(name, Enterprise.EnterpriseType.EmergencyResponseUnit);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        roles = new ArrayList<Role>();
        roles.add(new FireSafetyAdmin());
        roles.add(new PoliceAdmin());
        
        return roles;
    }
    
}
