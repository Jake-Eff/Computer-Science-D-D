public class DoublyLinkedListTester {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(Nucleotide.T);
        list.add(Nucleotide.A);
        list.add(Nucleotide.C);
        list.add(Nucleotide.G);
        list.add(Nucleotide.T);
        list.deleteLastThree();
        System.out.println(list);
    }
}
