package geekbrains;

import java.util.Arrays;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData() {
        header = new String[0];
        data = new int[0][0];
    }

    public void addHeaders(String[] h) {
        header = h;
    }

    public void addDatas(int[] d) {
        List<int[]> list = Arrays.asList(data);
        list.add(d);
        data = list.toArray(new int[0][0]);
    }

    public boolean hasHeaders() {
        return header.length > 0;
    }

    @Override
    public String toString() {
        String result = String.join(";", header) + "\n";
        for (int[] i : data) {
            result += myJoin(";", i) + "\n";
        }
        return result;
    }

    public static String myJoin(String separator, int[] arr) {
        if (null == arr || 0 == arr.length) return "";

        StringBuilder sb = new StringBuilder(256);
        sb.append(arr[0]);

        for (int i = 1; i < arr.length; i++) sb.append(separator).append(arr[i]);

        return sb.toString();
    }
}