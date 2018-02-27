# Metódy entity managera
V nasledujúcich úlohách pracujeme naďalej s tabuľkou OSOBA. Pred každou úlohou odstáňte z tabuľky všetky záznamy

Vyvtorte nový projekt a vygenerujte entitnú triedu pre tabuľku OSOBA. Potom v hlavnom programe:

## Opakované volanie persist
- [x] Začnite transakciu
- [x] Vytvorte inštanciu triedy Osoba - zadajte jej meno. Pozn. id nie je potrebné zadávať, prečo?
- [x] Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké jej meno.
- [x] pre obe inštancie zavolajte em.persist
- [x] ukončite transakciu
### Otázka: Koľko záznamov bude vytvorených v databáze? Spustite program a overte si to.

```java       
        em.getTransaction().begin();
        Osoba os = new Osoba();
        os.setMeno("Anton");
        
        Osoba oss = new Osoba();
        oss.setMeno("Anton");
        
        em.persist(os);
        em.persist(oss);
        
        em.getTransaction().commit();
 ```
**Je potrebné definovať @GeneratedValue(strategy = GenerationType.AUTO) v Osoba Entity triede pri ID**

## Opakované volanie persist - bez autogenerovaného klúča

Z entitnej triedy Osoba odstráňte anotáciu @GeneratedValue. Osoba musí mať teraz zadanú aj hodnotu klúča id.

- [x] Vytvorte inštanciu triedy Osoba - zadajte id, meno a váhu
- [x] Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišné meno
pre obe inštancie zavolajte em.persist

- [x] ukončite transakciu
```java
        em.getTransaction().begin();
        
        Osoba os = new Osoba(1L);
        os.setMeno("Peter");
        os.setVaha(55.5);
        os.setVyska(175.5);
        
        Osoba oss = new Osoba(1L);
        oss.setMeno("Andrej");
        oss.setVaha(55.5);
        oss.setVyska(175.5);
        
        em.persist(os);
        em.persist(oss);
        
        em.getTransaction().commit();
 ```
 
 
### Otázka: čo spraví program po spustení? Spustite program a overte si to.
`
Výnimka neunikátnych identifikačných kľúčov
`

`
The statement was aborted because it would have caused a duplicate key value in a unique or primary key constraint or unique index identified by 'SQL180227084438850' defined on 'OSOBA'
`
## persit a merge

- [x] Vytvorte inštanciu triedy Osoba - zadajte id, meno a váhu
- [x] Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišné meno alebo váhu
pre prvú inštanciu zavolajte em.persist

- [x] pre druhú inštanciu zavolajte em.merge

- [x] ukončite transakciu
### Otázka: čo spraví program po spustení? Spustite program a overte si to v DB.

## clear

- [x] Vytvorte inštanciu triedy Osoba - zadajte id a meno
- [x] Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišné meno
- [x] pre prvú inštanciu zavolajte em.persist

- [x] zavolajte em.clear

- [x] pre druhú inštanciu zavolajte em.persist

- [x] ukončite transakciu
### Otázka: čo spraví program po spustení? Spustite program a overte si to v DB.

## detach

- [x] Vytvorte inštanciu triedy Osoba - zadajte id a meno
- [x] Vytvorte druhú inštanciu triedy Osoba - zadajte rovnaké id ale odlišný meno
- [x] pre obe inštancie zavolajte em.persist
- [x] pre druhú inštanciu zavolajte em.detach
- [x] ukončite transakciu
### Otázka: čo spraví program po spustení? Spustite program a overte si to v DB.

**Poznámka: V nasledujúcich úlohách vyhľadávame v tabuľke OSOBA. Presvedčte sa či v nej máte nejaký záznam-osobu a zapamätajte si jej ID. (Ak je tabulka prázdna, pridajte do nej nejaké záznamy) V projekte nastavte table generation strategy na none**

## Opakované volanie find

- [x] pomocou em.find načítajte z DB inštanciu osoby podľa zadaného klúča.

- [x] zopakujte volanie em.find s tým istým klúčom.

- [x] Overte si či tieto dve volania vrátili ten istý objekt alebo dva rôzne objekty. (Porovnávajte referencie nie klúče)

## find a detach

- [x] pomocou em.find načítajte z DB inštanciu osoby podľa zadaného klúča.

- [x] zavolajte em.detach na načítanú inšanciu osoby.

- [x] zopakujte volanie em.find s tým istým klúčom.

- [x] Overte si či tieto dve volania vrátili ten istý objekt alebo dva rôzne objekty.
