
SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode node = head;
        if(head == null)
        {
            head = new SinglyLinkedListNode(data);
            return head;
        }
        while(node.next != null)
            node = node.next;
        
        node.next = new SinglyLinkedListNode(data);
        return head;

    }