//package ES.Lucene.IK;
//
//import org.apache.lucene.analysis.Tokenizer;
//import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
//import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
//import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
//import org.wltea.analyzer.core.IKSegmenter;
//import org.wltea.analyzer.core.Lexeme;
//
//import java.io.IOException;
//
//public class IKTokenizer6x extends Tokenizer {
//    // IK 分词器实现
//    private IKSegmenter ikSegmenter;
//    // 词元文本属性
//    private CharTermAttribute termAttribute;
//    // 词元位移属性
//    private OffsetAttribute offsetAttribute;
//    // 词元分类属性
//    private TypeAttribute typeAttribute;
//    // 记录最后一个词元的结束位置
//    private int endPosition;
//
//    public IKTokenizer6x(boolean useSmart) {
//        super();
//        offsetAttribute = addAttribute(OffsetAttribute.class);
//        termAttribute = addAttribute(CharTermAttribute.class);
//        typeAttribute = addAttribute(TypeAttribute.class);
//        ikSegmenter = new IKSegmenter(input, useSmart);
//    }
//
//    @Override
//    public boolean incrementToken() throws IOException {
//        clearAttributes();
//        Lexeme nextLexeme = ikSegmenter.next();
//        if (nextLexeme != null) {
//            termAttribute.append(nextLexeme.getLexemeText());   //设置词元文本
//            termAttribute.setLength(nextLexeme.getLength());    //设置词元长度
//            offsetAttribute.setOffset(nextLexeme.getBeginPosition(), nextLexeme.getEndPosition());  //设置词元位移
//            endPosition = nextLexeme.getEndPosition();  //记录分词的最后位置
//            typeAttribute.setType(nextLexeme.getLexemeText());  //记录词元分类
//
//            return true;    //返回true告知还有下个词元
//        }
//
//        return false;   //返回false告知词元输出完毕
//    }
//
//    @Override
//    public void reset() throws IOException {
//        super.reset();
//        ikSegmenter.reset(input);
//    }
//
//    @Override
//    public final void end() {
//        int finalOffset = correctOffset(this.endPosition);
//        offsetAttribute.setOffset(finalOffset, finalOffset);
//    }
//}
