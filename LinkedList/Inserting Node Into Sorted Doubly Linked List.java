static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
    DoublyLinkedListNode node = head;
    
    while((node.next != null) )
    {
        if( node.data == data)
        {
            newNode.next = node.next;
            node.next.prev = newNode;

            node.next = newNode;
            newNode.prev = node;
            break;
        }
        else if ( node.data > data)
        {
            if ( node == head )
            {
                newNode.next = node;
                node.prev = newNode;
                head = newNode;
                return head;
            }
            else
            {
                node.prev.next = newNode;
                node.prev = newNode;
                newNode.next = node;
                newNode.next = node;
                return head;
            }
            
        }
        node = node.next;
    }

    if(node.next == null)
    {
        if ( data > node.data)
        {
            node.next = newNode;
            newNode.prev = node;
            newNode.next = null;
        }
        else
        {
            node.prev.next = newNode;
            newNode.prev = node.prev;

            newNode.next = node;
            node.prev = newNode;
        }
    }
    return head;
}