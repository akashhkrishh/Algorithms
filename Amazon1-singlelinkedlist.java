import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SinglyLinkedListNode {
    public String data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(String nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(String nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(node.data);

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}


class Result {

    /*
     * Complete the 'finalCart' function below.
     *
     * The function is expected to return a STRING_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. STRING_SINGLY_LINKED_LIST head
     *  2. 2D_STRING_ARRAY queries
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     String data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode finalCart(SinglyLinkedListNode head, List<List<String>> queries) {
    // Write your code here
        SinglyLinkedListNode tail = head;
        if(tail != null){
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        for(List<String> query:queries){
            String cmd = query.get(0);
            String itemName = query.size()>1? query.get(1):null;
            
            // System.out.println(itemName);
            switch (cmd) {
                case "PUSH_HEAD":
                    SinglyLinkedListNode newHead = new SinglyLinkedListNode(itemName);
                    newHead.next = head;
                    head = newHead;
                    if(tail == null){
                        tail = head;
                    }
                    break;
                case "PUSH_TAIL":
                    SinglyLinkedListNode newTail = new SinglyLinkedListNode(itemName);
                    if(tail == null){
                        head = newTail;
                        tail = newTail;
                    }else{
                        tail.next = newTail;
                        tail = newTail;
                    }
                    break;
                case "POP_HEAD":
                    // System.out.println("Pop");
                    if(head != null){
                        head = head.next;
                        if(head==null){
                            tail = null;
                        }
                    }
                    break;
                
            }
            
        }
        
        return head;

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList head = new SinglyLinkedList();

        int headCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, headCount).forEach(i -> {
            try {
                String headItem = bufferedReader.readLine();

                head.insertNode(headItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int queriesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> queries = new ArrayList<>();

        IntStream.range(0, queriesRows).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        SinglyLinkedListNode result = Result.finalCart(head.head, queries);

        SinglyLinkedListPrintHelper.printList(result, "\n", bufferedWriter);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
