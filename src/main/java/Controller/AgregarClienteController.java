package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Cliente;
import Model.ClienteDao;

/**
 * Servlet implementation class AgregarClienteController
 */
@WebServlet("/AgregarClienteController")
public class AgregarClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cedula = request.getParameter("cedula");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String edad= request.getParameter("edad");
		String estado= request.getParameter("estado");
		
		
		if(cedula!=null&&!cedula.isEmpty()&&direccion!=null&&!direccion.isEmpty()&&
				telefono!=null&&!telefono.isEmpty()&&edad!=null&&!edad.isEmpty()&&
						estado!=null&&!estado.isEmpty()) {
			Cliente cliente = new Cliente();
			cliente.setCedula(cedula);
			cliente.setDireccion(direccion);
			cliente.setEdad(Long.parseLong(edad));
			cliente.setEstado(estado);
			cliente.setTelefono(telefono);
			ClienteDao clienteDao = new ClienteDao();
			clienteDao.insert(cliente);
			request.setAttribute("msgResultado", "Usuario Resgistrado con exito");
			request.setAttribute("bandera", true);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			request.setAttribute("msgResultado", "Esta mal diligenciado el formulario");
			request.setAttribute("bandera", false);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
		
		
		doGet(request, response);
	}

}
