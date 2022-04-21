package hongki.action;

import hongki.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertAction implements Action{

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        BoardService boardService = BoardService.getInstance();

        boardService.insertBoardService(request, response);

        actionForward.setPath("/board/list");
        actionForward.setCheckRedirect(true);

        return actionForward;
    }
}
