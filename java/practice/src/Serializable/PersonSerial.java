package Serializable;

import java.io.Serializable;

public class PersonSerial implements Serializable{
    private String name;
    public PersonSerial(String name){
        this.name =name;
    }

    public String getName(){
        return this.name;
    }
}
