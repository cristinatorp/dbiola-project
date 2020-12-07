INSERT INTO dim_movie (
    SELECT id as movie_id, title, popularity, rating, votes, runtime
    FROM movie
);

INSERT INTO dim_company (
    SELECT id as company_id, company
    FROM production_company
    GROUP BY id, company
    ORDER BY id
);

INSERT INTO dim_country (
    SELECT id as country_id, code, country
    FROM production_country
    GROUP BY id, code, country
    ORDER BY id
);

INSERT INTO dim_genre (
    SELECT id as genre_id, genre
    FROM genre
    GROUP BY id, genre
    ORDER BY id
);

INSERT INTO fact_revenue (
    SELECT  m.id,
            p.company_id,
            y.country_id,
            g.genre_id,
            m.release_date,
            m.revenue,
            m.budget
    FROM    movie m,
            movie_prod_company p,
            movie_prod_country y,
            movie_genre g
    WHERE   m.id = p.movie_id AND
            m.id = y.movie_id AND
            m.id = g.movie_id AND
            m.release_date IS NOT NULL AND
            m.revenue <> 0 AND
            m.budget <> 0
    ORDER BY m.id
);