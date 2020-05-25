package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		Estudiante estudiante = new Estudiante();
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante",estudiante);
		mav.setViewName("index");
		return mav;
	}
	
	//Mostrar Lista de Estudiantes
	@RequestMapping("/ingresar")
	public ModelAndView ingresar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result ) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
		}
		else {
			estudianteService.save(estudiante);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/borrar", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigoEstudiante") int codigoEstudiante) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(codigoEstudiante);
			estudiantes = estudianteService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listadoEstudiantes");
		
		return mav;
	}
	
	@RequestMapping(value = "/mostrarEstudiante")
	public ModelAndView findAll() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudiantes = estudianteService.findAll();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("estudiantes",estudiantes);
		mav.setViewName("listadoEstudiantes");
		return mav;
	}
}
