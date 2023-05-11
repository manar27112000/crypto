import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Aes {
       static void Aes() {
           try {
               byte[] plain_text = "0123456789abcdeffedcba9876543210".getBytes();
               System.out.println("plain text  " + new String(plain_text));
               KeyGenerator key = KeyGenerator.getInstance("AES");
               key.init(128);
               SecretKey secretKey = key.generateKey();
               Cipher en = Cipher.getInstance("AES");
               //Cipher en=Cipher.getInstance("AES/ECB/PKCS5Padding");
               en.init(Cipher.ENCRYPT_MODE, secretKey);
               byte[] Cipher_text = en.doFinal(plain_text);

               System.out.println("encrypt_text  " + new String(Cipher_text));

               Cipher de = Cipher.getInstance("AES");
               // Cipher de=Cipher.getInstance("AES/ECB/PKCS5Padding");
               de.init(Cipher.DECRYPT_MODE, secretKey);
               byte[] newplain_text = en.doFinal(Cipher_text);
               System.out.println(" decrypt_text  " + new String(plain_text));

           } catch (NoSuchAlgorithmException e) {

           } catch (NoSuchPaddingException e) {
               throw new RuntimeException(e);
           } catch (IllegalBlockSizeException e) {
               throw new RuntimeException(e);
           } catch (BadPaddingException e) {
               throw new RuntimeException(e);
           } catch (InvalidKeyException e) {
               throw new RuntimeException(e);
           }
       }

}
