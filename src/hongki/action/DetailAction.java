package hongki.action;

import hongki.model.MyBoard;
import hongki.model.MyReply;
import hongki.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class DetailAction implements Action{

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BoardService boardService = BoardService.getInstance();
        ActionForward actionForward = new ActionForward();

        MyBoard myBoard = boardService.detailBoardService(Integer.parseInt(request.getParameter("seq")));
        List<MyReply> listReply = boardService.listReplyService(request, response);

        request.setAttribute("myBoard", myBoard);
        request.setAttribute("listReply", listReply);

        actionForward.setPath("/detail.jsp");
        actionForward.setCheckRedirect(false);

        return actionForward;
    }
}
