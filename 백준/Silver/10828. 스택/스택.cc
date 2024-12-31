#include <iostream>
using namespace std;
class Stack{
private:
    int n;
    int stack[10000];
    int size;
public:
    Stack(){
        this->size = 0;
    }
    void push(int data){
        stack[size] = data;
        size+=1;
    }
    int pop(void){
        if(size == 0)
            return -1;
        size-=1;
        return stack[size];
    }
    int put_size(void){
        return size;
    }
    bool empty(void){
        return (size==0);
    }
    int top(void){
        if(size == 0)
            return -1;
        return stack[size-1];
    }
};

int main(void) {
    int n;
    cin >> n;
    string command;
    Stack stack;
    
    for(int i = 0;i<n;i++){
        cin >> command;
        if(command == "push"){
            int data;
            cin >> data;
            stack.push(data);
        }
        else if(command == "pop"){
            cout << stack.pop() << endl;
        }
        else if(command == "size"){
            cout << stack.put_size() << endl;
        }
        else if(command == "empty"){
            cout << stack.empty() << endl;
        }
        else if(command == "top"){
            cout << stack.top() << endl;
        }
        else{
            cout << "Wrong Command!" << endl;
        }
        
    }
    return 0;
}


