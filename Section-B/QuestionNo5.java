import java.util.*;
public class QuestionNo5{


    private static int[][] tempPits = null;
     
     private static int tempRows = 0;
     private static int tempColumns = 0;



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
        tempRows = rows;
        tempColumns =columns;
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


       System.out.print("Enter number of pits: ");
        int pitsSize = sc.nextInt();
        System.out.println();
        
        int[][] pits = new int[pitsSize][2];
        
      
        for(int h=0; h < pitsSize; h++){
            System.out.print("Position of pit "+(h+1)+" : ");
             pits[h][0] = sc.nextInt();
             pits[h][1] = sc.nextInt();
              
        }
        

        tempPits = pits;
        

        int totleSteps = 0;


        int[] adventurer_j_result = calculateSteps(adventurer_j, gold_j, gold_i, adventurer_i, "i");

        if(adventurer_j_result[0] == 1){
             System.out.println("No possible solution");
            return;
        } else if(adventurer_j_result[0] == 2){
            
            
             System.out.println("Minimum number of steps: "+ (totleSteps+adventurer_j_result[2] ));
            return;
        }
        totleSteps = adventurer_j_result[2];
        adventurer_i = adventurer_j_result[1];
        adventurer_j = adventurer_j_result[3];
        
        int[] adventurer_i_result = calculateSteps(adventurer_i, gold_i, gold_j, adventurer_j, "j");
        
         if(adventurer_i_result[0] == 1){
             System.out.println("No possible solution");
            return;
         }

        totleSteps = totleSteps + adventurer_i_result[2];
        
        System.out.println("Minimum number of steps: "+ totleSteps);
            
             
    }
    
    //this methos is used to check steps points(i, j) is equal to pits's points
    private static boolean pitsCheck(int pair, int idlePoint, String idleType){
  
                int i = 0, j= 0;
                if(idleType.equals("i")){
                    i = idlePoint;
                    j = pair;
                }else{
                   j = idlePoint;
                   i = pair;
                }  
             
                    boolean value = false;
                for(int b = 0; b< tempPits.length; b++){



                    if( i<=0 || j<=0 || i>tempRows || j>tempColumns || (tempPits[b][0]==i &&  tempPits[b][1]==j)){
                        
                       System.out.println();
                        return true;

                    }

                }
                

        return value;
    }
    


   //this method is used to find out the total number of steps to reach the gold.
    static int[] calculateSteps(int Start, int end, int idleGold, int idlePoint, String idleType){
       
       int count = 0;
       int firstMove = 0;
       int secondMove = 0;
       int[] values = new int[4];
       
       if(idlePoint < idleGold){
           firstMove = 1;
       }else  if(idlePoint > idleGold){
           firstMove = -1;
           
       }
       
       if(firstMove == 1){
           secondMove = -1;
       }else{
           secondMove = 1;
           
       }
       
       int resultIdlePoint = idlePoint;
       int currentpoint = Start;       
       
          if(Start < end){
            
             for(int a = Start+1; a <= end; a++){
                 

                 boolean result = false;

                   result = pitsCheck(a, resultIdlePoint, idleType );
                   
                   if(result){
                       result = pitsCheck(a-1, resultIdlePoint + firstMove, idleType );
                       
                       if(result){
                       result = pitsCheck(a-1, resultIdlePoint + secondMove, idleType );
                       resultIdlePoint = resultIdlePoint + secondMove;
                       a--;
                       }else{
                           resultIdlePoint = resultIdlePoint + firstMove;
                           a--;
                       }
                       
                       
                   }

                   
                   if(result){
                       values[0] = 1;
                      return values;
                   }
            
 		
               currentpoint = a;

                count++;

            
             }
         
        }else if(Start > end){
             
             for(int a = Start-1; a >= end; a--){
                 



                  
                         boolean result = false;
                 
              
                   result = pitsCheck(a, resultIdlePoint, idleType );
                   
                   if(result){
                       result = pitsCheck(a+1, resultIdlePoint + firstMove, idleType );
                       
                       if(result){
                       result = pitsCheck(a+1, resultIdlePoint + secondMove, idleType );
                       resultIdlePoint = resultIdlePoint + secondMove;
                       a++;
                       }else{
                           resultIdlePoint = resultIdlePoint + firstMove;
                           a++;
                       }
                       
                       
                   }
                   
                   if(result){
                      values[0] = 1;
                      return values;
                   }
            
		

                  currentpoint = a;
            
                count++;

             }
         
        }
        
        
        values[0] = 0;
        values[1] = resultIdlePoint;
        values[2] = count;
	  values[3] = currentpoint ;
        return values;
       
   }
   
   
   // this method is used to avoid taking invalied inputs
   static int[] repeaterPosition(int rows, int columns, String info){
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
    static int[] repeaterDimensions(String info){
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
 
}
