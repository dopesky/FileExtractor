#include <iostream>
using namespace std;

int main()
{
    float a;
    float ans;
    float b;
    cout<<"Please input digits to be subtracted: "<<endl;
    cin>>a;
    while(cin.fail())
    {
        cin.clear();
        cin.ignore(INT_MAX,'\n');
        cout<<"Invalid input.\nPlease input number: \n";
        cin>>a;
    }
    cin.ignore(INT_MAX,'\n');
    cin>>b;
    while(cin.fail())
    {
        cin.clear();
        cin.ignore(INT_MAX,'\n');
        cout<<"Invalid input.\nPlease input number: \n";
        cin>>b;
    }
    ans=a-b;
    cout<<"Ans: "<<ans<<endl;
    return 0;
}
