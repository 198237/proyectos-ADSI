/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auditoria;
import Modelo.Empleado;
import ModeloDao.AuditoriaDAO;
import ModeloDao.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Estiven
 */
public class ControladorEmpleado extends HttpServlet {

    String listar = "Vistas/EmpleadoVistas/listar.jsp";
    String add = "Vistas/EmpleadoVistas/add.jsp";
    String edit = "Vistas/EmpleadoVistas/edit.jsp";
    EmpleadoDAO dao = new EmpleadoDAO();
    Empleado empleado = new Empleado();
    int idEmpleado = 0;

    String agrego = "Insertó Empleado";
    String edito = "Editó Empleado";
    String elimino = "Eliminó Empleado";
    Auditoria auditoria = new Auditoria();
    AuditoriaDAO dao2 = new AuditoriaDAO();

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEmpleado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEmpleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String nombre = request.getParameter("txtNombreEmpleado");
            String apellido = request.getParameter("txtApellidoEmpleado");
            String edad = request.getParameter("txtEdadEmpleado");
            int salario = Integer.parseInt(request.getParameter("txtSalarioEmpleado"));
            String correo = request.getParameter("txtCorreoEmpleado");
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(agrego);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            empleado.setNombreEmpleado(nombre);
            empleado.setApellidoEmpleado(apellido);
            empleado.setEdadEmpleado(edad);
            empleado.setSalarioEmpleado(salario);
            empleado.setCorreoEmpleado(correo);
            dao.add(empleado);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idEmpleado", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            idEmpleado = Integer.parseInt(request.getParameter("txtIdEmpleado"));
            String nombre = request.getParameter("txtNombreEmpleado");
            String apellido = request.getParameter("txtApellidoEmpleado");
            String edad = request.getParameter("txtEdadEmpleado");
            int salario = Integer.parseInt(request.getParameter("txtSalarioEmpleado"));
            String correo = request.getParameter("txtCorreoEmpleado");
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(edito);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            empleado.setIdEmpleado(idEmpleado);
            empleado.setNombreEmpleado(nombre);
            empleado.setApellidoEmpleado(apellido);
            empleado.setEdadEmpleado(edad);
            empleado.setSalarioEmpleado(salario);
            empleado.setCorreoEmpleado(correo);
            dao.edit(empleado);
            dao2.add(auditoria);
            acceso = listar;

        } else if (action.equalsIgnoreCase("eliminar")) {
            idEmpleado = Integer.parseInt(request.getParameter("id"));
            
           HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(elimino);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            dao.eliminar(idEmpleado);
            dao2.add(auditoria);
            empleado.setIdEmpleado(idEmpleado);
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
