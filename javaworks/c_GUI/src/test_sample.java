import java.util.ArrayList;
import java.util.List;

public class test_sample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("B")) {
                list.remove(i);
            }
        }
        
        System.out.println(list);
    }
}