package project_1;

import java.util.Scanner;

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
    int minTimeForPush = 0;
    int maxTimeForPush = 3;

    int minTimeForPop = 3;
    int maxTimeForPop = 3;


    private final int INITIAL_SIZE = 1;


    public PriorityQueue(int limit) {
        this.data = new PriorityNode[limit];
        this.limit = limit;
        this.size = INITIAL_SIZE;
    }

    public void push(int priority, String value) {
        if (this.isFull()) {
            System.out.println("La cola esta llena");
            return;
        }

        if (isEmpty()) {
            this.insertAtFirstPosition(priority, value);
            return;
        }

        int currentPosition = this.size;
        PriorityNode newNode = new PriorityNode(priority, value);

        data[currentPosition] = newNode;
        this.upgradeSize();

        int parentPosition = this.getParentPosition(currentPosition);
        PriorityNode parentNode = this.data[parentPosition];

        while (currentPosition != this.INITIAL_SIZE && parentNode.getPriority() > newNode.getPriority()) {
            // exchange
            this.data[currentPosition] = parentNode;
            this.data[parentPosition] = newNode;

            // update positions
            currentPosition = parentPosition;
            parentPosition = this.getParentPosition(currentPosition);

            // get new parentNode
            parentNode = this.data[parentPosition];
        }

        this.orderBrothers(parentPosition);
        System.out.println("nodo insertado");
    }

    public void pop() {
        if (this.isEmpty()) {
            System.out.println("La cola esta vacia");
            return;
        }

        if (this.size == 2) {
            this.data[this.size - 1] = null;
            this.downgradeSize();
            return;
        }

        int currentPosition = this.INITIAL_SIZE;
        int lastPosition = this.size - 1;

        PriorityNode lastNode = this.data[lastPosition];

        this.data[currentPosition] = lastNode;
        this.data[lastPosition] = null;

        int leftChildPosition = 2 * currentPosition;
        int rightChildPosition = 2 * currentPosition + 1;

        PriorityNode leftChild = this.data[leftChildPosition];
        PriorityNode rightChild = this.data[rightChildPosition];

        while (rightChild != null || leftChild != null) {
            leftChildPosition = 2 * currentPosition;
            rightChildPosition = 2 * currentPosition + 1;

            leftChild = this.data[leftChildPosition];
            rightChild = this.data[rightChildPosition];

            boolean hasTwoChildren = leftChild != null && rightChild != null;

            if (!hasTwoChildren) break;

            if (leftChild == null) {
                if (!(rightChild.getPriority() < lastNode.getPriority())) {
                    this.data[rightChildPosition] = lastNode;
                    this.data[currentPosition] = rightChild;
                    currentPosition = rightChildPosition;
                    continue;
                }
            }

            if (rightChild == null) {
                if (!(leftChild.getPriority() < lastNode.getPriority())) {
                    this.data[leftChildPosition] = lastNode;
                    this.data[currentPosition] = leftChild;
                    currentPosition = leftChildPosition;
                    continue;
                }
            }


            boolean lastNodeHasMorePriority =
                    lastNode.getPriority() < leftChild.getPriority() &&
                    lastNode.getPriority() < rightChild.getPriority();

            if (lastNodeHasMorePriority) {
                break;
            }

            if (rightChild.getPriority() < leftChild.getPriority()) {
                this.data[rightChildPosition] = lastNode;
                this.data[currentPosition] = rightChild;
                currentPosition = rightChildPosition;

                continue;
            }

            this.data[leftChildPosition] = lastNode;
            this.data[currentPosition] = leftChild;
            currentPosition = leftChildPosition;
        }

        this.downgradeSize();
    }

    public void show() {
        System.out.println("Nombre" + "\t\t\t" + "Prioridad");
        for(int i=this.INITIAL_SIZE; i<this.size; i++) {
            System.out.println(data[i].getValue() + "\t\t\t" + data[i].getPriority());
        }
    }

    public void mostrarMenu() {
        int OPCION=0;
        Scanner leer = new Scanner(System.in);
        do
        {
            System.out.println("1.-Establecer el tope de la cola");
            System.out.println("2.-Establecer el rango de tiempo en el que se ingresan datos");
            System.out.println("3.-Establecer el rango de tiempo de servicio del servidor");
            System.out.println("4.-Iniciar");
            System.out.println();


            System.out.print("SELECCIONA UNA OPCION: ");
            OPCION=leer.nextInt();

            this.makeAction(OPCION);

        }while(OPCION !=4);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private void makeAction(int action) {
        switch (action) {
            case 1:
                this.setLimitAction();
                break;
            case 2:
                this.setTimeForPushAction();
                break;
            case 3:
                this.setTimeForPopAction();
                break;
            case 4:
                this.start();
                break;
            default:
                System.out.println("Esa opcion no esta disponible, escoga otra");
        }
    }

    private void setLimitAction() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite el limite de la cola");
        int newLimit = sc.nextInt();

        this.setLimit(newLimit);
    }

    private void setTimeForPushAction() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite el tiempo minimo");
        int minTime = sc.nextInt();

        System.out.println("Digite el tiempo maximo");
        int maxTime = sc.nextInt();

        if (minTime >= maxTime) {
            System.out.println("El tiempo minimo debe ser menor que el tiempo maximo");
            return;
        }

        this.minTimeForPush = minTime;
        this.maxTimeForPush = maxTime;
    }

    private void setTimeForPopAction() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite el tiempo minimo");
        int minTime = sc.nextInt();

        System.out.println("Digite el tiempo maximo");
        int maxTime = sc.nextInt();

        if (minTime >= maxTime) {
            System.out.println("El tiempo minimo debe ser menor que el tiempo maximo");
            return;
        }

        this.minTimeForPop = minTime;
        this.maxTimeForPop = maxTime;
    }

    private void start() {
/*        System.out.println("start...");
        System.out.println("Limite: " + this.limit);
        System.out.println("Tiempo minimo para push: " + this.minTimeForPush);
        System.out.println("Tiempo maximo para push: " + this.maxTimeForPush);
        System.out.println("Tiempo minimo para pop: " + this.minTimeForPop);
        System.out.println("Tiempo maximo para pop: " + this.maxTimeForPop);*/

        int totalSeconds = 0;

        while (totalSeconds <= 180) {
            boolean hasToPush = this.getHasToPush();
            int timeToWait = hasToPush ? getTimeToPush() : getTimeToPop();

        }

    }

    private int getTimeToPush() {
        return (int)(Math.random() * this.maxTimeForPush + this.minTimeForPush);
    }

    private int getTimeToPop() {
        return (int)(Math.random() * this.maxTimeForPop + this.minTimeForPop);
    }

    private boolean getHasToPush() {
        int num = (int)(Math.random() * 2 + 1);

        return num == 1;
    }

    private void orderBrothers(int parentPosition) {
        int leftChildPosition = 2 * parentPosition;
        int rightChildPosition = 2 * parentPosition + 1;

        PriorityNode leftChild = this.data[leftChildPosition];
        PriorityNode rightChild = this.data[rightChildPosition];


        if(leftChild == null || rightChild == null) return;

        if (rightChild.getPriority() < leftChild.getPriority()) {
            this.data[leftChildPosition] = rightChild;
            this.data[rightChildPosition] = leftChild;
        }
    }

    private void insertAtFirstPosition(int priority, String value) {
        PriorityNode newNode = new PriorityNode(priority, value);

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
