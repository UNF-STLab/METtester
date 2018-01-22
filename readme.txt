MTTester::
---------------
https://zenodo.org/badge/DOI/10.5281/zenodo.1157183.svg
---------------
Required files:
----------------
1.MTTester.jar
2.Class file to test
3.Xml file containing test cases 

How to run a MTTester.jar file from command line?
-----------------------------------------------------
Step 1:
create a 'src' folder inside the path of the MTTester.jar file.
Step 2:
Copy the class file under test in the 'src' folder. e.g. MethodCollection2.class
Step 3:
Start command prompt and go the location where MTTester.jar file is.
Step 4:
Type "java -cp file\path\of\MTTester.jar -jar MTTester.jar classFileName location\of\xml\file\with\filename.xml"

e.g."java -cp c:\MTTester\MTTester.jar -jar MTTester.jar MethodCollection2 c:\MTTester\sample.xml"
