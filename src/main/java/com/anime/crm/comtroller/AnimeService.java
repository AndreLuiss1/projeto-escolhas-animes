package com.anime.crm.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anime.crm.comtroller.interfac.AnimeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> listarAnimes() {
        return animeRepository.findAll();
    }

    public void adicionarAnime(Anime anime) {
        animeRepository.save(anime);
    }

    public List<Anime> filtrarAnimes(String genero, Integer ano, Integer episodios, Boolean filme) {
        return animeRepository.findAll().stream()
                .filter(anime ->
                        (genero == null || anime.getGenero().equalsIgnoreCase(genero)) &&
                        (ano == null || anime.getAno() == ano) &&
                        (episodios == null || anime.getEpisodios() <= episodios) &&
                        (filme == null || anime.isFilme() == filme))
                .collect(Collectors.toList());
    }

   
}
