# language: nl

  Functionaliteit: een autosoort aan de bekende autosoorten toevoegen

    Een Logistiek Medewerker (LM)
    kan een autosoort toevoegen met een naam, merk, huidig voorraadniveau, minimumpeiler en maximumpeiler.
    De toegevoegde autosoort krijgt een uniek id.

    Scenario: Een eerste autosoort toevoegen
      Gegeven er zijn geen bekende autosoorten
      Als de LM een autosoort toevoegt met naam "Civic", merk "Honda", huidig voorraadniveau 10, minimumpeiler 6 en maximumpeiler 12.
      Dan is er 1 bekende autosoort
      En krijgt de LM het toegekende uniek id

    Scenario: Een volgende autosoort toevoegen
      Gegeven er zijn 3 bekende autosoorten
        | naam       | merk       | huidigeVoorraadniveau | minimumpeiler | maximumpeiler |
        | Fiesta     | Ford       | 3                     | 5             | 10            |
        | Corolla    | Toyota     | 12                    | 6             | 15            |
        | Model 3    | Tesla      | 5                     | 3             | 8             |
      Als de LM een autosoort toevoegt met naam "Golf", merk "Volkswagen", hudig voorraadniveau 7, minimumpeiler 5 en maximumpeiler 10
      Dan zijn er 3 autosoorten
      En krijgt de LM het toegekende uniek id
