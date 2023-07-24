package leecode.medium;

import java.util.*;

/**
 * @Author m1a2st
 * @Date 2023/7/24
 * @Version v1.0
 */
public class No355 {

    class Twitter {

        Post top;
        Map<Integer, HashSet> followings;

        public Twitter() {
            top = null;
            followings = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            Post post = new Post(userId, tweetId);
            post.next = top;
            top = post;
        }

        public List<Integer> getNewsFeed(int userId) {
            Post post = top;
            List<Integer> feed = new ArrayList<>();
            Set<Integer> userFollowings = followings.get(userId);

            int count = 0;
            while (count < 10 && post != null) {
                if (userFollowings != null && userFollowings.contains(post.uid)) {
                    feed.add(post.pid);
                    count++;
                } else if (post.uid == userId) {
                    feed.add(post.pid);
                    count++;
                }
                post = post.next;
            }
            return feed;
        }

        public void follow(int followerId, int followeeId) {
            if (!followings.containsKey(followerId))
                followings.put(followerId, new HashSet<>());
            if (followerId != followeeId) followings.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followings.containsKey(followerId))
                followings.get(followerId).remove(followeeId);
        }

    }

    class Post {
        int uid;
        int pid;
        Post next;

        Post(int u, int p) {
            uid = u;
            pid = p;
        }
    }
}
