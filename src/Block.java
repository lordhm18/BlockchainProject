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
      //  this.hash=calculateBlockHash();

        if (TreatySC(data)){
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
            this.hash="    ";
            System.out.println("Error: transaction not valid.");
        }
    }

    public void mineBlock1(int prefix){
        boolean found=false;
        String prefixString = new String(new char[prefix]).replace('\0', '0');

        if (TreatySC1(data)){
        while(!found){
            this.hash=calculateBlockHash();
           if(getHash().substring(0,prefix).equals(prefixString)){
                found=true;
            }
                nonce++;
        }}
        else{
            this.hash="    ";
            System.out.println("Error: transaction not valid.");
        }

    }

    public boolean TreatySC(Transaction t){
       boolean valid= false;
       ArrayList<Transaction> tmp = new ArrayList<>();
       tmp= retrieveProvenance(data.getArt().getID());

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
            if(Main.blockchain.get(i).data.getTimeStamp()==(timeStamp)){
                if(Main.blockchain.get(i).data.getArt().getID().equals(ID)){
                    arr.add(Main.blockchain.get(i).data);
                }
            }
        }
        return arr;
    }

    public boolean verify_Blockchain(ArrayList<Block>BC){
        String prefixString = new String(new char[4]).replace('\0', '0');
        boolean valid=false;

        if(BC.size()==0){
            return true; }

            for (int i = 1; i <= BC.size(); i++) {

               /* if (Main.blockchain.get(i).getHash().equals(Main.blockchain.get(i).calculateBlockHash())) {
                    System.out.println("1");
                    if (Main.blockchain.get(i).getHash().equals(getPreviousHash())) {
                        System.out.println("2");
                        if (Main.blockchain.get(i).getHash().substring(0, 4).equals(prefixString)) {
                            System.out.println("3");
                            valid = true;
                        }
                    }
                }
                */
                System.out.println("hash: "+getHash());


                System.out.println("calc:"+calculateBlockHash());

               // if(getHash().equals(calculateBlockHash())){//not equal (calculating wrong hash w/out "0000"
                 //   System.out.println("1");
                    if (BC.get(i-1).getHash().equals(getPreviousHash())){
                        if(getHash().substring(0,4).equals(prefixString)){
                            valid=true;
                        }
                    }
                }
            //}

        return valid;
    }

}