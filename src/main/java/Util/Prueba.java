package Util;

import java.util.ArrayList;
import java.util.List;

import Entities.Cliente;
import Entities.Riesgo;
import Entities.Soat;
import Entities.Vehiculo;
import Model.ClienteDao;
import Model.RiesgoDao;
import Model.SoatDao;
import Model.VehiculoDao;

public class Prueba {

	public static void main(String[] args) {



		ClienteDao clienteDao = new ClienteDao();

		// Codigo para Registrar Soat
		List<Cliente> listCliente = new ArrayList<Cliente>();
		listCliente = clienteDao.list();

		Cliente clienteSearch = clienteDao.find(1l);

		VehiculoDao vehiculoDao = new VehiculoDao();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnio(2013l);
		vehiculo.setMarca("MW");
		vehiculo.setModelo("v1");
		vehiculo.setPlaca("WRG90C");
		vehiculo.setSerial("98765");
		vehiculo.setValor(2500000d);
		vehiculo.setCliente(clienteSearch);

		// Codigo para registrar polizas a todo riesgo
		RiesgoDao riesgoDao = new RiesgoDao();
		double valorRiesgo=0;
		if (clienteSearch.getEdad() > 60) {
			if (clienteSearch.getEstado().equalsIgnoreCase("casado")) {
				valorRiesgo = vehiculo.getValor() * 0.04;
				valorRiesgo += vehiculo.getValor() * 0.07;
			} else {
				valorRiesgo = vehiculo.getValor() * 0.04;
			}
		} else if (clienteSearch.getEdad() < 60 && clienteSearch.getEdad() > 45) {
			if (clienteSearch.getEstado().equalsIgnoreCase("casado")) {
				valorRiesgo = vehiculo.getValor() * 0.06;
				valorRiesgo += vehiculo.getValor() * 0.07;
			} else {
				valorRiesgo = vehiculo.getValor() * 0.06;
			}
		}
		Riesgo riesgo = new Riesgo();
		riesgo.setValor(valorRiesgo);
		riesgo.setCliente(clienteSearch);
		riesgo.setVehiculo(vehiculo);
		riesgoDao.find(riesgo);

		
	}
}
