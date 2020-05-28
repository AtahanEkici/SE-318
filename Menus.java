package se318;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;
import static se318.ConnectDB.Check_For_Password;

public class Menus 
{  
    public static void Main_Menu() throws SQLException, UnsupportedEncodingException
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
                Check_Admin();
                secim = 4;
                break;
                
            case 2:
                Check_Teacher();
                secim = 4;
                break;
                
            case 3:
                Check_Student();
                secim = 4;
                break;
                
            case 4:
                System.out.print("");
                
            default:
                if(secim == 4)
                {
                    System.out.println("Program ended by User Request");
                }
                else
                {
                    System.out.println("Error!\n");    
                }      
    }
   }
  }
 }
    
    public static void Check_Admin() throws SQLException
    {
         while(true)
 {
     System.out.print("Username :");
       Scanner user_n = new Scanner(System.in,"UTF-8");
       String Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in,"UTF-8");
       String Password = pass_n.nextLine();
       
       if(Check_For_Password("Admin",Username,Password) == true)
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
    
    
    public static void Check_Teacher() throws SQLException, UnsupportedEncodingException
{
   while(true)
 {
       System.out.print("\nUsername :");
       Scanner user_n = new Scanner(new InputStreamReader(System.in,"UTF-8"));
       String Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(new InputStreamReader(System.in,"UTF-8"));
       String Password = pass_n.nextLine();
       
       if(Check_For_Password("Teacher",Username,Password) == true)
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
       public static void Check_Student() throws SQLException
{
    while(true)
 {
     System.out.print("Username :");
       Scanner user_n = new Scanner(System.in,"UTF-8");
       String Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in,"UTF-8");
       String Password = pass_n.nextLine();
       
       if(Check_For_Password("Student",Username,Password) == true)
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
       
       public static void Student_Menu()
       {
           int secim = 0;
           
      while(secim != 4)  
      {
           String s = "Press 1 for show your Credentials";
           
           System.out.println(s);
           
           System.out.print("Your Choice: ");
    
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
                
                break;
                
            case 2:
                
                break;
                
            case 3:
                
                break;
                
            default:
                if(secim == 4)
                {
                    System.out.println("Program ended by User Request");
                }
                else
                {
                    System.out.println("Error!\n");    
                }      
    }
   }
  
       }
       }
}