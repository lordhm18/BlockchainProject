import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Block {
    String previousHash;
    Transaction data;
    long timeStamp;
    int nonce;
    String hash;

    public Block(){}

    public Block(Transaction d){
        this.data=d;
    }

    public void setPreviousHash(String p){//how?
        this.previousHash=p;
    }

    public void setData(Transaction d){
        this.data=d;
    }
    public void setTimeStamp(long t){
        this.timeStamp=t;
    }

    public void setNonce(){
        Random num=new Random();
        int n= 10000000 +num.nextInt(99999999);
        this.nonce=n;
    }

    public void setHash(String h){//how?
        this.hash=h;
    }

    public String getPreviousHash(){
        return previousHash;
    }

    public Transaction getData(){
        return this.data;
    }

    public long getTimeStamp(){
        return this.timeStamp;
    }

    public int getNonce(){
        return this.nonce;
    }

    public String getHash(){//need?
        return hash;
    }

    public String calculateBlockHash() {
        String dataToHash = previousHash
                + Long.toString(timeStamp)
                + Integer.toString(nonce)
                + data.toString();
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));//how to fix?
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("The encoding is not supported");
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public void mineBlock(int prefix){//public void?

    }

    //SC treaty

 /*   public Transaction retrieveProvenance(String ID){//identify for artefact? how?
        Transaction t=new Transaction();
       Artefact a= new Artefact();
        Stakeholder s= new Stakeholder();
        if(ID==t.getArt().getID()){
            return t;
        }

        return t;
    }

  */

}
