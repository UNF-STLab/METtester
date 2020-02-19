// This is a mutant program.
// Author : ysma

public class MethodsFromApacheMath
{

    public static  double distance( double[] p1, double[] p2 )
    {
        double sum = 0;
        for (int i = 0; i < p1.length; i++) {
            final double dp = p1[i] - p2[i];
            sum += dp * dp;
        }
        return Math.sqrt( sum );
    }

    public static  double distance1( double[] p1, double[] p2 )
    {
        double sum = 0;
        for (int i = 0; i < p1.length; i++) {
            sum += Math.abs( p1[i] - p2[i] );
        }
        return sum;
    }

    public static  double distanceInf( double[] p1, double[] p2 )
    {
        double max = 0;
        for (int i = 0; i < p1.length; i++) {
            max = Math.max( max, Math.abs( p1[i] - p2[i] ) );
        }
        return max;
    }

    public static  double[] ebeAdd( double[] a, double[] b )
    {
        if (a.length != b.length) {
            return null;
        }
        final double[] result = a.clone();
        for (int i = 0; i < a.length; i++) {
            result[i] += b[i];
        }
        return result;
    }

    public static  double[] ebeDivide( double[] a, double[] b )
    {
        if (a.length != b.length) {
            return null;
        }
        final double[] result = a.clone();
        for (int i = 0; i < a.length; i++) {
            result[i] /= b[i];
        }
        return result;
    }

    public static  double[] ebeMultiply( double[] a, double[] b )
    {
        if (a.length != b.length) {
            return null;
        }
        final double[] result = a.clone();
        for (int i = 0; i < a.length; i++) {
            result[i] *= b[i];
        }
        return result;
    }

    public static  double[] ebeSubtract( double[] a, double[] b )
    {
        if (a.length != b.length) {
            return null;
        }
        final double[] result = a.clone();
        for (int i = 0; i < a.length; i++) {
            result[i] -= b[i];
        }
        return result;
    }

    public static  double safeNorm( double[] v )
    {
        double rdwarf = 3.834e-20;
        double rgiant = 1.304e+19;
        double s1 = 0;
        double s2 = 0;
        double s3 = 0;
        double x1max = 0;
        double x3max = 0;
        double floatn = v.length;
        double agiant = rgiant / floatn;
        for (int i = 0; i < v.length; i++) {
            double xabs = Math.abs( v[i] );
            if (xabs < rdwarf || xabs > agiant) {
                if (xabs > rdwarf) {
                    if (xabs > x1max) {
                        double r = x1max / xabs;
                        s1 = 1 + s1 * r * r;
                        x1max = xabs;
                    } else {
                        double r = xabs / x1max;
                        s1 += r * r;
                    }
                } else {
                    if (xabs > x3max) {
                        double r = x3max / xabs;
                        s3 = 1 + s3 * r * r;
                        x3max = xabs;
                    } else {
                        if (xabs != 0) {
                            double r = xabs / x3max;
                            s3 += r * r;
                        }
                    }
                }
            } else {
                s2 += xabs * xabs;
            }
        }
        double norm;
        if (s1 != 0) {
            norm = x1max * Math.sqrt( s1 + s2 / x1max / x1max );
        } else {
            if (s2 == 0) {
                norm = x3max * Math.sqrt( s3 );
            } else {
                if (s2 >= x3max) {
                    norm = Math.sqrt( s2 * (1 + x3max / s2 * (x3max * s3)) );
                } else {
                    norm = Math.sqrt( x3max * (s2 / x3max + x3max * s3) );
                }
            }
        }
        return norm;
    }

    public static  double[] scale( double val, final double[] arr )
    {
        double[] newArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i] * val;
        }
        return newArr;
    }

    public static  double entropy( final double[] k )
    {
        double h = 0d;
        double sum_k = 0d;
        for (int i = 0; i < k.length; i++) {
            sum_k += (double) k[i];
        }
        for (int i = 0; i < k.length; i++) {
            if (k[i] != 0) {
                final double p_i = (double) k[i] / sum_k;
                h += p_i * Math.log( p_i );
            }
        }
        return -h;
    }

    public static  double g( final double[] expected, final double[] observed )
    {
        double sumExpected = 0d;
        double sumObserved = 0d;
        for (int i = 0; i < observed.length; i++) {
            sumExpected += expected[i];
            sumObserved += observed[i];
        }
        double ratio = 1d;
        boolean rescale = false;
        if (Math.abs( sumExpected - sumObserved ) > 10E-6) {
            ratio = sumObserved / sumExpected;
            rescale = true;
        }
        double sum = 0d;
        for (int i = 0; i < observed.length; i++) {
            final double dev = rescale ? Math.log( (double) observed[i] / (ratio * expected[i]) ) : Math.log( (double) observed[i] / expected[i] );
            sum += (double) observed[i] * dev;
        }
        return 2d * sum;
    }

    public static  double[] calculateAbsoluteDifferences( double[] z )
    {
        if (z == null) {
            return null;
        }
        if (z.length == 0) {
            return null;
        }
        final double[] zAbs = new double[z.length];
        for (int i = 0; i < z.length; ++i) {
            zAbs[i] = Math.abs( z[i] );
        }
        return zAbs;
    }

    public static  double[] calculateDifferences( final double[] x, final double[] y )
    {
        final double[] z = new double[x.length];
        for (int i = 0; i < x.length; ++i) {
            z[i] = y[i] - x[i];
        }
        return z;
    }

    public static  double[] computeDividedDifference( final double[] x, final double[] y )
    {
        final double[] divdiff = y.clone();
        final int n = x.length;
        final double[] a = new double[n];
        a[0] = divdiff[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                final double denominator = x[j + i] - x[j];
                divdiff[j] = (divdiff[j + 1] - divdiff[j]) / denominator;
            }
            a[i] = divdiff[0];
        }
        return a;
    }

    public static  double computeCanberraDistance( double[] a, double[] b )
    {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            final double num = Math.abs( a[i] - b[i] );
            final double denom = Math.abs( a[i] ) + Math.abs( b[i] );
            sum += num == 0.0 && denom == 0.0 ? 0.0 : num / denom;
        }
        return sum;
    }

    public static  double evaluateHoners( double[] coefficients, double argument )
    {
        int n = coefficients.length;
        double result = coefficients[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            result = argument * result + coefficients[j];
        }
        return result;
    }

    public static  double evaluateInternal( double[] x, double[] y, double z )
    {
        int nearest = 0;
        final int n = x.length;
        final double[] c = new double[n];
        final double[] d = new double[n];
        double min_dist = Double.POSITIVE_INFINITY;
        for (int i = 0; i < n; i++) {
            c[i] = y[i];
            d[i] = y[i];
            final double dist = Math.abs( z - x[i] );
            if (dist < min_dist) {
                nearest = i;
                min_dist = dist;
            }
        }
        double value = y[nearest];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                final double tc = x[j] - z;
                final double td = x[i + j] - z;
                final double divider = x[j] - x[i + j];
                final double w = (c[j + 1] - d[j]) / divider;
                c[j] = tc * w;
                d[j] = td * w;
            }
            if (nearest < 0.5 * (n - i + 1)) {
                value += c[nearest];
            } else {
                nearest--;
                value += d[nearest];
            }
        }
        return value;
    }

    public static  double evaluateNewton( double[] a, double[] c, double z )
    {
        final int n = c.length - 1;
        double value = a[n];
        for (int i = n - 1; i >= 0; i--) {
            value = a[i] + (z - c[i]) * value;
        }
        return value;
    }

    public static  double meanDifference( final double[] sample1, final double[] sample2 )
    {
        double sumDifference = 0;
        for (int i = 0; i < sample1.length; i++) {
            sumDifference += sample1[i] - sample2[i];
        }
        return sumDifference / sample1.length;
    }

    public static  double varianceDifference( final double[] sample1, final double[] sample2 )
    {
        double sum1 = 0d;
        double sum2 = 0d;
        double diff = 0d;
        int n = sample1.length;
        double sumDifference = 0;
        for (int i = 0; i < n; i++) {
            sumDifference += sample1[i] - sample2[i];
        }
        double meanDifference = sumDifference / n;
        for (int i = 0; i < n; i++) {
            diff = sample1[i] - sample2[i];
            sum1 += (diff - meanDifference) * (diff - meanDifference);
            sum2 += diff - meanDifference;
        }
        return (sum1 - sum2 * sum2 / n) / (n - 1);
    }

    public static  boolean equals( double[] x, double[] y )
    {
        if (x == null || y == null) {
            return !(x == null ^ y == null);
        }
        if (x.length != y.length) {
            return false;
        }
        for (int i = 0; i < x.length; ++i) {
            if (Math.abs( y[i] - x[i] ) > 0.0001) {
                return false;
            }
        }
        return true;
    }

    public static  boolean checkNonNegative( final double[] in )
    {
        for (int i = 0; i < in.length; i++) {
            if (in[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static  boolean checkPositive( final double[] in )
    {
        for (int i = 0; i < in.length; i++) {
            if (in[i] <= 0) {
                return false;
            }
        }
        return true;
    }

    public static  double chiSquare( double[] expected, double[] observed )
    {
        double sumExpected = 0d;
        double sumObserved = 0d;
        for (int i = 0; i < observed.length; i++) {
            sumExpected += expected[i];
            sumObserved += observed[i];
        }
        double ratio = 1.0d;
        boolean rescale = false;
        if (Math.abs( sumExpected - sumObserved ) > 10E-6) {
            ratio = sumObserved / sumExpected;
            rescale = true;
        }
        double sumSq = 0.0d;
        for (int i = 0; i < observed.length; i++) {
            if (rescale) {
                final double dev = observed[i] - ratio * expected[i];
                sumSq += dev * dev / (ratio * expected[i]);
            } else {
                final double dev = observed[i] - expected[i];
                sumSq += dev * dev / expected[i];
            }
        }
        return sumSq;
    }

    public static  double evaluateSemiVariance( final double[] values, final double cutoff, final boolean direction, final boolean corrected, final int start, final int length )
    {
        if (values.length == 0) {
            return Double.NaN;
        } else {
            if (values.length == 1) {
                return 0.0;
            } else {
                final boolean booleanDirection = direction;
                double dev = 0.0;
                double sumsq = 0.0;
                for (int i = start; i < length; i++) {
                    if (values[i] > cutoff == booleanDirection) {
                        dev = values[i] - cutoff;
                        sumsq += dev * dev;
                    }
                }
                if (corrected) {
                    return sumsq / (length - 1.0);
                } else {
                    return sumsq / length;
                }
            }
        }
    }

    public static  int partition( final double[] work, final int begin, final int end, final int pivot )
    {
        final double value = work[pivot];
        work[pivot] = work[begin];
        int i = begin + 1;
        int j = end - 1;
        while (i < j) {
            while (i < j && work[j] > value) {
                --j;
            }
            while (i < j && work[i] < value) {
                ++i;
            }
            if (i < j) {
                final double tmp = work[i];
                work[i++] = work[j];
                work[j--] = tmp;
            }
        }
        if (i >= end || work[i] > value) {
            --i;
        }
        work[begin] = work[i];
        work[i] = value;
        return i;
    }

    public static  double evaluateWeightedProduct( final double[] values, final double[] weights, final int begin, final int length )
    {
        double product = Double.NaN;
        product = 1.0;
        for (int i = begin; i < begin + length; i++) {
            product *= Math.pow( values[i], weights[i] );
        }
        return product;
    }

}
