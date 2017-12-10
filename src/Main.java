import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Main {

    static File folder = new File(Paths.get("").toAbsolutePath().toString() + File.separator + "files");

    public static File getFolder() {
        return folder;
    }

    public static void main(String[] args) {
        Menu menuValue = Menu.WRITE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(Paths.get("").toAbsolutePath().toString(), "fstudioil.html");
        try {
            while (menuValue != Menu.EXIT) {
                printMenu();
                menuValue = Menu.getMenu(Integer.parseInt(br.readLine()));
                System.out.println("***********"+ menuValue+"**************");
                switch (menuValue) {
                    case WRITE:
                        writeToFiles(br);
                        break;
                    case FIND:
                        findToFiles(br);
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeToFiles(BufferedReader br) throws IOException {
        System.out.println("Пишем по одно йстроке в файл. Выход -1");
        String str = br.readLine();

        while (!str.equals("-1")) {
            DoFile doFile = new DoFile();
            String finalStr = str;
            Thread th = new Thread(() -> {
                try {
                    doFile.writeToFile(finalStr);
               } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            th.start();
            str = br.readLine();
        }
    }

    private static void findToFiles(BufferedReader br) throws IOException {
        System.out.println("Что ищем: ");
        String str = br.readLine();
        DoFile doFile = new DoFile();
        System.out.println("Найдено: ");
        if (!folder.exists()) {
            return;
        }
        File[] fList = folder.listFiles();
        for (File aFList : fList) {
            if (aFList.isFile()) {
                Thread th = new Thread(() -> {
                    try {
                        doFile.findToFile(aFList, str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                th.start();
                try {
                    th.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        System.out.println("***********Поиск закончен***********");
    }

    private static void printMenu() {
        for (Menu menuValue : Menu.values()) {
            System.out.println(menuValue);
        }
    }


}

