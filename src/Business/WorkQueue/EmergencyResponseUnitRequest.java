/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;

import Business.Network.Network;
import Business.Organization.Organization;

/**
 *
 * @author rtspi
 */
public class EmergencyResponseUnitRequest extends WorkRequest{
    
    private Organization senderOrganization;
    private Organization recieverOrganization;
    private Network senderNetwork;
    private Network recieverNetwork;
    private String requirements;
    private String id;
    private String disasterType;
    private int casualties;
    private String estimatedLoss;
    private String zipCode;
    private Employee sceneManager;
    private String emergencyReqId;
    
   
    
    public EmergencyResponseUnitRequest() {
        int num = (int) (Math.random()*10);
        id = "D" + num;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Organization getSenderOrganization() {
        return senderOrganization;
    }

    public void setSenderOrganization(Organization senderOrganization) {
        this.senderOrganization = senderOrganization;
    }

    public Organization getRecieverOrganization() {
        return recieverOrganization;
    }

    public void setRecieverOrganization(Organization recieverOrganization) {
        this.recieverOrganization = recieverOrganization;
    }

    public Network getSenderNetwork() {
        return senderNetwork;
    }

    public void setSenderNetwork(Network senderNetwork) {
        this.senderNetwork = senderNetwork;
    }

    public Network getRecieverNetwork() {
        return recieverNetwork;
    }

    public void setRecieverNetwork(Network recieverNetwork) {
        this.recieverNetwork = recieverNetwork;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public int getCasualties() {
        return casualties;
    }

    public void setCasualties(int casualties) {
        this.casualties = casualties;
    }

    public String getEstimatedLoss() {
        return estimatedLoss;
    }

    public void setEstimatedLoss(String estimatedLoss) {
        this.estimatedLoss = estimatedLoss;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public Employee getSceneManager() {
        return sceneManager;
    }

    public void setSceneManager(Employee sceneManager) {
        this.sceneManager = sceneManager;
    }


    public String getEmergencyReqId() {
        return emergencyReqId;
    }

    public void setEmergencyReqId(String emergencyReqId) {
        this.emergencyReqId = emergencyReqId;
    }

    @Override
    public String toString() {
        return disasterType;
    }

    
}