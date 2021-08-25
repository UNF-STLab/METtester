import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

//import org.junit.Test;

public class MTTester {
	public void RunTest(String[] args) throws Exception{
		 try{
				//read input params
				 String inputClass = args[0];
				 String inputXml = args[1];
				 inputXml = inputXml.substring(0, inputXml.indexOf(".xml")).concat("_order.xml");
					
				 //System.out.println(inputClass+"  "+inputData+"   "+inputXml);
				 File fileClass  = new File(".//src//"+inputClass+".class");
				 File fileXml  = new File(inputXml);
				 if (fileClass.exists()) {
					    System.out.println("a class file exists");
					    	 if (fileXml.exists()) {
							    	System.out.println("a file or directory  exists");
							    	//xml parser values
							    	XmlParser xp = new XmlParser();
							    	String methodName = xp.xmlMethodName(inputXml);
							    	int param = xp.xmlParam(inputXml);
							    	ArrayList data_type = xp.xmlParamType(inputXml);
							    	ArrayList initial_data = xp.xmlMrDesc(inputXml);
								   //work starts from here
							    	ArrayList initial_inputdata = xp.xmlInitialInput(inputXml);
							    	
									//initial_input data
									//this loop run based on total number of initial test case
									initialTestInput testInput = new initialTestInput();
									//writing into a log file
									String sFileName = methodName+".log";
									FileWriter writer = new FileWriter(sFileName,false);
								    File file = new File(sFileName);
								    if ( !file.exists() ){
								    	file.createNewFile();	
								    }
								    writer.append(methodName);
								    //String[] violatedMR = {};
								    ArrayList<String> violatedMR = new ArrayList<String>();
								    ArrayList<Integer> failedTest = new ArrayList<Integer>();
								    int i =0;
								    int countMR = 0;
									for(i =0;i<initial_inputdata.size();i++){
										System.out.println("\n TestCase "+(i+1)+"  started... \n");
										//MR list and constant values
										ArrayList mrList = (ArrayList)initial_data.get(0);
										//MR operator list
										ArrayList mrOperator = (ArrayList)initial_data.get(1);
										countMR = mrList.size();
										//System.out.println(mrList.get(i));
										writer.append('\n');
										writer.append("Initial test input:"+initial_inputdata.get(i).toString());
										
										System.out.println("Initial test input:"+initial_inputdata.get(i).toString());
										Object[] initial_input_data = testInput.initialTestInput(initial_inputdata.get(i), data_type);	
										for(int j=0;j<mrList.size();j++){
											ArrayList mrdesc = (ArrayList)mrList.get(j);
											Object[] followup_input_data = testInput.followupTestInput(initial_input_data, mrdesc, data_type);
											boolean result = testInput.runTest(inputClass, methodName, initial_input_data,followup_input_data,mrOperator.get(j).toString());
										
										//for each test case
										ArrayList mrel = (ArrayList) mrdesc.get(0);
										//String String_Array[]=new String[followup_input_data.length];
										writer.append('\n');
										writer.append("follow-up test input:[");
										System.out.print("follow-up test input:[");
										for(int k=0;k<followup_input_data.length;k++){
											//System.out.print("[");
											if(followup_input_data[k] instanceof int[]){
												int[] followupTestCase =(int[]) followup_input_data[k];
												for(int l=0;l<followupTestCase.length;l++){
													if(l==(followupTestCase.length-1)){
														System.out.print(followupTestCase[l]+"]");
														//writer.append('\n');
														writer.append(String.valueOf(followupTestCase[l])+"]");
													}else if(l==0){
														System.out.print("["+followupTestCase[l]+",");
														//writer.append('\n');
														writer.append("["+String.valueOf(followupTestCase[l])+",");
													}else{
														System.out.print(followupTestCase[l]+",");
														//writer.append('\n');
														writer.append(String.valueOf(followupTestCase[l])+",");
													}
													
												}
											}else if(followup_input_data[k] instanceof Integer){
												int followupTestCase =(int) followup_input_data[k];
												System.out.println(followupTestCase+",");
												//writer.append('\n');
												writer.append(String.valueOf(followupTestCase)+",");
											}else if(followup_input_data[k] instanceof String){
												String followupTestCase =(String) followup_input_data[k];
												System.out.println(followupTestCase+",");
												//writer.append('\n');
												writer.append(String.valueOf(followupTestCase)+",");
											}else if (followup_input_data[k] instanceof double[]){
												double[] followupTestCase =(double[]) followup_input_data[k];
												for(int l=0;l<followupTestCase.length;l++){
													if(l==(followupTestCase.length-1)){
														System.out.print(followupTestCase[l]+"]");
														//writer.append('\n');
														writer.append(String.valueOf(followupTestCase[l])+"]");
													}else if(l==0){
														System.out.print("["+followupTestCase[l]+",");
														//writer.append('\n');
														writer.append("["+String.valueOf(followupTestCase[l])+",");
													}else{
														System.out.print(followupTestCase[l]+",");
														//writer.append('\n');
														writer.append(String.valueOf(followupTestCase[l])+",");
													}
													
												}
											}else if(followup_input_data[k] instanceof Double){
												double followupTestCase =(double) followup_input_data[k];
												System.out.println(followupTestCase+",");
												//writer.append('\n');
												writer.append(String.valueOf(followupTestCase)+",");
											}
											
										}
										System.out.print("]\n");
										//print result
										if(result==true){
											System.out.println("MR is satisfied");
											
										}else{
											System.out.println("MR is violated");
											//violated MR counter
											if(!Arrays.asList(violatedMR).contains(mrel.get(i).toString())){
												violatedMR.add(mrel.get(i).toString());	
											}
											//failed test case counter
											if(!Arrays.asList(failedTest).contains(i)){
												failedTest.add(i);
											}
												
										}
										   writer.append("]\n");
										   writer.append('\n');
										   writer.append("MR: "+mrel.get(i).toString());
										   writer.append('\n');
										   writer.append((result==true)?"MR is satisfied":"MR is violated");
										   writer.append('\n');  
										    	
										//coverage code
										//Runtime.getRuntime().exec("java -cp .;junit-4.10.jar -javaagent:C:/Users/p66n633/Dropbox/javaproject/MetaTest/src/jacocoagent.jar=append=false,dumponexit=true,classdumpdir=C:/Users/p66n633/Dropbox/javaproject/MetaTest/bin/class_dump_dir,destfile=C:/Users/p66n633/Dropbox/javaproject/MetaTest/jacoco.exec org.junit.runner.JUnitCore  testInput");
										//Runtime.getRuntime().exec("java -cp .;asm-all-5.0.4.jar;org.jacoco.report-0.7.6.201601131008.jar;org.jacoco.core-0.7.6.201601131008.jar;org.jacoco.ant-0.7.6.201601131008.jar;org.jacoco.agent-0.7.6.201601131008.jar ReportGenerator C:\\Users\\p66n633\\Dropbox\\javaproject\\MetaTest C:\\Users\\p66n633\\Dropbox\\javaproject\\MetaTest\\report");
										//coverage code end
										//For mutation testing using MRs and printing outputs
										//will not go in the main tool
										/*try
										{   
											String sFileName = "c:\\MRtest\\"+inputClass+"\\"+args[2].toString()+".csv";
											FileWriter writer = new FileWriter(sFileName,true);
										    File file = new File(sFileName);
										    if ( !file.exists() ){
										    	file.createNewFile();	
										    }
										    ArrayList mrel = (ArrayList) mrdesc.get(0);
									  // if(!System.getProperty("MRname").equals("buildClassifier_1")&&!System.getProperty("MRname").equals("buildClassifier_3")) { 
										   writer.append(methodName);
										   writer.append(',');
										   writer.append(args[3].toString());
										   writer.append(',');
										   writer.append(mrel.get(0).toString());
										   writer.append(',');
										   writer.append("test"+(i+1)); 
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
										}	*/
										
										//end mutation testing
											
										}
										
									}
									writer.append("Total MRs violated: "+violatedMR.size()+" out of "+countMR);
									writer.append('\n');
									writer.append("Total test cases failed: "+failedTest.size()+" out of "+ i);
									writer.append('\n');
									writer.flush();
									writer.close();
									System.out.println("Total MRs violated: "+violatedMR.size()+" out of "+countMR);
									System.out.println("Total test cases failed: "+failedTest.size()+" out of "+ i);
							    }else{
							    	System.out.println("Xml file not found");
							    }  
					}else{
						System.out.println(inputClass+".class file not found");
					}
			 }catch(Exception e){
				 System.out.println(e+" Input data mismatched. Please check your xml file.");
			 } 
	} 
	public static void main (String[] args){
		
	 }

}
