package serialize_;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Serializer {
    public static void main(String[] args) throws IOException {

        List<String> strings = List.of("Тарлан", "Руслан");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("sample.txt"));

        DataOutputStream dos = new DataOutputStream(bufferedOutputStream);

        dos.writeInt(strings.size());

        for (String string : strings) {
            dos.writeUTF(string);
        }

        bufferedOutputStream.flush();
        bufferedOutputStream.close();


        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("sample.txt"));

        DataInputStream dis = new DataInputStream(bufferedInputStream);

        int size = dis.readInt();

        List<String> strings2 = new ArrayList<>();

        for (int j = 0; j < size; j++) {
            strings2.add(dis.readUTF());
        }

        bufferedInputStream.close();

        System.out.println("Прочитанная коллекция " + strings2);
    }
}
