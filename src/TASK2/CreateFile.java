package TASK2;

import java.io.File;
import java.io.RandomAccessFile;

public class CreateFile {
    public static void main(String[] args) {
        try {
            File largeFile = new File("largeFile.txt");
            RandomAccessFile raf = new RandomAccessFile(largeFile, "rw");
            raf.setLength(100 * 1024 * 1024); // Устанавливаем размер файла в байтах (100 Мб)
            raf.close();
            System.out.println("Файл размером 100 Мб создан успешно.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при создании файла.");
            e.printStackTrace();
        }
    }
}


