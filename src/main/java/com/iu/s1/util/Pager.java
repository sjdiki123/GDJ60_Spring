package com.iu.s1.util;

public class Pager {

	// 검색종류 (사용할 column)
	private String kind;
	//검색오 
	private String search;
	
	
	
	//client 가 보고 싶은 페이지 번호 (parameter)
	private long page;
	//한페이지에 출력할 row의 갯수
	private long perPage;
	
	
	//한브럭당 추력할 번호의 갯수
	private Long perBlock;
	
	//table에서 조회할 시작번호 
	private Long startRow;
	//table에서 조회할 끝번호 
	private Long lastRow;
	
	private Long totalCount;
	 
	private Long startNum;
	private Long lastNum;
	
	
	
	
	public void makRow() {
		
		this.startRow =(this.page-1) *this.perPage+1;
		this.lastRow = this.page*this.perPage;
	}
	
	
	// startNum , lastNum
	public void makeNum() {
		//1.전체 row의 갯수 구하기
		//2.총 page의 갯수 구하기
		Long totalPage = this.totalCount/this.getPerPage();
		if(this.totalCount%this.getPerPage() !=0) {
		//	totalPage= totalPage+1;
		//totalPage +=1;
			totalPage++;
			
		}
		if (this.getPage()>totalPage){
			this.setPage(totalPage);
		}
		//3.한 블럭에 출력할 번호의 갯수 
		Long perBlock=5L;
		
		//4. 총 블럭의 수 구하기 
		Long totaBlock = totalPage/perBlock;
		if(totalPage % perBlock !=0) {
			totaBlock++;
		}
	//	5. page 번호로 현재 블럭 번호 구하디
		//page1-5 curBlock 1
		//page6-10 curBlock 2
		Long curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock !=0) {
			curBlock++;
		}
		//6.curBlock의 시작번호와 끝번호를 계산 
//		cur block      startnum    lastnum
//		1                  1            5      
//		2                  6           10
//      3                 11           15
		
		this.startNum=(curBlock-1)*perBlock;
		this.lastNum=curBlock*perBlock;
		
		
		if (curBlock==totaBlock) {
			lastNum=totalPage;
		}
	
	}
	
	
	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getSearch() {
		if(search == null) {
			search="";
		}
		return    search; //"%"+search+"%";
	}


	public void setSearch(String search) {
		this.search = search;
	}


	public Long getStartNum() {
		return startNum;
	}


	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}


	public Long getLastNum() {
		return lastNum;
	}


	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}


	public Long getPerBlock() {
	
		return perBlock;
	}


	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}


	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public long getPage() {

		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getPerPage() {
		return perPage;
	}
	public void setPerPage(long perPage) {
		this.perPage = perPage;
	}
	public Long getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}


	
	
}
