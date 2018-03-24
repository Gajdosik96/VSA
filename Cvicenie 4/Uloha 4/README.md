# Úloha 4.
![ER Diagram](https://github.com/xchovanecv1/VSA/blob/master/Cvicenie%204/ERdiagram.png?raw=true)

Na obrázku je ER diagram zobrazujúci riešenie teoretickej úlohy z 2.cvičenia.

- [x] Navrhnite entitné triedy odpovedajúce tomuto ER diagramu. (t.j. JPA by z entitných tried mal automaticky vygenerovať tabuľky tak ako sú zobrazené na diagrame)

  * pri návrhu asociácií zoberte do úvahy, akým spôsobom budete chcieť navigovať medzi objektami entitných tried.
  * Odporučenie: načrtnite si najprv UML diagram tried
- [x] Implementujte funkciu, ktorá dostane ako argument objekt triedy Autor a vráti zoznam všetkých obchodov (objektov triedy Obchod), ktoré ponúkajú knihu od daného autora (t.j. je jedným z jej autorov). Funkcia predpokladá, že všetky údaje o obchodoch knihách a autoroch sú už v pamäti a teda, nepristupuje do databázy.
- [x] Implementujte funkciu, ktorá načíta údaje o obchodoch, knihách a ich autoroch z databázy.
- [x] Implementujte program, ktorý otestuje funkčnosť oboch funkcií.
- [x] Pre naplnenie databázy testovacími údajmi implementujte program, ktorý importuje do DB dáta zo súboru [data3.csv](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%204/data3.csv)