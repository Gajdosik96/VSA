# Úloha 2.
Pre každý zo 4 príkladov

* vytvorte projekt a v ňom entitné triedy podľa popisu z prednášky.
* implementujte program, ktorý vytvorí aspoň jeden objekt hlavnej entitnej triedy a v prípade viacnasobných asociácií pridá aspoň dva asociované objekty. Následne ich pomocou entity managera (alebo JPA kontrolera) uloží do databázy.
* Spustite a otestujte program, databázové tabuľky pritom nechajte vygenerovať s použitím table-generation-strategy drop-and-create. * Pozrite si vygenerované tabuľky a overte si správnosť vášho ER diagramu.

* Vyskúšajte opačný postup: generovannie entít a asociácií z DB
  * vytvorte nový projekt
  * pomocou netbeans wizardu **Generate Entity Classes from Database** vygenerujte entitné triedy z tabuliek vytvorených v predchádzajúcom bode

  * porovnajte vygenerovaný zdrojový kód s pôvodnými entitnými triedami. Vidíte tam nejaké podstatné rozdiely alebo problémy?
Pozn: mali/mohli ste sa presvedčiť, že pri komplexnejších ER modelkoch nie je generovanie entitných tried z DB vždy najvhodnejšie
