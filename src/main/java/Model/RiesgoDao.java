package Model;

import Entities.Riesgo;
import Util.Conexion;

public class RiesgoDao 
	extends Conexion<Riesgo> 
	implements GenericDao<Riesgo>{

	public RiesgoDao() {
		super(Riesgo.class);
		// TODO Auto-generated constructor stub
	}
	
}