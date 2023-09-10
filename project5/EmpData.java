package project5;



public class EmpData{
      
	private int dnum;
      private String dname;
      private String ddept;
      private String dkyc;
      private String dlang;
      public EmpData()
      {
    	  dnum=0;
    	  dname="";
    	  ddept="";
    	  dkyc="";
    	  dlang="";
    	  
      }
      public EmpData(int a,String b,String c,String d,String e)
      {
    	  dnum=a;
    	  dname=b;
    	  ddept=c;
    	  dkyc=d;
    	  dlang=e;
      }
      
      public int getdnum() {
    		return dnum;
    	}
      public void setdnum(int a) {
    		this.dnum = a;
    	}
    	
    	public String getdname() {
    		return dname;
    	}
       public void setdname(String b) {
    		this.dname = b;
    	}
       
    	public String getddept() {
    		return ddept;
    	}
       public void setddept(String c) {
    		this.ddept = c;
    	}
       
    	public String getdkyc() {
    		return dkyc;
    	}
       public void setdkyc(String d) {
    		this.dkyc= d;
    	}
       
    	public String getdlang() {
    		return dlang;
    	}
        public void setdlang(String e) {
    		this.dlang = e;
    	}
        
}
