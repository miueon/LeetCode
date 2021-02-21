  //Design a simplified version of Twitter where users can post tweets, follow/unf
//ollow another user and is able to see the 10 most recent tweets in the user's ne
//ws feed. Your design should support the following methods: 
//
// 
// 
// postTweet(userId, tweetId): Compose a new tweet. 
// getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news
// feed. Each item in the news feed must be posted by users who the user followed 
//or by the user herself. Tweets must be ordered from most recent to least recent.
// 
// follow(followerId, followeeId): Follower follows a followee. 
// unfollow(followerId, followeeId): Follower unfollows a followee. 
// 
// 
//
// Example:
// 
//Twitter twitter = new Twitter();
//
//// User 1 posts a new tweet (id = 5).
//twitter.postTweet(1, 5);
//
//// User 1's news feed should return a list with 1 tweet id -> [5].
//twitter.getNewsFeed(1);
//
//// User 1 follows user 2.
//twitter.follow(1, 2);
//
//// User 2 posts a new tweet (id = 6).
//twitter.postTweet(2, 6);
//
//// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
//// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
//
//twitter.getNewsFeed(1);
//
//// User 1 unfollows user 2.
//twitter.unfollow(1, 2);
//
//// User 1's news feed should return a list with 1 tweet id -> [5],
//// since user 1 is no longer following user 2.
//twitter.getNewsFeed(1);
// 
// Related Topics Hash Table Heap Design 
// 👍 1205 👎 226

  package com.miueon.leetcode.editor.en

  import java.util.*
  import kotlin.collections.ArrayList
  import kotlin.collections.HashMap
  import kotlin.collections.HashSet

  //leetcode submit region begin(Prohibit modification and deletion)
class Twitter() {

    /** Initialize your data structure here. */
    companion object {
        private var timestamp:Int = 0
    }

    internal class Tweet(val id:Int, val time:Int){
        var next:Tweet? = null
    }

    internal class User(val id:Int){
        val followed:MutableSet<Int> = HashSet()
        var head:Tweet? = null
        init {
            follow(id)
        }

        fun follow(followeeId: Int) {
            followed.add(followeeId)
        }

        fun unfollow(followeeId: Int) {
            if (followeeId != id) {
                followed.remove(followeeId)
            }
        }

        fun post(tweetId: Int) {
            val twt = Tweet(tweetId, timestamp)
            timestamp++

            twt.next = head
            head = twt
        }
    }

    private val userMap = HashMap<Int, User>()

    /** Compose a new tweet. */
    fun postTweet(userId: Int, tweetId: Int) {
        if (!userMap.containsKey(userId)) {
            userMap[userId] = User(userId)
        }

        userMap[userId]!!.post(tweetId)
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    fun getNewsFeed(userId: Int): List<Int> {
        val res:MutableList<Int> = ArrayList()
        if (!userMap.containsKey(userId)) return res
        val users:Set<Int> = userMap[userId]!!.followed
        val pq = PriorityQueue<Tweet>(users.size){a, b -> b.time-a.time}

        for (id in users) {
            val twt = userMap[id]!!.head ?: continue
            pq.add(twt)
        }

        while (pq.isNotEmpty()) {
            if (res.size == 10) {
                return res
            }

            val twt = pq.poll()
            res.add(twt.id)
            if (twt.next != null) {
                pq.add(twt.next)
            }
        }
        return res
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    fun follow(followerId: Int, followeeId: Int) {
        if (!userMap.containsKey(followeeId)) {
            userMap[followeeId] = User(followeeId)
        }
        if (!userMap.containsKey(followerId)) {
            userMap[followerId] = User(followerId)
        }

        userMap[followerId]!!.follow(followeeId)
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    fun unfollow(followerId: Int, followeeId: Int) {
        if (userMap.containsKey(followerId)) {
            userMap[followerId]!!.unfollow(followeeId)
        }
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * var obj = Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */
//leetcode submit region end(Prohibit modification and deletion)

  
 