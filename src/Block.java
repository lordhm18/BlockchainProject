import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Block {
    String previousHash;
    Transaction data;
    long timeStamp;
    int nonce;
    String hash;

    public Block() {
    }

    public Block(Transaction d) {
        this.data = d;
    }

    public void setPreviousHash(String p) {//how?
        this.previousHash = p;
    }

    public void setData(Transaction d) {
        this.data = d;
    }

    public void setTimeStamp(long t) {
        this.timeStamp = t;
    }

    public void setNonce() {
        Random num = new Random();
        int n = 100000 + num.nextInt(999999);
        this.nonce = n;
    }

    public void setHash(String h) {//how?
        this.hash = h;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public Transaction getData() {
        return this.data;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getNonce() {
        return this.nonce;
    }

    public String getHash() {//need?
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
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("The encoding is not supported");
        }
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }

    public void mineBlock(int prefix) {//review
        if (TreatySC(data)==true){
            boolean found=false;
            while (!found){
                if(nonce==prefix){
                    found=true;
                }
                nonce++;
                //calculateBlockHash();
                hash=calculateBlockHash();
            }
        }
        else{
            System.out.println("Error: transaction not valid.");
        }
    }

    public boolean TreatySC(Transaction t){
       boolean valid= false;
        //if(retrieveProvenance())
        if(data.getBuyer().getBal()>=data.getPrice()){
            double p= data.getPrice();

            data.getAucHouse().setBal(p*.1);
            data.getSeller().setBal(p*.7);
            data.getArt().country.setBal(p*.2);

            valid=true;
        }
        return valid;
    }


    public ArrayList<Transaction> retrieveProvenance(String ID) {
        ArrayList<Transaction> arr = new ArrayList<>();
        for (int i=0;i<Main.blockchain.size;i++){
        if (block.i) {
            //(ID == data.getArt().getID()) {//conditions for loop? need to find all IDs
            arr.add(data);
        }}
        return arr;//return array of type transaction
    }

    public ArrayList<Transaction> retrieveProvenance(String ID, long timeStamp) {
        ArrayList<Transaction> arr = new ArrayList<>();
        for(int i=0;i<block.size;i++) {

            if (ID == data.getArt().getID()) {
                if (data.getTimeStamp() <= timeStamp) {
                    arr.add(data);
                }
            }
        }
        return arr;
    }

    public boolean verify_Blockchain(ArrayList<Block>BC){
        boolean valid=false;
        // Verify that the stored hash of the current block is actually what it calculates
        // Verify that the hash of the previous block stored in the current block is the hash
        // of the previous block
        // Verify that the current block has been mined

        return valid;
    }
}