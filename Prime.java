// wrap your code in a class 
public class Prime {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            if (isPrimeOptimized(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
