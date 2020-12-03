import java.util.ArrayList;
import java.util.Date;


public class Main {
     ///static Main blockchain= new Main();

    static ArrayList<Block> blockchain=new ArrayList<>();

    public static void main(String[] args) {
        Stakeholder o = new Stakeholder("O333", "Mary", "25 Spring St", 5000);
        Stakeholder s = new Stakeholder("S123", "Amy", "12 Oak Circle", 1000);
        Stakeholder b = new Stakeholder("B456", "Tom", "3 Penny Ln", 20000);
        Stakeholder auc = new Stakeholder("AUC356", "Olive", "5 Court St", 7000);
        Stakeholder c =new Stakeholder("C777","USA","5 US Drive",10000);
        Artefact a = new Artefact("D55", "Painting", c, o);
        Transaction data1 = new Transaction(a, 2000, s, b, auc, 500);

       /* System.out.println(s.toString());
        System.out.println(a.toString());
        System.out.println(t.toString());
        */


        //ArrayList<Block> blockchain = new ArrayList<>();
        int prefix = 4;   //we want our hash to start with four zeroes
         String prefixString = new String(new char[prefix]).replace('\0', '0');
        // data1-data3 should be filled by the user
        Block genesisBlock = new Block(data1,blockchain.get(blockchain.size() - 1).getHash(), new Date().getTime());
        genesisBlock.mineBlock(prefix);
        if (genesisBlock.getHash().substring(0, prefix).equals(prefixString) && genesisBlock.verify_Blockchain(blockchain))
            blockchain.add(genesisBlock);
        else
            System.out.println("Malicious block, not added to the chain");
/*
       Block secondBlock = new Block(data2, blockchain.get(blockchain.size() - 1).getHash(),new Date().getTime());
        secondBlock.mineBlock(prefix);
        if (secondBlock.getHash().substring(0, prefix).equals(prefixString) && secondBlock.verify_Blockchain(ArrayList<Block> BC))
            blockchain.add(secondBlock);
        else
        System.out.println("Malicious block, not added to the chain");

        Block newBlock = new Block(data3,blockchain.get(blockchain.size() - 1).getHash(),new Date().getTime());
        newBlock.mineBlock(prefix);
        if (newBlock.getHash().substring(0, prefix).equals(prefixString) && newBlock.verify_Blockchain(ArrayList<Block> BC))
            blockchain.add(newBlock);
        else
            System.out.println("Malicious block, not added to the chain");

 */

    }
}