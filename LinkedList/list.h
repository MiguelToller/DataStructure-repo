#include <iostream>
#include <cstdlib>

using namespace std;

typedef struct node {
    int value;
    struct node *prox;
} Cell;

Cell *add(int value, Cell *list) {

    for (Cell *p = list; p; p = p->prox) {
        if (p->value == value) {
            return list;
        }
    }

    // Allocate memory
    Cell *newCell = (Cell *)malloc(sizeof(Cell));

    // Set the value
    newCell->value = value;
    newCell->prox = NULL;

    // Empty list
    if (!list) return newCell;
    
    // Traverse to the end of the list
    Cell *p;
    for (p = list; p->prox; p = p->prox);

    // Link the new node at the end of the list
    p->prox = newCell;
    return list;
}

void show(Cell *list) {

    for (Cell *p = list; p; p = p->prox) {
        cout << p->value << " ";
    }
    cout << endl;
}

int size(Cell *list) {

    int total = 0;

    for (Cell *p = list; p; p = p->prox) {
        total++;
    }
    return total;
}

int contains(Cell *list, int value) {

    int count = 0;

    for (Cell *p = list; p; p = p->prox) {
        if (p->value == value) count++;
    }
    return count;
}

bool isSorted(Cell *list) {

    if (!list || !list->prox) return true;

    for (Cell *p = list; p->prox; p = p->prox) {
        if (p->value > p->prox->value) return false;
    }
    return true;
}

Cell *bubbleSort(Cell *list) {
    
    if (!list || !list->prox) return list;

    bool swapped;
    do {
        swapped = false;

        // Traverse the list and compare adjacent elements
        for (Cell *p = list; p && p->prox; p = p->prox) {
            if (p->value > p->prox->value) {
                // Swap the values if they are in the wrong order
                int temp = p->value;
                p->value = p->prox->value;
                p->prox->value = temp;

                swapped = true;
            }
        }
    } while (swapped);  // Repeat until no swaps are made in a full iteration

    return list;  // Return the sorted list
}

double average(Cell *list) {

    int sum = 0;
    int count = 0;

    for (Cell *p = list; p; p = p->prox) {
        sum += p->value;
        count++;
    }
    return (double)sum/count;
}