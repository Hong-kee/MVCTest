package hongki.mapper;

import hongki.model.MyBoard;
import hongki.model.MyReply;
import hongki.model.Search;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MyBoardMapper {
    List<MyBoard> listBoard(Search search, RowBounds rowBounds);
    int countBoard(Search search);
    int insertBoard(MyBoard myBoard);
    int updateBoard(MyBoard myBoard);
    int deleteBoard(int seq);
    MyBoard detailBoard(int seq);
    List<MyReply> listReply(int seq);
    int insertReply(MyReply myReply);
}
