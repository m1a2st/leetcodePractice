package leecode.dataStructure.huffmanCode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class HuffmanCodeDemo {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] contentByte = str.getBytes(StandardCharsets.UTF_8);
        byte[] zip = HuffmanEncoder.huffmanZip(contentByte);
        System.out.println(Arrays.toString(zip));
        byte[] sourceByte = HuffmanEncoder.decode(zip);
        System.out.println(new String(sourceByte));
//        HuffmanEncoder huffmanEncoder = new HuffmanEncoder();
//        String srcFile = "/Users/ken/Desktop/image.png";
//        String dstFile = "/Users/ken/Desktop/6YuwE.zip";
//        huffmanEncoder.zipFile(srcFile, dstFile);
//
//        String zipFile = "/Users/ken/Desktop/6YuwE.zip";
//        String dstFile2 = "/Users/ken/Desktop/image000.png";
//        huffmanEncoder.unZipFile(zipFile,dstFile2);
    }
}

class HuffmanEncoder {
    /**
     * 生成赫夫曼樹對應的赫夫曼編碼
     * 思路：
     * 1. 將赫夫曼編碼存放在Map<Byte,String>形式
     * 32 -> 01, 97 -> 100, 100 -> 11000 等等
     * 2. 在生成赫夫曼編碼表示，需要去拼接路徑，定義一個StringBuilder儲存某個葉子節點的路徑
     */
    private static final Map<Byte, String> huffmanCodes = new HashMap<>();
    private static final StringBuilder codePath = new StringBuilder();

    /**
     * 1. 將huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
     * 重寫先轉成赫夫曼編碼對應的二進制字符串 10101001101111011110...
     * 2. 赫夫曼編碼對應的二進制字符串“10101001101111011110...” => 對照赫夫曼編碼 => "i like like like java do you like a java"
     */
    public static byte[] decode(byte[] huffmanBytes) {
        return decode(huffmanCodes, huffmanBytes);
    }

    /**
     * 1. 先得到 huffman對應的二進制字符串，形式為10101001101111011110...
     *
     * @param huffmanCodes 赫夫曼編碼表 map
     * @param huffmanBytes 赫夫曼編碼得到的字節陣列
     * @return 原來的字符串對應的陣列
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder code = new StringBuilder();
        //將byte陣列組成二進制字符串
        for (int i = 0; i < huffmanBytes.length; i++) {
            //判斷是不是最後一個字節
            boolean flag = (i == huffmanBytes.length - 1);
            code.append(byte2BitString(!flag, huffmanBytes[i]));
        }
        //把字符串按照指定的赫夫曼編碼進行解碼
        //把赫夫曼編碼進行調換，因為反向查詢 a->100 100->a
        Map<String, Byte> reverseHuffmanCodes = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            reverseHuffmanCodes.put(entry.getValue(), entry.getKey());
        }
        //創建一個集合，存放byte
        List<Byte> byteList = new ArrayList<>();
        for (int index = 0; index < code.length(); ) {
            int count = 1; //計數器
            boolean flag = true;
            Byte b = null;
            while (flag) {
                //10101001101111011110...
                //取出一個'1' '0'
                String key = code.substring(index, index + count); //index不動，讓count移動，指定匹配到一個字符
                b = reverseHuffmanCodes.get(key);
                if (b == null) {
                    count++;
                } else {
                    //匹配到
                    flag = false;
                }
            }
            byteList.add(b);
            index += count;
        }
        //當for循環結束後，byteList存放所有字符 "i like like like java do you like a java"
        //把list中的數據方入到byte[] 並返回
        byte[] b = new byte[byteList.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = byteList.get(i);
        }
        return b;
    }

    /**
     * 將一個byte轉成一個二進制字符串
     *
     * @param b    欲轉換的byte
     * @param flag 標示是否需要補高位，如果是true，表示需要補高位，如果是false表示不補，如果是最後一個字節，則無需補高位
     * @return 該b對應的二進制字符串，（注意是按補碼返回）
     */
    private static String byte2BitString(boolean flag, byte b) {
        int temp = b;
        //如果是正數存在補位問題
        if (flag) {
            //按位與256 1 0000 0000 | 0000 00001 => 1 0000 0001
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);//返回的是二進制的補碼
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 1. 根據nodes來創建赫夫曼樹
     * 2. 獲得赫夫曼編碼
     * 3. 根據生成的赫夫曼編碼，壓縮得到壓縮後的赫夫曼編碼字節陣列
     *
     * @param bytes 原始的字符串對應的字節陣列
     * @return 經過赫夫曼編碼處理過後的字節陣列
     */
    public static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNodes(bytes);
        Node root = HuffmanTree.createHuffmanTree(nodes);
        Map<Byte, String> codes = getCodes(root);
        return zip(bytes, codes);
    }

    /**
     * 1. 創建一個ArrayList<Node>跟計算數量的HashMap
     * 2. 遍歷bytes 統計每一個byte出現的次數=>map[key, value]
     * 3. 把每一個鍵值對轉成一個Node對象，並加入到node集合
     *
     * @param bytes 接收一個字節陣列
     * @return List形式為  [Node[date=97 ,weight = 5], Node[]date=32,weight = 9]......]
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            counts.merge(b, 1, Integer::sum);
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    /**
     * 功能：
     * 將傳入的node節點的所有葉子節點的赫夫曼編碼得到，並放入到huffmanCode集合中
     *
     * @param node          傳入節點
     * @param code          路徑，左子節點是0，右子節點為1
     * @param stringBuilder 用於拼接路徑
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder path = new StringBuilder(stringBuilder);
        path.append(code);
        if (node != null) {
            if (node.data == null) {
                //非葉子節點，向左遞迴處理
                getCodes(node.left, "0", path);
                //向左遞迴處理
                getCodes(node.right, "1", path);
            } else {
                //說明是一個葉子節點，就表示已找到最後
                huffmanCodes.put(node.data, path.toString());
            }
        }
    }

    /**
     * overload getCodes
     *
     * @param root 赫夫曼樹根節點
     * @return 赫夫曼編碼
     */
    private static Map<Byte, String> getCodes(Node root) {
        if (root == null) {
            return new HashMap<>();
        }
        //處理root左子樹
        getCodes(root.left, "0", codePath);
        //處理root右子樹
        getCodes(root.right, "1", codePath);
        return huffmanCodes;
    }

    /**
     * 將字符串對應的byte[]陣列，通過生成的赫夫曼編碼表，返回一個赫夫曼邊碼呀鎖過後的byte[]
     * 1. 利用huffmanCodes 將bytes轉成赫夫曼編碼對應的字符串
     * 2. 將10101001101111011110...轉成byte[]
     *
     * @param bytes        原始字符串對應的bytes[]
     * @param huffmanCodes 生成的赫夫曼編碼Map
     * @return 返回赫夫曼編碼處理後的byte[]
     * Example: String str = "i like like like java do you like a java";
     * byte[] contentByte = str.getBytes(StandardCharsets.UTF_8);
     * 返回的是字符串：10101001101111011110...
     * =>對應的byte[] huffmanCodeBytes，即8為對應一個byte，放入到huffmanCodeBytes
     * huffmanCodeBytes[0] = 10101000（補碼）=> byte [推導 10101000 => 10101000 -1 => 10100111(反碼) => 11011000 = -88]
     * huffmanCodeBytes[0] = -88
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder code = new StringBuilder();
        for (byte b : bytes) {
            code.append(huffmanCodes.get(b));
        }
        int length;
        if (code.length() % 8 == 0) {
            length = code.length() / 8;
        } else {
            length = code.length() / 8 + 1;
        }
        //創建 儲存呀所後的byte陣列
        byte[] huffmanCodeBytes = new byte[length];
        //紀錄是第幾個byte
        int index = 0;
        for (int i = 0; i < code.length(); i += 8) {
            String strByte;
            if (i + 8 > code.length()) {//不夠8位
                strByte = code.substring(i);
            } else {
                strByte = code.substring(i, i + 8);
            }
            //將strByte 轉成一個byte，放入到huffmanCodeBytes
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    /**
     * 將一個文件進行壓縮
     *
     * @param srcFile 傳入希望壓縮文件的全路徑
     * @param dstFile 壓縮後將文件放至於哪個目錄
     */
    public static void zipFile(String srcFile, String dstFile) {
        try (//創建輸出流
             //創建文件的輸出流，存放壓縮文件
             FileOutputStream os = new FileOutputStream(dstFile);
             //創建一個與文件輸出流相關連的ObjectOutputStream
             ObjectOutputStream oos = new ObjectOutputStream(os);
             //創建輸入流
             FileInputStream is = new FileInputStream(srcFile);) {
            //創建一個與原文件大小一樣的陣列
            byte[] b = new byte[is.available()];
            is.read(b);
            //直接對原文件壓縮
            byte[] huffmanBytes = huffmanZip(b);
            //把赫夫曼編碼後的字節陣列寫入壓縮文件
            oos.writeObject(huffmanBytes);
            //這裡以對象流的方式寫入 赫夫曼編碼，是為了以後恢復文件使用
            //注意一定要把赫夫曼編碼寫入壓縮文件
            oos.writeObject(huffmanCodes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 對壓縮的文件解壓
     *
     * @param zipFile 準備解壓的文件
     * @param dstFile 講文件解壓到哪裡
     */
    public static void unZipFile(String zipFile, String dstFile) {
        try (//定義文件輸入流
             InputStream is = new FileInputStream(zipFile);
             //定義一個對象輸入流
             ObjectInputStream ois = new ObjectInputStream(is);
             //定義文件輸出流
             OutputStream os = new FileOutputStream(dstFile);) {
            //讀取赫夫曼編碼表
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
            //解碼
            byte[] bytes = decode(codes, huffmanBytes);
            //將bytes 陣列寫入到目標文件
            //寫數據到dstFile文件
            os.write(bytes);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class HuffmanTree {

    /**
     * 可以通過List<Node>，創建對應的赫夫曼樹
     * 1. 從小到大排序
     * 2. 取出最小的二元數節點
     * 3. 取出第二小的二元數節點
     * 4. 創建一顆新的二元數，他的根節點沒有data，只有權值
     * 5. 將已經處理的兩個二元數從nodes裡刪除
     * 6. 將新的二元數節點，加入到nodes
     *
     * @param nodes 要成為赫夫曼樹的陣列
     * @return 創建好赫夫曼樹的根節點
     */
    public static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    /**
     * 前序遍歷（測試用）
     *
     * @param root 根節點
     */
    public static void preOrder(Node root) {
        if (root == null) {
            System.out.println("This Huffman Tree is empty");
        } else {
            root.preOrder();
        }
    }
}

class Node implements Comparable<Node> {
    public Byte data; //存放數據本身，例如 'a' = 97
    public int weight; //權重
    public Node left;
    public Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}