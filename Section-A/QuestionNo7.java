import java.util.*;  
public class QuestionNo7{

     public static void main(String []args){
	//To using Scanner class we can get input at runtime
        Scanner sc= new Scanner(System.in);   
        System.out.print("Enter the string : ");  
	//To nextLine() method can get String input at runtime
        String temp= sc.nextLine();
        
        String[] array = temp.split(" "); 

	// these loops are used for removing duplicated string
          for(int i = 0; i < array.length; i++) {
         
            for(int j=i+1; j < array.length; j++){
                
                if(array[i].equals(array[j])){
               
                    array[j] = "";
                }
                
            } 
             
      
         }
         
         System.out.print("The distinct words are : ");
         
         int j =0;
	// while loop is used for print the output in order with help of array
         while( j < array.length){
             
              System.out.print(array[j]+" ");
             j++;
         }
         
       
     }
}
