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
 
@WebServlet("/TypeStudent")
public class TypeStudent extends HttpServlet  
{
	static String wAverage,average,avg2,studentID,assignmentName, date, type,student="";
	private static final long serialVersionUID = 1L;
	static Double avg = 0.0;
	static Integer count = 0;
	static Integer grade = 0;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		 getServletContext().getRequestDispatcher("/TypeS.jsp").forward(req, res);
		
		}
	
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	 String studentID = req.getParameter("sid");
    	// String assignmentName = req.getParameter("an");
    //	 String date = req.getParameter("dt");
    	 String type = req.getParameter("type");
    //	 int grade = req.getParameter("grd");
    	 
    	 
    	 try
         {
 			
              Class.forName("oracle.jdbc.driver.OracleDriver");
              Connection con=DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost","testdb","password");
              Statement st=con.createStatement();
              System.out.println("connection established successfully...!!");
              ResultSet rs=st.executeQuery("select * from gradebook where ASSIGNMENT_TYPE = '"+type+"' and STUDENT_ID = "+studentID+"");
             
              student+= "<table border=1>";
              student+= "<tr><th>Student ID</th>"
              		+ "<th>Assignment Name</th>"
              		+ "<th>Type</th>"
              		+ "<th>Date</th>"
              		+ "<th>Grade</th>"
              		+ "</tr>";
              
              average= "<table border=2>";
              average= "<tr><th>Average</th><th>Average Grade</th></tr>";
              
                  while(rs.next())
                  {
                 	 studentID = rs.getString("STUDENT_ID");
                 	 assignmentName = rs.getString("ASSIGNMENT_NAME");
                 	 date = rs.getString("ASSIGNMENT_DATE");
                 	 type = rs.getString("ASSIGNMENT_TYPE");
                 	 grade = rs.getInt("GRADE");
                 	 
                 	String grs = grade.toString();
                 	avg += grade;
                    count++;
                    avg2 = Double.toString(avg/count);
                    wAverage = "Average";
                     
                     
                 	 student+="<tr><td>"+studentID
                     		+"</td><td>"+assignmentName
                     		+"</td><td>"+type
                     		+"</td><td>"+date
                     		+"</td><td>"+grs
                     		+"</td></tr>";
                 	 
                 	average= "<tr><td>" +wAverage+"</td><td>"+avg2+"</td></tr>";
                  }
                  con.close();
       
         }
         catch (Exception e){
             e.printStackTrace();
         }
    	 req.setAttribute("message",student);
    	 req.setAttribute("message2",average);
 		getServletContext().getRequestDispatcher("/ProfOutput.jsp").forward(req, res);
    }
}