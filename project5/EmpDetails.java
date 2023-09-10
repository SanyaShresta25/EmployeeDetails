package project5;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import project1.WelcomeGUISwing;


@SuppressWarnings("serial")
public class EmpDetails extends JFrame
                         implements ActionListener
{   private JLabel l1,lnum,lname,ldept,lkyc,llang,lastl;
    private JTextField tnum,tname;
    private JList list1;
    private JRadioButton rb1,rb2,rb3,rb4;
    private ButtonGroup bg;
    private JCheckBox cb1,cb2,cb3,cb4,cb5;
    private JButton b1,b2,btnadd,btnupdate,btndelete,btndisplay,btnfind,btnaddwprep,btndispfields,btnwelcome,btnclose;
    private JTextArea ta;
    private String[] arrdept={"Sales","Accounts","Software DEV","HR","Testing Dept","Project Manager","Senior Manager"};
    //data declaration
    public int empno;
    private String empname,empdept,empkyc,emplang;
    @SuppressWarnings("unchecked")
	public EmpDetails()
    
    {   
    	
    	JPanel p0,p1,p2,p3,p4,p5,plast,pmain,psql;
         setLayout(new BorderLayout());
    	//panel 0
         p0=new JPanel();
         l1=new JLabel("Google California");
         p0.add(l1);
         //add(p0);
         
         
       //panel 1
       p1=new JPanel();
       p1.setLayout (new GridLayout(2,2,2,2));
       lnum=new JLabel("Employee Number");
       lname=new JLabel("Employee Name");
       tnum=new JTextField(12);
       tname=new JTextField(50);
       p1.add(lnum);
       p1.add(tnum);
       p1.add(lname);
       p1.add(tname);
       //add(p1);
       
       
       //panel 2
       p2=new JPanel();
       p2.setLayout (new GridLayout(1,2,4,4));
       ldept=new JLabel("Employee Department");
       list1=new JList(arrdept);
       list1.setSelectedIndex(0);
       //p2.add(ldept);
       p2.add(new JScrollPane (ldept));
       //p2.add(list1);
       p2.add(new JScrollPane (list1));
       //add(p2);
       
       //panel 3
       p3=new JPanel();
       p3.setLayout (new GridLayout(1,5));
       lkyc=new JLabel("KYC");
       rb1=new JRadioButton("PAN");
       rb2=new JRadioButton("Adhaar");
       rb3=new JRadioButton("Passport");
       rb4=new JRadioButton("Drivers License",true);
       
       bg=new ButtonGroup();
       bg.add(rb1);
       bg.add(rb2);
       bg.add(rb3);
       bg.add(rb4);
       
       p3.add(lkyc);
       p3.add(rb1);
       p3.add(rb2);
       p3.add(rb3);
       p3.add(rb4);
       //add(p3);
       
       
       //panel 4
        p4=new JPanel();
        p4.setLayout (new GridLayout(1,6));
       llang=new JLabel("Languages known");
       cb1=new JCheckBox("Kannada");
       cb2=new JCheckBox("English",true);
       cb3=new JCheckBox("Hindi");
       cb4=new JCheckBox("French");
       cb5=new JCheckBox("German");
       p4.add(llang);
       p4.add(cb1);
       p4.add(cb2);
       p4.add(cb3);
       p4.add(cb4);
       p4.add(cb5);
       //add(p4);
       
       //panel 5
       p5=new JPanel();
       p5.setLayout (new GridLayout(1,3));
       b1=new JButton("OK");
       ta=new JTextArea(10,80);
       b2=new JButton("CLEAR");
       p5.add(b1);
       b1.addActionListener(this);
       p5.add(ta);
       p5.add(new JScrollPane (ta));

       p5.add(b2);
       b2.addActionListener(this);
      


       //add(p5);
       
       //panel sql
       psql=new JPanel();
       psql.setLayout (new GridLayout(3,3,8,6));
       
       btnadd=new JButton("ADD");
       btnupdate=new JButton("UPDATE NAME");
       btndelete=new JButton("DELETE");
       btndisplay=new JButton("DISPLAY ALL");
       btnfind=new JButton("FIND");
       btnaddwprep=new JButton("ADD WITH PREP");
       btndispfields=new JButton("DISPLAY FIELD NAMES");
       btnwelcome=new JButton("WELCOME");
      btnclose=new JButton("CLOSE");
      
       psql.add(btnadd);
       btnadd.addActionListener(this);
       psql.add(btnupdate);
       btnupdate.addActionListener(this);
       psql.add(btndelete);
       btndelete.addActionListener(this);
       psql.add(btndisplay);
       btndisplay.addActionListener(this);
       psql.add(btnfind);
       btnfind.addActionListener(this);
       psql.add(btnaddwprep);
       btnaddwprep.addActionListener(this);
       psql.add(btndispfields);
       btndispfields.addActionListener(this);
       psql.add(btnwelcome);
       btnwelcome.addActionListener(this);
       psql.add(btnclose);
       btnclose.addActionListener(this);
       

       
       
       //last panel
       plast=new JPanel();
       //plast.setLayout (new GridLayout(1,3));
       lastl=new JLabel("Copyrights reserved"); 
       plast.add(lastl);
       //add(plast);
       
       //FrameLayout
      	setLayout(new BorderLayout());
       add(p0,BorderLayout.NORTH);
       pmain=new JPanel();
       pmain.setLayout (new GridLayout(6,1,10,10));
       pmain.add(p1);
       pmain.add(p2);
       pmain.add(p3);
       pmain.add(p4);
       pmain.add(p5);
       pmain.add(psql);
       add(pmain,BorderLayout.CENTER);
       add(plast,BorderLayout.SOUTH);
       
       
       setTitle("EMPLOYEE DETAILS");
       setSize(600,400);
       setVisible(true);//important
       ta.setEditable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    
 		
       
    	
    }
    public static void main(String[] args) {
    	EmpDetails e=new EmpDetails();
    }

	


@Override
       public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b1)
		doOk();
	if(e.getSource()==b2)
		doclear();
	
	if(e.getSource()==btnadd)
		doAdd();
	if(e.getSource()==btnupdate)
		doUpdate();
	if(e.getSource()==btndelete)
		doDelete();
	if(e.getSource()==btndisplay)
		doDisplay();
	if(e.getSource()==btnfind)
		doFind();
	if(e.getSource()==btnaddwprep)
		doAddwprep();
	if(e.getSource()==btndispfields)
		doDispfields();
	if(e.getSource()==btnwelcome)
		doWelcome();
	if(e.getSource()==btnclose)
		doClose();
	
}
private void doClose() {
	// TODO Auto-generated method stub
	try{ 
		EmpHelper help=new EmpHelper();
		help.Close();
		
		}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in Closing GUI "+e.toString());
	}
}
private void doWelcome() {
	// TODO Auto-generated method stub
	WelcomeGUISwing w=new WelcomeGUISwing();
	
}
private void doDispfields() {
	// TODO Auto-generated method stub
	try{
		EmpHelper help=new EmpHelper();
		List<String>lsts=help.displayTableFields();
		String s="";
		for(String str:lsts)
			s=s+str+"\n";
		JOptionPane.showMessageDialog(null,s);
		}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,"Error in Displaying Field Names "+e.toString());
	}
	
}
private void doAddwprep() {
	// TODO Auto-generated method stub
	try{
		boolean flag=collectdata();
		if(flag)
		{
		 EmpData emp=new EmpData();
		 emp.setdnum(empno);
	  	    emp.setdname(empname);
	  	    emp.setddept(empdept);
	  	    emp.setdkyc(empkyc);;
	  	    emp.setdlang(emplang);
	  	  EmpHelper help=new EmpHelper();
		 help.addDataToTableWithPrep(emp);
		}
				
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in Adding (prepared statements GUI "+e.toString());
	}
	
}
private void doFind() {
	// TODO Auto-generated method stub
	try{
		boolean flag=validateNo();
		if(flag)
		{
			EmpHelper help=new EmpHelper();
	  	    EmpData a =help.findDataInTable(empno);
	  	    String s="Employee Number:"+a.getdnum()+"\n";
	  	  s=s+"Employee Name:"+a.getdname()+"\n";
	  	s=s+"Employee Department:"+a.getddept()+"\n";
	  	s=s+"Employee KYC:"+a.getdkyc()+"\n";
	  	s=s+"Employee Language:"+a.getdlang()+"\n";
	  	JOptionPane.showMessageDialog(null,s);
		}
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in Finding Data "+e.toString());
	}
	
}
private void doDisplay() {
	// TODO Auto-generated method stub
	try{
	//boolean flag=validateNo();
	//if(flag)
	
		EmpHelper help=new EmpHelper();
		String s="";
		 List<EmpData> obj =help.displayAllFromTable();
		 s="EMPNO    "+"NAME          "+"DEPT    "+"KYC   "+"LANGUAGE   "+"\n";
		 for(EmpData d:obj)
			
		 s=s+d.getdnum()+"  "+d.getdname()+"   "+d.getddept()+"  "+d.getdkyc()+"  "+d.getdlang()+"\n";
		 
	  	JOptionPane.showMessageDialog(null,s);
  	    
	
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in Displaying Data "+e.toString());
	}
	
}
private int doDelete() {
	// TODO Auto-generated method stub
	try{
		//collectdata();
	
		boolean flag=validateNo();
		if (flag)
		//EmpData emp=new EmpData();
		{
			EmpHelper help=new EmpHelper();
			 EmpData d =help.deleteFromTable(empno);
		}
			EmpData emp=new EmpData();
  	    emp.setdnum(empno);
  	   
  	    
	  	    
		
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in Deleting GUI "+e.toString());
	}
return 0;
	
}
private void doUpdate() {
	// TODO Auto-generated method stub
	try{
		validateNo();
		validateName();
		EmpData emp=new EmpData();
		emp.setdnum(empno);
  	    emp.setdname(empname);
  	  EmpHelper help=new EmpHelper();
	    help.UpdateName(emp);
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,"Error in Updating GUI "+e.toString());
	}
	
}
private void doAdd() {
	// TODO Auto-generated method stub
	try{
		collectdata();
		
		EmpData emp=new EmpData();
  	    emp.setdnum(empno);
  	    emp.setdname(empname);
  	    emp.setddept(empdept);
  	    emp.setdkyc(empkyc);;
  	    emp.setdlang(emplang);
  	        //or EmpData emp=new EmpData(empno,empname,empdept,empkyc,emplang);
  	    EmpHelper help=new EmpHelper();
  	    help.addToTable(emp);
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in Adding GUI "+e.toString());
	}

}
public void doOk() {
	// TODO Auto-generated method stub
	    collectdata();
		ta.append("Employee Number:   "+empno+"\n");
		ta.append("Employee Name:  "+empname+"\n");
		ta.append("Employee Department:  "+empdept+"\n");
		ta.append("Employee KYC : "+empkyc+"\n");
		ta.append("Languages known to Employee:  "+emplang+"\n");
		
	
}
private boolean collectdata()
{
	boolean flag=false;
	boolean ok=validateNo();
	if (ok==true)
		ok=validateName();
	if(ok)
	{
		getDept();
		getKYC();
		getLanguage();
		flag=true;
	}
	return flag;
}
private void getLanguage() {
	// TODO Auto-generated method stub
	 emplang="";
	if(cb1.isSelected())
		emplang=cb1.getText();
	if(cb2.isSelected())
		emplang=emplang+" "+cb2.getText();
	if(cb3.isSelected())
		emplang=emplang+" "+cb3.getText();
	if(cb4.isSelected())
		emplang=emplang+" "+cb4.getText();
	if(cb5.isSelected())
		emplang=emplang+" "+cb5.getText();
	
}
private void getKYC() {
	// TODO Auto-generated method stub
	empkyc="";
	if(rb1.isSelected())
		empkyc=rb1.getText();
	else if(rb2.isSelected())
		empkyc=rb2.getText();
	else if(rb3.isSelected())
		empkyc=rb3.getText();
	else
		empkyc=rb4.getText();
	
}
private void getDept() {
	// TODO Auto-generated method stub
	empdept=arrdept[list1.getSelectedIndex()];
	
	
}
protected boolean validateName() {
	// TODO Auto-generated method stub
	
	boolean flag=false;
	try{
		empname=tname.getText();
		if(empname.length()>3)
		{
			NameValidation nv=new NameValidation(empname);
			flag=nv.validate();
			if(!flag)
			{
				JOptionPane.showMessageDialog(null,"Name contains of no vowels or has numbers");
			}
			
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Name must be of minimum 3 or more characters");
		}
		
		
				
		
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null,"Error in EMPLOYEE NAME "+e.toString());
	}
	
	
	return flag;
	
	
		
}
private boolean validateNo() {
	// TODO Auto-generated method stub
	
	boolean flag=false;
	String s = null;
	
	
	try{
		
		s=tnum.getText();
		empno=Integer.parseInt(s);
	
			if(empno>1 && empno<10000)
			{
				flag=true;
				
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Number not in range");
			}
			
			
		}
	catch(Exception e){
		
		JOptionPane.showMessageDialog(null,"Please enter Employee ID");
	}
	
	return flag;
}
	

private void doclear() {
	// TODO Auto-generated method stub
	tname.setText("");
	cb1.setSelected(false);
	cb2.setSelected(true);
	cb3.setSelected(false);
	cb4.setSelected(false);
	cb5.setSelected(false);
	rb1.setSelected(false);
	rb2.setSelected(false);
	rb3.setSelected(false);
	rb4.setSelected(true);
	tnum.setText("");         
	ta.setText("");
} 
}

