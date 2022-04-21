package hongki.service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import hongki.dao.BoardDao;
import hongki.model.*;
import hongki.util.ImageUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

public class BoardService extends HttpServlet {
    private static final BoardService boardService = new BoardService();
    private static BoardDao boardDao;
    private static final int PAGE_SIZE = 5;

    public static BoardService getInstance() {
        boardDao = BoardDao.getInstance();
        return boardService;
    }

    //글 읽어오기
    public ListModel listBoardService(HttpServletRequest request, HttpServletResponse response) throws Exception{

        Search search = new Search();
        HttpSession httpSession = request.getSession();

        /**
         * 검색
         */
        if (request.getParameterValues("area") != null) {
            httpSession.removeAttribute("search");
            search.setArea(request.getParameterValues("area"));
            search.setSearchKey("%"+request.getParameter("searchKey")+"%");
            httpSession.setAttribute("search", search);
        } else if (request.getParameterValues("area") == null
                && request.getParameter("pageNum") == null) {
            httpSession.removeAttribute("search");
        }

        if (httpSession.getAttribute("search") != null) {
            search = (Search) httpSession.getAttribute("search");
        }

        /**
         * 페이징 처리
         */
        int totalCount = boardDao.countBoard(search);

        int totalPage = totalCount / PAGE_SIZE;
        if (totalCount % PAGE_SIZE != 0) totalPage++;

        String pageNum = request.getParameter("pageNum");
        if (pageNum == null) pageNum = "1";
        int curPage = Integer.parseInt(pageNum);

        int startPage = curPage - (curPage - 1) % 5;

        int endPage = startPage + 4;
        if (endPage > totalPage) endPage = totalPage;

        int startRow = (curPage - 1) * PAGE_SIZE;

        List<MyBoard> list = boardDao.listBoard(startRow, search);
        ListModel listModel = new ListModel(list, curPage, totalPage, startPage, endPage);

        return listModel;
    }

    //글 작성
    public int insertBoardService(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");

       String uploadPath = request.getSession().getServletContext().getRealPath("upload");
       int size = 20 * 1024 * 1024;//20MB

        //파일 업로드가 완료
        MultipartRequest multipartRequest =
                new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());

        MyBoard myBoard = new MyBoard();

        myBoard.setTitle(multipartRequest.getParameter("title"));
        myBoard.setWriter(multipartRequest.getParameter("writer"));
        myBoard.setContents(multipartRequest.getParameter("contents"));
        myBoard.setF_name("");//null 아니고 빈 문자열 객체

        //파일 업로드 했을 때 [업로드한 파일 이름]
        if (multipartRequest.getFilesystemName("f_name") != null) {
            String f_name = multipartRequest.getFilesystemName("f_name");
            myBoard.setF_name(f_name);

            //썸네일 이미지(gif, jpg, png) aa.jpg => aa_small.jpg [자체적으로 규정하자]
            String pattern = f_name.substring(f_name.indexOf(".") + 1);//gif, jpg, png..
            String head = f_name.substring(0, f_name.indexOf("."));//aa

            //원본 파일 객체
            String imagePath = uploadPath + "\\" + f_name;//aa.jpg
            File src = new File(imagePath);

            //썸네일 파일 객체
            String thumbNailPath = uploadPath + "\\" + head + "_small." + pattern;//aa_small.jpg
            File dest = new File(thumbNailPath);

            if (pattern.equals("gif") || pattern.equals("jpg") || pattern.equals("png") ||
                    pattern.equals("GIF") || pattern.equals("JPG") ||pattern.equals("PNG")) {
                ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
            }
        }

        return boardDao.insertBoard(myBoard);
    }

    //글 상세
    public MyBoard detailBoardService(int seq) throws Exception {
        return boardDao.detailBoard(seq);
    }

    //글 삭제 Service logic
    public int deleteBoardService(int seq) throws Exception {
        return boardDao.deleteBoard(seq);
    }

    //글 수정
    public int updateBoardService(HttpServletRequest request, HttpServletResponse response) throws Exception{

        request.setCharacterEncoding("UTF-8");
        MyBoard myBoard = new MyBoard();

        myBoard.setSeq(Integer.parseInt(request.getParameter("seq")));
        myBoard.setTitle(request.getParameter("title"));
        myBoard.setContents(request.getParameter("contents"));

        return boardDao.updateBoard(myBoard);
    }

    //댓글 쓰기
    public int insertReplyService(HttpServletRequest request, HttpServletResponse response) throws Exception{

        request.setCharacterEncoding("UTF-8");

        MyReply myReply = new MyReply();

        myReply.setMr_title(request.getParameter("mr_title"));
        myReply.setMr_writer(request.getParameter("mr_writer"));
        myReply.setMr_contents(request.getParameter("mr_contents"));
        myReply.setMr_regDate(request.getParameter("mr_regDate"));
        myReply.setSeq(Integer.parseInt(request.getParameter("seq")));

        return boardDao.insertReply(myReply);
    }

    //댓글 리스트 출력
    public List<MyReply> listReplyService(HttpServletRequest request, HttpServletResponse response) throws Exception{
        return boardDao.listReply(Integer.parseInt(request.getParameter("seq")));
    }
}
