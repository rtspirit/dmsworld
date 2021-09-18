/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rtspi
 */
public abstract class Role {
    
    public enum RoleType{
        SysAdmin("Sysadmin"),
        EmergencyUnitAdmin("Emergency Unit Admin"),
        MitigationUnitAdmin("Mitigation Unit Admin"),
        RecoveryUnitAdmin("Recovery Unit Admin"),
        ResourceManagementUnitAdmin("Resource Management Unit Admin"),
        DisasterManagementHead("Incharge of Disaster Scene"),
        PoliceAdmin("PoliceDepartmentAdmin"),
        PoliceIncharge("Head of Police Department"),
        FireAdmin("FireDepartmentAdmin"),
        FireSafetyIncharge("Head of Fire Department"),
        HospitalAdmin("HospitalAdmin"),
        HospitalIncharge("Head of Hospital"),
        PWDAdmin("PublicWorksDepartmentAdmin"),
        PWDHead("Director of Public Works Department"),
        VolunteersAdmin("Admin of NGO"),
        NGOHead("Head of Volunteers"),
        ContractorAdmin("PrivateContractorHead"),
        VaccineAdmin("VaccineUnitAdmin"),
        MedicalChief("Incharge of Vaccination"),
        FinanceAdmin("RiskManagementAdmin"),
        ReportingAdmin("IncidentReportingAdmin");
        
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public RoleType type;
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network,
            EcoSystem system);
    

    @Override
    public String toString() {
        return (type != null) ? this.type.getValue() : this.getClass().getName();
    }
    
    
}