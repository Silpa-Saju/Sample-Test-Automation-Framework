# Sample-Selenium-Java-Automation-Test-Framework

I have automated the zipBoard UI and completed the following tasks. : 
   
-  Automated zipBoard login process.
-  Developed an automated test script for creating a new project.
-  Automated the task addition process.
-  Automated the project deletion process.
 

#  1. Choice of Framework: Selenium-Java
I chose Selenium with Java for this test script because:
- Widely Used: 
  Selenium is a popular framework for automating web applications, and it supports multiple programming languages, including Java.
- Java's Versatility: 
  Java is widely used in enterprise environments and has a rich ecosystem of testing libraries, making it a great choice for building scalable and     
  maintainable test automation solutions.
- Community Support: 
  A large community means ample resources, tutorials, and support when troubleshooting issues.


#  2. Design Pattern Used : Data-Driven Testing Approach
   This script will utilize the Data-Driven Approach:    
   separates test data from test scripts, enabling the same test case to run with different sets of data from sources like Excel files, CSV, databases,   or JSON.
   Also, its easier to manage test data separately, making it ideal for scenarios where the input data changes frequently.


#  3. Pre-requisites and Setup Instructions
- Install Java JDK: 
    Download and install the latest JDK from the Oracle website.
- Install Maven: 
    Download and install Maven from the Maven website.
- Set Up an IDE: 
    Use an IDE like IntelliJ IDEA or Eclipse.
- Open the downloaded project in any IDE like Eclipse
  
# 4. Steps to Run the Tests
* Build the Project:
 Open the terminal in your project directory.
 Run mvn clean install to build the project and download dependencies.
* Run the Tests:
	 Use the TestNG plugin in your IDE or run mvn test from the terminal.
	 The tests will launch the browser, navigate to the specified URL, add an annotation, and close the browser after execution.
  
  (OR)
- Build the project in Eclipse And Run the testng.xml file

#  5. Key Considerations
Kindly provide credentials (email and password) for zipBoard of sheet ‘UserLoginTest’ in    testData.xlsx in folder src/test/resources/excel/testData.xlsx, to run the test.

#  6. Report Generated By Automating zipBoard
- Reports generated after running the testng.xml file can be found in src/target/surefire-reports/html/extent.html.
- Open extent.html in any web browser


