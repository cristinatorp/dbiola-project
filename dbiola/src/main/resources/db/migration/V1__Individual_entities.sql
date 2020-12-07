CREATE TABLE IF NOT EXISTS actor (
    id     int not null,
    name   character varying(255),
    gender int,
    CONSTRAINT actor_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS crew_job (
    id          int not null,
    job         character varying(255),
    department  character varying(255),
    CONSTRAINT crew_job_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS crew_member (
    id      int not null,
    name    character varying(255),
    gender  int,
    CONSTRAINT crew_member_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS genre (
    id      int not null,
    genre   character varying(255),
    CONSTRAINT genre_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS keyword (
    id      int not null,
    keyword character varying(255),
    CONSTRAINT keyword_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS production_company (
    id      int not null,
    company character varying(255),
    CONSTRAINT production_company_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS production_country (
    id      int not null,
    code    character varying(255),
    country character varying(255),
    CONSTRAINT production_country_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS spoken_language (
    id       int not null,
    code     character varying(255),
    language character varying(255),
    CONSTRAINT spoken_language_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS movie (
    id                  int not null,
    title               character varying(255),
    tagline             character varying(255),
    overview            text,
    released            boolean,
    release_date        date,
    original_language   character varying(255),
    budget              bigint,
    revenue             bigint,
    popularity          double precision,
    runtime             int,
    votes               int,
    rating              double precision,
    homepage            character varying(255),
    CONSTRAINT movie_pkey PRIMARY KEY (id)
);