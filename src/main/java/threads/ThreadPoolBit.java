package threads;

public class ThreadPoolBit {
    public static void main(String[] args) {
        final int COUNT_BITS = Integer.SIZE - 3;
        final int SHUTDOWN   =  0 << COUNT_BITS;
        final int RUNNING    = -1 << COUNT_BITS;
        final int STOP       =  1 << COUNT_BITS;
        final int TIDYING    =  2 << COUNT_BITS;
        final int TERMINATED =  3 << COUNT_BITS;

        System.out.println("COUNT_BITS:" + Integer.toBinaryString(COUNT_BITS));
        System.out.println("SHUTDOWN:" + Integer.toBinaryString(SHUTDOWN));
        System.out.println("RUNNING:" + Integer.toBinaryString(RUNNING));
    }
}
