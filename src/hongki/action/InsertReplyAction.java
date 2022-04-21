package hongki.action;


import hongki.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertReplyAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        BoardService boardService = BoardService.getInstance();

        boardService.insertReplyService(request, response);

        actionForward.setPath("detail?seq=" + request.getParameter("seq"));
        actionForward.setCheckRedirect(true);

        return actionForward;
    }
}
