// PersonSerial.java
package Serializable;

import java.io.Serializable;

public class PersonSerial implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    public PersonSerial(String name){
        this.name =name;
    }

    public String getName(){
        return this.name;
    }
}
