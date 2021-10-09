package priority_queue;

/**
 * 2*n left child
 * 2*n+1 right child
 * round (n/2) someone's parent
 * n is equal to array position
 */

public class PriorityQueue {
    PriorityNode[] data;
    int size;
    private int limit;

    private final int DEFAULT_LIMIT = 12;
    private final int INITIAL_SIZE = 0;


    public PriorityQueue(int limit) {
        this.data = new PriorityNode[limit];
        this.limit = limit | this.DEFAULT_LIMIT;
        this.size = INITIAL_SIZE;
    }

    /**
    public void push(int priority, String value) {
        PriorityNode newNode = new PriorityNode(priority, value);
        this.size++;

        if (this.isEmpty()) {
            data[size] = newNode;
            return;
        }

        int position = this.size;
        data[position] = newNode;
    }
    */

    public void push(int priority, String value){

        if (this.isFull()) {
            System.out.println("Is full");
            return;
        }
        //creamos nodo a insertar
        PriorityNode nodeToInsert = new PriorityNode(priority, value);
        //aumentamos el tamaño de la cola priorizada
        this.size++;
        //si es el primero lo ponemos en la posición 1 y listo
        if (size ==1){
            data[size] = nodeToInsert;
        } else {
            //Si no está vacía la cola priorizada
            //la posición temporal es la última
            int myPosition = size;
            //ponemos el nodo ahí
            data[myPosition] = nodeToInsert;
            //encontramos la posición del padre
            int myParentPosition =(int)(myPosition/2);
            //Y guardamos el valor del padre
            PriorityNode myParent= data[myParentPosition];
            //repetimos intercambiar el padre con el hijo hasta que el padre
            //tenga mayor prioridad que el hijo

            while (myPosition!=1&& myParent.getPriority()>nodeToInsert.getPriority()
            ){
                data[myPosition] = myParent;
                data[myParentPosition] = nodeToInsert;
                myPosition =myParentPosition;
                myParentPosition = (int)(myParentPosition/2);
                myParent= data[myParentPosition];
            }
        }
    }

    public void show() {
        for(int i=1; i<=this.size; i++) {
            System.out.println(data[i].getValue());
        }
    }

    private void insertAtFirstPosition(String value) {
        PriorityNode newNode = new PriorityNode(1, value);

        this.data[this.size] = newNode;
        this.upgradeSize();
    }

    private int getParentPosition(int position) {
        return (int)(position / 2);
    }

    private boolean isEmpty(){
        return this.size == this.INITIAL_SIZE;
    }

    private boolean isFull() {
        return this.size == this.limit;
    }

    private void upgradeSize() {
        this.size++;
    }

    private void downgradeSize() {
        this.size--;
    }
}
