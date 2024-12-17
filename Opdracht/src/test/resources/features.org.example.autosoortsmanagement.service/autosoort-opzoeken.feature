# language: nl

Functionaliteit: Een autosoort opzoeken op id of op naam en merk

  Een Verkoper
  kan een bekende autosoort opzoeken op id of op naam en merk
  Hij krijgt de naam, het merk en het huidig voorraadniveau van de gevonden autosoort

  Achtergrond:
    Gegeven er zijn 3 bekende autosoorten
      | naam       | merk       | huidigeVoorraadniveau | minimumpeiler | maximumpeiler |
      | Fiesta     | Ford       | 3                     | 5             | 10            |
      | Corolla    | Toyota     | 12                    | 6             | 15            |
      | Model 3    | Tesla      | 5                     | 3             | 8             |

  Scenario: Een autosoort met een gekend id opzoeken tussen de bekende autosoorten
    Gegeven de Verkoper een autosoort toegevoegd heeft met naam "Golf", merk "Volkswagen", hudig voorraadniveau 7, minimumpeiler 5 en maximumpeiler 10
    En de Verkoper het toegekende uniek id gekregen heeft
    Als de Verkoper de autosoort met het toegekende uniek id opzoekt
    Dan krijgt hij "Golf Volkswagen, 7" als informatie over de gezochte autosoort

  Scenario: Een autosoort met haar naam en merk opzoeken tussen de bekende personen
    Als de Verkoper de autosoort met naam en mark "Golf Volkswagen" opzoekt
    Dan krijgt hij "Golf Volkswagen, 7" als informatie over de gezochte autosoort