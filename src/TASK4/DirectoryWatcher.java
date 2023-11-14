package TASK4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class DirectoryWatcher {
    public static void main(String[] args) {
        try {
            Path directory = Paths.get("DirectoryWatcher");
            WatchService watchService = FileSystems.getDefault().newWatchService();
            directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    Path filePath = (Path) event.context();
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        System.out.println("Создан новый файл: " + filePath);
                    } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                        System.out.println("Файл изменен: " + filePath);
                        try (FileChannel channel = (FileChannel) Files.newByteChannel(directory.resolve(filePath), StandardOpenOption.READ)) {
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            int bytesRead = channel.read(buffer);
                            while (bytesRead != -1) {
                                buffer.flip();
                                while (buffer.hasRemaining()) {
                                    System.out.print((char) buffer.get());
                                }
                                buffer.clear();
                                bytesRead = channel.read(buffer);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println('\n');
                    } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                        System.out.println("Файл удален: " + filePath);
                        try {
                            long fileSize = Files.size(directory.resolve(filePath));
                            System.out.println("File size: " + fileSize + " bytes");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}