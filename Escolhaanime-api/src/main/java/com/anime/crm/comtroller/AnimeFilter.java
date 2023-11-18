package com.anime.crm.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animes-filter")
public class AnimeFilter {

    private final AnimeService animeService;

    @Autowired
    public AnimeFilter(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public List<Anime> listarAnimes() {
        return animeService.listarAnimes();
    }

    @PostMapping
    public void adicionarAnime(@RequestBody Anime anime) {
        animeService.adicionarAnime(anime);
    }

    @GetMapping("/filtrar")
    public List<Anime> filtrarAnimes(@RequestParam(required = false) String genero,
                                     @RequestParam(required = false) Integer ano,
                                     @RequestParam(required = false) Integer episodios,
                                     @RequestParam(required = false) Boolean filme) {
        return animeService.filtrarAnimes(genero, ano, episodios, filme);
    }
}
