#include <iostream>
using namespace std;
#include <vector>

//Given a binary tree, and a target number,
// find if there is a path from the root to any leaf that sums up to the target.

class Node{
public:
    int value;
    Node *left,*right;
    Node(int data){
        this->value = data;
        this->left = nullptr;
        this->right = nullptr;
    }
};

void preOrder(Node *root){
    if(root == nullptr)
        return;
    cout<<root->value<<" ";
    preOrder(root->left);
    preOrder(root->right);
}

void rootLeaf(Node *start,vector<int> tree,vector<vector<int>> &trees){
    if(start == nullptr)
        return;
    tree.push_back(start->value);
    if(start->left == nullptr and start->right == nullptr)
        trees.push_back(tree);
    rootLeaf(start->left,tree,trees);
    rootLeaf(start->right,tree,trees);
}

vector<int> targetSum(const vector<vector<int>>& trees,int sum){
    for(auto element:trees){
        int currentSum = 0;
        for(auto index:element){
            currentSum += index;
        }
        if(currentSum == sum){
            return element;
        }
    }
    return vector<int>();
}


int main(){
    auto root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->right = new Node(6);
    root->right->right = new Node(4);
    vector<int> path;
    int sum = 9;
    vector<vector<int>> paths;
    rootLeaf(root,path,paths);
    auto final = targetSum(paths,sum);
    for(auto el:final){
        cout<<el<<"->";
    }
    return 0;
}