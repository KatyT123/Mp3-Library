/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author chern
 */
public class InsertFileDao {
    
        public static boolean InsertFileInDb(Part filepart,File file){
             Connection con = DbAccess.getConnection();
             String sql = "INSERT INTO mp3_files (file, title, album, artist, year, lyrics) VALUES (?,?,?,?,?,?)";
             PreparedStatement pst = null;
             HashMap <String,String> tags = getMyTags(file);
             boolean flag = false;
             try{
                 pst = con.prepareStatement(sql);
                 pst.setBlob(1, filepart.getInputStream());
                 pst.setString(2, tags.get("title"));
                 pst.setString(3, tags.get("album") );
                 pst.setString(4, tags.get("band"));
                 pst.setString(5, tags.get("year"));
                 pst.setString(6, WebServiseLyrics.getLyrics(tags.get("band"), tags.get("title")));
                 flag = pst.execute();
                 pst.close();
    
            } catch (SQLException ex) {
                Logger.getLogger(InsertFileDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(InsertFileDao.class.getName()).log(Level.SEVERE, null, ex);
            }  
            return flag;  
        }
        
        public static HashMap<String, String> getMyTags(File file){
            Mp3Tags mp = new Mp3Tags();
            HashMap <String,String> tags = new HashMap<>();
            try {
                tags = mp.getTags(file);
            } catch (IOException ex) {
                Logger.getLogger(InsertFileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return tags;
        }
}
