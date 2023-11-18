// Classe de serviço que manipula operações relacionadas a animes
package com.anime.crm.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anime.crm.comtroller.interfac.AnimeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {
	// Lista de animes que será manipulada pelos métodos do serviço
    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }
    // Construtor que injeta a lista de animes
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
