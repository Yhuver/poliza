package Util;

import Entities.Cliente;
import Model.ClienteDao;

public class Prueba {

	
	
	public static void main(String[] args) {
		Cliente cliente=new Cliente();
		
		cliente.setCedula("190500021");
		cliente.setDireccion("avenida siempre viva");
		cliente.setEdad(25l);
		cliente.setEstado("soltero");
		cliente.setTelefono("3209741369");
		
		ClienteDao cDao=new ClienteDao();
		
		cDao.insert(cliente);
		
	}
}
