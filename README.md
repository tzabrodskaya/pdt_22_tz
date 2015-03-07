# pdt_22_tz

new PDT project 2015:
 - Lecture 1: Start of basic automation tests of simple addressBook (web app), structured code.
    Two data clasees are created for Groups and Contacts. 
    Two tests classes are created (TestNG) with a TestBase class (common methods) to run the tests.
 
 - Lecture 2: Control the dataflow.
    Elements to control the application are moved into framework package.
    TestBase communicate with application via ApplicationManager.
    ApplicationManager delegates work with app elements to varios Helper classes.
    Base Helper class created with the common methods.
    Helpers are initialized on demand only.
    Tests are expanded to creation, modification, deletion of app Groups, Contacts.

 - Lecture 3: Data containers.
    Lists of data objects are introduced for Group Data.
    DataProvider methods are introduced for test-data generation.
    Assertions are added to tests.
