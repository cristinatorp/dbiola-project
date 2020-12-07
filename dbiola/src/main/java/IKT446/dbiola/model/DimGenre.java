package IKT446.dbiola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DimGenre {

    @Id
    @Column(name = "genre_id")
    private Long genreId;
    private String genre;

    public DimGenre() {}

    public DimGenre(Long genreId, String genre) {
        this.genreId = genreId;
        this.genre = genre;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
