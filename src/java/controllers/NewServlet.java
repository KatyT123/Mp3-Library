/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import Dao.DbAccess;
import Dao.Mp3Tags;
import Dao.WebServiseLyrics;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.HashMap;


/**
 *
 * @author KATY
 */
@WebServlet(name = "myfile", urlPatterns = {"/NewServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
                 maxFileSize = 1024 * 1024 * 10, 
                 maxRequestSize = 1024 * 1024 * 10 * 5)       //to orio toy megethous toy arxeioy //

public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        final Part filepart = request.getPart("myfile");
        final String filename = filepart.getSubmittedFileName();
        
        filepart.write("C:\\Users\\Katy\\Desktop\\" + filename);
        File f = new File("C:\\Users\\Katy\\Desktop\\" + filename);
        
        Mp3Tags mp = new Mp3Tags();
        HashMap <String,String> tags = mp.getTags(f);
        String lyrics = WebServiseLyrics.getLyrics(tags.get("band"), tags.get("title"));
        
        Connection con = DbAccess.getConnection();
        String sql = "INSERT INTO mp3_files (file, title, album, artist, year, lyrics) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try{
              pst = con.prepareStatement(sql);
              pst.setBlob(1, filepart.getInputStream());
              pst.setString(2, tags.get("title"));
              pst.setString(3, tags.get("album") );
              pst.setString(4, tags.get("band"));
              pst.setString(5, tags.get("year"));
              pst.setString(6, lyrics);
              pst.execute();
              RequestDispatcher disp = request.getRequestDispatcher("uploaded.jsp");
              disp.forward(request, response);
              
              pst.close();
    
        }  catch (SQLException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex)
         {
            System.out.println("An error occurred while reading/saving the mp3 file.");
            ex.printStackTrace();
         }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
