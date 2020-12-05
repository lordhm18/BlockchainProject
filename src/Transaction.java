import java.time.LocalDateTime;

public class Transaction {
    private Artefact art;
    private int timestamp;
    private Stakeholder seller;
    private Stakeholder buyer;
    private Stakeholder aucHouse;
    private double price;

    public Transaction(){}

    public Transaction(Artefact art, int timestamp,Stakeholder seller,Stakeholder buyer,Stakeholder aucHouse,double price){
        this.art=art;
        this.timestamp=timestamp;
        this.seller=seller;
        this.buyer=buyer;
        this.aucHouse=aucHouse;
        this.price=price;
    }

    public void setArt(Artefact a){
        this.art=a;
    }

    public void setTimestamp(int t){
        this.timestamp=t;
    }

    public void setSeller(Stakeholder s){
        this.seller=s;
    }

    public void setBuyer(Stakeholder b){
        this.buyer=b;
    }

    public void setAucHouse(Stakeholder a){
        this.aucHouse=a;
    }

    public void setPrice(double p){
        this.price=p;
    }

    public Artefact getArt(){
        return art;
    }

     public int getTimeStamp(){
        return timestamp;
    }

    public Stakeholder getSeller() {
        return seller;
    }

    public Stakeholder getBuyer() {
        return buyer;
    }

    public Stakeholder getAucHouse() {
        return aucHouse;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "\n" + "Transaction: "+ art + ", " + timestamp + ", " +
                seller + ", " + buyer + ", "+ aucHouse + ", $"+price ;
    }

}
