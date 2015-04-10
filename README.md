# pdt_22_tz

new PDT project 2015:
 - Lecture 1: Start of basic automation tests of simple addressBook (web app), structured code (HW1, HW2).
   Two data classes are created for Groups and Contacts. 
   Two tests classes are created (TestNG) with a TestBase class (common methods) to run the tests.
 
 - Lecture 2: Control the data-flow (HW3, HW4).
   Elements to control the application are moved into framework package.
   TestBase communicates with application via ApplicationManager.
   ApplicationManager delegates work with app elements to varios Helper classes.
   Base Helper class created with the common methods.
   Helpers are initialized on demand only.
   Tests are expanded to creation, modification, deletion of app Groups, Contacts.

 - Lecture 3: Data containers.
   Lists of data objects are introduced for GroupData (HW5), ContactData (HW6).
   DataProvider methods are introduced for test-data generation (HW7).
   Assertions are added to tests.

 - Lecture 4: Work with String.
   Cache is implemented for groups and contacts (HW8).
   Readability is improved (HW9).
   Navigation is moved from tests to Helpers (HW9).
   AdressBook tests are introduced (HW10*).

 - Lecture 5: Work with Files.
   DataGenerators for Groups and Contacts with saving test-data to files (csv or xml) are implemented (HW11).
   New DataProviders read data from files (HW12).
   Suit configuration file for TestNG is created with script to run tests from command-line (HW13).
   Make a properties file(HW14).

 - Lecture 6: Java GUI Test Automation.
   New project with same infostructure as in previous lessons: Test classes,TestData classes, ApplicationManager, Helpers,       properties files, TestNG suit file configuration (HW15).
   Tests for checking folder creation functionality (HW15).
   Tests for verifying folder creation with only unique name (HW16).
   Folder removal test-case (HW17).
