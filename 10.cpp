#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <fstream>
using namespace std;

class Tree{
public:
    int val;
    Tree *left, *right;
    Tree(int val){
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};

void allPaths(Tree *root,vector<int> paths){
    if(root == nullptr)
        return;
    paths.push_back(root->val);
    if(root->left == nullptr && root->right == nullptr){
        for(auto el:paths){
            cout << el << " ";
        }
        cout << endl;
    }else{
        allPaths(root->left,paths);
        allPaths(root->right,paths);
    }
}

int main(){
    auto root = new Tree(1);
    root->right = new Tree(2);
    root->left = new Tree(3);
    root->right->right = new Tree(4);
    root->left->right = new Tree(5);
    vector<int> paths;
    allPaths(root,paths);
    return 0;
}