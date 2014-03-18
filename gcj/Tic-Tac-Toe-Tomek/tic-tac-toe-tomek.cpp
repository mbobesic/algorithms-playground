#define SIZE 4
#include<cstdio>
#include<vector>

using namespace std;


char field[4][4];

bool check(char player){
  
  for(int i=0;i<SIZE;++i){
    bool won = true;
    for(int j=0;j<SIZE;++j){
      if(field[i][j] != player && field[i][j] != 'T')
        won = false;
    }
    if(won) return true;
  }
  
  for(int i=0;i<SIZE;++i){
    bool won = true;
    for(int j=0;j<SIZE;++j){
      if(field[j][i] != player && field[j][i] != 'T')
        won = false;
    }
    if(won) return true;
  }
  
  bool won_diag = true;
  for(int i=0;i<SIZE;++i){
    if(field[i][i] != player && field[i][i] != 'T')
      won_diag = false;
  }
  
  if(won_diag) return true;
  else won_diag = true;
  
  for(int i=0;i<SIZE;++i){
    if(field[i][SIZE-i-1] != player && field[i][SIZE-i-1] != 'T')
      won_diag = false;
  }
  
  return won_diag;
}


int main(){
  
  FILE * inFile, * outFile;
  inFile = fopen ("A-large-practice.in","r");
  outFile = fopen ("A-large-practice.out","w");
  int T;
  
  fscanf(inFile,"%d",&T);
  
  for(int t=0;t<T;++t){
    int empty_places = 0;
    fscanf(inFile,"%*c");
    for(int i=0; i<SIZE; ++i){
      for(int j=0; j<SIZE; ++j){
        
        fscanf(inFile,"%c", &field[i][j]);
        if(field[i][j]=='.'){
          ++ empty_places;
        }
      }
      fscanf(inFile,"%*c");
    }

    bool xWon = check('X');
    bool oWon = check('O');
    
    fprintf(outFile,"Case #%d: ",(t+1));
    if(xWon) fprintf(outFile,"X won\n");
    if(oWon) fprintf(outFile,"O won\n");
    if(!xWon && !oWon && empty_places==0) fprintf(outFile,"Draw\n");
    if(!xWon && !oWon && empty_places>0) fprintf(outFile,"Game has not completed\n");
 
 }
  
  fclose(inFile);
  fclose(outFile);
}
