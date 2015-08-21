import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/ToDatabase")
public class ToDatabase extends HttpServlet  
{
	static String studentID,assignmentName, date,grade, type="";
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/Input.jsp").forward(req, res);
		
		}
	
    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	 String studentID = req.getParameter("sid");
    	 String assignmentName = req.getParameter("an");
    	 String date = req.getParameter("dt");
    	 String type = req.getParameter("type");
    	 String grade = req.getParameter("grd");
    	 
    	 try
         {
              Class.forName("oracle.jdbc.driver.OracleDriver");
              Connection con=DriverManager.getConnection("jdbc:oracle:thin:testuser/password@localhost","testdb","password");
              Statement st=con.createStatement();
              System.out.println("connection established successfully...!!");
              String sql = "Insert into GRADEBOOK (STUDENT_ID,ASSIGNMENT_NAME,ASSIGNMENT_TYPE,ASSIGNMENT_DATE,GRADE) "
                		+ "values ('"+studentID+"','"+assignmentName+"','"+type+"','"+date+"',"+grade+")";
              System.out.println(sql);
              st.executeQuery (sql);
  
                  con.close();
                  getServletContext().getRequestDispatcher("/FromDatabase").forward(req, res);
         }
         catch (Exception e){
             e.printStackTrace();
         }
    }
}