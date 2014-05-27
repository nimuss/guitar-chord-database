guitar-chord-database
=====================

Leírás
------
A program egy gitár akkord adatbázist kezel.

- Megmutatja az akkordok lefogási módját.
- Egyenként kiírja a húrokon lefogott hangokat.
- Képes lejátszani mind különálló hangokat, mind teljes akkordokat.
- Interaktív módon képes új akkordokat hozzáadni az adatbázishoz.
- A lejátszásra több beépített gitár típussal is képes.


Első lépés
----------
A config/connection.properties állományban beállítani az adatbázishoz szükséges felhasználónév/jelszó párost.
Ezután kiadni a következő parancsot:
$ mvn process-resources

Fordítás
--------
$ mvn compile

Futtatás
--------
$ mvn exec:java -Dexec.mainClass="akkord_tabla.Main"

Site generálás
--------------
$ mvn site