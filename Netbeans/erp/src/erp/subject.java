/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

/**
 *
 * @author user
 */
public class subject {
   private int subno; 
   private String subname;
   private int credits;
   private int type;//1->core 2->elective
   
   public void setsubno(int n)
   {
     subno=n;  
   }
   public void setsubname(String s)
   {
     subname=s;  
   }
   public void setcredits(int n)
   {
     credits=n;  
   }
  public void settype(int n)
   {
     type=n;  
   }
  
   public String getsubname()
   {
     return subname;  
   }
  public int getcredits()
   {
     return credits;  
   }
  public int gettype()
  {
     return type; 
  }
   public int getsubno()
  {
     return subno; 
  }
   
}
