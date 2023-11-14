package TASK1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreationExample {
    public static void main(String[] args) {
        // Определение пути к файлу
        Path filePath = Paths.get("example.txt");

        try {
            // Создание файла
            Files.createFile(filePath);
            System.out.println("Файл успешно создан.");
        } catch (IOException e) {
            System.out.println("При создании файла произошла ошибка.");
            e.printStackTrace();
        }
    }
}