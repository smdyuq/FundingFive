package kr.co.green.common;

public class PageInfo {

	public PageInfo(int listCount, int currentPage, int pageLimit, int boardiLimit, int maxPage, int startPage,
			int endPage, int offset) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardiLimit = boardiLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.offset = offset;
	}

	// 전체 게시글 수
	private int listCount;

	// 현재 페이지
	private int currentPage;

	// 한 페이지에 보여질 페이지 수
	private int pageLimit;

	// 한 페이지에 들어갈 게시글 수
	private int boardiLimit;

	// 전체 페이지
	private int maxPage;

	// 시작 페이지
	private int startPage;

	// 끝 페이지
	private int endPage;
	
	//오프셋
	private int offset;
	

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardiLimit() {
		return boardiLimit;
	}

	public void setBoardiLimit(int boardiLimit) {
		this.boardiLimit = boardiLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	

}
