package hongki.action;

public class ActionForward {
    private String path;
    private boolean checkRedirect;

    public ActionForward() {}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isCheckRedirect() {
        return checkRedirect;
    }

    public void setCheckRedirect(boolean checkRedirect) {
        this.checkRedirect = checkRedirect;
    }
}
