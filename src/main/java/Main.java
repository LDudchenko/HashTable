public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(4);
        hashTable.insert(86060, "Авдеевка");
        hashTable.insert(9104, "Белая Церковь");
        hashTable.insert(8600, "Васильков");
        hashTable.insert(8132, "Вишнёвое");
        hashTable.insert(84701, "Дебальцево");
        hashTable.insert(69001, "Запорожье");
        hashTable.insert(84301, "Краматорск");
        hashTable.insert(87501, "Мариуполь");
        hashTable.insert(89600, "Мукачево");
        hashTable.insert(16600, "Нежин");

        hashTable.printHashTable();
        System.out.println();
        hashTable.delete(16600);
        hashTable.delete(9104);
        hashTable.printHashTable();
        System.out.println();

        Node node = hashTable.find(87501);
        if(node!=null){
            node.printNode();
        }
        else{
            System.out.println("Нет элемента c заданным ключём!");
        }
        System.out.println();

        hashTable.insert(93100, "Лисичанск");
        hashTable.insert(82482, "Моршин");
        hashTable.insert(65001, "Одесса");
        hashTable.insert(16600, "Нежин");
        hashTable.insert(9104, "Белая Церковь");
        hashTable.printHashTable();
    }
}
