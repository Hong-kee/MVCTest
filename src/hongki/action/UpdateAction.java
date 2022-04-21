package hongki.action;

import hongki.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        BoardService boardService = BoardService.getInstance();

        boardService.updateBoardService(request, response);

        actionForward.setCheckRedirect(true);
        actionForward.setPath("/board/list");

        return actionForward;
    }
}
