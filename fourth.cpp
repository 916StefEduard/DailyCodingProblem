#include <iostream>
#include <map>
#include <vector>
using namespace std;

vector<int> twoSum(vector<int> numbers,int target){
    map<int,int> mymap;
    vector<int> positions;
    for(int i=0; i<numbers.size();++i){
        if(mymap.find(target - numbers[i])!=mymap.end()){
            positions.push_back(i);
            positions.push_back(mymap[target - numbers[i]]);
            return positions;
        }
        mymap.insert(pair<int,int>(numbers[i],i));
    }
    return positions;
}

int main(){
    vector<int> numbers;
    numbers.push_back(3);
    numbers.push_back(2);
    numbers.push_back(4);
    int target = 6;
    auto results = twoSum(numbers,target);
    for(auto elements:results){
        cout<<elements<<" ";
    }
    return 0;
}