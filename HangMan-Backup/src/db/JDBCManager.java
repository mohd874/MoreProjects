/*
 * JDBCManager.java
 *
 * Created on May 21, 2007, 5:07 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author S200200874
 */
public class JDBCManager {
    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet res = null;
    int changedRows = 0;
    /** Creates a new instance of JDBCManager */
    public JDBCManager(Connection conn) {
        this.conn = conn;
    }
    
    public PreparedStatement createPreparedStatement(String sqlQuery) throws SQLException{
        return conn.prepareStatement(sqlQuery);
    }
    
    public String[][] getTopTenScores() throws SQLException{
        int recordsLimit = 10;
        String query = "select top 10 player,score from " +
                "(select * from tblGame order by score desc) x order by x.score desc";
        stm = createPreparedStatement(query);
        
        res = stm.executeQuery();
        
        int USER_NAME = 0;
        int USER_SCORE = 1;
        
        String[][] scores = new String[recordsLimit][2];
        
        for (int i = 0; i < scores.length; i++) {
            res.next();
            scores[i][USER_NAME] = res.getString("player");
            scores[i][USER_SCORE] = res.getString("score");
        }
        
        return scores;
    }
    
    public String getTheBoss(int bossLvl) throws SQLException{
        
        String query = "select * from secret_words where boss_lvl = ?";
        stm = createPreparedStatement(query);
        stm.setInt(1,bossLvl);
        res = stm.executeQuery();
        
        String boss = "";
        
        res.next();
        
        boss = res.getString("word");
        return boss;
    }
    
    public ArrayList<String> getAllSecretWords() throws SQLException{
        String query = "SELECT * from secret_words where boss_lvl = 0";
        stm = createPreparedStatement(query);
        
        res = stm.executeQuery();
        
        ArrayList<String> secretWords = new ArrayList();
        
        while(res.next()){
            secretWords.add(res.getString("word"));
        }
        
        return secretWords;
    }
    
    public boolean isNewHighScore(int newScore) throws SQLException{
        String[][] scores = getTopTenScores();
        
        for (int i = 0; i < scores.length; i++) {
            int currentScore = Integer.parseInt(scores[i][1]);
            //System.out.println("currentScore: "+currentScore+" vs. newScore: "+newScore); 
            if(currentScore < newScore){
                System.out.println("isNewHighScore return true");
                return true;
            }
        }
        System.out.println("isNewHighScore return false");
        return false;
    }
    
    public void addNewHighScore(String playerName, int newScore) throws SQLException{
        String query = "insert into tblGame(player,score) values(?,?)";
        stm = createPreparedStatement(query);
        stm.setString(1,playerName);
        stm.setInt(2,newScore);
        
        changedRows = stm.executeUpdate();
//        //if(changedRows > 0){
//            query = "insert into scores(score) values(?)";
//            stm = createPreparedStatement(query);
//            stm.setInt(1,newScore);
//
//            changedRows = stm.executeUpdate();
//        //    if(changedRows > 0){
////                return true;
////            }else{
////                return false;
////            }
////        }else{
////            return false;
//        }
    }
    
    public void closeStatement(){
        try {
            stm.close();
        } catch (Exception ex) {
            //do nothing
        }
    }
    
    public void closeConnection(){
        if(conn == null){
            try {
                closeStatement();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
