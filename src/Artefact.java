public class Artefact {
    String ID;
    String name;
    String country;
    Stakeholder owner;

    public Artefact(String ID, String name, String country, Stakeholder owner ){
        this.ID=ID;
        this.name=name;
        this.country=country;
        this.owner=owner;
    }

    public void setID(String ID){
        this.ID=ID;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public void setOwner(Stakeholder owner){
        this.owner=owner;
    }

    public String getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public Stakeholder getOwner(){
        return owner;
    }

    public String toString() {
        return "\n" + "Artefact: "+ ID + ", " + name + ", " +
                country + ", " + owner ;
    }
}
