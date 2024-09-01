import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] name = {"xxe", "atrider", "linkz", "clinkz", "awnbreaker", "nigma", "celessVoid", "rocopter"};

        for(String names: name){
            System.out.print(" " + names + ",");
        }
        System.out.println();

        String holder;
        for(int i = 0; i < name.length - 1; i++){
            for(int j = 0; j < name.length - i - 1; j++){
                if(name[j].compareTo(name[j + 1]) > 0){
                    holder = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = holder;
                }
            }
        }

        String findName = "linkz";

        int start_index = 0;
        int end_index = name.length - 1;
        int middle_index = (start_index + end_index) / 2;

        while(start_index <= end_index){
            middle_index = (start_index + end_index) / 2;
            if(findName == name[middle_index]){
                System.out.println("Name Found at index: " + middle_index);
                return;
            }else if(findName.compareTo(name[middle_index]) < 0){
                end_index = middle_index - 1;
            }else{
                start_index = middle_index + 1;
            }
        }
        System.out.println("Name not found");
    }
}
