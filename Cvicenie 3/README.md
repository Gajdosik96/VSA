# 3. Cvičenie
## Named query
V nasledujúcom projekte budeme pracovať s tabuľku Osoba vytvorenou 2. cvičení. Tabuľka by mala obsahovať stĺpce

- ID, klúč (autogenerovaný)
- MENO
- VAHA
- prípadne ďalšie

Presvedčte sa či je tabuľka naplnená vhodnými údajmi. Ak treba vytvorte ju nanovo a naplňte údajmi manuálne.

- vytvorte nový projekt
- z tabulky Osoba vygenerujte entitnú triedu pomocou nb.new.other.Persistance.Entity class from databaz
- pozrite si vygenerovaný kód a všimnite si v ňom anotácie: @NamedQuery
- implementujte a otestujete metódu, ktorá pomocou namedQuery findAll vyselektuje všetky osoby z DB. Návod:
```java
   TypedQuery<Osoba> all = em.createNamedQuery("Osoba.findAll", Osoba.class);
   for (Osoba o: all.getResultList()) {
      ...
   }
 ```
- implementujte a otestujete metódu, ktorá pomocou namedQuery **findByMeno** vyhladá osobu podla mena. **Návod** pre zadanie pamametra pre namedQuery:

```java
   TypedQuery<Osoba> q = em.createNamedQuery("Osoba.findByMeno", Osoba.class);
   q.setParameter("meno", hladaneMeno);
   ...
```
- implementujte a otestujete metódu, ktorá pomocou namedQuery všetky osoby z DB ktoré nemajú zadanú váhu, nastaví ich váhu na 80.0 a aktualizuje DB. **Návod**: Pridajte do triedy Osoba definíciu novej namedQuery alebo modifikujte niektorú z existujúcich.

## Metódy entity managera

V nasledujúcich úlohách pracujeme naďalej s tabuľkou OSOBA. Pred každou úlohou odstáňte z tabuľky všetky záznamy

Vyvtorte nový projekt a vygenerujte entitnú triedu pre tabuľku OSOBA. Potom v hlavnom programe:

### Opakované volanie persist
- Začnite transakciu
- Vytvorte inštanciu triedy Osoba - zadajte jej meno. Pozn. id nie je potrebné zadávať, prečo?
- Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké jej meno.
- pre obe inštancie zavolajte **em.persist**

- ukončite transakciu
**Otázka**: Koľko záznamov bude vytvorených v databáze? Spustite program a overte si to.

### Opakované volanie persist - bez autogenerovaného klúča
- Z entitnej triedy Osoba odstráňte anotáciu @GeneratedValue. Osoba musí mať teraz zadanú aj hodnotu klúča id.
- Vytvorte inštanciu triedy Osoba - zadajte id, meno a váhu
- Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišné meno
- pre obe inštancie zavolajte em.persist
- ukončite transakciu
- **Otázka**: čo spraví program po spustení? Spustite program a overte si to.

### persit a merge
- Vytvorte inštanciu triedy Osoba - zadajte id, meno a váhu
- Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišné meno alebo váhu
- pre prvú inštanciu zavolajte em.persist
- pre druhú inštanciu zavolajte em.merge
- ukončite transakciu
- **Otázka**: čo spraví program po spustení? Spustite program a overte si to v DB.

### clear
- Vytvorte inštanciu triedy Osoba - zadajte id a meno
- Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišné meno
- pre prvú inštanciu zavolajte em.persist
- zavolajte em.clear
- pre druhú inštanciu zavolajte em.persist
- ukončite transakciu
- **Otázka:** čo spraví program po spustení? Spustite program a overte si to v DB.

### detach
- Vytvorte inštanciu triedy Osoba - zadajte id a meno
- Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišný meno
- pre obe inštancie zavolajte em.persist
- pre druhú inštanciu zavolajte em.detach
- ukončite transakciu
- **Otázka:** čo spraví program po spustení? Spustite program a overte si to v DB.

**Poznámka:** V nasledujúcich úlohách vyhľadávame v tabuľke OSOBA. Presvedčte sa či v nej máte nejaký záznam-osobu a zapamätajte si jej ID. (Ak je tabulka prázdna, pridajte do nej nejaké záznamy) V projekte nastavte table generation strategy na none

### Opakované volanie find
- pomocou em.find načítajte z DB inštanciu osoby podľa zadaného klúča.
- zopakujte volanie em.find s tým istým klúčom.
- Overte si či tieto dve volania vrátili ten istý objekt alebo dva rôzne objekty. (Porovnávajte referencie nie klúče)

### find a detach
- pomocou em.find načítajte z DB inštanciu osoby podľa zadaného klúča.
- zavolajte em.detach na načítanú inšanciu osoby.
- zopakujte volanie em.find s tým istým klúčom.
- **Overte si** či tieto dve volania vrátili ten istý objekt alebo dva rôzne objekty.

## JPA kontroler
**Pozn.** JPA-kontroler predstavuje nadstavbu nad entity managerom, ktorá ďalej zjednodušuje prácu s databázou.

- pomocou netbeans wizardu **new.other.persitance.JPA Controller Classes from Entity Classes** vytvorte JPA-kontroler (data access object) pre entitu **Osoba**.
- Nasledujúci program ilustruje použitie JPA-kontrolera pre vytvorenie novej osoby v databáze
```java
public static void main(String[] args) throws Exception{
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cv3PU");
        OsobaJpaController dao = new OsobaJpaController(emf);
        
        Osoba p = new Osoba(1L,"Pipi");
        dao.create(p);
    } 
```

- spustite program a overte si jeho funkčnosť. (table generation strategy si nastavte opäť na 'drop and create)
- Modifikujte si program a oboznámte sa funkcionalitou ďalších metód JPA-kontrolera
  - edit
  - destroy
  - find*
  - getOsobaCount
- Pozrite si vygenerovaný kód JPA-kontrolera. Implementácia jeho metód ilustruje správne používanie entity managera.
## Swing DB aplikácia
V prílohách [Cv3swingapp.java](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%203/Cv3swingapp.java) a [Person.java](https://raw.githubusercontent.com/xchovanecv1/VSA/master/Cvicenie%203/Person.java) nájdete zdrojový kód java-swing-aplikácie, ktorá umožňuje editovať zoznam osôb. Údaje zadané užívateľom sú uchovávané v len pamäti, po ukončení aplikácie sú stratené

### Úlohy
- Vytvorte projekt cv3swingapp a stiahite si do neho zdrojové kódy, skompilujte a spustite aplikáciu. Oboznámte sa s jej funkcionalitou a zdrojovým kódom.
- Rozšírte aplikáciu tak aby s využitím JPA pri spustení načítala údaje o osobách z databázy a zmeny, ktoré urobí užívateľ v databáze uchovávala:
  - Všetky zmeny sa do databázy zapíšu až po stlačení **SAVE** (t.j. zmeny osobných údajov aj zmeny v zozname osôb - pridanie/odstránenie osoby)
  - Po stlačení **RESET** sa obnoví pôvodny stav z databázy (nepotvrdené zmeny v pamäti sa zahodia)
- Realizujte alternatívnu implementáciu, ktorá bude ukladať všetky zmeny ihneď, t.j.
  - Aktualizácia údaju o osobe je zapísaná do DB okamžite po zmene hodnoty v tabulke. (Pozor! pre ukončenie editácie textového poľa je potrebné prekliknúť do iného poľa tabulky)
  - Aktualizácia zoznamu osôb vykonaná v DB už pri stlačení ADD resp. DELETE.
  - Tlačidlá SAVE a RESET nebudú potrebné (disabled)
