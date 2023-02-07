package wenb.modules.front.board.mapper;

import java.io.IOException;
import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import wenb.modules.admin.user.vo.commentListVO;
import wenb.modules.front.board1.vo.Board1VO;
import wenb.modules.front.board1.vo.ReplyVO;

@Mapper
public interface BoardMapper {
	public Board1VO selectInfo(Board1VO vo) throws Exception;
	
	public List<ReplyVO> selectCommentList(ReplyVO vo) throws Exception;
	
	/**
	 * 
	 * 댓글 등록
	 * <pre>
	 * </pre>
	 * @method insertComment
	 * @return void
	 * @date 2022. 12. 16.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	public void insertComment(ReplyVO vo) throws Exception;
	
	/**
	 * 게시판 목록 반환
	 * <pre>
	 * </pre>
	 * @method selectBoard1List
	 * @return List<Board1VO>
	 * @date 2022. 12. 9.
	 * @author qkrtn
	 * @param vo
	 * @return
	 * @throws IOException
	 */
	public List<Board1VO> selectBoard1List(Board1VO vo) throws IOException;

	
	/**
	 * 게시판 내용 수정
	 * <pre>
	 * </pre>
	 * @method updateBoard
	 * @return void
	 * @date 2022. 12. 9.
	 * @author qkrtn
	 * @param vo
	 * @throws IOException
	 */
	public void updateBoard(Board1VO vo) throws IOException;
	
	/**
	 * 게시판 등록
	 * <pre>
	 * </pre>
	 * @method insertBoard
	 * @return void
	 * @date 2022. 12. 9.
	 * @author qkrtn
	 * @param vo
	 * @throws IOException
	 */
	public void insertBoard(Board1VO vo) throws IOException;
}
