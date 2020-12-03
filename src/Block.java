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

    public Block(Transaction data,String previousHash,long timeStamp){
        this.data=data;
        this.previousHash=previousHash;
        this.timeStamp=timeStamp;
    }

    public void setPreviousHash(String p) {
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

    public void setHash(String h) {
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

    public String getHash() {
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

    public void mineBlock(int prefix) {
        String prefixString = new String(new char[prefix]).replace('\0', '0');
        if (TreatySC(data)==true){
            boolean found=false;
            while(!found){
                this.hash=calculateBlockHash();
                if(getHash().substring(0,prefix).equals(prefixString)){
                    found=true;
                }
                nonce++;
            }
        }
        else{
            System.out.println("Error: transaction not valid.");
        }
    }

    public void mineBlock1(int prefix){
        boolean found=false;
        String prefixString = new String(new char[prefix]).replace('\0', '0');

        if (TreatySC1(data)==true){
        while(!found){
            this.hash=calculateBlockHash();
           if(getHash().substring(0,prefix).equals(prefixString)){
                found=true;
            }
                nonce++;
        }}
        else{
            System.out.println("Error: transaction not valid.");
        }
    }

    public boolean TreatySC(Transaction t){
       boolean valid= false;

       ArrayList<Transaction> tmp = new ArrayList<>();
       String ID=null;
       tmp= retrieveProvenance(ID);

       if(tmp.size()>=2) {
           if (data.getBuyer().getBal() >= data.getPrice()) {
               double p = data.getPrice();

               data.getAucHouse().setBal(p * .1);
               data.getSeller().setBal(p * .7);
               data.getArt().country.setBal(p * .2);

               valid = true;
           }
       }
        return valid;
    }

    public boolean TreatySC1(Transaction t){
        boolean valid= false;

            if (data.getBuyer().getBal() >= data.getPrice()) {
                double p = data.getPrice();

                data.getAucHouse().setBal(p * .1);
                data.getSeller().setBal(p * .7);
                data.getArt().country.setBal(p * .2);

                valid = true;
            }

        return valid;
    }

    public ArrayList<Transaction> retrieveProvenance(String ID) {
        ArrayList<Transaction> arr = new ArrayList<>();
        for (int i=0;i<Main.blockchain.size();i++){
            if(Main.blockchain.get(i).data.getArt().getID().equals(ID)){
            arr.add(Main.blockchain.get(i).data);
        }
        }
        return arr;//return array of type transaction
    }

    public ArrayList<Transaction> retrieveProvenance(String ID, long timeStamp) {
        ArrayList<Transaction> arr = new ArrayList<>();
        for(int i=0;i<Main.blockchain.size();i++) {
            if(Main.blockchain.get(i).data.getArt().getID().equals(ID)){
                if(Main.blockchain.get(i).data.getTimeStamp()==(timeStamp)){
                    arr.add(Main.blockchain.get(i).data);
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

        if(Main.blockchain.size()==1){

            return true;        }
        for(int i=1;i<Main.blockchain.size();i++){
            if(Main.blockchain.get(i).getHash().equals(calculateBlockHash())){
                if(Main.blockchain.get(i-1).getHash().equals(getPreviousHash())){
                   if(Main.blockchain.get(i).getHash().substring(0,3).equals("0000")){
                        valid=true;
                    }
                }
            }
        }
        return valid;
    }

    public boolean verify_Blockchain1(ArrayList<Block>BC){
        boolean valid=true;
        // Verify that the stored hash of the current block is actually what it calculates
        // Verify that the hash of the previous block stored in the current block is the hash
        // of the previous block
        // Verify that the current block has been mined

        for(int i=1;i<Main.blockchain.size();i++){
            if(Main.blockchain.get(i).getHash().equals(calculateBlockHash())){
                    if(Main.blockchain.get(i).getHash().substring(0,3).equals("0000")){
                        valid=true;
                    }
                }
            }
        return valid;
    }
}