static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {

    DoublyLinkedListNode first = head;
    DoublyLinkedListNode temp = first;

    while( temp.next != null )
    {   
        temp = first.next;

        //first node
        if(first == head)
            first.next = null;
        else
            first.next = first.prev;

        first.prev = temp;
        System.out.println(" \t" + first.data + "\t" + first.prev.data);

        if ( temp.next == null)
        {
            temp.next = first;
            first = temp;
            break;
        }
        first = temp;
    }
    
    return first;
}