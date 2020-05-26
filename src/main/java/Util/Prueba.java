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

		// Codigo para registrar clientes
		Cliente cliente = new Cliente();

		cliente.setCedula("190500022");
		cliente.setDireccion("avenida siempre viva");
		cliente.setEdad(28l);
		cliente.setEstado("casado");
		cliente.setTelefono("3209741999");

		ClienteDao clienteDao = new ClienteDao();

		clienteDao.insert(cliente);

		// Codigo para Registrar Soat
		List<Cliente> listCliente = new ArrayList<Cliente>();
		listCliente = clienteDao.list();

		Cliente clienteSearch = clienteDao.find(1l);

		VehiculoDao vehiculoDao = new VehiculoDao();
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnio(2013l);
		vehiculo.setMarca("Toyota");
		vehiculo.setModelo("v1");
		vehiculo.setPlaca("WRG70C");
		vehiculo.setSerial("123544");
		vehiculo.setValor(2598000d);
		vehiculo.setCliente(clienteSearch);

		SoatDao soatDao = new SoatDao();
		double valorSoat = vehiculo.getValor() * 0.01;
		Soat soat = new Soat();
		soat.setValor(valorSoat);
		soat.setCliente(clienteSearch);
		soat.setVehiculo(vehiculo);

		// Codigo para registrar polizas a todo riesgo
		RiesgoDao riesgoDao = new RiesgoDao();
		double valorRiesgo=0;
		if (clienteSearch.getEdad() > 60) {
			if (clienteSearch.getEstado().equalsIgnoreCase("casado")) {
				valorSoat = vehiculo.getValor() * 0.04;
				valorSoat += vehiculo.getValor() * 0.07;
			} else {
				valorSoat = vehiculo.getValor() * 0.04;
			}
		} else if (clienteSearch.getEdad() < 60 && clienteSearch.getEdad() > 45) {
			if (clienteSearch.getEstado().equalsIgnoreCase("casado")) {
				valorSoat = vehiculo.getValor() * 0.06;
				valorSoat += vehiculo.getValor() * 0.07;
			} else {
				valorSoat = vehiculo.getValor() * 0.06;
			}
		}
		Riesgo riesgo = new Riesgo();
		riesgo.setValor(valorRiesgo);
		riesgo.setCliente(clienteSearch);
		riesgo.setVehiculo(vehiculo);

		// Mostrar todos los vehiculos
		List<Vehiculo> listVehiculo = new ArrayList<Vehiculo>();
		listVehiculo = vehiculoDao.list();
		
		// Comision del 15% total 
		double comision=0;
		for (Vehiculo vehiculo2 : listVehiculo) {
			comision+=vehiculo2.getValor();
		}
		
	}
}
