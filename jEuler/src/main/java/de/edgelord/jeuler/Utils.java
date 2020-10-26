package de.edgelord.jeuler;

public class Utils {

    public static boolean isPrime(final long num) {
        if(num < 2) return false;
        else if(num == 2 || num == 3) return true;
        else if(num % 2 == 0 || num % 3 == 0) return false;

        long sqrt = (long) Math.sqrt(num) + 1;
        for(long i = 6; i <= sqrt; i += 6) {
            if(num % (i - 1) == 0 || num % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
