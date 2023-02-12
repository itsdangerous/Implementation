import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MergeSort {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("배열의 크기를 입력하세요 : ex) 10");
        int N = Integer.parseInt(br.readLine());


        System.out.println("숫자를 입력하세요 : ex) 1 2 3 4 5");
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(str[i]);
            list.add(num);
        }

        MergeSort(list);

        // 정렬 후 배열 출력
        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();


    }

    static List<Integer> MergeSort(List<Integer> arr) {
        int end = arr.size();
        int mid = (end+1)/2;

        if (arr.size() <= 1) {
            return arr;
        }
        List<Integer> left = arr.subList(0, mid);
        List<Integer> right = arr.subList(mid, end);

        List<Integer> ll = MergeSort(left);
        List<Integer> rr = MergeSort(right);

        return Merge(ll, rr);

    }

    static List<Integer> Merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int index_left = 0;
        int index_right = 0;

        while (index_left < a.size() && index_right < b.size()) {
            if (a.get(index_left) <= b.get(index_right)) {
                result.add(a.get(index_left));
                index_left++;
            } else {
                result.add(b.get(index_right));
                index_right++;
            }
        }
        if (index_left < a.size()) {
            while (index_left < a.size()) {
                result.add(a.get(index_left));
                index_left++;
            }
        } else {
            while (index_right < b.size()) {
                result.add(b.get(index_right));
                index_right++;
            }
        }

        return result;
    }


}
