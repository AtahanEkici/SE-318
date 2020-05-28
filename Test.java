package se318;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import static se318.ConnectDB.Check_For_Password_Teacher;
import static se318.Menus.Main_Menu;


public class Test 
{
     public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedEncodingException 
    {
        ConnectDB db = new ConnectDB();
        
        db.getConnection();
        
        //Main_Menu();
        
        System.out.println(db.getData_Student("username1","password1"));
        
        //System.out.println(db.getData_Teacher("username1","password1"));
        
        //System.out.println(ConnectDB.Check_For_Password("Admin","admin", "admin"));
        
        //System.out.println(ConnectDB.Check_For_Password("Teacher","", ""));
        
        //System.out.println(ConnectDB.Check_For_Password("Student","username2","password2"));
        
        //System.out.println(ConnectDB.Check_For_Password_Student("username1","password1"));

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



