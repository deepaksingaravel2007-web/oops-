# OOPS Lab Experiments

This repository contains Java programs for Object-Oriented Programming lab experiments.

## Experiments

| Ex.No | File / Folder | Description |
|-------|---------------|-------------|
| 1 | `Ex1_ElectricityBill.java` | Electricity Bill calculation (Domestic / Commercial) |
| 2 | `Ex2_Packages/` | Packages – Currency, Distance & Time converters |
| 3 | `Ex3_Inheritance_Vehicle.java` | Inheritance – Vehicle, Car, Bike, Truck with billing |
| 4 | `Ex4_AbstractClass_LibraryMember.java` | Abstract class – LibraryMember (Student / Faculty / External) |
| 5 | `Ex5_CircularQueue_ExceptionHandling.java` | ADT Circular Queue with Exception Handling |
| 6 | `Ex6_WrapperImmutableDemo.java` | Immutable nature of Wrapper classes (Integer & Double) |
| 7 | `Ex7_MultiThreadSort.java` | Multi-threading – Generate, Ascending & Descending sort |
| 8 | `Ex8_InterThread_RailwayBooking.java` | Inter-thread communication – Railway ticket booking |
| 9 | `Ex9_StringOperations_ArrayList.java` | String operations using ArrayList |
| 10 | `Ex10_FileHandling_ListFiles.java` | File Handling – List files in a directory |
| 11 | `Ex11_StudentManagementApp_JavaFX_JDBC.java` | CRUD Application using JavaFX + JDBC (MySQL) |

## How to run Ex2 (Packages)

```bash
cd Ex2_Packages
javac currency/CurrencyConverter.java distance/DistanceConverter.java time/TimeConverter.java Main.java
java Main
```

## Notes for Ex 11

Requires:
- MySQL database `studentdb` with table `students`
- MySQL Connector/J
- JavaFX SDK
- Update username/password in `connectToDatabase()` if needed

```sql
CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  age INT NOT NULL,
  course VARCHAR(100) NOT NULL
);
```
