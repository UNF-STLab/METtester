import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.FileUtils;
import org.xml.sax.SAXException;
import mujava.*;
import mujava.cli.testnew;

public class METTester {
	public static void RunMETTest() throws IOException, InterruptedException{
		System.out.println("METtester tool: Please enter Test class name:(example: abc) ");
		 Scanner input = new Scanner(System.in);
		 String[] argVal = {null,null};
		 argVal[0] = input.next();
		 System.out.println("Please enter the file name and location of your xml file:(Example:directory/of/xml/file/test.xml) ");
		 argVal[1] = input.next(); // getting a String value
		 System.out.println("Generating test cases....");
		 genRandomTestsuite(argVal[0],argVal[1]);
		 //genEvoTestsuite(argVal[0],argVal[1]);
		 System.out.println("Generating Mutants....");
		 generateMutants(argVal);
		 runMutants(argVal); 
		 //oracle prioritization
		 System.out.println("Oracle prioritisation is in progress....");
		 File folder = new File("./src/mutants/");
		 int count =0;
		  for (File file : folder.listFiles()) {
		   if (file.getName().startsWith("tmp")) {
		    file.delete();
		    count++;
		   }
		  }
		  if(count==4){
			  System.out.println("All temporary folders removed");
		  }
		 oraclePrior(argVal);	
		
		 //oracle prior end
		 //metamorphic testing 
		 System.out.println("Metamorphic testing is in progress....");
		 File currentFile =  new File(".//src//"+argVal[0]+".class");
		 File originalFile = new File(".//src//"+argVal[0]+"_.class");
		 Boolean fileChanged = true;
		 if(currentFile.exists()){
			 //commented for purpose
			//currentFile.delete();
			//fileChanged = originalFile.renameTo(currentFile);
			//originalFile.delete();
		 }else{
			 System.out.println("Either "+argVal[0]+".class file has been removed or not included on correct path");
		 }
		 if(fileChanged){
			 MTTester mt = new MTTester();
			 try {
				mt.RunTest(argVal);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("error:"+e);
				//e.printStackTrace();
			} 
		 }
		
		 //metamorphic testing end	
	 }
	//generate random test cases
	public static void genRandomTestsuite( String javaFile, String methodname) throws IOException, InterruptedException{
	    String testCase = "Random"; // no other testcase mention in xml file
	    XmlParser xp = new XmlParser();
		String methodName = xp.xmlMethodName(methodname);
		//ArrayList inputparam = xp.inputParamInfo(methodname);
		ArrayList inputparamtype = xp.xmlParamType(methodname);
		
	       if(testCase == "Random"){
	    	   int testno = 100; //default 100 if not mentioned in xml  
	    	   for(int i=0;i<testno;i++){
	    		   
	    	   }
	       } 
	}    
	//generagte evosuite based test cases/suite 
	 public static void genEvoTestsuite(String javaFile, String methodname) throws IOException, InterruptedException{
			  // commented part for evosuite generated test cases
			   String sFileName = ".//evosuite.bat";
			   FileWriter writer = new FileWriter(sFileName,false);
			   File file = new File(sFileName);
			   if ( !file.exists() ){
			    	file.createNewFile();	
			   }
			   writer.append("java -jar evosuite-1.0.6.jar -class "+ javaFile +" -projectCP C:\\Users\\p66n633\\Dropbox\\javaproject\\MetaTest\\src -Dtarget_method="+ methodname +" -criterion weakmutation");
			   writer.append('\n');
			  // writer.append("java mujava.cli.genmutes -AORB -AORS -AOIU -AODU "+args[0]);
			  // writer.append('\n');
			   //writer.append("exit");
			   writer.flush();
			   writer.close();	
		       //Runtime rt = Runtime.getRuntime();
		       int pr = 1;
		       try {
		    	   List listA = new ArrayList();

		    	   listA.add("cmd");
		    	   listA.add("/c");
		    	   listA.add(".\\evosuite.bat");
		    	   //listA.add("mujava.bat");
		    	    Process pb = new ProcessBuilder().inheritIO().command(listA).start();// /c java mujava.cli.testnew -debug "+args[0]+" "+args[0]).start();//, " java mujava.cli.genmutes -VDL "+args[0]," exit").start();
		            //pb.redirectOutput();
		    	    //pb.redirectError();
		            //Process p = pb.start();
		    	   pr = pb.waitFor();
		    	   System.out.println("Process terminated with " + pr);
		    	   if(pr==0){
			    	   //return 1;
			    	   System.out.println("Evosuite test suite generation Completed");
			    	   //System.out.println("Executing Mutants....");
			   		   //runMutants(args); 
			   		   //System.out.println("Mutants execution completed");
		    	   }
		       } catch (InterruptedException e) {
				// TODO Auto-generated catch block
		    	   System.err.println(e.toString());
		       }
		      
		       //commented part for evosuite generated test cases */
			   //int result= Runtime.getRuntime().exec(new String[] {"cmd", "/C", "Start","C:\\Users\\p66n633\\Dropbox\\javaproject\\MetaTest\\src\\mujava.bat"}).waitFor(); 
			   
	        //} 
	       /*  catch (IOException e){ 
	            //System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
	            //e.printStackTrace(); 
	            System.err.println(e.toString());
	        } */

	 }
	 public static void oraclePrior(String[] args){
		 createprioritisedorder cp = new createprioritisedorder();
			//String val[]= {sFileName};
		 try {
			cp.main(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 public static int runMutants(String[] args){
		 XmlParser xp = new XmlParser();
		 String methodName = xp.xmlMethodName(args[1]);
		 File fileXml  = new File(args[1]);
		 File mutantfile = new File(".//"+args[0]+"//result//"+args[0]+"//traditional_mutants");
		 String[] directories = null;
		 try {
			 directories = mutantfile.list(new FilenameFilter() {
			 @Override
			 public boolean accept(File current, String name) {
				     return new File(current, name).isDirectory();
				}
			});
			} catch(NullPointerException e) {
				 System.err.println("No directories found");
			} finally {
		 //File[] directories = new File("/your/path/").listFiles(File::isDirectory);
				//System.out.println(directories.toString());
				if(directories==null){
					System.out.println("No directories found");
				}else{
					for(int i =0; i < directories.length; i++)
				    {
				        if(directories[i].contains(methodName+"("))
				        {  
				        	File[] subdirectories = new File(".//"+args[0]+"//result//"+args[0]+"//traditional_mutants//"+directories[i]).listFiles(File::isDirectory);
				        	//System.out.println(Arrays.toString(subdirectories));
				        	if(subdirectories.length>0){
				        		//rename the current original file
				        		File originalFile =  new File(".//src//"+args[0]+".class");
				        		File renamedFile = new File(".//src//"+args[0]+"_.class");
				        		if(originalFile.exists()){
				        			originalFile.renameTo(renamedFile);
				        		}
				        		//search for class file and run test cases
				        		for(int j=0;j<subdirectories.length;j++){
				        			File fileClass  = new File(subdirectories[j]+"\\"+args[0]+".class");
				        			if(fileClass.exists()){
				        				//System.out.println(fileClass.toPath()+" "+originalFile.toPath()+"\n");
				        				//Files.copy(fileClass.toPath(),originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				        				try {
				        					//Files.copy(subdirectories[j], new File(".//src//"), null);
				        				    FileUtils.copyDirectory(subdirectories[j], new File(".//src//"));
				        				} catch (IOException e) {
				        				    //e.printStackTrace();
				        					System.err.println("File not found");
				        				}
				        				ArrayList data_type = xp.xmlParamType(args[1]);
								    	ArrayList initial_data = xp.xmlMrDesc(args[1]);
									   //work starts from here
								    	ArrayList initial_inputdata = xp.xmlInitialInput(args[1]);
								    	
										//initial_input data
										//this loop run based on total number of initial test case
										initialTestInput testInput = new initialTestInput();
										//for(int k =0;k<initial_inputdata.size();k++){
											//System.out.println("TestCase"+(k+1)+"  started... \n");
											//MR list and constant values
											ArrayList mrList = (ArrayList)initial_data.get(0);
											//MR operator list
											ArrayList mrOperator = (ArrayList)initial_data.get(1);
											//System.out.println(mrList.get(i));
											//System.out.println("Initial test input:"+initial_inputdata.get(0).toString());
											Object[] initial_input_data = testInput.initialTestInput(initial_inputdata.get(0), data_type);	
											for(int k=0;k<mrList.size();k++){
												ArrayList mrdesc = (ArrayList)mrList.get(k);
												Object[] followup_input_data = testInput.followupTestInput(initial_input_data, mrdesc, data_type);
												boolean result = testInput.runTest(args[0], methodName, initial_input_data,followup_input_data,mrOperator.get(k).toString());
											//For mutation testing using MRs and printing outputs
											//will not go in the main tool
											try
											{   
												String sFileName = ".//src//mutants//"+methodName+".csv";
												FileWriter writer = new FileWriter(sFileName,true);
											    File file = new File(sFileName);
											    if ( !file.exists() ){
											    	file.createNewFile();	
											    }
											    ArrayList mrel = (ArrayList) mrdesc.get(0);
										  // if(!System.getProperty("MRname").equals("buildClassifier_1")&&!System.getProperty("MRname").equals("buildClassifier_3")) { 
											   //writer.append(methodName);
											   //writer.append(',');
											   String mutantName = subdirectories[j].toString().replace(".\\"+args[0]+"\\result\\"+args[0]+"\\traditional_mutants\\"+directories[i].toString()+"\\", "");
											   writer.append(mutantName.toString());
											   writer.append(',');
											   writer.append(mrel.get(0).toString());
											   writer.append(',');
											   writer.append("test1"); 
											   writer.append(',');
											   writer.append(Boolean.toString(result));
											   writer.append('\n');  
											//	    }
											    writer.flush();
											    writer.close();	
											}
											catch(IOException e)
											{
											     e.printStackTrace();
											}	
											
											//end mutation testing
												
											}
										//}
				        			}
				        		}
				        	}
				        }else{
				        	//System.out.println("No folder found with the name of "+directories[i]+"\n");
				        }
				    }
				}	 
	 }
		 return 0;
	 }
	 
	 public static void generateMutants(String[] args){
		  try
	        { 
			   String sFileName = ".//mujava.bat";
			   FileWriter writer = new FileWriter(sFileName,false);
			   File file = new File(sFileName);
			   if ( !file.exists() ){
			    	file.createNewFile();	
			   }
			   writer.append("java mujava.cli.testnew -debug "+args[0]+" "+args[0]);
			   writer.append('\n');
			   writer.append("java mujava.cli.genmutes -ROR "+args[0]);
			   //writer.append('\n');
			   //writer.append("exit");
			   writer.flush();
			   writer.close();	
		       Runtime rt = Runtime.getRuntime();
		       int pr = 1;
		       try {
		    	   List listA = new ArrayList();

		    	   listA.add("cmd");
		    	   listA.add("/c");
		    	   listA.add(".\\mujava.bat");
		    	   Process pb = new ProcessBuilder().inheritIO().command(listA).start();// /c java mujava.cli.testnew -debug "+args[0]+" "+args[0]).start();//, " java mujava.cli.genmutes -VDL "+args[0]," exit").start();		          
		    	   pr = pb.waitFor();
		    	   System.out.println("Process terminated with " + pr);
		    	   //working on mujava
		    	   //testnew c1 = new mujava.cli.testnew();
		    	   //String[] mujavaArg = {args[0],args[0]};
		    	   
		    	   //c1.main(mujavaArg);
		    	   //working on mujava
		    	   if(pr==0){
			    	   //return 1;
			    	   System.out.println("Mutants generation Completed");
			    	   System.out.println("Executing Mutants....");
			   		   runMutants(args); 
			   		   System.out.println("Mutants execution completed");
		    	   }
		       } catch (InterruptedException e) {
				// TODO Auto-generated catch block
		    	   System.err.println(e.toString());
		       }
		      
			   //int result= Runtime.getRuntime().exec(new String[] {"cmd", "/C", "Start","C:\\Users\\p66n633\\Dropbox\\javaproject\\MetaTest\\src\\mujava.bat"}).waitFor(); 
			   
	        } 
	        catch (IOException e) 
	        { 
	            //System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
	            e.printStackTrace(); 
	        } 
	           // String[] command = {"cmd.exe", "/C", "Start", "D:\\test.bat"};
	           // Process p =  Runtime.getRuntime().exec(command);           
		    //String createDir = "java mujava.cli.testnew -debug "+className+" "+className;
			//String genMutes = "java mujava.cli.genmutes -ALL "+className;
			//Runtime.getRuntime().exec(createDir);
			//Runtime.getRuntime().exec(genMutes);
		  //return 0;
		//return 0;
	 }	
	 public static void main (String[] args){
		 args =null;
		 try {
			 //genEvoTestsuite("MethodCollection2","add_values");
			RunMETTest();
			 //genRandomTestsuite("MethodCollection2","C:\\Users\\p66n633\\Dropbox\\javaproject\\MetaTest\\src\\MethodCollection2\\array_calc1.xml");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	 } 
}
