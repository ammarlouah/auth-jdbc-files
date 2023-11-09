package com.example;
import java.io.*;

public class WriteFile {
    public static void write(String appoge,String cne) throws IOException{
        File file = new File("login.txt");
        FileWriter ecr = new FileWriter(file,true);
        ecr.write(appoge+"/"+cne+"\n");
        ecr.close();
    }

    public static void write(String appoge,String cne,String nom,String prenom) throws IOException{
        File file = new File("signup.txt");
        FileWriter ecr = new FileWriter(file,true);
        ecr.write(appoge+"/"+cne+"/"+nom+"/"+prenom+"\n");
        ecr.close();
    }
}
