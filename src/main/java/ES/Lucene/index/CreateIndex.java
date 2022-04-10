//package ES.Lucene.index;
//
//import ES.Lucene.IK.IKAnalyzer6x;
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.document.*;
//import org.apache.lucene.index.IndexOptions;
//import org.apache.lucene.index.IndexWriter;
//import org.apache.lucene.index.IndexWriterConfig;
//import org.apache.lucene.index.Term;
//import org.apache.lucene.store.Directory;
//import org.apache.lucene.store.FSDirectory;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Date;
//
//public class CreateIndex {
//    private static final String dataPath = "/Users/miaohongyuan/IdeaProjects/JavaProjects/src/main/resources/indexdir";
//
//    public static void main(String[] args) {
//        News news1 = new News();
//        news1.setId(1);
//        news1.setTitle("习近平会见美国总统奥巴马，学习国外经验");
//        news1.setContent("国家主席习近平 9 月 3 日在杭州西湖国宾馆会见前米出席二十国集团领导人杭州峰会的美国总统奥巴马.");
//        news1.setReply(672);
//
//        News news2 = new News();
//        news2.setId(2);
//        news2.setTitle("北大迎 4380 名新生 农村学生 700 多人近年最多");
//        news2.setContent("昨天，北京大学迎来 4380 名来自全国各地及数十个同家的本科新生。其中，农村学生共 700 余名，为近年最多.");
//        news2.setReply(995);
//
//        News news3 = new News();
//        news3.setId(3);
//        news3.setTitle("特朗普宣誓(Donald Trump)就任美国第 45任总统");
//        news3.setContent("当地时间 1 月 20 日，唐纳德·特朗普在美国国会宣誓就职，正式成为美国第 45 任总统。");
//        news3.setReply(1872);
//
//        // 创建IK分词器
//        Analyzer analyzer = new IKAnalyzer6x();
//        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
//        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
//        Directory directory = null;
//        IndexWriter indexWriter = null;
//
//        // 索引目录
//        Path indexPath = Paths.get(dataPath);
//        // 开始时间
//        Date start = new Date();
//        try {
//            if (!Files.isReadable(indexPath)) {
//                System.out.println("Document directory '" + indexPath.toAbsolutePath() + "' does not exist or is not readable, please check the path");
//                System.exit(1);
//            }
//
//            directory = FSDirectory.open(indexPath);
//            indexWriter = new IndexWriter(directory, indexWriterConfig);
//            // 设置新闻ID索引并存储
//            FieldType idType = new FieldType();
//            idType.setIndexOptions(IndexOptions.DOCS);
//            idType.setStored(true);
//            // 设置新闻标题索引文档、词项频率、位移信息和偏移量，存储并词条化
//            FieldType titleType = new FieldType();
//            titleType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
//            titleType.setStored(true);
//            titleType.setTokenized(true);
//
//            FieldType contentType = new FieldType();
//            contentType.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
//            contentType.setStored(true);
//            contentType.setTokenized(true);
//            contentType.setStoreTermVectors(true);
//            contentType.setStoreTermVectorPositions(true);
//            contentType.setStoreTermVectorOffsets(true);
//            contentType.setStoreTermVectorPayloads(true);
//
////            Document doc1 = new Document();
////            doc1.add(new Field("id", String.valueOf(news1.getId()), idType));
////            doc1.add(new Field("title", news1.getTitle(), titleType));
////            doc1.add(new Field("content", news1.getContent(), contentType));
////            doc1.add(new IntPoint("reply", news1.getReply()));
////            doc1.add(new StoredField("reply_display", news1.getReply()));
////
////            Document doc2 = new Document();
////            doc2.add(new Field("id", String.valueOf(news2.getId()), idType));
////            doc2.add(new Field("title", news2.getTitle(), titleType));
////            doc2.add(new Field("content", news2.getContent(), contentType));
////            doc2.add(new IntPoint("reply", news2.getReply()));
////            doc2.add(new StoredField("reply_disply", news2.getReply()));
////
////            Document doc3 = new Document();
////            doc3.add(new Field("id", String.valueOf(news3.getId()), idType));
////            doc3.add(new Field("title", news3.getTitle(), titleType));
////            doc3.add(new Field("content", news3.getContent(), contentType));
////            doc3.add(new IntPoint("reply", news3.getReply()));
////            doc3.add(new StoredField("reply_disply", news3.getReply()));
////
////            indexWriter.addDocument(doc1);
////            indexWriter.addDocument(doc2);
////            indexWriter.addDocument(doc3);
//
//            String newsFilePath = "/Users/miaohongyuan/IdeaProjects/JavaProjects/src/main/resources/testfile/news.txt";
//            File newsFile = new File(newsFilePath);
//            String newsContent = textToString(newsFile);
//            Document docNews = new Document();
//            docNews.add(new Field("id", String.valueOf(4), idType));
//            docNews.add(new Field("title", "李开复: 无人驾驶进入黄金时代", titleType));
//            docNews.add(new Field("content", newsContent, contentType));
//            docNews.add(new IntPoint("reply", 1024));
//            indexWriter.addDocument(docNews);
//
//            indexWriter.commit();
//            indexWriter.close();
//            directory.close();
//        } catch (Exception e) {
//            System.out.println("异常：" + e);
//        }
//
//        Date end = new Date();
//        System.out.println("索引文档用时：" + (end.getTime() - start.getTime()) + " milliseconds");
//    }
//
//    public static String textToString(File file) {
//        StringBuilder result = new StringBuilder();
//        try {
//            // 构造一个BufferReader类来读取文件
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String str = null;
//            // 使用readLine方法，一次读一行
//            while ((str = br.readLine()) != null) {
//                result.append(System.lineSeparator() + str);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return result.toString();
//    }
//
//    public static void deleteDoc(String field, String key) {
//        Analyzer analyzer = new IKAnalyzer6x();
//        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
//        Path indexPath = Paths.get(dataPath);
//        Directory directory;
//        try {
//            directory = FSDirectory.open(indexPath);
//            IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
//            indexWriter.deleteDocuments(new Term(field, key));
//            indexWriter.commit();
//            indexWriter.close();
//            System.out.println("删除完成！");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void updateIndex() {
//        Analyzer analyzer = new IKAnalyzer6x();
//        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
//        Path indexPath = Paths.get(dataPath);
//        Directory directory;
//        try {
//            directory = FSDirectory.open(indexPath);
//            IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
//            Document doc = new Document();
//            doc.add(new TextField("id", "2", Field.Store.YES));
//            doc.add(new TextField("title", "北京大学开学迎来 4380 名新生", Field.Store.YES));
//            doc.add(new TextField("content", "”昨天，北京大学迎来 4380 名来自全国各地及数十个国家的本科新生。其中，农村学生共 700 余 名，为近年最多 .. .", Field.Store.YES));
//            indexWriter.updateDocument(new Term("title", "北大"), doc);
//            indexWriter.commit();
//            indexWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
