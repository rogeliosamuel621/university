package albertico;

public class Ordybusq <T> {

    public void Seleccion(int[] data) {
        int min;
        int temp;
        for (int i = 0; i < data.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < data.length; j++)
                if (data[j] < data[min])
                    min = j;

            temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
    }

    static public void OrdenInsercion( int [] v)
    {  int i,j,aux;
        for( i=1; i< v.length ; i++)
        {
            j=i;
            aux=v[i];
            while (j>0 && aux < v[j-1])
            {
                v[j]=v[j-1];
                j--;
            }
            v[j]=aux;
        }
    }

    static public void Burbuja (int [] v){
        int superior, temp;
        boolean bandera=true;
        superior=v.length;

        while (bandera)
        {  bandera=false;
            superior--;
            for(int i=0 ; i < superior ; i ++)
            {  if (v[i] > v[i+1])
            {
                temp=v[i];
                v[i]=v[i+1];
                v[i+1]=temp;
                bandera=true;
            }
            }
        }
    }

    public void quickSort(T[] data, int min, int max) {
        int indexofpartition;

        if(max - min > 0) {
            indexofpartition = findPartition(data, min, max);
            quickSort(data, min, indexofpartition - 1);
            quickSort(data, indexofpartition + 1, max);
        }
    }

    private int findPartition(T[] data, int min, int max) {
        int left, right;
        T temp, partitionElement;

        partitionElement = data[min];
        left = min;
        right = max;

        while(left<right){
            while(data[left].compareTo(partitionElement) <= 0 && left < right)
                left++;

            while(data[right].compareTo(partitionElement) > 0)
                right--;
            if(left < right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }

        temp = data[min];
        data[min] = data[right];
        data[right] = temp;

        return right;
    }

    public void Mezcla (T[] data, int min, int max) {
        T[] temp;
        int index1, left, rigth;

        if(min == max)
            return;

        int size = max - min + 1;
        int pivot = (min + max)/2;

        temp = (T[])(new Comparable[size]);
        Mezcla(data, min, pivot);

        Mezcla(data, pivot + 1, max);

        for(index1 = 0; index1 < size; index1++)
            temp[index1] = data[min + index1];

        left = 0;
        rigth = pivot - min + 1;

        for(index1 = 0; index1 < size; index1++) {
            if(rigth <= max- min)
                if(left <= pivot - min)
                    if(temp[left].compareTo(temp[rigth]) > 0)
                        data[index1 + min] = temp[rigth++];
                    else
                        data[index1 + min] = temp[left++];
                else
                    data[index1 + min] = temp[rigth++];
            else
                data[index1 + min] = temp[rigth++];
        }

    }


    public boolean Lineal (T[] data, int min, int max, T target){
        int index = min;
        boolean found = false;

        while(!found && index <= max) {
            if(data[index].compareTo(target) == 0) {
                found = true;
                index++;
            }
        }
        if(found == true)
            System.out.println("valor encontrado");
        else
            System.out.println("valor no encontrado");
        return found;
    }

    public boolean Binaria (T [] data, T target, int min, int max)
    {
        boolean found = false;
        int midpoint = (min + max) / 2;

        if (data[midpoint].compareTo(target) == 0)
            found = true;
        else if (data[midpoint].compareTo(target)  > 0) {
            if(min <= midpoint - 1)
                found = Binaria(data, target, midpoint - 1, min);
        }
        else if(midpoint + 1 <= max)
            found = Binaria(data, target, midpoint + 1, min);

        if(found == true)
            System.out.println("valor encontrado");
        else
            System.out.println("valor no encontrado");


        return found;
    }

}
