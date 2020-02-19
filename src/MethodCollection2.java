// This is a mutant program.
// Author : ysma

public class MethodCollection2
{

    public static  int add_values( int[] a )
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static  double add_two_array_values( int[] a, int i, int j )
    {
        if (i < 0 || i >= a.length || j < 0 || j >= a.length) {
            return -100000;
        } else {
            return a[i] + a[j] / 2.0;
        }
    }

    public static  int[] bubble( int[] a )
    {
        int i;
        int j;
        int t;
        for (i = a.length - 2; i >= 0; i--) {
            for (j = 0; j <= i; j++) {
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return a;
    }

    public static  int[] shell_sort( int[] a )
    {
        int j;
        int i;
        int k;
        int m;
        int mid;
        for (m = a.length / 2; m > 0; m /= 2) {
            for (j = m; j < a.length; j++) {
                for (i = j - m; i >= 0; i -= m) {
                    if (a[i + m] >= a[i]) {
                        break;
                    } else {
                        mid = a[i];
                        a[i] = a[i + m];
                        a[i + m] = mid;
                    }
                }
            }
        }
        return a;
    }

    public static  int sequential_search( int[] a, int key )
    {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static  int[] selection_sort( int[] list )
    {
        int i;
        int j;
        int min;
        for (i = 0; i < list.length - 1; i++) {
            min = i;
            for (j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            int tmp = list[i];
            list[i] = list[min];
            list[min] = tmp;
        }
        return list;
    }

    public static  int add_values_in_two_arrays( int[] a, int[] b, int i )
    {
        if (i < 0 || i >= a.length || i >= b.length) {
            return -100000;
        } else {
            return a[i] + b[i];
        }
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

    public static  int[] array_calc1( int[] a, int k )
    {
        int i;
        int[] b = new int[a.length];
        for (i = 0; i < a.length; i++) {
            b[i] = a[i] / k;
        }
        return b;
    }

    public static  int[] set_min_val( int[] a, int k )
    {
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] < k) {
                a[i] = k;
            }
        }
        return a;
    }

    public static  int get_array_value( int[] a, int k )
    {
        if (k - 1 >= a.length || k - 1 < 0) {
            return -100000;
        } else {
            return a[k - 1];
        }
    }

    public static  int find_min( int[] a )
    {
        int min = a[0];
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static  int[] find_diff( int[] a, int[] b )
    {
        int i;
        int[] c = new int[a.length];
        for (i = 0; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }
        return c;
    }

    public static  int[] array_copy( int[] a )
    {
        int i;
        int[] b = new int[a.length];
        for (i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    public static  double find_euc_dist( int[] a, int[] b )
    {
        int i;
        double sum = 0;
        for (i = 0; i < a.length; i++) {
            sum += (a[i] - b[i]) * (a[i] - b[i]);
        }
        double result = Math.sqrt( sum );
        return result;
    }

    public static  double find_magnitude( int[] a )
    {
        int i;
        double sum = 0;
        for (i = 0; i < a.length; i++) {
            sum += a[i] * a[i];
        }
        double result = Math.sqrt( sum );
        return result;
    }

    public static  double manhattan_dist( int[] a, int[] b )
    {
        int i;
        double sum = 0;
        for (i = 0; i < a.length; i++) {
            sum += Math.abs( a[i] - b[i] );
        }
        return sum;
    }

    public static  double average( int[] a )
    {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    public static  int[] dec_array( int[] a, int k )
    {
        int i;
        for (i = 0; i < a.length; i++) {
            a[i] -= k;
        }
        return a;
    }

    public static  double expr1( double a, double b )
    {
        double result = (b - a) / a;
        return result;
    }

    public static  int find_max( int[] a )
    {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static  int find_max2( int[] a )
    {
        int max = a[0] + a[1];
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] + a[i + 1] > max) {
                max = a[i] + a[i + 1];
            }
        }
        return max;
    }

    public static  double variance( double[] x )
    {
        double sum = 0;
        double sum1 = 0;
        double var = 0;
        double avrg = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum + x[i];
        }
        avrg = sum / (double) x.length;
        for (int i = 0; i < x.length; i++) {
            sum1 = sum1 + (x[i] - avrg) * (x[i] - avrg);
        }
        var = sum1 / (double) x.length;
        return var;
    }

    public static  int[] insertion_sort( int[] array )
    {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int B = array[i];
            while (j > 0 && array[j - 1] > B) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = B;
        }
        return array;
    }

    public static  double geometric_mean( int[] a )
    {
        long product = 1;
        for (int i = 0; i < a.length; i++) {
            product *= a[i];
        }
        return Math.pow( product, (double) 1 / a.length );
    }

    public static  double mean_absolute_error( int[] a, int[] b )
    {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs( a[i] - b[i] );
        }
        return (double) sum / a.length;
    }

    public static  double find_median( int[] a )
    {
        int k = a.length / 2 + 1;
        int minIndex = 0;
        int minValue = a[0];
        for (int i = 0; i < k; i++) {
            minIndex = i;
            minValue = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minValue) {
                    minIndex = j;
                    minValue = a[j];
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
        if (a.length % 2 == 0) {
            return (double) (a[a.length / 2 - 1] + a[a.length / 2]) / 2;
        } else {
            return a[a.length / 2];
        }
    }

    public static  int[][] cartesian_product( int[] a, int[] b )
    {
        int[][] result = new int[a.length * b.length][2];
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                result[cnt][0] = a[i];
                result[cnt][1] = b[j];
                cnt++;
            }
        }
        return result;
    }

    public static  int[] reverse( int[] a )
    {
        int[] r = new int[a.length];
        int cnt = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            r[cnt] = a[i];
            cnt++;
        }
        return r;
    }

    public static  boolean check_equal_tolerance( double[] a, double[] b, double tol )
    {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (Math.abs( a[i] - b[i] ) >= tol) {
                return false;
            }
        }
        return true;
    }

    public static  boolean check_equal( int[] a, int[] b )
    {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static  double weighted_average( double[] a, double[] b )
    {
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < a.length; i++) {
            sum1 += a[i] * b[i];
            sum2 += b[i];
        }
        return sum1 / sum2;
    }

    public static  int count_k( int[] a, int k )
    {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                cnt++;
            }
        }
        return cnt;
    }

    public static  int[] clip( int[] a, int lowerLim, int upperLim )
    {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < lowerLim) {
                r[i] = lowerLim;
            } else {
                if (a[i] > upperLim) {
                    r[i] = upperLim;
                } else {
                    r[i] = a[i];
                }
            }
        }
        return r;
    }

    public static  int[] elementwise_max( int[] a, int[] b )
    {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) {
                r[i] = a[i];
            } else {
                r[i] = b[i];
            }
        }
        return r;
    }

    public static  int[] elementwise_min( int[] a, int[] b )
    {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                r[i] = a[i];
            } else {
                r[i] = b[i];
            }
        }
        return r;
    }

    public static  int count_non_zeroes( int[] a )
    {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static  int cnt_zeroes( int[] a )
    {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static  boolean[] elementwise_equal( int[] a, int[] b )
    {
        boolean[] r = new boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                r[i] = true;
            } else {
                r[i] = false;
            }
        }
        return r;
    }

}
