package com.test.SERVICE;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.DAO.IMercaderiaDAO;

import com.test.BEAN.Mercaderia;


@Service
public class MercaderiaService implements IMercaderiaService{
	
	@Autowired
	private IMercaderiaDAO mercaderiaDAO;
	

	@Override
	public List<Mercaderia> getAllMercaderia() {	
		return mercaderiaDAO.getAllMercaderia();
	
	}

	
	@Override
	public Mercaderia getMercaderiaById(int mercaderiaId) {
		
		Mercaderia merc = mercaderiaDAO.getMercaderiaById(mercaderiaId);
		return merc;
	
		
	}

	@Override
	public boolean createMercaderia(Mercaderia mercaderia) {
		
		
		if (mercaderiaDAO.mercaderiaExists(mercaderia.getNombre())) {
	    	   return false;
	       } else {
	    	   mercaderiaDAO.createMercaderia(mercaderia);
	    	   return true;
	       }
	
	}

	@Override
	public void updateMercaderia(Mercaderia mercaderia) {
		// TODO Auto-generated method stub
		mercaderiaDAO.updateMercaderia(mercaderia);
	}

}
