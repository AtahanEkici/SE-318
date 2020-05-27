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

/**
 *
 * @author oculus_team_4
 */
public class ConnectDB 
{
    private static Connection con;
   
    void getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:SE318.db");
         System.out.println("Successfully Connected");    
    }
    
    /**
     *
     * @param tablename
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
        } catch (SQLException e) {
                    
           System.out.println(e);            
    }      
   }
    
        public void getFrom_Teacher() throws SQLException
    {
         Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("select * from Teacher");
        
while(rs.next())
        System.out.println("ID: "+rs.getInt(1)+" Name: "+rs.getString(2)+" Username: "+rs.getString(3)+" Password: "+rs.getString(4)); 
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
        System.out.println(String.format("ID: %s Name: %s Age: %s", rs.getInt(1), rs.getString(2), rs.getInt(3))); 

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
    
    public void addTo_Student(String Name,int Age,String Semester,int Year,String Courses,int Absent) throws ClassNotFoundException, SQLException
    {
       String INSERT_STUDENT = "INSERT INTO Student(Name,Age) VALUES(?,?)";
        
         if(con == null)
        {
           getConnection();
         }

          try 
        {
            
        PreparedStatement addition;
        addition = ConnectDB.con.prepareStatement(INSERT_STUDENT);
        addition.setString(1, Name);
        addition.setInt(2, Age);
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
                System.out.println(" ID: "+rs.getInt(1)+" Course Name: "+rs.getString(2)+" Section: "+rs.getInt(3)+" Teacher: "+rs.getString(4)+" Semester: "+rs.getString(5));
            }
        } catch (SQLException ex) {
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
    
    public void getFrom_Attendence()
    {
         try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from Attendance");
            
            while(rs.next())
            {
                System.out.println(" ID: "+rs.getInt(1)+" Student_ID: "+rs.getInt(2)+" Course Name: "+rs.getString(3)+" Seciton: "+rs.getInt(4));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
        public void addTo_Attendence(int Student_ID, String Name, int Section) throws ClassNotFoundException, SQLException
    {
         String INSERT_ATTENDANCE = "INSERT INTO Attendence(Student_ID,Course,Section) VALUES(?,?,?)";
         
          if(con == null)
        {
           getConnection();
         }

          try 
        {     
        PreparedStatement addition;
        addition = ConnectDB.con.prepareStatement(INSERT_ATTENDANCE);
        addition.setInt(1, Student_ID);
        addition.setString(2, Name);
        addition.setInt(3, Section);       
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
                System.out.println(" ID: "+rs.getInt(1)+" Sender: "+rs.getString(2)+" Reveiver: "+rs.getString(3)+" Message: "+rs.getString(4));
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
        
         try {
             /*
        PreparedStatement begin;
        begin = con.prepareStatement(".headers on");
        begin.execute();    
             */
             
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
          PreparedStatement displaytable;
          displaytable = con.prepareStatement(""+a+"");
          displaytable.execute();
          } catch (SQLException e) 
        {
                    
           System.out.println(e.getCause());            
    }
      }
}