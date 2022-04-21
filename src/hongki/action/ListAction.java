package hongki.action;

import hongki.model.ListModel;
import hongki.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements Action{

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForward actionForward = new ActionForward();
        BoardService boardService = BoardService.getInstance();

        ListModel listModel = boardService.listBoardService(request, response);
        request.setAttribute("listModel", listModel);

        actionForward.setPath("/list.jsp");
        actionForward.setCheckRedirect(false);

        return actionForward;
    }
}
