package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;


public interface EstudianteDao {
	public List<Estudiante> findAll() throws DataAccessException;
	
	public void save(Estudiante c) throws DataAccessException;
	
	public void delete(Integer code) throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
}
