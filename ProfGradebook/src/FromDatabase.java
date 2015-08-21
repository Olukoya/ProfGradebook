import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/FromDatabase")
public class FromDatabase extends HttpServlet  
{
	static String studentID,assignmentName, date, type,student="";
	static Integer grade = 0;
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");                
		}
	
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	try
        {
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost","testdb","password");
             Statement st=con.createStatement();
             System.out.println("connection established successfully...!!");     
 
             ResultSet rs=st.executeQuery("select * from gradebook");
 
             student+= "<table border=1>";
             student+= "<tr><th>Student ID</th><th>Assignment Name</th><th>Type</th><th>Date</th><th>Grade</th></tr>";
                 while(rs.next())
                 {
                	 studentID = rs.getString("STUDENT_ID");
                	 assignmentName = rs.getString("ASSIGNMENT_NAME");
                	 date = rs.getString("ASSIGNMENT_DATE");
                	 type = rs.getString("ASSIGNMENT_TYPE");
                	 grade = rs.getInt("GRADE");
                    
                    
                	 student+=
                			 "<tr><td>"+"<a href =" + "\"Details?studentid=" +studentID+"\"" + ">" + studentID +"</a>"+"</td>"
                					 +"<td>"+assignmentName+"</td>"
                					 +"<td>"+"<a href =" + "\"Details?type=" +type+"\"" + ">" + type +"</a>"+"</td>"
                					 +"<td>"+date+"</td>"
                					 +"<td>"+grade+"</td></tr>";
                 }
                 con.close();
                 req.setAttribute("message",student);
         		getServletContext().getRequestDispatcher("/ProfOutput.jsp").forward(req, res);
      
        }
        catch (Exception e){
            e.printStackTrace();
            
            
        }

    }
}