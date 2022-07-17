import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


//pq에 cost 순서대로 넣어놓고 하나 씩 뺴서 부모 연결되어있는지 확인
//부모가 연결되어있지 않다면 서로 연결된 방이 아니므로 union으로 연결시켜줌
//모든 방이 연결되면 부모가 같을것이므로 pq에 들어가있는것들은 if문에 걸리지 않고 전부  poll
public class B_23743 {

   static int N, M; 
   static int parent[];
   static class edge implements Comparable<edge>
   {
      int from,to,cost;

      public edge(int from, int to, int cost) {
         super();
         this.from = from;
         this.to = to;
         this.cost = cost;
      }
      
      @Override
      public int compareTo(edge o) {
         // TODO Auto-generated method stub
         return this.cost - o.cost;
      }
   }
   
   static PriorityQueue<edge> pq = new PriorityQueue<>();
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      
      N = Integer.parseInt(st.nextToken()); //방의 수
      M = Integer.parseInt(st.nextToken()); // 워프 개수
      int result=0; //결과값 저장용
      
      for(int i=0;i<M;i++) //워프 개수만큼
      {
         int from, to, cost;
         st = new StringTokenizer(br.readLine()," ");
         from = Integer.parseInt(st.nextToken());
         to = Integer.parseInt(st.nextToken());
         cost = Integer.parseInt(st.nextToken());
         
         pq.add(new edge(from,to,cost));
      }
      
      //비상탈출구
      st = new StringTokenizer(br.readLine()," ");
      for(int i=1;i<=N;i++) //0번을 비상탈출구라 가정하고 1~N까지 방 연결
      {
         int cost;
         cost = Integer.parseInt(st.nextToken());
         pq.add(new edge(0,i,cost));
      }
      
      parent = new int[N+1];
      for(int i=1;i<=N;i++) //자기자신으로 부모 초기화
         parent[i]=i;
      
      while(!pq.isEmpty()) //pq에는 어차피 cost낮은 순으로 들어가 있음
      {
         edge temp = pq.poll();
         int from = temp.from;
         int to = temp.to;
         int cost = temp.cost;
         
         if(find(from) != find(to)) //부모가 같지 않으면 연결되지 않았으므로 연결해줌
         {
            union(from, to); //부모 연결
            result+=cost;
         }
      }
      System.out.println(result);
   }
   
   private static void union(int from, int to) {
      int fromParent = find(from);
      int toParent = find(to);
      
      if(fromParent < toParent)
         parent[toParent] = fromParent; 
      else
         parent[fromParent] = toParent;
   }
   
   private static int find(int x) {
      if(parent[x] == x)
         return x;
      return parent[x] = find(parent[x]);
   }

}