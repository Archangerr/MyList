public class MyList<T> {
    private T[] arr;
    private int size;
    private int capacity =10;

    public MyList() {
        this.capacity=10;
        this.arr = (T[]) new Object[capacity];
        this.size=0;
    }
    public MyList(int capacity) {
        this.size = capacity;
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void add(T data){
        if (this.size == this.capacity) {
            increaseCapacity();
        }
        this.arr[this.size++] = data;
    }

    // Kapasiteyi iki katına çıkaran yardımcı metod
    private void increaseCapacity() {
        this.capacity *= 2;
        T[] newArray = (T[]) new Object[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.arr[i];
        }
        this.arr = newArray;
    }

    public T get(int index){
        if(this.arr[index]!=null)
            return arr[index];
        else
            return null;
    }

    public T remove(int index){
        if(this.arr[index]!=null){
             T removedElement=arr[index];
             for(int i =index;i< this.arr.length-1;i++){
                 this.arr[i]=this.arr[i+1];
             }
            this.arr[--size] = null;
             return removedElement;
        }
        else
            return null;
    }

    public T set(int index, T data) {
        if (index >= size || index < 0) {
            return null;
        }
        T oldElement = this.arr[index];
        this.arr[index] = data;
        return oldElement;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";  // Dizi boşsa boş liste döner
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(this.arr[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int indexOf(T data){
        for(int i =0;i <size;i++){
            if(data==this.arr[i])
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for(int i =size;i >0;i--){
            if(data==this.arr[i])
                return i;
        }
        return -1;
    }

    public void clear(){
        this.size=0;
        this.capacity=10;
        this.arr = (T[]) new Object[capacity];
    }

    public T[] toArray(){
        T[] newArray =(T[]) new Object[size];
        for(int i=0;i<size;i++)
            newArray[i]=this.arr[i];
        return newArray;
    }

    public MyList<T> subList(int start,int finish){
        if (start < 0 || finish > size || start >= finish) {
            throw new IndexOutOfBoundsException("Geçersiz indeks aralığı"); // Hatalı aralık kontrolü
        }
        MyList<T> subList=new MyList<>(finish-start);
        for(int i=start;i<finish;i++){
            subList.add(this.arr[i]);

        }
        return subList;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean contains(T data){
        for (int i = 0; i < size; i++) {
            if (this.arr[i].equals(data)) {
                return true;  // Eğer eleman bulunduysa true döner
            }
        }
        return false;
    }

    public T[] getArr() {
        return arr;
    }

    public void setArr(T[] arr) {
        this.arr = arr;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
