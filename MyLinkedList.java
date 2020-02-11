class Node<E> {
    public Node<E> pre;
    public E element;
    public Node<E> next;
    public Node(Node<E> pre,E element,Node<E> next){
        this.pre=pre;
        this.element=element;
        this.next=next;
    }
    public Node(E element){
        this(null,element,null);
    }
}
public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList(){

    }

    public void addFirst(E e){
        Node<E> first=head;
        Node<E> node=new Node<>(null,e,head);
        head=node;
        if(first==null){
            tail=node;
        }else{
            first.pre=head;
        }
        size++;
    }
    public void addLast(E e){
        Node<E> last=tail;
        Node<E> node=new Node<>(tail,e,null);
        tail=node;
        if(last==null){
            head=node;
        }else{
            last.next=node;
        }
        size++;
    }

    public boolean addBefore(E e,Node<E> suc){
        if(suc==head){
            addFirst(e);
        }else{
            Node<E> node=new Node<>(e);
            node.pre=suc.pre;
            suc.pre.next=node;
            node.next=suc;
            suc.pre=node;
        }
        size++;
        return true;
    }

    public E removeFirst(){
        if(head==null){
            return null;
        }
        E val=head.element;
        Node<E> next=head.next;
        head.element=null;
        head.next=null;
        head=next;
        if(head==null){
            tail=null;
        }
        size--;
        return val;
    }

    public E removeLast(){
        if(tail==null){
            return null;
        }
        E val=tail.element;
        Node<E> node=tail.pre;
        tail.pre=null;
        tail.element=null;
        tail=node;
        if(tail==null){
            head=null;
        }
        size--;
        return val;
    }
    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("illegal:"+index);
        }
        if(index==0){
            return removeFirst();
        }
        if(index==size-1){
            return removeLast();
        }
        Node<E> cur=head;
        while(index!=0){
            cur=cur.next;
            index--;
        }
        cur.pre.next=cur.next;
        cur.next.pre=cur.pre;
        E e=cur.element;
        cur.pre=null;
        cur.element=null;
        cur.next=null;
        return e;
    }

    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("illegal:"+index);
        }
        Node<E> cur=head;
        while(index!=0){
            cur=cur.next;
            index--;
        }
        return cur.element;
    }

    public void set(int index,E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("illegal:"+index);
        }
        Node<E> cur=head;
        while(index!=0){
            cur=cur.next;
            index--;
        }
        cur.element=e;
    }

    public boolean isEmpty(){
        return 0==size;
    }
    
    public int size(){
        return size;
    }


    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        Node<E> cur=head;
        while(cur!=null){
            sb.append(cur.element).append(" ");
            cur=cur.next;
        }
        return new String(sb);
    }
}


public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> list=new MyLinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);
        list.removeLast();
        list.removeLast();
        System.out.println(list);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}