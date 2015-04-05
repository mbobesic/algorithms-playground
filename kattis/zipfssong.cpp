// link: https://labs.spotify.com/puzzles/
// name: Zipfs Song
#include<iostream>
#include<string>
#include<vector>
#include<set>

using namespace std;

struct pair_compare {
    bool operator() (const pair<int, long>& lhs, const pair<int, long>& rhs) const{
		if (lhs.second == rhs.second)
			return lhs.first < rhs.first;
		return lhs.second > rhs.second;
    }
};

int main(){

	int n, m;
	cin >> n >> m;
	
	vector< string > inputs;
	set< pair<int, long>, pair_compare> quality_by_order;
	for(int i=0;i<n;i++){
		long value;
		string name;
		cin >> value >> name;
		inputs.push_back(name);
		quality_by_order.insert(make_pair(i, (i+1) * value));
	}
	
	int count = 0;
	for (set< pair<int, long>, pair_compare>::const_iterator it = quality_by_order.begin(); it!=quality_by_order.end();it++){
		if (count == m){
			break;
		}
		count ++;
		cout << inputs[(*it).first] << endl;
	}
}
