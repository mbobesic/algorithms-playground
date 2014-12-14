#include<cstdio>
#include<vector>

using namespace std;

int main(){
  
  FILE * inFile, * outFile;
  inFile = fopen ("A-small-attempt1.in","r");
  outFile = fopen ("A-small-attempt1.out","w");
  
  
  
  int T;
  
  fscanf(inFile,"%d",&T);
  
  for(int t=0;t<T;++t){
    int first_row;
    fscanf(inFile, "%d", &first_row);
    
    int board[4][4];
    for (int row = 0;row<4;++row){
      for(int column = 0; column<4;++column){
        int temp;
        fscanf(inFile, "%d", &temp);
        board[row][column] = temp;
      }
    }
    int possible[16+1] = {};
    for(int i=0;i<4;++i){
      possible[board[first_row-1][i]] = 1;

    }

    int second_row;
    fscanf(inFile, "%d", &second_row);
    
    for (int row = 0;row<4;++row){
      for(int column = 0; column<4;++column){
        fscanf(inFile, "%d",&board[row][column]);
      }
    }
    
    vector<int> solutions;
    for(int i=0;i<4;++i){
      int current = board[second_row-1][i];
      if(possible[current] == 1){
        solutions.push_back(current);
      }
    }

    if (solutions.size() == 0) fprintf(outFile,"Case #%d: Volunteer cheated!\n", (t+1));
    if (solutions.size() == 1) fprintf(outFile,"Case #%d: %d\n", (t+1), solutions[0]);
    if (solutions.size() > 1) fprintf(outFile,"Case #%d: Bad magician!\n", (t+1));
  }
  
  fclose(inFile);
  fclose(outFile);
}
