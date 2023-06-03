#include <bits/stdc++.h>
using namespace std;
#define random(x)(rand()%x)
#define orderc 600

int age[20] = { 18,18,19,19,20,20,21,21,22,22,23,23,24,24,28,33,37,41,55,66 };
string type[5] = { "篮球场","羽毛球场","乒乓球场","跑廊乒乓球场","网球场" };
int venue_count[5] = { 1,22,37,38,40 };
int prdate = 1;
struct VdState {
    string date;
    string state;
};
struct User {
    string id;
    string password;
    string sex;
    int age;
    string email;
}user[20];
struct Venue {
    string id;
    string type;
    string name;
    double price;
    int capacity;
    int open;
    int close;
    int is_del;
    VdState vd[30];
}venue[41];
struct Order {
    string id;
    int ven_ix;
    int user_ix;
    int dateix;
    int st;
    int ed;
    int state;
    string mktime;
}order[orderc];

string toString(int x) {
    stringstream tmp;
    tmp << x;
    return tmp.str();
}
int getrandrange(int x, int y) {
    return rand() % (y - x + 1) + x;
}

string getrandint(int ix) {//获得ix位的随机数
    string rs = toString((rand() % 9) + 1);
    for (int i = 0; i < ix - 1; i++) {
        rs = rs + toString(rand() % 10);
    }
    return rs;
}

void getuser() {
    for (int i = 0; i < 20; i++) user[i].age = age[i];
    for (int i = 0; i < 20; i++) {
        string id;
        string a[3] = { "3","5","8" };
        string b[9] = { "0","1","2","3","5","6","7","8","9" };
        id = "1";
        id = id + a[random(3)]+b[random(9)];
        id = id + getrandint(8);
        
        
        user[i].id = id;
        if (i % 2 == 0) user[i].sex = "男";
        else user[i].sex = "女";
        user[i].password = "123456";
        stringstream tmp;
        user[i].email = getrandint(10) + "@qq.com";
        //        cout<<user[i].id<<" "<<user[i].password<<" "<<user[i].sex<<" "<<user[i].age<<" "<<user[i].email<<endl;
        cout << "INSERT INTO gms_user VALUES('" << user[i].id << "','" << user[i].password << "','" << user[i].sex << "'," << user[i].age << ",'" << user[i].email << "');\n";
    }
}

void getvenue() {
    int idc = 0;
    while (idc < 41) {
        if (idc + 1 < 10) venue[idc].id = "0" + toString(idc + 1);
        else venue[idc].id = toString(idc + 1);

        if (idc <= venue_count[0]) {
            venue[idc].type = type[0];
            venue[idc].name = type[0] + toString(idc + 1) + "号";
            venue[idc].capacity = 18;
            venue[idc].price = 1.0 * 500;
        }
        else if (idc <= venue_count[1]) {
            venue[idc].type = type[1];
            venue[idc].name = type[1] + toString(idc - venue_count[0]) + "号";
            venue[idc].capacity = 4;
            venue[idc].price = 1.0 * 50;
        }
        else if (idc <= venue_count[2]) {
            venue[idc].type = type[2];
            venue[idc].name = type[2] + toString(idc - venue_count[1]) + "号";
            venue[idc].capacity = 4;
            venue[idc].price = 1.0 * 50;
        }
        else if (idc <= venue_count[3]) {
            venue[idc].type = type[3];
            venue[idc].name = type[3] + toString(idc - venue_count[2]) + "号";
            venue[idc].capacity = 2;
            venue[idc].price = 1.0 * 30;
        }
        else {
            venue[idc].type = type[4];
            venue[idc].name = type[4] + toString(idc - venue_count[3]) + "号";
            venue[idc].capacity = 10;
            venue[idc].price = 1.0 * 400;
        }

        venue[idc].open = getrandrange(9, 13);
        venue[idc].close = getrandrange(17, 22);

        venue[idc].is_del = 0;
        //        cout<<venue[idc].id<<" "<<venue[idc].type<<" "<<venue[idc].name<<" "<<venue[idc].price<<
        //        " "<<venue[idc].capacity<<" "<<venue[idc].open<<" "<<venue[idc].close<<" "<<venue[idc].is_del<<endl;
        cout << "INSERT INTO gms_venue VALUES('" << venue[idc].id << "','" << venue[idc].type << "','" << venue[idc].name << "'," << venue[idc].price <<
            ".0," << venue[idc].capacity << "," << venue[idc].open << "," << venue[idc].close << "," << venue[idc].is_del << ");\n";
        for (int j = 0; j < 30; j++) {
            venue[idc].vd[j].date = "2023-6-" + toString(prdate + j);
            venue[idc].vd[j].state = "00000000000000000000000";
            for (int k = venue[idc].open; k < venue[idc].close; k++)
                venue[idc].vd[j].state[k] = '1';
        }
        idc++;
    }
}

void getorder() {
    for (int i = 0; i < orderc; i++) {
        int ven_ix;
        int user_ix;
        double price;
        order[i].id = toString(i);
        order[i].dateix = rand() % 30;
        int tmp = rand() % 5;
        if (tmp == 0) order[i].st = getrandrange(10, 12);
        else if (tmp == 4) order[i].st = getrandrange(18, 19);
        else order[i].st = getrandrange(13, 17);
        order[i].ed = order[i].st + 1;
        order[i].state = (rand() % 5) > 0 ? 0 : 1;//大部分是进行中
        order[i].mktime = "2023-6-" + toString(prdate + order[i].dateix) + " " + toString(getrandrange(10, 23)) + ":" + toString(getrandrange(10, 59)) + ":" + toString(getrandrange(10, 59));
        order[i].user_ix = rand() % 20;
        order[i].ven_ix = rand() % 41;
        if (venue[order[i].ven_ix].open > order[i].st || venue[order[i].ven_ix].close < order[i].ed) i--;
        else if (venue[order[i].ven_ix].vd[order[i].dateix].state[order[i].st] == '2' || venue[order[i].ven_ix].vd[order[i].dateix].state[order[i].st] == '0') i--;
        else {
            venue[order[i].ven_ix].vd[order[i].dateix].state[order[i].st] = '2';
            cout << "INSERT INTO gms_order VALUES('" << order[i].id << "','" << venue[order[i].ven_ix].id << "','" << user[order[i].user_ix].id << "','"
                << venue[order[i].ven_ix].vd[order[i].dateix].date << "'," << order[i].st << "," << order[i].ed << "," << order[i].state << ",'" << order[i].mktime << "',"
                << venue[order[i].ven_ix].price << ".0);\n";
        }

    }
}

void print() {
    set<string>s;
    for (int i = 0; i < orderc; i++) {
        if (s.find(venue[order[i].ven_ix].id + venue[order[i].ven_ix].vd[order[i].dateix].date) != s.end()) continue;
        s.insert(venue[order[i].ven_ix].id + venue[order[i].ven_ix].vd[order[i].dateix].date);
        cout << "INSERT INTO gms_vdstate VALUES('" << venue[order[i].ven_ix].id << "','" << venue[order[i].ven_ix].vd[order[i].dateix].date << "','" << venue[order[i].ven_ix].vd[order[i].dateix].state << "');\n";
        
    }
    //for (int i = 0; i < 41; i++)
    //{
     //   cout << "INSERT INTO gms_vdstate VALUES('" << i << "','" << "2023-6-" + toString(8 + i % 21) << "','" << "11111111111111111111111" << "');\n";
    //}

}
int main()
{
    srand(time(0));
    getuser();
    getvenue();
    getorder();
    print();
    return 0;
}