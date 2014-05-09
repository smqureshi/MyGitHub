package com.philips.atna.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Waqas
 * 
 */

@XmlRootElement
public class ATNALog {
     
    private String creationDateTime;
    private String level;
    private String source;
    private String id;
    private String transactionId;
    private String message;
    
    
    public ATNALog() {
    }
    
    /**
     * @return the creationDateTime
     */
    public String getCreationDateTime() {
        return creationDateTime;
    }


    /**
     * @param creationDateTime the creationDateTime to set
     */
    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }


    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }


    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }


    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }


    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }


    /**
     * @return the ID
     */
    public String getID() {
        return id;
    }


    /**
     * @param ID the ID to set
     */
    public void setID(String id) {
        this.id = id;
    }


    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }


    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }


    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }


    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
