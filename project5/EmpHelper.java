package project5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class EmpHelper extends EmpDetails{
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private ResultSetMetaData resultsetmetadata ;
	private PreparedStatement preparedstatementi ;
	
	public  EmpHelper() {
		// TODO Auto-generated constructor stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb","Shresta","250404");
			statement=connection.createStatement(); 
		  String sqli="INSERT INTO empmasttb values(?,?,?,?,?)";
		 preparedstatementi=connection.prepareStatement(sqli);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error in Connecting to database operation "+e.toString());
			System.exit(0);
		}
	}

	public void addToTable(EmpData emp) {
		// TODO Auto-generated method stub
		try{
			String sql="INSERT INTO empmasttb values("+emp.getdnum()+","+"'"+emp.getdname()+"'"+","+"'"+emp.getddept()+"'"+","+"'"+emp.getdkyc()+"'"+","+"'"+emp.getdlang()+"'"+")";
			long lg=statement.executeUpdate(sql);
			if(lg>0)
				JOptionPane.showMessageDialog(null,"Successful Operation");
			else
				JOptionPane.showMessageDialog(null,"Unsuccessful Operation");
			//INSERT INTO empmasttb values(1005,'Sanya','Sales','PAN','Kannada');
			connection.close();
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error in Adding Data to Table "+e.toString());
		}
		
	}
	public EmpData deleteFromTable(int empno){
		try{
			//String sql="DELETE FROM empmasttb WHERE tno="+empno.getdnum();
			String sql="DELETE FROM empmasttb WHERE tno="+empno;
			long lg=statement.executeUpdate(sql);
			if(lg>0)
				JOptionPane.showMessageDialog(null,"Successful Operation");
			else
				JOptionPane.showMessageDialog(null,"Unsuccessful Operation");
			connection.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error in Deleting Data from Table "+e.toString());
		}
		return null;
	}
	public void UpdateName(EmpData emp){
		try{
			//validateName();
			String sql="UPDATE empmasttb SET tname='"+emp.getdname()+"'    where tno="+emp.getdnum();
			long lg=statement.executeUpdate(sql);
			if(lg>0)
				JOptionPane.showMessageDialog(null,"Successful Operation");
			else
				JOptionPane.showMessageDialog(null,"Unsuccessful Operation");
			connection.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error in Updating name from Table "+e.toString());
		}
	}

	public EmpData findDataInTable(int empno) {
		// TODO Auto-generated method stub
		EmpData obj=new EmpData();
		try{
			String sql="SELECT *FROM empmasttb WHERE tno="+empno;
			resultset=statement.executeQuery(sql);
			if(resultset.first()){
				obj.setdnum(resultset.getInt(1));
				obj.setdname(resultset.getString(2));
				obj.setddept(resultset.getString(3));
				obj.setdkyc(resultset.getString(4));
				obj.setdlang(resultset.getString(5));
			 //JOptionPane.showMessageDialog(null,"Record Found");
			}
			else{
				obj.setdnum(empno);
				obj.setdname("RECORD");
				obj.setddept("NOT");
				obj.setdkyc("FOUND");
				obj.setdlang("SORRY");
				//JOptionPane.showMessageDialog(null,"Record NOT Found");
			}
		}
		catch(Exception e)
		{
			obj.setdnum(empno);
			obj.setdname("ERROR:RECORD");
			obj.setddept("NOT");
			obj.setdkyc("FOUND");
			obj.setdlang(""+e.toString());
		}
		return obj;
	}

	public List<EmpData> displayAllFromTable() {
		// TODO Auto-generated method stub
		List<EmpData>lstd=new ArrayList<EmpData>();
		try{
			String sql="SELECT *FROM empmasttb";
			resultset=statement.executeQuery(sql);
			if(resultset.next())
			{
				do{
			
				EmpData d=new EmpData();
				d.setdnum(resultset.getInt(1));
				d.setdname(resultset.getString(2));
				d.setddept(resultset.getString(3));
				d.setdkyc(resultset.getString(4));
				d.setdlang(resultset.getString(5));
				//or we could use parameterized constructor
				//EmpData d=new EmpData(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getString(5));
				lstd.add(d);
				}while(resultset.next());
			}
			else
			{
				EmpData d=new EmpData(0,"NO DATA","IN","THE","TABLE");
				lstd.add(d);
			}
			
				
			
		}
		catch(Exception e){
			EmpData d=new EmpData(0," ERROR IN DISPLAYING DATA","IN","THE","TABLE" +e.toString());
			lstd.add(d);
		}
	
		return lstd;
	}

	public List<String> displayTableFields() {
		// TODO Auto-generated method stub
	   List<String>lst=new ArrayList<String>();
		try{
		    String sql="SELECT * FROM empmasttb";
			resultset=statement.executeQuery(sql);
			resultsetmetadata=resultset.getMetaData();
			for(int i=1;i<=resultsetmetadata.getColumnCount();i++)
			{
				lst.add(resultsetmetadata.getColumnLabel(i));
				
			}
			connection.close();
		}
		catch(Exception e)
		{
			lst.add(" ERROR IN DISPLAYING field "+e.toString());	
			}
		return lst;
	}

	public void addDataToTableWithPrep(EmpData emp) {
		// TODO Auto-generated method stub
		try{
			preparedstatementi.setInt(1,emp.getdnum());
			preparedstatementi.setString(2,emp.getdname());
			preparedstatementi.setString(3,emp.getddept());
			preparedstatementi.setString(4,emp.getdkyc());
			preparedstatementi.setString(5,emp.getdlang());
			
					long lg=preparedstatementi.executeUpdate();
			if(lg>0)
				JOptionPane.showMessageDialog(null,"Successful Operation");
			else
				JOptionPane.showMessageDialog(null,"Unsuccessful Operation");
			
			connection.close();//create one more button called close to erase the memory
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error in Adding Data With Prepared Statements to Table "+e.toString());

		}
		
	}

	public void Close() {
		// TODO Auto-generated method stub
		try{
			connection.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Error in Closing "+e.toString());

		}
	}

	

}

