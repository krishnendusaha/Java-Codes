/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class customer {
    private String  cn;
   private String  Address;
   private String  Driving_Licence_No;
   private String   Tel_No; 
   private long purchase_value=0;
   public customer()
   {
      String  cn=null;
      String  Address=null;
      String  Driving_Licence_No=null;
      String   Tel_No=null; 
      long purchase_value=0;
   }

   public void set_cn(String s)
   {
       cn=s;
   }
     public String get_cn()
   {
       return cn;
   }
   public void set_Driving_Licence_No(String s)
   {
       Driving_Licence_No=s;
   }
   public void set_Address(String s)
   {
       Address=s;
   }
    public void set_Tel_No(String l)
   {
       Tel_No=l;
   }
   
   public void reset_data()
   {
       Address="";
       Driving_Licence_No="";
       Tel_No="";
       purchase_value=0;
   }
   public void update_purchase_value(int n)
   {
       purchase_value+=n;
   }
   public long get_purchase_value()
   {
       return purchase_value;
   }
    public String get_Driving_Licence_No()
   {
      return Driving_Licence_No;
   }
   public String get_Address()
   {
       return Address;
   }
    public String get_Tel_No()
   {
       return Tel_No;
   }
    public void resetpurchasevalue()
    {
        purchase_value=0;
    }     
   
}