package TASK2;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ThirdMethod {
    public static void main() {
        try {
            File source = new File("largeFile.txt");
            File dest = new File("destinationFileApache.txt");
            long startTime = System.currentTimeMillis(); // Измеряем время начала копирования
            FileUtils.copyFile(source, dest);
            long endTime = System.currentTimeMillis(); // Измеряем время окончания копирования
            long timeElapsed = endTime - startTime; // Вычисляем время, затраченное на копирование
            long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Вычисляем затраты памяти
            System.out.println("Файл успешно скопирован с использованием Apache Commons IO.");
            System.out.println("Время: " + timeElapsed + " милисекунд");
            System.out.println("Использовано памями: " + memoryUsed + " байт\n");
        } catch (IOException e) {
            System.out.println("An error occurred while copying the file using Apache Commons IO.");
            e.printStackTrace();
        }
    }
}