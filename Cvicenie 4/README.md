# 4. cvičenie

Na poslednej prenáške sme prebrali 4 príklady, ilustrujúce rôzne situácie, ktoré môžu nastať pri mapovaní asociacií. Ich stručný popis aj s ukážkami zdrojového kódu entitných tried nájdete na stránke prednášky P4 . Pozn. Ukážky zdrojových kódov zobrazujú len deklarácie najdôležitejších dátových členov. Zvyšok kódu (gettre, settre...) si môžete dopniť manuálne alebo nechať vygenerovať.

## Úloha 1.
Pre každý zo 4 príkladov si načrtnite **ER diagram** s databázovými tabuľkami pre dané entitné triedy, t.j tak ako ich vygeneruje JPA ak použijeme Table generation strategy **drop-and-create**. V diagrame uveďte **názvy tabuliek**, **názvy stpĺcov**, vyznačte **primárne a cudzie klúče**.

**Pozn.** Komentáre aj zakomentovaný zdrojový kód (anotácie) ignorujte.

## Úloha 2.
Pre každý zo 4 príkladov

* vytvorte projekt a v ňom entitné triedy podľa popisu z prednášky.
* implementujte program, ktorý vytvorí aspoň jeden objekt hlavnej entitnej triedy a v prípade viacnasobných asociácií pridá aspoň dva asociované objekty. Následne ich pomocou entity managera (alebo JPA kontrolera) uloží do databázy.
* Spustite a otestujte program, databázové tabuľky pritom nechajte vygenerovať s použitím table-generation-strategy drop-and-create. * Pozrite si vygenerované tabuľky a overte si správnosť vášho ER diagramu.

* Vyskúšajte opačný postup: generovannie entít a asociácií z DB
  * vytvorte nový projekt
  * pomocou netbeans wizardu **Generate Entity Classes from Database** vygenerujte entitné triedy z tabuliek vytvorených v predchádzajúcom bode

  * porovnajte vygenerovaný zdrojový kód s pôvodnými entitnými triedami. Vidíte tam nejaké podstatné rozdiely alebo problémy?
Pozn: mali/mohli ste sa presvedčiť, že pri komplexnejších ER modelkoch nie je generovanie entitných tried z DB vždy najvhodnejšie

## Úloha 3.
Zopakujte Úlohu 2, pričom však

* v zdrojových kódoch entít prevzatých zo stránky prednášky najprv odkomnetujete/zfunkčnite zakomentované anotácie.
* ak treba, upravte implementáciu programu z úlohy 2.
* spustite program a overte či správne rozumiete funkcionalite pridaných anotácií.
**ozn.** *niektoré anotácie by mali ovplyvniť štruktúru vygenerovaných tabuliek, niektoré zasa spôsob použitia entitných tried a entity managera*

## Úloha 4.
![ER Diagram](https://github.com/xchovanecv1/VSA/blob/master/Cvicenie%204/ERdiagram.png?raw=true)

Na obrázku je ER diagram zobrazujúci riešenie teoretickej úlohy z 2.cvičenia.

* Navrhnite entitné triedy odpovedajúce tomuto ER diagramu. (t.j. JPA by z entitných tried mal automaticky vygenerovať tabuľky tak ako sú zobrazené na diagrame)

  * pri návrhu asociácií zoberte do úvahy, akým spôsobom budete chcieť navigovať medzi objektami entitných tried.
  * Odporučenie: načrtnite si najprv UML diagram tried
* Implementujte funkciu, ktorá dostane ako argument objekt triedy Autor a vráti zoznam všetkých obchodov (objektov triedy Obchod), ktoré ponúkajú knihu od daného autora (t.j. je jedným z jej autorov). Funkcia predpokladá, že všetky údaje o obchodoch knihách a autoroch sú už v pamäti a teda, nepristupuje do databázy.

* Implementujte funkciu, ktorá načíta údaje o obchodoch, knihách a ich autoroch z databázy.
* Implementujte program, ktorý otestuje funkčnosť oboch funkcií.
* Pre naplnenie databázy testovacími údajmi implementujte program, ktorý importuje do DB dáta zo súboru [data3.csv](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%204/data3.csv)
