package com.filme.crm;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {
	
    private final List<Anime> animes;

    public AnimeController(List<Anime> animes) {
        this.animes = animes;
    }

    @GetMapping
    public List<Anime> listarAnimes() {
        return animes;
    }

    @PostMapping
    public void adicionarAnime(@RequestBody Anime anime) {
        animes.add(anime);
    }

    @GetMapping("/filtrar")
    public List<Anime> filtrarAnimes(@RequestParam(required = false) String genero,
                                     @RequestParam(required = false) Integer ano,
                                     @RequestParam(required = false) Integer episodios,
                                     @RequestParam(required = false) Boolean filme) {
        // Implemente a lógica de filtragem conforme necessário
        // Esta implementação de exemplo apenas retorna todos os animes
        return animes;
    }
}
