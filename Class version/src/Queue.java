class Queue {

    Customer[] customers = new Customer[100];
    int Queue_count;
    int Current_Customers = 0;
    int income = 0;

    Queue(int size) {
        Queue_count = size;
        for (int i = 0; i < size; i++) {
            customers[i] = new Customer();
        }

    }
}
