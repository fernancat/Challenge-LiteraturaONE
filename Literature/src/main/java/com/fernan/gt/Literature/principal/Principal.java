package com.fernan.gt.Literature.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.fernan.gt.Literature.models.Authors;
import com.fernan.gt.Literature.models.Book;
import com.fernan.gt.Literature.models.BookData;
import com.fernan.gt.Literature.models.Results;
import com.fernan.gt.Literature.repository.AuthorsRepository;
import com.fernan.gt.Literature.repository.BookRepository;
import com.fernan.gt.Literature.service.ApiConsumerService;
import com.fernan.gt.Literature.service.ConvierteDatos;

public class Principal {
    private final String API_BASE_URL = "http://gutendex.com";
    private ApiConsumerService apiConsumerService = new ApiConsumerService();
    private Scanner reader = new Scanner(System.in);
    private ConvierteDatos convertidor = new ConvierteDatos();
    private BookRepository repositoryBook;
    private AuthorsRepository repositoryAuthors;

    public Principal(BookRepository repositoryBook, AuthorsRepository repositoryAuthors){
        this.repositoryBook = repositoryBook;
        this.repositoryAuthors = repositoryAuthors;
    }

    public Principal(){

    }
    public void Init(){
        
        int opcion  = 0;

        do{
            try{
                 GenerateMenu();
                opcion = reader.nextInt();
                reader.nextLine();
                switch(opcion){
                    case 1:
                        searchBookByTitle();
                        break;
                    case 2:
                        searchRegisterBookInBD();
                }
            }catch(NumberFormatException n){
                System.out.println("Debes insertar una opcion valida");
            }
            
        }while(opcion != -1);

    }



    public void searchBookByTitle(){
        System.out.println("Escribe el nombre del libro que deseas buscar: ");
        String title = reader.nextLine();
        String titleFormated = API_BASE_URL + "books?search=" + title.replace(" ", "%20");
        String json = apiConsumerService.getData(API_BASE_URL + "/books/?search=" + title.replace(" ", "%20"));
        var libros = convertidor.convertData(json, Results.class);
        
        Optional<Book> libroDisponible = libros.bookData().stream()
        .filter(l -> l.title().toLowerCase().contains(title.toLowerCase()))
        .map(l -> new Book(l.title(),l.authors(), l.donwloads(), l.languages().get(0).toString()))
        .findFirst();

        if (libroDisponible.isPresent()){
            Book libro = libroDisponible.get();

            List<Authors> autores = libro.getAuthors();
            repositoryAuthors.saveAll(autores);

            repositoryBook.save(libro);
            
        }else{
            System.out.println("No se encontro ningun libro con ese titulo");
        }
    }

    private void searchRegisterBookInBD() {
        List<Book> books = repositoryBook.findAll();

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            System.out.println("Libros registrados en la base de datos:");
            books.forEach(book -> System.out.println(book.toString()));
        }
    }



    public void GenerateMenu(){
        System.out.println("--------------Bienvenido a Lectorama-------\n "+
        "a" + "Escoge una de las siguientes opciones: " + "\n \t 1- Buscar Libros Por titulo" +
        "\n \t 2- Buscar Libros Registrados en la BD"
        +"\n \t 3- Listar Autores Registrados en la BD"+
        "\n \t 4- Listar autores vivos en un determinado año" +
        "\n \t 5- Listar Libros Por idioma" +"\n \t 0- Salir");
    }
}
