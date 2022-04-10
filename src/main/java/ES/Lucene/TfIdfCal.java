package ES.Lucene;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class TfIdfCal {
    public double tf(List<String> doc, String term) {
        double termFrequency = 0;
        for (String str : doc) {
            if (str.equalsIgnoreCase(str)) {
                termFrequency++;
            }
        }

        return termFrequency / doc.size();
    }

    public int df(List<List<String>> docs, String term) {
        int n = 0;
        if (StringUtils.isEmpty(term)) {
            System.out.println("term不能为null或者为空串");
        }

        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }

        return n;
    }

    public double idf(List<List<String>> docs, String term) {
        return Math.log(docs.size() / (double) df(docs, term));
    }

    // doc为某一个文档，docs为文档集合，term为某个词，计算结果为文档doc中的term词的权重
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);
    }
}
