  //Note: This is a companion problem to the System Design problem: Design TinyURL
//. 
//
// TinyURL is a URL shortening service where you enter a URL such as https://lee
//tcode.com/problems/design-tinyurl and it returns a short URL such as http://tiny
//url.com/4e9iAk. 
//
// Design the encode and decode methods for the TinyURL service. There is no res
//triction on how your encode/decode algorithm should work. You just need to ensur
//e that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the
// original URL. 
// Related Topics Hash Table Math 
// 👍 657 👎 1441

  
  package com.miueon.leetcode.editor.en;

  import java.util.HashMap;
  import java.util.Map;

  public class EncodeAndDecodeTinyurl{
        public static final Codec solution = new EncodeAndDecodeTinyurl().new Codec();
      public static void main(String[] args) {
           
      }
      //leetcode submit region begin(Prohibit modification and deletion)
public class Codec {
    Map<String, String> short_long = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int x = longUrl.hashCode();
        StringBuilder shortUrl = new StringBuilder();
        shortUrl.append("p");
        if (x < 0) {
            shortUrl.deleteCharAt(0);
            shortUrl.append("n");
        }
        x = Math.abs(x);
        int chrInx = 0;
        char c;
        while (x !=0) {
            chrInx = x % 95 + 32;
            c = (char) chrInx;
            shortUrl.append(c);
            x = x/95;
        }
        String shU = shortUrl.toString();
        short_long.put(shU, longUrl);
        return shU;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short_long.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
//leetcode submit region end(Prohibit modification and deletion)

  }