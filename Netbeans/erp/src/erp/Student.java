/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

/**
 *
 * @author user
 */
public class Student {
    private String name;
    private String address;
    private String phoneNo;
    private String password;
    private String rollno;
    private int[] elective=new int[3];
    private String[] grade=new String[7];
    private float sgpa;
    private float cgpa;
     int j=0;
    public void setname(String s)
    {
      name=s;  
    }       
       
   public void setaddress(String s)
    {
      address=s;  
    }       
   public void setphoneno(String s)
    {
      phoneNo=s;  
    }   
   
   public void setpassword(String s)
    {
      password=s;  
    }
    public void setrollno(String s)
    {
      rollno=s;  
    }
   public void setelective(char[] s)
    {
        int j=0;
     for(j=0;j<3;j++)
     {
        elective[j]=s[j]; 
     }   
    }  
       
     public void setsgpa(float f)
    {
      sgpa=f;  
    }
    public void setgrades(String f)
    {
       
      while(grade[j]!=null)
      {
       j++;   
      } 
      grade[j]=new String();
      grade[j]=f;
   }
     
   
     public String getname()
    {
      return name;  
    }
    public String getaddress()
    {
      return address;  
    }
    public String getphoneno()
    {
      return phoneNo;  
    }
    public String getpassword()
    {
      return password;  
    }
    public String getrollno()
    {
      return rollno;  
    }
   
     public float getsgpa()
    {
      return sgpa;  
    }
     public int[] getelective()
    {
      return elective;  
    }
     public String[] getgrades()
     {
       return grade;  
     }     
  /*   
   private float calculate_sgpa()
   {
      int total_credits=0;
      for(int f=0;f<no_of_subjects;f++)
      {
          
      }
   }*/    
     
       
}
