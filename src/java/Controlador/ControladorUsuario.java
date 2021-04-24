/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auditoria;
import Modelo.Usuario;
import Modelo.hash;
import ModeloDao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Estiven
 */
public class ControladorUsuario extends HttpServlet {


    UsuarioDAO usuarioDao = new UsuarioDAO();
    Usuario usuario = new Usuario();
    int resultado = 0;
    Auditoria auditoria = new Auditoria();

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
         request.getRequestDispatcher("index.jsp").forward(request, response);
        String accion = request.getParameter("accion");
        request.getRequestDispatcher("index.jsp").forward(request, response);
        if (accion.equals("Ingresar")) {
            System.out.println("Hola putos");
            String nombre = request.getParameter("txtNombreUsuario");
            String correo = request.getParameter("txtCorreoUsuario");
            String contrasena =  request.getParameter("txtContrasenaUsuario");
            String nuevaContrasena = hash.md5(contrasena);
            auditoria.setUsuarioAuditoria(nombre);
            usuario.setContrasenaUsuairo(nuevaContrasena);
            usuario.setNombreUsuario(nombre);
            usuario.setCorreoUsuario(correo);
            resultado = usuarioDao.validar(usuario);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            if (resultado == 1) {
                request.getSession().setAttribute("nombre", nombre);
                request.getSession().setAttribute("correo", correo);
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
