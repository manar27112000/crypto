

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class des
{
    public static void main(String[] args) {
        KeyGenerator keygenerator= null;
        try {
            keygenerator = KeyGenerator.getInstance("Des");
            SecretKey mykey= keygenerator.generateKey();
          byte[]  plain_text="02468aceeca86420".getBytes();
            System.out.println("plain_text "+new String(plain_text));

            Cipher en=Cipher.getInstance("DES");
            en.init(Cipher.ENCRYPT_MODE,mykey);
           byte[]cipher_text= en.doFinal(plain_text);
            System.out.println("cipher_text "+new String(cipher_text));

            Cipher de=Cipher.getInstance("DES");
            de.init(Cipher.DECRYPT_MODE,mykey);
            byte[]p= de.doFinal(cipher_text);
            System.out.println("p "+new String(p));

        } catch (Exception e) {
        }
    }
    }
