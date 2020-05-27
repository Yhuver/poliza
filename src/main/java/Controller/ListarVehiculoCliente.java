package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Cliente;
import Entities.Soat;
import Entities.Vehiculo;
import Model.ClienteDao;
import Model.SoatDao;
import Model.VehiculoDao;

/**
 * Servlet implementation class ListarVehiculoCliente
 */
@WebServlet("/ListarVehiculoCliente")
public class ListarVehiculoCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarVehiculoCliente() {
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
		String persona = request.getParameter("persona");
		
		
		if(persona!=null&&!persona.isEmpty()) {
			
			ClienteDao clienteDao = new ClienteDao();
			Cliente clienteSearch = clienteDao.find(Long.parseLong(persona));
			VehiculoDao vehiculoDao = new VehiculoDao();
			List<Vehiculo> vehiculos=vehiculoDao.list();
			response.setContentType("text/plain ");
		    PrintWriter out =  response.getWriter();
			
		    boolean ban=false;
		    for (Vehiculo vehiculo : vehiculos) {
				if(vehiculo.getCliente().getId()==Long.parseLong(persona)) {
		    out.print("<tr>\n" + 
		    		"                <td>"+vehiculo.getModelo()+"</td>\n" + 
		    		"                <td>"+vehiculo.getMarca()+"</td>\n" + 
		    		"                <td>"+vehiculo.getAnio()+"</td>\n" + 
		    		"                <td>"+vehiculo.getPlaca()+"</td>\n" + 
		    		"                <td>"+vehiculo.getSerial()+"</td>\n" + 
		    		"                <td>"+vehiculo.getValor()+"</td>\n" + 
		    		"                <td>"+vehiculo.getValorSeguro()+"</td>\n" + 
		    		"            </tr>");
				ban=true;
				}
		    }
		    if(ban==false) {
				out.print("<tr>\n" + 
	    		"                <td>"+"No existen Datos"+"</td>\n" + 
	    		"                <td>"+"No existen Datos"+"</td>\n" + 
	    		"                <td>"+"No existen Datos"+"</td>\n" + 
	    		"                <td>"+"No existen Datos"+"</td>\n" + 
	    		"                <td>"+"No existen Datos"+"</td>\n" + 
	    		"                <td>"+"No existen Datos"+"</td>\n" + 
	    		"                <td>"+"No existen Datos"+"</td>\n" + 
	    		"            </tr>");
			}
		}else {
			response.setContentType("text/plain ");
		    PrintWriter out =  response.getWriter();
		    out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" + 
		    		"Error, ocurrio un problema" + 
		    		"			</div>");
		}
		
		
		
		doGet(request, response);
	}

}
