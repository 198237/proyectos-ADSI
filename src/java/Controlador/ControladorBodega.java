/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auditoria;
import Modelo.Bodega;
import Modelo.Producto;
import Modelo.Proveedor;
import ModeloDao.AuditoriaDAO;
import ModeloDao.BodegaDAO;
import ModeloDao.ProductoDAO;
import ModeloDao.ProveedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ControladorBodega extends HttpServlet {

    String listar = "Vistas/BodegaVistas/listar.jsp";
    String add = "Vistas/BodegaVistas/add.jsp";
    String edit = "Vistas/BodegaVistas/edit.jsp";

    BodegaDAO dao = new BodegaDAO();
    Bodega bodega = new Bodega();
    int idBodega = 0;

    String agrego = "Insertó En Bodgea";
    String edito = "Editó En Bodega";
    String elimino = "Eliminó De Bodega";
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
            out.println("<title>Servlet ControladorBodega</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorBodega at " + request.getContextPath() + "</h1>");
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
            ProductoDAO proDAO = new ProductoDAO();
            List<Producto> listaProveedor = proDAO.listarTodo();
            request.setAttribute("productoPedido", listaProveedor);

            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String codigo = request.getParameter("txtCodigoBodega");
            int producto = Integer.parseInt(request.getParameter("cboProducto"));
            int cantidad = Integer.parseInt(request.getParameter("txtCantidadBodega"));
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(agrego);
            auditoria.setUsuarioAuditoria(nombreUsuario);

            bodega.setCodigoBodega(codigo);
            bodega.setIdProductoBodega(producto);
            bodega.setCantidadBodega(cantidad);
            dao.add(bodega);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            ProductoDAO proDAO = new ProductoDAO();
            List<Producto> listaProveedor = proDAO.listarTodo();
            request.setAttribute("productoPedido", listaProveedor);

            request.setAttribute("idBodega", request.getParameter("id"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            idBodega = Integer.parseInt(request.getParameter("txtIdBodega"));
            String codigo = request.getParameter("txtCodigoBodega");
            int producto = Integer.parseInt(request.getParameter("cboProducto"));
            int cantidad = Integer.parseInt(request.getParameter("txtCantidadBodega"));
           
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(edito);
            auditoria.setUsuarioAuditoria(nombreUsuario);

            bodega.setIdBodega(idBodega);
            bodega.setCodigoBodega(codigo);
            bodega.setIdProductoBodega(producto);
            bodega.setCantidadBodega(cantidad);
            dao.edit(bodega);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            idBodega = Integer.parseInt(request.getParameter("id"));
            
             HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(elimino);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            bodega.setIdBodega(idBodega);
            dao.eliminar(idBodega);
            dao2.add(auditoria);
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
