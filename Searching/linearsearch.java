package Searching;

public class linearsearch {
    public static void main(String[] args) {
        int[] data = {2, 2, 5, 6, 7, 8, 9, 12, 1, 0, 12, 5};

        int search = 2;

        for(int i = 0; i < data.length; i++){
            if (search == data[i]) {
                System.out.println("Number found at index: " + i);
                
            }else{
                System.out.println("Number not found");
            }
        }

       
    }
}
