package hongki.controller;

import hongki.action.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/*")
public class Controller extends HttpServlet {

    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
        String path = url.substring(7);

        Action action = null;
        ActionForward actionForward = null;

        if (path.equals("list")) {
            action = new ListAction();

            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("insert-form")) {
            action = new InsertFormAction();

            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("insert")) {
            action = new InsertAction();
            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("detail")) {
            action = new DetailAction();
            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("insertReply")) {
            action = new InsertReplyAction();
            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("delete")) {
            action = new DeleteAction();
            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("update")) {
            action = new UpdateAction();
            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (path.equals("updateform")) {
            action = new UpdateFormAction();
            try {
                actionForward = action.execute(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        if (actionForward != null) {
            if (actionForward.isCheckRedirect()) response.sendRedirect(actionForward.getPath());
            else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(actionForward.getPath());
                requestDispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}
