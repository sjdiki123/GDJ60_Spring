  package com.iu.s1.board;

import java.util.List;

public interface BoardDAO  extends BbsDAO{

	//list	
	
	
	//detail
	
	public BoardDTO getBoardDetail(BoardDTO boardDTO) throws Exception;
	
	
	
	
	//fileadd
	public int setBoardFileAdd( BoardFileDTO boardFileDTO) throws Exception;
	
	
	//update
	
	//delete
	
	
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO) throws Exception;
	
	public BoardFileDTO getBoardFileDeteil(BoardFileDTO boardFileDTO) throws Exception;
	
	
}
