/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;
import Business.Network.Network;

/**
 *
 * @author rtspi
 */
public class DisasterHeadWorkRequest extends WorkRequest {
    
    private String id;
    private String disasterType;
    private String location;
    private int casualties;
    private Employee workingUnit;
    private String zipCode;

    public DisasterHeadWorkRequest() {
        
        int num = (int) (Math.random()*10);
        id = "D" + num;        
         
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    

    public int getCasualties() {
        return casualties;
    }

    public void setCasualties(int casualties) {
        this.casualties = casualties;
    }

    public Employee getWorkingUnit() {
        return workingUnit;
    }

    public void setWorkingUnit(Employee workingUnit) {
        this.workingUnit = workingUnit;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
    
    
    
}
