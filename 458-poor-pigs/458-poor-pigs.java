class Solution {
    public int poorPigs(int buckets, int mt, int mi) {
          int period = mi / mt + 1;
          int ans = 0;
          while(Math.pow(period, ans) < buckets){
            ans ++;
          }
          return ans;
    }
}