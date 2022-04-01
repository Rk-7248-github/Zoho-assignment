import java.util.*;

public class Pattern{
    
     public static void main(String []args){
	//To using Scanner class we can get input
      Scanner sc= new Scanner(System.in);
	System.out.print("Enter the number :");  
	//To nextInt() method can get integer input
        int value = sc.nextInt();
	//rows repersent how many line we need to print
         int rows= (value *2)-1;
        
         
       for (int i = 1; i <= rows; i++)   {  

	//inner for loop
        for (int j = 1; j <= rows; j++)   { 
            
            
            printOutput(rows, i, j, value);

        } 

	//strat to print next line
        System.out.println();  
    }  

     }
     
          static void printOutput(int rows, int i , int j, int value){
         
	//temp variable is use to decrease the value to print as respected time
         int temp = 0;
         while(temp < value ){
             
             if(i == temp+1 || i == rows-temp || j== temp+1 || j== rows-temp ){
                 System.out.print(value-temp); 
                 return;
             }
             temp++;
             
         }
         
     }
     
   
}