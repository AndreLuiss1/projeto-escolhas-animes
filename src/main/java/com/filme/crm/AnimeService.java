package com.filme.crm;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    private final List<Anime> animes;

    public AnimeService(List<Anime> animes) {
        this.animes = animes;
    }

    public List<Anime> listarAnimes() {
        return animes;
    }

    public void adicionarAnime(Anime anime) {
        animes.add(anime);
    }

    public List<Anime> filtrarAnimes(String genero, Integer ano, Integer episodios, Boolean filme) {
        return animes.stream()
                .filter(anime ->
                        (genero == null || anime.getGenero().equalsIgnoreCase(genero)) &&
                        (ano == null || anime.getAno() == ano) &&
                        (episodios == null || anime.getEpisodios() <= episodios) &&
                        (filme == null || anime.isFilme() == filme))
                .collect(Collectors.toList());
    }
}
