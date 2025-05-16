using namespace std;

#include <iostream>
#include "list.h"

int main() {

    Cell *list = NULL;

    list = add(7, list);
    list = add(10, list);
    list = add(5, list);
    list = add(4, list);

    // List size
    cout << "List contains " << size(list) << " elements\n";

    // Show list
    show(list);

    // Contains
    int number;
    cout << "Write a number for search: ";
    cin >> number;

    int count = contains(list, number);
    if (count > 0) {
        cout << "The list contains the number '" << number << "', " << count << " time(s)." << endl;
    } else {
        cout << "The list does not contain the number " << number << endl;
    }

    // Average
    double avg = average(list);
    cout << "The average of the elements in the list is: " << avg << endl;

    // Sorted
    if (isSorted(list)) {
        std::cout << "The list is already sorted." << std::endl;
    } else {
        std::cout << "The list is not sorted. Sorting the list using Bubble Sort..." << std::endl;
        list = bubbleSort(list);  // Sort the list using Bubble Sort
    }

    // Show sorted list
    show(list);
}