package com.example.demo.controller;

import com.example.demo.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Movie;

import java.util.List;
import java.util.Objects;

// Annotation
@RestController

// Class
public class MovieController {

    @Autowired
    private MovieRepo repo;

    @PostMapping("/addMovie")
    public String saveBook(@RequestBody Movie movie){
        repo.save(movie);

        return "Added Successfully";
    }

    @GetMapping("/findAllMovies")
    public List<Movie> getBooks() {

        return repo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        repo.deleteById(id);

        return "Deleted Successfully";
    }
    @PutMapping("/update/{id}")
    public String updateMovie(@PathVariable Integer id,@RequestBody Movie movie)
    {
       Movie m=repo.findById(id).get();
        if(Objects.nonNull(movie.getMovieName())&&
                !"".equalsIgnoreCase(movie.getMovieName()))
        {
            m.setMovieName(movie.getMovieName());
        }
        repo.save(m);
        return "updated successfully";
    }

}
