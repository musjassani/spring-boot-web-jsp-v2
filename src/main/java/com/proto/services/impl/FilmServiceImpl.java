package com.proto.services.impl;

import com.proto.beans.Artiste;
import com.proto.beans.Film;
import com.proto.beans.Genre;
import com.proto.services.ArtisteService;
import com.proto.services.FilmService;
import com.proto.services.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("filmService")
public class FilmServiceImpl extends AbstractServiceImpl<Film> implements FilmService{

    private final Logger logger = LoggerFactory.getLogger(FilmServiceImpl.class);

    @Autowired
    ArtisteService artisteService;

    @Autowired
    GenreService genreService;

    @Override
    @Transactional
    public void testInsertFilm() {

        Film gravity = new Film();
        gravity.setTitre("Gravity");
        gravity.setAnnee(2013);

        Genre genre = new Genre();
        genre.setCode("Science-fiction");
        genreService.save(genre);
        gravity.setGenre(genre);

        Artiste cuaron = new Artiste();
        cuaron.setPrenom("Alfonso");
        cuaron.setNom("Cuaron");
        cuaron.addFilm(gravity);// Le réalisateur de Gravity est Alfonso Cuaron

        // Sauvegardons dans la base
        save(gravity);
        artisteService.save(cuaron);

        /*
        SQL
        select genre_.Code from Genre genre_ where genre_.Code='Science-fiction'
        -- Comme nous avons indiqué la valeur de la clé primaire dans l’instance Java,
        -- Hibernate vérifie automatiquement si cet objet Genre existe dans la base pour le lier par référence à l’objet Film en cours de création
        insert into Film (Annee, CodeGenre, CodePays, IdRealisateur, Titre) values (2013, null, null, null, 'Gravity')
        -- Hibernate n'a pas trouvé le genre dans la base et n'a pas cherché le réalisateur car ce dernier n'a pas de clé primaire donc les deux FK seront null
         */
    }
}
