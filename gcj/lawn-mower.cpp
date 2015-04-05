// link: https://code.google.com/codejam/contest/2270488/dashboard#s=p1
// name: Lawnmower
#include<cstdio>
#include<vector>

using namespace std;

int main(){
  
  FILE * inFile, * outFile;
  inFile = fopen ("B-large-practice.in","r");
  outFile = fopen ("B-large-practice.out","w");
  int T;
  
  fscanf(inFile,"%d",&T);

  for(int t=0;t<T;++t){
    
    int n, m;
    fscanf(inFile, "%d%d",&n,&m);
    
    vector < vector <int> > lawn; 
    vector < vector <int> > solution;
    vector <int> row;
    
    lawn.insert(lawn.begin(),n, row);
    solution.insert(solution.begin(), n, row);
    
    
    for(int i=0;i<n;++i){      
      for(int j = 0;j<m;++j){
        int height;
        fscanf(inFile,"%d",&height);
        lawn[i].push_back(height); 
        solution[i].push_back(100);
      }
    }
    
    for(int i=0;i<n;++i){      
      
      int max = 1;
      for(int j = 0;j<m;++j){
        if(lawn[i][j] > max) max = lawn[i][j];
      }
      
      for(int j = 0;j<m;++j){
        solution[i][j] = max;
      }
    }
    
    
    for(int j=0;j<m;++j){      
      
      int max = 1;
      for(int i = 0;i<n;++i){
        if(lawn[i][j] > max) max = lawn[i][j];
      }
      
      for(int i = 0;i<n;++i){
        solution[i][j] = min(solution[i][j], max);
      }
    }
    
    bool solvable = true;
    
    for(int i=0;i<n;++i){      
      for(int j = 0;j<m;++j){
         if(solution[i][j] != lawn[i][j])
           solvable = false;
      }
    }
    if(solvable)
      fprintf(outFile,"Case #%d: YES\n", (t+1)); 
    else
      fprintf(outFile,"Case #%d: NO\n", (t+1)); 
  }
  
  fclose(inFile);
  fclose(outFile);
}
