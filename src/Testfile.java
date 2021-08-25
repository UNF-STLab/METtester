import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Testfile {
		 public static void main (String[] args){
			 File fileData  = new File(args[0]);
			// String s = args[0];
			// int i =  Integer.parseInt(args[0]);
			 int[] initial_input ={};
			 if (fileData.exists()) {
				 try (Scanner xmlset = new Scanner(new File(args[0])))
					{	
			    		//String[] content = new String[200];
					// System.out.println("i am here 1");
			    		int i =0;
			    		while(xmlset.hasNextLine()){
			    			String message = xmlset.nextLine();
			    	        message = message.replace(" ", "");
			    	        String store[] = message.split(",");
			    	        initial_input = new int[store.length];
			    	        for(String s:store){
			    	        	initial_input[i] = Integer.parseInt(s);
			    	        	i++;
			    	        }
			    		}
			    		//System.out.println("i am here 2");
			    		int output = add_values(initial_input);
			    		//System.out.println("i am here"+ output);
						String sFileName = "C:/Users/psaha/workspace/MetaTest/src/output.txt";
						FileWriter writer = new FileWriter(sFileName,true);
						//System.out.println("i am here"+ output);
					    File file = new File(sFileName);
					    PrintWriter pw = new PrintWriter(file);
					   //System.out.println("work in progress...");
					   if (file.exists()){
						  // file.delete();
					    	//file.createNewFile();
						   //writer.write("");
						   pw.write("");
						    pw.flush(); 
						    pw.close();
					    	 writer.append(Integer.toString(output));
							 writer.flush();
							 writer.close();
					    }   
					} catch (IOException e) {
						//e.printStackTrace();
					}
			 }else{
				 System.out.println("file not found");
			 }
			
			// return add_values(initial_input);
		 }
	 public static  int add_values( int[] a )
			{
				int sum = 0;
				for (int i = 0; i < a.length; i++) {
				sum += a[i];
				}
				return sum;
			 }
	 public static  String test_method(int a,int b){
		 return "i am test_method";
	 	}
	 public static  int dot_product( int[] a, int[] b )
	    {
	        int sum = 0;
	        int i;
	        for (i = 0; i < a.length; i++) {
	            sum += a[i] * b[i];
	        }
	        return sum;
	    }
	 public static String palindrom(String text){
		 	String palindrome = text;//"Dot saw I was Tod";
	        int len = palindrome.length();
	        char[] tempCharArray = new char[len];
	        char[] charArray = new char[len];
	        
	        // put original string in an 
	        // array of chars
	        for (int i = 0; i < len; i++) {
	            tempCharArray[i] = 
	                palindrome.charAt(i);
	        } 
	        
	        // reverse array of chars
	        for (int j = 0; j < len; j++) {
	            charArray[j] =
	                tempCharArray[len - 1 - j];
	        }
	        
	        String reversePalindrome =
	            new String(charArray);
	        //System.out.println(reversePalindrome);
	        return reversePalindrome;
	 }
	 public static int vowelCounter(String text){
		 	String letters = text;//"Dot saw I was Tod";
		 	int count = 0; 
		 	for (char c : letters.toCharArray()) {
		 		switch (c) {
		 		case 'a': 
		 		case 'e':
		 		case 'i': 
		 		case 'o': 
		 		case 'u': 
		 			count++; 
		 		break; 
		 		default: // no count increment 
		 			} 
		 		} 
		 		
		 		return count;
	 }
	 }
