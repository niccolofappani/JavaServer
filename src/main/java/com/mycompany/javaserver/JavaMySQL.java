package com.mycompany.javaserver;

import java.sql.*;
import java.util.ArrayList;

public class JavaMySQL {
    ArrayList<Studenti> studenti = new ArrayList<>();
    public void start(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/EsTPSIT?user=root&password=12345&serverTimezone=Europe/Rome");
            Statement statement = connessione.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Studenti");
            while(resultset.next()){
                String nome = resultset.getString("Nome");
                String cognome = resultset.getString("Cognome");
                studenti.add(new Studenti(nome, cognome));
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Studenti> getStudenti() {
        return studenti;
    }
    
    public JavaMySQL(){
        start();
    }
}
