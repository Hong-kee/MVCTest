package hongki.model;

import java.io.Serializable;

public class MyReply implements Serializable {
    private int mr_no;
    private String mr_title;
    private String mr_writer;
    private String mr_contents;
    private String mr_regDate;
    private int seq;

    public MyReply() {}

    public int getMr_no() {
        return mr_no;
    }

    public void setMr_no(int mr_no) {
        this.mr_no = mr_no;
    }

    public String getMr_title() {
        return mr_title;
    }

    public void setMr_title(String mr_title) {
        this.mr_title = mr_title;
    }

    public String getMr_writer() {
        return mr_writer;
    }

    public void setMr_writer(String mr_writer) {
        this.mr_writer = mr_writer;
    }

    public String getMr_contents() {
        return mr_contents;
    }

    public void setMr_contents(String mr_contents) {
        this.mr_contents = mr_contents;
    }

    public String getMr_regDate() {
        return mr_regDate;
    }

    public void setMr_regDate(String mr_regDate) {
        this.mr_regDate = mr_regDate;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
