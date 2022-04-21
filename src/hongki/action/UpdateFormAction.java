package hongki.action;

import hongki.model.MyBoard;
import hongki.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateFormAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        BoardService boardService = BoardService.getInstance();
        ActionForward actionForward = new ActionForward();

        MyBoard myBoard = boardService.detailBoardService(Integer.parseInt(request.getParameter("seq")));
        request.setAttribute("myBoard", myBoard);

        actionForward.setCheckRedirect(false);
        actionForward.setPath("/updateForm.jsp");

        return actionForward;
    }
}
