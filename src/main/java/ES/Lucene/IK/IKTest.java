//package ES.Lucene.IK;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.TokenStream;
//import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
//
//import java.io.IOException;
//import java.io.StringReader;
//
//public class IKTest {
//    // 在扩展词词典中添加"正兴公路局"
//    private static String str1 = "正兴公路局正在治理解放大道路面积水问题。";
//    private static String str2 = "IKAnalyzer 是一个开源的，基于 java 语言开发的轻量级的中文分词工具包。";
//
//    public static void main(String[] args) throws IOException {
//        Analyzer analyzer = null;
//        System.out.println(str1);
//        System.out.println("IKAnalyzer分词结果");
//        analyzer = new IKAnalyzer6x(true);
//        printAnalyzer(analyzer, str1);
//        System.out.println("-------------------");
//        System.out.println(str2);
//        analyzer = new IKAnalyzer6x(true);
//        printAnalyzer(analyzer, str2);
//    }
//
//    public static void printAnalyzer(Analyzer analyzer, String str) throws IOException {
//        StringReader reader = new StringReader(str);
//        TokenStream tokenStream = analyzer.tokenStream(str, reader);
//        tokenStream.reset();
//        CharTermAttribute termAttribute = tokenStream.getAttribute(CharTermAttribute.class);
//        while (tokenStream.incrementToken()) {
//            System.out.print(termAttribute.toString() + "|");
//        }
//        System.out.println();
//    }
//}
