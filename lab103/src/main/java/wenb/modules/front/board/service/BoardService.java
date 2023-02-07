package wenb.modules.front.board.service;



import java.util.List;

import wenb.modules.front.board1.vo.Board1VO;
import wenb.modules.front.board1.vo.ReplyVO;

public interface BoardService {
	
	List getList();
	Board1VO getInfo(Board1VO vo) throws Exception;
	
	List<ReplyVO> getCommentList(ReplyVO vo) throws Exception;
	
	/**
	 * 
	 * 댓글 등록
	 * <pre>
	 * </pre>
	 * @method createComment
	 * @return void
	 * @date 2022. 12. 16.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	void createComment(ReplyVO vo) throws Exception;
	
	/**
	 * 게시판 목록 반환
	 * <pre>
	 * </pre>
	 * @method getBoard1List
	 * @return List<Board1VO>
	 * @date 2022. 12. 9.
	 * @author qkrtn
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<Board1VO> getBoard1List(Board1VO vo) throws Exception;
	
	
	/**
	 * 게시판 내용 수정
	 * <pre>
	 * </pre>
	 * @method modifyBoard
	 * @return void
	 * @date 2022. 12. 9.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	void modifyBoard(Board1VO vo) throws Exception;
	
	/**
	 * 게시판 등록
	 * <pre>
	 * </pre>
	 * @method createBoard
	 * @return void
	 * @date 2022. 12. 9.
	 * @author qkrtn
	 * @param vo
	 * @throws Exception
	 */
	void createBoard(Board1VO vo) throws Exception;
}
