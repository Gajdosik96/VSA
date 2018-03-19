# 5. Cvičenie
## Obojsmerné asociácie
## Úloha 1:
Úloha 3 z 5. prednášky ilustruje obojstrannú many-to-many asociáciu. Na prednáške sme si ukázali, že po vytvorení nových kníh a autorov stačilo inicializovať asociáciu medzi nimi na jednej strane: Osobe pridať do zoznamu diel knihy, ktorých je autorom (funkcia create). Po následnom načítaní knihy z databázy (funkcia read), už mala aj kniha inicializovaný zoznam svojich autorov, hoci vo funkcii create pôvodne vyplnený nebol. Implementujte aplikáciu (funkcie create a read) z prednášky, tentoraz však vo funkcii create:

- [x] inicializujte zoznam na len druhej strane asociácie, t.j. zoznam autorov v triede kniha.
- [x] inicializujte obe strany asociácie, t.j. zoznam diel v triede osoba aj zoznam autorov v triede kniha. Dajte pozor aby do zoznamu diel pridali naozaj len tie diela, ktorych je daná osoba autorom!
- [x] inicializujte obe strany asociácie. Tentoraz však urobte pri vypĺňaní zoznamov úmyslene chybu: Do zoznamu autorov knihy dajte osobu, ktorá nie je jej autorom. Príp. naopak do zoznamu diel osoby dajte knihu, ktorej táto osoba nie je autorom.
Vo všetkých prípadoch si overte výsledok, jednak v DB a jednak opätovným načítaním vytvorených kníh/osôb z databázy (napr. pomocou query findAll).

## Úloha 2:
![cv5u2.png](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%205/cv5u2.png)

Pre UML diagram tried znázornených na obrázku:

- [ ] navrhnite a nakreslite si diagram databazových tabuliek, pričom OSOBA a PREDMET budú mať klúčový stĺpec ID (nie je v UML diagrame)
- [x] implementujte entitné triedy, tak aby odpovedali vášmu návrhu DB (klúčové atribúty môžu byť autogenerované) pričom asociácie sú obojsmerné a majú kardinalitu tak ako je to na diagrame.
- [x] implementujte funkciu **create**, ktorá vytvorí dva predmety a troch osoby, pričom

  - Prvá osoba bude prednášať 1. predmet,
  - Druhá osoba bude prednášať aj cvičiť 2. predmet
  - Tretia osoba bude cvičiť 1. aj 2. predmet
- [x] implementujte funkciu void **read(String meno)**, ktorá dostane meno učiteľa, nájde všetky predmety, ktoré učiteľ cvičí a na obrazovku vypíše ich názvov a meno prednášajúceho.

- [x] implementujte funkciu void **release(Osoba o)**, ktorá dostane ako parameter osobu, zistí či taká osoba je v DB, ak áno odstráni ju, pričom odstráni aj všetky odkazy na ňu, t.j. nesmie ostať už ani prednášajúcim ani cvičiacim, žiadneho predmetu.

## Kompozícia
## Úloha 3:
![kompozicia-uml.png](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%205/kompozicia-uml.png)

Implemntujte entitnú triedu **Dokument** ako kompozíciu podľa UML diagramu tried:

- [x] Dokument okrem názvu a vlastného textu môže obsahovať podkapitoly
- [x] Podkapitola je tiež dokument a môže teda obsahovať daľšie vlastné podkapitoly.
- [x] Z dokumentu je možné navigovať (má referencie) na jeho podkapitoly, tak ako znázorňuje asociácia na diagrame.
- [x] Asociácia podkapitoly je kompozícia, je teda potrebné zabezpečiť, že pri odstánení odkazu na podkapitolu z dokumentu bude podkapitola úplne odstránená z databázy spolu s jej všetkými podkapitolami. (JPA poskytuje na implementáciu tejto funkcionality vhodné argumenty anotácií, použite ich)

Pre otestovanie funkcionality implementujte program, ktorý:

- [x] Vytvorí dokument, pridá mu niekoľko podkapitol.
- [x] Prvej podkapitole pridá daľšie podkapitoly (na druhej úrovni).
- [x] všetky vytvorené objekty uloží do datbázy (naraz, v rámci jednej transakcie)
- [x] nasledne načíta dokument opäť z databázy, odstráni z neho prvú kapitolu a aktualizuje stav v databáze.
## Úloha 4:
Modifikujte a otestujte triedu Dokument z Úlohy 1. tak, že asociácia podkapitoly bude obojsmerná, t.j. okrem referencií na vlastné podkapitoly, bude mať dokument aj opačnú referenciu na dokument, v ktorom sa nachádza.
