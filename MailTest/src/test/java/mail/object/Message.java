package mail.object;

public class Message {
    private String time;
    private String title;

    public Message(String time ,String title){
        this.title = title;
        this.time = time;
    }

    public Message(String title){
        this.title = title;
    }

    public Message() {

    }

    public String getTime() { return time; }

    public String getTitle() {
        return title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
