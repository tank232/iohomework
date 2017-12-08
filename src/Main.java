import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        File file1 = new File(Paths.get("").toAbsolutePath().toString(), "fstudioil.html");
        try (InputStream is = new URL("https://fstudioil.github.io").openStream();
             OutputStream os = new FileOutputStream(file1)) {
            if (!file1.exists()) {
                boolean b = file1.createNewFile();
            }
            copy(is, os);
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte data[] = new byte[1024 * 5];
        int count;
        while ((count = is.read(data, 0, 1024 * 5)) != -1) {
            os.write(data, 0, count);
        }
    }
}

