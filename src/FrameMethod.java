
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;


public class FrameMethod {
	
	public static Random rand = new Random();
	public static int Const_INT = getInt();
	public static final	int MAX = 100;
	public static long permSeed = 12345; 
	
	//common methods
	public static int getInt(){
		return rand.nextInt(MAX) + 1;
	}
	public static double getDouble() {
        return rand.nextDouble() * getInt() + 1;
    }
	public static int[] getIntArray(){
		int size = rand.nextInt(8) + 4;
		
		return getIntArray(size);
	}
	public static int[] getIntArray(int size){	
		return rand.ints(size, 1, MAX).toArray();
	}
	public static double[] getDoubleArray() {
        int size = rand.nextInt(9) + 1;
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (rand.nextDouble() * MAX) + 1;
        }
        return arr;
    }

    public static double[] getDoubleArray(int size) {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (rand.nextDouble() * MAX) + 1;
        }
        return arr;
    }
    
	//Addition MR methods
	public static int add(int Initial, int Const) {
      //  return Initial + Const_INT;
		return Initial + Const;

    }

    public static double add(double Initial, double Const) {
        //return Initial + ( (double)Const_INT);
    	return Initial + ( (double)Const);
    }

    public static long add(long Initial, int Const) {
        //return Initial + ( (long)Const_INT);
    	return Initial + ( (long)Const);
    }
    public static int[] add(int[] Initial){
		int[] Followup = new int[Initial.length];
		int Const = Const_INT;
		for(int i=0;i<Followup.length;i++){
			 //add Const_INT with each element
			//Followup[i]= Initial[i] + Const_INT;	
			Followup[i]= Initial[i] + Const;	
		 }
		return Followup;	
	}
    public static int[] add(int[] Initial, int Const){
		int[] Followup = new int[Initial.length];
		for(int i=0;i<Followup.length;i++){
			 //add Const_INT with each element
			//Followup[i]= Initial[i] + Const_INT;	
			Followup[i]= Initial[i] + Const;	
		 }
		return Followup;	
	}
	
	public static double[] add(double[] original, int Const) {
        double[] additive = new double[original.length];
        for (int i = 0; i < original.length; i++) {
          //  additive[i] = original[i] + ( (double)Const_INT);
        	additive[i] = original[i] + ( (double)Const);
        }
        return additive;
    }
	
	public static double[] add(double[] original, double Const) {
        double[] additive = new double[original.length];
        for (int i = 0; i < original.length; i++) {
          //  additive[i] = original[i] + ( (double)Const_INT);
        	additive[i] = original[i] + Const;
        }
        return additive;
    }
	
	public static boolean addTest(int InitTest, int FollowupTest){
		
		return InitTest <= FollowupTest;		
	}
	
	public static boolean addTest(double orig, double next) {
        return ((Double.compare(orig, next) <= 0) || ((next - orig) > -0.0001));
    }
	
	public static boolean addTest(int[] InitTest, int[] FollowupTest) {
        if (InitTest.length != FollowupTest.length) { return false; }
        for (int i = 0; i < InitTest.length; i++) {
            if (!addTest(InitTest[i], FollowupTest[i])) {
                return false;
            }
        }
        return true;
    }
	
	public static boolean addTest(double[] orig, double[] next) {
        if (orig.length != next.length) { return false; }
        for (int i = 0; i < orig.length; i++) {
            if (!addTest(orig[i], next[i])) {
                return false;
            }
        }
        return true;
    }
	
	//Permutation MR methods
	  public static int[] perm(int[] original) {
	        int temp, index;
	        int[] permuted = Arrays.copyOf(original, original.length);
	        Random r = new Random();
	        for (int i = original.length - 1; i > 0; i--) {
	            index = r.nextInt(i+1);
	            temp = permuted[i];
	            permuted[i] = permuted[index];
	            permuted[index] = temp;
	        }
	        return permuted;
	    }
	  public static int[] perm(int[] original, Random r) {
	        int temp, index;
	        int[] permuted = Arrays.copyOf(original, original.length);
	       // Random r = new Random();
	        for (int i = original.length - 1; i > 0; i--) {
	            index = r.nextInt(i+1);
	            temp = permuted[i];
	            permuted[i] = permuted[index];
	            permuted[index] = temp;
	        }
	        return permuted;
	    }
	  public static double[] perm(double[] original) {
	        int index;
	        double temp;
	        double[] permuted = Arrays.copyOf(original, original.length);
	        Random r = new Random(permSeed);
	        for (int i = original.length - 1; i > 0; i--) {
	            index = r.nextInt(i+1);
	            temp = permuted[i];
	            permuted[i] = permuted[index];
	            permuted[index] = temp;
	        }
	        return permuted;
	    }
	  
	  public static double[] perm(double[] original, Random r) {
	        int index;
	        double temp;
	        double[] permuted = Arrays.copyOf(original, original.length);
	      //  Random r = new Random(permSeed);
	        for (int i = original.length - 1; i > 0; i--) {
	            index = r.nextInt(i+1);
	            temp = permuted[i];
	            permuted[i] = permuted[index];
	            permuted[index] = temp;
	        }
	        return permuted;
	    }

	  public static double perm(double original) { return original; }
	  public static int perm(int original) { return original; }
	  
	  public static boolean PermTest(int o, int n) {
	        return (o == n);
	    }
	  
	  public static boolean PermTest(double o, double n) {
	        return ((Double.compare(o,n) == 0) || (Math.abs(o - n) < 0.0001));
	    }

	  public static boolean PermTest(int[] o, int[] n) {
	        if (o.length != n.length) { return false; }
	        for (int i = 0; i < o.length; i++) {
	            if (!PermTest(o[i], n[i])) {
	                return false;
	            }
	        }
	        return true;
	    }

	  public static boolean PermTest(double[] o, double[] n) {
	        if (o.length != n.length) { return false; }
	        for (int i = 0; i < o.length; i++) {
	            if (!PermTest(o[i], n[i])) {
	                return false;
	            }
	        }
	        return true;
	    }
	  
	  //Multiplication MR methods
	  public static int[] mult(int[] original) {
	        int[] multiplied = new int[original.length];
	        int Const = Const_INT;
	        for (int i = 0; i < original.length; i++) {
	          //  multiplied[i] = original[i] * Const_INT;
	        	multiplied[i] = original[i] * Const;
	        }
	        return multiplied;
	    }
	  public static int[] mult(int[] original, int Const) {
	        int[] multiplied = new int[original.length];
	        for (int i = 0; i < original.length; i++) {
	          //  multiplied[i] = original[i] * Const_INT;
	        	multiplied[i] = original[i] * Const;
	        }
	        return multiplied;
	    }
	  public static double[] mult(double[] original, int Const) {
	        double[] multiplied = new double[original.length];
	        for (int i = 0; i < original.length; i++) {
	           // multiplied[i] = original[i] * Const_INT;
	        	 multiplied[i] = original[i] * Const;
	        }
	        return multiplied;
	    }
	  
	  public static double[] mult(double[] original, double Const) {
	        double[] multiplied = new double[original.length];
	        for (int i = 0; i < original.length; i++) {
	           // multiplied[i] = original[i] * Const_INT;
	        	 multiplied[i] = original[i] * Const;
	        }
	        return multiplied;
	    }
	  
	  public static double mult(double original, double Const) {
	      //  return original * (double)Const_INT;
	        return original * (double)Const;
	    }

	  public static int mult(int original, int Const) {
	        //return original * Const_INT;
		  return original * Const;
	    }
	  
	  public static boolean multTest(int o, int n) { return addTest(o, n); }
	  public static boolean multTest(double o, double n) { return addTest(o, n); }
	  public static boolean multTest(int[] o, int[] n) { return addTest(o, n); }
	  public static boolean multTest(double[] o, double[] n) { return addTest(o, n); }
	  
	//Inclusive MR methods
	  public static int[] inc(int[] original) {
	        int[] included = new int[original.length + 1];
	        for (int i = 0; i < original.length; i++) {
	            included[i] = original[i];
	        }
	        included[original.length] = getInt(); //new final element
	        return included;
	    }
	  public static int[] inc(int[] original, int item, int constVal) {
	        int[] included = new int[original.length + item];
	        for (int i = 0; i < original.length; i++) {
	            included[i] = original[i];
	        }
	        included[original.length] = constVal; //new final element
	        return included;
	    }
	  public static double[] inc(double[] original) {
	        double[] included = new double[original.length + 1];
	        for (int i = 0; i < original.length; i++) {
	            included[i] = original[i];
	        }
	        included[original.length] = getDouble(); //new final element
	        return included;
	    }
	  public static double[] inc(double[] original, int item, double constVal) {
	        double[] included = new double[original.length + item];
	        for (int i = 0; i < original.length; i++) {
	            included[i] = original[i];
	        }
	        included[original.length] = constVal; //new final element
	        return included;
	    }
	  public static String inc(String original, int item, String constVal) {
		  	String included = original;
	        for (int i = 0; i < original.length(); i++) {
	            included = included+constVal;
	        }
	        return included;
	    }
	  public static int inc(int original) { return original; }

	  public static double inc(double original) { return original; }
	    
	  public static boolean incTest(int o, int n) { return addTest(o, n); }
	  public static boolean incTest(double o, double n) { return addTest(o, n); }
	  public static boolean incTest(int[] o, int[] n) { return addTest(o, n); }
	  public static boolean incTest(double[] o, double[] n) { return addTest(o, n); }
	
	  //Exclusive MR methods 
	  public static int[] exc(int[] original) {
	        int[] excluded = new int[original.length - 1];
	        for (int i = 0; i < excluded.length; i++) { //output excludes final element
	            excluded[i] = original[i];
	        }
	        return excluded;
	    }
	  public static int[] exc(int[] original, int item) {
	        int[] excluded = new int[original.length - item];
	        for (int i = 0; i < excluded.length; i++) { //output excludes final element
	            excluded[i] = original[i];
	        }
	        return excluded;
	    }
	  public static double[] exc(double[] original) {
	        double[] excluded = new double[original.length - 1];
	        for (int i = 0; i < excluded.length; i++) { //output excludes final element
	            excluded[i] = original[i];
	        }
	        return excluded;
	    }
	  public static double[] exc(double[] original, int item) {
	        double[] excluded = new double[original.length - item];
	        for (int i = 0; i < excluded.length; i++) { //output excludes final element
	            excluded[i] = original[i];
	        }
	        return excluded;
	    }
	  public static String exc(String original, int item) {
		  	String excluded = original.substring(0, original.length()-item);
	        return excluded;
	    }
	  public static int exc(int original) { return original; }

	  public static double exc(double original) { return original; }
	  
	  public static boolean excTest(int pre, int post) {
	        return (post <= pre);
	    }
	  public static boolean excTest(int[] pre, int[] post) {
	        if (pre.length != post.length) { return false; }
	        for (int i = 0; i < pre.length; i++) {
	            if (!excTest(pre[i], post[i])) {
	                return false;
	            }
	        }
	        return true;
	    }
	  
	  public static boolean excTest(double pre, double post) {
	        return ( (Double.compare(pre, post) >= 0) || ((pre - post) > -0.0001) );
	    }

	    public static boolean excTest(double[] pre, double[] post) {
	        if (pre.length != post.length) { return false; }
	        for (int i = 0; i < pre.length; i++) {
	            if (!excTest(pre[i], post[i])) {
	                return false;
	            }
	        }
	        return true;
	    }

	//Inversion MR methods  
	  public static int[] inv(int[] original) {
	        int[] inverse = new int[original.length];
	        for (int i = 0; i < original.length; i++) {
	        	if(original[i]== 0){
	        		inverse[i] = original[i]; //Integer arithmetic. Problem?
	        	}else{
	        		inverse[i] = 1 / original[i]; //Integer arithmetic. Problem?
	        	}
	            
	        }
	        return inverse;
	    }
	  
	  public static double[] inv(double[] original) {
	        double[] inverse = new double[original.length];
	        for (int i = 0; i < original.length; i++) {
	        	if(original[i]== 0){
	        		inverse[i] = original[i]; 
	        	}else{
	        		inverse[i] = 1.0 / original[i];
	        	}
	            
	        }
	        return inverse;
	    }

	    public static double inv(double original) {
	    	if(original== 0){
	    		return  original;
        	}else{
        		return 1.0 / original;
        	}
	        //return 1.0 / original;
	    }

	    public static int inv(int original) {
	    	if(original== 0){
	    		return  original;
        	}else{
        		return 1 / original;
        	}
	       // return 1 / original;
	    }
	    
	    public static boolean invTest(int o, int n) { return excTest(o, n); }
	    public static boolean invTest(double o, double n) { return excTest(o, n); }
	    public static boolean invTest(int[] o, int[] n) { return excTest(o, n); }
	    public static boolean invTest(double[] o, double[] n) { return excTest(o, n); }
	  
	    public static String rev(String original) {
	    	//String string="whatever";
	    	String reverse = new StringBuffer(original).reverse().toString();
	        return reverse;
	    }
	  //MR initial and followup test case
	  
	    //Addition
	  public static boolean Addition(int[] Original, int sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		  /*if(methodName == "add_values"){
			  int sum1 = MethodCollection2.add_values(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }
		  
		  else if(methodName == "find_min"){
			  int sum1 = MethodCollection2.find_min(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }
		  
		  else if(methodName == "find_max"){
			  int sum1 = MethodCollection2.find_max(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }*/
		/*  else if(methodName == "sum"){
			  int sum1 = MethodsFromMahout.sum(add(Original));
			  result = addTest(sum, sum1); 
		  }*/
		  return result;
	  }
	  
	  public static boolean Addition(int[] Original, double sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		  /*if(methodName == "find_magnitude"){
			  double sum1 = MethodCollection2.find_magnitude(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }
		  else if(methodName == "average"){
			  double sum1 = MethodCollection2.average(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }
		  else if(methodName == "geometric_mean"){
			  double sum1 = MethodCollection2.geometric_mean(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }
		  else if(methodName == "find_median"){
			  double sum1 = MethodCollection2.find_median(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }*/
		
		  return result;
	  }
	 
	  public static boolean Addition(double[] Original, double sum, String methodName){
		  boolean result = true;	
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		  /*if(methodName == "variance"){
			  double sum1 = MethodCollection2.variance(add(Original,Const));
			  result = addTest(sum, sum1); 
		  }*/
		  return result;
	  }
	  
	  public static boolean Addition(int[] Original, int[] sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		 /* if(methodName == "bubble"){
			  int[] sum1 = MethodCollection2.bubble(add(Original,Const));
			  result = FrameMethod.addTest(sum, sum1);  
		  }
		  else if(methodName == "selection_sort"){
			  int[] sum1 = MethodCollection2.selection_sort(add(Original,Const));
			  result = FrameMethod.addTest(sum, sum1);  
		  }
		  else if(methodName == "array_calc1"){
			  int key = getInt();
			  int[] sum1 = MethodCollection2.array_calc1(add(Original,Const), key);
			  result = FrameMethod.addTest(sum, sum1);  
		  }
		  else if(methodName == "set_min_val"){
			  int key = getInt();
			  int[] sum1 = MethodCollection2.set_min_val(add(Original,Const), key);
			  result = FrameMethod.addTest(sum, sum1); 
		  }
		  else if(methodName == "array_copy"){
			  int[] sum1 = MethodCollection2.array_copy(add(Original,Const));
			  result = FrameMethod.addTest(sum, sum1);  
		  }
		  else if(methodName == "insertion_sort"){
			  int[] sum1 = MethodCollection2.insertion_sort(add(Original,Const));
			  result = FrameMethod.addTest(sum, sum1);  
		  }
		  else if(methodName == "reverse"){
			  int[] sum1 = MethodCollection2.reverse(add(Original,Const));
			  result = FrameMethod.addTest(sum, sum1);  
		  }
		  else if(methodName == "clip"){
			  int upperlim = FrameMethod.getInt();
			  int lowerlim = FrameMethod.getInt();
			  int[] sum1 = MethodCollection2.clip(add(Original,Const), upperlim, lowerlim);
			  result = addTest(sum, sum1); 
		  }*/
		  return result;
	  }
	
	  public static boolean Addition(int[] a, int[] b, int sum,  String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		  /*if(methodName == "hamming_dist"){
			  int sum1 = MethodCollection2.hamming_dist(add(a,Const), add(b,Const));
			  result = addTest(sum, sum1);  
		  }*/
		   return result;
	  }
	  public static boolean Addition(int[] a, int[] b, int[] sum,  String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "add"){
			  int[] sum1 = MethodsFromMahout.add(add(a), add(b));
			  result = addTest(sum, sum1);  
		  }*/
		   return result;
	  }
	  public static boolean Addition(double[] a, double[] b, double sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "weighted_average"){
			  double sum1 = MethodCollection2.weighted_average(add(a,Const), add(b,Const));
			  result = addTest(sum, sum1);  
		  }*/

		  return result;
	  }
	  
	  public static boolean Addition(double[] arr,int begin,int end,int pivot,  int sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		 /* if(methodName == "partition"){
			  int sum1 = MethodsFromApacheMath.partition(add(arr), begin, end, pivot);
			  result = addTest(sum, sum1);  
		  } */
		  return result;
	  }
	  
	  public static boolean Addition(double[] Original, double[] sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "calculateAbsoluteDifferences"){
			  double[] sum1 = MethodsFromApacheMath.calculateAbsoluteDifferences(add(Original));
			  result = addTest(sum, sum1); 
		  }
		  else if(methodName == "scale"){
			  double Arg = FrameMethod.getDouble();
			  double[] sum1 = MethodsFromApacheMath.scale( Arg , add(Original));
			  result = addTest(sum, sum1); 
		  }*/
		  
		  return result;
	  }
	  
	  public static boolean Addition(double[] a, double[] b, double[] sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "ebeMultiply"){
			  double[] sum1 = MethodsFromApacheMath.ebeMultiply(add(a), add(b));
			  result = addTest(sum, sum1);  
		  }
		  else if(methodName == "ebeAdd"){
			  double[] sum1 = MethodsFromApacheMath.ebeAdd(add(a), add(b));
			  result = addTest(sum, sum1);  
		  }
		  
		  else if(methodName == "ebeDivide"){
			  double[] sum1 = MethodsFromApacheMath.ebeDivide(add(a), add(b));
			  result = addTest(sum, sum1);  
		  }*/
		  
		  return result;
	  }
	  
	  public static boolean Addition(double[] a, int b, double sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		 /* if(methodName == "polevl"){
			  double first = FrameMethod.getDouble();
			  double sum1 =  MethodsFromColt.polevl(first, add(a), add(b));
			  result = addTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Addition(double[] a, int b, int c, double sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "winsorizedMean"){
			 // double first = FrameMethod.getDouble();
			  double sum1 =  MethodsFromColt.winsorizedMean(add(a), add(b), add(c));
			  result = addTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  //Permutation
	  public static boolean Permutation(int[] Original, int sum, String methodName){
		  boolean result = true;
		  Random r = new Random();
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Permutation MR
		 /* if(methodName == "add_values"){
			  int sum1 = MethodCollection2.add_values(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }
		  
		  else if(methodName == "find_min"){
			  int sum1 = MethodCollection2.find_min(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }
		  
		  else if(methodName == "find_max"){
			  int sum1 = MethodCollection2.find_max(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "count_k"){
			  int key = getInt();
			  int sum1 = MethodCollection2.count_k(perm(Original, r), key);
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "count_non_zeroes"){
			  int sum1 = MethodCollection2.count_non_zeroes(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "cnt_zeroes"){
			  int sum1 = MethodCollection2.cnt_zeroes(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }*/
		
		  return result;
	  }
	  
	  public static boolean Permutation(int[] Original, double sum, String methodName){
		  boolean result = true;
		  Random r = new Random();
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Permutation MR
		 /* if(methodName == "average"){
			  double sum1 = MethodCollection2.average(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "geometric_mean"){
			  double sum1 = MethodCollection2.geometric_mean(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "find_median"){
			  double sum1 = MethodCollection2.find_median(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }*/
		 
		  return result;
	  }
	 
	  public static boolean Permutation(double[] Original, double sum, String methodName){
		  boolean result = true;
		  Random r = new Random(permSeed);
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Permutation MR
		 /* if(methodName == "variance"){
			  double sum1 = MethodCollection2.variance(perm(Original, r));
			  result = PermTest(sum, sum1);  
		  }*/
		 
		
		  return result;
	  }
	  
	  public static boolean Permutation(int[] Original, int[] sum, String methodName){
		  boolean result = true;
		  Random r = new Random();
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		/*  if(methodName == "set_min_val"){
			 int key = getInt();
			 int[] sum1 = MethodCollection2.set_min_val(perm(Original, r), key);
			 result = PermTest(sum, sum1);
		}*/
		  return result;
	  }
	  
	  public static boolean Permutation(double[] Original, double[] sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Permutation MR
		/*  if(methodName == "standardize"){
			  double[] sum1 = MethodsFromColt.standardize(perm(Original));
			  result = PermTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Permutation(double[] Original1, double[] Original2, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Permutation MR
	/*	  if(methodName == "pooledVariance"){
			  double sum1 = MethodsFromColt.pooledVariance(perm(Original1), perm(Original2));
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "pooledMean"){
			  double sum1 = MethodsFromColt.pooledMean(perm(Original1), perm(Original2));
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "weightedMean"){
			  double sum1 = MethodsFromColt.weightedMean(perm(Original1), perm(Original2));
			  result = PermTest(sum, sum1);  
		  }
		  else if(methodName == "errorRate"){
			  double sum1 = MethodsFromMahout.errorRate(perm(Original1), perm(Original2));
			  result = PermTest(sum, sum1);  
		  }*/
		  return result;
	  }
	//Multiplication
	  public static boolean Multiplication(int[] Original, int sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		/*  if(methodName == "add_values"){
			  int sum1 = MethodCollection2.add_values(mult(Original, Const));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "find_min"){
			  int sum1 = MethodCollection2.find_min(mult(Original, Const));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "find_max"){
			  int sum1 = MethodCollection2.find_max(mult(Original, Const));
			  result = multTest(sum, sum1);  
		  }*/
		/*  else if(methodName == "sum"){
			  int sum1 = MethodsFromMahout.sum(mult(Original));
			  result = multTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Multiplication(int[] Original, double sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		 /* if(methodName == "find_magnitude"){
			  double sum1 = MethodCollection2.find_magnitude(mult(Original, Const));
			  result =multTest(sum, sum1); 
		  }
		  
		  else if(methodName == "average"){
			  double sum1 = MethodCollection2.average(mult(Original, Const));
			  result =multTest(sum, sum1); 
		  }
		  else if(methodName == "geometric_mean"){
			  double sum1 = MethodCollection2.geometric_mean(mult(Original, Const));
			  result =multTest(sum, sum1); 
		  }
		  else if(methodName == "find_median"){
			  double sum1 = MethodCollection2.find_median(mult(Original, Const));
			  result =multTest(sum, sum1); 
		  }*/
		  return result;
	  }
	  
	  public static boolean Multiplication(double[] Original, double sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		/*  if(methodName == "variance"){
			  double sum1 = MethodCollection2.variance(mult(Original, Const));
			  result = multTest(sum, sum1);  
		  }*/
		 
		 
		  return result;
	  }
	  
	  public static boolean Multiplication(double[] agr1, double[] agr2, int start, int length, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		 /* if(methodName == "evaluateWeightedProduct"){
			  double sum1 = MethodsFromApacheMath.evaluateWeightedProduct(mult(agr1),mult(agr2), start, length);
			  result = multTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Multiplication(int[] a, int[] b,int sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		  /*if(methodName == "dot_product"){
			  int sum1 = MethodCollection2.dot_product(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "hamming_dist"){
			  int sum1 = MethodCollection2.hamming_dist(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }*/
		  
		  return result;
	  }
	  
	  public static boolean Multiplication(int[] a, int[] b,int[] sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		 /* if(methodName == "elementwise_max"){
			  int[] sum1 = MethodCollection2.elementwise_max(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "elementwise_min"){
			  int[] sum1 = MethodCollection2.elementwise_min(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }*/
		 /* else if(methodName == "add"){
			  int[] sum1 = MethodsFromMahout.add(mult(a), mult(b));
			  result = multTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Multiplication(int[] Original, int[] sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		/*if(methodName == "bubble"){
			 int[] sum1 = MethodCollection2.bubble(mult(Original, Const));
			 result = multTest(sum, sum1);
		}
		else if(methodName == "shell_sort"){
			 int[] sum1 = MethodCollection2.shell_sort(mult(Original, Const));
			 result = multTest(sum, sum1);
		} 
		else if(methodName == "selection_sort"){
			 int[] sum1 = MethodCollection2.selection_sort(mult(Original, Const));
			 result = multTest(sum, sum1);
		}
		else if(methodName == "set_min_val"){
			 int key = getInt();
			 int[] sum1 = MethodCollection2.set_min_val(mult(Original, Const), key);
			 result = multTest(sum, sum1);
		}
		else if(methodName == "array_copy"){
			int[] sum1 = MethodCollection2.array_copy(mult(Original, Const));
			 result = multTest(sum, sum1);
		}
		else if(methodName == "insertion_sort"){
			 int[] sum1 = MethodCollection2.insertion_sort(mult(Original, Const));
			 result = multTest(sum, sum1);
		}
		else if(methodName == "reverse"){
			 int[] sum1 = MethodCollection2.reverse(mult(Original, Const));
			 result = multTest(sum, sum1);
		}
		
		else if(methodName == "clip"){
			  int upperlim = FrameMethod.getInt();
			  int lowerlim = FrameMethod.getInt();
			  int[] sum1 = MethodCollection2.clip(mult(Original, Const), upperlim, lowerlim);
			  result = multTest(sum, sum1); 
		  }*/
		  return result;
	  }
	  
	  public static boolean Multiplication(int[] a, int[] b, double sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		 /* if(methodName == "find_euc_dist"){
			  double sum1 = MethodCollection2.find_euc_dist(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "manhattan_dist"){
			  double sum1 = MethodCollection2.manhattan_dist(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "mean_absolute_error"){
			  double sum1 = MethodCollection2.mean_absolute_error(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }*/
		  return result;
	  }
	
	  public static boolean Multiplication(double[] a, double[] b, double sum, String methodName){
		  boolean result = true;
		  int Const = Const_INT;
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "weighted_average"){
			  double sum1 = MethodCollection2.weighted_average(mult(a, Const), mult(b, Const));
			  result = multTest(sum, sum1);  
		  }*/
		
		
		  return result;
	  }
	  
	  
	  public static boolean Multiplication(double[] arr,int begin,int end,int pivot,  int sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		/*  if(methodName == "partition"){
			  int sum1 = MethodsFromApacheMath.partition(add(arr), begin, end, pivot);
			  result = multTest(sum, sum1);  
		  } */
		  return result;
	  }
	  
	  public static boolean Multiplication(double[] Original, double[] sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		/*if(methodName == "calculateAbsoluteDifferences"){
			double[] sum1 = MethodsFromApacheMath.calculateAbsoluteDifferences(mult(Original));
			 result = multTest(sum, sum1);
		}
		else if(methodName == "scale"){
			double arg1 = FrameMethod.getDouble();
			double[] sum1 = MethodsFromApacheMath.scale(arg1, mult(Original));
			 result = multTest(sum, sum1);
		}*/
		
		
		return result;
	  }
	  
	  public static boolean Multiplication(double[] a, double[] b, double[] sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "ebeMultiply"){
			  double[] sum1 = MethodsFromApacheMath.ebeMultiply(mult(a), mult(b));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "ebeDivide"){
			  double[] sum1 = MethodsFromApacheMath.ebeDivide(mult(a), mult(b));
			  result = multTest(sum, sum1);  
		  }
		  else if(methodName == "ebeAdd"){
			  double[] sum1 = MethodsFromApacheMath.ebeAdd(mult(a), mult(b));
			  result = multTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Multiplication(double[] a, int b, double sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "polevl"){
			  double first = FrameMethod.getDouble();
			  double sum1 =  MethodsFromColt.polevl(first, mult(a), mult(b));
			  result = multTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Multiplication(double[] a, int b, int c, double sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
	/*	  if(methodName == "winsorizedMean"){
			  //double first = FrameMethod.getDouble();
			  double sum1 =  MethodsFromColt.winsorizedMean(mult(a), mult(b),  mult(c));
			  result = multTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  //Inclusive
	  public static boolean Inclusive(int[] Original , int sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inclusive MR
		/*  if(methodName == "sequential_search"){
			  int key = getInt();
			  int sum1 = MethodCollection2.sequential_search(inc(Original), key);
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "add_values"){
			  int sum1 = MethodCollection2.add_values(inc(Original));
			  result = incTest(sum, sum1);
		  }
		  
		  else if(methodName == "find_min"){
			  int sum1 = MethodCollection2.find_min(inc(Original));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "count_k"){
			  int key = getInt();
			  int sum1 = MethodCollection2.count_k(inc(Original), key);
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "count_non_zeroes"){
			  int sum1 = MethodCollection2.count_non_zeroes(inc(Original));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "cnt_zeroes"){
			  int sum1 = MethodCollection2.cnt_zeroes(inc(Original));
			  result = incTest(sum, sum1);
		  }*/
		
		  return result;
	  }
	  
	  public static boolean Inclusive(int[] Original , double sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "find_magnitude"){
			  double sum1 = MethodCollection2.find_magnitude(inc(Original));
			  result =incTest(sum, sum1); 
		  }
		  else if(methodName == "geometric_mean"){
			  double sum1 = MethodCollection2.geometric_mean(inc(Original));
			  result =incTest(sum, sum1); 
		  }*/
		  
		  return result;
	  }
	  
	  public static boolean Inclusive(int[] a , int[] b, int sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inclusive MR
		/*  if(methodName == "dot_product"){
			  
			  int sum1 = MethodCollection2.dot_product(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "hamming_dist"){
			  
			  int sum1 = MethodCollection2.hamming_dist(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }*/
		  
		  return result;
	  }
	
	  public static boolean Inclusive(int[] a , int[] b, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inclusive MR
		 /* if(methodName == "find_euc_dist"){
			  
			  double sum1 = MethodCollection2.find_euc_dist(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "manhattan_dist"){
			  
			  double sum1 = MethodCollection2.manhattan_dist(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }*/
		  
		  return result;
	  }
	  
	  public static boolean Inclusive(double[] agr1, double[] agr2, int start, int length, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		/*  if(methodName == "evaluateWeightedProduct"){
			  double sum1 = MethodsFromApacheMath.evaluateWeightedProduct(inc(agr1),inc(agr2), start, length);
			  result = incTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Inclusive(double[] a , double[] b, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inclusive MR
		/*  if(methodName == "chiSquare"){
			  
			  double sum1 = MethodsFromApacheMath.chiSquare(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "equals"){
			  
			  boolean sum1 = MethodsFromApacheMath.equals(inc(a), inc(b));
			  result = sum1;
		  }
		  else if(methodName == "evaluateNewton"){
			  double thirdArg = FrameMethod.getDouble();
			  double sum1 = MethodsFromApacheMath.evaluateNewton(inc(a), inc(b), inc(thirdArg));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "computeCanberraDistance"){
			  
			  double sum1 = MethodsFromApacheMath.computeCanberraDistance(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "distanceInf"){
			  
			  double sum1 = MethodsFromApacheMath.distanceInf(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }
		  else if(methodName == "distance1"){
			  
			  double sum1 = MethodsFromApacheMath.distance1(inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }*/
		  
		  return result;
	  }
	  
	  public static boolean Inclusive(double[] Original , double sum, String methodName){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "evaluateHoners"){
			  double secondArg = FrameMethod.getDouble();
			  double sum1 = MethodsFromApacheMath.evaluateHoners(inc(Original), inc(secondArg));
			  result =incTest(sum, sum1); 
		  }*/
		 
		  return result;
	  }
	  
	  public static boolean Inclusive(double[] a , int b, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inclusive MR
		/*  if(methodName == "polevl"){
			  double first = FrameMethod.getDouble();
			  double sum1 = MethodsFromColt.polevl(first, inc(a), inc(b));
			  result = incTest(sum, sum1);
		  }*/
		  return result;
	  }
	  
	  
	  //Exclusive
	  public static boolean Exclusive(int[] Original, int sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Exclusive MR
		/*  if(methodName == "sequential_search"){
			  int key = getInt(); 
			  int sum1 = MethodCollection2.sequential_search(exc(Original), key);
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "add_values"){
			  int sum1 = MethodCollection2.add_values(exc(Original));
			  result = excTest(sum, sum1);  
		  }
		  else if(methodName == "count_k"){
			  int key = getInt(); 
			  int sum1 = MethodCollection2.count_k(exc(Original), key);
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "count_non_zeroes"){
			  int sum1 = MethodCollection2.count_non_zeroes(exc(Original));
			  result = excTest(sum, sum1);  
		  }
		  else if(methodName == "cnt_zeroes"){
			  int sum1 = MethodCollection2.cnt_zeroes(exc(Original));
			  result = excTest(sum, sum1);  
		  }*/
		 
		  return result;
	  }
	 
	  public static boolean Exclusive(int[] Original, double sum, String methodName){
		  boolean result = true;
		  
		/*  if(methodName == "geometric_mean"){
			  double sum1 = MethodCollection2.geometric_mean(exc(Original));
			  result = excTest(sum, sum1);  
		  }*/
		  
		  return result;
	  
	  }
	  
	  public static boolean Exclusive(double[] Original, double sum, String methodName){
		  boolean result = true;
		  
		/*  if(methodName == "sumOfPowerOfDeviations"){
			  int arg2 = FrameMethod.getInt();
				double arg3 = FrameMethod.getDouble();
			  double sum1 = MethodsFromColt.sumOfPowerOfDeviations(exc(Original), arg2, arg3);
			  result = excTest(sum, sum1);  
		  }
		  else if(methodName == "sumOfLogarithms"){
			  double sum1 = MethodsFromColt.sumOfLogarithms(exc(Original));
			  result = excTest(sum, sum1);  
		  }*/
		  return result;
	  
	  }
	  
	  public static boolean Exclusive(int[] a, int[] b,int sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Exclusive MR
		/*  if(methodName == "dot_product"){
			 
			  int sum1 = MethodCollection2.dot_product(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "hamming_dist"){
			 
			  int sum1 = MethodCollection2.hamming_dist(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }*/
		  
		  return result;
	  }
	
	  public static boolean Exclusive(int[] a, int[] b,double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Exclusive MR
		/*  if(methodName == "find_euc_dist"){
			 
			  double sum1 = MethodCollection2.find_euc_dist(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "manhattan_dist"){
			 
			  double sum1 = MethodCollection2.manhattan_dist(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }*/
		  
		  return result;
	  }
	  
	  public static boolean Exclusive(double[] agr1, double[] agr2, int start, int length, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Multiplication MR
		/*  if(methodName == "evaluateWeightedProduct"){
			  double sum1 = MethodsFromApacheMath.evaluateWeightedProduct(exc(agr1),exc(agr2), start, length);
			  result = excTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Exclusive(double[] a, double[] b,double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Exclusive MR
		/*  if(methodName == "chiSquare"){
			 
			  double sum1 = MethodsFromApacheMath.chiSquare(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "evaluateNewton"){
			  double thirdArg = FrameMethod.getDouble();
			  double sum1 = MethodsFromApacheMath.evaluateNewton(exc(a), exc(b), exc(thirdArg));
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "computeCanberraDistance"){
			 
			  double sum1 = MethodsFromApacheMath.computeCanberraDistance(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "distance1"){
				 
			  double sum1 = MethodsFromApacheMath.distance1(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }
		  else if(methodName == "distanceInf"){
				 
			  double sum1 = MethodsFromApacheMath.distanceInf(exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }*/
		 
		  return result;
	  }
	  
	  public static boolean Exclusive(double[] a, int b, double sum, String methodName){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Exclusive MR
		/*  if(methodName == "polevl"){
			  double first = FrameMethod.getDouble();
			  double sum1 = MethodsFromColt.polevl(first, exc(a), exc(b));
			  result = excTest(sum, sum1);
		  }*/
		  return result;
	  }
	  
	  //Inversion
	  public static boolean Inversion(int[] Original, int sum,String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		 
		/*  if(methodName == "sequential_search"){
			  int key = getInt();
			  int sum1 = MethodCollection2.sequential_search(inv(Original), key);
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "add_values"){
			  int sum1 = MethodCollection2.add_values(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "find_min"){
			  int sum1 = MethodCollection2.find_min(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "find_max"){
			  int sum1 = MethodCollection2.find_max(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		 
		  else if(methodName == "count_non_zeroes"){
			  int sum1 = MethodCollection2.count_non_zeroes(inv(Original));
			  result = invTest(sum, sum1);  
		  }*/
		  return result;
	  } 
	  
	  public static boolean Inversion(int[] Original, double sum,String methodName ){
		  boolean result = true;		 
		  //follow up test case
		  //Addition MR
		/*  if(methodName == "find_magnitude"){
			  double sum1 = MethodCollection2.find_magnitude(inv(Original));
			  result =invTest(sum, sum1); 
		  }
		  else if(methodName == "average"){
			  double sum1 = MethodCollection2.average(inv(Original));
			  result =invTest(sum, sum1); 
		  }
		  else if(methodName == "geometric_mean"){
			  double sum1 = MethodCollection2.geometric_mean(inv(Original));
			  result =invTest(sum, sum1); 
		  }
		  else if(methodName == "find_median"){
			  double sum1 = MethodCollection2.find_median(inv(Original));
			  result =invTest(sum, sum1); 
		  }*/
		 
		  return result;
	  }
	  
	  public static boolean Inversion(double[] Original, double sum,String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		 
		/*  if(methodName == "variance"){
			  
			  double sum1 = MethodCollection2.variance(inv(Original));
			  result = invTest(sum, sum1);  
		  }*/
		/*  else if(methodName == "evaluateHoners"){
			  double secondArg = FrameMethod.getDouble();
			  double sum1 = MethodsFromApacheMath.evaluateHoners(inv(Original) ,inv(secondArg));
			  result = invTest(sum, sum1);  
		  }
		  
		  else if(methodName == "entropy"){
			 // double secondArg = FrameMethod.getDouble();
			  double sum1 = MethodsFromApacheMath.entropy(inv(Original));
			  result = invTest(sum, sum1);  
		  }*/
		
		  return result;
	  }
	  
	  public static boolean Inversion(int[] Original, int[] sum, String methodName ){

		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
	/*	  if(methodName == "bubble"){
			  int[] sum1 = MethodCollection2.bubble(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "shell_sort"){
			  int[] sum1 = MethodCollection2.shell_sort(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "selection_sort"){
			  int[] sum1 = MethodCollection2.selection_sort(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  
		  else if(methodName == "set_min_val"){
			  int key = getInt();
			  int[] sum1 = MethodCollection2.set_min_val(inv(Original), key);
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "array_copy"){
			  int[] sum1 = MethodCollection2.array_copy(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "insertion_sort"){
			  int[] sum1 = MethodCollection2.insertion_sort(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "reverse"){
			  int[] sum1 = MethodCollection2.reverse(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  
		  else if(methodName == "clip"){
			  int upperlim = FrameMethod.getInt();
			  int lowerlim = FrameMethod.getInt();
			  int[] sum1 = MethodCollection2.clip(inv(Original), upperlim, lowerlim);
			  result = invTest(sum, sum1); 
		  }*/
		  return result;
	  } 

	  public static boolean Inversion(int[] a, int[] b, double sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		/*  if(methodName == "find_euc_dist"){
			  double sum1 = MethodCollection2.find_euc_dist(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  } 
		  else if(methodName == "manhattan_dist"){
			  double sum1 = MethodCollection2.manhattan_dist(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "mean_absolute_error"){
			  double sum1 = MethodCollection2.mean_absolute_error(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }*/
		  return result;
	  }

	  public static boolean Inversion(int[] a, int[] b, int sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		/*  if(methodName == "hamming_dist"){
			  int sum1 = MethodCollection2.hamming_dist(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  } */
		  return result;
	  }
	  public static boolean Inversion(int[] a, int[] b, int[] sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		 /* if(methodName == "add"){
			  int[] sum1 = MethodsFromMahout.add(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  } */
		  return result;
	  }
	  
	  public static boolean Inversion(double[] arr,int begin,int end,int pivot,  int sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		 /* if(methodName == "partition"){
			  int sum1 = MethodsFromApacheMath.partition(inv(arr), begin, end, pivot);
			  result = invTest(sum, sum1);  
		  } */
		  return result;
	  }
	  
	  public static boolean Inversion(double[] a, double[] b, double sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		/*  if(methodName == "chiSquare"){
			  double sum1 = MethodsFromApacheMath.chiSquare(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  } 
		  else if(methodName == "meanDifference"){
			  double sum1 = MethodsFromApacheMath.meanDifference(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "evaluateNewton"){
			  double thirdArg = FrameMethod.getDouble();
			  double sum1 = MethodsFromApacheMath.evaluateNewton(inv(a), inv(b), inv(thirdArg));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "evaluateInternal"){
			  double thirdArg = FrameMethod.getDouble();
			  double sum1 = MethodsFromApacheMath.evaluateInternal(inv(a), inv(b), inv(thirdArg));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "computeCanberraDistance"){
			  double sum1 = MethodsFromApacheMath.computeCanberraDistance(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "g"){
			  double sum1 = MethodsFromApacheMath.g(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "distanceInf"){
			  double sum1 = MethodsFromApacheMath.distanceInf(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "distance1"){
			  double sum1 = MethodsFromApacheMath.distance1(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }*/
		  
		
		  return result;
	  }
	  
	  public static boolean Inversion(double[] Original, double[] sum, String methodName ){

		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		/*  if(methodName == "calculateAbsoluteDifferences"){
			  double[] sum1 = MethodsFromApacheMath.calculateAbsoluteDifferences(inv(Original));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "scale"){
			  double arg1 = FrameMethod.getDouble();
			  double[] sum1 = MethodsFromApacheMath.scale(arg1, inv(Original));
			  result = invTest(sum, sum1);  
		  }*/
		 
		  return result;
	  }
	  
	  public static boolean Inversion(double[] a, double[] b, double[] sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		/*  if(methodName == "ebeMultiply"){
			  double[] sum1 = MethodsFromApacheMath.ebeMultiply(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  } 
		  else if(methodName == "ebeAdd"){
			  double[] sum1 = MethodsFromApacheMath.ebeAdd(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }
		  else if(methodName == "ebeDivide"){
			  double[] sum1 = MethodsFromApacheMath.ebeDivide(inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  }*/
		  return result;
	  }
	  
	  public static boolean Inversion(double[] a, int b, double sum, String methodName ){
		  boolean result = true;
		  //int sum = MethodCollection2.add_values(Original);
		  //follow up test case
		  //Inversion MR
		/*  if(methodName == "polevl"){
			  double first = FrameMethod.getDouble();
			  double sum1 =MethodsFromColt.polevl(first, inv(a), inv(b));
			  result = invTest(sum, sum1);  
		  } */
		 
		  return result;
	  }
	  

}
