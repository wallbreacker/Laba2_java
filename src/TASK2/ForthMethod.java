package TASK2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ForthMethod {
    public static void main() {
        Path source = Paths.get("largeFile.txt");
        Path dest = Paths.get("destinationFileFilesClass.txt");
        try {
            long startTime = System.currentTimeMillis(); // Измеряем время начала копирования
            Files.copy(source, dest);
            long endTime = System.currentTimeMillis(); // Измеряем время окончания копирования
            long timeElapsed = endTime - startTime; // Вычисляем время, затраченное на копирование
            long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Вычисляем затраты памяти
            System.out.println("Файл успешно скопирован с использованием Files class.");
            System.out.println("Время: " + timeElapsed + " милисекунд");
            System.out.println("Использовано памями: " + memoryUsed + " байт\n");
        } catch (IOException e) {
            System.out.println("An error occurred while copying the file using Files class.");
            e.printStackTrace();
        }
    }
}