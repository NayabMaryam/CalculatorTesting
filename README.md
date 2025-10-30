# 🧮 Calculator App – JUnit 5 Test Automation Solution

## 📝 Project Overview

This project implements **automated unit testing** for a simple Java-based calculator application with three main components:

* **CalculatorModel** – Performs all arithmetic operations (add, subtract, multiply, divide).
* **CalculatorPresenter** – Acts as the logic layer that connects the View and Model.
* **CalculatorView** – Displays calculation results and interacts with the user interface.

The purpose of this assignment is to design, implement, and execute automated tests using **JUnit 5**, following **Equivalence Class Partitioning (ECP)** and **Boundary Value Analysis (BVA)**.


## ⚙️ Tools & Technologies

| Tool                  | Purpose                 |
| --------------------- | ----------------------- |
| Java 8                | Programming Language    |
| JUnit 5               | Testing Framework       |
| Maven                 | Build Automation        |
| Eclipse               | IDE                     |
| Apache POI            | Excel File Handling     |
| Maven Surefire Plugin | Parallel Test Execution |
| GitHub                | Version Control         |
| Jira Software         | Bug Reporting           |


## 🚀 Project Setup (Task 1)

1. Clone the repository:

   ```bash
   git clone https://github.com/NayabMaryam/CalculatorTestAutomation.git
   ```
2. Open the project in **Eclipse**.
3. Ensure Maven dependencies for JUnit 5 are added in `pom.xml`:

   ```xml
   <dependency>
       <groupId>org.junit.jupiter</groupId>
       <artifactId>junit-jupiter</artifactId>
       <version>5.10.0</version>
       <scope>test</scope>
   </dependency>
   ```
4. Run the project once to verify setup.
5. A short demo video (`setup_demo.mp4`) in this repository shows:

   * Cloning/importing
   * Running project
   * Executing sample tests

---

## 🧪 Automated JUnit Tests (Task 2)

### 🔹 Tested Classes

| Class               | Description                                   |
| ------------------- | --------------------------------------------- |
| CalculatorModel     | Core arithmetic operations                    |
| CalculatorPresenter | Connects View and Model                       |
| CalculatorView      | Handles user interaction (mocked for testing) |

---

### 🔹 Test Design

All tests were designed using **ECP** and **BVA**:

* **Valid Inputs:** Normal numeric values (e.g., add(5,3) = 8)
* **Invalid Inputs:** Exceptional cases (e.g., divide by zero)
* **Boundary Values:** Extreme limits (e.g., Integer.MAX_VALUE, negative numbers)

### 🔹 Example Unit Test

```java
@Test
void testDivision_ByZero_ShouldThrowException() {
    CalculatorModel model = new CalculatorModel();
    assertThrows(ArithmeticException.class, () -> model.divide(10, 0));
}
```

Each class includes **5–10 descriptive test cases**, focusing on correctness and robustness.

---

## 📊 Data-Driven Testing (Task 3)

Data-driven testing was implemented using **CSV files** and an **Excel test sheet**.

### 📁 CSV File Example (`/resources/addition_data.csv`)

```
a,b,expected
2,3,5
-1,4,3
0,0,0
100,200,300
```

### 🧩 Example Parameterized Test

```java
@ParameterizedTest
@CsvFileSource(resources = "/addition_data.csv", numLinesToSkip = 1)
void testAdditionFromCsv(int a, int b, int expected) {
    CalculatorModel model = new CalculatorModel();
    assertEquals(expected, model.add(a, b));
}
```

### 🧾 Excel Test Sheet

The file `TestCases.xlsx` includes **4 test cases per category**:

| Category | Input   | Expected | Result |
| -------- | ------- | -------- | ------ |
| Valid    | 5 + 3   | 8        | Pass   |
| Invalid  | 2 / 0   | Error    | Pass   |
| Edge     | 0 + 0   | 0        | Pass   |
| Edge     | Max + 1 | Overflow | Pass   |

---

## ⚙️ Test Configuration & Suites (Task 4)

### 🧰 Maven Surefire Plugin for Parallel Execution

Configured in `pom.xml`:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-plugin</artifactId>
  <version>3.1.2</version>
  <configuration>
    <parallel>classes</parallel>
    <threadCount>3</threadCount>
  </configuration>
</plugin>
```

### 🏷️ Test Grouping with Tags

```java
@Tag("fast")
@Test
void testQuickAddition() { ... }

@Tag("integration")
@Test
void testPresenterIntegration() { ... }
```

Run a specific group:

```bash
mvn test -Dgroups=fast
```

### 🧩 Test Suites Example

```java
@Suite
@SelectClasses({CalculatorModelTest.class, CalculatorPresenterTest.class})
public class FastTestsSuite {}
```

---

## 🧾 Summary Report

| Metric                   | Description                                          |
| ------------------------ | ---------------------------------------------------- |
| **Test Framework**       | JUnit 5                                              |
| **Classes Tested**       | CalculatorModel, CalculatorPresenter, CalculatorView |
| **Test Cases per Class** | 5–10                                                 |
| **Data Source**          | CSV + Excel                                          |
| **Execution Type**       | Parallel (3 threads)                                 |
| **Coverage Tool**        | JaCoCo                                               |
| **Team Members**         | 2                                                    |
| **Extras**               | JaCoCo report & Jira bug report                      |

---

## 🧮 Code Coverage (Optional +5 Marks)

Generated using **JaCoCo** plugin.
Coverage report path:

```
/target/site/jacoco/index.html
```

Screenshot of report attached in repository.

---

## 🐞 Bug Report (Question 2)

A bug report was created in **Jira Software** for an issue found in the Calculator app.

| Field                  | Value                                                                                |
| ---------------------- | ------------------------------------------------------------------------------------ |
| **Project Name**       | Calculator App                                                                       |
| **Issue Type**         | Bug                                                                                  |
| **Summary**            | App crashes when dividing by zero                                                    |
| **Description**        | Division by zero causes ArithmeticException instead of showing user-friendly message |
| **Priority**           | High                                                                                 |
| **Steps to Reproduce** | 1. Enter 10 ÷ 0 <br> 2. Press “=”                                                    |
| **Expected Result**    | Show “Cannot divide by zero”                                                         |
| **Actual Result**      | Application crash                                                                    |
| **Attachment**         | `jira_bug_report.png`                                                                |

---

## 👥 Group Members

<p align="center">
  <a href="https://github.com/l232550" target="_blank">
    <img src="https://avatars.githubusercontent.com/l232550" width="80" height="80" style="border-radius: 50%;" alt="Tooba Nadeem" />
  </a><br/>
  <a href="https://github.com/l232550"><b>Tooba Nadeem</b></a><br/>
  <sub>Student ID: L232550</sub>
</p>

<p align="center">
  <a href="https://github.com/NayabMaryam" target="_blank">
    <img src="https://avatars.githubusercontent.com/NayabMaryam" width="80" height="80" style="border-radius: 50%;" alt="Nayab Maryam" />
  </a><br/>
  <a href="https://github.com/NayabMaryam"><b>Nayab Maryam</b></a><br/>
  <sub>Student ID: F233015</sub>
</p>


---

## 🧩 Attachments

* `setup_demo.mp4` – project setup and execution demo
* `TestCases.xlsx` – Excel test sheet
* `addition_data.csv` – CSV data file
* `jira_bug_report.png` – screenshot of Jira bug report

---

## ▶️ How to Run Tests

```bash
# Run all tests
mvn test

# Run only fast tests
mvn test -Dgroups=fast

# Generate coverage report
mvn jacoco:report
```

### ✅ Final Notes

* All tests were executed successfully on JUnit 5.
* Data-driven and parallel testing demonstrated as required.
* Bug report created and attached.
* Summary report and setup video included.



