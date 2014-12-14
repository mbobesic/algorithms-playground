#include<cstdio>
#include<vector>
#include <limits>

using namespace std;

int main(){
  
  FILE * inFile, * outFile;
  inFile = fopen ("B-large.in","r");
  outFile = fopen ("B-large.out","w");
  
  
  
  int T;
  
  fscanf(inFile,"%d",&T);
  
  for(int t=0;t<T;++t){
    
    double c, f, x;
    fscanf(inFile, "%lf%lf%lf", &c,&f,&x);
    
    double timeSpentOnFactories = 0.0;
    int factoriesNum = 0;
    double solution = x/2;
    

    while(true){
      
      double current_speed = 2 + factoriesNum*f;
      timeSpentOnFactories += c/current_speed;
      factoriesNum++;
      current_speed =  2 + factoriesNum*f;
      
      double current_solution = timeSpentOnFactories + x/current_speed;
      if(current_solution < solution) solution = current_solution;
      else break;
    }

    fprintf(outFile, "Case #%d: %lf\n", (t+1),solution);
  }
  
  fclose(inFile);
  fclose(outFile);
}
