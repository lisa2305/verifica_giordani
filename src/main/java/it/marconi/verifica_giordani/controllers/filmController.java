package it.marconi.verifica_giordani.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.marconi.verifica_giordani.domains.listFilm;
import it.marconi.verifica_giordani.services.filmService;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class filmController {
    
    @Autowired
    filmService servizioFilm ;

    @GetMapping("/films")
    public ModelAndView homepageFilms(){
        return new ModelAndView("Films-list").addObject("film", servizioFilm.findAll());
    }

    @GetMapping("/films/nuovo")
    public ModelAndView newFilm(){
        return new ModelAndView ("film-form").addObject("filmForm", new listFilm());
    }

    @PostMapping("/films/nuovo")
    public ModelAndView handelerNewFilm(@ModelAttribute listFilm l){
        servizioFilm.addFilm(l);
        String codice = l.getCodice();
        return new ModelAndView("redirect:/films/" + codice);
    }

    @GetMapping("/films/{codice}")
    public ModelAndView detailFilm(@PathVariable("codice") String codice){
        Optional<listFilm> f = servizioFilm.getCode(codice);

        return new ModelAndView("film-detail").addObject("film", f.get());
    }

    @GetMapping("films/delete/{codice}") 
    public ModelAndView deleteContact(
        @PathVariable("codice") String codice,
        RedirectAttributes attr
    ) {
        servizioFilm.deleteById(codice); 

        // aggiunto un boolean agli attributi del redirect
        attr.addFlashAttribute("deleted", true);
        return new ModelAndView("redirect:/films");
    }
}
