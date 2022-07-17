import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_19238 {
/*
1. 상 좌 우 하로 하면 될줄 알았는데 왼 왼 왼 보다 오 오 위가 우선순위 높음
2. 승객의 목적지가 다 벽으로 둘러 쌓여있을 때 간과 
3. 시작시점에 승객이 있을시, 승객이 탑승한곳에서 하차할 시 간과
4. 이동하다가 연료가 만료되면 멈추는게 맞지만 pq에 넣어놓은 승객이 있을 경우는 끝난게아님.
*/
   static int N, M, totalFuel, map[][], cnt=0;
   static int startX,startY;
   static int target[][][];
   static int clientNo;
   static int dx[] = {-1,0,0,1}, dy[]= {0,-1,1,0}; //상 좌 우 하 순으로 탐색해야 조건에 맞음
   
   static class location
   {
      int x,y,fuel;

      public location(int x, int y, int fuel) {
         super();
         this.x = x;
         this.y = y;
         this.fuel = fuel;
      }
      
   }
   
   static class firstClient implements Comparable<firstClient>
   {
      int x, y, cost;

      public firstClient(int x, int y, int cost) {
         super();
         this.x = x;
         this.y = y;
         this.cost = cost;
      }
      
      @Override
      public int compareTo(firstClient o) {
         // TODO Auto-generated method stub
         if(this.cost == o.cost)
            if(this.x == o.x)
               return this.y-o.y;
            else
               return this.x-o.x;
         else
            return this.cost-o.cost;
      }
   }
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      totalFuel = Integer.parseInt(st.nextToken());
      
      map = new int[N][N];
      target = new int[N][N][M]; //한 좌표에 여러명 도착할 수 있으므로
      for(int i=0;i<N;i++)
      {
         st = new StringTokenizer(br.readLine()," ");
         for(int j=0;j<N;j++)
            map[i][j] = Integer.parseInt(st.nextToken());
      }
      
      st = new StringTokenizer(br.readLine()," ");
      startX = Integer.parseInt(st.nextToken())-1;
      startY = Integer.parseInt(st.nextToken())-1;
      
      for(int i=1;i<M+1;i++) //승객의 수 1은 벽이므로 2부터 표시
      {
         st = new StringTokenizer(br.readLine()," ");
         int clientX = Integer.parseInt(st.nextToken())-1;
         int clientY = Integer.parseInt(st.nextToken())-1;
         map[clientX][clientY] = i+1; //고객 좌표에 번호 표시해서 넣기
         
         int targetX = Integer.parseInt(st.nextToken())-1;
         int targetY = Integer.parseInt(st.nextToken())-1;
         int idx=0;
         while(true) //도착지에 해당 손님 번호 넣기
         {
            if(target[targetX][targetY][idx]!=0)
               idx++;
            else
            {
               target[targetX][targetY][idx] = i+1;
               break;
            }
         }
      }
      
      for(int i=2;i<M+2;i++)
      {
         firstClient client = FindClient();
         totalFuel -= client.cost; //승객 태우는데 까지 걸린 연료 소비
         FindTarget(client);
      }
      
      //승객을 도착지에 내려주지 못한경우
      for(int i=0;i<N;i++)
         for(int j=0;j<N;j++)
            for(int k=0; k<target[i][j].length;k++)
               if(target[i][j][k]!=0)
               {
                  System.out.println(-1);
                  return;
               }
   
      System.out.println(totalFuel);
   }
   
   private static void FindTarget(firstClient client) {
      Queue<location> q = new LinkedList<>();
      q.offer(new location(client.x, client.y, 0));
      boolean visited[][] = new boolean[N][N];
      visited[client.x][client.y] = true;
      
      for(int i=0;i<target[client.x][client.y].length;i++)//타자마자 내리는경우 ... 왜 탔냐?
         if(target[client.x][client.y][i]==clientNo)
         {
            target[client.x][client.y][i]=0;
            return;
         }
      
      while(!q.isEmpty())
      {
         location temp = q.poll();
         int x = temp.x;
         int y = temp.y;
         int fuel = temp.fuel;
         
         for(int i=0;i<4;i++)
         {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]==false)
            {
               if(map[nx][ny] == 1) //벽일 때
                  continue;
               
               for(int j=0;j<target[nx][ny].length;j++)
               {
                  if(target[nx][ny][j] == clientNo)
                  {
                     target[nx][ny][j] = 0; //들렸다고 표시
                     startX = nx; //시작점 바꿔주기
                     startY = ny;
                     
                     totalFuel -= fuel+1;
                     totalFuel += (fuel+1)*2; //연료 두배로 추가
                     return;
                  }
               }

               if(totalFuel < fuel+1)
               {
                  System.out.println(-1);
                  System.exit(0);
               }
               visited[nx][ny]=true;
               q.offer(new location(nx,ny,fuel+1));
               
            }
         }
      }
   }

   static firstClient FindClient()
   {
      location start = new location(startX,startY,0);
      Queue<location> q = new LinkedList<>();
      q.offer(start);
      boolean visited[][] = new boolean[N][N];
      visited[startX][startY]=true;
      PriorityQueue<firstClient> pq = new PriorityQueue<>(); //왼왼왼 보다 오오위가 더 우선순위 높음
      
      //시작지점에 승객이 있을 시 다른데 찾을 필요없음
      if(map[startX][startY]>1)
      {
         q.poll();
         pq.offer(new firstClient(startX,startY,0));
      }
      
      while(!q.isEmpty())
      {
         location temp = q.poll();
         int x = temp.x;
         int y = temp.y;
         int fuel = temp.fuel;
         
         
         for(int i=0;i<4;i++)
         {
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]==false)
            {
               if(map[nx][ny]==1)//벽일 때
               {
                  visited[nx][ny]=true;
                  continue;
               }
               if(map[nx][ny]==0) //비어있으면 계속 탐색
               {
                  if(totalFuel < fuel+1 && pq.isEmpty()) //연료가 초과됐는데 pq에 들어간 승객도 하나도 없을 경우 
                  {
                     System.out.println(-1);
                     System.exit(0);
                  }
                  
                  visited[nx][ny]=true;
                  q.offer(new location(nx,ny,fuel+1));
               }
               
               if(map[nx][ny]>1) //가장 가까운 승객 만났을 때
               {
                  pq.offer(new firstClient(nx,ny,fuel+1));
                  visited[nx][ny]=true;
               }
            }
         }
      }
      
      firstClient first = pq.poll();
      if(first==null) //다 막혀있어서 승객 못태우고 나온경우
      {
         System.out.println(-1);
         System.exit(0);
      }
      clientNo=map[first.x][first.y];
      map[first.x][first.y]= 0; //승객 태움
      return first;
   }

}