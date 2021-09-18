/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<Enterprise>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> EnterpriseList) {
        this.enterpriseList = EnterpriseList;
    }

    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.EmergencyResponseUnit) {
            enterprise = new EmergencyResponseUnit(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.MitigationUnit){
            enterprise = new MitigationUnit(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.RecoveryUnit){
            enterprise = new RecoveryUnit(name);
            enterpriseList.add(enterprise);
        }
        else if (type == Enterprise.EnterpriseType.ResourceManagementUnit){
            enterprise = new ResourceManagementUnit(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
