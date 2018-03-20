# Fetch Type
## Asociácia 1:1
## Úloha 1
Na prednáške sme ilustrovali @OneToOne asociáciu, na príkladoch, v ktorých sme databázové tabulky genrovali z entitných tried. Teraz na cvičení vyskúšajte opačný postup - generovanie entitných tried z databázy:
- Vytvorte v DB tabulku **OSOBA** so stĺpcami
  **ID (PK), MENO, PRIEZVISKO**
- a vložte do nej dva záznamy s ID 1, 2 a rôznymi menami
- Vytvorte v DB tabulku **KONTAKT** so stĺpcami
  **ID (PK), MAIL, TEL**
-a vložte do nej dva záznamy s ID 1, 5 a rôznymi mailami
- Vyvtorte nový projekt a (príp. nechajte vygenerovať) entitné triedy pre tieto tabulky.
- Do triedy Osoba, pridajte referenciu **kontaktneUdaje** na objekt triedy **Kontakt** s anotáciami *@OneToOne* a *@PrimaryKeyJoinColumn*

- Implementujte program ktorý načíta z DB všetky osoby, Presvedčte sa či sú aj kontaktné údaje správne načítané.
## Úloha 2
- V projekte z predchádzajúcej úlohy upravte entitné triedy tak,že asociácia medzi osobou a jej kontaktami bude obojsmerná.
- Implementujte program ktorý načíta z DB všetky kontakty, Presvedčte sa či sú správne načítané aj ostatné osobne údaje (meno priezvisko).
## Úloha 3
1. Implementujte entitné triedy pre spojový zoznam obsahujúci dátové členy typu mydData ako je znazornené na UML diagrame tried:

![cv6u1a.png](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%206/cv6u1a.png)

1. Implementujte a otestujte metódu triedy Item **void addData(Mydata d)**, ktorá pridá novú položku s dátami hneď za túto (this).
1. Implementujte a otestujte metódu triedy Item void **appendData(Mydata d)**, ktorá pridá novú položku s dátami až na koniec spojového zoznamu.
1. Reimplementujte úlohy a. b. , pričom bude teraz zoznam obojsmerne zreťazený, tak ako je znazornené na UML diagrame tried.

![cv6u1b.png](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%206/cv6u1b.png)

1. Implementujte a otestujte metódu triedy Item void remove(Mydata d), ktorá odstáni položku s dátami z obojstranne zretazeného zoznamu v ktorom sa nachádza. Pozor. po commite transakcie sa v databáze nesmie nachýdzať ani odstánená položka ani jej dáta.
## Mapovanie jednej triedy do viacerých tabuliek
## Úloha 4
Modifikujte úlohu 1, tak že tabulky OSOBA a KONTAKT namapujete do jednej entitnej triedy (obsahujúcej všetky atribúty)

## Zložené kľúče
## Úloha 5
- Organizácia eviduje v databáze údaje o svojich zanestnancoch ako meno, pracovné zadalenie, plat... Prirodzene viaceré z týchto údajov sa môžu časom meniť. Aby bolo možné zistiť nielen aktuálny stav (napr. plat) ale aj stav kedykoľvek v minulosti, sú údaje uložené v tzv. historizovanej tabulke:
- **ZAMESTNANEC:** Klúč pozostáva z dvoch stĺpcov
  - **ID** - LONG identifikáčné číslo zamestnanca
  - **OD** - TIMESTAMP od kedy platia udaje.

- Ďalej tabuľka obsahuje údaje
  - **MENO**
  - **ZARADENIE**
  - **PLAT**

- Implementujte entitnú triedu pre historizovanú tabuľku ZAMESTNANEC. (Pre implementáciu entitnej triedy so zloženým kľúčom pozri prednášku 6. prednášku
- Implementujte a otestujte CRUD funkcie pre prácu s informáciami o zamestnancoch
  - vyhladatZamestnanca(long id) vráti aktuálne údaje o zamestnancovi
  - vyhladatZamestnanca(long id, Date d) vráti údaje o zamestnancovi platné, k danému dátumu
  - prijatZamestnanca(long id, String meno) vytvorí nového zamestnanca
  - aktualizovatZamestnanca(Zamestnanec z) aktualizuje údaje o zamestnancovi
  - prepustitZamestnanca(Zamestnanec z) prepusti zamestnanca
**Dôležité:** V historizovanej tabuľke sa nikdy záznamy nevymazávajú ani nemodifikujú, len vkladajú. To značí, že:
- Funkcia **aktualizovatZamestnanca** musí namieto UPDATE volať INSERT, ktorý pridá nový záznam s aktualizovanými údajmi do tabuľky ZAMESTNANEC. Kľúčový stĺpec OD bude obsahovať timestamp okamihu, keď nastáva zmena (použite new Date())
- Funkciu **prepustitZamestnanca** môžeme implementovať ako špeciálny prípad aktualizovatZamestnanca, pričom hodnoty zo stĺpcov MENO, PLAT a ZARADENIE vymažeme.
