package iterator;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileReadObj implements Iterator<String> {
    private BufferedReader reader;
    private String line;

    public FileReadObj(String file) throws IOException {
        FileReader f = new FileReader(file);
        reader = new BufferedReader(f);
        line = reader.readLine();
    }

    @Override
    public boolean hasNext() {
        return StringUtils.isNotEmpty(line);
    }

    @Override
    public String next() {
        if (hasNext()) {
            try {
                line = reader.readLine();
                if (StringUtils.isEmpty(line)) {
                    close();
                }
            } catch (Exception e) {
                close();
            }

            return line;
        }

        throw new RuntimeException("越界");
    }

    private void close() {
        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("close fail" + e);
        }
    }
}
