package array;

/**
 * @author wangyakun
 * @date 2020/12/3
 */
public class SparseArray {
    /**
     * 二维数组 => 稀疏数组
     * 1. 遍历原始的二维数组，得到有效数据的个数sum
     * 2. 根据sum即可创建稀疏数组 sparseArr int[sum+1][3]
     * 3. 再次遍历二维数组，将其有效数据存入稀疏数组
     * 稀疏数组 => 二维数组
     * 1. 读取稀疏数组的第一行，根据第一行的数据，初始化一个二维数组，如上图：array= int[11][11]
     * 2. 遍历读取稀疏数组后续行数据，并将对应数据赋值给此二维数组即可
     *
     * @param args
     */
    public static void main(String[] args) {
        // 初始化二维数组
        int[][] array = new int[11][11];
        array[1][1] = 1;
        array[2][2] = 2;
        array[3][3] = 3;
        array[4][4] = 4;

        System.out.println("=====================原始二维数组========================");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d\t", array[i][j]);
            }
            System.out.println();
        }

        // 二维数组 => 稀疏数组
        int[][] sparseArray = arrayToSparse(array);
        // 打印稀疏数组
        System.out.println("=======================稀疏数组==========================");
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.printf("%d\t", sparseArray[i][j]);
            }
            System.out.println();
        }

        // 稀疏数组 => 二维数组
        int[][] array1 = sparseToArray(sparseArray);
        // 打印还原后的二维数组
        System.out.println("====================还原后的二维数组=======================");
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                System.out.printf("%d\t", array1[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 稀疏数组 => 二维数组
     * @param sparseArray
     * @return
     */
    private static int[][] sparseToArray(int[][] sparseArray) {
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }

    /**
     * 二维数组 => 稀疏数组
     * @param array
     * @return
     */
    private static int[][] arrayToSparse(int[][] array) {
        // 计算不为0的个数
        int notZeroCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    notZeroCount++;
                }
            }
        }
        // 创建稀疏数组 行数=1汇总行+非0总数  列数=3
        int[][] sparseArray = new int[notZeroCount + 1][3];
        // 汇总行 [行数，列数，非0个数]
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = notZeroCount;

        // 遍历二维数组，赋值
        int row = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0) {
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = array[i][j];
                    row++;
                }
            }
        }
        return sparseArray;
    }
}
