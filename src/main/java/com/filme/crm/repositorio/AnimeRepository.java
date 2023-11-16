package com.filme.crm.repositorio;

import java.util.List;

import com.filme.crm.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    
    List<Anime> findByTitulo(String titulo);

    List<Anime> findByGenero(String genero);

    List<Anime> findByAno(int ano);

    List<Anime> findByEpisodiosLessThan(int maxEpisodios);

    List<Anime> findByFilme(boolean filme);

    List<Anime> findByGeneroAndAno(String genero, int ano);
    // Exemplo de método combinando múltiplos critérios

    // Adicione outros métodos conforme necessário
}
