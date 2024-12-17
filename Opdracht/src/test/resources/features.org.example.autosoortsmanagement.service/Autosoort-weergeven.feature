# language: nl


Feature: Bekende autosoorten weergeven

  Scenario: Er zijn geen bekende autosoorten zodat een lege lijst resulteert
  Gegeven er zijn geen bekende autosoorten
  Wanneer de Verkoper een lijst van bekende autosoorten opvraagt
  Dan krijgt hij "Aantal bekende autosoorten 0" als resultaat

  Scenario: Er zijn meerdere bekende autosoorten die in een lijst getoond worden
  Gegeven er zijn 3 bekende autosoorten
  | naam     | merk    | huidigVoorraadniveau | minimumpeiler | maximumpeiler |
  | Fiesta   | Ford    | 3                    | 5             | 10            |
  | Corolla  | Toyota  | 12                   | 6             | 15            |
  | Model 3  | Tesla   | 5                    | 3             | 8             |
  Wanneer de Verkoper een lijst van bekende autosoorten opvraagt
  Dan krijgt hij als resultaat voor de lijst van bekende autosoorten
  | autosoort       | huidigVoorraadniveau |
  | Fiesta Ford     | 3                    |
  | Corolla Toyota  | 12                   |
  | Model 3 Tesla   | 5                    |
  | Aantal bekende autosoorten 3 |
