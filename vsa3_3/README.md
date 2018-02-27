# Swing DB aplikácia

V súboroch [Cv3swingapp.java](https://github.com/xchovanecv1/VSA/blob/master/vsa3_3/Cv3swingapp.java) a [Person.java](https://github.com/xchovanecv1/VSA/blob/master/vsa3_3/Person.java) nájdete zdrojový kód java-swing-aplikácie, ktorá umožňuje editovať zoznam osôb. 
Údaje zadané užívateľom sú uchovávané v len pamäti, po ukončení aplikácie sú stratené

## Úlohy
- [ ] Vytvorte projekt cv3swingapp a stiahite si do neho zdrojové kódy, skompilujte a spustite aplikáciu. Oboznámte sa s jej funkcionalitou a zdrojovým kódom.
- [ ] Rozšírte aplikáciu tak aby s využitím JPA pri spustení načítala údaje o osobách z databázy a zmeny, ktoré urobí užívateľ v databáze uchovávala:
- [ ] Všetky zmeny sa do databázy zapíšu až po stlačení SAVE (t.j. zmeny osobných údajov aj zmeny v zozname osôb - pridanie/odstránenie osoby)
- [ ] Po stlačení RESET sa obnoví pôvodny stav z databázy (nepotvrdené zmeny v pamäti sa zahodia)

- [ ] Realizujte alternatívnu implementáciu, ktorá bude ukladať všetky zmeny ihneď, t.j.
- [ ] Aktualizácia údaju o osobe je zapísaná do DB okamžite po zmene hodnoty v tabulke. (Pozor! pre ukončenie editácie textového poľa je potrebné prekliknúť do iného poľa tabulky)
- [ ] Aktualizácia zoznamu osôb vykonaná v DB už pri stlačení ADD resp. DELETE.
- [ ] Tlačidlá SAVE a RESET nebudú potrebné (disabled)
