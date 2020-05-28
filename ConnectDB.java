package se318;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectDB
{
    private static Connection con;
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
   
    void getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:lib/SE318.db");
        //JOptionPane.showMessageDialog(null, "Connection Established");   
    }
    
    public ArrayList<String> getData_Teacher(String Username,String Password)
    {
        ArrayList<String> list = new ArrayList<>();
        
         try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Teacher WHERE username = '"+Username+"' AND password = '"+Password+"';");
            
            while(rs.next())
            {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
            }
            
    }catch(SQLException e)
    {
        System.out.println(e);
    }
         return list;
    }
    
    public ArrayList<String> getData_Student(String Username,String Password)
    {
         ArrayList<String> list = new ArrayList<>();
        
         try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Student WHERE username = '"+Username+"' AND password = '"+Password+"';");
            
            while(rs.next())
            {
                list.add(rs.getString(1));
                list.add(rs.getString(2));
                list.add(rs.getString(3));
                list.add(rs.getString(4));
                list.add(rs.getString(5)); 
                list.add(rs.getString(6)); 
            }
    }catch(SQLException e)
    {
        System.out.println(e);
    }
         return list;
    }
    
    
    public static Boolean Check_For_Password(String Tablename,String Username,String Password)
    {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT EXISTS(SELECT username,password FROM "+Tablename+" WHERE username = '"+Username+"' AND password = '"+Password+"');");
            
            while(rs.next())
            {
                return (rs.getBoolean(1));
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public static Boolean Check_For_Password_Student(String Username,String Password) throws SQLException
    {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT EXISTS(SELECT username,password FROM Student WHERE username = '"+Username+"' AND password = '"+Password+"');");
            
            while(rs.next())
            {
               return (rs.getBoolean(1));
            }
        return null;
    }
    
     public static Boolean Check_For_Password_Teacher(String username,String password) throws SQLException
    {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT EXISTS(SELECT username,password FROM Teacher WHERE username = '"+username+"' AND password = '"+password+"');");
            
            while(rs.next())
            {
               return (rs.getBoolean(1));
            }
        return null;
    }
 
  public static Boolean Check_For_Password_Admin(String Username,String Password) throws SQLException
    {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT EXISTS(SELECT username,password FROM Admin WHERE username = '"+Username+"' AND password = '"+Password+"');");
            
            while(rs.next())
            {
               return (rs.getBoolean(1));
            }
        return null;
    }
    
    public void createtable(String tablename) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
         }
        try {
        PreparedStatement createdb;
        createdb = con.prepareStatement("CREATE TABLE \""+tablename+"\" (\n" +
"	\"ID\"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT\n" +
");");
        createdb.execute();
        } catch (SQLException e) 
    {  
           System.out.println(e);            
    }      
   }
    
        public void getFrom_Teacher() throws SQLException
    {
         Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Teacher");
        
while(rs.next())
        System.out.println("ID: "+ANSI_BLUE+rs.getInt(1)+ANSI_RESET+" Name: "+ANSI_BLUE+rs.getString(2)+ANSI_RESET+" Username: "+ANSI_BLUE+rs.getString(3)+ANSI_RESET+" Password: "+ANSI_BLUE+rs.getString(4)+ANSI_RESET); 
    }
        
     

    public void addTo_Teacher(String Name,String username,String password) throws ClassNotFoundException, SQLException
    {
         String INSERT_TEACHER = "INSERT INTO Teacher(Name,username,password) VALUES(?,?,?)";
        
        if(con == null)
        {
           getConnection();
         }
        
         try 
        {
        PreparedStatement addition;
        addition = con.prepareStatement(INSERT_TEACHER);        
        addition.setString(1, Name);
        addition.setString(2, username);
        addition.setString(3,password);
        addition.execute();
   
        } catch (SQLException e) 
        {
           System.out.println(e);            
    }   
    }
              
   public void getFrom_Student() throws SQLException
    {
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Student");
        
         while(rs.next())
        System.out.println(String.format("ID: "+ANSI_BLUE+"%s"+ANSI_RESET+" Name: "+ANSI_BLUE+"%s"+ANSI_RESET+" UserName: "+ANSI_BLUE+"%s"+ANSI_RESET+" Password: "+ANSI_BLUE+"%s"+ANSI_RESET+" Age: "+ANSI_BLUE+"%s"+ANSI_RESET+" Year: "+ANSI_BLUE+"%s"+ANSI_RESET+"", rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6))); 

    }
   
  public ArrayList<String> getAllTeacherNames()
   {
       ArrayList<String> list = new ArrayList<>();
       
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Name From Teacher");
            
            while(rs.next())
            {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        return list;
   }
    
   public ArrayList<String> getAllStudentNames()
   {
       ArrayList<String> list = new ArrayList<>();
       
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select Name From Student");
            
            while(rs.next())
            {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        return list;
   }
    
    public void addTo_Student(String Name,String UserName,String Password,int Age,int Year) throws ClassNotFoundException, SQLException
    {
       String INSERT_STUDENT = "INSERT INTO Student(Name,Username,Password,Age,Year) VALUES(?,?,?,?,?)";
        
         if(con == null)
        {
           getConnection();
         }

          try 
        {
            
        PreparedStatement addition;
        addition = ConnectDB.con.prepareStatement(INSERT_STUDENT);
        addition.setString(1, Name);
        addition.setString(2, UserName);
        addition.setString(3, Password);
        addition.setInt(4, Age);
        addition.setInt(5, Year);
        addition.execute();
        
        } catch (SQLException e) 
        {
           System.out.println(e);            
    }
    }
    
    public void getFrom_Courses()
    {
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from Courses");
            
            while(rs.next())
            {
                System.out.println(" ID: "+ANSI_BLUE+rs.getInt(1)+ANSI_RESET+" Course Name: "+ANSI_BLUE+rs.getString(2)+ANSI_RESET+" Section: "+ANSI_BLUE+rs.getInt(3)+ANSI_RESET+" Teacher: "+ANSI_BLUE+rs.getString(4)+ANSI_RESET+" Semester: "+ANSI_BLUE+rs.getString(5)+ANSI_RESET);
            }
        } catch (SQLException ex)
        {
            System.out.println(ex);
        }
    }
    
    public void addTo_Courses(String Name, int Section, String Teacher, String Semester) throws ClassNotFoundException, SQLException
    {
         String INSERT_COURSES = "INSERT INTO Courses(Name,Section,Teacher,Semester) VALUES(?,?,?,?)";
         
          if(con == null)
        {
           getConnection();
         }

          try 
        {     
        PreparedStatement addition;
        addition = ConnectDB.con.prepareStatement(INSERT_COURSES);
        addition.setString(1, Name);
        addition.setInt(2, Section);
        addition.setString(3, Teacher);
        addition.setString(4, Semester);
        addition.execute();
        
        } catch (SQLException e) 
        {
           System.out.println(e);            
    }
    }
    
    public void getFrom_Attendance()
    {
         try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from Attendance");
            
            while(rs.next())
            {
                System.out.println(" ID: "+ANSI_BLUE+rs.getInt(1)+ANSI_RESET+" Student_ID: "+ANSI_BLUE+rs.getInt(2)+ANSI_RESET+" Course Name: "+ANSI_BLUE+rs.getString(3)+ANSI_RESET+" Section: "+ANSI_BLUE+rs.getInt(4)+ANSI_RESET+" Attendence: "+ANSI_BLUE+rs.getInt(5)+ANSI_RESET);
            }
        } catch (SQLException ex)
        {
            System.out.println(ex);
        }
    }
    
        public void addTo_Attendance(int Student_ID, String Course, int Section,int Count) throws ClassNotFoundException, SQLException
    {
         String INSERT_ATTENDANCE = "INSERT INTO Attendance(Student_ID,Course,Section,Count) VALUES(?,?,?,?)";
         
          if(con == null)
        {
           getConnection();
         }

          try 
        {     
        PreparedStatement addition;
        addition = ConnectDB.con.prepareStatement(INSERT_ATTENDANCE);
        addition.setInt(1, Student_ID);
        addition.setString(2, Course);
        addition.setInt(3, Section);
        addition.setInt(4, Count);
        addition.execute();
        
        } catch (SQLException e) 
        {
           System.out.println(e);            
    }
    }
        
    public void getFrom_Messages()
    {
         try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from Messages");
            
            while(rs.next())
            {
                System.out.println(" ID: "+ANSI_BLUE+rs.getInt(1)+ANSI_RESET+" Sender: "+ANSI_BLUE+rs.getString(2)+ANSI_RESET+" Reveiver: "+ANSI_BLUE+rs.getString(3)+ANSI_RESET+" Message: "+ANSI_BLUE+rs.getString(4)+ANSI_RESET);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
            public void addTo_Messages(String Sender, String Receiver, String Message) throws ClassNotFoundException, SQLException
    {
         String INSERT_MESSAGES = "INSERT INTO Messages(Sender,Receiver,Message) VALUES(?,?,?)";
         
          if(con == null)
        {
           getConnection();
         }

          try 
        {     
        PreparedStatement addition;
        addition = ConnectDB.con.prepareStatement(INSERT_MESSAGES);
        addition.setString(1, Sender);
        addition.setString(2, Receiver);
        addition.setString(3, Message);      
        addition.execute();
        
        } catch (SQLException e) 
        {
           System.out.println(e);            
    }
    }
    
    
    List<String> displayTableColumns(String tableName) throws SQLException 
    {
        List<String> columns = new ArrayList<>();
        
        try{ 
    String sql = "select * from " + tableName + " LIMIT 0";
    
    Statement statement = con.createStatement();
    ResultSet rs = statement.executeQuery(sql);
    ResultSetMetaData mrs = rs.getMetaData();
    
    for(int i = 1; i <= mrs.getColumnCount(); i++) 
    {
        columns.add(mrs.getColumnLabel(i));
    }
        }catch(SQLException e)
        {
            System.out.println(e);
        }
   
    return columns;
}
    
    public void tableAttributes(String tablename) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
        }
        
         try 
         {
        PreparedStatement showatr;
        showatr = con.prepareStatement("PRAGMA table_info("+tablename+");");
        showatr.execute();
        manuallyvacuumDB();   
        } catch (SQLException e) {
                    
           System.out.println(e);            
    }
    }
   
    public void renametable(String tablename , String new_name) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
        }
        
         try {
        PreparedStatement renametable;
        renametable = con.prepareStatement(" alter table  " + tablename + " rename to " + new_name + " ;");
        renametable.execute();
        manuallyvacuumDB();   
        } catch (SQLException e) {
                    
           System.out.println(e.getCause());            
    }
    }
    
    public void droptable(String tablename) throws SQLException, ClassNotFoundException
      {
          if(con == null)
        {
           getConnection();
         }
          
           try {
          PreparedStatement droptable;
          droptable = con.prepareStatement(" DROP TABLE if exists " + tablename + "");        
          droptable.execute();
          manuallyvacuumDB();
          } catch (SQLException e) 
        {
                    
           System.out.println(e.getCause());            
    }
      }

    public void manuallyvacuumDB() throws ClassNotFoundException, SQLException
      {
           if(con == null)
        {
           getConnection();
         }
           try {
          PreparedStatement vacuum;
          vacuum = con.prepareStatement("VACUUM;");
          vacuum.execute();
          } catch (SQLException e) 
        {
                    
           System.out.println(e.getCause());            
    }
      }

    public void DisplayTable(String tablename) throws SQLException , ClassNotFoundException
      {
          Statement state = con.createStatement();
          ResultSet res = state.executeQuery("select * from sqlite_master where type = 'table' and name ='"+tablename+"'");
          
          try {
          while(res.next())
          {
              
          }
          } catch (SQLException e) 
        {
                    
           System.out.println(e.getCause());            
    }
      }

      public void findontableitem(String tablename , String item , String parameter) throws SQLException, ClassNotFoundException
    {
        if(con == null)
        {
           getConnection();
        }
         try {
         PreparedStatement findontableitem;
         findontableitem = con.prepareStatement("SELECT "+item+" FROM " + tablename + " WHERE " + parameter + " ");
         findontableitem.execute();
         
         } catch (SQLException e) 
        {
                    
           System.out.println(e.getCause());            
    }
    
    }
      
        public void DisplayAllTables() throws SQLException, ClassNotFoundException
      {
       if(con == null)
        {
           getConnection();
        }
           try {
           DatabaseMetaData md = con.getMetaData();
           ResultSet rs = md.getTables(null, null, "%", null);           
            
           while(rs.next())
           {
                System.out.println(rs.getString(3));
           }  
           } catch (SQLException e) 
        {
                    
           System.out.println(e.getCause());            
    }
      }

        public void Terminal(String a) throws SQLException, ClassNotFoundException
      {
          if(con == null)
         {
           getConnection();
         }
          
          try {
          PreparedStatement Terminal;
          Terminal = con.prepareStatement(""+a+"");
          Terminal.execute();
          } catch (SQLException e) 
        {
                    
           System.out.println(e.getCause());            
    }
      }
}