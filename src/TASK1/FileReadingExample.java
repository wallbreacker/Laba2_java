package TASK1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReadingExample {
    public static void main(String[] args) {
        // Определение пути к файлу
        Path filePath = Paths.get("example.txt");

        try {
            // Чтение содержимого файла
            List<String> lines = Files.readAllLines(filePath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("При чтении файла произошла ошибка.");
            e.printStackTrace();
        }
    }
}