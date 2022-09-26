class Solution {
    public boolean equationsPossible(String[] arr) {
      
        int [] par=new int [26];
        int [] rank=new int[26];
        for(int i=0;i<par.length;i++ ){
            
            par[i]=i;
            
            rank[i]=1;
        }
        int count=0;
        
        for(String s :arr){
            char ch1=s.charAt(0);
            char ch2=s.charAt(3);
            if(s.charAt(1)=='='){
             boolean a =Union(((int)ch1)-97,((int)ch2)-97,par,rank); 
               
            }
      
        }
        
         for(String s :arr){
            char ch1=s.charAt(0);
            char ch2=s.charAt(3);
            if(s.charAt(1)=='!'){
             boolean a =Unionf(((int)ch1)-97,((int)ch2)-97,par,rank); 
                if(a==false){
                    return false;
                }
            }
      
        }
        
        return true;
    }
    
    public boolean Unionf(int x,int y,int [] par,int [] rank ){
        int lx=find(x,par);
        int ly=find(y,par);
        
        if(lx!=ly){
            return true;
        }
        else{
            return false;
        }
        
    }
    public boolean Union(int x,int y,int [] par,int [] rank ){
        int lx=find(x,par);
        int ly=find(y,par);
        
        if(lx!=ly){//dono same group mai nhi hai 
            if(rank[lx]>rank[ly]){
                par[ly]=lx;
                
            }
            else if(rank[lx]<rank[ly]){
                par[lx]=ly;
            }
            else{
                par[lx]=ly;
                rank[ly]++;
            }
            
          
            return true;
        }
  
        return false;//already in same group 
    }
    public int find(int x ,int [] parent){
        if(parent[x]==x){
            return x;
        }
        
       int temp=find(parent[x],parent);
      parent[x]=temp;
      
      return temp;
       
    }
}