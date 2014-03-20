#include<cstdio>
#include<vector>
#include<cmath>

#define MAX_R 1000000000

using namespace std;

bool canPaint(long long r, long long paint, long long circles){

  return (2 * r + 2 * circles - 1) <= paint/circles;
}

int main(){
  
  FILE * inFile, * outFile;
  inFile = fopen ("A-large-practice.in","r");
  outFile = fopen ("A-large-practice.out","w");
  
  
  
  int T;
  
  fscanf(inFile,"%d",&T);
  
  for(int t=0;t<T;++t){
    long long paint, r;
    fscanf(inFile, "%lld%lld", &r, &paint);
    
    long long result = 0;
    long long low=1, high = paint;
    
    while(low<high){
      long long mid = (high+low)/2;
     
      if(canPaint(r,paint,mid)){
        low = mid+1;
        result = mid;
      }else{
        high = mid;
      }
    }
    
    fprintf(outFile,"Case #%d: %lld\n", (t+1),result);
  }
  
  fclose(inFile);
  fclose(outFile);
}
