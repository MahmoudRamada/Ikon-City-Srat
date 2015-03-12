package com.ikonsoft.partner.mbeans;

import com.ikonsoft.email.SendAttachmentInEmail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import java.util.Date;
import java.util.List;






//import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;

@ManagedBean
@SessionScoped
public class CampaignBean implements  Serializable{

    
	private static final long serialVersionUID = 1L;
	private String requesterName;
    private String email;
    private String phone;
    private String busineessType;
    private String offerType;
    private String projectName;
    private final String destination = "D:/tmp/";
    private Date launchDate;
    private Date endDate;
    private String description;
    private String objective;
    private String targetAudience;
    private List<SelectItem> channels;

    private List<String> Languages;
    
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
//            input.setSubmittedValue(null);
//            input.setValue(null);
//            input.setLocalValueSet(false);
//            input.setValid(true);
                // JSF 1.2+
                input.resetValue();
            }
        }
    }
    return null;
}

/*
private void clear(){
   this.requesterName="";
   this.email="";
   this.filename="";
   this.filepath=""; 
   this.phone="";
  this.busineessType="";
 this.offerType="";
  this.projectName="";
  this.launchDate=null;
 this.endDate=null;
   this.description="";
   this.objective="";
   this.targetAudience="";
   this.channels =null;

   this.Languages=null;
  
}
*/
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

      

    public String send(){
       StringBuilder body = new StringBuilder();
        body.append("\nRequester name:+requesterName");
        body.append("Sender email :" + email);
        body.append("\nPhone No:" + phone);
        body.append("\nBusiness type:" + busineessType);
        body.append("\nFile path :" + filepath);
        body.append("\nFile Name :" + filename); 
         System.out.println("__________Start Sending_________________ ");

        System.out.println(body.toString());
        return "Home";
        
    }
    
    public void refresh() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application application = context.getApplication();
        ViewHandler viewHandler = application.getViewHandler();
        UIViewRoot viewRoot = viewHandler.createView(context, context
         .getViewRoot().getViewId());
        context.setViewRoot(viewRoot);
        context.renderResponse(); //Optional
    }
    public String print() throws UnsupportedEncodingException {
        StringBuilder body = new StringBuilder();
        body.append("Campain Bean \nRequester name:" +requesterName);
        body.append("\nSender email :" + email);
        body.append("\nPhone No:" + phone);
        body.append("\nBusiness type:" + busineessType);
     body.append("\nFile path :" + filepath);
        body.append("\nFile Name :" + filename);
       /*    body.append("offer type :" + offerType);
        body.append("offer type :" + offerType);
*/
        System.out.println("__________Starting Printing_________________ ");

        System.out.println("Data  :\n" + body.toString());

 
   SendAttachmentInEmail.sendMail(email, "", "", description, body.toString(), requesterName, filepath, filename);
   refresh(); 
   //clear();
      return "RegDone";
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

    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the objective
     */
    public String getObjective() {
        return objective;
    }

    /**
     * @param objective the objective to set
     */
    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    /**
     * @param targetAudience the targetAudience to set
     */
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getBusineessType() {
        return busineessType;
    }

    /**
     * @param busineessType the busineessType to set
     */
    public void setBusineessType(String busineessType) {
        this.busineessType = busineessType;
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
     * @return the Languages
     */
    public List<String> getLanguages() {
        return Languages;
    }

    /**
     * @param Languages the Languages to set
     */
    public void setLanguages(List<String> Languages) {
        this.Languages = Languages;
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

   
}
