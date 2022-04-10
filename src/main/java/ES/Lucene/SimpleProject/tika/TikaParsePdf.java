//package ES.Lucene.SimpleProject.tika;
//
//import org.apache.tika.exception.TikaException;
//import org.apache.tika.metadata.Metadata;
//import org.apache.tika.parser.ParseContext;
//import org.apache.tika.parser.pdf.PDFParser;
//import org.apache.tika.sax.BodyContentHandler;
//import org.xml.sax.SAXException;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class TikaParsePdf {
//    public static void main(String[] args) throws IOException, TikaException, SAXException {
//        String filePath = "/Users/miaohongyuan/IdeaProjects/JavaProjects/src/main/resources/files/meituanStoreSystem.pdf";
//        File pdfFile = new File(filePath);
//        FileInputStream inputStream = new FileInputStream(pdfFile);
//
//        BodyContentHandler handler = new BodyContentHandler();
//        Metadata metadata = new Metadata();
//        ParseContext parserContext = new ParseContext();
//        PDFParser parser = new PDFParser();
//        parser.parse(inputStream, handler, metadata, parserContext);
//
//        System.out.println("文件属性信息：");
//        for (String name : metadata.names()) {
//            System.out.println(name + ":" + metadata.get(name));
//        }
//        System.out.println("pdf文件中的内容：");
//        System.out.println(handler.toString());
//    }
//}
