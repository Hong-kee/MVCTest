package hongki.dao;

import hongki.mapper.MyBoardMapper;
import hongki.model.MyBoard;
import hongki.model.MyReply;
import hongki.model.Search;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BoardDao {
    private static BoardDao boardDao = new BoardDao();

    public static BoardDao getInstance() {
        return boardDao;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    //게시글 목록
    public List<MyBoard> listBoard(int startRow, Search search) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<MyBoard> list = null;

        try {
             list = sqlSession.getMapper(MyBoardMapper.class).listBoard(search, new RowBounds(startRow, 5));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return list;
    }

    //DB 글 갯수
    public int countBoard(Search search) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = 0;

        try {
            result = sqlSession.getMapper(MyBoardMapper.class).countBoard(search);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return result;
    }

    //글 작성
    public int insertBoard(MyBoard myBoard) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = 0;

        try {
            result = sqlSession.getMapper(MyBoardMapper.class).insertBoard(myBoard);
            if (result > 0) sqlSession.commit();
            else sqlSession.rollback();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return result;
    }

    //글 상세
    public MyBoard detailBoard(int seq) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        MyBoard myBoard = new MyBoard();

        try {
            myBoard = sqlSession.getMapper(MyBoardMapper.class).detailBoard(seq);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return myBoard;
    }

    //글 삭제
    public int deleteBoard(int seq) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;

        try {
            result = sqlSession.getMapper(MyBoardMapper.class).deleteBoard(seq);

            if (result > 0) sqlSession.commit();
            else sqlSession.rollback();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return result;
    }

    //글 업데이트
    public int updateBoard(MyBoard myBoard) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;

        try {
            result = sqlSession.getMapper(MyBoardMapper.class).updateBoard(myBoard);

            if (result > 0) sqlSession.commit();
            else sqlSession.rollback();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return result;
    }

    //댓글 쓰기
    public int insertReply(MyReply myReply) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = 0;

        try {
            result = sqlSession.getMapper(MyBoardMapper.class).insertReply(myReply);
            if (result > 0) sqlSession.commit();
            else sqlSession.rollback();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return result;
    }

    //댓글 목록 출력
    public List<MyReply> listReply(int seq) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<MyReply> list = null;

        try {
            list = sqlSession.getMapper(MyBoardMapper.class).listReply(seq);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return list;
    }
}
