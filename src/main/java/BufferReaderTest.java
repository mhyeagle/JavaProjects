import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader f = new FileReader("/Users/miaohongyuan/dependency.txt");
        FileReader f2 = new FileReader("http://s3plus.sankuai.com/bitcube/088b22a3-8275-457a-999a-60ef2a7b4082.txt?AWSAccessKeyId=f8af9459b2b2441b945fce4f92d74965&Expires=1635926927&Signature=YnuOdRxIzu0cbx4slJ%2FTra4OOwU%3D");
        BufferedReader br = new BufferedReader(f2);
        String line = br.readLine();
        br.mark(0);
        System.out.println(line);
        while (StringUtils.isNotEmpty(line)) {
            line = br.readLine();
        }

        br.reset();
        line = br.readLine();
        System.out.println(line);
    }
}
