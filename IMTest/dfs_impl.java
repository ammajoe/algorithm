// 4 X 4 행렬
// 숫자는 3번만 기입

// 기입할 수 있는 숫자의 범위는 1~3
// 3개의 숫자의 합이 5
// 이 때 이걸 만족하는 경우의 수를 구하시오.
// 같은 숫자 조합이더라도 기입한 위치가 다르면 다른 경우로 본다.

// package Algo_study.Test;

public class dfs_impl {
   static int[][] map;
   static int count = 0;
   
   public static void main(String[] args) 
   {
	      map = new int[4][4];
	      // index -> 내가 어디 블록을 지금 채워야 할지 말지 결정하는 곳
	      // 내가 숫자를 기입한 횟수
	      // 그리고 지금까지 기입한 숫자의 합
	      dfs(0, 0, 0);
	      System.out.println(count);

   }
   
   static void dfs(int index, int write, int sum) 
   {
	   
      int r = index / 4;
      int c = index % 4;
      
      if(sum > 15) 
      {
         return;
      }
      
      // 0~ 15 까지는 칸을 채우고 15 -> 16으로 올 때가 종료할 때
      if(index == 16)
      {
         if(write != 11)
         {
            return;
         }
      }
      
      // 0으로 초기화되어있는 상태 
      if(write == 3)
      {
         // index == 10
         // 0~10 까지 모두 숫자를 기입했다. 
         if(sum == 5)
         {
            System.out.println();
            for(int i = 0 ; i < 4; i++)
            {
               for(int j = 0; j < 4; j++)
               {
                  System.out.print(map[i][j] + " ");
               }
               System.out.println();
            }
            count++;
         }
         return;
      }
      // 0으로 초기화된거 다 알아
      // 근데 0으로 그냥 냅두는 경우의 수
      dfs(index+1, write, sum);
      //현재 재귀함수의 상태에서
      
      // 다음 재귀함수의 경우의 수를 다 표현해줬을 때

      // 재귀함수의 80퍼는 끝났다.

      // 0을 1~3까지 채우는 경우의 수
      for(int i = 1; i < 4; i++)
      {
         map[r][c] = i;
         // 지금 내가 있는 곳을 i로 채워주고 따지는 경우의 수
         dfs(index+1, write+1, sum+i);
         map[r][c] = 0;
      }
   }
   
}