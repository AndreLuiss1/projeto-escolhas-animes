package com.filme.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animes")
public class AnimeController {

    private final List<Anime> animes;

    @Autowired
    private AnimeService animeService;

    public AnimeController(List<Anime> animes) {
        this.animes = animes;
    }

    @GetMapping
    public List<Anime> listarAnimes() {
        return animes;
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
