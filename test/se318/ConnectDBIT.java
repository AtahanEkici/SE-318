package se318;

import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectDBIT
{
    @Test
    public void testGetCredential_Teacher() {
        System.out.println("getCredential_Teacher");
        String Username = "username1";
        String Password = "password1";
        ArrayList<String> result = ConnectDB.getCredential_Teacher(Username, Password);
        assertNotEquals(null,result);
    }

    @Test
    public void testGetCredential_Student() {
        System.out.println("getCredential_Student");
        String Username = "username1";
        String Password = "password1";
        ArrayList<String> result = ConnectDB.getCredential_Student(Username, Password);
        assertNotEquals(null,result);
    }

    @Test
    public void testCheck_For_Password() throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        db.getConnection();
        System.out.println("Check_For_Password");
        String Tablename = "Teacher";
        String Username = "username1";
        String Password = "password1";
        Boolean expResult = true;
        Boolean result = ConnectDB.Check_For_Password(Tablename, Username, Password);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheck_For_Password_Student() throws Exception {
        System.out.println("Check_For_Password_Student");
        String Username = "username2";
        String Password = "password2";
        Boolean expResult = true;
        Boolean result = ConnectDB.Check_For_Password_Student(Username, Password);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheck_For_Password_Teacher() throws Exception 
    {
        ConnectDB db = new ConnectDB();
        db.getConnection();
        System.out.println("Check_For_Password_Teacher");
        String username = "username2";
        String password = "password2";
        Boolean expResult = true;
        Boolean result = ConnectDB.Check_For_Password_Teacher(username, password);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheck_For_Password_Admin() throws Exception 
    {
        ConnectDB db = new ConnectDB();
        System.out.println("Check_For_Password_Admin");
        String Username = "admin";
        String Password = "admin";
        Boolean expResult = true;
        Boolean result = ConnectDB.Check_For_Password_Admin(Username, Password);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllTeacherNames() {
        System.out.println("getAllTeacherNames");
        ConnectDB instance = new ConnectDB();
        ArrayList<String> result = instance.getAllTeacherNames();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Kaan Kurtel");
        expected.add("Cem Evrendilek");
        expected.add("Serhat Uzunbayır");
        expected.add("Yekta Golem");
        expected.add("");
        assertEquals(expected, result);
    }

    @Test
    public void testGetAllStudentNames() {
        System.out.println("getAllStudentNames");
        ConnectDB instance = new ConnectDB();
        ArrayList<String> result = instance.getAllStudentNames();
         ArrayList<String> expected = new ArrayList<>();
         expected.add("Atahan Ekici");
         expected.add("Onat Kocabaşoğlu");
         expected.add("Hacer");
         expected.add("Seda Sindi");  
         expected.add("");
        assertEquals(expected, result);
    }

    @Test
    public void testGet_Attendance_Student() 
    {
        System.out.println("get_Attendance_Student");
        int ID = 1;
        ArrayList<String> result = ConnectDB.get_Attendance_Student(ID);
        assertNotEquals(null,result);
    }

    @Test
    public void testGivenCourses() throws ClassNotFoundException, SQLException
    {
        ConnectDB db = new ConnectDB();
        db.getConnection();
        System.out.println("GivenCourses");
        int ID = 1;
        ArrayList<String> result = ConnectDB.GivenCourses(ID);
        assertNotEquals(null,result);
    }

    @Test
    public void testEnrolledCourses() throws ClassNotFoundException, SQLException 
    {
        ConnectDB db = new ConnectDB();
        db.getConnection();
        System.out.println("EnrolledCourses");
        int ID = 1;
        ArrayList<String> result = ConnectDB.EnrolledCourses(ID);
        assertNotEquals(null,result);
    }

    @Test
    public void testTotal_Student() 
    {
        System.out.println("Total_Student");
        int expResult = 4;
        int result = ConnectDB.Total_Student();
        assertEquals(expResult, result);
    }


    @Test
    public void testGet_Attendance_Teacher() 
    {
        System.out.println("Get_Attendance_Teacher");
        int ID = 1;
        ArrayList<String> result = ConnectDB.Get_Attendance_Teacher(ID);
        assertNotEquals(null,result);
    }

    @Test
    public void testGet_Messages() throws ClassNotFoundException, SQLException
    {
        ConnectDB db = new ConnectDB();
        db.getConnection();
        System.out.println("Get_Messages");
        String Name = "Hacer";
        ArrayList<String> result = ConnectDB.Get_Messages(Name);
        assertNotEquals(null,result);
    }

    @Test
    public void testGet_All_Users() 
    {
        System.out.println("Get_All_Users");
        ArrayList<String> result = ConnectDB.Get_All_Users();
        assertNotEquals(null,result);
    }
}