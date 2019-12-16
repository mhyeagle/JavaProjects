package ES.Lucene.SimpleProject.tika;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TikaExtraction {
    private static final String filesPath = "/Users/miaohongyuan/IdeaProjects/JavaProjects/src/main/resources/files";
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        Tika tika = new Tika();
        File fileDir = new File(filesPath);
        if (!fileDir.exists()) {
            System.out.println("文件夹不存在！");
            System.exit(1);
        }

        File[] fileArr = fileDir.listFiles();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream = null;

        Parser parser = new AutoDetectParser();
        ParseContext context = new ParseContext();

        for (File file : fileArr) {
            inputStream = new FileInputStream(file);
            parser.parse(inputStream, handler, metadata, context);
            System.out.println("----------------------------------");
            System.out.println(file.getName() + ":\n" + handler.toString());
        }
    }
}
