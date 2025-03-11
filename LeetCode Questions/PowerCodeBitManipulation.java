public class PowerCodeBitManipulation{
    public double myPow(double x, int n) {
        /*
            if(n == 0){
                // Any number raised to the power 0 is 1
                return 1;
            }
            // If x is negative, compute for positive exponent and take reciprocal
            if(n < 0){
                return (1/myPow(x, -n));
            }
            double halfPowerSquare = myPow(x, n/2) * myPow(x, n/2);
            // If x is odd, multiply halfPowerSq by n to get the final result
            if(n%2 != 0){
                halfPowerSquare *= x;
            }
            return halfPowerSquare;
        */
        // Bakuas hai bhai let's solve this using bit manipulation...
        if(n == 0) return 1;
        long exponent = n; // To handle cases like case-294 
        if(exponent < 0){
            x = 1/x; // Reciprocate the number
            exponent = -exponent; // Remove the negative sign from power
        }
        double result = 1.0;
        while(exponent > 0){
            if((exponent & 1) == 1){
                // If exponent is odd number -
                result *= x;
            }
            x *= x; 
            exponent >>= 1; // Right shifts the exponent by 1 bit or in simple terms divides the exponent by 2
        }
        return result;
    }
}