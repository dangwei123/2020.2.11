public class MyStack<E> {
    private Object[] element;
    private int size;

    public MyStack(){
        this.element=new Object[100];
        this.size=0;
    }

    public void push(E e){
        element[size++]=e;
    }

    public E pop(){
        if(size==0){
            return null;
        }
        E e=(E)element[size-1];
        size--;
        return e;
    }

    public E peek(){
        if(size==0){
            return null;
        }
        return (E)element[size-1];
    }

    public boolean empty(){
        return 0==size;
    }

    public int size(){
        return size;
    }
}



public class MyQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public MyQueue(){

    }

    public void offer(E e){
        Node<E> last=rear;
        Node<E> node=new Node<>(rear,e,null);
        rear=node;
        if(last==null){
            front=node;
        }else{
            last.next=rear;
        }
        size++;
    }

    public E poll(){
        if(size==0){
            return null;
        }
        E e=front.element;
        Node<E> node=front.next;
        node.element=null;
        node.next=null;
        front=node;
        if(front==null){
            rear=null;
        }
        size--;
        return e;
    }

    public E peek(){
        return front==null?null:front.element;
    }

    public boolean isEmpty(){
        return 0==size;
    }

    public int size(){
        return size;
    }
}
