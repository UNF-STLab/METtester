METtester::
---------------
https://zenodo.org/badge/DOI/10.5281/zenodo.1157183.svg
---------------
Required files:
----------------
1.METtester.jar,mujava.jar,openjava.jar,tools.jar,commons-io-2.4.jar,junit.jar,hamcrest.jar,mujavaCLI.config
2.Class file to test & java file to generate mutants. e.g. test.java & test.class
3.Xml file containing test cases 

Note: METtester is tested on Java 8 and Java 10 environment & Windows OS. Only compatible on Java 8.

How to run a MTTester.jar file from command line?
-----------------------------------------------------
Step 1:
create a 'src' folder inside the path of the METtester.jar file and create a folder mutants inside src folder.
Step 2:
Copy the class and the java file under test in the 'src' folder. e.g. MethodCollection2.class & MethodCollection2.java
Step 3:
Copy the .XML file in the root directory.
Step 4:
Open mujavaCLI.config file and write down the directory of mujava.jar file. e.g. MuJava_HOME=C:\METTester
Step 5:
Start command prompt and go to the location where METtester.jar file is.
Step 5:
SET classpath by copying 'set CLASSPATH=%CLASSPATH%;C:\METtester\mujava.jar;C:\METtester\lib\openjava.jar;C:\METtester\lib\tools.jar;C:\METtester\lib\commons-io-2.4.jar;C:\METtester\lib\junit.jar;C:\METtester\lib\hamcrest.jar'
Step 7:
Type "java -cp .;./src; -jar METtester.jar" & enter
Step 8:
Type class name to be tested, press enter. E.g. MethodCollection2 
Step 9:
Type the path and file name of the XML and press enter. e.g. C:\METtester\find_median.xml 

