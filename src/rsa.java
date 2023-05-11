
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class rsa {

    BigInteger p,q,e,phi,d,n;

    public rsa(int bitLength) {
        getkey(bitLength);
    }

    private void getkey(int bitLength) {
        SecureRandom random = new SecureRandom();
        p = BigInteger.probablePrime(bitLength, random);
        q = BigInteger.probablePrime(bitLength, random);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537"); // common value for public key
        d = e.modInverse(phi);
        while (!e.gcd(phi).equals(BigInteger.ONE)) {
            e = e.add(BigInteger.TWO);
        }
    }

    public BigInteger encrypt(BigInteger plain) {
        return plain.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(d, n);
    }

    public List<BigInteger> encrypt(String message) {
        List<BigInteger> encryptedBlocks = new ArrayList<>();
        byte[] bytes = message.getBytes();
        int blockSize = n.toByteArray().length - 1; // Subtract 1 to account for padding

        for (int i = 0; i < bytes.length; i += blockSize) {
            int end = Math.min(i + blockSize, bytes.length);
            byte[] block = new byte[end - i];
            System.arraycopy(bytes, i, block, 0, block.length);
            BigInteger value = new BigInteger(block);
            encryptedBlocks.add(encrypt(value));
        }

        return encryptedBlocks;
    }

    public String decrypt(List<BigInteger> encryptedBlocks) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (BigInteger encryptedBlock : encryptedBlocks) {
            BigInteger decryptedBlock = decrypt(encryptedBlock);
            byte[] blockBytes = decryptedBlock.toByteArray();
            decryptedMessage.append(new String(blockBytes));
        }
        return decryptedMessage.toString();
    }
    public static void main(String[] args) {
        rsa rsa = new rsa(1024);

        String plaintext = "noha";
        List<BigInteger> plain = rsa.encrypt(plaintext);
        String chiper = rsa.decrypt(plain);

        System.out.println("plaintext : " + plaintext);
        System.out.println("encrypted text: " + plain);
        System.out.println("decrypted text: " + chiper);

    }
}
