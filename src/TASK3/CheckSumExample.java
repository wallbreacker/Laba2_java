package TASK3;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class CheckSumExample {
    public static void main(String[] args) {
        String fileName = "l.txt";
        try (FileInputStream fis = new FileInputStream(fileName);
             FileChannel channel = fis.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            short checksum = 0;
            while (channel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    checksum += buffer.getShort();
                }
                buffer.clear();
            }
            long memoryUsed = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            System.out.println("Сумма: " + checksum);
            System.out.println("Занимаемая память: " + memoryUsed + " байт");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
