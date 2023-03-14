public class LinkedList {
    private Node head;
    public LinkedList(){
    this.head = null;
    }


    /* Define an addNode method that takes a data value, creates a new node with that data,
    and adds it to the end of the linked list.*/
    public void addNode(int data){
        Node tempNode = new Node(data);
        if (this.head==null){
            head = tempNode;
        }
        else {
            Node temp1Node = head;
            while (temp1Node.getNext() != null) {
                temp1Node = temp1Node.getNext();
            }
            temp1Node.setNext(tempNode);
        }
    }

    /*Define a printList method that traverses the linked list from the head node and prints
    the data value of each node.*/
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.getData()+" ");
            temp = temp.getNext();
        }
        System.out.println();
    }


    /*Define a contains method that takes a data value and returns a boolean indicating
    whether that value is present in any node of the linked list.*/
    public boolean contains(int data){
        Node temp = head;
        while(temp != null){
            if(temp.getData()==data){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }


    /*Define a findMax method that returns the maximum data value present in any node of
    the linked list.*/
    public int findMax(){
        Node temp = head;
        int max = head.getData();
        while (temp != null){
            int cmp = temp.getData();
            if(cmp>max){
                max = cmp;
            }
            temp = temp.getNext();
        }
        return max;
    }


    /*Define a findAvg method that returns the average data value of all nodes in the linked
    list.*/
    public double findAvg(){
        Node temp =head;
        double sum=0;
        double cnt=0;
        while(temp != null){
            sum = sum + temp.getData();
            cnt++;
            temp = temp.getNext();
        }
        return sum/cnt;
    }

}
