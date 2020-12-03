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

        Stakeholder o2 = new Stakeholder("O222", "Lisa", "50 Main St", 10000);
        Stakeholder s2 = new Stakeholder("S466", "Karen", "15 Maple Circle", 2000);
        Stakeholder b2 = new Stakeholder("B789", "Mike", "10 Pine Ln", 35000);
        Stakeholder auc2 = new Stakeholder("AUC444", "Carly", "9 South St", 9000);
        Stakeholder c2 =new Stakeholder("C989","France","25 FR Drive",15000);
        Artefact a2 = new Artefact("D678", "Drawing", c2, o2);
        Transaction data2= new Transaction(a2, 1990, s2, b2, auc2, 1500);

        Stakeholder o3 = new Stakeholder("O555", "Sam", "7 Lion St", 6500);
        Stakeholder s3 = new Stakeholder("S888", "Kevin", "16 Art Circle", 10000);
        Stakeholder b3 = new Stakeholder("B929", "Alan", "5 Diamond Ln", 25000);
        Stakeholder auc3 = new Stakeholder("AUC533", "Erin", "10 North St", 6000);
        Stakeholder c3 =new Stakeholder("C234","Italy","8 IT Drive",12000);
        Artefact a3 = new Artefact("D909", "Sketch", c3, o3);
        Transaction data3 = new Transaction(a3, 1999, s3, b3, auc3, 700);

       /* System.out.println(s.toString());
        System.out.println(a.toString());
        System.out.println(t.toString());
        */


        //ArrayList<Block> blockchain = new ArrayList<>();
        int prefix = 4;   //we want our hash to start with four zeroes
         String prefixString = new String(new char[prefix]).replace('\0', '0');
        // data1-data3 should be filled by the user
       /* Block genesisBlock = new Block(data1,blockchain.get(blockchain.size()-1).getHash(), new Date().getTime());
        genesisBlock.mineBlock(prefix);
        */
        Block genesisBlock = new Block(data1, null, new Date().getTime());
        genesisBlock.mineBlock(prefix);
        if (genesisBlock.getHash().substring(0, prefix).equals(prefixString) && genesisBlock.verify_Blockchain(blockchain))
            blockchain.add(genesisBlock);
        else
            System.out.println("Malicious block, not added to the chain");

       Block secondBlock = new Block(data2, blockchain.get(blockchain.size() - 1).getHash(),new Date().getTime());
        secondBlock.mineBlock(prefix);
        if (secondBlock.getHash().substring(0, prefix).equals(prefixString) && secondBlock.verify_Blockchain(blockchain))
            blockchain.add(secondBlock);
        else
        System.out.println("Malicious block, not added to the chain");

        Block newBlock = new Block(data3,blockchain.get(blockchain.size() - 1).getHash(),new Date().getTime());
        newBlock.mineBlock(prefix);
        if (newBlock.getHash().substring(0, prefix).equals(prefixString) && newBlock.verify_Blockchain(blockchain))
            blockchain.add(newBlock);
        else
            System.out.println("Malicious block, not added to the chain");

    }
}