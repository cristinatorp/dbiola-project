export const aggOptions = [
    {
        value: "$sum",
        label: "Sum",
        column: "Total"
    },
    {
        value: "$avg",
        label: "Average",
        column: "Average"
    },
    {
        value: "$max",
        label: "Maximum",
        column: "Maximum"
    },
    {
        value: "$min",
        label: "Min",
        column: "Minimum"
    },
];

export const propertyOptions = [
    { value: '$DimGenre', label: 'Genre', type: 'String' },
    { value: '$DimCompany', label: 'Production Company', type: 'String' },
    { value: '$DimCountry', label: 'Production Country', type: 'String' },
    { value: '$vote_average', label: 'Rating', type: 'Numeric' },
    { value: '$vote_count', label: 'Votes', type: 'Numeric' },
];
