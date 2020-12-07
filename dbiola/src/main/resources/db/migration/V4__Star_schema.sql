CREATE SEQUENCE IF NOT EXISTS dim_movie_seq;
CREATE TABLE IF NOT EXISTS dim_movie (
    movie_id    int not null DEFAULT nextval('dim_movie_seq'::regclass),
    title       character varying(255),
    popularity  double precision,
    rating      double precision,
    votes       int,
    runtime     int,
    CONSTRAINT dim_movie_pkey PRIMARY KEY (movie_id)
);

CREATE SEQUENCE IF NOT EXISTS dim_company_seq;
CREATE TABLE IF NOT EXISTS dim_company (
    company_id  int not null DEFAULT nextval('dim_company_seq'::regclass),
    company     character varying(255),
    CONSTRAINT dim_company_pkey PRIMARY KEY (company_id)
);

CREATE SEQUENCE IF NOT EXISTS dim_country_seq;
CREATE TABLE IF NOT EXISTS dim_country (
    country_id  int not null DEFAULT nextval('dim_country_seq'::regclass),
    code        character varying(255),
    country     character varying(255),
    CONSTRAINT dim_country_pkey PRIMARY KEY (country_id)
);

CREATE SEQUENCE IF NOT EXISTS dim_genre_seq;
CREATE TABLE IF NOT EXISTS dim_genre (
    genre_id  int not null DEFAULT nextval('dim_genre_seq'::regclass),
    genre     character varying(255),
    CONSTRAINT dim_genre_pkey PRIMARY KEY (genre_id)
);

CREATE TABLE IF NOT EXISTS fact_revenue (
    movie_id        int not null,
    company_id      int not null,
    country_id      int not null,
    genre_id        int not null,
    release_date    date,
    revenue         bigint,
    budget          bigint,
    CONSTRAINT fact_revenue_pkey PRIMARY KEY (movie_id, company_id, country_id, genre_id, release_date),
    CONSTRAINT fact_revenue_fk_dim_movie FOREIGN KEY (movie_id)
        REFERENCES dim_movie (movie_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT fact_revenue_fk_dim_company FOREIGN KEY (company_id)
        REFERENCES dim_company (company_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT fact_revenue_fk_dim_country FOREIGN KEY (country_id)
        REFERENCES dim_country (country_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION,
    CONSTRAINT fact_revenue_fk_dim_genre FOREIGN KEY (genre_id)
        REFERENCES dim_genre (genre_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
);