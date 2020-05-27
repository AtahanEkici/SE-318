package se318;

import java.sql.SQLException;
import java.util.Scanner;
import static se318.ConnectDB.Check_For_Password_Admin;
import static se318.ConnectDB.Check_For_Password_Student;
import static se318.ConnectDB.Check_For_Password_Teacher;

public class Menus 
{  
    public static void Main_Menu() throws SQLException
 {    
    int secim = 0;
    
        while(secim != 4)
    {
    
    System.out.println("Press 1 For Admin Login\n"
            + "Press 2 For Teacher Login\n"
            + "Press 3 For Student Login\n"
            + "Press 4 To Quit");
    
    System.out.print("Your Choice:");
    
    Scanner secim_s = new Scanner(System.in);
    
    if(secim_s.hasNextInt() == false)
    {
        System.out.println("\nLütfen geçerli bir değer girin\n");
        
    }
    else
    {
        secim = secim_s.nextInt();
        
        switch(secim)
        {
            case 1:
                Admin_Menu();
                secim = 4;
                break;
                
            case 2:
                Teacher_Menu();
                secim = 4;
                break;
                
            case 3:
                Student_Menu();
                secim = 4;
                break;
                
            case 4:
                System.out.print("");
                
            default:
                System.out.println("Error!\n");      
    }
   }
  }
 }
    
    public static void Admin_Menu() throws SQLException
    {
         while(true)
 {
     System.out.print("Username :");
       Scanner user_n = new Scanner(System.in);
       String Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in);
       String Password = pass_n.nextLine();
       
       if(Check_For_Password_Admin(Username,Password) == true)
       {
           System.out.println("Admin girişi başarılı");
           break;
       }
       
       else
       {
           System.out.println("Hatalı Giriş tekrar deneyin! \n");
       }
    } 
    }
    
    
    public static void Teacher_Menu() throws SQLException
{
   while(true)
 {
     System.out.print("Username :");
       Scanner user_n = new Scanner(System.in);
       String Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in);
       String Password = pass_n.nextLine();
       
       if(Check_For_Password_Teacher(Username,Password) == true)
       {
           System.out.println("Teacher girişi başarılı");
           break;
       }
       
       else
       {
           System.out.println("Hatalı Giriş tekrar deneyin! \n");
       }
    } 
} 
       public static void Student_Menu() throws SQLException
{
    while(true)
 {
     System.out.print("Username :");
       Scanner user_n = new Scanner(System.in);
       String Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in);
       String Password = pass_n.nextLine();
       
       if(Check_For_Password_Student(Username,Password) == true)
       {
           System.out.println("Student girişi başarılı");
           break;
       }
       
       else
       {
           System.out.println("Hatalı Giriş tekrar deneyin! \n");
       }
    } 
}
}