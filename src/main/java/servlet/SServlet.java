/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephawwal
 */
@WebServlet(name = "SServlet", urlPatterns = {"/SServlet"})

public class SServlet extends HttpServlet {

    static ArrayList persons = new ArrayList<>();
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
        try (PrintWriter out = response.getWriter()) {
            personCreator(request, response, out);

        }
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void randomQ(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {

        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();

        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String quote = "";

        switch (hour) {

            case 0:
                quote = "Quote from hour " + hour;

                break;

            case 1:
                quote = "Quote from hour " + hour;

                break;

            case 2:
                quote = "Quote from hour " + hour;

                break;

            case 3:
                quote = "Quote from hour " + hour;

                break;
            case 4:
                quote = "Quote from hour " + hour;

                break;
            case 5:
                quote = "Quote from hour " + hour;

                break;
            case 6:
                quote = "Quote from hour " + hour;

                break;
            case 7:
                quote = "Quote from hour " + hour;

                break;
            case 8:
                quote = "Quote from hour " + hour;

                break;
            case 9:
                quote = "Quote from hour " + hour;

                break;
            case 10:
                quote = "Quote from hour " + hour;

                break;

                case 11:
                quote = "Quote from hour " + hour;
                
                break;
                case 12:
                quote = "Quote from hour " + hour;
                
                break;
                case 13:
                quote = "Quote from hour " + hour;
                
                break;
                case 14:
                quote = "Quote from hour " + hour;
                
                break;
                case 15:
                quote = "Quote from hour " + hour;
                
                break;
                case 16:
                quote = "Quote from hour " + hour;
                
                break;
                case 17:
                quote = "Quote from hour " + hour;
                
                break;
                case 18:
                quote = "Quote from hour " + hour;
                
                break;
                case 19:
                quote = "Quote from hour " + hour;
                
                break;
                case 20:
                quote = "Quote from hour " + hour;
                
                break;
                case 21:
                quote = "Quote from hour " + hour;
                
                break;
                case 22:
                quote = "Quote from hour " + hour;
                
                break;
                case 23:
                quote = "Quote from hour " + hour;
                break;
                
                default: quote="Sorry failed";
                
                
        }
        
        out.write(quote);

    }
    
    private void personCreator(HttpServletRequest request, HttpServletResponse response, PrintWriter out){
        
        if (persons.isEmpty()){
            
            Person p1 = new Person("Hanne", 15);
            Person p2 = new Person("Man", 20);
            Person p3 = new Person("Kan", 12);
            
            
            persons.add(p1);
            persons.add(p2);
            persons.add(p3);
            
            
        }
     
        String jsonString = new Gson().toJson(persons);
        out.write(jsonString);
        
        
        
    }
    
    
    private void saveToPersons(HttpServletRequest request, HttpServletResponse response){
        
        try {
            
            BufferedReader reader = request.getReader();
            String s = reader.readLine();
            Person pFromServer = new Gson().fromJson(s, Person.class);
            persons.add(pFromServer);
            
        } catch (IOException ex){
            System.out.println("Could not read");
            System.out.println(ex);
            
        }
    }
}
