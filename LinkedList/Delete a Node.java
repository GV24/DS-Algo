static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {

    SinglyLinkedListNode node = head;

    switch(position)
    {
        case 0:
            head = head.next;
        break;


        default:
            int i = 1;
            while( (node.next != null) && (i < position) )
            {
                node = node.next;
                i++;
            }
            node.next = node.next.next;
        break;
    }

    return head;

}