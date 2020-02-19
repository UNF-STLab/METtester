import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.junit.*;

public class initialTestInput {
	public static void main(String[] args){
	}
	public Object[]  initialTestInput(Object input_data, ArrayList data_type){
		ArrayList inputArray =new ArrayList();
		inputArray = (ArrayList) input_data;
		Object[] initialData = new Object[data_type.size()];
		for(int i=0;i<data_type.size();i++){
			//System.out.println(inputArray.get(i));
			 String input_line_scanner =inputArray.get(i).toString();
			 input_line_scanner = input_line_scanner.substring(input_line_scanner.indexOf("[")+1, input_line_scanner.indexOf("]"));
			 //System.out.println(input_param[0]);
			String data = (String) data_type.get(i);
			String[] data_arr = data.split(",");
			try{
				if(data_arr.length > 1){//its an array
					 String[] input_param = input_line_scanner.split(",");
		       		 switch(data_arr[0]){
		       		 case "int":
		       			int[] a = new int[input_param.length];
		       			for(int count=0; count< input_param.length;count++){
		    	        	a[count]= Integer.parseInt(input_param[count]);
		    	        	//System.out.println(a[count]);
		    	        }
		       			initialData[i] = a;
		       			 break;
		       		 case "double":
		       			double[] b = new double[input_param.length];
		       			for(int count=0; count< input_param.length;count++){
		    	        	b[count]= Double.parseDouble(input_param[count]);
		    	        	//System.out.println(a[count]);
		    	        }
		       			initialData[i] = b;
		       			 break;
		       		 case "string":
		        			initialData[i] = input_param;
		        			break;	
		        	 default:
		        		 System.out.println("Wrong data type.");
		        		 break;
		       		 }
			    	        
			    	 }else{//normal data type
			    	 String input_param = input_line_scanner;
			    	 switch(data_arr[0]){
		       		 case "int":
		       			 int c =Integer.parseInt(input_param);
		       			 initialData[i] = c;
		       			 //System.out.println(c);
		       			break;
		       		 case "double":
		       			Double d = Double.parseDouble(input_param);
		      			 initialData[i] = d;
		       			break;
		       		 case "string":
		       			initialData[i] = input_param;
		       			break;
		       		 default:
		        		 System.out.println("Wrong data type.");
		        		 break;	
		       		 }	
			    	 } 
			 }catch(Exception e){
				 System.out.println("Wrong Data type given.");
			 }
			
		}
		//runTest(testClassName, methodName, initialData);
		
		return initialData;	
	}
	@Test
	public Object[] followupTestInput(Object[] initial_inputdata,ArrayList mrList,ArrayList data_type){
		//ArrayList inputArray =new ArrayList();
		//inputArray = (ArrayList) initial_inputdata;
		Object[] followupData = new Object[data_type.size()];
		FrameMethod fm = new FrameMethod();
		for(int i=0;i<data_type.size();i++){
			ArrayList mrDesc = (ArrayList) mrList.get(i);
			if (initial_inputdata[i] instanceof int[]){
				int[] initialTestCase =(int[]) initial_inputdata[i];
				int constVal= 0;
				int constItem = 0;
				if(mrDesc.get(2).toString().equals("")){
					constVal = 0;
				}else{
					constVal =  Integer.parseInt(mrDesc.get(2).toString());
				}
				if(mrDesc.get(1).toString().equals("")){
					 constItem = 0;
				}else{
					 constItem =  Integer.parseInt(mrDesc.get(1).toString());
				}
				System.out.println("MR name: "+mrDesc.get(0).toString());
				switch(mrDesc.get(0).toString())
				{
				case "ADD":
					//System.out.println(constVal);
					followupData[i] = fm.add(initialTestCase, constVal);
					//return followupData;
					break;
				case "MUL":
					followupData[i] =  fm.mult(initialTestCase, constVal);
					//return followuptc;
					break;
				case "SHUFFLE":
					followupData[i] =  fm.perm(initialTestCase);
					//return followuptc;
					break;
				case "INCLUDE":
					followupData[i] =  fm.inc(initialTestCase,constItem, constVal);
					//return followuptc;
					break;
				case "INVERSE":
					followupData[i] =  fm.inv(initialTestCase);
					//return followuptc;
					break;
				case "EXCLUDE":
					followupData[i] =  fm.exc(initialTestCase,constItem);
					//return followuptc;
					break;
				default:
	        		 System.out.println("Wrong Metamorphic relation.");
	        		 break;	
				}
			}else if(initial_inputdata[i] instanceof Integer){
				int initialTestCase =(int) initial_inputdata[i];
				int constVal= 0;
				int constItem = 0;
				if(mrDesc.get(2).toString().equals("")){
					constVal = 0;
				}else{
					constVal =  Integer.parseInt(mrDesc.get(2).toString());
				}
				if(mrDesc.get(1).toString().equals("")){
					 constItem = 0;
				}else{
					 constItem =  Integer.parseInt(mrDesc.get(1).toString());
				}
				System.out.println("MR name: "+mrDesc.get(0).toString());
				switch(mrDesc.get(0).toString())
				{
				case "ADD":
					//System.out.println(constVal);
					followupData[i] = fm.add(initialTestCase, constVal);
					//return followupData;
					break;
				case "MUL":
					followupData[i] =  fm.mult(initialTestCase, constVal);
					//return followuptc;
					break;
				case "SHUFFLE":
					followupData[i] =  fm.perm(initialTestCase);
					//return followuptc;
					break;
				case "INCLUDE":
					followupData[i] =  initialTestCase;//fm.inc(initialTestCase,constItem, constVal);
					//return followuptc;
					break;
				case "INVERSE":
					followupData[i] =  fm.inv(initialTestCase);
					//return followuptc;
					break;
				case "EXCLUDE":
					followupData[i] =  initialTestCase;//fm.exc(initialTestCase,constItem);
					//return followuptc;
					break;
				default:
	        		 System.out.println("Wrong Metamorphic relation.");
	        		 break;	
				}
				//followupData[i] =(int) initial_inputdata[i];
			}else if(initial_inputdata[i] instanceof String){
				String initialTestCase =(String) initial_inputdata[i];
				String constVal= "";
				int constItem = 0;
				if(mrDesc.get(2).toString().equals("")){
					constVal = "";
				}else{
					constVal =  mrDesc.get(2).toString();
				}
				if(mrDesc.get(1).toString().equals("")){
					 constItem = 0;
				}else{
					 constItem =  Integer.parseInt(mrDesc.get(1).toString());
				}
				System.out.println("MR name: "+mrDesc.get(0).toString());
				switch(mrDesc.get(0).toString())
				{
				case "REVERSE":
					followupData[i] =  fm.rev(initialTestCase);
					//return followuptc;
					break;
				case "INCLUDE":
					followupData[i] =  fm.inc(initialTestCase,constItem, constVal);
					//return followuptc;
					break;
				case "EXCLUDE":
					followupData[i] =  fm.exc(initialTestCase,constItem);
					//return followuptc;
					break;
				default:
	        		 System.out.println("Wrong Metamorphic relation.");
	        		 break;		
				}
				//followupData[i] =(int) initial_inputdata[i];
			}else if (initial_inputdata[i] instanceof double[])
			{
				double[] initialTestCase=(double[])initial_inputdata[i];
				double constVal= 0;
				int constItem = 0;
				if(mrDesc.get(2).toString().equals("")){
					constVal = 0;
				}else{
					constVal =  Double.parseDouble(mrDesc.get(2).toString());
				}
				if(mrDesc.get(1).toString().equals("")){
					 constItem = 0;
				}else{
					 constItem =  Integer.parseInt(mrDesc.get(1).toString());
				}
				System.out.println("MR name: "+mrDesc.get(0).toString());
				switch(mrDesc.get(0).toString())
				{
				case "ADD":
					followupData[i] = fm.add(initialTestCase, constVal);
					//return followupData;
					break;
				case "MUL":
					followupData[i] = fm.mult(initialTestCase, constVal);
					//return followupData;
					break;			
				case "SHUFFLE":
					followupData[i] = fm.perm(initialTestCase);
					//return followupData;
					break;
				case "INCLUDE":
					followupData[i] =  fm.inc(initialTestCase,constItem, constVal);
					//return followuptc;
					break;
				case "INVERSE":
					followupData[i] =  fm.inv(initialTestCase);
					//return followuptc;
					break;
				case "EXCLUDE":
					followupData[i] =  fm.exc(initialTestCase,constItem);
					//return followuptc;
					break;
				default:
	        		 System.out.println("Wrong Metamorphic relation.");
	        		 break;		
				}
			}
			else if(initial_inputdata[i] instanceof Double){
				double initialTestCase=(double)initial_inputdata[i];
				double constVal= 0;
				int constItem = 0;
				if(mrDesc.get(2).toString().equals("")){
					constVal = 0;
				}else{
					constVal =  Double.parseDouble(mrDesc.get(2).toString());
				}
				if(mrDesc.get(1).toString().equals("")){
					 constItem = 0;
				}else{
					 constItem =  Integer.parseInt(mrDesc.get(1).toString());
				}
				System.out.println("MR name: "+mrDesc.get(0).toString());
				switch(mrDesc.get(0).toString())
				{
				case "ADD":
					followupData[i] = fm.add(initialTestCase, constVal);
					//return followupData;
					break;
				case "MUL":
					followupData[i] = fm.mult(initialTestCase, constVal);
					//return followupData;
					break;			
				case "SHUFFLE":
					followupData[i] = fm.perm(initialTestCase);
					//return followupData;
					break;
				case "INCLUDE":
					followupData[i] =  initialTestCase;//fm.inc(initialTestCase,constItem, constVal);
					//return followuptc;
					break;
				case "INVERSE":
					followupData[i] =  fm.inv(initialTestCase);
					//return followuptc;
					break;
				case "EXCLUDE":
					followupData[i] =  initialTestCase;//fm.exc(initialTestCase,constItem);
					//return followuptc;
					break;
				default:
	        		 System.out.println("Wrong Metamorphic relation.");
	        		 break;		
				}
				//followupData[i] =(Double) initial_inputdata[i];
			}
		}
		return followupData;
	}
	@Test(timeout=120000)
	public boolean runTest(String testClassName, String methodName, Object[] initialData,Object[] followupData, String operator){
		boolean mrResult = false;
		int methodFound = 0;
		try {
			Class testClass = Class.forName(testClassName);
			Method[] method = testClass.getDeclaredMethods();
			Object result=null;
			Object resultFollowup=null;
			
			for(int i=0;i<method.length;i++){
				if(method[i].getName().toString().equals(methodName)){
						methodFound = 1;
					//System.out.println(method[i].getName());
					    Class returnType = method[i].getReturnType();
					    Object instance = returnType.getName();//.newInstance();
					    try {
					    	result = method[i].invoke(null, initialData);
					    	resultFollowup = method[i].invoke(null, followupData);
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							System.out.println("Argument Type Mismatched.");
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
							System.out.println("Argument Type Mismatched.");
						}

						if (returnType.isArray())
						{
							Class arrType=returnType.getComponentType();
							if(arrType==Integer.TYPE)
							{
								int[] newResult=(int[])result;
								int[] newResultFollowup=(int[])resultFollowup;
								mrResult=checkResult(newResult,newResultFollowup,operator);
								return mrResult;
							}
							else if(arrType==Double.TYPE)
							{
								double[] newResult=(double[])result;
								double[] newResultFollowup=(double[])resultFollowup;
								mrResult=checkResult(newResult,newResultFollowup,operator);
								
								return mrResult;
							}
							else if(arrType==Boolean.TYPE)
							{
								boolean[] newResult=(boolean[])result;
								boolean[] newResultFollowup=(boolean[])resultFollowup;
								mrResult=checkResult(newResult,newResultFollowup,operator);
								
								return mrResult;
								
							}
							else 
							{
								System.out.println("Unhandled array result type");
								//return -3;
							}
							
						}else if(returnType==Integer.TYPE) 
						{   if(result==null||resultFollowup==null){
							return mrResult;
							}
							int newResult=(Integer)result;
							int newResultFollowup=(Integer)resultFollowup;
							mrResult=checkResult(newResult,newResultFollowup,operator);
							return mrResult;
							//System.out.println(newResult);
						}
						else if(returnType==Double.TYPE) 
						{   if(result==null||resultFollowup==null){
							return mrResult;
							}
							double newResult=(Double)result;
							double newResultFollowup=(Double)resultFollowup;
							mrResult=checkResult(newResult,newResultFollowup,operator);
							return mrResult;
						}
						else if(returnType==Boolean.TYPE) 
						{   if(result==null||resultFollowup==null){
							return mrResult;
							}
							boolean newResult=(Boolean)result;
							boolean newResultFollowup=(Boolean)resultFollowup;
							mrResult=checkResult(newResult,newResultFollowup,operator);
							return mrResult;
						}else if(instance instanceof String) 
						{
							//boolean newResult=(Boolean)result;
							//boolean newResultFollowup=(Boolean)resultFollowup;
							mrResult=checkResult(result,resultFollowup,operator);
							return mrResult;
						}
						else 
						{
							System.out.println("Unhandled result non-array type");
							//return -4;
						}	
					
				}
			 }
			if(methodFound == 0){
				System.out.println("Method Name Mismatched.");
			}
			return mrResult;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage()+".class Not found.");
		}
		
		return mrResult;
	}
	public static boolean checkResult(Object initResult, Object followResult, String operator)
	{   boolean result = false;
		switch(operator){
		case "EQUAL":
			if(checkEqual(initResult,followResult)==1) 
				result = true;
			break;
		case "GE":
			if(checkGreaterEqual(initResult,followResult)==1)
				result =true;
			break;
		case "LE":
			if(checkLessEqual(initResult,followResult)==1)
				result =true;
			break;
		case "G":
			if(checkGreaterThan(initResult,followResult)==1)
				result =true;
			break;
		case "L":
			if(checkLessThan(initResult,followResult)==1)
				result=true;
			break;
		case "NE":
			if(checkEqual(initResult,followResult)==0) 
				result = true;
			break;
		default:
			System.out.println("Unknown operator found.");
			break;	
	}
		return result;
	}
	
	
	public static int checkEqual(Object initResult, Object followResult)
	{
		int check=0;
		if (initResult instanceof int[] && followResult instanceof int[] )
		{
			int[] initR=(int[])initResult;
			int[] followR=(int[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=1;
				for(int i=0;i<initR.length;i++)
				{
					if(followR[i]!=initR[i])
						check=0;
				}
			}
			
		}
		else if (initResult instanceof double[] && followResult instanceof double[] )
		{
			double[] initR=(double[])initResult;
			double[] followR=(double[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=1;
				for(int i=0;i<initR.length;i++)
				{
					if(Double.isNaN(initR[i])||Double.isNaN(followR[i]))
						return -1;
					if(doubleCompare(initR[i],followR[i])!=0)
						check=0;
				}
			}
			
		}
		else if (initResult instanceof boolean[] && followResult instanceof  boolean[] )
		{
			boolean[] initR=( boolean[])initResult;
			boolean[] followR=( boolean[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=1;
				for(int i=0;i<initR.length;i++)
				{
					if(initR[i]!=followR[i])
						check=0;
				}
			}
			
		}
		
		else if (initResult instanceof Double && followResult instanceof Double )
		{
			double initR=(Double)initResult;
			double followR=(Double)followResult;
			//System.out.println("init:"+initR);
			//System.out.println("follow:"+followR);
			if(Double.isNaN(initR) ||Double.isNaN(followR))
				//System.out.println("**********Nan found");
				return -1;
			check=1;
			if(doubleCompare(initR, followR)!=0)
				check=0;
		}
		else if (initResult instanceof Integer && followResult instanceof Integer )
		{
			int initR=(Integer)initResult;
			int followR=(Integer)followResult;
			check=1;
			if(followR!=initR)
				check=0;
		}
		else if (initResult instanceof Boolean && followResult instanceof Boolean )
		{
			boolean initR=(Boolean)initResult;
			boolean followR=(Boolean)followResult;
			check=1;
			if(followR!=initR)
				check=0;
		}
		else if (initResult instanceof String && followResult instanceof String )
		{
			String initR=(String)initResult;
			String followR=(String)followResult;
			check=0;
			if(initR.toLowerCase().equals(followR.toLowerCase()))
				check=1;
		}
		return check;
		
	}
	public static int checkGreaterEqual(Object initResult, Object followResult)
	{	int check=0;
		if (initResult instanceof int[] && followResult instanceof int[] )
		{
			int[] initR=(int[])initResult;
			int[] followR=(int[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=0;
				for(int i=0;i<initR.length;i++)
				{
					if(followR[i]>=initR[i])
						check=1;
				}
			}
			
		}
		else if (initResult instanceof double[] && followResult instanceof double[] )
		{
			double[] initR=(double[])initResult;
			double[] followR=(double[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=0;
				for(int i=0;i<initR.length;i++)
				{
					if(Double.isNaN(initR[i])||Double.isNaN(followR[i]))
							return -1;
					if(doubleCompare(initR[i],followR[i])>=0)
						check=1;
				}
			}
			
		}
		else if (initResult instanceof Double && followResult instanceof Double )
		{
			double initR=(Double)initResult;
			double followR=(Double)followResult;
			check=0;
			if(Double.isNaN(initR)||Double.isNaN(followR))
				return -1;
			if(doubleCompare(initR,followR)>=0)
				check=1;
		}
		else if (initResult instanceof Integer && followResult instanceof Integer )
		{
			int initR=(Integer)initResult;
			int followR=(Integer)followResult;
			check=0;
			if(followR>=initR)
				check=1;
		}
		else if (initResult instanceof Boolean && followResult instanceof Boolean )
		{
			check=1;
		}
		return check;
	}
	public static int checkLessEqual(Object initResult, Object followResult)
	{	int check=0;
		if (initResult instanceof int[] && followResult instanceof int[] )
		{
			int[] initR=(int[])initResult;
			int[] followR=(int[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=0;
				for(int i=0;i<initR.length;i++)
				{
					if(followR[i]<=initR[i])
						check=1;
				}
			}
			
		}
		else if (initResult instanceof double[] && followResult instanceof double[] )
		{
			double[] initR=(double[])initResult;
			double[] followR=(double[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=0;
				for(int i=0;i<initR.length;i++)
				{
					if(Double.isNaN(initR[i])||Double.isNaN(followR[i]))
							return -1;
					if(doubleCompare(initR[i],followR[i])<=0)
						check=1;
				}
			}
			
		}
		else if (initResult instanceof Double && followResult instanceof Double )
		{
			double initR=(Double)initResult;
			double followR=(Double)followResult;
			check=0;
			if(Double.isNaN(initR)||Double.isNaN(followR))
				return -1;
			if(doubleCompare(initR,followR)<=0)
				check=1;
		}
		else if (initResult instanceof Integer && followResult instanceof Integer )
		{
			int initR=(Integer)initResult;
			int followR=(Integer)followResult;
			check=0;
			if(followR<=initR)
				check=1;
		}
		else if (initResult instanceof Boolean && followResult instanceof Boolean )
		{
			check=1;
		}
		return check;
	}
	
	public static int checkGreaterThan(Object initResult, Object followResult)
	{
		int check=0;
		if (initResult instanceof int[] && followResult instanceof int[] )
		{
			int[] initR=(int[])initResult;
			int[] followR=(int[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=1;
				for(int i=0;i<initR.length;i++)
				{
					if(followR[i]<initR[i])
						check=0;
				}
			}
			
		}
		else if (initResult instanceof double[] && followResult instanceof double[] )
		{
			double[] initR=(double[])initResult;
			double[] followR=(double[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=1;
				for(int i=0;i<initR.length;i++)
				{
					if(Double.isNaN(initR[i])||Double.isNaN(followR[i]))
							return -1;
					if(doubleCompare(initR[i],followR[i])<0)
						check=0;
				}
			}
			
		}
		
		else if (initResult instanceof Double && followResult instanceof Double )
		{
			double initR=(Double)initResult;
			double followR=(Double)followResult;
			check=1;
			if(Double.isNaN(initR)||Double.isNaN(followR))
				return -1;
			if(doubleCompare(initR,followR)<0)
				check=0;
		}
		else if (initResult instanceof Integer && followResult instanceof Integer )
		{
			int initR=(Integer)initResult;
			int followR=(Integer)followResult;
			check=1;
			if(followR<initR)
				check=0;
		}
		else if (initResult instanceof Boolean && followResult instanceof Boolean )
		{
			check=0;
		}
		return check;
		
	}
	public static int checkLessThan(Object initResult, Object followResult)
	{
		int check=0;
		if (initResult instanceof int[] && followResult instanceof int[] )
		{
			int[] initR=(int[])initResult;
			int[] followR=(int[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=1;
				for(int i=0;i<initR.length;i++)
				{
					if(followR[i]>initR[i])
						check=0;
				}
			}
			
		}
		else if (initResult instanceof double[] && followResult instanceof double[] )
		{
			double[] initR=(double[])initResult;
			double[] followR=(double[])followResult;
			if(initR.length!=followR.length)
				return 0;
			else
			{
				check=1;
				for(int i=0;i<initR.length;i++)
				{
					if(Double.isNaN(initR[i])||Double.isNaN(followR[i]))
						return -1;
					if(doubleCompare(initR[i],followR[i])>0)
						check=0;
				}
			}
			
		}
		
		else if (initResult instanceof Double && followResult instanceof Double )
		{
			double initR=(Double)initResult;
			double followR=(Double)followResult;
			check=1;
			if(Double.isNaN(initR)||Double.isNaN(followR))
				return -1;
			if(doubleCompare(initR,followR)>0)
				check=0;
		}
		else if (initResult instanceof Integer && followResult instanceof Integer )
		{
			int initR=(Integer)initResult;
			int followR=(Integer)followResult;
			check=1;
			if(followR>initR)
				check=0;
		}
		else if (initResult instanceof Boolean && followResult instanceof Boolean )
		{
			check=0;
		}
		return check;
		
	}
	public static int doubleCompare(double init,double follow)
	{
		double tol=Math.abs(follow-init);
		if(tol<0.0000001)
			return 0;
		else if(tol>=0.0000001 && follow-init>0)
			return 1;
		else 
			return -1;
	}
	public ArrayList  initialTestInput1(String fileName, String methodName, ArrayList data_type){
		ArrayList inputArray =new ArrayList();
		try {
		        File file = new File(fileName);
		        Scanner scanner = new Scanner(file);
		        int[] initial_input = {};
		        int i =0;
		        boolean allComplete = false;
				
		        while(scanner.hasNextLine() && !allComplete){
		        	String input_line = scanner.nextLine();
		        	if(input_line.contains(methodName)){
		        		 input_line =	input_line.substring(input_line.indexOf("(")+1, input_line.indexOf(")"));
		        		 String[] input = input_line.split(",");
		        		 int counter = 0;
		        		 for(String s:input){
		        			 scanner.close();
		        			 scanner=null;    
		        			 //reset scanner         
		        			 scanner=new Scanner(file);
		        			 String data = (String) data_type.get(counter);
		        			 String[] data_arr = data.split(",");
		        			 counter++;
		        			 boolean complete =false;
				        	 ArrayList initial_input_param = new ArrayList();
		        			 while (scanner.hasNextLine() && !complete) {
		        			    // System.out.println(scanner.nextLine());
		        				 String input_line_scanner = scanner.nextLine();
		        			     if(input_line_scanner.contains(data_arr[0]) && input_line_scanner.contains(s)){
		        			    	 if(data_arr.length > 1){//its an array
		        			    		 input_line_scanner =	input_line_scanner.substring(input_line_scanner.indexOf("{")+1, input_line_scanner.indexOf("}"));
			    		        		 String[] input_param = input_line_scanner.split(",");
			    		        		 //ArrayList initial_input_param = new ArrayList();
			    		        		 switch(data_arr[0]){
			    		        		 case "int":
			    		        			 for(String a:input_param){
				    			    	        	initial_input_param.add(Integer.parseInt(a));
				    			    	        	i++;
				    			    	        }
			    		        			 break;
			    		        		 case "double":
			    		        			 for(String a:input_param){
				    			    	        	initial_input_param.add(Double.parseDouble(a));
				    			    	        	i++;
				    			    	        }
			    		        			 break;
			    		        		 }
			    			    	        
		        			    	 }else{//normal data type
		        			    		 input_line_scanner =	input_line_scanner.substring(input_line_scanner.indexOf("=")+1, input_line_scanner.indexOf(";"));
		        			    		 switch(data_arr[0]){
			    		        		 case "int":
			    		        			 initial_input_param.add(Integer.parseInt(input_line_scanner));
			    		        			 break;
			    		        		 case "double":
			    		        			 initial_input_param.add(Double.parseDouble(input_line_scanner));
			    		        			 break;
			    		        		 }	
		        			    	 }
		        			    	 if(initial_input_param.size()>0) complete = true;
		    		        		// System.out.println(initial_input[0]);
		    		        	}//end if
		        			 }
		        			 inputArray.add(initial_input_param);
		        		 }
		        		 if(inputArray.size()>0) allComplete = true; 
		        	}
	
		        }//end while
		       
		 } catch (Exception e) {
		        e.printStackTrace();
		    }
		return inputArray;
	}
}
