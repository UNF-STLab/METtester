//import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Random;
//import com.google.common.collect.Lists;

public class MethodsFromMahout {
	
	public static double cosineDistance(double[] p1, double[] p2) {
	    double dotProduct = 0.0;
	    double lengthSquaredp1 = 0.0;
	    double lengthSquaredp2 = 0.0;
	    for (int i = 0; i < p1.length; i++) {
	      lengthSquaredp1 += p1[i] * p1[i];
	      lengthSquaredp2 += p2[i] * p2[i];
	      dotProduct += p1[i] * p2[i];
	    }
	    double denominator = Math.sqrt(lengthSquaredp1) * Math.sqrt(lengthSquaredp2);
	    
	    // correct for floating-point rounding errors
	    if (denominator < dotProduct) {
	      denominator = dotProduct;
	    }
	    
	    // correct for zero-vector corner case
	    if (denominator == 0 && dotProduct == 0) {
	      return 0;
	    }
	    
	    return 1.0 - dotProduct / denominator;
	  }
	
	 public static double manhattanDistance(double[] p1, double[] p2) {
		    double result = 0.0;
		    for (int i = 0; i < p1.length; i++) {
		      result += Math.abs(p2[i] - p1[i]);
		    }
		    return result;
		  }
	 //this was implemented by me since Mahout implementation relies on oo design
	 public static double chebyshevDistance(double[] p1, double[] p2)
	 {
		 if (p1.length != p2.length) {
		      System.out.println("Error!");
		      return -1;
		    }
		 double maxDiff=Math.abs(p1[0]-p2[0]);
		 for(int i=1;i<p1.length;i++)

			 {
			 	double diff=Math.abs(p1[i]-p2[i]);
			 	if(maxDiff<diff)
			 	{
			 		maxDiff=diff;
			 	}
			
			 }
		 return maxDiff;
	 }
	 
	//this was implemented by me since Mahout implementation relies on oo design
	 /**
	   * Calculates the distance between two vectors.
	   * 
	   * The coefficient (a measure of similarity) is: T(a, b) = a.b / (|a|^2 + |b|^2 - a.b)
	   * 
	   * The distance d(a,b) = 1 - T(a,b)
	   * 
	   * @return 0 for perfect match, > 0 for greater distance
	   */
	 public static double tanimotoDistance(double[] p1, double[] p2)
	 {
		 	double ab=0,aSq=0,bSq=0;
		 	for(int i=0;i<p1.length;i++)
		 	{
		 		ab+=p1[i]*p2[i];
		 		aSq+=p1[i]*p1[i];
		 		bSq+=p2[i]*p2[i];
		 		
		 	}
		 	double denominator=aSq+bSq-ab;
		    
		    if (denominator < ab) { // correct for fp round-off: distance >= 0
		      denominator = ab;
		    }
		    if (denominator > 0) {
		      // denominator == 0 only when dot(a,a) == dot(b,b) == dot(a,b) == 0
		      return 1.0 - ab / denominator;
		    } else {
		      return 0.0;
		    }
	 }
	 /*
	 public static int binarySearchFromTo(int[] array, int value, int from, int to) {
		    int mid = -1;
		    while (from <= to) {
		      mid = (from + to) >>> 1;
		      if (value > array[mid]) {
		        from = mid + 1;
		      } else if (value == array[mid]) {
		        return mid;
		      } else {
		        to = mid - 1;
		      }
		    }
		    if (mid < 0) {
		      return -1;
		    }
		    return -mid - (value < array[mid] ? 1 : 2);
		  }
		  */
	 
	 public static int sum(int[] values) {
		    int sum = 0;
		    for (int value : values) {
		      sum += value;
		    }
		    
		    return sum;
		  }
		  
	 /**
	   * foreach i : array1[i] += array2[i]
	   */
	/*  public static int[] add(int[] array1, int[] array2) {
	    Preconditions.checkArgument(array1.length == array2.length, "array1.length != array2.length");
	    for (int index = 0; index < array1.length; index++) {
	      array1[index] += array2[index];
	    }
	    return array1;
	  }*/

	  /**
	   * foreach i : array1[i] -= array2[i]
	   */
	 /* public static int[] dec(int[] array1, int[] array2) {
	    Preconditions.checkArgument(array1.length == array2.length, "array1.length != array2.length");
	    for (int index = 0; index < array1.length; index++) {
	      array1[index] -= array2[index];
	    }
	    return array1;
	  }*/
	  
	  /**
	   * return the index of the maximum of the array, breaking ties randomly
	   * 
	   * @param rng
	   *          used to break ties
	   * @return index of the maximum
	   */
	  /*
	  public static int maxindex(Random rng, int[] values) {
	    int max = 0;
	    List<Integer> maxindices = Lists.newArrayList();
	    
	    for (int index = 0; index < values.length; index++) {
	      if (values[index] > max) {
	        max = values[index];
	        maxindices.clear();
	        maxindices.add(index);
	      } else if (values[index] == max) {
	        maxindices.add(index);
	      }
	    }

	    return maxindices.size() > 1 ? maxindices.get(rng.nextInt(maxindices.size())) : maxindices.get(0);
	  }*/
	
	  /**
	   * Efficiently returns the binomial coefficient, often also referred to as "n over k" or "n choose k". The binomial
	   * coefficient is defined as <tt>(n * n-1 * ... * n-k+1 ) / ( 1 * 2 * ... * k )</tt>. <ul> <li>k<0<tt>: <tt>0</tt>.
	   * <li>k==0<tt>: <tt>1</tt>. <li>k==1<tt>: <tt>n</tt>. <li>else: <tt>(n * n-1 * ... * n-k+1 ) / ( 1 * 2 * ... * k
	   * )</tt>. </ul>
	   *
	   * @return the binomial coefficient.
	   */
	  /*
	  public static double binomial(double n, long k) {
	    if (k < 0) {
	      return 0;
	    }
	    if (k == 0) {
	      return 1;
	    }
	    if (k == 1) {
	      return n;
	    }

	    // binomial(n,k) = (n * n-1 * ... * n-k+1 ) / ( 1 * 2 * ... * k )
	    double a = n - k + 1;
	    double b = 1;
	    double binomial = 1;
	    for (long i = k; i-- > 0;) {
	      binomial *= (a++) / (b++);
	    }
	    return binomial;
	  }*/
	  
	  /**
	   * Evaluates the series of Chebyshev polynomials Ti at argument x/2. The series is given by
	   * <pre>
	   *        N-1
	   *         - '
	   *  y  =   >   coef[i] T (x/2)
	   *         -            i
	   *        i=0
	   * </pre>
	   * Coefficients are stored in reverse order, i.e. the zero order term is last in the array.  Note N is the number of
	   * coefficients, not the order. <p> If coefficients are for the interval a to b, x must have been transformed to x ->
	   * 2(2x - b - a)/(b-a) before entering the routine.  This maps x from (a, b) to (-1, 1), over which the Chebyshev
	   * polynomials are defined. <p> If the coefficients are for the inverted interval, in which (a, b) is mapped to (1/b,
	   * 1/a), the transformation required is x -> 2(2ab/x - b - a)/(b-a).  If b is infinity, this becomes x -> 4a/x - 1.
	   * <p> SPEED: <p> Taking advantage of the recurrence properties of the Chebyshev polynomials, the routine requires one
	   * more addition per loop than evaluating a nested polynomial of the same degree.
	   *
	   * @param x    argument to the polynomial.
	   * @param coef the coefficients of the polynomial.
	   * @param N    the number of coefficients.
	   */
	  /*
	  public static double chbevl(double x, double[] coef, int N) {

	    int p = 0;

	    double b0 = coef[p++];
	    double b1 = 0.0;
	    int i = N - 1;

	    double b2;
	    do {
	      b2 = b1;
	      b1 = b0;
	      b0 = x * b1 - b2 + coef[p++];
	    } while (--i > 0);

	    return 0.5 * (b0 - b2);
	  }
	  */
	  /**
	   * Evaluates the given polynomial of degree <tt>N</tt> at <tt>x</tt>, assuming coefficient of N is 1.0. Otherwise same
	   * as <tt>polevl()</tt>.
	   * <pre>
	   *                     2          N
	   * y  =  C  + C x + C x  +...+ C x
	   *        0    1     2          N
	   *
	   * where C  = 1 and hence is omitted from the array.
	   *        N
	   *
	   * Coefficients are stored in reverse order:
	   *
	   * coef[0] = C  , ..., coef[N-1] = C  .
	   *            N-1                   0
	   *
	   * Calling arguments are otherwise the same as polevl().
	   * </pre>
	   * In the interest of speed, there are no checks for out of bounds arithmetic.
	   *
	   * @param x    argument to the polynomial.
	   * @param coef the coefficients of the polynomial.
	   * @param N    the degree of the polynomial.
	   */
	  /*
	  public static double p1evl(double x, double[] coef, int N) {

	    double ans = x + coef[0];

	    for (int i = 1; i < N; i++) {
	      ans = ans * x + coef[i];
	    }

	    return ans;
	  }
	  */
	  /**
	   * Evaluates the given polynomial of degree <tt>N</tt> at <tt>x</tt>.
	   * <pre>
	   *                     2          N
	   * y  =  C  + C x + C x  +...+ C x
	   *        0    1     2          N
	   *
	   * Coefficients are stored in reverse order:
	   *
	   * coef[0] = C  , ..., coef[N] = C  .
	   *            N                   0
	   * </pre>
	   * In the interest of speed, there are no checks for out of bounds arithmetic.
	   *
	   * @param x    argument to the polynomial.
	   * @param coef the coefficients of the polynomial.
	   * @param N    the degree of the polynomial.
	   */
	  /*
	  public static double polevl(double x, double[] coef, int N) {
	    double ans = coef[0];

	    for (int i = 1; i <= N; i++) {
	      ans = ans * x + coef[i];
	    }

	    return ans;
	  }*/
	  
	  public static double[] givens(double a, double b, double[] csOut) {
		    if (b == 0) {
		      csOut[0] = 1;
		      csOut[1] = 0;
		      return csOut;
		    }
		    if (Math.abs(b) > Math.abs(a)) {
		      double tau = -a / b;
		      csOut[1] = 1 / Math.sqrt(1 + tau * tau);
		      csOut[0] = csOut[1] * tau;
		    } else {
		      double tau = -b / a;
		      csOut[0] = 1 / Math.sqrt(1 + tau * tau);
		      csOut[1] = csOut[0] * tau;
		    }
		    return csOut;
		  }
	  
	  /**
	   * Computes the binomial logistic inverse link function.
	   *
	   * @param r The value to transform.
	   * @return The logit of r.
	   */
	  public static double link(double r) {
	    if (r < 0.0) {
	      double s = Math.exp(r);
	      return s / (1.0 + s);
	    } else {
	      double s = Math.exp(-r);
	      return 1.0 / (1.0 + s);
	    }
	  }
	  
	  /**
	   * Computes the likelihood that a given output sequence was computed by a
	   * given model using the alpha values computed by the forward algorithm.
	   * // TODO I am a bit confused here - where is the output sequence referenced in the comment above in the code?
	   * @param alpha  Matrix of alpha values
	   * @param scaled Set to true if the alpha values are log-scaled.
	   * @return model likelihood.
	   */
	  /*
	  public static double modelLikelihood(Matrix alpha, boolean scaled) {
	    double likelihood = 0;
	    if (scaled) {
	      for (int i = 0; i < alpha.numCols(); ++i) {
	        likelihood += Math.exp(alpha.getQuick(alpha.numRows() - 1, i));
	      }
	    } else {
	      for (int i = 0; i < alpha.numCols(); ++i) {
	        likelihood += alpha.getQuick(alpha.numRows() - 1, i);
	      }
	    }
	    return likelihood;
	  }
	  */
	  
	  /**
	   * Compute the number of trees for a given partition. The first partition (0) may be longer than the rest of
	   * partition because of the remainder.
	   * 
	   * @param numMaps
	   *          total number of maps (partitions)
	   * @param numTrees
	   *          total number of trees to build
	   * @param partition
	   *          partition to compute the number of trees for
	   */
	  public static int nbTrees(int numMaps, int numTrees, int partition) {
	    int nbTrees = numTrees / numMaps;
	    if (partition == 0) {
	      nbTrees += numTrees - nbTrees * numMaps;
	    }
	    
	    return nbTrees;
	  }
	  /*
	  
	  public static void orthonormalizeColumns(Matrix mx) {

		    int n = mx.numCols();

		    for (int c = 0; c < n; c++) {
		      Vector col = mx.viewColumn(c);
		      for (int c1 = 0; c1 < c; c1++) {
		        Vector viewC1 = mx.viewColumn(c1);
		        col.assign(col.minus(viewC1.times(viewC1.dot(col))));

		      }
		      final double norm2 = col.norm(2);
		      col.assign(new DoubleFunction() {
		        @Override
		        public double apply(double x) {
		          return x / norm2;
		        }
		      });
		    }
		  }
		  */
	  
	  public static int stepSize(int recordNumber, double multiplier) {
		    int[] bumps = {1, 2, 5};
		    double log = Math.floor(multiplier * Math.log10(recordNumber));
		    int bump = bumps[(int) log % bumps.length];
		    int scale = (int) Math.pow(10, Math.floor(log / bumps.length));

		    return bump * scale;
		  }
	  /*
	  public static void applyGivensInPlace(double c, double s, double[] row1,
		      double[] row2, int offset, int len) {

		    int n = offset + len;
		    for (int j = offset; j < n; j++) {
		      double tau1 = row1[j];
		      double tau2 = row2[j];
		      row1[j] = c * tau1 - s * tau2;
		      row2[j] = s * tau1 + c * tau2;
		    }
		  }*/
	  public static double choose2(double n) {
		    return n * (n - 1) / 2;
		  }
	  
	  public static double computeWeight(double featureLabelWeight, double labelWeight, double alphaI,
		      double numFeatures) {
		    double numerator = featureLabelWeight + alphaI;
		    double denominator = labelWeight + alphaI * numFeatures;
		    return Math.log(numerator / denominator);
		  }
	  public static double computeWeight(double featureWeight, double featureLabelWeight,
		      double totalWeight, double labelWeight, double alphaI, double numFeatures) {
		    double numerator = featureWeight - featureLabelWeight + alphaI;
		    double denominator = totalWeight - labelWeight + alphaI * numFeatures;
		    return -Math.log(numerator / denominator);
		  }
	  public static double errorRate(double[] labels, double[] predictions) {
		    //Preconditions.checkArgument(labels.length == predictions.length, "labels.length != predictions.length");
		    double nberrors = 0; // number of instance that got bad predictions
		    double datasize = 0; // number of classified instances

		    for (int index = 0; index < labels.length; index++) {
		      if (predictions[index] == -1) {
		        continue; // instance not classified
		      }

		      if (predictions[index] != labels[index]) {
		        nberrors++;
		      }

		      datasize++;
		    }

		    return nberrors / datasize;
		  }

	  public static double[] fromRho(double rho, double[] csOut) {
		    if (rho == 1) {
		      csOut[0] = 0;
		      csOut[1] = 1;
		      return csOut;
		    }
		    if (Math.abs(rho) < 1) {
		      csOut[1] = 2 * rho;
		      csOut[0] = Math.sqrt(1 - csOut[1] * csOut[1]);
		      return csOut;
		    }
		    csOut[0] = 2 / rho;
		    csOut[1] = Math.sqrt(1 - csOut[0] * csOut[0]);
		    return csOut;
		  }

	  


}





	 



