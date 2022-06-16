public class Problem4_LargestPalindromeProduct {

    private static boolean isPalindrome(int n) {
        String number = String.valueOf(n);
        int front = 0;
        int rear = number.length() - 1;
        while (front < rear) {
            if (number.charAt(front) != number.charAt(rear)) return false;
            front++;
            rear--;
        }
        return true;
    }

    public static void main(String[] args) {
        int largestPalindromeProduct = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                int product = i * j;
                if ((isPalindrome(product) && (product > largestPalindromeProduct)))
                    largestPalindromeProduct = product;
            }
        }
        System.out.println(largestPalindromeProduct);
    }
}
