import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    public static void main(String[] args) {
        Stakeholder s=new Stakeholder("S123","Amy","12 Oak Circle",1000);
        Artefact a = new Artefact("D55","Painting","USA",s);
        System.out.println(s.toString());
        System.out.println(a.toString());
    }
}
