package TASK2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class SecondMethod {
    public static void main() {
        try (FileInputStream inputStream = new FileInputStream("largeFile.txt");
             FileOutputStream outputStream = new FileOutputStream("destinationFileChannel.txt")) {
            FileChannel sourceChannel = inputStream.getChannel();
            FileChannel destChannel = outputStream.getChannel();
            long startTime = System.currentTimeMillis(); // Измеряем время начала копирования
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            long endTime = System.currentTimeMillis(); // Измеряем время окончания копирования
            long timeElapsed = endTime - startTime; // Вычисляем время, затраченное на копирование
            long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Вычисляем затраты памяти
            System.out.println("Файл успешно скопирован с использованием FileChannel.");
            System.out.println("Время: " + timeElapsed + " милисекунд");
            System.out.println("Использовано памями: " + memoryUsed + " байт\n");
        } catch (IOException e) {
            System.out.println("An error occurred while copying the file using FileChannel.");
            e.printStackTrace();
        }
    }
}