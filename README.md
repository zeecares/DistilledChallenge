# DistilledChallenge

Introduction
This README provides instructions for setting up the environment for a Java Maven project using Selenium in TestNG framework. It covers the necessary steps to get the project up and running on your local machine for development and testing purposes.

Prerequisites
Java JDK (Version 11 or higher recommended)
Maven (Version 3.6 or higher)
Git (for version control)
An IDE (Integrated Development Environment) of your choice (e.g., IntelliJ IDEA, Eclipse)
Getting Started
Clone the Repository: Use Git to clone the project repository to your local machine.

bash
Copy code
git clone [https://github.com/zeecares/DistilledChallenge.git]
Navigate to the Project Directory: After cloning, navigate to the project directory.

bash
Copy code
cd [project directory]
Install Dependencies: Run the following Maven command to install all required dependencies specified in the pom.xml file.

bash
Copy code
mvn clean install
IDE Configuration
IntelliJ IDEA:

Open IntelliJ IDEA.
Choose 'Open' and select the project directory.
IntelliJ IDEA should automatically detect the Maven project and import the necessary configurations.
Eclipse:

Open Eclipse.
Go to 'File' > 'Import' > 'Existing Maven Projects' and select the project directory.
Running the Application
Run the application through your IDE's run configuration, ensuring the main class is correctly specified.

Running Tests
To run tests, use the following Maven command:

bash
Copy code
mvn test
Version Control
Use the .gitignore file to manage which files and directories should be excluded from version control.

Further Assistance
For additional help, refer to the Maven and Java documentation, or consult your IDE's support resources.
