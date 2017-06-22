package com.test.DAO;

import java.util.List;
 
import com.test.BEAN.Mercaderia;

public interface IMercaderiaDAO {
	
	 List<Mercaderia> getAllMercaderia();
	 
	    Mercaderia getMercaderiaById(int mercaderiaId);
	    
	    void createMercaderia(Mercaderia mercaderia);
	    
	    void updateMercaderia(Mercaderia mercaderia);
	    
	    boolean mercaderiaExists(String nombre);

	
}
