/**
 * @author markymouseee
 **/

package Searching;

import java.util.Arrays;
public class binarysearch {
    public static void main(String[] args) {
        int[] data = {5, 2, 1, 4, 6, 3, 8, 7, 10, 9, 11, 7};

        System.out.println("Not sorted");
        for (int i : data) { 
            System.out.println(i);
        }

        Arrays.sort(data);

        System.out.println("Sorted");
        for (int i : data) {
            System.out.println(i);
        }
        
        int search = 9;

        int start_index = 0;
        int end_index = data.length - 1;

        while(start_index <= end_index){
            int middle_index = (start_index + end_index) / 2;

            if(search == data[middle_index]){
                System.out.println("Number found at index: " + middle_index);
                return;
            }else if(search < data[middle_index]){
                end_index = middle_index - 1;
                System.out.println("Number not found");
            }else{
                start_index = middle_index + 1;
                System.out.println("Number not found");
            }
        }

        System.out.println("Number not found");
    }
}
