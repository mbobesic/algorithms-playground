#include<cstdio>
#include<vector>
#include<cmath>

#define MAX_R 1000000000

using namespace std;
// need big int or some approximation for too big r
int main(){
  
  FILE * inFile, * outFile;
  inFile = fopen ("A-small-practice.in","r");
  outFile = fopen ("A-small-practice.out","w");
  
  
  
  int T;
  
  fscanf(inFile,"%d",&T);
  
  for(int t=0;t<T;++t){
    long long paint, r;
    fscanf(inFile, "%lld%lld", &r, &paint);
    

    long long result;
    result = 1 - 2*r;
    result += sqrt(4*r*r - 4*r + 1 + 8*paint);
    result /= 4;
    
    fprintf(outFile,"Case #%d: %lld\n", (t+1),result);
  }
  
  fclose(inFile);
  fclose(outFile);
}
