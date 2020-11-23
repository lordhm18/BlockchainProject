import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//import static java.nio.charset.StandardCharsets.UTF_8;

public class Block {
    String previousHash;
    Transaction data;
    long timeStamp;
    Integer nonce;



    public String calculateBlockHash() {
        String dataToHash = previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + data.toString();
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));//how to fix?
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("The encoding is not supported");
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();

    }

}
