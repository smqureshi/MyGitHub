package com.philips.atna.services;

import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.philips.atna.beans.ATNALog;
import com.philips.atna.beans.ATNALogStore;
import com.philips.atna.beans.Student;
import com.philips.atna.dao.ATNALogDAO;

/**
 * 
 * @author Waqas
 * @author Shahid
 *
 */

@Path("/applog")
public class ATNALogDetailsImpl implements ATNALogDetail {
    
    
    @Override
    @GET    
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("getLogDetail/{appLogID}")
    public ATNALog getLogDetail(@PathParam("appLogID") final String appLogID) {
                
        ATNALog log = new ATNALog();
        ATNALogDAO logDao= null;
                
        try {
            logDao = new ATNALogDAO();
            log = logDao.getATNALogDetail(appLogID);
        } catch (SQLException e) {
            e.printStackTrace();
        }    
        
        return log;
    }
    
    @Override
    @POST    
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("getFilteredLogs/{filterBean}/{endTime}/{pageNum}")
    public ATNALogStore getFilteredLogs(final @PathParam("filterBean") ATNALog filterBean, 
                                        final @PathParam("endTime") String endTime,
                                        final @PathParam("endTime") Integer pageNum ) 
    {
        
        ATNALogStore logs = new ATNALogStore();
        ATNALogDAO logDao= null;
                
        try {
            logDao = new ATNALogDAO();
            logs = logDao.getFilteredATNALogs(filterBean, endTime,pageNum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return logs;
    }
}
