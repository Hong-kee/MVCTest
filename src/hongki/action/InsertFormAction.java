package hongki.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertFormAction implements Action{
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();

        actionForward.setCheckRedirect(false);
        actionForward.setPath("/insert-form.jsp");

        return actionForward;
    }
}
