/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import ModeloDao.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Request;

/**
 *
 * @author Estiven
 */
@WebServlet(name = "ControladorPersona", urlPatterns = {"/ControladorPersona"})
public class ControladorPersona extends HttpServlet {

   

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
    String listar = "Vistas/PersonaVistas/listar.jsp";
    String add = "Vistas/PersonaVistas/add.jsp";
    String edit = "Vistas/PersonaVistas/edit.jsp";
    Persona persona = new Persona();
    PersonaDAO dao = new PersonaDAO();
    int idPersona = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";

        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;

        } else if (action.equalsIgnoreCase("Agregar")) {
            String DNIPersona = request.getParameter("txtDNIPersona");
            String NombrePersona = request.getParameter("txtNombrePersona");
            System.out.println(DNIPersona);
            persona.setDniPersona(DNIPersona);
            persona.setNombrePersona(NombrePersona);
            dao.add(persona);
            acceso = listar;

        } else if (action.equalsIgnoreCase("editar")) {

            request.setAttribute("idPer", request.getParameter("idPersona"));
            acceso = edit;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            idPersona = Integer.parseInt(request.getParameter("txtIdPersona"));
            String DNIPersona = request.getParameter("txtDNIPersona");
            String NombrePersona = request.getParameter("txtNombrePersona");
            persona.setDniPersona(DNIPersona);
            persona.setNombrePersona(NombrePersona);
            persona.setIdPersona(idPersona);
            dao.edit(persona);
            acceso = listar;

        } else if (action.equalsIgnoreCase("eliminar")) {

            idPersona = Integer.parseInt(request.getParameter("idPersona"));
            persona.setIdPersona(idPersona);
            dao.eliminar(idPersona);
            acceso = listar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

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

}
