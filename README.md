# DistilledChallenge

## Introduction
This README provides instructions for setting up the environment for a Java Maven project using Selenium in TestNG framework. It covers the necessary steps to get the project up and running on your local machine for development and testing purposes.

Prerequisites
Java JDK (Version 11 or higher recommended) 

Maven (Version 3.6 or higher)

Git (for version control)

An IDE (Integrated Development Environment) of your choice (e.g., IntelliJ IDEA, Eclipse)

## Getting Started
Clone the Repository: Use Git to clone the project repository to your local machine.

git clone https://github.com/zeecares/DistilledChallenge.git

After cloning, navigate to the project directory.

cd challenge

Install Dependencies: Run the following Maven command to install all required dependencies specified in the pom.xml file.
mvn clean install

## IDE Configuration
### IntelliJ IDEA:

Open IntelliJ IDEA.
Choose 'Open' and select the project directory.
IntelliJ IDEA should automatically detect the Maven project and import the necessary configurations.

### Eclipse:

Open Eclipse.
Go to 'File' > 'Import' > 'Existing Maven Projects' and select the project directory.

## Running the Application
Run the application through your IDE's run configuration, ensuring the main class is correctly specified.
Double click challenge/src/test/testCases/DaftSearchTest and run it from the IDE

Please note, headless mode is enabled by default. To disable headless mode, in challenge/src/test/testCases/BaseClass, please comment out: 
options.addArguments("--headless"); 

