static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
{
    HashSet<SinglyLinkedListNode> set = new HashSet<SinglyLinkedListNode>();

    int i = 0;
    while( head1 != null)
    {
        set.add(head1);
        i++;
        head1 = head1.next;
    }

    while( head2 != null )
    {
        i++;
        set.add(head2);

        if ( set.size() != i )
            return head2.data;

        head2 = head2.next;
    }
    return 0;

}