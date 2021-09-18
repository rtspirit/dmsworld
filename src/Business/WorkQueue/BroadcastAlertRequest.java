/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Network.Network;

/**
 *
 * @author Mayank
 */
public class BroadcastAlertRequest extends WorkRequest {
    
    private String alertMessage;
    private MitigationUnitAdminRequest scene;
    private Network inNetwork;
    private boolean isAlertSeen;
    
    public BroadcastAlertRequest() {
        isAlertSeen = false;
    }
    
    public boolean isIsAlertSeen() {
        return isAlertSeen;
    }

    public void setIsAlertSeen(boolean isAlertSeen) {
        this.isAlertSeen = isAlertSeen;
    }

    public Network getInNetwork() {
        return inNetwork;
    }

    public void setInNetwork(Network inNetwork) {
        this.inNetwork = inNetwork;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public MitigationUnitAdminRequest getScene() {
        return scene;
    }

    public void setScene(MitigationUnitAdminRequest scene) {
        this.scene = scene;
    }   
    
}
