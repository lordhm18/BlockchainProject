public class Main {

    public static void main(String[] args) {
        Stakeholder o= new Stakeholder("O333","Mary","25 Spring St",5000);
        Stakeholder s=new Stakeholder("S123","Amy","12 Oak Circle",1000);
        Stakeholder b= new Stakeholder("B456","Tom","3 Penny Ln",20000);
        Stakeholder auc= new Stakeholder("AUC356","Olive","5 Court St",7000);
        Artefact a = new Artefact("D55","Painting","USA",o);
        Transaction t=new Transaction(a, 2020,s,b,auc,500);

        System.out.println(s.toString());
        System.out.println(a.toString());
        System.out.println(t.toString());

    }
}
