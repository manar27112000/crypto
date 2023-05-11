import java.util.Scanner;

public class mono {
    public static char[] p = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static char[] c = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
     public static String en(String text) {
        char cipher_text[]=new char[text.length()];
        for (int i = 0; i <text.length() ; i++) {
            for (int j = 0; j <26 ; j++) {
                if (text.charAt(i)==p[j]){
                    cipher_text[i]=  c[j];
                }
            }
        }
        return new String(cipher_text);
    }


    public static String de(String text) {
        char cipher_text[]=new char[text.length()];
        for (int i = 0; i <text.length() ; i++) {
            for (int j = 0; j <26 ; j++) {
                if (text.charAt(i)==c[j]){
                    cipher_text[i]=  p[j];
                }
            }
        }
        return new String(cipher_text);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        String plain_text = scanner.nextLine();

        String cipher_text=en(plain_text);
        System.out.println("Encrypted text: " + cipher_text);
        String decrypted_text = de(cipher_text);
        System.out.println("Decrypted text: " + decrypted_text);


    }



}
