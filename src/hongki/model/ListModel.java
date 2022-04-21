package hongki.model;

import java.util.List;

public class ListModel {
    private List<MyBoard> list;
    private int curPage;
    private int totalPage;
    private int startPage;
    private int endPage;

    public ListModel() {}

    public ListModel(List<MyBoard> list, int curPage, int totalPage, int startPage, int endPage) {
        this.list = list;
        this.curPage = curPage;
        this.totalPage = totalPage;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public List<MyBoard> getList() {
        return list;
    }

    public void setList(List<MyBoard> list) {
        this.list = list;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
