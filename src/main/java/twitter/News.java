package twitter;

/**
 * @author wangyakun
 * @date 2020/4/13
 */
public class News {
    private int userId;
    private int newsId;

    public News(int userId, int newsId) {
        this.userId = userId;
        this.newsId = newsId;
    }

    public int getUserId() {
        return userId;
    }

    public int getNewsId() {
        return newsId;
    }

}
