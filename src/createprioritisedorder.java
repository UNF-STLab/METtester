// creating prioritised MR order

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;

//import org.apache.commons.collections.ListUtils;												
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class createprioritisedorder extends xmlparseMR {
	public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException
	{
		// Create the mutant kill/alive sheet
		//String filename="/./"+"buildClassifier_result.csv";
		//modify by psaha
		XmlParser xp = new XmlParser();
		String methodName = xp.xmlMethodName(args[1]);
		String filename=".//src//mutants//"+methodName+".csv";
		//modify end
		Generate_Killed_Alive_Table gkal=new Generate_Killed_Alive_Table();
		 boolean flag2=false;
		String mutant_file=gkal.createkillalive(filename);
		
			
		ArrayList<Integer>  list = new ArrayList<Integer>();
		ArrayList<String>  list1 = new ArrayList<String>();
		ArrayList<String>  list2 = new ArrayList<String>();
		ArrayList<ArrayList<String>> parent = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> parent1 = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> parent2 = new ArrayList<ArrayList<String>>();
		String val1="";
		String strLine;
		//String txtfile="/home/madhu/sdb/Compact/bbmap_latestrun_august2018/yeastPIT_ecoli_major";
		Boolean flag=true;
		Boolean snap=false;
		
		
		// divide mutants into training and evaluation set
		
		// read the total number of mutants from the master file
		
		  FileInputStream fstream = new FileInputStream(mutant_file);
		//FileInputStream fstream = new FileInputStream("/./"+mutant_file);
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));

		
		while ((strLine = br.readLine()) != null)
		  {
			list1.add(strLine);
		  }
		  String[] split_value1 = list1.toArray(new String[list1.size()]);
		  for(int t=0;t<split_value1.length;t++)
		  {
		    
		    String val9=split_value1[t];
		    if((val9.indexOf("mutant")>=0))
		    {
		    	Integer index_num=val9.indexOf("M");
		    	String mutantval_training=val9.substring(index_num,val9.indexOf("\t"));
		    	list2.add(mutantval_training);
		    }
		  }
		
		  for(int iteration=0;iteration<1;iteration++)
		  {
			  
			  System.out.println();
			  System.out.print("****************************************************************************");
			  System.out.println();
			  System.out.print("Prioritised MR List");
			  System.out.println();

	//	Collections.shuffle(list2);
		
		// TODO Auto-generated method stub
		// divide the arraylist into training list and evaluation list
	
		Integer Training_list_size1=list2.size();
		double Training_list_size=Training_list_size1;  
			parent.clear();
		
	    // sort the shuffled list into training and evaluation
		for(int p=0;p<list2.size();p++)
		{
			
			if(p==0)
			{
				parent.add(new ArrayList<String>());
				//p=p+1;
			}
			if(p<Math.round(Training_list_size))
			{
				 val1=list2.get(p);
				parent.get(0).add(val1);
			}
			
			if(p==Math.round(Training_list_size))
			{
				val1=list2.get(p);
				parent.add(new ArrayList<String>());

			}
			if(p>Math.round(Training_list_size)-1)
			{
				 val1=list2.get(p);
				parent.get(1).add(val1);
				
			}
			
		}

		ranking(parent,split_value1,Training_list_size,mutant_file, args); //psaha


	}
	}
	//psaha
	public static void ranking(ArrayList<ArrayList<String>> parent, String[] split_value1,Double Training_list_size, String mutant_file, String[] args) throws IOException, ParserConfigurationException, SAXException
	{
		String strLine;
		ArrayList<String>  list1 = new ArrayList<String>();
		ArrayList<String>  list2 = new ArrayList<String>();
		ArrayList<String>  list3 = new ArrayList<String>();
		ArrayList<String>  list4 = new ArrayList<String>();
		ArrayList<String> storeval=new ArrayList<String>();
		ArrayList<String>  list5 = new ArrayList<String>();
		ArrayList<Integer>  list6 = new ArrayList<Integer>();
		ArrayList<Integer>  list7 = new ArrayList<Integer>();
		ArrayList<String> Evaluation_set=new ArrayList<String>();
		ArrayList<String>  ranked_trainingset = new ArrayList<String>();
		Boolean flag=true;
		Boolean cut=true;
		Boolean snap=false;
		Boolean catch1=false;
		int countlist=0;
		ArrayList<ArrayList<String>> parent1 = new ArrayList<ArrayList<String>>();

	// read the master excel sheet and get the killed or alive for each mutant

	FileInputStream fstream1 = new FileInputStream(mutant_file);
	//FileInputStream fstream1 = new FileInputStream("./"+mutant_file);
	DataInputStream in1 = new DataInputStream(fstream1);
	  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));


	while ((strLine = br1.readLine()) != null)
	  {
		list1.add(strLine);
	  }
	  String[] split_value = list1.toArray(new String[list1.size()]);
	  // iterate through each Mutant-parent array stores all the mutant 
	 for(int y=0;y<parent.get(0).size();y++)
	  {
		  String mutant_number=parent.get(0).get(y);
		
		  for(int t=1;t<split_value1.length;t++)
		  {
			  if(snap==true)
			  {
				  snap=false;
				  break;
			  }
		    
		    String val9=split_value1[t];
		    Integer index_num=val9.indexOf("M");
		    String mutantval_training=val9.substring(index_num,val9.indexOf("\t"));
		   // get all the pass and alive for each MR for the particular mutant
		    if(mutant_number.equals(mutantval_training))
		    {
		    	int p=0;
		    	String[] spltval=val9.split("\t");
		    	for(int j=1;j<spltval.length;j++)
		    	{
		    		String val4=spltval[j];
		    		if(flag==true)
		    		{
		    			parent1.add(new ArrayList<String>());
			    		
		    		}
		    		if(j==spltval.length-1)
		    		{
		    			flag=false;
		    			snap=true;
		    			//break;
		    		}
		    		parent1.get(p).add(val4+"-"+mutant_number);
		    		p=p+1;
		    		
		    	}
		    	
		    	
		    }
		  }
					  
	  }
	  

	 // get the count of Kill for each MR
	 ArrayList<String> rankingmr = new ArrayList<String>();
	 int n=0;
	 int m=1;
	 int countval=0;
	 DecimalFormat df = new DecimalFormat("###.00");
	 //String trainsize=df.format(Training_list_size);
	 String trainsize=Double.toString(Training_list_size).substring(0,Double.toString(Training_list_size).indexOf("."));
	 String trainingvalues1=list1.get(1);
	 String[] trainval1=trainingvalues1.split("\t");
	 

		 for(int u3=1;u3<=Integer.parseInt(trainsize);u3++)
		 {

			 String trainingvalues=list1.get(u3);
			 if(trainingvalues.indexOf("mutant")>=0)
			 {
			 String[] trainval=trainingvalues.split("\t");
			 String trainingval1=trainval[0].substring(trainval[0].indexOf("M"),trainval[0].length());
			 
			// if(mastertrainingval.equals(trainingval1))
			// {
				 String killalive=trainval[m];
				 if(killalive.equals("Killed"))
				 {
					 countval=countval+1;
					// cut=false;
					// break;
				 }
			 
			// }
			 }
			if((u3==Integer.parseInt(trainsize)))
				 //if((u2==parent.get(0).size()-1)&&(u3==list1.size()-1))
				 {
					 rankingmr.add("MR"+m+":"+countval);
					//u2=-1;
					 m=m+1;
					 countval=0;
					 u3=0;
					// break;
				 }
			if(m==trainval1.length)
			{
				break;
			}
		
		 }
		 
	 //}
	 
	 // Update and sort the list to provide the MR with maximum fault
	 ArrayList<Integer> dummylist=new ArrayList<Integer>();
	 ArrayList<Integer> dummylist1=new ArrayList<Integer>();
	 ArrayList<String> dummylist2=new ArrayList<String>();
	 Collections.shuffle(rankingmr);
	 for(int j=0;j<rankingmr.size();j++)
	 {
		 String getmr=rankingmr.get(j);
		String[] str1=getmr.split(":");
		 dummylist.add(Integer.parseInt(str1[1]));
		 			
	 }
	 for(int j1=0;j1<rankingmr.size();j1++)
	 {
	  Integer val5=Collections.max(dummylist);
	  dummylist1.add(val5);
	  dummylist.remove(dummylist.indexOf(val5));
	  if(dummylist.size()==0)
	  {
		  break;
	  }
	  	j1=j1-1;  
	 }
	 for(int m1=0;m1<dummylist1.size();m1++)
	 {
		 Integer number=dummylist1.get(m1);
		 for(int v=0;v<rankingmr.size();v++)
		 {
			 String checkmr=rankingmr.get(v);
			 String[] spltcheck=checkmr.split(":");
			 //String checkmr1=checkmr.substring(checkmr.indexOf("R")+1,checkmr.indexOf(":"));
			 if(Integer.parseInt(spltcheck[1])==(number))
			 {
				 dummylist2.add(checkmr);
				 rankingmr.remove(v);
				 break;
			 }
			 
		 }
	 }
	// round 1 is over, remove the mutants of the first MR in the list in other MRs also
	 String firstMR=dummylist2.get(0);
	 storeval.add(firstMR);
	 removeMR(dummylist2,list1, parent,trainsize,split_value1,storeval,args); //psaha
	 
	 
	}
		// remove the mutants in all the MR based on the mutants in the first MR 
	//psaha modified parameters
	 private static void removeMR(ArrayList<String> dummylist2, ArrayList<String> list1,
			ArrayList<ArrayList<String>> parent, String trainsize,String[] split_value1, ArrayList<String> storeval,String[] args) throws IOException, ParserConfigurationException, SAXException 
	 {

		 int m=0;
		 Boolean flag=true;
		 int b;
		 ArrayList<String> storetoremovemutant=new ArrayList<String>();
		 ArrayList<String> collectmutant=new ArrayList<String>();
		 String mr=dummylist2.get(0);
		 String[] spltmr=mr.split(":");
		 String mrval=spltmr[0].substring(spltmr[0].indexOf("R")+1,spltmr[0].length());
		 String getmrnumber=spltmr[1];
		// String getmrnumber=spltmr[0].substring(spltmr[0].indexOf("R"),spltmr[0].indexOf(":") );
		 Integer train=Integer.parseInt(trainsize);
//		 for(int b=1;b<=train;b++)
//		 {
//			 list1.remove(b);
//		 }
		for(b=1;b<list1.size();b++)
		{
			String getmutant=list1.get(b);
			String[] mutant=getmutant.split("\t");
			if(mutant[Integer.parseInt(mrval)].equals("Killed"))
			{
				collectmutant.add(getmutant);
		
			}
			m=m+1;
			if(m==train)
			{
				break;
			}
			
					
			
		}
		// remove the mutant from the parent list
		for(int v=0;v<collectmutant.size();v++)
		{
			String getval1=collectmutant.get(v);
			String[] spltval1=getval1.split("\t");
			for(int c=0;c<parent.get(0).size();c++)
			{
				String getparent=parent.get(0).get(c);
				if(getparent.equals(spltval1[0].substring(spltval1[0].indexOf("M"), spltval1[0].length())))
				{
					parent.get(0).remove(c);
					break;
				}
			}
		}
		// get the total mutant killed by each MR
		getmutantkilled(dummylist2,list1,parent,trainsize,split_value1,storeval,args); //psaha
	}

	 //psaha changed arguments
	 private static void getmutantkilled(ArrayList<String> dummylist2, ArrayList<String> list1, ArrayList<ArrayList<String>> parent,String trainsize,String[] split_value1,ArrayList<String> storeval, String[] args) throws IOException, ParserConfigurationException, SAXException 
	 {
	 	ArrayList<String> MRafterremoving=new ArrayList<String>();
	 	ArrayList<Integer> dummymr=new ArrayList<Integer>();
	 	
	 	ArrayList<Integer> dummymr1=new ArrayList<Integer>();
	 	ArrayList<String> Evaluation_set=new ArrayList<String>();
	 	ArrayList<ArrayList<String>> average = new ArrayList<ArrayList<String>>();
	 	 ArrayList<String> randomlist = new ArrayList<String>();
	 	ArrayList<String> getxmlMR = new ArrayList<String>();
		List<String> al = new ArrayList<>();							   
	 	ArrayList<Integer> numberlist = new ArrayList<Integer>();
	 	 ArrayList<String> collectmutant_number = new ArrayList<String>();
	 	ArrayList<String> countfault=new ArrayList<String>();
		ArrayList<String> storexmldata=new ArrayList<String>();
	 	ArrayList<String> finalorder=new ArrayList<String>();
	 	ArrayList<String> finalorder1=new ArrayList<String>();
	 	ArrayList<String> MR_size=new ArrayList<String>();
	 	String[] spltsum = null;
	 	int n=1;
	 	int count_mr=0;
	 	String strLine;
	 	Boolean flag=true;
	 	String removeddecimal=null;	
	 	int m=1;
	 	int counter=0;
	 	Boolean flag1=true;
	 	Boolean flag_check=true;
	 	String finalval="";
	 	int counter1=0;
	 	String concatval="";
	 	int j=0;
	 	int count=0;
	 		for(int v=0;v<parent.get(0).size();v++)
	 		{
	 			
	 			String getparent=parent.get(0).get(v);
	 			for(int x=1;x<list1.size();x++)
	 			{
	 				String listval=list1.get(x);
	 				 spltsum=listval.split("\t");
	 				if(spltsum[0].substring(spltsum[0].indexOf("M"),spltsum[0].length()).equals(getparent))
	 				{
	 					if(spltsum[m].equals("Killed"))
	 					{
	 						count=count+1;
	 						break;
	 					}
	 					else
	 					{
	 						break;
	 					}
	 				}
	 			}
	 			if(v==parent.get(0).size()-1)
	 			{
	 				countfault.add("MR"+m+":"+count);
	 				counter=counter+1;
	 				count=0;
	 				v=-1;
	 				m=m+1;
	 			}
	 			if(counter==spltsum.length-1)
	 			{
	 				break;
	 			}
	 		}
	 		
	 		// order the MRs based on the total mutant killed
	 		Collections.shuffle(countfault);
	 		for(int m1=0;m1<countfault.size();m1++)
	 		{
	 			String getMR=countfault.get(m1);
	 			String[] spltmr=getMR.split(":");
	 			dummymr.add(Integer.parseInt((spltmr[1])));
	 			dummymr1.add(Integer.parseInt((spltmr[1])));
	 			
	 		}
	 		// get max from the list
	 		//Collections.sort(dummymr1);
	 		for(int m2=0;m2<=dummymr.size();m2++)
	 		{
	 			if(flag==false)
	 			{
	 				//flag=true;
	 				break;
	 			}
	 			if(dummymr.size()==0)
	 			{
	 				break;
	 			}
	 		Integer findmax=Collections.max(dummymr);
	 		for(int h=0;h<countfault.size();h++)
	 		{
	 			String getcount=countfault.get(h);
	 			String[] spltcount=getcount.split(":");
	 			if(spltcount[1].equals(Integer.toString(findmax)))
	 			{
	 				finalorder.add(getcount);
	 				dummymr.remove(h);
	 				countfault.remove(h);
	 				m2=m2-1;
	 				break;
	 			}
	 		}
	 		}
	 		if(countfault.size()==0)
	 		{
	 			// if the all the MRs are zero, the final order for the ranked can be generated
	 			for(int v=0;v<finalorder.size();v++)
	 			{
	 			
	 				String getval1=finalorder.get(v);
	 			
	 				String[] spltval=getval1.split(":");
	 				if(Integer.parseInt(spltval[1])==0)
	 				{
	 					counter1=counter1+1;
	 					
	 				}
	 				if(v==finalorder.size()-1)
	 				{
	 					finalval=finalorder.get(0);
	 					storeval.add(finalval);
	 					
	 					if(counter1==finalorder.size()-1)
	 					{
	 						 // Rank Evaluation Set
	 						 
	 						 // Generate the evaluation set
	 						String[] spltmrheader=list1.get(0).split(" ");
	 						for(int v1=0;v1<spltmrheader.length;v1++)
	 						{
	 							flag1=true;
	 							String header=spltmrheader[v1];
	 							String getheader=header.substring(header.indexOf("R")+1,header.length());
	 							for(int v2=0;v2<storeval.size();v2++)
	 							{
	 								String gettheval=storeval.get(v2);
	 								String[] splttheval=gettheval.split(":");
	 								if(splttheval[0].equals(header))
	 								{
	 									flag1=false;
	 									break;
	 								}
	 								if((v2==storeval.size()-1)&&(flag1==true))
	 								{
	 									storeval.add(header+":"+"0");
	 									break;
	 								}
	 							}
	 						}
						}
	 					else
	 					{
	 						 // Generate the evaluation set
	 						String[] spltmrheader=list1.get(0).split(" ");
	 						for(int v1=0;v1<spltmrheader.length;v1++)
	 						{
	 							flag1=true;
	 							String header=spltmrheader[v1];
	 							String getheader=header.substring(header.indexOf("R")+1,header.length());
	 							for(int v2=0;v2<storeval.size();v2++)
	 							{
	 								String gettheval=storeval.get(v2);
	 								String[] splttheval=gettheval.split(":");
	 								if(splttheval[0].equals(header))
	 								{
	 									flag1=false;
	 									break;
	 								}
	 								if((v2==storeval.size()-1)&&(flag1==true))
	 								{
	 									storeval.add(header+":"+"0");
	 									break;
	 								}
	 							}
	 						}
	 					}
	 				}
	 			}
	 			
	 			// when parent size is zero or when all the mutants is removed
		 		// create countfault array
	 			
	 	if(parent.get(0).size()==0)
	 	{
	 		storeval.clear();
	 		for(int n1=0;n1<dummylist2.size();n1++)
	 		{
	 			String val1=dummylist2.get(n1);
	 			String[] spltmr=val1.split(":");
	 			if(n1==0)
	 			{
	 				storeval.add(val1);
	 			}
	 			else
	 			{
	 				storeval.add(spltmr[0]+":"+"0");
	 			}
	 		
	 		}
	 	}
	 						
	 						// read xml file and get the list of MR name
	 						NodeList nList = xmlparser(args[1]);//psaha
	 						Node nNode = nList.item(0);
	 						int inputparam = 0;
	 						ArrayList mrDesc = new ArrayList();
	 						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 				             Element eElement = (Element) nNode;
	 				             inputparam = Integer.parseInt(eElement
	 				                     .getElementsByTagName("INPUTPARAM")
	 				                     .item(0)
	 				                     .getTextContent());
	 				             
	 				          //   System.out.println("METHODNAME : " 
	 				           //          + eElement
	 				          //           .getElementsByTagName("MRDESCRIPTOR").getLength());
	 				             
	 				             NodeList nodeMR = eElement.getElementsByTagName("MRDESCRIPTOR");
	 				             //loop through each mr description
	 				             ArrayList mrInput = new ArrayList(1);
	 				             ArrayList mrOutputOperator = new ArrayList(1);
	 				             
	 				             for(int temp = 0; temp < nodeMR.getLength(); temp++){
	 				            	 ArrayList mrItem = new ArrayList(1);
	 				            	 Node mrNode = nodeMR.item(temp);
	 				            	 Element eMRElement = (Element) mrNode;
	 				            	 NodeList nodeMRparam = eMRElement.getElementsByTagName("PARAM");
	 				            	 
	 				            	 for(int tempParam = 0; tempParam < nodeMRparam.getLength(); tempParam++){
	 				            		 //mrName.clear();
	 				            		 ArrayList mrName = new ArrayList(1);
	 				            		 Node mrParamNode = nodeMRparam.item(tempParam);
	 				                	 Element eMRParamElement = (Element) mrParamNode;

	 				                	 String mrname=eMRParamElement
	 				                              .getElementsByTagName("PARAMNAME") 
	 				                              .item(0)
	 				                              .getTextContent();
	 				                	 String paramval=(eMRParamElement
	 				                             .getElementsByTagName("PARAMVAL") 
	 				                             .item(0)
	 				                             .getTextContent());
	 				                	 
	 				                	 String concat=mrname+"-"+paramval;
	 				                	getxmlMR.add(mrname);
	 				                	// withduplicate.add(concat);
	 				                
	 				            	 }
	 				         
	 				            	  
	 				             }
	 						}
//	 						Set<String> hs = new HashSet<>();
//	 					   
//	 					    hs.addAll(getxmlMR);
//	 						//ListUtils.removeDuplicate(getxmlMR);
//	 					   Object[] myArr = hs.toArray();  
//	 						for(int c9=0;c9<storeval.size();c9++)
//	 						{
//	 							String c2=storeval.get(c9);
//	 							String[] spltvalmr=c2.split(":");
//	 							String getmrname=c2.substring(c2.indexOf("R")+1,c2.indexOf(":"));
//	 							for(int b=0;b<myArr.length;b++)
//	 							{
//	 								String val1=(String) myArr[b];
//	 								if(b+1==Integer.parseInt(getmrname))
//	 								{
//	 									System.out.println(" ");
//	 									System.out.println(val1+":"+spltvalmr[1]+"(Killed)");
//	 									break;
//	 								}
//	 							}
//	 							//ArrayList<String> a1=xmlparseMR.main(flag_check);
//	 							
//	 						}
	 						 Set<String> hs = new HashSet<>();
	                            hs.clear();
	                             hs.addAll(getxmlMR);
	                            // getxmlMR.addAll(hs);
	                             //ListUtils.removeDuplicate(getxmlMR);
	                            List<Object> deDupStringList3 = getxmlMR.stream().distinct().collect(Collectors.toList());
	                            Object[] myArr = deDupStringList3.toArray();  
	                             for(int c9=0;c9<storeval.size();c9++)
	                             {
	                                 String c2=storeval.get(c9);
	                                 String[] spltvalmr=c2.split(":");
	                                 String getmrname=c2.substring(c2.indexOf("R")+1,c2.indexOf(":"));
	                                 for(int b=0;b<myArr.length;b++)
	                                 {
	                                     String val1=(String) myArr[b];
	                                     if(b+1==Integer.parseInt(getmrname))
	                                     {
	                                         System.out.println(" ");
	                                         System.out.println(val1+":"+spltvalmr[1]+"(Killed)");
	                                         break;
	                                     }
	                                 }
	                                 //ArrayList<String> a1=xmlparseMR.main(flag_check);
	                                 
	                             }
	 						
	 						//Get the number of MRs to run from the user
	 						
	 						Scanner sc=new Scanner(System.in);  
	 						System.out.println("Enter the number of MRs to run");
	 						  Integer MR_number=sc.nextInt();  
	 						
	 						 for(int c1=0;c1<storeval.size();c1++)
		 						{
		 							String c2=storeval.get(c1);
		 							MR_size.add(c2);
		 							count_mr=count_mr+1;
		 							if(count_mr==MR_number)
		 							{
		 								break;
		 							}
		 						}
	 						  
	 						 xmlparseMR xml=new xmlparseMR();
	 						 String [] list = MR_size.toArray(new String[MR_size.size()+1]);
	 						 list[list.length-1] = args[1];//psaha added xml file path to the end of array
	 						 xml.main(list);	
	 						 //flag2=true;
	 						//generateorder_evaluationset(storeval,list1,parent,trainsize,split_value1,Evaluation_set_size);
	 						flag=false;
	 					//	break;
	 					}
	 					else
	 					{
	 					//	removeMR(finalorder, list1, parent,trainsize,split_value1,storeval,args);//psaha
	 						//break;
	 						
	 					}
	 				}		 
	 			//}
	 		//}
	 		//}
	 //}

		
				}


