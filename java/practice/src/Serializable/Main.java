package Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        PersonSerial p = new PersonSerial("hiio420");


        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("files","test")))){
            os.writeObject(p);
        }catch(Exception e){
            e.printStackTrace();
        }



        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("files","test")))){
            PersonSerial inputPersonObject = (PersonSerial)is.readObject();
            System.out.println(inputPersonObject.getName());

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
