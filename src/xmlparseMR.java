// Writing the prioritised MR order to xml file

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;
import java.util.stream.Collectors;								   

public class xmlparseMR {
	public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException
	{
		ArrayList<String>  list2 = new ArrayList<String>();
		ArrayList<String>  list3 = new ArrayList<String>();
	  for(int b=0;b<args.length-1;b++)
	  {
		 String valmr= args[b];
		 list2.add(valmr);
	  }
	 // xmlMrDesc("/./"+"MetaTest1/src/MethodsFromColt/meanDeviation.xml",list2);
	  Boolean flag1=true;
	xmlMrDesc(args[args.length-1],list2);//psaha changed path
	}
		public static NodeList xmlparser(String inputFileName){
			NodeList nList = null ;
			 try {	
		         File inputFile = new File(inputFileName);
		         DocumentBuilderFactory dbFactory 
		            = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
		       //  System.out.println("Root element :" 
		       //     + doc.getDocumentElement().getNodeName());
		         nList = doc.getElementsByTagName("METHODDESCRIPTOR");
		         
			 }catch (Exception e) {
				// e.printStackTrace();
				 System.out.println("Tag mismatch in input XML file. " );
			 }
			return nList;
			// xmlMrDesc("/home/madhu/sdb/Compact/downloads/MetaTest/src/MethodsFromColt/weightedMean.xml");
		}
		public static void xmlMrDesc(String inputFileName,ArrayList<String> list2) throws IOException{
			String strLine;
			int j=0;
			int counter=0;
			int mr_descriptior_count=0;
			String operatorval="";
			Boolean flag=true;
			ArrayList<String>  list1 = new ArrayList<String>();
			ArrayList<String>  final_list = new ArrayList<String>();
			//BufferedWriter writer = new BufferedWriter(new FileWriter("/./"+"/src/MethodsFromColt/meandeviation1.xml"));
			//modify inputfile name psaha
			String newinputFile = inputFileName.substring(0, inputFileName.indexOf(".xml")).concat("_order.xml");
			 BufferedWriter writer = new BufferedWriter(new FileWriter(newinputFile));//psaha
			  strLine="";
			  ArrayList<String>  storexmldata = new ArrayList<String>();
			ArrayList<String>  withduplicate = new ArrayList<String>();
			ArrayList<String>  priortisedlist = new ArrayList<String>();
			
			NodeList nList = xmlparser(inputFileName);
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
	                	 String paramitem=(eMRParamElement
	                             .getElementsByTagName("PARAMITEM") 
	                             .item(0)
	                             .getTextContent());
	                	 String operator=(eMRElement
	                             .getElementsByTagName("OPERATOR") 
	                             .item(0)
	                             .getTextContent());
	                	 
	                	 String concat=mrname+"-"+paramval+"-"+paramitem+"-"+operator;
	                	 //String concat=mrname+"-"+paramval;
	                	 list1.add(mrname);
	                	 withduplicate.add(concat);
	                
	            	 }
	         
	            	  
	             }
	             mrDesc.add(mrInput);
	             mrDesc.add(mrOutputOperator);
	           //  System.out.println("METHODNAME : " + mrDesc+"\n");
			 }
	       
			 HashSet<String> set = new HashSet<String>(list1);
			 
	        //Constructing listWithoutDuplicateElements using set
	 
	        ArrayList<String> listWithoutDuplicateMRS = new ArrayList<String>(set);

	       List<Object> deDupStringList3 = list1.stream().distinct().collect(Collectors.toList());
           // put reararange the MR order
	        for(int c=0;c<list2.size();c++)
	        {
	        	String getthemr=list2.get(c);
	        	String getthemrnumber=getthemr.substring(getthemr.indexOf("R")+1,getthemr.indexOf(":"));
	        	String prioritisemr=(String) deDupStringList3.get(Integer.parseInt(getthemrnumber)-1);
	        	priortisedlist.add(prioritisemr);
	        }
	        
	        // prioritise the duplicate list
	        for(int g=0;g<priortisedlist.size();g++)
	        {
	        	String valprioritse=priortisedlist.get(g);
	        	for(int g1=0;g1<withduplicate.size();g1++)
	        	{
	        		String valgetduplicate=withduplicate.get(g1);
	        		String[] getduplicate=valgetduplicate.split("-");
	        		if(getduplicate[0].equals(valprioritse))
	        		{
	        			final_list.add(valgetduplicate);
	        		}
	        			
	        			
	        	}
	        	
	        }
		
	       // FileInputStream fstream1 = new FileInputStream("/./"+"/src/MethodsFromColt/meanDeviation.xml");
	       FileInputStream fstream1 = new FileInputStream(inputFileName);//psaha
	        DataInputStream in1 = new DataInputStream(fstream1);
			  BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
	      
				
while ((strLine = br1.readLine()) != null)
{

	storexmldata.add(strLine);
}

String[] split_value1 = storexmldata.toArray(new String[storexmldata.size()]);
		 
for(int d1=0;d1<split_value1.length;d1++)
{
	  flag=true;
	
	  String getval=split_value1[d1];
	  //String getoperatorval=final_list.get(j);
	
	
	  
	  if((getval.indexOf("MRDESCRIPTOR")>=0))
			  
	  {
		  String mrdesc=getval.substring(getval.indexOf("<")+1,getval.indexOf(">"));
		  if(mrdesc.indexOf("/")<0)
		  {
			  mr_descriptior_count=mr_descriptior_count+1;
		  }
	  }
	  if(mr_descriptior_count>list2.size())
	  {
		  writer.newLine();
		  writer.write("</METHODDESCRIPTOR>");
		  writer.newLine();
		  writer.write("</TESTDESCRIPTOR>");
		  break;
	  }
	  if((getval.indexOf("PARAMNAME")>=0))
	  {
		
		  String getnewmr=final_list.get(j);
		  String[] spltmr=getnewmr.split("-");
		  String getoldmr=getval.substring(getval.indexOf(">")+1,getval.indexOf("/")-1);
		  String replacedval=getval.replace(getoldmr, spltmr[0]);
		  writer.write(replacedval);
		
		  writer.newLine();
		  counter=counter+1;
		  flag=false;
		 // writer.close();
	 
		//  j=j+1;
	  }
	  if(getval.indexOf("PARAMVAL")>=0)
	  {
		  String getnewmr=final_list.get(j);
		  String[] spltoperatorval=getnewmr.split("-");
		  operatorval=spltoperatorval[3];
		  String[] spltmr=getnewmr.split("-");
		  String getoldmr=getval.substring(getval.indexOf(">")+1,getval.indexOf("/")-1);
		  if(spltmr.length>1)
		  {
			  if(getoldmr.indexOf("")>=0)
			  {
				  writer.write("<PARAMVAL>"+spltmr[1]+"</PARAMVAL>");
				 // final_list.remove(j);
				//  j=j+1;
				  writer.newLine();
				  counter=counter+1;
				  final_list.remove(j);
				  flag=false;
			  }
			  else
			  {
			  String replacedval=getval.replace(getoldmr, spltmr[1]);
			  writer.write(replacedval);
			  writer.newLine();
			  counter=counter+1;
			  final_list.remove(j);
			//  j=j+1;
			  flag=false;
			  }
		  }
		  else
		  {
			  String replacedval=getval.replace(getoldmr,"");
			  writer.write(replacedval);
			  writer.newLine();
			  counter=counter+1;
			  final_list.remove(j);
			 // j=j+1;
			  flag=false;
		  }
	  }
		  
		  if(getval.indexOf("PARAMITEM")>=0)
		  {
			  String getnewmr1=final_list.get(j);
			  String[] spltmr1=getnewmr1.split("-");
			  String getoldmr1=getval.substring(getval.indexOf(">")+1,getval.indexOf("/")-1);
			  if(spltmr1.length>2)
			  {
				  if(getoldmr1.indexOf("")>=0)
				  {
					  writer.write("<PARAMITEM>"+spltmr1[2]+"</PARAMITEM>");
					  counter=counter+1;
					  //final_list.remove(j);
					//  j=j+1;
					  writer.newLine();
					  flag=false;
				  }
			  }
				  else
				  {
					  writer.write("<PARAMITEM>"+""+"</PARAMITEM>");
				  //String replacedval=getval.replace(getoldmr1, spltmr1[2]);
				 // writer.write(replacedval);
				  writer.newLine();
				counter=counter+1;
				 // final_list.remove(j);
				//  j=j+1;
				  flag=false;
				  }

		
		  
	  }
		  
		  if(getval.indexOf("OPERATOR")>=0)
		  {
			//  String getnewmr1=final_list.get(j);
		//	  String[] spltmr1=getnewmr1.split("-");
		//	  String getoldmr1=getval.substring(getval.indexOf(">")+1,getval.indexOf("/")-1);
		//	  if(spltmr1.length>2)
		//	  {
			//	  if(getoldmr1.indexOf("")>=0)
			//	  {
				
					  writer.write("<OPERATOR>"+operatorval+"</OPERATOR>");
					 
					  writer.newLine();
					  flag=false;
				//  }
			//  }
				//  else
			//	  {
				//	  writer.write("<OPERATOR>"+""+"</OPERATOR>");
				
					  writer.newLine();
				//
				//	  flag=false;
			//	  }

		
		  
	  }
		  if(counter==3)
		  {
			 // if(final_list.get(index))
			//  j=j+2;
			  counter=0;
		
		  }
	  if(flag==true)
	  {
		 writer.write(getval);
			writer.newLine();
	  }


}
writer.close();
//return list1;

// System.out.print("Hello");

}	
}

// Write to XML with the prioritised order




//	}

//}
//}