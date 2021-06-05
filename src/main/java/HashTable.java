import java.util.ArrayList;

public class HashTable {
    private ArrayList<LinkedList> hashArray = new ArrayList<>();
    private int size;
    private int countOfNotes;
    private double coefficientOfFilling;

    public HashTable(int s){
        size = s;
        for(int i=0; i<size; i++){
            hashArray.add(i,new LinkedList());
        }
    }

    public void printHashTable(){
        for(int j=0; j<size; j++){
            System.out.print("["+j+"]");
            hashArray.get(j).printList();
        }
    }

    public int hashFunc(int key){
        int h = (int)(((key*0.618033)%1)*size);
        return h;
    }

    public void coeffiicientOfFilling(){
        coefficientOfFilling = (double)countOfNotes/size;
    }

    public void insert(int key, String data){
        if(this.find(key)!=null){
            System.out.println("Элемент с ключём "+key+" уже существует!");
            return;
        }
        int hashVal=hashFunc(key);
        hashArray.get(hashVal).insertEnd(key, data);
        countOfNotes++;
        coeffiicientOfFilling();
        if(coefficientOfFilling>3){
            this.reHash();
        }
    }

    public void delete(int key){
        int hashVal = hashFunc(key);
        if(hashArray.get(hashVal).removeElement(key)==0){
            countOfNotes--;
        }else{
            System.out.println("Нет элемента с ключём: "+key+"!");
        }
    }

    public Node find(int key){
        int hashVal = hashFunc(key);
        Node node = hashArray.get(hashVal).findElement(key);
        return node;
    }

    public void reHash(){
        int tempSize = size;
        size*=2;
        countOfNotes = 0;
        ArrayList<LinkedList> temp = new ArrayList<>(hashArray);
        for(int i=0; i<size; i++){
            hashArray.add(i,new LinkedList());
        }
        for(int i =0; i<tempSize; i++){
            Node current = temp.get(i).getStart();
            while(current!=null){
                this.insert(current.key, current.data);;
                current = current.next;
            }
        }
    }
}


