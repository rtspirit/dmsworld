package Business;


import Business.Employee.Employee;
import Business.Role.DisasterManagementHead;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rtspi
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        
//        Employee employee = new Employee();
//        employee.setName("Rahul Tiwari");
//        
//        UserAccount ua = new UserAccount();
//        ua.setUsername("rtspirit");
//        ua.setPassword("super");
//        ua.setRole(new SystemAdminRole());
//        ua.setEmployee(employee);
//        
//        sysadminOrganization.getEmployeeDirectory().getEmployeeList().add(employee);
//        sysadminOrganization.getUserAccountDirectory().getUserAccountList().add(ua);
        
        Employee employee = system.getEmployeeDirectory().createEmployee("Rahul Tiwari");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        
//        Employee employee1 = system.getEmployeeDirectory().createEmployee("DisasterHeadBoston");
//        UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("abc", "abc", employee1, new SystemAdminRole());
        return system;
    }
    
}
