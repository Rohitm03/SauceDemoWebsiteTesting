SauceDemoWebsiteTesting
This project is an end-to-end UI Test Automation Framework built with Playwright + TestNG in Java for automating the SauceDemo website.

📚 Tech Stack
Java
Playwright for Java
TestNG (Test Runner)
Extent Reports (Reporting)
Maven (Build Tool)
Git & GitHub (Version Control)

🏗️ Project Structure
bash
Copy
Edit
/src
  /main
    /java
      /webpages      --> Page Object Model (POM) classes (LoginPage, InventoryPage, CartPage, CheckoutPage)
  /test
    /java
      /tests         --> Test classes (loginTest.java)
pom.xml             --> Maven project file
testng.xml          --> TestNG suite file
README.md
⚙️ How to Set Up Locally
Clone the repository:

bash
Copy
Edit
git clone https://github.com/Rohitm03/SauceDemoWebsiteTesting.git
cd SauceDemoWebsiteTesting
Open the project in IntelliJ IDEA / Eclipse.

Install project dependencies:

If you are using IntelliJ:

Maven -> Right click on pom.xml -> "Reload Project"

Or via command line:

bash
Copy
Edit
mvn clean install
Run the tests:

Via TestNG (Right click testng.xml -> Run)

OR through Maven:

bash
Copy
Edit
mvn test
🧪 What Tests Are Covered?
Login to SauceDemo Website

Verify product sorting (Z to A)

Verify price sorting (High to Low)

Add selected products to cart

Complete checkout journey (First Name, Last Name, Postal Code)

📄 Test Reports
After test execution, an Extent Report will be generated inside /test-output/ExtentReport.html.
You can open it in a browser to view full detailed test results.

📌 Prerequisites
JDK 17 or later

Maven

Git

Stable Internet connection

🙌 Acknowledgements
SauceDemo Website

Playwright for Java

TestNG

ExtentReports

🚀 Happy Testing!
