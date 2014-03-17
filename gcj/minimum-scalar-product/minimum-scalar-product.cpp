#include<cstdio>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
  int T;
 
  FILE * inFile, * outFile;
  inFile = fopen ("A-large-practice.in","r+");
  outFile = fopen ("A-large-practice.out","w");
  

  fscanf(inFile, "%d",&T);
  for(int t=0;t<T;++t)
    {
      int n;
      fscanf(inFile, "%d", &n);
      vector<int> x, y;
      for(int i=0;i<n;++i)
        {	
          int xi;
          fscanf(inFile,"%d",&xi);
          x.push_back(xi);
        }		
      
      for(int i=0;i<n;++i)
        {	
          int yi;
          fscanf(inFile,"%d",&yi);
          y.push_back(yi);
        }
      
      sort(x.begin(),x.end());
      sort(y.begin(),y.end());
      
      long long result = 0;
      
      for(int i=0;i<n;++i)
        {	
          result += (long long) x[i]*y[n-i-1];
        }
      
      fprintf(outFile,"Case #%d: %lld\n", (t+1), result);
    }
  
  fclose(inFile);
  fclose(outFile);
}
