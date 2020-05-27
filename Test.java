package se318;

import java.sql.SQLException;
import static se318.ConnectDB.Check_For_Password_Teacher;
import static se318.Menus.Main_Menu;


public class Test 
{
     public static void main(String[] args) throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        
        db.getConnection();
        
        System.out.println(ConnectDB.Check_For_Password_Student("username","password"));
        
        //Main_Menu();
        
        //System.out.println(db.Check_For_Password_Admin("admin", "admin"));
        
        //db.getFrom_Student();

        //db.addTo_Student("Deneme", "username", "password",2 , 4);
        
        //db.addTo_Teacher("Serhat Uzunbayır", "suzunbayır", "Herkese100");
        
        //db.getFrom_Teacher();
        
        //db.addTo_Courses("SE318", 1, "Kaan Kurtel", "Summer");
        
        //db.getFrom_Courses();

        //db.addTo_Attendance(1, "SE318", 2, 0);
        
        //db.getFrom_Attendance();
        
        //db.addTo_Messages("Cem Evrendilek", "Atahan Ekici", "Çalış artık aq öğrencisi!!1!!");
        
        //db.getFrom_Messages();
        
        //System.out.println(db.getAllTeacherNames());
        
        //db.DisplayAllTables();
        
         //System.out.println(db.getAllStudentNames());
    }  
}  



