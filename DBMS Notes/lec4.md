# Aggregation

ER Model me **Aggregation** ek abstraction concept hai jo ek fundamental limitation ko solve karta hai.

## 1. Aggregation Ki Zaroorat Kyu Padi? (The Core Limitation)

Standard ER Modeling ka ek strict rule hai: **Ek relationship kisi dusri relationship se directly connect nahi ho sakti.** Relationships sirf **Entities** ke beech banti hain.

Lekin real-world business logic me kai baar aisa scenario aata hai jahan hume ek **poore relationship pair ko kisi teesri entity ke sath associate karna padta hai**. Wahan standard ER diagram fail ho jata hai.

---

## 2. Aggregation Kya Hai?

**Aggregation** ek aisa mechanism hai jisme hum ek existing relationship (aur usme connected entities) ko ek box me wrap karte hain aur us poore block ko ek **Single Higher-Level Entity (Virtual Entity)** ki tarah treat karte hain.

Isse hum us "aggregated block" ka relation kisi aur naye entity ke sath bana sakte hain bina ER rules todhe.

---

## Example 1: Employee, Project, aur Machinery (Classic Industrial Case)

### Scenario:

1. Ek company me `Employee` kisi `Project` par kaam karta hai (Relationship: `Works_On`).
2. Is specific assignment ke liye employee ko koi `Machinery` (tool/laptop/sensor) issue ki jati hai.

### Bina Aggregation ke Problem (Why Normal ER Fails):

* Agar tum `Machinery` ko directly `Employee` se connect karoge, to iska matlab hoga ki machinery hamesha ke liye employee ke paas hai (jabki wo sirf ek specific project ke liye mili hai).
* Agar tum `Machinery` ko directly `Project` se connect karoge, to pata nahi chalega ki project me kis exact employee ko wo machine issue hui hai.
* Hum `Machinery` ko directly `Works_On` relationship se connect **nahi kar sakte** (rule violation).

### Aggregation Solution:

Hum `[Employee <-- Works_On --> Project]` ko ek bade box me band karte hain. Ab ye box ek **Aggregated Entity** ban gaya. Ab hum is poore box ko `Machinery` entity ke sath ek nayi relationship **`Uses`** ke through connect karte hain.

* **Meaning:** "A specific Employee working on a specific Project uses a specific Machinery."

---

## Example 2: Doctor, Patient, aur Medicine (Healthcare System)

### Scenario:

1. `Doctor` ek `Patient` ka checkup karta hai (Relationship: `Diagnoses`).
2. Us specific diagnosis session ke badle koi `Medicine` prescribe ki jati hai.

### Aggregation Design:

* Hum `Doctor` aur `Patient` ke beech ke `Diagnoses` relation ko aggregate karte hain.
* Is aggregated entity ko hum `Medicine` entity ke sath **`Prescribes`** relationship se जोड़ते hain.
* **Why?** Kyunki dawai na to akele Doctor ki definition me aati hai, na akele Patient ki. Dawai tab exist karti hai jab *wo specific doctor us specific patient ka diagnosis karta hai*.

---

## Relational Database (SQL Tables) Me Ye Kaise Map Hota Hai?

ER diagram me Aggregation ek conceptual structure hai. When you convert it into production database tables, koi special SQL keyword nahi hota. Ye simply **Composite Foreign Keys** ke through implement hota hai.

Example 1 (Employee-Project-Machinery) ka table breakdown:

1. **`Employee` Table:** `Emp_ID` (PK), `Name`
2. **`Project` Table:** `Proj_ID` (PK), `Title`
3. **`Machinery` Table:** `Machine_ID` (PK), `Type`
4. **`Works_On` Table (Base Relationship):**
* PK / FK: `(Emp_ID, Proj_ID)`
* Ye dono milkar is table ka Composite Primary Key banate hain.


5. **`Uses` Table (Aggregated Relationship):**
* Yahan par inner relationship ka Composite Key as a Foreign Key aata hai, aur teesri entity ka PK uske sath judta hai.
* Columns: `Emp_ID` (FK), `Proj_ID` (FK), `Machine_ID` (FK)
* PK of this table: **`(Emp_ID, Proj_ID, Machine_ID)`**



---

## Takeaway Summary

* **Ternary Relationship vs Aggregation:** Agar teeno entities (`Employee`, `Project`, `Machinery`) ek hi exact instant par teeno taraf se equal weight carry karti hain, to Ternary relationship use hoti hai. Lekin agar ek relationship pehle banti hai (`Works_On`) aur teesra element (`Machinery`) us **completed pair** par depend karta hai, tab strictly **Aggregation** use hota hai.
* Aggregation is basically **"Abstraction of a relationship into an entity"** so that it can participate in other relationships.