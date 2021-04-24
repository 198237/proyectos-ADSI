/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auditoria;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Tipo;
import ModeloDao.AuditoriaDAO;
import ModeloDao.PedidoDAO;
import ModeloDao.ProductoDAO;
import ModeloDao.ProveedorDAO;
import ModeloDao.TipoDAO;
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
public class ControladorPedido extends HttpServlet {

    String listar = "Vistas/PedidoVistas/listar.jsp";
    String add = "Vistas/PedidoVistas/add.jsp";
    String edit = "Vistas/PedidoVistas/edit.jsp";

    PedidoDAO dao = new PedidoDAO();
    Pedido pedido = new Pedido();
    int idPedido = 0;

    String agrego = "Insertó Pedido";
    String edito = "Editó Pedido";
    String elimino = "Eliminó Pedido";
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
            out.println("<title>Servlet ControladorPedido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorPedido at " + request.getContextPath() + "</h1>");
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

            ProveedorDAO provDAO = new ProveedorDAO();
            List<Proveedor> listaProveedorProducto = provDAO.listarTodo();
            request.setAttribute("proveedorProducto", listaProveedorProducto);

            acceso = add;

        } else if (action.equalsIgnoreCase("Agregar")) {
            int idProveedor = Integer.parseInt(request.getParameter("cboProveedorProducto"));
            int idProducto = Integer.parseInt(request.getParameter("cboProducto"));
            String observacion = request.getParameter("txtObservacion");
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(agrego);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            pedido.setIdProveedorPedido(idProveedor);
            pedido.setIdProductoPedido(idProducto);
            pedido.setObservacionPedido(observacion);
            dao.add(pedido);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            
            ProductoDAO proDAO = new ProductoDAO();
            List<Producto> listaProveedor = proDAO.listarTodo();
            request.setAttribute("productoPedido", listaProveedor);

            ProveedorDAO provDAO = new ProveedorDAO();
            List<Proveedor> listaProveedorProducto = provDAO.listarTodo();
            request.setAttribute("proveedorProducto", listaProveedorProducto);
            
            request.setAttribute("idPedido", request.getParameter("id"));
            
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            idPedido = Integer.parseInt(request.getParameter("txtIdPedido"));
            int idProveedor = Integer.parseInt(request.getParameter("cboProveedorProducto"));
            int idProducto = Integer.parseInt(request.getParameter("cboProducto"));
            String observacion = request.getParameter("txtObservacion");
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(edito);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            pedido.setIdPedido(idPedido);
            pedido.setIdProveedorPedido(idProveedor);
            pedido.setIdProductoPedido(idProducto);
            pedido.setObservacionPedido(observacion);
            dao.edit(pedido);
            dao2.add(auditoria);
            acceso = listar;
        } else if(action.equalsIgnoreCase("eliminar")){
            idPedido = Integer.parseInt(request.getParameter("id"));
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(elimino);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            pedido.setIdPedido(idPedido);
            dao.eliminar(idPedido);
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
