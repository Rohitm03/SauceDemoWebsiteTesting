# 🧪 SauceDemo Website Testing Automation

Automated UI test suite for [SauceDemo](https://www.saucedemo.com/) using **Playwright + Java + TestNG**, designed with modular architecture and industry-standard practices.

---

## ✅ Scenarios Automated

1. ✔️ Verify sorting order from **Z to A** on the "All Items" page.
2. ✔️ Verify **price order (high to low)** on the "All Items" page.
3. ✔️ Add multiple items to cart and **validate full checkout journey**.

---

## 🌟 Bonus Features

- 📸 **Automated visual tests** with screenshot capture on failure.
- 📄 **Extent Reports** for rich HTML test execution reports.

---

## 📂 Project Structure

SAUCEDEMOWEBTESTING-MAIN/ │ ├── .idea/ # IDE config ├── .vscode/ # VSCode config ├── src/ │ ├── main/java/ │ │ ├── utilities/ │ │ │ ├── ExtentReportManager.java │ │ │ └── ScreenshotUtility.java │ │ └── webpages/ │ │ ├── CartPage.java │ │ ├── CheckoutPage.java │ │ ├── InventoryPage.java │ │ └── LoginPage.java │ └── test/java/ │ └── SauceDemoTest.java │ ├── target/ │ └── test-output/images/ # Screenshots on test failures │ ├── failure_*.png │ └── extent-report.html # HTML test report │ ├── pom.xml # Maven config and dependencies ├── testng.xml # Test suite configuration ├── README.md ├── .gitignore ├── .gitattributes



---

## 🛠️ Prerequisites

- Windows system
- Java 17+
- Maven 3.6+
- Node.js (for Playwright CLI, optional)
- Git

---

## 🚀 How to Run the Tests on Windows Machine

```bash
# Clone the repo
git clone https://github.com/Rohitm03-/saucedemowebsitetesting.git
cd saucedemowebsitetesting

# Install dependencies
mvn clean install

# Run tests
mvn test


🧾 Reports and Logs
📄 HTML Report: target/extent-report.html

📸 Failure Screenshots: target/test-output/images/*.png

🎥 Test Execution Demo
✅ Headed
https://drive.google.com/file/d/163Trrsf3pwomNJb5u1sSlpvHF9Q9zbs8/view?usp=sharing



📌 Notes
No public APIs were available, so tests were fully automated at the UI level.
Run on windows machine only.


Designed using Page Object Model, modular utilities, and proper reporting integrations.

🔮 Future Improvements
Here are planned enhancements to improve automation scalability, maintainability, and CI/CD integration:

🔁 Cucumber BDD Integration
Refactor the current TestNG-based suite into Cucumber BDD format.

Define human-readable Gherkin feature files for better collaboration with non-technical stakeholders.

Maintain separation of concerns with:

Step definitions

Hooks

Feature files

Page objects

🚀 CI/CD Integration with Jenkins
Integrate this test suite with Jenkins to support:

Automated nightly builds and test runs

Triggered executions on GitHub pushes or pull requests

Archiving reports and screenshots post-run

Enable parameterized jobs to run tests across:

Headless/headed modes

Different environments (e.g., staging, production)

Cross-browser setups

👨‍💻 Author
Rohit Mishra
📧  mrohit499@gmail.com
