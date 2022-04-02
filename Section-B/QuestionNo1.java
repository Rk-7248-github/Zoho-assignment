import java.util.*;  
public class QuestionNo1{

// this method is used to calculating the totle steps adventurer moving to reach gold.

  private static int calculateSteps(int Start, int end){
       
       int count = 0;
       
          if(Start < end){
            
             for(int a = Start+1; a <= end; a++){
         
            count++;
             }
         
        }else if(Start > end){
             
             for(int a = Start-1; a >= end; a--){
            
              count++;
             }
         
        }
        
        return count;
       
   }
   
// this method is used to avoid taking invalied inputs
   private static int[] repeaterPosition(int rows, int columns, String info){
       Scanner sc= new Scanner(System.in); 
       System.out.print(info);
       int i = sc.nextInt();
       int j = sc.nextInt();
       
        if(i > rows || j > columns || rows < 1|| columns < 1){
          int[] temp = repeaterPosition(rows, columns,info);
          i = temp[0];
          j = temp[1];
        }
       
       int[] values = {i,j};
       return values;
   }

   // this method is used to avoid taking invalied inputs
    private static int[] repeaterDimensions(String info){
       Scanner sc= new Scanner(System.in); 
       System.out.print(info);
       int i = sc.nextInt();
       int j = sc.nextInt();
       
        if(i < 1 || j < 1 ){
          int[] temp = repeaterDimensions(info);
          i = temp[0];
          j = temp[1];
        }
       
       int[] values = {i,j};
       return values;
   }


     public static void main(String []args){
         
        Scanner sc= new Scanner(System.in); 
        System.out.print("Dimensions of the dungeon(Row x Column): ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        
	//this if condition to check the given input is valied
        if( rows < 1||  columns < 1){
        
          int[] temp = repeaterDimensions("Enter correct Dimensions of the dungeon(Row x Column): ");
          rows = temp[0];
          columns = temp[1];
        }
        System.out.println();
        System.out.print("Position of adventurer: ");
        int adventurer_i = sc.nextInt();
        int adventurer_j = sc.nextInt();

	//this if condition to check the given input is valied
        if(adventurer_i > rows || adventurer_j > columns || adventurer_i < 1||  adventurer_j < 1){
        
          int[] temp = repeaterPosition(rows, columns,"Enter correct position of adventurer: ");
          adventurer_i = temp[0];
          adventurer_j = temp[1];
        }
        
        System.out.print("Position of gold: ");
        int gold_i = sc.nextInt();
        int gold_j = sc.nextInt();

	//this if condition to check the given input is valied
        if(gold_i > rows || gold_j > columns || gold_i < 1||  gold_j < 1){
        
          int[] temp = repeaterPosition(rows, columns,"Enter correct position of gold: ");
          gold_i = temp[0];
          gold_j = temp[1];
        }


        int adventurer_j_counts = calculateSteps(adventurer_j, gold_j);
        int adventurer_i_counts = calculateSteps(adventurer_i, gold_i);

        int totleSteps = adventurer_j_counts + adventurer_i_counts;


       System.out.print("Minimum number of steps:"+totleSteps);
        
     }
}
