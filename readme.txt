METtester::
---------------
https://zenodo.org/badge/DOI/10.5281/zenodo.1157183.svg
---------------
Required files:
----------------
1.METtester.jar,mujava.jar,openjava.jar,tools.jar,commons-io-2.11.0.jar,junit-4.10.jar,hamcrest-core-1.3.jar,mujavaCLI.config
2.Class file to test & java file to generate mutants. e.g. test.java & test.class
3.Xml file containing test cases 

Note: METtester is tested on Java 8 and Java 10 environment & Windows OS. Only compatible on Java 8.

How to run a MTTester.jar file from command line?
-----------------------------------------------------
Step 1:
create a 'src' folder inside the path of the METtester.jar file.
Step 2:
Copy the class and the java file under test in the 'src' folder. e.g. MethodCollection2.class & MethodCollection2.java
Step 3:
Start command prompt and go to the location where METtester.jar file is.
Step 4:
Type "java -cp . -jar METTester.jar" & enter
Step 5:
Type class name to be tested, press enter. E.g. MethodCollection2 
Step 6:
Type the method name under test from that class file. e.g. find_median
Step 7:
Type the MR names you want to apply on Metamorphic Testing. e.g. ADD,MUL

