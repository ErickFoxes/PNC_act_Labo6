package com.uca.capas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.EstudianteDao;
import com.uca.capas.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDao estudianteDao;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		return estudianteDao.findAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		return estudianteDao.findOne(code);
	}

	@Override
	public void save(Estudiante estudiante) throws DataAccessException {
		estudianteDao.save(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer code) throws DataAccessException {
		estudianteDao.delete(code);
		
	}

}
