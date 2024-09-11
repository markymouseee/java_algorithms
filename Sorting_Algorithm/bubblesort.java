package Sorting_Algorithm;

public class bubblesort {
    public static void main(String[] args) {
        int[] data = {2, 9, 10, 11, 8, 7, 6, 1, 0, 5, 3, 4, 12};

        int temp;
        for(int i = 0; i < data.length - 1; i++){
            for(int j = 0; j < data.length - i - 1; j++){
                if(data[j] > data[j + 1]){
                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }

        for(int Data: data){
            System.out.print(Data + ", ");
        }
    }
}
