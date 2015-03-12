/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikonsoft.partner.vo;

import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author mohamed
 */
public class CampaignVO {
       private String requesterName;
    private String email;
    private String phone;
    private String busineessType;
    private String offerType;
    private String projectName;
    private String destination = "D:/tmp/";
    private Date launchDate;
    private Date endDate;
    private String description;
    private String objective;
    private String targetAudience;
    private List<SelectItem> channels;

    private List<String> Languages;
    
private String filepath="";
private String filename="";

    /**
     * @return the requesterName
     */
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
     * @return the busineessType
     */
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
     * @return the projectName
     */
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

    /**
     * @return the targetAudience
     */
    public String getTargetAudience() {
        return targetAudience;
    }

    /**
     * @param targetAudience the targetAudience to set
     */
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
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
