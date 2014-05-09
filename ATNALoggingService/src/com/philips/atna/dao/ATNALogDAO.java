package com.philips.atna.dao;

import java.sql.*;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import com.philips.atna.beans.ATNALog;
import com.philips.atna.beans.ATNALogStore;

/**
 * 
 * @author Shahid
 *
 */
public class ATNALogDAO {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * 
     * @param transactionID
     * @return
     * @throws SQLException
     */
    public ATNALog getATNALogDetail(String appLogID) throws SQLException {
        
        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw e;
        }

        final String sqlStatement = "select id, transactionId, logtime, loglevel, source, message " +
                                    "from ApplicationLog where ID = '" + appLogID + "'";
        resultSet = statement.executeQuery(sqlStatement);

        ATNALog log = null;
        while (resultSet.next()) {
            log = new ATNALog();
            
            log.setCreationDateTime(resultSet.getString("logtime"));
            log.setLevel(resultSet.getString("loglevel"));
            log.setSource(resultSet.getString("Source"));
            log.setID(resultSet.getString("Id"));
            log.setMessage(resultSet.getString("Message"));      
            
        }
        
        
        statement.close();
        connection.close();

        return log;
    }
    
    /**
     * 
     * @param filterBean
     * @param creationStopDateTime
     * @return
     * @throws SQLException
     */
    public ATNALogStore getFilteredATNALogs(ATNALog filterBean, String endTime, final Integer pageNum) throws SQLException {
        
        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
        }

        String sqlStatement = "id, transactionId, logtime, loglevel, source, Left(message,20) message " + 
                              "from ApplicationLog Where";
        
        if(StringUtils.isNotEmpty(filterBean.getTransactionId()) ){
            sqlStatement += "transactionId ='" + filterBean.getTransactionId() + "' ";
        }
        else {
            sqlStatement += "transactionId = transactionId";
        }
        
        if(StringUtils.isNotEmpty(filterBean.getCreationDateTime()) ){
            sqlStatement += "AND logtime ='" + filterBean.getCreationDateTime() + "' ";
        }
        else {
            sqlStatement += "AND logtime = logtime";
        }
        
        if(StringUtils.isNotEmpty(filterBean.getLevel()) ){
            sqlStatement += " AND loglevel ='" + filterBean.getLevel() + "'";
        }
        else {
            sqlStatement += " AND loglevel = loglevel";
        }            
          
        if(StringUtils.isNotEmpty(filterBean.getSource()) ){
            sqlStatement += " AND source ='" + filterBean.getSource() + "'";
        }
        else {
            sqlStatement += " AND source = source";
        } 
        
        resultSet = statement.executeQuery(sqlStatement);

        ATNALogStore logs= new ATNALogStore();
        ArrayList<ATNALog> logList = new ArrayList<>();
        
        while (resultSet.next()) {
            ATNALog log = new ATNALog();
            
            log.setCreationDateTime(resultSet.getString("logtime"));
            log.setLevel(resultSet.getString("loglevel"));
            log.setSource(resultSet.getString("Source"));
            log.setID(resultSet.getString("ID"));            
            log.setTransactionId(resultSet.getString("TransactionId"));
            
            logList.add(log);
        }
        
        logs.setLogList(logList);
        logs.setPageNum(pageNum);
        logs.setTotalCount(logList.size());
        logs.setReturnCount(logList.size());
        
        statement.close();
        connection.close();

        return logs;
    }
    
    private Connection getConnection() {
    
    	String driverName = "org.postgresql.Driver";
        String conectionURI = "jdbc:postgresql://localhost:5432/ATNALogging";
        String userName = "postgres";
        String password = "p0s7gre";

        try {
            Class.forName(driverName);

            try {
                connection = DriverManager.getConnection(conectionURI, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();  
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();  
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  
        }

        return connection;
    }   
}