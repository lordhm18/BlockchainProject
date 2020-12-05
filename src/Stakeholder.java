public class Stakeholder {
    private String ID;
   private String name;
   private String addr;
   private double bal;

    public Stakeholder(){}

    public Stakeholder(String ID, String n, String a, double bal ){
        this.ID=ID;
        this.name=n;
        this.addr=a;
        this.bal=bal;
    }

    public void setID(String ID){
        this.ID=ID;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAddr(String addr){
        this.addr=addr;
    }

    public void setBal(double bal){
        this.bal+=bal;
    }

    public String getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getAddr (){
        return addr;
    }

    public double getBal(){
        return bal;
    }

    public String toString() {
        return "\n" + "Stakeholder: " + ID + ", " + name + ", " +
                addr + ", $" + bal ;
    }


}
