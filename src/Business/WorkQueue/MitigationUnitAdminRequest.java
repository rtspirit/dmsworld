/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Employee.Employee;

/**
 *
 * @author rtspi
 */
public class MitigationUnitAdminRequest extends WorkRequest {

    private String sceneName;
    private String id;
    private int noOfVictims;
    private String estimatedLoss;
    private String sceneZipcode;
    private Employee sceneManager;


    
    
    public MitigationUnitAdminRequest() {
       int num = (int) (Math.random()*10);
        id = "INC"+num;
    }
    

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNoOfVictims() {
        return noOfVictims;
    }

    public void setNoOfVictims(int noOfVictims) {
        this.noOfVictims = noOfVictims;
    }

    public String getEstimatedLoss() {
        return estimatedLoss;
    }

    public void setEstimatedLoss(String estimatedLoss) {
        this.estimatedLoss = estimatedLoss;
    }

    public String getSceneZipcode() {
        return sceneZipcode;
    }

    public void setSceneZipcode(String sceneZipcode) {
        this.sceneZipcode = sceneZipcode;
    }


    public Employee getSceneManager() {
        return sceneManager;
    }

    public void setSceneManager(Employee sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public String toString() {
        return id;
    }

}
