package com.kevin.mirs.vo;


public class SimpleUserMessage {

    private String from;
    private String to;
    private int type;
    private String content;

    public SimpleUserMessage() {
    }

    public SimpleUserMessage(String from, String to, int type, String content) {
        this.from = from;
        this.to = to;
        this.type = type;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "SimpleUserMessage{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                '}';
    }
}
