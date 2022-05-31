package com.fedi.etudiants.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fedi.etudiants.entities.Parcours;
import com.fedi.etudiants.entities.Etudiant;
import com.fedi.etudiants.service.ParcoursService;
import com.fedi.etudiants.service.EtudiantService;


@Controller
public class EtudiantController {
	@Autowired
	EtudiantService etudiantService;
	@Autowired
	ParcoursService parcoursService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("etudiant", new Etudiant());
	modelMap.addAttribute("mode", "new");
	List<Parcours> parcours = parcoursService.getAllParcourss();

	modelMap.addAttribute("parcourss", parcours);
	return "formEtudiant";
	}
	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@Valid Etudiant etudiant,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formEtudiant";
	
	etudiantService.saveEtudiant(etudiant);
	return "redirect:/ListeEtudiants";
	}
	@RequestMapping("/ListeEtudiants")
	public String listeEtudiants(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)

	{
	Page<Etudiant> prods = etudiantService.getAllEtudiantsParPage(page, size);
	modelMap.addAttribute("etudiants", prods);

	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	List<Parcours> parcs = parcoursService.getAllParcourss();
	modelMap.addAttribute("parcourss", parcs);

	modelMap.addAttribute("currentPage", page);
	
	
	
	return "listeEtudiants";
	}
	
	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "10") int size)

	{
	etudiantService.deleteEtudiantById(id);
	Page<Etudiant> prods = etudiantService.getAllEtudiantsParPage(page,

	size);

	modelMap.addAttribute("etudiants", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	List<Parcours> parcs = parcoursService.getAllParcourss();
	modelMap.addAttribute("parcourss", parcs);
	return "listeEtudiants";
	}
	
	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Etudiant p= etudiantService.getEtudiant(id);
		modelMap.addAttribute("etudiant", p);
		modelMap.addAttribute("mode", "edit");
		
		List<Parcours> parcs = parcoursService.getAllParcourss();

		modelMap.addAttribute("parcourss", parcs);
		return "formEtudiant";
	}
	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
//conversion de la date

SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateNaissance = dateformat.parse(String.valueOf(date));
etudiant.setDateNaissance(dateNaissance);
etudiantService.updateEtudiant(etudiant);
List<Etudiant> prods = etudiantService.getAllEtudiants();
modelMap.addAttribute("etudiants", prods);
List<Parcours> parcs = parcoursService.getAllParcourss();
modelMap.addAttribute("parcourss", parcs);
return "listeEtudiants";

}
	 @RequestMapping("/chercherNom")
	    public String chercherEtudiant(@RequestParam("nomEtudiant") String nom,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "10") int size)
	    
	    
	    {     
		 	
	    	  List <Etudiant> prods = etudiantService.findByNomEtudiantContains(nom);
	    	  
	    	  modelMap.addAttribute("Etudiants",prods);
	    	  List<Parcours> parcs = parcoursService.getAllParcourss();
	    		modelMap.addAttribute("parcourss", parcs);
	    	  /*Page<Etudiant> prod = etudiantService.getAllEtudiantsParPage(page, size);
	    		modelMap.addAttribute("Etudiants", prod);

	    		modelMap.addAttribute("pages", new int[prod.getTotalPages()]);

	    		modelMap.addAttribute("currentPage", page);*/
	    	  return "resultat";
	    }  
	
	 @RequestMapping("/chercherParc")
	  public String chercherParc(@RequestParam("idParc") int idParc,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "10") int size)
	    {     
		 	
	    	  List <Etudiant> etudiants = etudiantService.getAllEtudiants();
	    	  etudiants = etudiants.stream()
	                  .filter(x -> x.getParcours().getIdParc() == idParc)
	                  .collect(Collectors.toList());
	    	  modelMap.addAttribute("etudiants",etudiants);
	    	  List<Parcours> parcs = parcoursService.getAllParcourss();
	    		modelMap.addAttribute("parcourss", parcs);
	    		modelMap.addAttribute("currentPage", page);
	    	  
	    	  return "listeEtudiants";
	    }  
	    
		  
}