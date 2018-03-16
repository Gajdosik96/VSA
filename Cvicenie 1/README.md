# 1. cvičenie - Práca s prostredím NetBeans
Prvý projekt - len študenti, ktorí ešte vôbec nepracovali s prostredím Netbeans

- Vytvorte a otestujte HelloWorld Java Application

## 1. Práca s databázou v prostredí Netbeans
1. Otvorenie databázy, prezeranie tabuliek ich štruktury a obsahu:
  - Otvoriť databázu v záložke: **services\databases\jdbc:derby..sample\connect** zadať **user:app** **heslo:app**
      (Pozn. automaticky aj spustí server derby databázy)
  - pozrite si štruktúru tabuľky CUSTOMER
  - zobrazte jej obsah (view data)
  - pomocou **Execute Command** vykonajte SQL-SELECT, ktorý vráti meno a mesto (NAME a CITY) všetkých zákazníkov z tabuľky CUSTOMER

 1. Vytvorenie a naplnenie novej tabuľky
  - Pomocou dialogu tables\create table vytvorte novú tabuľku KNIHA so stĺpcami:
    - **nazov** VARCHAR(40) - klúč
    - **autor** VARCHAR(80)
    - **cena** DOUBLE
  - zobrazte jej obsah (view data) a zadajte nejaké záznamy, priamo v zobrazenom dialógu
  - modifikujte jej obsah pomocou dialógu **Execute Command**:
    - odstránťe knihu s určitým menom z DB
    - znížte cenu všetkých kníh o 20%
## 2. Implementácia JDBC aplikácie, ktorá číta a zobrazuje
[JDBC Guide](https://www.tutorialspoint.com/jdbc/jdbc-quick-guide.htm)

Vytvoriť nový java-app projekt a v ňom:
1. Implementovať pomocou JDBC connect na DB
```java
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement st = con.createStatement();
```
 - meno triedy drivera, url-db user aj heslo si zistite záložke properties príslušnej DB (services\databases\jdbc:derby..sample\properties)
 - build
 - pridať do lib jdbc derby driver
 - spustiť a otestovať, či sa aplikácia konektovala na DB
 1. Implmentovať **select ***, otestovať
```java
ResultSet rs = st.executeQuery("SELECT * FROM kniha");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
 ```
 1. Implmentovať select count, otestovať
```java
ResultSet rs = st.executeQuery("SELECT count(*) FROM kniha");
        while (rs.next()) {
            System.out.println("" + rs.getInt(1));
        }
```
## 3. Implementácia JDBC aplikácie, ktorá modifikuje údaje v DB
Vytvoriť nový java-app projekt a v ňom implementovať a otestovať nasledujúce metódy:

 1. **double cenaKnihy(String meno)**, ktorá nájde v DB knihu so zadaným menom a vráti jej cenu. Ak neexistuje taká kniha vráti -1 a vypíše spávu "Knihu nemáme"
 1. **boolean pridajKnihu(String meno, double cena)**, ktorá pridá do DB knihu s daným menom a cenou. Ak kniha s daným menom v DB už existuje, vráti false.
 1. **void zlava(String meno)** ktorá nájde v DB knihu so zadaným menom a zníži jej cenu o o 20% (v databáze). Ak neexistuje taká kniha neurobí nič.

**Pozn.** Pre vykonanie SQL príkazov INSERT a UPDATE treba namiesto executeQuery volať metódu executeUpdate.
