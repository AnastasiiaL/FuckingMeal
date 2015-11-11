package model;

/**
 * Created by Кроха on 17.09.2015.
 */
public class Shop {
    public String name;
    public String location;

    public Shop(String name, String location){
        this.name = name;
        this.location = location;
    }
    @Override public String toString(){

        return (this.name + " " + this.location);
    }
}
