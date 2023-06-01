package org.zerock.dao;

import org.zerock.domain.BoardVO;
import org.zerock.domain.PageDTO;

import java.util.ArrayList;
import java.util.List;

public enum BoardDAO {
    INSTANCE;
    private int count;

    final String REMOVE = "delete from tbl_board where bno = ?";
    final String MODIFY = "update tbl_board\n" +
                          "set title=?, content=?, poster=? , where bno=?";
    final String WRITE = "insert into tbl_board(bno,title,content,poster)\n" +
                        "values(seq_movie.nextval,?,?,?)";

    final String ADDVIEW = "update tbl_board\n" +
                           "set viewcount = ?\n" +
                           "where bno = ?";
    final String READ = "select * from tbl_board where bno=?";
    final String LIST = "select * from (select\n" +
                        "/*+ INDEX_DESC(tbl_board pk_board)*/\n" +
                        "ROWNUM rn, bno, title, content, writer, regdate, updatedate, VIEWCNT\n" +
                         "from TBL_BOARD\n" +
                          "where bno > 0\n" +
                          "AND ROWNUM < (? * 10))\n" +
                        "where rn > (?-1) * 10";

    public void delete(final int bno){
        new QueryExecutor(){
            @Override
            public void doJob()throws Exception{
                stmt = con.prepareStatement(REMOVE);
                stmt.setInt(1,bno);
                stmt.executeUpdate();

            }
        }.executeAll();
    }

    public void modifyMovie(final BoardVO vo){

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt=con.prepareStatement(MODIFY);
                stmt.setString(1,vo.getTitle());
                stmt.setString(2,vo.getContent());
                stmt.setString(3,vo.getPoster());
                stmt.setInt(4,vo.getBno());
                stmt.executeUpdate();
            }
        }.executeAll();

    }

    public void write(final BoardVO vo) {

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt =con.prepareStatement(WRITE);
                stmt.setString(1,vo.getTitle());
                stmt.setString(2,vo.getContent());
                stmt.setString(3,vo.getPoster());
                stmt.executeUpdate();
            }

        }.executeAll();

    }

    public BoardVO getBoard(final int bno){
        final BoardVO vo = new BoardVO();

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt=con.prepareStatement(READ);
                stmt.setInt(1,bno);
                rs=stmt.executeQuery();

                while (rs.next()){
                    vo.setBno(rs.getInt("bno"));
                    vo.setTitle(rs.getString("title"));
                    vo.setContent(rs.getString("content"));
                    vo.setPoster(rs.getString("poster"));
                    vo.setRegdate(rs.getDate("regdate"));
                    vo.setViewCount(rs.getInt("viewCount"));
                }
            }
        }.executeAll();

        return vo;
    }

    public List<BoardVO> getList(int page){
        List<BoardVO> list = new ArrayList<>();

        new QueryExecutor(){
            @Override
            public void doJob() throws Exception {

                stmt = con.prepareStatement(LIST);
                int i=1;
                stmt.setInt(i++,page);
                rs = stmt.executeQuery();

                while(rs.next()){
                    BoardVO vo= new BoardVO();

                    vo.setBno(rs.getInt("bno"));
                    vo.setTitle(rs.getString("title"));
                    vo.setContent(rs.getString("content"));
                    vo.setPoster(rs.getString("poster"));
                    vo.setRegdate(rs.getDate("regdate"));
                    vo.setViewCount(rs.getInt("viewCount"));

                    list.add(vo);
                }
            }
        }.executeAll();

        return list;
    }

    public int countMovie() {
        final String sql = "select count(*) count from tbl_board";
        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    BoardVO vo = new BoardVO();
                    vo.setCount(rs.getInt("count"));
                    count = vo.getCount();
                }

            }
        }.executeAll();

        return count;
    }

    public void addView(final int bno){
        new QueryExecutor(){
            @Override
            public void doJob() throws Exception{
                BoardVO vo = getBoard(bno);
                int view = vo.getViewCount();
               stmt = con.prepareStatement(ADDVIEW);
                stmt.setInt(1,view+1);
                stmt.setInt(2,bno);
                stmt.executeQuery();

            }
        }.executeAll();
    }
}
