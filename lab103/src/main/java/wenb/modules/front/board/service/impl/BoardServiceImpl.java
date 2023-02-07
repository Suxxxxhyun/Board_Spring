package wenb.modules.front.board.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import wenb.modules.admin.user.vo.commentListVO;
import wenb.modules.front.board.mapper.BoardMapper;
import wenb.modules.front.board.service.BoardService;
import wenb.modules.front.board1.vo.Board1VO;
import wenb.modules.front.board1.vo.ReplyVO;

@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService{
	
	@Resource(name="boardMapper")
	BoardMapper boardMapper; //BoardController에서 설명한 것과 같음. 결국 mapper의 메서드를 호출하기위해 자동주입을 해줌

	@Override
	public List getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board1VO getInfo(Board1VO vo) throws Exception {
		// TODO Auto-generated method stub
		return boardMapper.selectInfo(vo);
	}

	/*ReplyVO를 파라미터로 넘겨주는 이유
	"http://localhost:8070/front/board/getInfo.do?seq=2"이런식으로 브라우저에 요청하게 될텐데, 이때의 seq는 board1테이블의 seq이고 이것과
	같은 값을 가지고 있는 것이 TB_BOARD_COMMENTS테이블의 board_id임. board_id는 ReplyVO의 있는 값이잖아? 그래서 2를 넘겨주기 위해서 파라미터로 ReplyVO를 넘겨줌
	*/
	/*
	 * 댓글 조회
	 */
	@Override
	public List<ReplyVO> getCommentList(ReplyVO vo) throws Exception {
		return boardMapper.selectCommentList(vo);
	}

	@Override
	public void createComment(ReplyVO vo) throws Exception {
		boardMapper.insertComment(vo);
		
	}

	/**
	 * 게시판 목록 반환
	 */
	@Override
	public List<Board1VO> getBoard1List(Board1VO vo) throws Exception {
		return boardMapper.selectBoard1List(vo);
	}
	
	/*
	 * 게시판 내용 수정
	 */
	@Override
	public void modifyBoard(Board1VO vo) throws Exception{
		boardMapper.updateBoard(vo);
	}
	
	/**
	 * 게시판 등록
	 */
	@Override
	public void createBoard(Board1VO vo) throws Exception{
		boardMapper.insertBoard(vo);
	}
	
	
}
