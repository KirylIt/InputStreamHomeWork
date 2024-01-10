import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Прочитайте несколько строк с консоли.
        // Если их длина составляет больше n (n выбираете сами),
        // то записать их в файл, в ином случае пропустить.

            int n = 25;
            int colString;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите количество строк: ");
            colString = scanner.nextInt();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            String[] str = new String[colString];
            for (int i = 0; i < colString; i++) {
                str[i] = reader.readLine();
            }
        System.out.println("Вы ввели строки: ");
            try {
                for (int i = 0; i < str.length; i++) {
                    System.out.println(str[i]);
                }
                System.out.println("Идет проверка файла ");
                if (!(Files.exists(Path.of("readme.txt")))) {
                    Files.createFile(Path.of("readme.txt"));
                    System.out.println("Файл создан " + "readme.txt");
                }
                System.out.println("Проверка файла успешна ");
                File file = new File("readme.txt");
                FileWriter writer = new FileWriter(file);

                System.out.println("Идёт запись файла");
                for (String len : str){
                    if (len.length() >= n) {
                        writer.write(len);
                        writer.write("\n");
                    }else
                        System.out.println("Запись файла невозможна, так как длина строки меньше " + n);
                }
                System.out.println("Файл записан ");
                writer.close();
                System.out.println("Чтение файла: ");
                FileInputStream fileInputStream = new FileInputStream(file);
                int read;
                while ((read = fileInputStream.read()) != -1){
                    System.out.print((char) read);
                }
            }catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Error");
            }
    }
}
