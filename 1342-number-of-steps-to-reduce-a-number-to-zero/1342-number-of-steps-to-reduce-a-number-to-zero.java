class Solution {
   public int numberOfSteps(int num) {
        if(num==0)
            return 0;
     int totalSetBit =0;
     int msbPosition =0;
    
	/**
	This loop will run number of set bits in number which in worst case can be 64 or 32 depending on underlying arch.
	**/
        while(num!=0) {
             msbPosition = num;
             num=num&(num-1);
             totalSetBit++;
         }
        	/**
	This loop will run number of set bits in number which in worst case can be 64 or 32 depending on underlying arch.
	**/
        int pos=0;
         while(msbPosition>0) {
                msbPosition>>=1;
                pos++;
        }
         msbPosition=pos; 
        return totalSetBit+msbPosition-1;
    }
}