/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import com.beaglebuddy.mp3.MP3;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KATY
 */
public class Mp3Tags {
    private  HashMap <String,String> tags = new HashMap<>();

    public Mp3Tags() {
    }
    
    
    public HashMap getTags(File f){
        try {
            MP3 mp3 = new MP3(f);
            String album = mp3.getAlbum();
            String band = mp3.getBand();
            String title = mp3.getTitle();
            String year = Integer.toString(mp3.getYear()); 
            tags.put("album", album);
            tags.put("band", band);
            tags.put("title", title);
            tags.put("year", year);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Mp3Tags.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return tags;
    }
}
