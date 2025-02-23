package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class No889 {
    
    @Test
    public void Test() {
        Solution solution = new Solution();
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        solution.constructFromPrePost(pre, post);
    }

    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            Map<Integer, Integer> postToIndex = new HashMap<>();

            for (int i = 0; i < post.length; ++i)
                postToIndex.put(post[i], i);

            return build(pre, 0, pre.length - 1, post, 0, post.length - 1, postToIndex);
        }

        private TreeNode build(int[] pre, int preStart, int preEnd, int[] post, int postStart,
                               int postEnd, Map<Integer, Integer> postToIndex) {
            if (preStart > preEnd)
                return null;
            if (preStart == preEnd)
                return new TreeNode(pre[preStart]);

            final int rootVal = pre[preStart];
            final int leftRootVal = pre[preStart + 1];
            final int leftRootPostIndex = postToIndex.get(leftRootVal);
            final int leftSize = leftRootPostIndex - postStart + 1;

            TreeNode root = new TreeNode(rootVal);
            root.left = build(pre, preStart + 1, preStart + leftSize, post, postStart, leftRootPostIndex,
                    postToIndex);
            root.right = build(pre, preStart + leftSize + 1, preEnd, post, leftRootPostIndex + 1,
                    postEnd - 1, postToIndex);
            return root;
        }
    }
}
