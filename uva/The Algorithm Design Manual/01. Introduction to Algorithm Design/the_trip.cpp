// link: https://uva.onlinejudge.org/external/101/10137.pdf
// name: The Trip

#include<cstdio>
#include<vector>
#include<cmath>

using namespace std;

double round2(double d){
    long temp = (long) round(d * 100);
    return temp/100.;
}

int main(){

    while(true){

        int n;
        scanf("%d",&n);
        if (n==0) break;

        vector<double> spendings;
        double total_sum = 0.0;
        for(int i =0;i<n;i++){
            double current_spending;
            scanf("%lf",&current_spending);
            total_sum+=current_spending;
            spendings.push_back(current_spending);
        }

        double avg = round2(total_sum/n);
        double plus_diff = 0;
        double minus_diff = 0;
        for (int i=0;i<n;i++){
            if (spendings[i] > avg)
                minus_diff += spendings[i]-avg;
            else
                plus_diff += avg-spendings[i];
        }
        if (plus_diff < minus_diff)
            printf("$%.2lf\n", plus_diff);
        else
            printf("$%.2lf\n", minus_diff);
    }
}
