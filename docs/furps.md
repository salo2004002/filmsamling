# FURPS – vores filmsamling

|     | Krav                                                                    | Opfyldt? | Hvor                                                                 |
|-----|-|----------|----------------------------------------------------------------------|
| F   | Man kan søge på en del af en titel                                      | Ja       | US4, `domainmodel.MovieCollection`                                   |
| F   | Man kan oprete en film og bekræfter med filmens titel efter den er lagt til i samlingen. | Ja       | US1, `UserInterFace.addMovie`                                        |
| F   | Vill have en menu, der men kan oprete en film og avslut                 | Ja       | US2, `UserInterFace`                                                 |
| F   | Skal vises menun igen når man har udføt dit val                         | Ja       | US2, `UserInterFace`                                                 |
| F   | Givet at jeg skriver noget, der ikke er et menuvalg, så får jeg det at vide, og menuen vises igen – programmet går ikke ned. | Ja       | US2, `UserInterFace`                                                 |
| F   | Givet at jeg vælger "Afslut", så stopper programmet med en afskedshilsen. | Ja       | US2, `UserInterFace`                                                 |
| F   | Givet at samlingen indeholder film, når jeg vælger "Vis alle film", så vises alle oplysninger om hver film. | Ja       | US3, `UserInterFace`                                                 |
| F   | Der må ikke stå computer-ord som null, true eller false i udskriften. En film er "farver" eller "sort-hvid" – ikke true. | Ja       | US3, `UserInterFace`                                                 |
| F   | Givet at samlingen er tom, så får jeg en besked om det i stedet for ingenting. | Ja       | US3, `UserInterFace`                                                 |
| F   | Jeg kan søge på en del af titlen: søgningen god finder både The Godfather og Godzilla. | Ja       | US4, `UserInterFace`                                                 |
| F   | Søgningen er ligeglad med store og små bogstaver: GOD, god og God giver det samme. | Ja       | US4, `UserInterFace`                                                 |
| F   | Givet at flere film matcher, så vises alle de film, der matcher.        | Ja       | US4, `UserInterFace`                                                 |
| F   | Givet at ingen film matcher, så får jeg en besked om det.               | Ja       | US4, `UserInterFace`                                                 |
| F   | Jeg finder filmen ved at søge (som i US4). Matcher flere film, vælger jeg den rigtige ud fra et nummer. | Ja       | US5, `UserInterFace`                                                 |
| F   | Jeg kan rette alle oplysninger, og jeg kan beholde en oplysning uden at skrive den igen. | Ja       | US5, `UserInterFace`                                                 |
| F   | Efter redigeringen vises alle filmens oplysninger – også dem, jeg ikke har ændret. | Ja       | US5, `UserInterFace`                                                 |
| F   | Jeg finder filmen på samme måde som i US5.                              | Ja       | US6, `UserInterFace`                                                 |
| F   | Programmet spørger, om jeg er sikker, før filmen slettes.               | Ja       | US6, `UserInterFace`                                                 |
| F   | Bagefter er filmen væk fra samlingen.                                   | Ja       | US6, `UserInterFace`                                                 |
| F   | Jeg kan markere en film som set, og dagens dato gemmes som sidst set-dato. | Ja       | US8, `Controller.markAsWatched`                                      |
| F   | Jeg kan angive et antal dage, og se film, der aldrig er set eller ikke er set i mindst det antal dage. | Ja       | US9, `Controller.getMoviesNotWatchedForDays`                         |
| F   | En film set præcis for det angivne antal dage siden er ikke med i listen. | Ja       | US9, `domainmodel.MovieCollection`                                   |
| R   | Programmet går ikke ned, hvis man skriver bogstaver, hvor der skal stå et tal | Ja       | `UserInterface.readInt`                                              |
| S   | Al talindlæsning går igennem én metode (`readInt`), så en rettelse kun skal laves ét sted | Ja       | `UserInterface.readInt`                                              |
| U   | Skriver man et ugyldigt svar på et Yes/No-spørgsmål, bliver man spurgt igen i stedet for at programmet går ned eller gætter | Ja       | `UserInterface.addMovie`, `UserInterface.deleteMovies`               |
| P   | Filen skrives kun, når der er ændringer                                 | Ja       | US14, `Controller.saveMoviesIfChanged`, `UserInterface.startProgram` |
| F   | Programmet kan ikke oprette eller redigere en film med ugyldige værdier (tom titel/instruktør/genre, år udenfor gyldigt interval, længde under 1 min) – i stedet får jeg en fejlbesked. | Ja       | US11, `Movie` (settere + konstruktør)                                |
| F   | Redigering af en film er alt-eller-intet: hvis en af de nye værdier er ugyldig, bliver ingen af filmens oplysninger ændret. | Ja       | US11, `domainmodel.MovieCollection`                                  |
| F   | Jeg kan ikke markere en film som set med en fremtidig dato.             | Ja       | US12, `Movie.markAsWatched`                                          |
| F   | Når programmet starter, indlæses filmene automatisk fra en fil, hvis den findes. | Ja       | US13, `Controller.loadMovies`, `UserInterface.startProgram`          |
| F   | Givet at jeg afslutter programmet med menuvalg 0, så gemmes samlingen i filen movies.csv. | ja      | US13, `Controller.saveMoviesIdChanged`, `UserInterFace.startProgram`                                                  |
| F   | Givet at programmet startes, og movies.csv findes, så indlæses filmene, og jeg får at vide, hvor mange der blev indlæst.| Ja       | US13,                                                                |
| F   | Alle oplysninger overlever – også æ, ø og å i titlerne, og datoen for, hvornår jeg sidst så filmen.| Ja       | US13,                                                                |
| F   |Givet at filen ikke findes (første gang programmet kører), så starter jeg med en tom samling – programmet går ikke ned.| Ja       | US13,                                                                |
| R   |Givet at filen ikke findes (første gang programmet kører), så starter jeg med en tom samling – programmet går ikke ned.| Ja       | US13,                                                                |
| R   |Givet at en linje i filen er ødelagt, så springes den over, jeg får en advarsel, og resten af filmene indlæses.| Ja       | US13,                                                                |
| P   |Givet at jeg hverken har oprettet, rettet, slettet eller markeret en film som set, når jeg afslutter, så bliver filen ikke skrevet, og jeg får at vide, at der ikke var noget at gemme.| ja      | US14                                                                 |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |
| --- |---| ---      | ---                                                                  |



