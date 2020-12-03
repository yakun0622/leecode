package twitter;

import java.util.*;

/**
 * @author wangyakun
 * @date 2020/4/13
 */
public class User {
    private Integer userId;
    private PriorityQueue<Integer> followees;

    public User(Integer userId) {
        this.userId = userId;
        this.followees = new PriorityQueue<>();
    }

    public PriorityQueue<Integer> getFollowees() {
        return followees;
    }

    public void addFollowee(Integer followeeId) {
        if (!followees.contains(followeeId)) {
            followees.add(followeeId);
        }
    }

    public void delFollowee(Integer followeeId) {
        if (followees.contains(followeeId)) {
            followees.remove(followeeId);
        }
    }
}
