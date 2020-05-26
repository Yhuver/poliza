package Model;

import Entities.Soat;
import Util.Conexion;

public class SoatDao 
	extends Conexion<Soat> 
	implements GenericDao<Soat>{

	public SoatDao() {
		super(Soat.class);
		// TODO Auto-generated constructor stub
	}
	
}