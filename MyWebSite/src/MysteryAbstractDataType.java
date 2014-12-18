public class  MysteryAbstractDataType  {
      private class  Node  {
          private Node(Object data)  {
               this.data = data;
        }
      private Object  data;
      private Node  next;
       }
public void  insert(Object data)  {
     if (data  !=  null) {
         Node  temp = new  Node(data);
         temp.next  = head;
         head = temp;
      }
}
public Object  remove()  {
      Object  temp = null;
       if (head !=  null) {
           temp = head.data;
           head = head.next;
        }
       return  temp;
}
private Node  head;
}