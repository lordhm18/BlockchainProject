public class Artefact {
    String ID;
    String name;
    Stakeholder country;
    Stakeholder owner;

    public Artefact(){}

    public Artefact(String ID, String name, Stakeholder country, Stakeholder owner ){
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

    public void setCountry(Stakeholder country){
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

    public Stakeholder getCountry(){
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