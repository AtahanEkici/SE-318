package se318;

import java.sql.SQLException;

public class Test 
{
     public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        
        db.getConnection();
        
        //db.getFrom_Student();
        
        //db.getFrom_Teacher();
        
        //db.getFrom_Courses();
        
        //db.addTo_Messages("Cem Evrendilek", "Atahan Ekici", "Çalış artık aq öğrencisi!!1!!");
        
        //db.getFrom_Messages();
        
        //db.createtable("Messages");
        
        //db.droptable("Deneme");
        
        //System.out.println(db.displayTableColumns("Teacher"));
        
        //db.DisplayAllTables();
        
         //System.out.println(db.getAllStudentNames());
    }
     
     
     
}
