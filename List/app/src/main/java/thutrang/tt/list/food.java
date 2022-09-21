package thutrang.tt.list;

public class food {
    String title;
    String content;
    String money;
    int imageId;

    public food() {
    }

    public food(String title, String content, String money, int imageId) {
        this.title = title;
        this.content = content;
        this.money = money;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
