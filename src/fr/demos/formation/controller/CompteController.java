package fr.demos.formation.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.LocaleResolver;

import fr.demos.formation.model.Compte;

@Controller
@SessionAttributes("compte")
public class CompteController {

 

	
	@Autowired
	private LocaleResolver sessionLocaleResolver;

	@RequestMapping(value = "/saisieCompte.htm", method = RequestMethod.GET)
	public String affichePage(ModelMap model) {
		
	

		model.addAttribute("compte", new Compte());
		return "saisieCompte";

	}

	@RequestMapping(value = "/english.htm", method = RequestMethod.GET)
	public String english(HttpServletRequest request, HttpServletResponse response) {

		sessionLocaleResolver.setLocale(request, response, Locale.ENGLISH);
		return "saisieCompte";

	}

	@RequestMapping(value = "/french.htm", method = RequestMethod.GET)
	public String french(HttpServletRequest request, HttpServletResponse response) {

	
		
		sessionLocaleResolver.setLocale(request, response, Locale.FRENCH);
		return "saisieCompte";
		

	}

	@RequestMapping(value = "/enregistrerCompte.htm", method = RequestMethod.POST)
	public String enregistrerCompte(@ModelAttribute("compte") @Valid Compte compte, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {

		System.out.println("le nom:" + compte.getNom());
		System.out.println("le prenom:" + compte.getPrenom());
		System.out.println("la date de naissance:" + compte.getDateNaissance());
		System.out.println("l'email:" + compte.getEmail());

		if (result.hasErrors()) {

			return "saisieCompte";

		} else {

			return "saisieSuccess";
		}

	}

}
