import java.util.*;
public class QuestionNo4{

  // this method is used to calculating the totle steps adventurer moving to reach gold.
  private static int[] calculateSteps(int adventurer_current, int adventurer, int monster_current, int monster, int gold_current, int gold){
       
        int count = 0;
       
          if(adventurer_current < gold_current){
            
             //this for loop using to move the adventurer either RIGHT or DOWN
             for(int a = adventurer_current+1; a <= gold_current; a++){
                adventurer_current = a;
                count++;
                
                if(adventurer_current == gold_current && adventurer == gold){
                     int[] temp = {1, count};
                      return temp;
                }
                
               //this nested if condition using to move the monster 
                if(monster_current < gold_current){
                    monster_current++;
                     if(monster_current == gold_current && monster == gold){
                        
                        int[] temp = {0};
                        return temp;
                    }
                    
                }else if(monster_current > gold_current){
                    monster_current--;
                     if(monster_current == gold_current && monster == gold){
                        
                        int[] temp = {0};
                        return temp;
                    }
                }else{
                    if(monster_current == gold_current && monster == gold){
                        int[] temp = {0};
                        return temp;
                    }
                    
                }
            
             }
         
        }else if(adventurer_current > gold_current){
             
             //this for loop using to move the adventurer either LEFT or UP
             for(int a = adventurer_current-1; a >= gold_current; a--){
                adventurer_current = a;
                count++;
                
                if(adventurer_current == gold_current && adventurer == gold){
                        int[] temp = {1, count};
                        return temp;
                }
                
               //this nested if condition using to move the monster
                if(monster_current < gold_current){
                    monster_current++;
                     if(monster_current == gold_current && monster == gold){
                        int[] temp = {0};
                        return temp;
                    }
                    
                }else if(monster_current > gold_current){
                    monster_current--;
                     if(monster_current == gold_current && monster == gold){
                        int[] temp = {0};
                        return temp;
                    }
                }else{
                    if(monster_current == gold_current && monster == gold){
                        int[] temp = {0};
                        return temp;
                    }
                    
                }
             }
         
        }
        
        
        int[] temp = {2, count, adventurer_current, monster_current};
        
        return temp;
       
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

        final int ADVENTURE_I = adventurer_i;
         final int ADVENTURE_J = adventurer_j;
         
        
        System.out.print("Position of monster: ");
        int m_i = sc.nextInt();
        int m_j = sc.nextInt();
       
       //this if condition to check the given input is valied
        if(m_i > rows || m_j > columns || m_i < 1||  m_j < 1){
        
          int[] temp = repeaterPosition(rows, columns,"Enter correct position of monster: ");
          m_i = temp[0];
          m_j = temp[1];
        }
        
      
 
         System.out.print("Position of trigger: ");
        int trigger_i = sc.nextInt();
        int trigger_j = sc.nextInt();
       
       //this if condition to check the given input is valied
        if(trigger_i > rows || trigger_j > columns || trigger_i < 1||  trigger_j < 1){
        
          int[] temp = repeaterPosition(rows, columns,"Enter correct position of gold: ");
          trigger_i = temp[0];
          trigger_j = temp[1];
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
         

     

        int totleSteps = 0;
        
        
        int[] iResult = calculateSteps(adventurer_j, adventurer_i, m_j, m_i, gold_j,gold_i);
        
        if(iResult[0] == 0){
            System.out.print("  No possible solution");
            return;
        }else if(iResult[0] == 1){
             totleSteps = iResult[1];
             System.out.println("Minimum number of steps: " +totleSteps );
             return;
            
        }else{
            
            totleSteps = iResult[1];
            adventurer_j = iResult[2];
            m_j = iResult[3];
            
        }
     
        
        int[] jResult = calculateSteps(adventurer_i, adventurer_j, m_i, m_j, gold_i,gold_j);
        
         if(jResult[0] == 1){
             totleSteps = totleSteps+jResult[1];
             System.out.println("Minimum number of steps: " +totleSteps );
           return;
        }
        
        totleSteps = 0;
        int adventurer_j_counts = triggerSteps(ADVENTURE_J, trigger_j);
        int adventurer_i_counts = triggerSteps(ADVENTURE_I, trigger_i);
        int trigger_j_counts = triggerSteps(trigger_j, gold_j);
        int trigger_i_counts = triggerSteps(trigger_i, gold_i);
        
        
         totleSteps = adventurer_j_counts + adventurer_i_counts+trigger_j_counts+trigger_i_counts;
        
        System.out.println("Minimum number of steps: " +totleSteps );
            
             
    }
    
    // this method will call after adventurer trigger the triggers .
   private static int triggerSteps(int Start, int end){
       
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
   
    
    
}
