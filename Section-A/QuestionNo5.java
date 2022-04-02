import java.util.*;  
class QuestionNo5{

    public static void main(String []args){
       /To using Scanner class we can get input in runtime  
        Scanner sc= new Scanner(System.in);   
        System.out.print("Enter the string : ");  
	//To nextLine() method can get String input in runtime
        String string = sc.nextLine(); 
        
            //To toCharArray() method we can spite the given string into a array of characters 
         char[] charArray = string.toCharArray();
         int arraySize = charArray.length;
         int[] hashCodes = new int[arraySize];

		//this for loop is using for find out hash keys for given characters
         for(int i = 0; i < arraySize; i++){
             Character  temp = charArray[i];
              hashCodes[i] = temp.hashCode();

         }
         
         int spliteSize = arraySize/2;
       // x and y arrays are used for compare the difference in respective manner.
         int[] xArray = new int[spliteSize];
         int[] yArray = new int[spliteSize];
         //this loop is user to fill xArray
         for(int j = 0; j < spliteSize; j++){
             
             int x = hashCodes[j+1]-hashCodes[j];
             xArray[j] = x;
       
            }
		 //this loop is user to fill yArray
         for(int k = 0; k < spliteSize; k++){

             int y = hashCodes[arraySize-(k+2)]-hashCodes[arraySize-(k+1)];
             yArray[k] = y;
        
            }
   
         Boolean checker = false;
         // this for loop is using find out the result is equal or not
         for(int a = 0; a < spliteSize; a++){
             
             if(xArray[a]%yArray[a] == 0 ){
                  checker = true;
           
             }else{
              
                  System.out.print("Unequal difference.");
                  return;
             }
             
        
         }
         
         if(checker){
              System.out.print("Equal difference.");
         }
        
         
     }
}
