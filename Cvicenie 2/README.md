Cvičenie 2
Úloha1. Vytvorenie DB tabulky z entitnej triedy. (precvičenie učiva z prednášky)
vytvorte nový projekt
Vytvoriť entitnú triedu Osoba pomocou nb.new.other.Persistance.Entity Class

pozrite si vygenerovaný zdrojový kód triedy Osoba. Všimnite si, že trieda má zatial jedinú property id, ktorá bude primárnym autogenerovaným klúčom odpovedajúcej DB tabulky.

pridajte do triedy nasledujúce property:
meno :String
narodena :Date
vyska :float
vaha :Float
Vytvoriť program, ktorý vytvorí inštancie niekoľkých osôb a pomocou entity managera ich vloží do databázy
najmenej jedna osoba má zadané všetky údaje
najmenej jedna osoba nemá zadaný údaj o váhe a narodení
jedna osoba nemá inicializovaný žiadny údaj
nastaviť table generation strategy na: create

spustiť program, skontrolovať v databáze vytvorenú tabulku (názvy a typy stĺpcov, obsah)
spustiť program znovu. (mal by zbehnúťt bez problemov, prečo nevyhlásila DB unique key constranit? Pridal osoby znovu ale s novým autogenerovaným klúčom)
zmeniť table generation strategy na: drop-and-create
program môžeme teraz spušťať opakovane bez problémov, zakaždým inicializuje DB, obsah DB by mal byť po každom spustení rovnaký (užitočné pre unit-testy)
Úloha2. Vytvorenie entitnej triedy z databázovej tabulky.
vytvorte nový projekt
z tabulky Osoba vytvorte entitnú triedu pomocou nb.new.other.Persistance.Entity class from databaze

pozrite si vygenerovaný kód a všimnite si v ňom najmä anotácie: @Table, @Column, @NamedQuery

implementujte metódu, ktorá
pomocou find (metoda entity managera) zisti či v DB existuje osoba z daným klúčom.

Ak existuje vypíše o nej všetky údaje
otestujte si jej správanie v oboch situáciách
Úloha3. Namapovanie existujúcej entitnej triedy na existujúcu databazovú tabulku.
vytvorte nový projekt
vytvorte entitnú triedu Person pomocou nb.new.other.Persistance.Entity class a pridajte property

name :String
born :Date
height :float
weight :float - vyskúšajte vynechať
pomocou parametrov anotacií @Table a @Column namapujete triedu Person na tabulku OSOBA.

implementujete a otestujte program, ktorý vyselektuje všetky osoby z DB a vypíše ich údaje. (reimplementácia 2. metódy z 2 úlohy)
pridajte do triedy Person dalšiu property age: int Spustite program znovu (mal by hlásiť chybu)

pred deklaráciu property age pridajte anotáciu @Transient a spustite program znovu (mal by opäť bežať bez chýb)

Úloha4.
Vytvorte nový java application projekt uloha4 a v ňom program, ktorý prečíta údaje o publikáciách z csv-súboru data1.csv a vloží ich do tabulky KNIHA so stĺpcami:

nazov VARCHAR(40) - klúč

autor VARCHAR(80)

pocet INTEGER

Tabuľku môžete vytvoriť manuálne a z nej vygenerovať odpovedajúcu entitnú triedu alebo naopak implementovať najprv entitnú triedu a z nej nechať vygenerovať tabuľku.

Pri importe údajov z csv-súboru použite ako
názov údaje z 1. stĺpca vstupného súboru,
autor údaje 2. a
pocet údaje z 3. stĺca.
Keďže nazov je klúč, nesmie byť prázdny a musí byť jedinečný. Kontrolu toho, či sa v 1. stĺpci vstupného súboru nenachádzajú duplicity urobí program ešte pred tým než záznam vloží do databázy. Návod: pre kontrolu duplicít použite kontainer java.util.set.

Pred vložením textových údajov odstráňte z reťazcov prázdne znaky pred a za. Prázdne reťazce do databázy nevkladajte.
Pomôcka pre čítanie a parsovanie súboru:
```java
        String line;
        BufferedReader br = new BufferedReader(new FileReader("/home/igor/Downloads/data1.csv"));
        while ((line = br.readLine()) != null) {

            String s[] = line.split(";");
            if (s.length < 3) {
                System.out.println("kratky riadok");
                return;
            }
            String  nazov = s[0].trim();
```