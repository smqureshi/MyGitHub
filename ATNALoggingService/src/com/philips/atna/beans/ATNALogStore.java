package com.philips.atna.beans;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Waqas
 *
 */

@XmlRootElement
public class ATNALogStore {
    public ATNALogStore(){
    }
    
    private ArrayList<ATNALog> logList;    
    private Integer  totalCount;
    private Integer returnCount;
    private Integer pageNum;
    
    
    /**
     * @return the logList
     */
    
    @XmlElement(name="logs")
    public ArrayList<ATNALog> getLogList() {
        if(logList==null){
            logList=new ArrayList<ATNALog>();
        }
        return logList;
    }
    
    
    /**
     * @param logList the logList to set
     */
    public void setLogList(ArrayList<ATNALog> logList) {
        this.logList = logList;
    }
    /**
     * @return the totalCount
     */
    public Integer getTotalCount() {
        return totalCount;
    }
    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    /**
     * @return the returnCount
     */
    public Integer getReturnCount() {
        return returnCount;
    }
    /**
     * @param returnCount the returnCount to set
     */
    public void setReturnCount(Integer returnCount) {
        this.returnCount = returnCount;
    }
    /**
     * @return the pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }
    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    
}
