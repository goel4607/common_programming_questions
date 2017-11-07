package goel4607;

/**
 * @author Rajesh Goel on 10/23/17.
 */
public class Fibonacci {
    /**
     * f(n) = f(n-1) + f(n-2)
     * @param n number whose fibonacci series needs to be found
     * @param dynProgMatrix matrix
     */
    private static int fibonacci(int n, final int[] dynProgMatrix) {
        if (dynProgMatrix[n] != -1) {
            return dynProgMatrix[n];
        }
        if (n<=1) {
            dynProgMatrix[n] = n;
            return n;
        }
        else {
            return dynProgMatrix[n] = fibonacci(n-1, dynProgMatrix) + fibonacci(n-2, dynProgMatrix);
        }
    }
}
