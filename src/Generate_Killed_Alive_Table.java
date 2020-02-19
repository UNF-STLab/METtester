import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Generate_Killed_Alive_Table 
{
	static String strLine2;
	static ArrayList<String>  list3 = new ArrayList<String>();
	
public static String createkillalive(String filename) throws IOException
{
	String strLine;
	//String strLine2;
	String getindex = null;
	String getval5 = "aa";
	int count=0;
	Boolean b = null;
	String truefalse;
	Integer number_MRs=11;
	ArrayList<String>  list1 = new ArrayList<String>();
	ArrayList<String>  list2 = new ArrayList<String>();

		ArrayList<String>  temporary_list = new ArrayList<String>();
	  FileInputStream fstream = new FileInputStream(filename);
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));

	
	while ((strLine = br.readLine()) != null)
	  {
		list1.add(strLine);
	  }
	// Generating the mutant list and processing it
	for(int k=0;k<list1.size();k++)
	{
		String val1=list1.get(k);
		String[] spltval=val1.split(",");
		String getid=spltval[0];
		if(getid.equals("98"))
		{
			System.out.print("Hrllo");
		}
		list2.add(val1);
		for(int j=k+1;j<list1.size();j++)
		{
			String val2=list1.get(j);
			String[] spltval2=val2.split(",");
			String getid1=spltval2[0];
			if(getid1.equals(getid))
			{
				list2.add(val2);
//				if(j==1)
//					
//				{
//				list1.remove(j);
//				}
//				else
//				{
//					list1.remove(j-1);
//				}
			}
			if(j==list1.size()-1)
			{
				if(list2.size()!=1)
				  {
//				if(list2.size()==1)
//				{
//					break;
//				}
				FileWriter fstream4=new FileWriter(".//src//mutants//tmp", true);//psaha
				 //FileWriter fstream4=new FileWriter("/./"+"tmp", true);
				  
					BufferedWriter bf1= new BufferedWriter(fstream4);
					  
					   for(int n=0;n<list2.size();n++)
					   {
					    	 bf1.write(list2.get(n));
								bf1.newLine();
								
					   }
					   bf1.close();	 
					   
					   remove_ids(list2,list1);
					   list2.clear();
					   k=k-1;
					   break;
					  }
				else
				{
					list2.clear();
				}
			}
			
		}
		
	}
	
	assign_kill_alive();
	String mutantfile=Generate_tableform_killAlive();
	return mutantfile;
}

public static void remove_ids(ArrayList<String> list2,ArrayList<String> list1)
{
	for(int m1=0;m1<list2.size();m1++)
	{
		String getval=list2.get(m1);
		
		for(int m2=0;m2<list1.size();m2++)
		{
			String getval1=list1.get(m2);
			if(getval.equals(getval1))
			{
				list1.remove(m2);
				break;
			}
		}
	}
}

// Based on the result, assigning kill/alive to each mutant

public static void assign_kill_alive() throws IOException
{
	//FileInputStream fstream6=new FileInputStream("/./"+"tmp");
	FileInputStream fstream6 = new FileInputStream(".//src//mutants//tmp");//psaha
	
	  DataInputStream in6 = new DataInputStream(fstream6);
	  BufferedReader br6 = new BufferedReader(new InputStreamReader(in6));
	  
	  FileWriter fstream5=new FileWriter(".//src//mutants//tmp1", true);//psaha
	 // FileWriter fstream5=new FileWriter("./"+"tmp1", true);
	  
		BufferedWriter bf2= new BufferedWriter(fstream5);

	
	while ((strLine2 = br6.readLine()) != null)
	  {
		list3.add(strLine2);
		
	  }
	for(int k1=0;k1<list3.size();k1++)
	{
		String val1=list3.get(k1);
		String[] spltstr=val1.split(",");
		String val2=spltstr[spltstr.length-1];
		if(val2.equals("true"))
		{
			bf2.newLine();
			bf2.write(val1+","+"Alive");
			
		}
		if(val2.equals("false"))
		{
			bf2.newLine();
			bf2.write(val1+","+"Killed");
		}
	}
	bf2.close();
}

// generating the Killed/Alive table
public static String Generate_tableform_killAlive() throws IOException
{
	int count=0;
	int count1=0;
	int b=1;
	Boolean flag=true;
	String strLine;
	int count_list=0;
	String strval1 = null;
	int mutantnumber=1;
	//FileInputStream fstream = new FileInputStream("/./"+"tmp1");
	FileInputStream fstream = new FileInputStream(".//src//mutants//tmp1");//psaha
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  ArrayList<ArrayList<String>> parent1 = new ArrayList<ArrayList<String>>();
	  ArrayList<String>  list7 = new ArrayList<String>();
	  ArrayList<String>  list8 = new ArrayList<String>();
	  ArrayList<String>  list9 = new ArrayList<String>();
	  ArrayList<String>  list10 = new ArrayList<String>();
	  
	  //FileWriter fstream5=new FileWriter("/./"+"tmp2", true);
	  FileWriter fstream5=new FileWriter(".//src//mutants//tmp2", true);//psaha
	  
		BufferedWriter bf2= new BufferedWriter(fstream5);

	
	while ((strLine2 = br.readLine()) != null)
	  {
		list7.add(strLine2);
		
	  }
	  // writing the MR header
    for(int k1=1;k1<list7.size();k1++)
    {
        String getmrname=list7.get(1);
        String[] spltmr=getmrname.split(",");
        String getval1=spltmr[1];
        String strval=list7.get(k1);
        strval1=list7.get(k1+1);
        String[] spltval1=strval.split(",");
        String[] spltval2=strval1.split(",");
        count=count+1;
        if(getval1.equals(spltval2[1]))
        {
            for(int k=0;k<count;k++)
            {
                int a=k+1;
                bf2.write("MR"+a+" ");
            }
            break;    
        }
        
        
        
    }
	// processing the mutant kill/alive based on different set
	int count_mr=0;
	FileInputStream fstream8 = new FileInputStream(".//src//mutants//tmp1");//psaha
	  DataInputStream in1 = new DataInputStream(fstream8);
	  BufferedReader br2 = new BufferedReader(new InputStreamReader(in1));

	  FileWriter fstream9=new FileWriter(".//src//mutants//tmp6", true);//psaha
	  
		BufferedWriter bf3= new BufferedWriter(fstream9);

	
	while ((strLine = br2.readLine()) != null)
	  {
		list8.add(strLine);
	  }
	//parent1.add(new ArrayList<String>());
	for(int k=b;k<list8.size();k++)
	{
		if(flag==false)
		{
			
		  flag=true;
		  break;
		}
		count_mr=count_mr+1;
		String val4=list8.get(k);
		
		
		//parent1.get(count_list).add(val4);
		bf3.newLine();
		bf3.write(val4);
		list9.add(val4);
		b=b+1;
		if(count_mr==count)
		{
			for(int k1=k;k1<list8.size();k1++)
			{
				String val9=list8.get(k1);
				String splt1[]=val9.split(",");
				if(k1<list8.size()-1)
				{
				String val10=list8.get(k1+1);
				String splt2[]=val10.split(",");
				if(!splt1[0].equals(splt2[0]))
				{
					count_mr=0;
					k=k1;
					break;
				}
				}
				if(k1==list8.size()-1)
				{
					flag=false;
					break;
				}
				
				
				
			}
//			parent1.add(new ArrayList<String>());
//			for(int k1=k;k1<list8.size();k1++)
//			{
//				String val5=list8.get(k1);
//				//String[] spltval5=val5.split(",");
//				//String val_next=list8.get(k+1);
//			//	String[] spltval8=val_next.split(",");
//				parent1.get(count_list+1).add(val5);
				
			}
	
		}
		bf3.close();
	//}
	// Generating the mutant list and processing it
	
	
	// writing the mutant and kill/Alive
	bf2.newLine();
	count1=0;
	FileInputStream fstream10 = new FileInputStream(".//src//mutants//tmp6");//psaha
	  DataInputStream in10 = new DataInputStream(fstream10);
	  BufferedReader br10 = new BufferedReader(new InputStreamReader(in10));
	  
	  while ((strLine2 = br10.readLine()) != null)
	  {
		list10.add(strLine2);
		
	  }
	for(int k1=1;k1<list10.size();k1++)
	{
//		if(k1==2466)
//		{
//			System.out.println("Hello");
//			
//		}
		
		if(count1==0)
		{
			bf2.write("mutantM"+mutantnumber);
		}
		String strval=list10.get(k1);
		if(k1<list10.size()-1)
		{
		strval1=list10.get(k1+1);
		}
		String[] spltval1=strval.split(",");
	
		String[] spltval2=strval1.split(",");
		//}
		//bf2.write("   ");
		bf2.write("\t"+spltval1[spltval1.length-1]);
		count1=count1+1;
		// When MR Killed/Alive is missing from the main list, the add alive to fill the remaining MR
		if((count1<count)&&(!spltval1[0].trim().equals(spltval2[0].trim())))
		{
			Integer coun=count-count1;
			for(int v=0;v<coun;v++)
			{
				bf2.write("\t"+"Alive");
				
				count1=count1+1;
			}
		}
		if(count1==count)
		{
			System.out.println((strval+","+count1));
			bf2.newLine();
			count1=0;
			mutantnumber=mutantnumber+1;
		}
		
	}
	bf2.close();
	//String mastermutantfile="/./"+"tmp2";
	String mastermutantfile=".//src//mutants//tmp2";//psaha
	return mastermutantfile;
	//System.out.println("\t"+"alive");
}
}
