static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

    SinglyLinkedListNode nodeA = head1;
    SinglyLinkedListNode nodeB = head2;
    SinglyLinkedListNode head = null;
    SinglyLinkedListNode node = null;
    
    while( (nodeA != null) && (nodeB != null) )
    {
        int data = 0;
        if(nodeA.data > nodeB.data)
        {
            data = nodeB.data;
            nodeB = nodeB.next;
        }
        else
        {
            data = nodeA.data;
            nodeA = nodeA.next;  
        }

        if( head == null)
        {
            head = new SinglyLinkedListNode(data);
            node = head;
        }
        else
        {
            node.next = new SinglyLinkedListNode(data);
            node = node.next;
        }
        
    }

    if(nodeA == null)
    {
        while(nodeB != null)
        {
            node.next = new SinglyLinkedListNode(nodeB.data);
            nodeB = nodeB.next;
            node = node.next;
        }
    }

    if(nodeB == null)
    {
        while(nodeA != null)
        {
            node.next = new SinglyLinkedListNode(nodeA.data);
            nodeA = nodeA.next;
            node = node.next;
        }
    }

    return head;
}