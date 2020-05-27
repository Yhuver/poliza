package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entities.Vehiculo;
import Model.VehiculoDao;

/**
 * Servlet implementation class ConsultarComisionController
 */
@WebServlet("/ConsultarComisionController")
public class ConsultarComisionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarComisionController() {
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
		VehiculoDao vehiculoDao=new VehiculoDao();
		List<Vehiculo> listVehiculo=vehiculoDao.list();
		
		double comision=0;
		for (Vehiculo vehiculo : listVehiculo) {
			comision+=vehiculo.getValorSeguro()*0.15;
		}
		
		response.setContentType("text/plain ");
	    PrintWriter out =  response.getWriter();
	    out.print("<div class=\"alert alert-success\" role=\"alert\">\n" + 
	    		"La ganancia por comisión es de $: "+comision + 
	    		"			</div>");
		doGet(request, response);
	}

}
