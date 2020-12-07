COPY actor
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/actors.csv'
    DELIMITER ','
    CSV HEADER;

COPY crew_job
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/jobs.csv'
    DELIMITER ','
    CSV HEADER;

COPY crew_member
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/crew_members.csv'
    DELIMITER ','
    CSV HEADER;

COPY genre
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/genres.csv'
    DELIMITER ','
    CSV HEADER;

COPY keyword
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/keywords.csv'
    DELIMITER ','
    CSV HEADER;

COPY production_company
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/production_companies.csv'
    DELIMITER ','
    CSV HEADER;

COPY production_country
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/production_countries.csv'
    DELIMITER ','
    CSV HEADER;

COPY spoken_language
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/spoken_languages.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/independent/movies.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie_cast
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/relational/movie_cast_members.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie_crew
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/relational/movie_crew_members.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie_genre
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/relational/movie_genres.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie_keyword
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/relational/movie_keywords.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie_prod_company
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/relational/movie_prod_companies.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie_prod_country
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/relational/movie_prod_countries.csv'
    DELIMITER ','
    CSV HEADER;

COPY movie_spoken_language
    FROM '/Users/cristinatorp/Dokumenter/Skole/Master/Semester3/IKT446/Project/dbiola/src/main/resources/data/relational/movie_languages.csv'
    DELIMITER ','
    CSV HEADER;