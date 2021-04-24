/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auditoria;
import Modelo.Proveedor;
import ModeloDao.AuditoriaDAO;
import ModeloDao.ProveedorDAO;
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
public class ControladorProveedor extends HttpServlet {

    String listar = "Vistas/ProveedorVistas/listar.jsp";
    String add = "Vistas/ProveedorVistas/add.jsp";
    String edit = "Vistas/ProveedorVistas/edit.jsp";

    Proveedor proveedor = new Proveedor();
    ProveedorDAO dao = new ProveedorDAO();
    int idProveedor = 0;

    String agrego = "Insertó Proveedor";
    String edito = "Editó Proveedor";
    String elimino = "Eliminó Proveedor";
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
            out.println("<title>Servlet ControladorProveedor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProveedor at " + request.getContextPath() + "</h1>");
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
            String nomProveedor = request.getParameter("txtNombreProveedor");
            String rutProveedor = request.getParameter("txtRUTProveedor");
            String telefonoProveedor = request.getParameter("txtTelefonoProveedor");
            String direccionProveedor = request.getParameter("txtDireccionProveedor");

            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();

            auditoria.setDescripcionAuditoria(agrego);
            auditoria.setUsuarioAuditoria(nombreUsuario);

            proveedor.setNombreProveedor(nomProveedor);
            proveedor.setRUTProveedor(rutProveedor);
            proveedor.setTelefonoProveedor(telefonoProveedor);
            proveedor.setDireccionProveedor(direccionProveedor);
            dao.add(proveedor);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idProveedor", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            idProveedor = Integer.parseInt(request.getParameter("txtIdProveedor"));
            String nomProveedor = request.getParameter("txtNombreProveedor");
            String rutProveedor = request.getParameter("txtRUTProveedor");
            String telefonoProveedor = request.getParameter("txtTelefonoProveedor");
            String direccionProveedor = request.getParameter("txtDireccionProveedor");

            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();

            auditoria.setDescripcionAuditoria(edito);
            auditoria.setUsuarioAuditoria(nombreUsuario);

            proveedor.setIdProveedor(idProveedor);
            proveedor.setNombreProveedor(nomProveedor);
            proveedor.setRUTProveedor(rutProveedor);
            proveedor.setTelefonoProveedor(telefonoProveedor);
            proveedor.setDireccionProveedor(direccionProveedor);
            dao.edit(proveedor);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            idProveedor = Integer.parseInt(request.getParameter("id"));

            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();

            auditoria.setDescripcionAuditoria(elimino);
            auditoria.setUsuarioAuditoria(nombreUsuario);

            proveedor.setIdProveedor(idProveedor);
            dao.eliminar(idProveedor);
            dao2.add(auditoria);
            acceso = listar;
        }

        //desde aqui nos lleva a la vista solicitada
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
