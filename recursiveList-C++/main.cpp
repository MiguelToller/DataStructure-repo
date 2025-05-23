#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

#include "list.h"

int main() {
    
    srand(time(NULL));

    List *list = NULL;
    for (int i=0; i<10; i++) {
        list = insert(rand() % 100, list);
    }

    cout << "Total number of elements: " << count(list) << endl;
    showList(list);

    int number;
    cout << "Number for search: ";
    cin >> number;

    List *response = find(list, number);
    if (response) {
        cout << response->data << " : " << response << " found\n";
    } else {
        cout << number << " not found\n";
    }

    return 1;
}