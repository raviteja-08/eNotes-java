
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NotesDAO {
	
	private Connection con;

	public NotesDAO() {
		super();
	}
	
	//Add Notes 
  	public boolean addNotes(Notes app) {
  		boolean f=false;
  		
  		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","Raviteja@9553");
  			String sql="insert into notes(title,content,emailid) values(?,?,?)";
  			PreparedStatement ps=con.prepareStatement(sql);
  			ps.setString(1, app.getTitle());
  			ps.setString(2, app.getContent()); 
  			ps.setString(3, app.getEmailid().trim());
  			
  			int i=ps.executeUpdate();
  			
  			if(i==1) {
  				f=true;
  			}			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return f;
  	}
  	
  	//View Notes 
  	public List<Notes> getAllNotes(String email) {  		
  		List<Notes> list = new ArrayList<Notes>();
  		Notes b=null;
		
	    try {        
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","Raviteja@9553");
		   String sql="select * from notes where emailid='"+email+"'";
		   PreparedStatement ps = con.prepareStatement(sql);
		   ResultSet rs = ps.executeQuery();
		   
		   while(rs.next()) {
			   
			b=new Notes();
			b.setId(rs.getInt(1));
			b.setTitle(rs.getString(2));
			b.setContent(rs.getString(3));
			b.setEmailid(rs.getString(4));			
			b.setCreationDate(rs.getString(5));
			list.add(b);			
		   }		   
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
  	}
  	
  	// Update Notes
 	public boolean updateNotes(Notes n) {
 		boolean f = false;
 		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","Raviteja@9553");
 			String sql = "update notes set title=?, content=? where id=?";
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setString(1, n.getTitle());
 			ps.setString(2, n.getContent());
 			ps.setInt(3, n.getId());

 			int i = ps.executeUpdate();
 			if (i == 1) {
 				f = true;
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return f;
 	}
 	public boolean deleteNotes(Notes n) {
 		boolean f = false;
 		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","Raviteja@9553");
 			String sql = "DELETE FROM notes WHERE id = ?";
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setInt(1, n.getId());
           
 			int i = ps.executeUpdate();
 			if (i == 1) {
 				f = true;
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return f;
 	}

}
