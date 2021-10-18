package geekbrains;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String path = "D:\\hw-5\\fff.csv";

        AppData data = read(path);

        write(path, data);
    }

    public static void write(String path, AppData data) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(data.toString());
        writer.close();
    }

    public static AppData read(String path) throws Exception {
        AppData f = new AppData();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String str;
        while ((str = reader.readLine()) != null) {
            if (f.hasHeaders()) {
                String[] datas = str.split(";");
                int[] datasInt = new int[datas.length];
                for (int i = 0; i < datas.length; i++) {
                    datasInt[i] = Integer.parseInt(datas[i]);
                }
                f.addDatas(datasInt);
            } else {
                f.addHeaders(str.split(";"));
            }
        }
        reader.close();

        return f;
    }
}
