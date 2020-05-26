package Model;

import Entities.Vehiculo;
import Util.Conexion;

public class VehiculoDao 
	extends Conexion<Vehiculo> 
	implements GenericDao<Vehiculo>{

	public VehiculoDao() {
		super(Vehiculo.class);
		// TODO Auto-generated constructor stub
	}
	
}