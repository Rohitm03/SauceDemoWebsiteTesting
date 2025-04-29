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

- Java 17+
- Maven 3.6+
- Node.js (for Playwright CLI, optional)
- Git

---

## 🚀 How to Run the Tests

```bash
# Clone the repo
git clone https://github.com/your-username/saucedemowebsitetesting.git
cd saucedemowebsitetesting

# Install dependencies
mvn clean install

# Run tests
mvn test


🧾 Reports and Logs
📄 HTML Report: target/extent-report.html

📸 Failure Screenshots: target/test-output/images/*.png

🎥 Test Execution Demo
✅ Headed and headless execution recorded (upload video in repo or share via link).

📌 Notes
No public APIs were available, so tests were fully automated at the UI level.

Designed using Page Object Model, modular utilities, and proper reporting integrations.

👨‍💻 Author
Rohit Mishra
📧  mrohit499@gmail.com
