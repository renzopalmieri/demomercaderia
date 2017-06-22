package com.test.DAO;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.test.BEAN.Mercaderia;
import com.test.DAO.IMercaderiaDAO;;

@Transactional
@Repository
public class MercaderiaDAO implements IMercaderiaDAO{
	
	@PersistenceContext	
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercaderia> getAllMercaderia() {
		
		String hql = "FROM Mercaderia as merc ORDER BY merc.mercaderiaId DESC";
		return (List<Mercaderia>) entityManager.createQuery(hql).getResultList();
	}
	
	

	@Override
	public Mercaderia getMercaderiaById(int mercaderiaId) {
		
		return entityManager.find(Mercaderia.class, mercaderiaId);

		// TODO Auto-generated method stub
		
	}

	@Override
	public void createMercaderia(Mercaderia mercaderia) {
		
		entityManager.persist(mercaderia);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean mercaderiaExists(String nombre) {
		// TODO Auto-generated method stub
		
		String hql = "FROM Mercaderia as merc WHERE merc.nombre = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, nombre)
		             .getResultList().size();
		return count > 0 ? true : false;
		
		
		
	}
	
	@Override
	public void updateMercaderia(Mercaderia mercaderia) {
		
		Mercaderia merc = getMercaderiaById(mercaderia.getmercaderiaId());
		merc.setNombre(mercaderia.getNombre());
		merc.setPrecio(mercaderia.getPrecio());
		entityManager.flush();
	}

	
	
	

}
