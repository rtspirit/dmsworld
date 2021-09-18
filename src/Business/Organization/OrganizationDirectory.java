package Business.Organization;

import Business.Organization.Organization.Type;
import Business.Organization.Organization;
import java.util.ArrayList;

/**
 *
 * @author rtspi
 */
public class OrganizationDirectory {
    
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<Organization>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type, String name){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.FireDepartment.getValue())){
            organization = new FireSafetyOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.HospitalOrganization.getValue())){
            organization = new HospitalOrganization(name);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.PWDOrganization.getValue())){
            organization = new PWDOrganization(name);
            organizationList.add(organization);
        }   
        else if(type.getValue().equals(Organization.Type.PoliceDepartment.getValue())){
            organization = new PoliceOrganization(name);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.Contractor.getValue())){
            organization = new PrivateContractorOrganization(name);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.Management.getValue())){
            organization = new RiskManagementOrganization(name);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.PoliceDepartment.getValue())){
            organization = new PoliceOrganization(name);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.Vaccine.getValue())){
            organization = new VaccineOrganization(name);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.DisasterHead.getValue())){
            organization = new DisasterManagementOrganization(name);
            organizationList.add(organization);
        }
        else if(type.getValue().equals(Organization.Type.Volunteer.getValue())){
            organization = new DisasterManagementOrganization(name);
            organizationList.add(organization);
        }
        return organization;
    }
    
    
}