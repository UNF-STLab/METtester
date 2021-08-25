// This is a mutant program.
// Author : ysma

public class MethodsFromColt
{

    public static  double autoCorrelation( double[] data, int lag, double mean, double variance )
    {
        int N = data.length;
        double run = 0;
        for (int i = lag; i < N; ++i) {
            run += (data[i] - mean) * (data[i - lag] - mean);
        }
        return run / (N - lag) / variance;
    }

    public static  int binarySearchFromTo( double[] elements, double key, int from, int to )
    {
        int low = from;
        int high = to;
        while (low <= high) {
            int mid = (low + high) / 2;
            double midVal = elements[mid];
            if (midVal < key) {
                low = mid + 1;
            } else {
                if (midVal > key) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -(low + 1);
    }

    public static  double covariance( double[] elements1, double[] elements2 )
    {
        int size = elements1.length;
        double sumx = elements1[0];
        double sumy = elements2[0];
        double Sxy = 0;
        for (int i = 1; i < size; ++i) {
            double x = elements1[i];
            double y = elements2[i];
            sumx += x;
            Sxy += (x - sumx / (i + 1)) * (y - sumy / i);
            sumy += y;
        }
        return Sxy / (size - 1);
    }

    public static  double durbinWatson( double[] elements )
    {
        int size = elements.length;
        double run = 0;
        for (int i = 1; i < size; ++i) {
            double x = elements[i] - elements[i - 1];
            run += x * x;
        }
        return run;
    }

    public static  double lag1( double[] elements, double mean )
    {
        int size = elements.length;
        double r1;
        double q = 0;
        double v = (elements[0] - mean) * (elements[0] - mean);
        for (int i = 1; i < size; i++) {
            double delta0 = elements[i - 1] - mean;
            double delta1 = elements[i] - mean;
            q += (delta0 * delta1 - q) / (i + 1);
            v += (delta1 * delta1 - v) / (i + 1);
        }
        r1 = q / v;
        return r1;
    }

    public static  double max( double[] elements )
    {
        int size = elements.length;
        double max = elements[size - 1];
        for (int i = size - 1; --i >= 0;) {
            if (elements[i] > max) {
                max = elements[i];
            }
        }
        return max;
    }

    public static  double meanDeviation( double[] elements, double mean )
    {
        int size = elements.length;
        double sum = 0;
        for (int i = size; --i >= 0;) {
            sum += Math.abs( elements[i] - mean );
        }
        return sum / size;
    }

    public static  double min( double[] elements )
    {
        int size = elements.length;
        double min = elements[size - 1];
        for (int i = size - 1; --i >= 0;) {
            if (elements[i] < min) {
                min = elements[i];
            }
        }
        return min;
    }

    public static  double product( double[] elements )
    {
        int size = elements.length;
        double product = 1;
        for (int i = size; --i >= 0;) {
            product *= elements[i];
        }
        return product;
    }

    public static  double quantile( double[] sortedElements, double phi )
    {
        int n = sortedElements.length;
        double index = phi * (n - 1);
        int lhs = (int) index;
        double delta = index - lhs;
        double result;
        if (n == 0) {
            return 0.0;
        }
        if (lhs == n - 1) {
            result = sortedElements[lhs];
        } else {
            result = (1 - delta) * sortedElements[lhs] + delta * sortedElements[lhs + 1];
        }
        return result;
    }

    public static  double sampleKurtosis( int size, double moment4, double sampleVariance )
    {
        int n = size;
        double s2 = sampleVariance;
        double m4 = moment4 * n;
        return m4 * n * (n + 1) / ((n - 1) * (n - 2) * (n - 3) * s2 * s2) - 3.0 * (n - 1) * (n - 1) / ((n - 2) * (n - 3));
    }

    public static  double sampleKurtosisStandardError( int size )
    {
        int n = size;
        return Math.sqrt( 24.0 * n * (n - 1) * (n - 1) / ((n - 3) * (n - 2) * (n + 3) * (n + 5)) );
    }

    public static  double sampleSkew( int size, double moment3, double sampleVariance )
    {
        int n = size;
        double s = Math.sqrt( sampleVariance );
        double m3 = moment3 * n;
        return n * m3 / ((n - 1) * (n - 2) * s * s * s);
    }

    public static  double sampleVariance( double[] elements, double mean )
    {
        int size = elements.length;
        double sum = 0;
        for (int i = size; --i >= 0;) {
            double delta = elements[i] - mean;
            sum += delta * delta;
        }
        return sum / (size - 1);
    }

    public static  double sumOfLogarithms( double[] elements )
    {
        double logsum = 0;
        for (int i = 0; i < elements.length; i++) {
            logsum += Math.log( elements[i] );
        }
        return logsum;
    }

    public static  double trimmedMean( double[] sortedElements, double mean, int left, int right )
    {
        int N = sortedElements.length;
        int N0 = N;
        for (int i = 0; i < left; ++i) {
            mean += (mean - sortedElements[i]) / --N;
        }
        for (int i = 0; i < right; ++i) {
            mean += (mean - sortedElements[N0 - 1 - i]) / --N;
        }
        return mean;
    }

    public static  double weightedMean( double[] elements, double[] theWeights )
    {
        int size = elements.length;
        double sum = 0.0;
        double weightsSum = 0.0;
        for (int i = size; --i >= 0;) {
            double w = theWeights[i];
            sum += elements[i] * w;
            weightsSum += w;
        }
        return sum / weightsSum;
    }

    public static  int binarySearchFromTo( int[] list, int key, int from, int to )
    {
        int midVal;
        while (from <= to) {
            int mid = (from + to) / 2;
            midVal = list[mid];
            if (midVal < key) {
                from = mid + 1;
            } else {
                if (midVal > key) {
                    to = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -(from + 1);
    }

    public static  double binomial( double n, long k )
    {
        if (k < 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        double a = n - k + 1;
        double b = 1;
        double binomial = 1;
        for (long i = k; i-- > 0;) {
            binomial *= a++ / b++;
        }
        return binomial;
    }

    public static  double link( double r )
    {
        if (r < 0.0) {
            double s = Math.exp( r );
            return s / (1.0 + s);
        } else {
            double s = Math.exp( -r );
            return 1.0 / (1.0 + s);
        }
    }

    public static  double winsorizedMean( double[] sortedElements, int left, int right )
    {
        int N = sortedElements.length;
        double sum = 0;
        for (int i = 0; i < sortedElements.length; i++) {
            sum += sortedElements[i];
        }
        double mean = sum / sortedElements.length;
        double leftElement = sortedElements[left];
        for (int i = 0; i < left; ++i) {
            mean += (leftElement - sortedElements[i]) / N;
        }
        double rightElement = sortedElements[N - 1 - right];
        for (int i = 0; i < right; ++i) {
            mean += (rightElement - sortedElements[N - 1 - i]) / N;
        }
        return mean;
    }

    public static  double geometricPdf( int k, double p )
    {
        return p * Math.pow( 1 - p, k );
    }

    public static  double kurtosis( double[] data )
    {
        double sum = 0;
        double sumPD = 0;
        double sumSq = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            sumSq += data[i] * data[i];
        }
        double mean = sum / data.length;
        double standardDeviation = Math.sqrt( (sumSq - mean * sum) / data.length );
        for (int i = 0; i < data.length; i++) {
            sumPD += Math.pow( data[i] - mean, 4 );
        }
        double moment4 = sumPD / data.length;
        return -3 + moment4 / (standardDeviation * standardDeviation * standardDeviation * standardDeviation);
    }

    public static  double logGamma( double xx )
    {
        double[] cof = { 76.18009172947146, -86.50532032941677, 24.01409824083091, -1.231739572450155, 0.1208650973866179e-2, -0.5395239384953e-5 };
        double x = xx - 1.0;
        double tmp = x + 5.5;
        tmp -= (x + 0.5) * Math.log( tmp );
        double ser = 1.000000000190015;
        double[] coeff = cof;
        for (int j = 0; j <= 5; j++) {
            x++;
            ser += coeff[j] / x;
        }
        return -tmp + Math.log( 2.5066282746310005 * ser );
    }

    public static  double pooledMean( double[] data1, double[] data2 )
    {
        double sum1 = 0;
        for (int i = 0; i < data1.length; i++) {
            sum1 += data1[i];
        }
        double mean1 = sum1 / data1.length;
        double sum2 = 0;
        for (int i = 0; i < data2.length; i++) {
            sum2 += data2[i];
        }
        double mean2 = sum2 / data2.length;
        return (data1.length * mean1 + data2.length * mean2) / (data1.length + data2.length);
    }

    public static  double pooledVariance( double[] data1, double[] data2 )
    {
        double sum1 = 0;
        double sumSq1 = 0;
        for (int i = 0; i < data1.length; i++) {
            sum1 += data1[i];
            sumSq1 += data1[i] * data1[i];
        }
        double mean1 = sum1 / data1.length;
        double var1 = (sumSq1 - mean1 * sum1) / data1.length;
        double sum2 = 0;
        double sumSq2 = 0;
        for (int i = 0; i < data2.length; i++) {
            sum2 += data2[i];
            sumSq2 += data2[i] * data2[i];
        }
        double mean2 = sum2 / data2.length;
        double var2 = (sumSq2 - mean2 * sum2) / data2.length;
        return (data1.length * var1 + data2.length * var2) / (data1.length + data2.length);
    }

    public static  double polevl( double x, double[] coef, int N )
        throws java.lang.ArithmeticException
    {
        double ans;
        ans = coef[0];
        for (int i = 1; i <= N; i++) {
            ans = ans * x + coef[i];
        }
        return ans;
    }

    public static  double rankInterpolated( double[] sortedList, double element, int index )
    {
        if (index >= 0) {
            int to = index + 1;
            int s = sortedList.length;
            while (to < s && sortedList[to] == element) {
                to++;
            }
            return to;
        }
        int insertionPoint = -index - 1;
        if (insertionPoint == 0 || insertionPoint == sortedList.length) {
            return insertionPoint;
        }
        double from = sortedList[insertionPoint - 1];
        double to = sortedList[insertionPoint];
        double delta = (element - from) / (to - from);
        return insertionPoint + delta;
    }

    public static  double sampleWeightedVariance( double[] data, double[] weights )
    {
        double sumOfWeights = 0;
        double sumOfProducts = 0;
        double sumOfSquaredProducts = 0;
        for (int i = 0; i < data.length; i++) {
            sumOfWeights += weights[i];
            sumOfProducts += data[i] * weights[i];
            sumOfSquaredProducts += data[i] * data[i] * weights[i];
        }
        return (sumOfSquaredProducts - sumOfProducts * sumOfProducts / sumOfWeights) / (sumOfWeights - 1);
    }

    public static  double skew( double[] data )
    {
        double sum = 0;
        double sumPD = 0;
        double sumSq = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            sumSq += data[i] * data[i];
        }
        double mean = sum / data.length;
        double standardDeviation = Math.sqrt( (sumSq - mean * sum) / data.length );
        for (int i = 0; i < data.length; i++) {
            sumPD += Math.pow( data[i] - mean, 3 );
        }
        double moment3 = sumPD / data.length;
        return moment3 / (standardDeviation * standardDeviation * standardDeviation);
    }

    public static  double[] standardize( double[] data )
    {
        double sum = 0;
        double sumSq = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            sumSq += data[i] * data[i];
        }
        double mean = sum / data.length;
        double sd = Math.sqrt( (sumSq - mean * sum) / data.length );
        for (int i = 0; i < data.length; i++) {
            data[i] = (data[i] - mean) / sd;
        }
        return data;
    }

    public static  double weightedRMS( double[] data, double[] weights )
    {
        double sumOfProducts = 0;
        double sumOfSquaredProducts = 0;
        for (int i = 0; i < data.length; i++) {
            sumOfProducts += data[i] * weights[i];
            sumOfSquaredProducts = data[i] * data[i] * weights[i];
        }
        return sumOfProducts / sumOfSquaredProducts;
    }

    public static  double harmonicMean( double[] data )
    {
        double sumOfInversions = 0;
        for (int i = 0; i < data.length; i++) {
            sumOfInversions += 1 / data[i];
        }
        return data.length / sumOfInversions;
    }

    public static  double sumOfPowerOfDeviations( double[] data, int k, double c )
    {
        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += Math.pow( data[i] - c, k );
        }
        return sum;
    }

    public static  double[] power( double[] data, int k )
    {
        for (int i = 0; i < data.length; i++) {
            data[i] = Math.pow( data[i], k );
        }
        return data;
    }

    public static  double[] square( double[] data )
    {
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i] * data[i];
        }
        return data;
    }

    public static  void main( java.lang.String[] args )
    {
        double[] d = { 12, 13, 25, 11, 10 };
        System.out.println( durbinWatson( d ) );
        double[] d1 = { 25, 11, 12, 13, 10 };
        System.out.println( durbinWatson( d1 ) );
    }

}
