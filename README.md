# 🧮 Calculator App – JUnit 5 Test Automation Solution

## 📝 Project Overview

This project implements **automated unit testing** for a simple Java-based calculator application with three main components:

* **CalculatorApp** – To initialize the objects of other classes so they work correctly.
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
| CalculatorAppTest       | Connects all three classes to run without exception|
| CalculatorModelTest     | Core arithmetic operations                    |
| CalculatorPresenterTest | Connects View and Model                       |
| CalculatorViewTest      | Handles user interaction (mocked for testing) |

---

### 🔹 Test Design

All tests were designed using **ECP** and **BVA**:

* **Valid Inputs:** Normal numeric values (e.g., add(5,3) = 8)
* **Invalid Inputs:** Exceptional cases (e.g., divide by zero)
* **Boundary Values:** Extreme limits (e.g., Integer.MAX_VALUE, negative numbers)

### 🔹 Example Unit Test

```java
	@Test
	void fivePlusThreeShouldEqualEight() { // testing addition with positive number
		assertEquals(8, model.add(5, 3)); // assertEquals(expected,actual);
	}
```

Each class includes **3–11 descriptive test cases**, focusing on correctness and robustness.

---

## 📊 Data-Driven Testing (Task 3)

Data-driven testing was implemented using **CSV files** and an **Excel test sheet**.

### 📁 CSV File Example (`/resources/add_data.csv`)

```
num1,num2,expected
5,3,8
-4,6,2
0,7,7
10,-10,0
```

### 🧩 Example Parameterized Test

```java
// ---------- Addition Tests ----------
    //This test will run once for every line in the CSV file.
    @ParameterizedTest(name = "add({0}, {1}) = {2}") //for example: add(5.0, 3.0) = 8.0
    @CsvFileSource(resources = "/add_test_data.csv", numLinesToSkip = 1) //resources: tell JUnit to look in 'src/test/resources/add_test_data.csv'. //numLinesToSkip: skip the header line (num1,num2,expected).
    void testAddition(double num1, double num2, double expected)
    {
        assertEquals(expected, model.add(num1, num2));
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
<plugins>
   <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>3.0.0-M7</version>
      <configuration>
         <parallel>classes</parallel>
         <threadCount>2</threadCount>
         <useUnlimitedThreads>false</useUnlimitedThreads>
      </configuration>
   </plugin>
</plugins>
```

### 🏷️ Test Grouping with order notation

```java
   @Test
	@Order(1)
	void fivePlusThreeShouldEqualEight() { // testing addition with positive number
		assertEquals(8, model.add(5, 3)); // assertEquals(expected,actual);
	}

	@Test
	@Order(2)
	void fivePlusMinusThreeShouldEqualTwo() { // testing addition with negative number
		assertEquals(2, model.add(5, -3));
	}
```

Run a specific group:

```bash
mvn test -Dgroups=fast
```

### 🧩 Test Suites Example

```java
/**
 * Suite for fast, lightweight unit tests.
 */
@Suite
@SelectClasses({
    CalculatorModelTest.class,
    CalculatorViewTest.class
})
public class FastTests {
}
```

---

## 🧾 Summary Report

| Metric                   | Description                                                         |
| ------------------------ | ------------------------------------------------------------------- |
| **Test Framework**       | JUnit 5                                                             |
| **Classes Tested**       | CalculatorApp, CalculatorModel, CalculatorPresenter, CalculatorView |
| **Test Cases per Class** | 3–11                                                                |
| **Data Source**          | CSV + Excel                                                         |
| **Execution Type**       | Parallel (3 threads)                                                |
| **Coverage Tool**        | JaCoCo                                                              |
| **Team Members**         | 2                                                                   |
| **Extras**               | JaCoCo report & Jira bug report                                     |

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
**Bug#01**
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
| **Actual Result**      | Show -1.0 on screen.                                                                 | 
| **Attachment**         | `jira_bug_report.png`                                                                |

---
## 🐞 Bug Report (Question 2)
**Bug#02**
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
* `addition_data.csv` – CSV data files for all operators
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



