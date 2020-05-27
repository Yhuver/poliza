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
import Entities.Riesgo;
import Entities.Vehiculo;
import Model.ClienteDao;
import Model.RiesgoDao;
import Model.VehiculoDao;

/**
 * Servlet implementation class RegistrarRiesgoController
 */
@WebServlet("/RegistrarRiesgoController")
public class RegistrarRiesgoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarRiesgoController() {
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
		String modelo = request.getParameter("modelo");
		String marca = request.getParameter("marca");
		String anio= request.getParameter("anio");
		String placa= request.getParameter("placa");
		String serial= request.getParameter("serial");
		String valor= request.getParameter("valor");
		String radio= request.getParameter("radio");
		String rines= request.getParameter("rines");
		String aire= request.getParameter("aire");
		
		
		if(persona!=null&&!persona.isEmpty()&&modelo!=null&&!modelo.isEmpty()&&
				marca!=null&&!marca.isEmpty()&&anio!=null&&!anio.isEmpty()&&
						placa!=null&&!placa.isEmpty()&&serial!=null&&!serial.isEmpty()&&
								valor!=null&&!valor.isEmpty()) {
			
			ClienteDao clienteDao = new ClienteDao();
			Cliente clienteSearch = clienteDao.find(Long.parseLong(persona));

			VehiculoDao vehiculoDao = new VehiculoDao();
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setAnio(Long.parseLong(anio));
			vehiculo.setMarca(marca);
			vehiculo.setModelo(modelo);
			vehiculo.setPlaca(placa);
			vehiculo.setSerial(serial);
			vehiculo.setValor(Double.parseDouble(valor));
			vehiculo.setCliente(clienteSearch);
			List<Vehiculo> vehiculos=vehiculoDao.list();
			for (Vehiculo vehiculo2 : vehiculos) {
				if(vehiculo2.getPlaca().equalsIgnoreCase(placa)) {
					response.setContentType("text/plain ");
				    PrintWriter out =  response.getWriter();
				    out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" + 
				    		"Este carro ya se encuentra registrado, cambie de placa" + 
				    		"			</div>");
					doGet(request, response);
					return;
				}
			}
			vehiculoDao.insert(vehiculo);

			
			double valorRiesgo=0;
			if (clienteSearch.getEdad() > 60) {
				if (clienteSearch.getEstado().equalsIgnoreCase("casado")) {
					valorRiesgo += vehiculo.getValor() * 0.04;
					valorRiesgo += vehiculo.getValor() * 0.07;
				} else {
					valorRiesgo = vehiculo.getValor() * 0.04;
				}
			} else if (clienteSearch.getEdad() < 60 && clienteSearch.getEdad() > 45) {
				if (clienteSearch.getEstado().equalsIgnoreCase("casado")) {
					valorRiesgo += vehiculo.getValor() * 0.06;
					valorRiesgo += vehiculo.getValor() * 0.07;
				} else {
					valorRiesgo = vehiculo.getValor() * 0.06;
				}
			}else {
				if (clienteSearch.getEstado().equalsIgnoreCase("casado")) {
					valorRiesgo += vehiculo.getValor() * 0.07;
				}
			}
			if(radio!=null&&!radio.isEmpty()) {
				valorRiesgo+=Double.parseDouble(radio);
			}if(rines!=null&&!rines.isEmpty()) {
				valorRiesgo+=Double.parseDouble(rines);
			}if(aire!=null&&!aire.isEmpty()) {
				valorRiesgo+=Double.parseDouble(aire);
			}
			RiesgoDao riesgoDao = new RiesgoDao();
			Riesgo riesgo = new Riesgo();
			riesgo.setValor(valorRiesgo);
			riesgo.setCliente(clienteSearch);
			riesgo.setVehiculo(vehiculo);
			riesgoDao.insert(riesgo);
			
			response.setContentType("text/plain ");
		    PrintWriter out =  response.getWriter();
		    out.print("<div class=\"alert alert-success\" role=\"alert\">\n" + 
		    		"Soat registrado con Exito el valor a pagar es: "+valorRiesgo + 
		    		"			</div>");
		}else {
			response.setContentType("text/plain ");
		    PrintWriter out =  response.getWriter();
		    out.print("<div class=\"alert alert-danger\" role=\"alert\">\n" + 
		    		"No se pudo registrar con exito por favor diligencia bien el formulario" + 
		    		"			</div>");
		}
		
		
		
		doGet(request, response);
	}

}
