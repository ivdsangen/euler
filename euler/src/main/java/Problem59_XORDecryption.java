import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Problem59_XORDecryption {

    public static void main(String[] args) {

        File cipherFile = new File(Objects.requireNonNull(
                Problem59_XORDecryption.class.getClassLoader().getResource("p059_cipher.txt")).getFile());
        Scanner scanner = null;
        try {
            scanner = new Scanner(cipherFile);
        } catch (FileNotFoundException e) {
            System.err.println("File p059_cipher.txt not found");
            System.exit(1);
        }

        StringBuilder cipherBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            cipherBuilder.append(scanner.nextLine());
        }
        String cipherString = cipherBuilder.toString();
        String[] cipherList = cipherString.split(",");
        byte[] cipher = new byte[cipherList.length];
        for (int i = 0; i < cipher.length; i++) {
            cipher[i] = (byte) Integer.parseInt(cipherList[i]);
        }

        int maximum = 0;
        byte[] plaintext = new byte[cipher.length];
        for (byte k1 = 97; k1 <= 122; k1++) {
            for (byte k2 = 97; k2 <= 122; k2++) {
                for (byte k3 = 97; k3 <= 122; k3++) {
                    int[] key = new int[] {k1, k2, k3};
                    byte[] runningCipher = cipher.clone();
                    for (int i = 0; i < runningCipher.length; i++) {
                        runningCipher[i] = (byte) (runningCipher[i] ^ key[i % 3]);
                    }
                    int count = 0;
                    for (byte b : runningCipher) {
                        if ((b >= 'A' && b <= 'Z') || ((b >= 'a' && b <= 'z'))) {
                            count++;
                        } else if (b >= '[' || b <= '`') {
                            count--;
                        }
                    }
                    if (count > maximum) {
                        maximum = count;
                        plaintext = runningCipher;
                    }
                }
            }
        }
        int sum = 0;
        for (byte b : plaintext) {
            sum += b;
        }
        System.out.println(sum);
    }
}
