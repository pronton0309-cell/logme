package com.example.logme;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController{
    private final BookRepository repository;

    public HelloController(BookRepository repository){
        this.repository = repository;
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return repository.findAll();
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        repository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {

        repository.deleteById(id);
        return ResponseEntity.ok("削除成功");
    }


    @GetMapping("/books/search")
    public List<Book> searchBooks(@RequestParam String keyword){
        List<Book> result =new ArrayList<>();

        for(Book book : repository.findAll()){
            String title = book.getTitle();
            String author = book.getAuthor();

            if(title == null){
                title = "";
            }
            if(author == null){
                author = "";
            }

            if(title.toLowerCase().contains(keyword.toLowerCase())
            || author.toLowerCase().contains(keyword.toLowerCase())){
                result.add(book);
            }
        }
        return result;
    }
    @PutMapping("/books/{id}/top10")
    public ResponseEntity<Void>toggleTop10(@PathVariable Long id){
        Book book = repository.findById(id).orElse(null);

        if(book == null){
        return ResponseEntity.notFound().build();
        }

        Boolean currentTop10 = book.getTop10();

        if(currentTop10 == null){
        currentTop10 = false;
        }

        book.setTop10(!currentTop10);
        repository.save(book);

        return ResponseEntity.ok().build();
    }
}
