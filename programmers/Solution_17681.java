package study_08_04;

class Solution_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int map1[][] = new int[n][n];
        int map2[][] = new int[n][n];
        
        int ans[][] = new int[n][n];
        
        for(int i=0; i<n; i++) {
        	map1[i] = change(arr1[i],n);
        	map2[i] = change(arr2[i],n);
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		ans[i][j] = map1[i][j] + map2[i][j];
        	}
        }
        
        for(int i=0; i<n; i++) {
        	String str = "";
        	for(int j=0; j<n; j++) {
        		if(ans[i][j] > 0) str +="#";
        		else str+= " ";
        	}
        	answer[i] = str;
        }
        
        return answer;
    }

	private int[] change(int num, int n) {
		
		int arr[] = new int[n];
		
		for(int i=0; i<n; i++) {
			int binary = (int) Math.pow(2, n-i-1);
			if(num >= binary) {
				arr[i] = 1;
				num -= binary;
			}
		}
//		System.out.println(Arrays.toString(arr));
		return arr;
	}
}
