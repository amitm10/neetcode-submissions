//Class contains Value, head, size and next - head doesnt change, size and head will be initalised as 0 and NULL
class MyLinkedList {
    int val;//
    MyLinkedList next;
    int size;
    MyLinkedList head;

    public MyLinkedList() {//Object Initialisation, non parametrised constructor
        this.size = 0; //size is 0
        this.head = null;// head is null, next is not defined,val is not defined
    }

    private MyLinkedList(int val) {
        this.val = val;//first call only wiht value no pointer is given
        this.next = null;//next will be null
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        MyLinkedList curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;//get the value at index by looping till value of index-1
        return curr.val;
    }
    
    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList(val);
        newNode.next = head;//adding at head only
        head = newNode;//head changes
        size++;
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        MyLinkedList newNode = new MyLinkedList(val);
        MyLinkedList curr = head;
        for (int i = 0; i < index - 1; i++) curr = curr.next;
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
        } else {
            MyLinkedList curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            curr.next = curr.next.next;
        }
        size--;
    }
}