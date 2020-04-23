static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode node = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        
        switch(position)
        {
            case 0:
            if(head != null)
                newNode.next = head;
            head = newNode;
            break;

            default:
            int i = 1;
            while((node.next) != null && (i < position))
            {
                node = node.next;
                i++;
            }

            newNode.next = node.next;
            node.next = newNode;
            break;
        }

        return head;

}