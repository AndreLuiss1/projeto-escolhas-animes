package com.filme.crm;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Serviço {

    public List<Anime> filtrarAnimes(List<Anime> animes, String generoFiltrado, int anoFiltrado, int episodiosFiltrados, boolean filmeFiltrado) {
        return animes.stream()
                .filter(anime -> (generoFiltrado.isEmpty() || anime.getGenero().equalsIgnoreCase(generoFiltrado))
                        && (anoFiltrado == 0 || anime.getAno() == anoFiltrado)
                        && (episodiosFiltrados == Integer.MAX_VALUE || anime.getEpisodios() <= episodiosFiltrados)
                        && (filmeFiltrado || !anime.isFilme()))
                .collect(Collectors.toList());
    }
}
