/**
  Represent a list, implemented in a chain of nodes
 */

public class List_inChainOfNodes{
    private Node headReference;

    /**
      Construct an empty list
     */
     public List_inChainOfNodes(){
       headReference = null;
     }


    /**
      @return the number of elements in this list
     */
    public int size() {
      if(headReference == null)
        return 0;
      else return size(headReference);
     }

     private int size(Node node0){
       if(node0.getReferenceToNextNode() == null)
        return 1;
      else return size(node0.getReferenceToNextNode()) + 1;
     }


     /**
       @return a string representation of this list,
       format:
           # elements [element0,element1,element2,]
      */
     public String toString() {
       if (headReference == null) return "size: 0, list: []";
       else {
         String returned = "size: " +size() + ", list: [";
         returned += toString(headReference) + "]";
         return returned;
       }
     }

     private String toString( Node node) {
        if (node.getReferenceToNextNode() == null)
            return node.getCargoReference() + ",";
        else
            return node.getCargoReference() + ","
                + toString(node.getReferenceToNextNode());
    }

     private Node getNode(int index){
        Node node1;
        int counter;
        for (node1 = headReference , counter = 0;
            counter < index;
            node1 = node1.getReferenceToNextNode() , counter++);
        return node1;
      }

    /**
      Append @value to the head of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean addAsHead( Object val) {
        Node head = new Node(val);
        head.setReferenceToNextNode(headReference);
        headReference = head;
        return true;
     }

     public boolean add(int index, Object val){
       if (index == 0)
          addAsHead(val);
       else {
         Node element = new Node(val, getNode(index));
         getNode(index - 1).setReferenceToNextNode(element);
       }
       return true;
     }

     public Object set(int index, Object val){
       Object result = getNode(index).getCargoReference();
       getNode(index).setCargoReference(val);
       return result;
     }

     public Object get(int index){
       return getNode(index).getCargoReference();
     }
}
