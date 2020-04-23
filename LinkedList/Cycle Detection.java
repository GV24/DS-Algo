static boolean hasCycle(SinglyLinkedListNode head) {

    HashSet<SinglyLinkedListNode> set = new HashSet<>();
    int i = 0;
    while(head != null)
    {
        set.add(head);
        i++;
        if( i > set.size())
            return true;
        head = head.next;
    }
    return false;

}