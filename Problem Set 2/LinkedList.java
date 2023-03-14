public class LinkedList {
    private Node head;
    public LinkedList(){
    this.head = null;
    }


    /* Define an addNode method that takes a data value, creates a new node with that data,
    and adds it to the end of the linked list.*/
    public void addNode(int data){
        Node temp = new Node(data);
        if (this.head==null){
            head = temp;
        }
        else {
            Node temp1 = head;
            while (temp1.getNext() != null) {
                temp1 = temp1.getNext();
            }
            temp1.setNext(temp);
        }
    }

    /*Define a printList method that traverses the linked list from the head node and prints
    the data value of each node.*/
    public void printList(){
        Node temp = head;
        int index = 1;
        while(temp != null){
            System.out.println("["+index+"]"+temp.getData()+" ");
            temp = temp.getNext();
            index++;
        }

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


    /* Delete from linked list*/

    public void delete(int position){
        //if linked list is empty
        if(head == null){
            return;
        }
        //How many nodes exist
        Node temp = head;
        int last = 0;
        while(temp != null){
            last++;
            temp = temp.getNext();
        }

        //Remove first item
        if (position == 1){
            Node temp1 = head.getNext();
            head.setNext(null);
            head = temp1;
        }

        //Remove last item
        else if(position == last){
            Node temp2 = head;
            while(temp2.getNext().getNext()!= null){
                temp2 = temp2.getNext();
            }
            temp2.setNext(null);
        }

        //Remove item between first and last
        else{
            Node temp3 = head;
            for (int i = 0; i < position - 1; i++) {
                temp3 = temp3.getNext();
            }
                temp3.setNext(temp3.getNext().getNext());
             }
        }
    }


