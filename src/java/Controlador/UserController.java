/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Auditoria;
import Modelo.Usuario;
import Modelo.hash;
import ModeloDao.AuditoriaDAO;
import ModeloDao.UsuarioDAO;
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
public class UserController extends HttpServlet {

    String registro = "Vistas/RegistroVistas/registro.jsp";
    String registroEmpleado = "Vistas/RegistroVistas/registroEmpleado.jsp";
    String index = "index.jsp";
    String login = "login.jsp";
    String verProductos = "producto.jsp";
    String listar = "Vistas/RegistroVistas/listar.jsp";
    

    UsuarioDAO dao = new UsuarioDAO();
    Usuario usuario = new Usuario();
    
    AuditoriaDAO auditoriaDAO = new AuditoriaDAO();
    Auditoria auditoria = new Auditoria();
    int resultado = 0;
    int idUsuario = 0;

    int alerta = 0;

    /**
     * 1 correcto 2 incorrecto 3 vacio 4 login incorrecto 5 ya existe el correo
     * 6 las contraseñas no coincide
     */
    HttpSession sessionPrincipal;

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
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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

        if (action.equalsIgnoreCase("registrarse")) {

            alerta = 3;
            HttpSession hi = request.getSession();
            hi.setAttribute("opcionAlerta", alerta);
            acceso = registro;

        } else if (action.equalsIgnoreCase("Registrar")) {

            String nombre = request.getParameter("txtNombreUsuario");
            String correo = request.getParameter("txtCorreoUsuario");
            String contrasena = request.getParameter("txtContrasenaUsuario");
            String contrasenaConfirmacion = request.getParameter("txtContrasenaUsuarioConfirmacion");
            int rol_idRol = Integer.parseInt(request.getParameter("txtRolUsuario"));

            alerta = 2;
            HttpSession hi = request.getSession();
            hi.setAttribute("opcionAlerta", alerta);

            if (dao.existeUsuario(correo) == 0) {

                if (contrasena.equals(contrasenaConfirmacion)) {

                    String nuevaContrasena = hash.md5(contrasena);
                    usuario.setNombreUsuario(nombre);
                    usuario.setCorreoUsuario(correo);
                    usuario.setContrasenaUsuairo(nuevaContrasena);
                    usuario.setRol_idRol(rol_idRol);
                    dao.add(usuario);

                    alerta = 1;
                    HttpSession firtSession = request.getSession();
                    firtSession.setAttribute("opcionAlerta", alerta);

                    if (rol_idRol == 2) {

                        acceso = listar;
                    } else {

                        acceso = login;
                    }

                } else {

                    alerta = 6;
                    sessionPrincipal = request.getSession();
                    sessionPrincipal.setAttribute("opcionAlerta", alerta);

                    if (rol_idRol == 2) {

                        acceso = registroEmpleado;
                    } else {

                        acceso = registro;
                    }

                }

            } else {
                alerta = 5;
                sessionPrincipal = request.getSession();
                sessionPrincipal.setAttribute("opcionAlerta", alerta);

                if (rol_idRol == 2) {

                    acceso = registroEmpleado;
                } else {

                    acceso = registro;
                }

            }

        } else if (action.equalsIgnoreCase("Ingresar")) {

            String nombre = request.getParameter("txtNombreUsuario");
            String correo = request.getParameter("txtCorreoUsuario");
            String contrasena = request.getParameter("txtContrasenaUsuario");
            String nuevaContrasena = hash.md5(contrasena);
            
            usuario.setNombreUsuario(nombre);
            usuario.setCorreoUsuario(correo);
            usuario.setContrasenaUsuairo(nuevaContrasena);

            resultado = dao.validar(usuario);

            if (resultado == 1) {
                int idRol = usuario.getRol_idRol();
                request.getSession().setAttribute("nombre", nombre);
                request.getSession().setAttribute("correo", correo);
                request.getSession().setAttribute("idRol", idRol);
                String nombreUsuario = nombre;
                alerta = 2;

                auditoria.setUsuarioAuditoria(nombre);
                auditoria.setDescripcionAuditoria("Ingresó al sistema");
                auditoriaDAO.add(auditoria);
                
                HttpSession session = request.getSession();
                session.setAttribute("nombreUsuario", nombreUsuario);
                session.setAttribute("idRol", idRol);
                session.setAttribute("opcionAlerta", alerta);

                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            } else {
                alerta = 4;
                sessionPrincipal = request.getSession();
                sessionPrincipal.setAttribute("opcionAlerta", alerta);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if (action.equalsIgnoreCase("salir")) {

            acceso = index;

        } else if (action.equalsIgnoreCase("agregarUsuario")) {

            acceso = registroEmpleado;

        } else if (action.equalsIgnoreCase("loguearse")) {

            alerta = 3;

            sessionPrincipal = request.getSession();
            sessionPrincipal.setAttribute("opcionAlerta", alerta);
            acceso = login;

        } else if (action.equalsIgnoreCase("listar")) {

            acceso = listar;

        } else if (action.equalsIgnoreCase("eliminar")) {

            idUsuario = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(idUsuario);
            acceso = listar;
        }
        else if(action.equalsIgnoreCase("verProductos")){
            acceso = verProductos;
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
