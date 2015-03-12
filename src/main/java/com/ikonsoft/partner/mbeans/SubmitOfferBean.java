/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.partner.mbeans;

import com.ikonsoft.email.SendAttachmentInEmail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@SessionScoped
public class SubmitOfferBean implements Serializable{
  
    private String requesterName;
    private String email;
    private String phone;
    private String department;
    private String offerType;
    private String offerDescription;
    private String destination = "D:/tmp/";
    private Date launchDate;
    private Date endDate;
   
    private List<SelectItem> channels;
 
    private String filepath="";
    private String filename="";

    
    public String clear1(final String parentComponentId) {
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent fc = view.findComponent(parentComponentId);
        if (null != fc) {
            List<UIComponent> components = fc.getChildren();
            for (UIComponent component : components) {
                if (component instanceof UIInput) {
                    UIInput input = (UIInput) component;
                    // JSF 1.1+
//                input.setSubmittedValue(null);
//                input.setValue(null);
//                input.setLocalValueSet(false);
//                input.setValid(true);
                    // JSF 1.2+
                    input.resetValue();
                }
            }
        }
        return null;
    }

    
    
    public String print() throws UnsupportedEncodingException {
        StringBuilder body = new StringBuilder();
        body.append("\nRequester name:").append(requesterName)
                .append("\nSender email :").append(email).append("\nPhone No:").append(phone)
                .append("\nFile path :").append(filepath).append("\nFile Name :").append(filename);
 
        System.out.println("__________Starting Printing_________________ ");

        System.out.println("Data  :\n" + body.toString());

 
 SendAttachmentInEmail.sendMail(email, "","", offerDescription, body.toString(), requesterName, filepath, filename);
      //clear();
      return "RegDone";
    }
    public void upload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Success! "+event.getFile().getFileName() + " is uploaded.", " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        filename=event.getFile().getFileName();
        filepath=destination+filename;
// Do what you want with the file
        try {

            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {

        try {

        // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {

                out.write(bytes, 0, read);
            }

            in.close();

            out.flush();

            out.close();

            System.out.println("A new file created:"+filepath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

      

    public String getRequesterName() {
        return requesterName;
    }

    /**
     * @param requesterName the requesterName to set
     */
    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the offerType
     */
    public String getOfferType() {
        return offerType;
    }

    /**
     * @param offerType the offerType to set
     */
    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    /**
     * @return the offerDescription
     */
    public String getOfferDescription() {
        return offerDescription;
    }

    /**
     * @param offerDescription the offerDescription to set
     */
    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the launchDate
     */
    public Date getLaunchDate() {
        return launchDate;
    }

    /**
     * @param launchDate the launchDate to set
     */
    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

  

    /**
     * @return the channels
     */
    public List<SelectItem> getChannels() {
        return channels;
    }

    /**
     * @param channels the channels to set
     */
    public void setChannels(List<SelectItem> channels) {
        this.channels = channels;
    }

    /**
     * @return the filepath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @param filepath the filepath to set
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    
    
 
 
    
}
