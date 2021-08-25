
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.*;
public class XmlParser {
	public static void main(String[] args){
	}
	public NodeList xmlparser(String inputFileName){
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
	}
	
	public String xmlMethodName(String inputFileName){
		NodeList nList = xmlparser(inputFileName);
		Node nNode = nList.item(0);
		String methodname = null;
		// System.out.println("\nCurrent Element :" 
	    //           + nNode.getNodeName());
		 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             //System.out.println("METHODNAME : " 
             ///   + eElement
             //  .getElementsByTagName("METHODNAME")
             //   .item(0)
             //   .getTextContent());
             methodname =  eElement
             .getElementsByTagName("METHODNAME")
             .item(0)
             .getTextContent();
		 }
		 
		return methodname;
	}
	
	public int xmlParam(String inputFileName){
		NodeList nList = xmlparser(inputFileName);
		Node nNode = nList.item(0);
		int inputparam = 0;
		// System.out.println("\nCurrent Element :" 
	    //           + nNode.getNodeName());
		 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             inputparam = Integer.parseInt(eElement
                     .getElementsByTagName("INPUTPARAM")
                     .item(0)
                     .getTextContent());
		 }
		 
		return inputparam;
	}
	
	public ArrayList xmlParamType(String inputFileName){
		NodeList nList = xmlparser(inputFileName);
		Node nNode = nList.item(0);
		ArrayList paramType = new ArrayList();
		// System.out.println("\nCurrent Element :" 
	    //           + nNode.getNodeName());
		 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
             Element eElement = (Element) nNode;
             NodeList nodePT = eElement.getElementsByTagName("INPUTDATATYPE");
             for(int temp = 0; temp < nodePT.getLength(); temp++){
            	 Node mrParamType = nodePT.item(temp);
            	// Element eParamType = (Element) mrParamType;
            	 paramType.add(mrParamType.getFirstChild()
                         .getTextContent());
             }
		 }
		 
		return paramType;
	}
	
	public ArrayList xmlInitialInput(String inputFileName){
		NodeList nList = xmlparser(inputFileName);
		Node nNode = nList.item(0);
		ArrayList initialInput = new ArrayList();
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            int inputparam = Integer.parseInt(eElement
                    .getElementsByTagName("INPUTPARAM")
                    .item(0)
                    .getTextContent());
            NodeList nodeII = eElement.getElementsByTagName("INPUTDESCRIPTOR");
            for(int temp = 0; temp < nodeII.getLength(); temp++){
            	ArrayList inputItem = new ArrayList(1);
           	 	Node iiNode = nodeII.item(temp);
           	 	Element eIIElement = (Element) iiNode;
           	 	NodeList nodeIIparam = eIIElement.getElementsByTagName("INPUT");
	           	 for(int tempParam = 0; tempParam < nodeIIparam.getLength(); tempParam++){
	        		 ArrayList iniInput = new ArrayList(1);
	        		 Node mrParamNode = nodeIIparam.item(tempParam);
	        		 iniInput.add(mrParamNode.getFirstChild()
	                         .getTextContent());
	        		 inputItem.add(iniInput);
	           	 }
	           	//System.out.println("METHODNAME : " + inputItem+"\n");
	           	initialInput.add(inputItem);
            }
            //System.out.println("METHODNAME : " + initialInput+"\n");
		}
		return initialInput;
	}
	//gathering input parameter info for random test case
	public ArrayList inputParamInfo(String xmlFileName){
		ArrayList inputParam = new ArrayList();
		NodeList nList = xmlparser(xmlFileName);
		Node nNode = nList.item(0);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            int inputparam = Integer.parseInt(eElement
                    .getElementsByTagName("INPUTPARAM")
                    .item(0)
                    .getTextContent());
            inputParam.add(inputparam);
		}
		return inputParam;
	}
	
	public ArrayList xmlMrDesc(String inputFileName){
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

                	 mrName.add(eMRParamElement
                              .getElementsByTagName("PARAMNAME") 
                              .item(0)
                              .getTextContent());
                	 
                	 //array of MR items
                	 
                	 mrName.add(eMRParamElement
                             .getElementsByTagName("PARAMITEM") 
                             .item(0)
                             .getTextContent());
                	 
                	//array of MR constant value

                	 mrName.add(eMRParamElement
                            .getElementsByTagName("PARAMVAL") 
                            .item(0)
                            .getTextContent());
                	 //each param value is addaed in mr
                	 mrItem.add(mrName);
                	// System.out.println("METHODNAME : " + mrName+"\n");
                	// System.out.println("METHODNAME : " + mrItem+"\n");
            	 }
            	 //each mr added as input
            	 mrInput.add(mrItem);
            	//array of MR output operator
            	 mrOutputOperator.add(eMRElement
                         .getElementsByTagName("OPERATOR") 
                         .item(0)
                         .getTextContent());
            	  
             }
             mrDesc.add(mrInput);
             mrDesc.add(mrOutputOperator);
           //  System.out.println("METHODNAME : " + mrDesc+"\n");
		 }
		return mrDesc;
		
	}
}
