package TASK2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FirstMethod {
    public static void main() {
        try (FileInputStream inputStream = new FileInputStream("largeFile.txt");
             FileOutputStream outputStream = new FileOutputStream("destinationFileStream.txt")) {
            byte[] buffer = new byte[1024];
            int length;
            long startTime = System.currentTimeMillis(); // Измеряем время начала копирования
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            long endTime = System.currentTimeMillis(); // Измеряем время окончания копирования
            long timeElapsed = endTime - startTime; // Вычисляем время, затраченное на копирование
            long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Вычисляем затраты памяти
            System.out.println("Файл успешно скопирован с использованием FileInputStream/FileOutputStream.");
            System.out.println("Время: " + timeElapsed + " милисекунд");
            System.out.println("Использовано памями: " + memoryUsed + " байт\n");
        } catch (IOException e) {
            System.out.println("An error occurred while copying the file using FileInputStream/FileOutputStream.");
            e.printStackTrace();
        }
    }
}


