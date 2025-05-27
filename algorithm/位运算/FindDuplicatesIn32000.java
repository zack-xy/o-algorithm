package algorithm.位运算;

/**
 *
 *  给定一个数组，包含从1到N的整数，N最大为32000，数组可能还有重复值，且N的取值不定，若只有4KB的内存可用，该如何打印数组中所有重复元素。
 *
 *  解释：32,000 × 4 字节 = 128,000 字节 ≈ 125 KB
 *
 *  一个比特位代表1个数组元素，遍历访问整个数组。如果发现数组元素是v，那么就将位置为v的设置为1，碰到重复元素，就输出一下。
 *
 */
// TODO 位向量
public class FindDuplicatesIn32000 {

    public void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i=0;i<array.length;i++) {
            int num = array[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    class BitSet {
        int[] bitset;

        public BitSet(int size) {
            this.bitset = new int[size >> 5];  //  125 KB / 32  ≈ 3.9k
        }

        boolean get(int pos) {
            int wordNumber = (pos >> 5); // 除以32
            int bitNumber = (pos & 0x1F); // 取模32
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        void set(int pos) {
            int wordNumber = (pos >> 5); // 除以32
            int bitNumber = (pos & 0x1F); // 取模32
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }
}
