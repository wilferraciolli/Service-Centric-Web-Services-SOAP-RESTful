/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienttotest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Wiliam
 */
public class ClientToTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String dateString = "01/02/2015";
       
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      Date date;
      
      try{
         date = df.parse(dateString);
         String newDateString = df.format(date);
         System.out.println(newDateString);
      }
      catch(Exception e){
          
      }
        
    }    
    
}
