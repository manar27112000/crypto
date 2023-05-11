import java.util.Scanner;

public class Polyalphabetic {

    public static String encrypt(String text, String key) {
        StringBuilder cipherText = new StringBuilder();
        int k = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int shift = key.charAt(k) - 'A';
                char encrypt = (char) ((c - 'A' + shift) % 26 + 'A');
                cipherText.append(encrypt);
                
                k = (k + 1) % key.length();
            } else {
                cipherText.append(c);
            }}
        return cipherText.toString();
    }

    public static String decrypt(String cipherText, String key) {
        StringBuilder decryptedText = new StringBuilder();
        int keyIndex = 0;

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);
            if (Character.isLetter(c)) {
                int shift = key.charAt(keyIndex) - 'A';
                char decryptedChar = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                decryptedText.append(decryptedChar);

                keyIndex = (keyIndex + 1) % key.length();
            } else {
                decryptedText.append(c);
            }
        }

        return decryptedText.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plainText = scanner.nextLine().toUpperCase();

        System.out.print("Enter the key: ");
        String key = scanner.nextLine().toUpperCase();

        String cipherText = encrypt(plainText, key);
        System.out.println("Encrypted text: " + cipherText);

        String decryptedText = decrypt(cipherText, key);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }

}