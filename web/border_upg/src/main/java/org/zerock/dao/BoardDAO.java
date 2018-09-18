package org.zerock.dao;

import lombok.extern.log4j.Log4j;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageDTO;

import java.util.ArrayList;
import java.util.List;

@Log4j
public class BoardDAO {

    private static final String INSERT ="insert into TBL_BOARD (BNO, TITLE, CONTENT, WRITER) \n" +"VALUES (SEQ_BOARD.nextval,?,?,?)";
    private static final String UPDATE_HIT="update tbl_board set viewcnt=viewcnt+1 where bno=?";
    private static final String READ="select * from tbl_board where bno=?";
    private static final String LIST = "select *\n" +
            "from (select\n" +
            "             /*+INDEX_DESC(tbl_board pk_board) */\n" +
            "          ROWNUM rn, bno, title, CONTENT, WRITER, REGDATE, UPDATEDATE, viewcnt \n" +
            "      from TBL_BOARD\n" +
            "      where BNO > 0\n" +
            "        AND ROWNUM <= (? * ?))\n" +
            "where rn > ( ? -1) * ?";
    private static final String DELETE="delete from tbl_board where bno=?";
    private static final String MODIFY="update tbl_board set title=?,content=?, WRITER=? ,UPDATEDATE=sysdate where bno=?";
    private static final String COUNT="select *\n" +
            "from (select count(*) count from TBL_board)";

    public void modify(BoardVO vo){
        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt=con.prepareStatement(MODIFY);
                int i=1;
                stmt.setString(i++,vo.getTitle());
                stmt.setString(i++,vo.getContent());
                stmt.setString(i++,vo.getWriter());
                stmt.setInt(i++,vo.getBno());
                stmt.executeUpdate();
            }
        }.executeAll();
    }

    public void delete(int bno){
        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt=con.prepareStatement(DELETE);
                stmt.setInt(1,bno);
                stmt.executeUpdate();
            }
        }.executeAll();
    }

    public BoardVO getBoard(Integer bno,boolean updateable)throws Exception{
        BoardVO vo =new BoardVO();
        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                if(updateable){ //조회수1 추가
                    stmt=con.prepareStatement(UPDATE_HIT);
                    stmt.setInt(1,bno);
                    stmt.executeUpdate();
                    stmt.close();
                }
                stmt=con.prepareStatement(READ);
                stmt.setInt(1,bno);
                rs=stmt.executeQuery();
                while (rs.next()){
                    vo.setBno(bno);
                    vo.setRegdate(rs.getDate("regdate"));
                    vo.setUpdatedate(rs.getDate("updatedate"));
                    vo.setTitle(rs.getString("title"));
                    vo.setContent(rs.getString("content"));
                    vo.setWriter(rs.getString("writer"));
                    vo.setViewcnt(rs.getInt("viewcnt"));
                }
            }
        }.executeAll();
        return vo;
    }

    public List<BoardVO> getList(PageDTO pageDTO)throws Exception{
        List<BoardVO> list = new ArrayList<>();

        log.debug(pageDTO);
        log.debug(LIST);

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(LIST);
                int i = 1;
                stmt.setInt(i++, pageDTO.getPage());
                stmt.setInt(i++, pageDTO.getSize());
                stmt.setInt(i++, pageDTO.getPage());
                stmt.setInt(i++, pageDTO.getSize());
                rs = stmt.executeQuery();

                //bno, title, CONTENT, WRITER, REGDATE, UPDATEDATE
                while(rs.next()){
                    BoardVO vo = new BoardVO();
                    int idx = 2;
                    vo.setBno(rs.getInt(idx++));
                    vo.setTitle(rs.getString(idx++));
                    vo.setContent(rs.getString(idx++));
                    vo.setWriter(rs.getString(idx++));
                    vo.setRegdate(rs.getDate(idx++));
                    vo.setUpdatedate(rs.getDate(idx++));
                    vo.setViewcnt(rs.getInt(idx++));
                    list.add(vo);
                }
            }
        }.executeAll();
        return list;
    }

    public void create(BoardVO vo)throws Exception{

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(INSERT);
                int i = 1;
                stmt.setString(i++, vo.getTitle());
                stmt.setString(i++, vo.getContent());
                stmt.setString(i++, vo.getWriter());
                stmt.executeUpdate();
            }
        }.executeAll();

    }

    public int total()throws Exception{
        int[] hello = new int[1];
        new QueryExecutor() {

            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(COUNT);
                rs = stmt.executeQuery();
                while(rs.next()){

                    hello[0] = rs.getInt("count");
                    log.info("aaaa");
                }

            }
        }.executeAll();

        return hello[0];
    }
}