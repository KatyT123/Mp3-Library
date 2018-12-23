/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Mp3File;

/**
 *
 * @author KATY
 */
public class DaoMp3File {
    
    public static ArrayList showTable(Connection con){
        
        String sql = "Select title,artist,album,year,lyrics,image From files";
        PreparedStatement pst = null;
        ResultSet rs =null;
        ArrayList<Mp3File> mylist = new ArrayList<>(); 
        
        try{
             pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
         
             while (rs.next()){
                 Mp3File mp3 = new Mp3File();
                 mp3.setTitle(rs.getString(1));
                 mp3.setArtist(rs.getString(2));
                 mp3.setAlbum(rs.getString(3));
                 mp3.setYear(rs.getString(4));
                 mp3.setLyrics(rs.getString(5));
                 mp3.setImage(rs.getString(6));
                 mylist.add(mp3);
             }   
             pst.close();
             rs.close();
    
        }catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        
        return mylist;
    
    }
    
    public static boolean DeleteMp3(Connection con, String title,String artist){
         boolean flag = false;
         String sql = "Delete From files Where title =? and artist=?";
         PreparedStatement pst = null;
         ResultSet rs =null;
         
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,title);
            pst.setString(2,artist);
            rs = pst.executeQuery();
            pst.close();
            rs.close();
            flag = true;
        } catch (SQLException ex) {
              Logger.getLogger(DaoMp3File.class.getName()).log(Level.SEVERE, null, ex);
        }
         return flag;
    }
    
    
}
