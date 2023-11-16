package com.filme.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class AnimeFilter {

    private final List<Anime> animes = new ArrayList<>();

    @Autowired
    private AnimeService animeService;

    public static void main(String[] args) {
        SpringApplication.run(AnimeFilter.class, args);

        try (Scanner scanner = new Scanner(System.in)) {
            AnimeFilter animeFilter = new AnimeFilter();
            animeFilter.menu(scanner);
        }
    }

    private void menu(Scanner scanner) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Anime");
            System.out.println("2 - Listar Animes");
            System.out.println("3 - Filtrar Animes");
            System.out.println("0 - Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    adicionarAnime(scanner);
                    break;
                case 2:
                    listarAnimes();
                    break;
                case 3:
                    filtrarAnimes(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void adicionarAnime(Scanner scanner) {
        System.out.print("Título do anime: ");
        String titulo = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();
        System.out.print("Número de episódios: ");
        int episodios = scanner.nextInt();
        System.out.print("É um filme? (true/false): ");
        boolean filme = scanner.nextBoolean();
        scanner.nextLine(); // Consumir a quebra de linha

        Anime anime = new Anime(titulo, genero, ano, episodios, filme);
        animes.add(anime);
        System.out.println("Anime adicionado com sucesso!");
    }

    private void listarAnimes() {
        System.out.println("Lista de Animes:");
        for (Anime anime : animes) {
            System.out.println(anime.getTitulo());
        }
    }

    private void filtrarAnimes(Scanner scanner) {
        System.out.print("Filtrar por gênero (deixe em branco para qualquer): ");
        String generoFiltrado = scanner.nextLine();
        System.out.print("Filtrar por ano (deixe em branco para qualquer): ");
        String anoFiltradoStr = scanner.nextLine();
        int anoFiltrado = anoFiltradoStr.isEmpty() ? 0 : Integer.parseInt(anoFiltradoStr);
        System.out.print("Filtrar por número de episódios (deixe em branco para qualquer): ");
        String episodiosFiltradosStr = scanner.nextLine();
        int episodiosFiltrados = episodiosFiltradosStr.isEmpty() ? Integer.MAX_VALUE : Integer.parseInt(episodiosFiltradosStr);
        System.out.print("Filtrar por filme? (true/false, deixe em branco para qualquer): ");
        String filmeFiltradoStr = scanner.nextLine();
        boolean filmeFiltrado = !filmeFiltradoStr.isEmpty() && Boolean.parseBoolean(filmeFiltradoStr);

        List<Anime> animesFiltrados = animeService.filtrarAnimes(animes, generoFiltrado, anoFiltrado, episodiosFiltrados, filmeFiltrado);

        System.out.println("Animes que correspondem aos critérios:");
        for (Anime anime : animesFiltrados) {
            System.out.println(anime.getTitulo());
        }
    }
}

@Service
class AnimeService {

    public List<Anime> filtrarAnimes(List<Anime> animes, String generoFiltrado, int anoFiltrado, int episodiosFiltrados, boolean filmeFiltrado) {
        return animes.stream()
                .filter(anime -> (generoFiltrado.isEmpty() || anime.getGenero().equalsIgnoreCase(generoFiltrado))
                        && (anoFiltrado == 0 || anime.getAno() == anoFiltrado)
                        && (episodiosFiltrados == Integer.MAX_VALUE || anime.getEpisodios() <= episodiosFiltrados)
                        && (filmeFiltrado || !anime.isFilme()))
                .collect(Collectors.toList());
    }
}
