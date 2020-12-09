import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    static ArrayList<Block> blockchain = new ArrayList<>();

    //public static void main(String[] args) {

        static Stakeholder o = new Stakeholder("O333", "Mary", "25 Spring St", 5000);
        static Stakeholder s = new Stakeholder("S123", "Amy", "12 Oak Circle", 1000);
        static Stakeholder b = new Stakeholder("B456", "Tom", "3 Penny Ln", 20000);
        static Stakeholder auc = new Stakeholder("AUC356", "Olive", "5 Court St", 7000);
        static Stakeholder c = new Stakeholder("C777", "USA", "5 US Drive", 10000);
        static Artefact a = new Artefact("D55", "Painting", c, o);
        static Transaction data1 = new Transaction(a, 2000, s, b, auc, 500);

    static Stakeholder o2 = new Stakeholder("O222", "Lisa", "50 Main St", 10000);
    static Stakeholder s2 = new Stakeholder("S466", "Karen", "15 Maple Circle", 2000);
    static Stakeholder b2 = new Stakeholder("B789", "Mike", "10 Pine Ln", 35000);
    static Stakeholder auc2 = new Stakeholder("AUC444", "Carly", "9 South St", 9000);
    static Stakeholder c2 = new Stakeholder("C989", "France", "25 FR Drive", 15000);
    static Artefact a2 = new Artefact("D678", "Drawing", c2, o2);
    static Transaction data2 = new Transaction(a2, 1990, s2, b2, auc2, 1500);

    static Stakeholder o3 = new Stakeholder("O555", "Sam", "7 Lion St", 6500);
    static Stakeholder s3 = new Stakeholder("S888", "Kevin", "16 Art Circle", 10000);
    static Stakeholder b3 = new Stakeholder("B929", "Alan", "5 Diamond Ln", 25000);
    static Stakeholder auc3 = new Stakeholder("AUC533", "Erin", "10 North St", 6000);
    static Stakeholder c3 = new Stakeholder("C234", "Italy", "8 IT Drive", 12000);
    static Artefact a3 = new Artefact("D909", "Sketch", c3, o3);
    static Transaction data3 = new Transaction(a3, 1999, s3, b3, auc3, 700);

    static Choice t = new Choice();
    static  Choice ch = new Choice();
    static  Choice ch2 = new Choice();
    static   Choice ch3 = new Choice();
    static   Choice ch4 = new Choice();
    static   Choice ch5 = new Choice();
    static   Choice ch6 = new Choice();

    static    Frame f = new Frame("choice");
    static    Frame f2 = new Frame("choice 2");
    static   Panel p = new Panel();
    static   Panel p2 = new Panel();

    static    Label l0 = new Label();
    static    Label l = new Label();
    static     Label l2 = new Label();
    static    Label l3 = new Label();
    static    Label l4 = new Label();
    static     Label l5 = new Label();
    static     Label l6 = new Label();
    static     Label l7 = new Label();
    static    Label l8 = new Label();
    static Button ent = new Button("enter");
    static   Button inp1 = new Button("First transaction");
    static    Button inp2 = new Button("Second transaction");
    static    Button inp3 = new Button("Third transaction");
    static    Button done = new Button("Done");

    public static void makeFrame(){
        l0.setText("Please select the transaction number");
        t.add("1");
        t.add("2");
        t.add("3");

        l.setText("Please select an artefact: ");
        ch.add("Painting");
        ch.add("Drawing");
        ch.add("Sketch");

        l2.setText("Please select a country: ");
        ch2.add("USA");
        ch2.add("France");
        ch2.add("Italy");

        l3.setText("Please select an owner: ");
        ch3.add("Mary");
        ch3.add("Lisa");
        ch3.add("Sam");

        l4.setText("Please select a seller: ");
        ch4.add("Amy");
        ch4.add("Karen");
        ch4.add("Kevin");

        l5.setText("Please select a buyer: ");
        ch5.add("Tom");
        ch5.add("Mike");
        ch5.add("Alan");

        l6.setText("Please select an auction house: ");
        ch6.add("Olive");
        ch6.add("Carly");
        ch6.add("Erin");

        p.add(l0);
        p.add(t);
        p.add(l);
        p.add(ch);
        p.add(l2);
        p.add(ch2);
        p.add(l3);
        p.add(ch3);
        p.add(l4);
        p.add(ch4);
        p.add(l5);
        p.add(ch5);
        p.add(l6);
        p.add(ch6);
        p.add(ent);

        l7.setText("Please select transaction number:");
        l8.setText("Please press done after inputting data for all three transactions");
        p2.add(l7);
        p2.add(inp1);
        p2.add(inp2);
        p2.add(inp3);
        p2.add(l8);
        p2.add(done);

        f2.add(p2);
        f.add(p);
        f2.show();
        f2.setSize(400, 300);
        f.setSize(300, 400);}

        static ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ch.getSelectedItem().equals("Painting")) {
                    if (ch2.getSelectedItem().equals("USA")) {
                        a.setCountry(c);                    }
                    if (ch2.getSelectedItem().equals("France")) {
                        a.setCountry(c2);                    }
                    if (ch2.getSelectedItem().equals("Italy")) {
                        a.setCountry(c3);                    }
                   if(ch3.getSelectedItem().equals("Mary")){
                        a.setOwner(o); }
                    if(ch3.getSelectedItem().equals("Lisa")){
                        a.setOwner(o2); }
                    if(ch3.getSelectedItem().equals("Sam")){
                        a.setOwner(o3); }

                    if (t.getSelectedItem().equals("1")) {
                        data1.setArt(a);                    }
                    if (t.getSelectedItem().equals("2")) {
                        data2.setArt(a);                    }
                    if (t.getSelectedItem().equals("3")) {
                        data3.setArt(a);                    }
                }
                else if (ch.getSelectedItem().equals("Drawing")) {
                    if(ch2.getSelectedItem().equals("USA")){
                        a2.setCountry(c);}
                    if(ch2.getSelectedItem().equals("France")){
                        a2.setCountry(c2); }
                    if (ch2.getSelectedItem().equals("Italy")){
                        a2.setCountry(c3); }
                    if(ch3.getSelectedItem().equals("Mary")){
                        a2.setOwner(o); }
                    if(ch3.getSelectedItem().equals("Lisa")){
                        a2.setOwner(o2); }
                    if(ch3.getSelectedItem().equals("Sam")){
                        a2.setOwner(o3); }

                    if (t.getSelectedItem().equals("1")) {
                        data1.setArt(a2);                    }
                    if (t.getSelectedItem().equals("2")) {
                        data2.setArt(a2);                    }
                    if (t.getSelectedItem().equals("3")) {
                        data3.setArt(a2);                    }
                }
                else if (ch.getSelectedItem().equals("Sketch")) {
                    if(ch2.getSelectedItem().equals("USA")){
                        a3.setCountry(c);}
                    if(ch2.getSelectedItem().equals("France")){
                        a3.setCountry(c2); }
                    if (ch2.getSelectedItem().equals("Italy")){
                        a3.setCountry(c3); }
                    if(ch3.getSelectedItem().equals("Mary")){
                        a3.setOwner(o); }
                    if(ch3.getSelectedItem().equals("Lisa")){
                        a3.setOwner(o2); }
                    if(ch3.getSelectedItem().equals("Sam")){
                        a3.setOwner(o3); }

                    if (t.getSelectedItem().equals("1")) {
                        data1.setArt(a3);                }
                    if (t.getSelectedItem().equals("2")) {
                        data2.setArt(a3);                    }
                    if (t.getSelectedItem().equals("3")) {
                        data3.setArt(a3);                    }
                }

                if (t.getSelectedItem().equals("1")) {
                    if (ch4.getSelectedItem().equals("Amy")) {
                        data1.setSeller(s);
                    }
                    if (ch4.getSelectedItem().equals("Karen")) {
                        data1.setSeller(s2);
                    }
                    if (ch4.getSelectedItem().equals("Kevin")) {
                        data1.setSeller(s3);
                    }
                    if (ch5.getSelectedItem().equals("Tom")) {
                        data1.setBuyer(b);
                    }
                    if (ch5.getSelectedItem().equals("Mike")) {
                        data1.setBuyer(b2);
                    }
                    if (ch5.getSelectedItem().equals("Alan")) {
                        data1.setBuyer(b3);
                    }
                    if (ch6.getSelectedItem().equals("Olive")) {
                        data1.setAucHouse(auc);
                    }
                    if (ch6.getSelectedItem().equals("Carly")) {
                        data1.setAucHouse(auc2);
                    }
                    if (ch6.getSelectedItem().equals("Erin")) {
                        data1.setAucHouse(auc3);
                    }
                } else if (t.getSelectedItem().equals("2")) {
                    if (ch4.getSelectedItem().equals("Amy")) {
                        data2.setSeller(s);
                    }
                    if (ch4.getSelectedItem().equals("Karen")) {
                        data2.setSeller(s2);
                    }
                    if (ch4.getSelectedItem().equals("Kevin")) {
                        data2.setSeller(s3);
                    }
                    if (ch5.getSelectedItem().equals("Tom")) {
                        data2.setBuyer(b);
                    }
                    if (ch5.getSelectedItem().equals("Mike")) {
                        data2.setBuyer(b2);
                    }
                    if (ch5.getSelectedItem().equals("Alan")) {
                        data2.setBuyer(b3);
                    }
                    if (ch6.getSelectedItem().equals("Olive")) {
                        data2.setAucHouse(auc);
                    }
                    if (ch6.getSelectedItem().equals("Carly")) {
                        data2.setAucHouse(auc2);
                    }
                    if (ch6.getSelectedItem().equals("Erin")) {
                        data2.setAucHouse(auc3);
                    }
                } else if (t.getSelectedItem().equals("3")) {
                    if (ch4.getSelectedItem().equals("Amy")) {
                        data3.setSeller(s);
                    }
                    if (ch4.getSelectedItem().equals("Karen")) {
                        data3.setSeller(s2);
                    }
                    if (ch4.getSelectedItem().equals("Kevin")) {
                        data3.setSeller(s3);
                    }
                    if (ch5.getSelectedItem().equals("Tom")) {
                        data3.setBuyer(b);
                    }
                    if (ch5.getSelectedItem().equals("Mike")) {
                        data3.setBuyer(b2);
                    }
                    if (ch5.getSelectedItem().equals("Alan")) {
                        data3.setBuyer(b3);
                    }
                    if (ch6.getSelectedItem().equals("Olive")) {
                        data3.setAucHouse(auc);
                    }
                    if (ch6.getSelectedItem().equals("Carly")) {
                        data3.setAucHouse(auc2);
                    }
                    if (ch6.getSelectedItem().equals("Erin")) {
                        data3.setAucHouse(auc3);
                    }
                }
                f.dispose();
                f2.show();
            }
        };

       static ActionListener inp = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.dispose();
                f.show();
            }
        };

       static ActionListener fin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.dispose();

                int prefix = 4;   //hash starts with four zeroes
                String prefixString = new String(new char[prefix]).replace('\0', '0');

                Block genesisBlock = new Block(data1, " ", new Date().getTime());
                genesisBlock.mineBlock1(prefix);
                if (genesisBlock.getHash().substring(0, prefix).equals(prefixString) && genesisBlock.verify_Blockchain(blockchain))
                    blockchain.add(genesisBlock);
                else
                    System.out.println("Malicious block, not added to the chain");

                Block secondBlock = new Block(data2, blockchain.get(blockchain.size() - 1).getHash(), new Date().getTime());
                secondBlock.mineBlock1(prefix);
                if (secondBlock.getHash().substring(0, prefix).equals(prefixString) && secondBlock.verify_Blockchain(blockchain))
                    blockchain.add(secondBlock);
                else
                    System.out.println("Malicious block, not added to the chain");

                Block newBlock = new Block(data3, blockchain.get(blockchain.size() - 1).getHash(), new Date().getTime());
                newBlock.mineBlock(prefix);
                if (newBlock.getHash().substring(0, prefix).equals(prefixString) && newBlock.verify_Blockchain(blockchain))
                    blockchain.add(newBlock);
                else
                    System.out.println("Malicious block, not added to the chain");
            }
        };

    public static void main(String[] args) {
        makeFrame();
        inp1.addActionListener(inp);
        ent.addActionListener(act);

        inp2.addActionListener(inp);
        ent.addActionListener(act);

        inp3.addActionListener(inp);
        ent.addActionListener(act);

        done.addActionListener(fin);
    }
}