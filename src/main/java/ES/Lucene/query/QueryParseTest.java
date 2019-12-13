package ES.Lucene.query;

import ES.Lucene.IK.IKAnalyzer6x;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QueryParseTest {
    private static final String dataPath = "/Users/miaohongyuan/IdeaProjects/JavaProjects/src/main/resources/indexdir";
    public static void main(String[] args) throws IOException, ParseException {
        String field = "title";
        Path indexPath = Paths.get(dataPath);
        Directory directory = FSDirectory.open(indexPath);
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        Analyzer analyzer = new IKAnalyzer6x();
        QueryParser parser = new QueryParser(field, analyzer);
        parser.setDefaultOperator(QueryParser.Operator.AND);
        Query query = parser.parse("农村学生"); // 查询关键词
        System.out.println("Query:" + query.toString());
        // 返回前10条
        TopDocs topDocs = searcher.search(query, 10);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            Document document = searcher.doc(scoreDoc.doc);
            System.out.println("DocId:" + scoreDoc.doc);
            System.out.println("id:" + document.get("id"));
            System.out.println("title:" + document.get("title"));
            System.out.println("文档评分:" + scoreDoc.score);
        }
        directory.close();
        reader.close();
    }
}
