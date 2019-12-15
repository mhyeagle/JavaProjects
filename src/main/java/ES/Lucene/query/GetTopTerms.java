package ES.Lucene.query;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class GetTopTerms {;
    private static final String indexPath = "/Users/miaohongyuan/IdeaProjects/JavaProjects/src/main/resources/indexdir";
    public static void main(String[] args) throws IOException {
        Directory directory = FSDirectory.open(Paths.get(indexPath));
        IndexReader reader = DirectoryReader.open(directory);

        Terms terms = reader.getTermVector(3, "content");
        TermsEnum termsEnum = terms.iterator();
        Map<String, Integer> map = new HashMap<>();
        BytesRef thisTerm;
        while ((thisTerm = termsEnum.next()) != null) {
            String termText = thisTerm.utf8ToString();
            map.put(termText, (int) termsEnum.totalTermFreq());
        }

        List<Map.Entry<String, Integer>> sortedMap = new ArrayList<>(map.entrySet());
        Collections.sort(sortedMap, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        getTopN(sortedMap, 10);
    }

    public static void getTopN(List<Map.Entry<String, Integer>> sortedMap,  int N) {
        for (Map.Entry entry : sortedMap) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
