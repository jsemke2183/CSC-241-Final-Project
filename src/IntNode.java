public class IntNode {
   private int dataVal;         // Node data
   private IntNode nextNodeRef; // Reference to the next node

   public IntNode() {
      dataVal = 0;
      nextNodeRef = null;
   }

   // Constructor
   public IntNode(int dataInit) {
      this.dataVal = dataInit;
      this.nextNodeRef = null;
   }

   /* Insert node after this node.
    Before: this -- next
    After:  this -- node -- next
    */
   public void insertAfter(IntNode nodeLoc) {
      IntNode tmpNext;

      tmpNext = this.nextNodeRef;
      this.nextNodeRef = nodeLoc;
      nodeLoc.nextNodeRef = tmpNext;
   }

   // Get location of nextNodeRef
   public IntNode getNext() {
      return this.nextNodeRef;
   }

   public void printNodeData() {
      System.out.println(this.dataVal);
   }
}