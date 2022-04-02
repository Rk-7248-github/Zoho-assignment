import java.util.*;  
class QuestionNo3{


    public static void main(String []args){
         //To using Scanner class we can get input at runtime      
        Scanner sc= new Scanner(System.in);   
        System.out.print("Enter the number of string to be entered- ");  
        int stringsCount = sc.nextInt(); 
        
        String[] stringsArray = new String[stringsCount];
        
        sc.nextLine(); 
	 //for loop is used to get characters input at runtime 
        for(int h =0; h < stringsCount; h++){
            System.out.print("Enter the string "+(h+1)+" "); 
            stringsArray[h] = sc.nextLine();

        }
         
      
        
        for(int a =0; a < stringsCount; a++){
            
         char[] charArray = stringsArray[a].toCharArray();
         int[] hashCodes = new int[charArray.length];

          // this loop is used to get hash keys of respective characters
         for(int i = 0; i < charArray.length; i++){
             Character  temp = charArray[i];
              hashCodes[i] = temp.hashCode();
              
             
         }
         // this loop is used to sorting the given characters
         for(int j = 0; j < hashCodes.length; j++){
             
            for(int k = j+1; k < hashCodes.length; k++){
             
             if(hashCodes[j] < hashCodes[k]){
                 int tempcode = hashCodes[j];
                 char tempString = charArray[j];
                 hashCodes[j] = hashCodes[k];
                 charArray[j] = charArray[k];
                 hashCodes[k] = tempcode;
                 charArray[k] = tempString;
                
             }
             
            }

         }
          System.out.print("String"+(a+1)+" : ");
         System.out.print(charArray);
		//strat to print next line
         System.out.println();
         
        }
         
     }
}
