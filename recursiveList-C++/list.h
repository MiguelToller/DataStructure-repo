typedef struct node {
    int data;
    struct node *next;
} List;

List *insert(int data, List *list) {

    if (list && data > list->data) {
        if (data != list->data) {
            list->next = insert(data, list->next);
        }
        return list;
    }
    else {
        List *newNode = (List*)malloc(sizeof(List));
        newNode->data = data;

        if (list) 
            newNode->next = list;
        else 
            newNode->next = NULL;
        
        return newNode;
    }
}

void showList(List *list) {
    if (list) {
        cout << list->data << endl;
        showList(list->next);
    }
}

int count(List *list) {
    if (list) {
        return 1 + count(list->next);
    }
    return 0;
}

List *find(List *list, int value) {
    if (list) {
        if (value == list->data) 
            return list;
        return find(list->next, value);
    }
    return NULL;
}