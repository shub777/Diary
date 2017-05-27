package model;

/**
 * Created by ShubhamBhama on 26-04-2016.
 */
public class MyWish
{

    private int itemId;
    public String content;
    public String recordDate;
    public String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
