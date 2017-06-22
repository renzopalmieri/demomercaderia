package com.test.SERVICE;

import java.util.List;

import com.test.BEAN.Mercaderia;;

public interface IMercaderiaService {
	
	 List<Mercaderia> getAllMercaderia();
	 Mercaderia getMercaderiaById(int mercaderiaId);
     boolean createMercaderia(Mercaderia mercaderia);
     void updateMercaderia(Mercaderia mercaderia);

	

}
