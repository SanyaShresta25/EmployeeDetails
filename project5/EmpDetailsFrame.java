package project5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


@SuppressWarnings("serial")
public class EmpDetailsFrame 
                         implements ActionListener
{   JFrame jf;
    private JLabel l1,lnum,lname,ldept,lkyc,llang,lastl;
    private JTextField tnum,tname;
    private JList list1;
    private JRadioButton rb1,rb2,rb3,rb4;
    private ButtonGroup bg;
    private JCheckBox cb1,cb2,cb3,cb4,cb5;
    private JButton b1,b2;
    private JTextArea ta;
    private String[] arrdept={"Sales","Accounts","Software DEV","HR","Testing Dept","Project Manager","Senior Manager"};
    //data declaration
    private int empno;
    private String empname,empdept,empkyc,emplang;
    public EmpDetailsFrame()
    
    {   
    	jf=new JFrame();
    	JPanel p0,p1,p2,p3,p4,p5,plast,pmain;
         jf.setLayout(new FlowLayout());
    	//panel 0
         p0=new JPanel();
         l1=new JLabel("Google California");
         p0.add(l1);
         //jf.add(p0);
         
         
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
       //jf.add(p1);
       
       
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
       //jf.add(p2);
       
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
       //jf.add(p3);
       
       
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
       //jf.add(p4);
       
       //panel 5
       p5=new JPanel();
       p5.setLayout (new GridLayout(1,3));
       b1=new JButton("OK");
       ta=new JTextArea(10,80);
       b2=new JButton("CLEAR");
       p5.add(b1);
       b1.addActionListener(this);
       p5.add(ta);
       p5.add(b2);
       b2.addActionListener(this);
      // jf.add(p5);
       
       
       //last panel
       plast=new JPanel();
       //plast.setLayout (new GridLayout(1,3));
       lastl=new JLabel("Copyrights reserved"); 
       plast.add(lastl);
       //jf.add(plast);
       
       //FrameLayout
      	jf.setLayout(new BorderLayout());
       jf.add(p0,BorderLayout.NORTH);
       pmain=new JPanel();
       pmain.setLayout (new GridLayout(5,1));
       pmain.add(p1);
       pmain.add(p2);
       pmain.add(p3);
       pmain.add(p4);
       pmain.add(p5);
       jf.add(pmain,BorderLayout.CENTER);
       jf.add(plast,BorderLayout.SOUTH);
       
       
       jf.setTitle("EMPLOYEE DETAILS");
       jf.setSize(600,400);
       jf.setVisible(true);//important
       ta.setEditable(false);
       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    
 		
       
    	
    }
    public static void main(String[] args) {
    	EmpDetailsFrame e=new EmpDetailsFrame();
    }

	


@Override
       public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==b1)
		doOk();
	
	if(e.getSource()==b2)
		doclear();
	
}
private void doOk() {
	// TODO Auto-generated method stub
	boolean flag=validateNo();
	if (flag==true)
		flag=validateName();
	if(flag)
	{
		getDept();
		getKYC();
		getLanguage();
		ta.append("Employee Number:   "+empno+"\n");
		ta.append("Employee Name:  "+empname+"\n");
		ta.append("Employee Department:  "+empdept+"\n");
		ta.append("Employee KYC : "+empkyc+"\n");
		ta.append("Languages known to Employee:  "+emplang+"\n");
		
	}
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
private boolean validateName() {
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
	//cb1.setVisible(false);
	cb1.setSelected(false);
	cb2.setSelected(true);
	cb3.setSelected(false);
	cb4.setSelected(false);
	cb5.setSelected(false);
	
	tnum.setText("");
	ta.setText("");
} 
}

