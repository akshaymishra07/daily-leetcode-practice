// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int N, int k)
    {
        long res[] = new long[N-k+1];
        List<Long> list = new ArrayList<>();
        int p = 0;
        
        
        for(int i = 0; i < N; i++){
            
            if(arr[i] < 0){
                list.add(arr[i]);
            }
            
            if(i >= k){
                
                if(list.size() != 0 && list.get(0) == arr[i-k]){
                    list.remove(0);
                }
                
            }
            
            if(i >= k-1){
                
                if(list.size() == 0){
                    res[p++] = 0;
                }else{
                    res[p++] = list.get(0);
                }
            }
        }
        
        return res;
    }
}