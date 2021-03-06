/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auditoria;
import Modelo.Producto;
import Modelo.Proveedor;
import Modelo.Tipo;
import ModeloDao.AuditoriaDAO;
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
public class ControladorProducto extends HttpServlet {

    String add = "Vistas/ProductoVistas/add.jsp";
    String edit = "Vistas/ProductoVistas/edit.jsp";
    String listar = "Vistas/ProductoVistas/listar.jsp";

    ProductoDAO dao = new ProductoDAO();
    Producto producto = new Producto();
    int idProducto = 0;

    String agrego = "Insertó Producto";
    String edito = "Editó Producto";
    String elimino = "Eliminó Producto";
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
            out.println("<title>Servlet ControladorProducto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorProducto at " + request.getContextPath() + "</h1>");
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
            TipoDAO tipoDAO = new TipoDAO();
            List<Tipo> listaTipoProducto = tipoDAO.consultarTodo();
            request.setAttribute("tipoProducto", listaTipoProducto);

            ProveedorDAO provDAO = new ProveedorDAO();
            List<Proveedor> listaProveedorProducto = provDAO.listarTodo();
            request.setAttribute("proveedorProducto", listaProveedorProducto);

            acceso = add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String nombre = request.getParameter("txtNombreProducto");
            int peso = Integer.parseInt(request.getParameter("txtPesoProducto"));
            int proveedor = Integer.parseInt(request.getParameter("cboProveedorProducto"));
            int tipo = Integer.parseInt(request.getParameter("cboTipoProducto"));
            int precio = Integer.parseInt(request.getParameter("txtPrecioProducto"));
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(agrego);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            producto.setNombreProducto(nombre);
            producto.setPesoProducto(peso);
            producto.setIdProveedor_Producot(proveedor);
            producto.setIdTipo_producto(tipo);
            producto.setPrecioProducto(peso);
            dao.add(producto);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            TipoDAO tipoDAO = new TipoDAO();
            List<Tipo> listaTipoProducto = tipoDAO.consultarTodo();
            request.setAttribute("tipoProducto", listaTipoProducto);

            ProveedorDAO provDAO = new ProveedorDAO();
            List<Proveedor> listaProveedorProducto = provDAO.listarTodo();
            request.setAttribute("proveedorProducto", listaProveedorProducto);
            request.setAttribute("idProducto", request.getParameter("id"));
            acceso = edit;
        } else if (action.equals("Actualizar")) {
            idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));
            String nombre = request.getParameter("txtNombreProducto");
            int peso = Integer.parseInt(request.getParameter("txtPesoProducto"));;
            int tipo = Integer.parseInt(request.getParameter("cboTipoProducto"));
            int proveedor = Integer.parseInt(request.getParameter("cboProveedorProducto"));
            int precio = Integer.parseInt(request.getParameter("txtPrecioProducto"));
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(edito);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            producto.setIdProducto(idProducto);
            producto.setNombreProducto(nombre);
            producto.setPesoProducto(peso);
            producto.setIdProveedor_Producot(proveedor);
            producto.setIdTipo_producto(tipo);
            producto.setPrecioProducto(precio);
            dao.edit(producto);
            dao2.add(auditoria);
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            idProducto = Integer.parseInt(request.getParameter("id"));
            
            HttpSession session = request.getSession();
            Object usuario = session.getAttribute("nombreUsuario");
            String nombreUsuario = usuario.toString();
            
            auditoria.setDescripcionAuditoria(elimino);
            auditoria.setUsuarioAuditoria(nombreUsuario);
            
            producto.setIdProducto(idProducto);
            dao.eliminar(idProducto);
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
