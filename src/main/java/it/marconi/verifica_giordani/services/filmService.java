package it.marconi.verifica_giordani.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.marconi.verifica_giordani.domains.listFilm;

@Service
public class filmService {

    // creo un finto database per salvare i film inseriti
    private ArrayList<listFilm> films = new ArrayList<>();

    // aggiungo il film all'array list
    public void addFilm(listFilm l) {
        films.add(l);
    }

    public ArrayList<listFilm> findAll() {
        return films;
    }

    // predo il codice di ciascun film
    public Optional<listFilm> getCode(String code) {

        for (listFilm l : films) {
            if (l.getCodice().equals(code)) {
                return Optional.of(l);
            }
        }
        return Optional.empty();
    }

    // metodo che permette l'eliminazione di tutto il catalogo
    public void deleteAll() {
        films.clear();
    }

    //eliminazine del signolo elemento tramite codice
    public void deleteById(String codice) {
        films.remove(codice);
    }

}
