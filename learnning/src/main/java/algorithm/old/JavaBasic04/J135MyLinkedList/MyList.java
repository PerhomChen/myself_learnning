package JavaBasic04.J135MyLinkedList;

/**
 * 双向链表实现LinkedList
 */
public class MyList {

    //头结点
    private Node frist ;
    //尾节点
    private Node last;
    private int size;

    public Node getFrist() {
        return frist;
    }

    public void setFrist(Node frist) {
        this.frist = frist;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    //size
    public int size(){
        return size;
    }
    //构造方法
    // add方法
    public void add(Object obj){

        //判断是否为头结点
        if(frist==null){
            //设置头结点
            Node node = new Node();
            node.setPervious(null);
            node.setNext(null);
            node.setObject(obj);
            frist = node;
            //设置尾节点
            last = frist;
            size++;
        }else{
            //设置尾节点
            Node node = new Node();
            node.setPervious(last);
            node.setObject(obj);
            node.setNext(null);
            //原先尾节点指向新增节点
            last.setNext(node);
            //更新last指针
            last = node;
            size ++;
        }
    }

    //get方法---遍历

    public Object get(int index){

        Node node = getNode(index);

        return node.getObject();
    }

    //封装get index Node的方法
    //使用二分查找优化遍历效率
    public Node getNode(int index){
        if(checkIndex(index)){

            if(index<=size/2){

                Node temp = frist;
                for (int i=1;i<=index;i++) {
                    temp = temp.getNext();

                }
                return temp;
            }else{
                Node temp = last;
                for (int i=size-1;i>index;i--) {
                    temp = temp.getPervious();

                }
                return temp;
            }

        }
        return null;
    }

    //insert方法
    public void insert(int index,Object obj){
        //取出那个节点
        Node node = getNode(index);
        //新节点
        Node newnode = new Node();
        newnode.setObject(obj);
        //前节点
        Node pervious = node.getPervious();

        //前节点与新节点建立关系
        pervious.setNext(newnode);
        newnode.setPervious(pervious);
        //新节点与后节点建立关系
        newnode.setNext(node);
        node.setPervious(newnode);

        size++;
    }

    public void remove(int index){
        if(checkIndex(index)){
            //得到节点
            Node node = getNode(index);
            //得到前节点
            Node pervious = node.getPervious();
            //得到后节点
            Node next = node.getNext();

            pervious.setNext(next);
            next.setPervious(pervious);

            size--;
        }
    }

    //检查索引
    public boolean checkIndex(int index){
        if(index >=0&& index<size){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyList ml = new MyList();
        ml.add("aaaa");
        ml.add("bbbb");
        System.out.println(ml.size());
        System.out.println(ml.get(0));

        System.out.println("*******************************");
        ml.insert(1,"ccccc");
        System.out.println(ml.get(1));
        ml.add("2cc3cc");
        ml.add("ddddd");
        System.out.println(ml.get(4));
        Node node =ml.getLast();
        System.out.println(node.getObject());
        System.out.println("###################");
        System.out.println(ml.get(2));
        ml.remove(2);
        System.out.println(ml.get(2));
    }
}


