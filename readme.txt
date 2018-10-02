METtester::
---------------
https://zenodo.org/badge/DOI/10.5281/zenodo.1157183.svg
---------------
Required files:
----------------
1.METtester.class
2.Class file to test &java file to generate mutants
3.Xml file containing test cases 

How to run a MTTester.jar file from command line?
-----------------------------------------------------
Step 1:
create a 'src' folder inside the path of the MTTester.jar file.
Step 2:
Copy the class and the java file under test in the 'src' folder. e.g. MethodCollection2.class & MethodCollection2.java
Step 3:
Copy the .XML file in the root directory.
Step 4:
Open mujavaCLI.config file and write down the directory of mujava.jar file. e.g. MuJava_HOME=C:\METTester
Step 5:
Start command prompt and go the location where MTTester.jar file is.
Step 5:
SET classpath by copying 'set CLASSPATH=%CLASSPATH%;C:\mettester\mujava.jar;C:\mettester\openjava.jar;C:\mettester\tools.jar;C:\mettester\commons-io-2.4.jar'
Step 7:
Type "java -cp .;./src;commons-io-2.4.jar METTester"

