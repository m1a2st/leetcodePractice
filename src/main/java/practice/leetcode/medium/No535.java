package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class No535 {

    public class Codec {

        Map<String, String> db = new HashMap<>();
        Random random = new Random();
        String urlPrefix = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int r = random.nextInt() * 1000;
            String tinyUrl = urlPrefix + r;
            db.put(tinyUrl, longUrl);
            return tinyUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return db.get(shortUrl);
        }
    }
}
