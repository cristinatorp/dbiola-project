CREATE TABLE IF NOT EXISTS movie_cast (
    id          int not null,
    movie_id    int,
    actor_id    int,
    character   text,
    credit_id   character varying(255),
    CONSTRAINT movie_cast_pkey PRIMARY KEY (id),
    CONSTRAINT movie_cast_fk_movie FOREIGN KEY (movie_id)
        REFERENCES movie (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_cast_fk_actor FOREIGN KEY (actor_id)
        REFERENCES actor (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS movie_crew (
    id              int not null,
    movie_id        int,
    crew_member_id  int,
    job_id          int,
    credit_id       character varying(255),
    CONSTRAINT movie_crew_pkey PRIMARY KEY (id),
    CONSTRAINT movie_crew_fk_movie FOREIGN KEY (movie_id)
        REFERENCES movie (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_crew_fk_crew_member FOREIGN KEY (crew_member_id)
        REFERENCES crew_member (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_crew_fk_crew_job FOREIGN KEY (job_id)
        REFERENCES crew_job (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS movie_genre (
    id          int not null,
    movie_id    int,
    genre_id    int,
    CONSTRAINT movie_genre_pkey PRIMARY KEY (id),
    CONSTRAINT movie_genre_fk_movie FOREIGN KEY (movie_id)
        REFERENCES movie (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_genre_fk_genre FOREIGN KEY (genre_id)
        REFERENCES genre (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS movie_keyword (
    id          int not null,
    movie_id    int,
    keyword_id  int,
    CONSTRAINT movie_keyword_pkey PRIMARY KEY (id),
    CONSTRAINT movie_keyword_fk_movie FOREIGN KEY (movie_id)
        REFERENCES movie (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_keyword_fk_keyword FOREIGN KEY (keyword_id)
        REFERENCES keyword (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS movie_prod_company (
    id          int not null,
    movie_id    int,
    company_id  int,
    CONSTRAINT movie_prod_company_pkey PRIMARY KEY (id),
    CONSTRAINT movie_prod_company_fk_movie FOREIGN KEY (movie_id)
        REFERENCES movie (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_prod_company_fk_prod_company FOREIGN KEY (company_id)
        REFERENCES production_company (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS movie_prod_country (
    id          int not null,
    movie_id    int,
    country_id  int,
    CONSTRAINT movie_prod_country_pkey PRIMARY KEY (id),
    CONSTRAINT movie_prod_country_fk_movie FOREIGN KEY (movie_id)
        REFERENCES movie (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_prod_country_fk_prod_country FOREIGN KEY (country_id)
        REFERENCES production_country (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS movie_spoken_language (
    id          int not null,
    movie_id    int,
    language_id int,
    CONSTRAINT movie_spoken_language_pkey PRIMARY KEY (id),
    CONSTRAINT movie_spoken_language_fk_movie FOREIGN KEY (movie_id)
        REFERENCES movie (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT movie_spoken_language_fk_language FOREIGN KEY (language_id)
        REFERENCES spoken_language (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);