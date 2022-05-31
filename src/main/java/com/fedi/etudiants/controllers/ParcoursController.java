package com.fedi.etudiants.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.fedi.etudiants.entities.Parcours;
import com.fedi.etudiants.entities.Etudiant;
import com.fedi.etudiants.service.ParcoursService;
import com.fedi.etudiants.service.EtudiantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParcoursController {
	  @Autowired
	    ParcoursService parcoursService;
	  @Autowired
	    EtudiantService etudService;
	 @RequestMapping("/CreateParcours")
	  public String CreateParc(ModelMap modelMap)
	    {
	  
	    modelMap.addAttribute("parcours",new Parcours());
	    modelMap.addAttribute("mode","new");
	    
	    return "formParcours";
	    }
	 
	 @RequestMapping("/saveParcours")
	    public String saveParcours(Parcours parcours)
	    {
	    parcoursService.saveParcours(parcours);
		return "redirect:/ListeParcourss";
	    }
	 
	 @RequestMapping("/ListeParcourss")
	    public String listeParcourss(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "5") int size)
	    {
	    	Page<Parcours> parcs = parcoursService.getAllParcourssParPage(page, size);
	    	modelMap.addAttribute("parcourss", parcs);
	    	modelMap.addAttribute("pages", new int[parcs.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listeparcours";
	    }
	 
	 
	 @RequestMapping("/supprimerParcours")
	    public String supprimerSkin(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "10") int size)
	    {
	        parcoursService.deleteParcoursById(id);
	        Page<Parcours> parcs = parcoursService.getAllParcourssParPage(page,size);
	        		modelMap.addAttribute("parcourss", parcs);
	        		modelMap.addAttribute("pages", new int[parcs.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "listeparcours";
	    }
	 @RequestMapping("/modifierParcours")
	    public String editerParcours(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Parcours c= parcoursService.getParcours(id);
	    modelMap.addAttribute("parcours", c);
	    modelMap.addAttribute("mode", "edit");
	    return "formParcours";
	    }
	 
	 
	 @RequestMapping("/updateParcours")
	    public String updateParcours(@ModelAttribute("parcours") Parcours parcours,ModelMap modelMap) throws ParseException
	    {

	        parcoursService.updateParcours(parcours);
	        List<Parcours> parcs = parcoursService.getAllParcourss();
	        modelMap.addAttribute("parcourss", parcs);
	        return "listeparcours";
	    }
	 @RequestMapping("/chercherParcours")
	
	    public String chercherParcours(@RequestParam("nomParc") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Etudiant> prods = etudService.findByNomParcoursContains(nom);
	    	  System.out.println(prods);
	    	  modelMap.addAttribute("parcourss",prods);
	    	  
	    	  return "chercherParc";
	    } 


}
