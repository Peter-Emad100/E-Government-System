public abstract class Human {
    String name;
    String id;
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    Human(String name,String id){
        this.name=name;
        this.id=id;
    }
}
