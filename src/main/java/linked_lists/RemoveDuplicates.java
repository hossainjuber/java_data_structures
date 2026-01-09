public class RemoveDuplicates {

    public static void main(String[] str){

        LinkedList l5 = new LinkedList(4, null);
        LinkedList l4 = new LinkedList(4, l5);
        LinkedList l3 = new LinkedList(5, l4);
        LinkedList l2 = new LinkedList(4, l3);
        LinkedList l1 = new LinkedList(5, l2);
        printLinkedList(l1);
        removeDuplicates(l1);
        printLinkedList(l1);
    }

    public static void printLinkedList(LinkedList l){
        StringBuffer sb = new StringBuffer();
        while(l!=null){
            sb.append(String.valueOf(l.getValue()));
            sb.append("->");
            l = l.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
        System.out.println("********Done*******");
    }

    public static void removeDuplicates(LinkedList node){
        while(node!=null){
            LinkedList runner = node;
            while(runner.next!=null){
                if(runner.next.getValue()==node.getValue()){
                    runner.next = runner.next.next;
                }else{
                    runner=runner.next;
                }
            }

            node = node.next;
        }
    }



    public static class LinkedList{
        private int value;
        private LinkedList next;

        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }

        public LinkedList(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public LinkedList getNext() {
            return next;
        }

        public void setNext(LinkedList next) {
            this.next = next;
        }
    }
}


