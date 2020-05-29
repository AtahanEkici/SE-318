package se318;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import static se318.ConnectDB.Check_For_Password;
import static se318.ConnectDB.EnrolledCourses;
import static se318.ConnectDB.Get_Messages;
import static se318.ConnectDB.GivenCourses;
import static se318.ConnectDB.Update_Attendance;
import static se318.ConnectDB.get_Attendance_Student;

public class Menus 
{  
    public static void Main_Menu() throws SQLException, UnsupportedEncodingException, ClassNotFoundException
 {    
    int secim = 0;
    
        while(secim != 4)
    {
    
    System.out.println("Press 1 For Admin Login\n"
            + "Press 2 For Teacher Login\n"
            + "Press 3 For Student Login\n"
            + "Press 4 To Quit");
    
    System.out.print("Your Choice: ");
    
    Scanner secim_s = new Scanner(System.in);
    
    if(secim_s.hasNextInt() == false)
    {
        System.out.println("\nPlease provide an integer as stated above\n"); 
    }
    else
    {
        secim = secim_s.nextInt();
        
        switch(secim)
        {
            case 1:
                Check_Admin();
                break;
                
            case 2:
                Check_Teacher();
                break;
                
            case 3:
                Check_Student();
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
    
    public static void Check_Admin() throws SQLException, ClassNotFoundException
    {
        String Username = null;
        String Password = null;
        
        boolean checked = false;
        
         while(checked == false)
 {
     System.out.print("\nUsername :");
       Scanner user_n = new Scanner(System.in,"UTF-8");
       Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in,"UTF-8");
       Password = pass_n.nextLine();
       
       if(Check_For_Password("Admin",Username,Password) == true)
       {
           System.out.println("Admin Access Granted\n");
           checked = true;
       }
            
       else
       {
           System.out.println("Wrong username OR password \n");
       }
    }
       int secim_2 = 0;
           
      while(secim_2 != 8)  
      {
        String s = "\nPress 1 for Listing All Students\n"
                   + "Press 2 for Listing All Teachers\n"
                   + "Press 3 for Listing All Courses\n"
                   + "Press 4 for Listing All Attendances\n"
                   + "Press 5 for Listing All Messages\n"
                   + "Press 6 for Adding a Student\n"
                   + "Press 7 for Adding a Teacher\n"
                   + "Press 8 to Quit";
           
           System.out.println(s);
           
           System.out.print("\nYour Choice: ");
    
    Scanner secim_s_2 = new Scanner(System.in);
    
    if(secim_s_2.hasNextInt() == false)
    {
        System.out.println("\nWrong input please provide an integer as stated above\n");
        
    }
    else
    {
        secim_2 = secim_s_2.nextInt();
        
        switch(secim_2)
        {
            case 1:
                ConnectDB.getFrom_Student();
                break;
                
            case 2:
                ConnectDB.getFrom_Teacher();
                break;
                
            case 3:
                ConnectDB.getFrom_Courses();
                break;
                
            case 4:
               ConnectDB.getFrom_Attendance();
                break;
                
            case 5:
                ConnectDB.getFrom_Messages();
                break;
                
            case 6:
                System.out.print("Please Provide A Name: ");
                Scanner name_scanner = new Scanner(System.in);
                String Name = name_scanner.nextLine();
                
                System.out.print("Please Provide A Username: ");
                Scanner username_scanner = new Scanner(System.in);
                String username = username_scanner.nextLine();
                
                System.out.print("Please Provide A Password: ");
                Scanner password_scanner = new Scanner(System.in);
                String pass = password_scanner.nextLine();
                
                System.out.print("Please Provide A Age: ");
                Scanner Age_scanner = new Scanner(System.in);
                String Age = Age_scanner.nextLine();
                int age = Integer.parseInt(Age);
                
                int year = Calendar.getInstance().get(Calendar.YEAR);
                
                ConnectDB.addTo_Student(Name, username, pass, age, year);
                
                System.out.println("\nSuccesfully Created new Student\n");
                
                break;
                
            case 7:
                System.out.print("Please Provide A Name: ");
                Scanner Name_scanner = new Scanner(System.in);
                String Teacher_Name = Name_scanner.nextLine();
                
                System.out.print("Please Provide A Username: ");
                Scanner Username_teacher_scan = new Scanner(System.in);
                String Username_Teacher = Username_teacher_scan.nextLine();
                
                System.out.print("Please Provide A Password: ");
                Scanner Password_teacher_scanner = new Scanner(System.in);
                String Password_teacher = Password_teacher_scanner.nextLine();
                
                ConnectDB.addTo_Teacher(Teacher_Name, Username_Teacher, Password_teacher);
                
                System.out.println("\nSuccessfully Added new Teacher\n");
                break;
                
            default:
                if(secim_2 == 8)
                {
                    System.out.println("\nReturning to Main Menu\n");
                }
                else
                {
                    System.out.println("Error!\n");    
                }      
    }
   }
}
    }
    
    
    public static void Check_Teacher() throws SQLException, UnsupportedEncodingException, ClassNotFoundException
{
    boolean checked = false;
    
    String Username = null;
    String Password = null;
    
    while(checked == false)
 {
     System.out.print("\nUsername :");
       Scanner user_n = new Scanner(System.in,"UTF-8");
       Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in,"UTF-8");
       Password = pass_n.nextLine();
       
       if(Check_For_Password("Teacher",Username,Password) == true)
       {
           System.out.println("Access successful as Teacher\n");
           checked = true;
       }
       
       else
       {
           System.out.println("Wrong username OR password \n");
       }
    }  
    
    int secim_2 = 0;
    
    ArrayList <String> list = new ArrayList<>();
    
    list = ConnectDB.getCredential_Teacher(Username,Password);
    
    String Name = list.get(1).trim(); 
    
    int ID = Integer.parseInt(list.get(0));
           
      while(secim_2 != 7)  
      {
           String s = "\nPress 1 to show your Credentials\n"
                   + "Press 2 to Take Attendance\n"
                   + "Press 3 to Courses\n"
                   + "Press 4 to Update Attendance\n"
                   + "Press 5 to Message\n"
                   + "Press 6 to See your Messages\n"
                   + "Press 7 to QUIT\n";
           
           System.out.println(s);
           
           System.out.print("Your Choice: ");
    
    Scanner secim_s_2 = new Scanner(System.in);
    
    if(secim_s_2.hasNextInt() == false)
    {
        System.out.println("\nWrong input please provide an integer as stated above!\n");
        
    }
    else
    {
        secim_2 = secim_s_2.nextInt();
        
        switch(secim_2)
        {
            case 1:
                System.out.println("\n"+list);
                break;
                
            case 2:
        System.out.println("\n"+GivenCourses(ID));

        Scanner course_scan = new Scanner(System.in);
        System.out.print("Pick a Course ID you'd like to take the Attendance:");
        int Course = course_scan.nextInt();
                
        ArrayList<String> Student_List = new ArrayList<>();
        Student_List = ConnectDB.Get_Attendance_Teacher(1);
        
        int counter = 0;
        
        for(int i = 0; i<Student_List.size();i++)
        {
            if((counter % 4) == 0)
            {
                System.out.print("\nID:");
            }
                ++counter;
                System.out.print(" "+Student_List.get(i)); 
        }
        
        System.out.print("\nPick the ID of the Student that is absent:");
        
        Scanner student_scan = new Scanner(System.in);
        int picked = student_scan.nextInt();
        ConnectDB.Increment_Absent(picked,Course);
        System.out.println("\nSuccessfully incremented\n");
                break;
                
            case 3:
                System.out.println("\n"+GivenCourses(ID));
                break;
                
            case 4:
                System.out.println("\n"+GivenCourses(ID));

        Scanner course_scan2 = new Scanner(System.in);
        System.out.print("\nPick a Course ID you'd like to take the Attendance:");
        int Course2 = course_scan2.nextInt();
                
        Student_List = ConnectDB.Get_Attendance_Teacher(1);
        
        counter = 0;
        
        for(int i = 0; i<Student_List.size();i++)
        {
            if((counter % 4) == 0)
            {
                System.out.print("\nID:");
            }
                ++counter;
                System.out.print(" "+Student_List.get(i)); 
        }
        
        System.out.print("\nPick the ID of the Student that you want to update:");
        
        Scanner student_scan2 = new Scanner(System.in);
        int picked2 = student_scan2.nextInt();
        
        System.out.println("\n");
        
        System.out.print("What value you want to Update:");
        
        Scanner student_scan3 = new Scanner(System.in);
        int value = student_scan3.nextInt();
        
        Update_Attendance(value,Course2,picked2);
        
                break;
                
            case 5:
                String Message = "";
                String Send_To = "";
                
                Scanner Mes_sca = new Scanner(System.in);
                System.out.print("\nYour Message: ");
                Message = Mes_sca.nextLine();
                
                System.out.println(ConnectDB.Get_All_Users());
                System.out.print("\nSend To: ");
                Scanner sen_sca = new Scanner(System.in);
                Send_To = sen_sca.nextLine();
                
                ConnectDB.addTo_Messages(Name,Send_To,Message);
                System.out.println("Message Sent To "+Send_To+"");
                break;
                
            case 6: 
                System.out.println("\n"+Get_Messages(Name)+"\n");
                break;
                
            default:
                if(secim_2 == 4)
                {
                    System.out.println("\nReturning to Main Menu\n");
                }
                else
                {
                    System.out.println("Error!\n");    
                }      
    }
   }
}
} 
    
public static void Check_Student() throws SQLException, ClassNotFoundException
{
    boolean checked = false;
    
    String Username = null;
    String Password = null;
    
    while(checked == false)
 {
     System.out.print("\nUsername :");
       Scanner user_n = new Scanner(System.in,"UTF-8");
       Username = user_n.nextLine();
       
       System.out.print("Password :");
       Scanner pass_n = new Scanner(System.in,"UTF-8");
       Password = pass_n.nextLine();
       
       if(Check_For_Password("Student",Username,Password) == true)
       {
           System.out.println("Student Access Successfull");
           checked = true;
       }
       
       else
       {
           System.out.println("Wrong username OR password \n");
       }
    }  
    
    int secim_2 = 0;
    
    ArrayList <String> list = new ArrayList<>();
    
    list = ConnectDB.getCredential_Student(Username,Password);
    

    int ID = Integer.parseInt(list.get(0));
    String Name = list.get(1).trim();
    //int Age = Integer.parseInt(list.get(4));
    //int Year = Integer.parseInt(list.get(5));


      while(secim_2 != 6)  
      {
           String s = "\nPress 1 for show your Credentials\n"
                   + "Press 2 for show your courses enrolled\n"
                   + "Press 3 for show your Attendances\n"
                   + "Press 4 to message User \n"
                   + "Press 5 to Show Messages\n"
                   + "Press 6 to Quit";
           
           System.out.println(s);
           
           System.out.print("Your Choice: ");
    
    Scanner secim_s_2 = new Scanner(System.in);
    
    if(secim_s_2.hasNextInt() == false)
    {
        System.out.println("\nWrong Input please provide an integer as listed above!\n");
        
    }
    else
    {
        secim_2 = secim_s_2.nextInt();
        
        switch(secim_2)
        {
            case 1:
                System.out.println("\n"+list);
                break;
                
            case 2:
                System.out.println("\n"+EnrolledCourses(ID));
                break;
                
            case 3:
                System.out.println("\n"+get_Attendance_Student(ID));
                break;
                
            case 4:
                String Message = "";
                String Send_To = "";
                
                Scanner Mes_sca = new Scanner(System.in);
                System.out.print("\nYour Message: ");
                Message = Mes_sca.nextLine();
                
                System.out.println(ConnectDB.Get_All_Users());
                System.out.print("\nSend To: ");
                Scanner sen_sca = new Scanner(System.in);
                Send_To = sen_sca.nextLine();
                Send_To = Send_To.trim();
                
                ConnectDB.addTo_Messages(Name,Send_To,Message);
                System.out.println("Message Sent To "+Send_To+"");
                break;
                
            case 5:
                System.out.println("\n"+Get_Messages(Name)+"\n");
                break;
                
            default:
                if(secim_2 == 4)
                {
                    System.out.println("\nReturning to Main Menu\n");
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