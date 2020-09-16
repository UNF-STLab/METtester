import java.util.List;
import java.util.Random;


public class MethodsFromMahout
{

    public static  double cosineDistance( double[] p1, double[] p2 )
    {
        double dotProduct = 0.0;
        double lengthSquaredp1 = 0.0;
        double lengthSquaredp2 = 0.0;
        for (int i = 0; i < p1.length; i++) {
            lengthSquaredp1 += p1[i] * p1[i];
            lengthSquaredp2 += p2[i] * p2[i];
            dotProduct += p1[i] * p2[i];
        }
        double denominator = Math.sqrt( lengthSquaredp1 ) * Math.sqrt( lengthSquaredp2 );
        if (denominator < dotProduct) {
            denominator = dotProduct;
        }
        if (denominator == 0 && dotProduct == 0) {
            return 0;
        }
        return 1.0 - dotProduct / denominator;
    }

    public static  double manhattanDistance( double[] p1, double[] p2 )
    {
        double result = 0.0;
        for (int i = 0; i < p1.length; i++) {
            result += Math.abs( p2[i] - p1[i] );
        }
        return result;
    }

    public static  double chebyshevDistance( double[] p1, double[] p2 )
    {
        if (p1.length != p2.length) {
            System.out.println( "Error!" );
            return -1;
        }
        double maxDiff = Math.abs( p1[0] - p2[0] );
        for (int i = 1; i < p1.length; i++) {
            double diff = Math.abs( p1[i] - p2[i] );
            if (maxDiff < diff) {
                maxDiff = diff;
            }
        }
        return maxDiff;
    }

    public static  double tanimotoDistance( double[] p1, double[] p2 )
    {
        double ab = 0;
        double aSq = 0;
        double bSq = 0;
        for (int i = 0; i < p1.length; i++) {
            ab += p1[i] * p2[i];
            aSq += p1[i] * p1[i];
            bSq += p2[i] * p2[i];
        }
        double denominator = aSq + bSq - ab;
        if (denominator < ab) {
            denominator = ab;
        }
        if (denominator > 0) {
            return 1.0 - ab / denominator;
        } else {
            return 0.0;
        }
    }

    public static  int sum( int[] values )
    {
        int sum = 0;
        for (int value: values) {
            sum += value;
        }
        return sum;
    }

   

    public static  double[] givens( double a, double b, double[] csOut )
    {
        if (b == 0) {
            csOut[0] = 1;
            csOut[1] = 0;
            return csOut;
        }
        if (Math.abs( b ) > Math.abs( a )) {
            double tau = -a / b;
            csOut[1] = 1 / Math.sqrt( 1 + tau * tau );
            csOut[0] = csOut[1] * tau;
        } else {
            double tau = -b / a;
            csOut[0] = 1 / Math.sqrt( 1 + tau * tau );
            csOut[1] = csOut[0] * tau;
        }
        return csOut;
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

    public static  int nbTrees( int numMaps, int numTrees, int partition )
    {
        int nbTrees = numTrees / numMaps;
        if (partition == 0) {
            nbTrees += numTrees - nbTrees * numMaps;
        }
        return nbTrees;
    }

    public static  int stepSize( int recordNumber, double multiplier )
    {
        int[] bumps = { 1, 2, 5 };
        double log = Math.floor( multiplier * Math.log10( recordNumber ) );
        int bump = bumps[(int) log % bumps.length];
        int scale = (int) Math.pow( 10, Math.floor( log / bumps.length ) );
        return bump * scale;
    }

    public static  double choose2( double n )
    {
        return n * (n - 1) / 2;
    }

    public static  double computeWeight( double featureLabelWeight, double labelWeight, double alphaI, double numFeatures )
    {
        double numerator = featureLabelWeight + alphaI;
        double denominator = labelWeight + alphaI * numFeatures;
        return Math.log( numerator / denominator );
    }

    public static  double computeWeight( double featureWeight, double featureLabelWeight, double totalWeight, double labelWeight, double alphaI, double numFeatures )
    {
        double numerator = featureWeight - featureLabelWeight + alphaI;
        double denominator = totalWeight - labelWeight + alphaI * numFeatures;
        return -Math.log( numerator / denominator );
    }

    public static  double errorRate( double[] labels, double[] predictions )
    {
        double nberrors = 0;
        double datasize = 0;
        for (int index = 0; index < labels.length; index++) {
            if (predictions[index] == -1) {
                continue;
            }
            if (predictions[index] != labels[index]) {
                nberrors++;
            }
            datasize++;
        }
        return nberrors / datasize;
    }

    public static  double[] fromRho( double rho, double[] csOut )
    {
        if (rho == 1) {
            csOut[0] = 0;
            csOut[1] = 1;
            return csOut;
        }
        if (Math.abs( rho ) < 1) {
            csOut[1] = 2 * rho;
            csOut[0] = Math.sqrt( 1 - csOut[1] * csOut[1] );
            return csOut;
        }
        csOut[0] = 2 / rho;
        csOut[1] = Math.sqrt( 1 - csOut[0] * csOut[0] );
        return csOut;
    }

}
