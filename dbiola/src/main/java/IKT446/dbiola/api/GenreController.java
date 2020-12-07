package IKT446.dbiola.api;

import IKT446.dbiola.model.Genre;
import IKT446.dbiola.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreRepo genreRepo;

    @Autowired
    public GenreController(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    @GetMapping
    public List<Genre> getGenres() {
        return genreRepo.findAll();
    }

    @DeleteMapping("/deleteAll")
    public void deleteGenres() {
        genreRepo.deleteAll();
    }

}
