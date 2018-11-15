/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author KATY
 */
public class WebServiseLyrics {
    
    public static String getLyrics(String artist1, String title1){
        String lyrics = null ;
        String artist = artist1.replaceAll(" ","%20");
        String title = title1.replaceAll(" ","%20");
        
       try{
             URL url = new URL("https://api.lyrics.ovh/v1/" + artist + "/" + title);
             HttpURLConnection conn = (HttpURLConnection)url.openConnection();
             conn.setRequestMethod("GET");
             conn.setRequestProperty("Accept","application/json");
             if(conn.getResponseCode()!= 200){
                  throw new RuntimeException("Failed:HTTP error code:" + conn.getResponseCode());
             }
             StringBuilder stringBuilder = new StringBuilder();
	     String line = null;
             try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
              
                 while ((line = br.readLine()) != null) {
			stringBuilder.append(line);
		 }
          
                
                 lyrics = stringBuilder.toString();
                 JSONObject jobj =  new JSONObject(lyrics);
                 String jLyrics = jobj.getString("lyrics");
                 System.out.println(jLyrics);
                 
            } 
              
        
             }catch (Exception ex){}
           
           
        return lyrics;
    }
}
