import java.util.*;

public class QuestionNo1{

     public static void main(String []args){
	//To using Scanner class we can get input in runtime
        Scanner sc= new Scanner(System.in);
	//To using nextLine() method we can get string input in runtime
        String input = sc.nextLine();
       System.out.println("Enter the string :");
        //To using trim() method can avoid unwanted space
	 String temp= input.trim();
	 input = temp;
	//To using toCharArray() method we can split the string
        char[] charInput = input.toCharArray();
        int size = charInput.length;
	// size dividing by 2 we can get printing place of first row
        int startPoint = size/2;
        if(size%2 > 0){
               
          
            for (int i = 0; i < size; i++)   {  
        //inner for loop
                for (int j = 0; j < size; j++)   { 
                    
                    // if conditions are use to print a character on respected plase
                    if( i == 0 || i == size-1){
                         
            
                          if(startPoint == j){
                            System.out.print(charInput[j]);
                            
                            }else{
                                System.out.print("  "); 
                            }
                   
                    }else if(i < size-1 && i > 0){
                        
                    
                    if(i <= startPoint){
                        int leftPoint = startPoint -i;
                        int rightPoint = startPoint +i;
                        
                        
                        if(j == leftPoint || j == rightPoint){
                             System.out.print(charInput[j]);
                        }else{
                             System.out.print("  ");
                        }
                       
                    }else{
                        
                        int leftPoint = i - startPoint ;
                        int rightPoint = (size-1) - (i - startPoint);
                        
                        
                        if(j == leftPoint || j == rightPoint){
                             System.out.print(charInput[j]);
                        }else{
                             System.out.print("  ");
                        }
                        
                    }
                    
                   
                    }
                
                } 
    
        	//strat to print next line
           System.out.println();  
        }  

            
        }else{
            System.out.print("Not Possible");
        }

     }
}
