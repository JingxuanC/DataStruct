import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList=new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",arrayList);
        System.out.println(arrayList.size());
    }
}
