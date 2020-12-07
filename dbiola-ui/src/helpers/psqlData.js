export const aggOptions = [
    {
        value: "SUM",
        label: "Sum"
    },
    {
        value: "AVG",
        label: "Average"
    },
    {
        value: "MAX",
        label: "Maximum"
    },
    {
        value: "MIN",
        label: "Minimum"
    }
];

export const dimensionOptions = [
    { value: 'M.title', label: 'Movie title', type: 'String', table: 'dim_movie M', pk: 'movie_id' },
    { value: 'M.popularity', label: 'Popularity', type: 'Number', table: 'dim_movie M', pk: 'movie_id' },
    { value: 'M.rating', label: 'Rating', type: 'Number', table: 'dim_movie M', pk: 'movie_id' },
    { value: 'M.votes', label: 'Number of votes', type: 'Number', table: 'dim_movie M', pk: 'movie_id' },
    { value: 'M.runtime', label: 'Movie length', type: 'Number', table: 'dim_movie M', pk: 'movie_id' },

    { value: 'date_part(\'year\', F.release_date)', label: 'Release Year', type: 'Date', table: 'fact_revenue F', pk: '' },

    { value: 'P.company', label: 'Production Company', type: 'String', table: 'dim_company P', pk: 'company_id' },

    { value: 'C.country', label: 'Production Country', type: 'String', table: 'dim_country C', pk: 'country_id' },
    { value: 'C.code', label: 'Country Code', type: 'String', table: 'dim_country C', pk: 'country_id' },

    { value: 'G.genre', label: 'Movie Genre', type: 'String', table: 'dim_genre G', pk: 'genre_id' },
];

export const allFilterOptions = [
    {
        type: 'String',
        placeholder: 'I.e. "ava"',
        options: [
            { value: '*', label: 'Include all' },
            { value: '=', label: 'Equals' },
            { value: 'contains', label: 'Contains' },
            { value: 'notcontains', label: 'Does not contain' },
            { value: 'starts', label: 'Starts with' },
            { value: 'ends', label: 'Ends with' },
        ]
    },
    {
        type: 'Number',
        placeholder: 'I.e. "5"',
        options: [
            { value: '*', label: 'Include all' },
            { value: '=', label: 'Equals' },
            { value: '!=', label: 'Does not equal' },
            { value: '>', label: 'Is greater than' },
            { value: '<', label: 'Is less than' },
        ]
    },
    {
        type: 'Date',
        options: [
            { value: '*', label: 'Include all' },
            { value: '=', label: 'Is' },
            { value: '<', label: 'Is before' },
            { value: '>', label: 'Is after' },
        ]
    }
];