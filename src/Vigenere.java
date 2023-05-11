import java.util.Scanner;

public class Vigenere {

    public static String generationKey(String plain_text, String key) {
        //String key_new="";
        int len=plain_text.length();
        for (int i = 0; i < len; i++) {
           if (i==len) i=0;
            if (key.length()==len) break;
                key+=key.charAt(i);

        }
        System.out.println("key_new "+key);
        return key;
    }

    public static String en(String p, String key) {
      int len=p.length();
        String cipher_text="";
        for (int i = 0; i <len ; i++) {


                char c = p.charAt(i);
                if (Character.isUpperCase(c)) {
                    c = (char) ((c + key.charAt(i) - 2 * 'A') % 26 + 'A');
                } else {
                    c = (char) ((c + key.charAt(i) - 2 * 'a') % 26 + 'a');
                }
                cipher_text += c;

//            if ( p.charAt(i)+(key.charAt(i)-65)>122){
//                int c=(int) p.charAt(i)+(key.charAt(i)-65)-26;
//                 char x= Character.toUpperCase((char) c);
//                   cipher_text=cipher_text+x;
//            }else{
//                int c=(int) p.charAt(i)+(key.charAt(i)-65);
//                char x= Character.toUpperCase((char) c);
//                cipher_text+=x;



        }
        return cipher_text;
    }

    public static String de(String cipher_text, String key) {
        String plain_text = "";
        int len = cipher_text.length();
        for (int i = 0; i < len; i++) {
            char c = cipher_text.charAt(i);
            if (Character.isUpperCase(c)) {
                c = (char) ((c - key.charAt(i) + 26) % 26 + 'A');
            } else {
                c = (char) ((c - key.charAt(i) + 26) % 26 + 'a');
            }
            plain_text += c;
        }
        return plain_text;
    }
//    public static String de(String cipher_text, String key) {
//        String plain_text="";
//        for (int i = 0; i < cipher_text.length() && i< key.length() ; i++) {
//            int p=(int)((cipher_text.charAt(i)-key.charAt(i))+26)%26+97;
//            plain_text+=(char) p;
//
//        }
//        return plain_text;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plaintext: ");
        String plain_text = scanner.nextLine();
        System.out.print("Enter the keyword: ");
        String key_word = scanner.nextLine();
        String key = generationKey(plain_text, key_word);
        String cipher_text = en(plain_text, key);
        System.out.println("Encrypted text: " + cipher_text);
        String plain_text1 = de(cipher_text, key);
        System.out.println("Decrypted text: " + plain_text1);
    }



}
