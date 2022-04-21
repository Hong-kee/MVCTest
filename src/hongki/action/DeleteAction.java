package hongki.action;

import hongki.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        BoardService boardService = BoardService.getInstance();
        ActionForward actionForward = new ActionForward();

        boardService.deleteBoardService(Integer.parseInt(request.getParameter("seq")));

        actionForward.setCheckRedirect(true);//redirect
        actionForward.setPath("/board/list");

        return actionForward;
    }
}
