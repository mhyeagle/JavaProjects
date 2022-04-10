//package ES.Lucene.IK;
//
//import org.apache.lucene.analysis.Analyzer;
//import org.apache.lucene.analysis.Tokenizer;
//
//public class IKAnalyzer6x extends Analyzer {
//    private boolean useSmart;
//
//    public boolean useSmart() {
//        return useSmart;
//    }
//
//    public void setUseSmart(boolean useSmart) {
//        this.useSmart = useSmart;
//    }
//
//    public IKAnalyzer6x() {
//        this.useSmart = false;
//    }
//
//    public IKAnalyzer6x(boolean useSmart) {
//        super();
//        this.useSmart = useSmart;
//    }
//
//    @Override
//    protected TokenStreamComponents createComponents(String fieldName) {
//        Tokenizer ikTokenizer = new IKTokenizer6x(this.useSmart);
//        return new TokenStreamComponents(ikTokenizer);
//    }
//}
