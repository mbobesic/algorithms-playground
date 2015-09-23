// link: https://uva.onlinejudge.org/external/1/100.pdf
// name: 3n+1

#include<cstdio>

using namespace std;

int main(){

    int i, j;

    while(scanf ("%d%d", &i, &j)!=EOF){

        int bigger = i;
        int smaller = j;

        if (bigger < smaller){
            smaller = i;
            bigger = j;
        }
        int best_solution=1;
        for (int current=smaller;current<=bigger;current++){
            int n = current;
            int current_solution=1;
            while (n!=1){
                if(n%2==1) n = 3*n+1;
                else n=n/2;
                current_solution++;
            }

            if (current_solution > best_solution){
                best_solution = current_solution;
            }
        }

        printf("%d %d %d\n", i,j,best_solution);
    }
}
