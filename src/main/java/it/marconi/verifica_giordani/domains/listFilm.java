package it.marconi.verifica_giordani.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class listFilm {
    
    private String codice;
    private String titolo;
    private String genere;
    private String anno;
    private String voto;
}
