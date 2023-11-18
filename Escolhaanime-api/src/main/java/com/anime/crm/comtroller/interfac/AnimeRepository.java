// Interface que define métodos para realizar consultas no banco de dados para a entidade Anime
package com.anime.crm.comtroller.interfac;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.anime.crm.comtroller.Anime;
//Métodos de consulta derivados do nome para buscar animes por diferentes critérios
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    List<Anime> findByTitulo(String titulo);

    List<Anime> findByGenero(String genero);

    List<Anime> findByAno(int ano);

    List<Anime> findByEpisodiosLessThan(int maxEpisodios);

    List<Anime> findByFilme(boolean filme);

    List<Anime> findByGeneroAndAno(String genero, int ano);

    // Adicione outros métodos conforme necessário
}
