package com.uca.capas.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDaoImpl implements EstudianteDao{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.Estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(), Estudiante.class);

		List<Estudiante> res = query.getResultList();
		return res;
	}

	@Override
	@Transactional
	public void save(Estudiante c) throws DataAccessException {
		entityManager.persist(c);
		
	}

	@Override
	public void delete(Integer code) throws DataAccessException {
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		entityManager.remove(estudiante);
		
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		Estudiante estudiante = entityManager.find(Estudiante.class, code);
		return estudiante;
	}

}
