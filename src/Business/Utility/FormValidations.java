/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;

import Business.EcoSystem;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author rtspi
 */
public class FormValidations {
    String name = "";  
 String user = "";  
 String pass1 = "";  
 //String pass2 = "";  
 String address = "";  
 String contact = "";  
 //String pin = "";  
 String email = "";  
 //String code = "";  
  
 public String getName() {  
  return name;  
 }  
  
 public void setName(String name) {  
  this.name = name;  
 }  
  
 public String getUser() {  
  return user;  
 }  
  
 public void setUser(String user) {  
  this.user = user;  
 }  
  
 public String getPass1() {  
  return pass1;  
 }  
  
 public void setPass1(String pass1) {  
  this.pass1 = pass1;  
 }  
  
// public String getPass2() {  
//  return pass2;  
// }  
//  
// public void setPass2(String pass2) {  
//  this.pass2 = pass2;  
// }  
//  
 public String getAddress() {  
  return address;  
 }  
  
 public void setAddress(String address) {  
  this.address = address;  
 }  
  
 public String getContact() {  
  return contact;  
 }  
  
 public void setContact(String contact) {  
  this.contact = contact;  
 }  
  
// public String getPin() {  
//  return pin;  
// }  
//  
// public void setPin(String pin) {  
//  this.pin = pin;  
// }  
  
 public String getEmail() {  
  return email;  
 }  
  
 public void setEmail(String email) {  
  this.email = email;  
 }  
  
 public static final Integer ERR_NAME_BLANK = new Integer(1);  
 public static final Integer ERR_USER_BLANK = new Integer(2);  
 public static final Integer ERR_USER_LENGTH = new Integer(3);  
 public static final Integer ERR_USER_EXISTS = new Integer(4);  
 public static final Integer ERR_PASS1_BLANK = new Integer(5);  
 public static final Integer ERR_PASS1_LENGTH = new Integer(6);  
 public static final Integer ERR_PASS1_INVALID = new Integer(17);  
 public static final Integer ERR_PASS2_BLANK = new Integer(7);  
 public static final Integer ERR_PASS2_MATCH = new Integer(8);  
 public static final Integer ERR_ADDRESS_BLANK = new Integer(9);  
 public static final Integer ERR_PIN_BLANK = new Integer(10);  
 public static final Integer ERR_PIN_LENGTH = new Integer(11);  
 public static final Integer ERR_PIN_INVALID = new Integer(12);  
 public static final Integer ERR_CONTACT_BLANK = new Integer(13);  
 public static final Integer ERR_CONTACT_LENGTH = new Integer(14);  
 public static final Integer ERR_CONTACT_INVALID = new Integer(15);  
 public static final Integer ERR_EMAIL_BLANK = new Integer(16);  
 public static final Integer ERR_EMAIL_INVALID = new Integer(17);  
  
  
 Map errorCodes = new HashMap();  
 private EcoSystem system; 
 Map msgMap;  
 public void setErrorMessages(Map msgMap) {  
  this.msgMap = msgMap;  
 }  
  
 public String getErrorMessage(String propName) {  
  Integer code = (Integer)(errorCodes.get(propName));  
  if (code == null) {  
   return "";  
  } else if (msgMap != null) {  
   String msg = (String) msgMap.get(code);  
   if (msg != null) {  
    return msg;  
   }  
  }  
  return "Error";  
 }  
 public boolean isValid() {  
  
  errorCodes.clear();  
  
  if (name.length() == 0) {  
   errorCodes.put("name", ERR_NAME_BLANK);  
   JOptionPane.showMessageDialog(null, "Name cannot be blank.");
  }  
  
  if (user.length() == 0) {  
   errorCodes.put("user", ERR_USER_BLANK);  
   JOptionPane.showMessageDialog(null, "Username cannot be blank.");
  } else  
  if (user.length() < 5) {  
   errorCodes.put("user", ERR_USER_LENGTH);  
   JOptionPane.showMessageDialog(null, "Username should be atleast 5 characters long.");
  } else {  
  
   try {  
//    conn ob = new conn();  
//    Connection con = ob.c();  
//    Statement stm = con.createStatement();  
//    ResultSet rst = stm.executeQuery("select * from  client where username='" + user + "'");  
    if (!system.checkIfNetworkIsUnique(name)) {  
     errorCodes.put("user", ERR_USER_EXISTS);  
     JOptionPane.showMessageDialog(null, "Username exists. Please choose a unique username.");
    }  
  
   } catch (Exception e) {}  
  
  }  
  if (pass1.length() == 0) {  
   errorCodes.put("pass1", ERR_PASS1_BLANK);  
      JOptionPane.showMessageDialog(null, "Password cannot be blank.");
  } else  
  if (pass1.length() < 5) {  
   errorCodes.put("pass1", ERR_PASS1_LENGTH);
   JOptionPane.showMessageDialog(null, "Password should be atleast 5 characters long.");
  }  
  if(address.length() == 0){
          errorCodes.put("address", ERR_ADDRESS_BLANK);
          JOptionPane.showMessageDialog(null, "City cannot be blank.");
  }
   
  
//  if (pin.length() == 0) {  
//   errorCodes.put("pin", ERR_PIN_BLANK);  
//  } else  
//  if (pin.length() != 6) {  
//   errorCodes.put("pin", ERR_PIN_LENGTH);  
//  } else {  
//   try {  
//    long n1 = Long.parseLong(pin);  
//   } catch (NumberFormatException e) {  
//    errorCodes.put("pin", ERR_PIN_INVALID);  
//   }  
//  }  
  
  if (contact.length() == 0) {  
   errorCodes.put("contact", ERR_CONTACT_BLANK);  
   JOptionPane.showMessageDialog(null, "Contact Info cannot be blank.");
  } else if (contact.length() != 10) {  
   errorCodes.put("contact", ERR_CONTACT_LENGTH); 
   JOptionPane.showMessageDialog(null, "Contact Info should be of 10 digits.");
  } else {  
   try {  
    long n1 = Long.parseLong(contact);  
   } catch (NumberFormatException e) {  
    errorCodes.put("contact", ERR_CONTACT_INVALID);  
    JOptionPane.showMessageDialog(null, "Invalid Contact Info");
   }  
  }  
  if (email.length() == 0) {  
   errorCodes.put("email", ERR_EMAIL_BLANK);  
   JOptionPane.showMessageDialog(null, "EMAIL cannot be blank.");
  } else if (!email.matches(".+@.+\\..+")) {  
   errorCodes.put("email", ERR_EMAIL_INVALID); 
   JOptionPane.showMessageDialog(null, "Invalid email.");
  }  
  
  return errorCodes.size() == 0;  
 }  
  
 public boolean process() {  
  if (!isValid()) {  
   return false;  
  }  
  
  name = "";  
  user = "";  
  pass1 = "";  
  //pass2 = "";  
  //address = "";  
  contact = "";  
  //pin = "";  
  email = "";  
  //code = "";  
  
  errorCodes.clear();  
  return true;  
 } 
    
}
