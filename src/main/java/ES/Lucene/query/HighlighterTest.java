//package ES.Lucene.query;
//
//import ES.Lucene.IK.IKAnalyzer6x;
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.TokenStream;
//import org.apache.lucene.document.Document;
//import org.apache.lucene.index.DirectoryReader;
//import org.apache.lucene.index.IndexReader;
//import org.apache.lucene.queryparser.classic.ParseException;
//import org.apache.lucene.queryparser.classic.QueryParser;
//import org.apache.lucene.search.IndexSearcher;
//import org.apache.lucene.search.Query;
//import org.apache.lucene.search.ScoreDoc;
//import org.apache.lucene.search.TopDocs;
//import org.apache.lucene.search.highlight.*;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.FSDirectory;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//public class HighlighterTest {
//    private static final String dataPath = "/Users/miaohongyuan/IdeaProjects/JavaProjects/src/main/resources/indexdir";
//    public static void main(String[] args) throws IOException, ParseException, InvalidTokenOffsetsException {
//        String field = "title";
//        Path indexPath = Paths.get(dataPath);
//        Directory directory = FSDirectory.open(indexPath);
//        IndexReader reader = DirectoryReader.open(directory);
//
//        IndexSearcher searcher = new IndexSearcher(reader);
//
//        Analyzer analyzer = new IKAnalyzer6x();
//
//        QueryParser parser = new QueryParser(field, analyzer);
//        Query query = parser.parse("北大");
//        System.out.println("Query:" + query);
//
//        QueryScorer scorer = new QueryScorer(query, field);
//        SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<span style=\"color:red;\">","</span>");   // 定制高亮标签
//        Highlighter highlighter = new Highlighter(formatter, scorer);
//
//        // 高亮分词器
//        TopDocs topDocs = searcher.search(query, 10);
//        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
//            Document doc = searcher.doc(scoreDoc.doc);
//            System.out.println("id:" + doc.get("id"));
//            System.out.println("title:" + doc.get("title"));
//            TokenStream tokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), scoreDoc.doc, field, analyzer);
//            // 获取tokenStream
//            Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
//            highlighter.setTextFragmenter(fragmenter);
//            // 获取高亮片段
//            String str = highlighter.getBestFragment(tokenStream, doc.get(field));
//            System.out.println("高亮的片段：" + str);
//        }
//
//        directory.close();
//        reader.close();
//    }
//}
