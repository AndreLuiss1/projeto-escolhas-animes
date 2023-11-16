package com.filme.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@SpringBootApplication
@Service
@RestController
@RequestMapping("/v1/animes-filter")

public class AnimeFilter {
	
	public static void main(String[] args) {
        SpringApplication.run(AnimeFilter.class, args);
        }

    private final List<Anime> animes;

    @Autowired
    private AnimeService animeService;

    public AnimeFilter(List<Anime> animes) {
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

