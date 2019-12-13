package ES.Lucene.query;

import ES.Lucene.IK.IKAnalyzer6x;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.IntPoint;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
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

//        QueryParser parser = new QueryParser(field, analyzer);
//        parser.setDefaultOperator(QueryParser.Operator.AND);
//        Query query = parser.parse("农村学生"); // 查询关键词

//        // 多域搜索（MultiFieldQueryParser）
//        String[] fields = {"title", "content"};
//        MultiFieldQueryParser multiFieldQueryParser = new MultiFieldQueryParser(fields, analyzer);
//        Query query = multiFieldQueryParser.parse("美国");

//        // 词项搜索（TermQuery)
//        Term term = new Term("title", "美国");
//        Query query = new TermQuery(term);

        // 布尔搜索（BooleanQuery)
//        Query query1 = new TermQuery(new Term("title", "美国"));
//        Query query2 = new TermQuery(new Term("content", "日本"));
//        BooleanClause booleanClause1 = new BooleanClause(query1, BooleanClause.Occur.MUST);
//        BooleanClause booleanClause2 = new BooleanClause(query2, BooleanClause.Occur.MUST_NOT);
//        BooleanQuery query = new BooleanQuery.Builder()
//                .add(booleanClause1)
//                .add(booleanClause2)
//                .build();

        // 范围搜索（RangeQuery）
//        Query query = IntPoint.newRangeQuery("reply", 500, 1000);

        // 前缀搜索（PrefixQuery）
        // 查询包含以"学"开头的词项的文档
//        Term term = new Term("title", "学");
//        Query query = new PrefixQuery(term);

        // 多关键字搜索（PhraseQuery）
//        PhraseQuery.Builder builder = new PhraseQuery.Builder();
//        builder.add(new Term("title", "日本"), 2);
//        builder.add(new Term("title", "美国"), 3);
//        PhraseQuery query = builder.build();

        // 模糊搜索（FuzzyQuery）
//        Term term = new Term("title", "Tramp");
//        FuzzyQuery query = new FuzzyQuery(term);

        // 通配符搜索（WildcardQuery）
        WildcardQuery query = new WildcardQuery(new Term(field, "学?"));

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
