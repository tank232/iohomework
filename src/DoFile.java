import javafx.css.Match;

import java.io.*;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class DoFile {
    private static AtomicInteger atomicInt = new AtomicInteger(0);

    public void writeToFile(String str) throws IOException {
        File folder = Main.getFolder();
        if (!folder.exists()) {
            folder.mkdir();
        }
        File file1 = new File(folder.toString(), "file-" + atomicInt.getAndIncrement()+".txt");
        if (!file1.exists()) {
            boolean b = file1.createNewFile();
        }
        OutputStream os = new FileOutputStream(file1);
        os.write(str.getBytes(), 0, str.length());
        os.close();
    }

    public void findToFile(File file,String str) throws IOException {
        byte[] content = new byte[5*1024];
        FileInputStream fis = new FileInputStream(file);
        int count;
        while ((count = fis.read(content, 0, 1024 * 5)) != -1) {
            if(new String(content, "Cp1251").indexOf(str)!= -1)
            {  System.out.println(file.getName());
                fis.close();
                return;
            }

        }
        fis.close();
    }
}
