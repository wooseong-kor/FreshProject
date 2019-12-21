package com.min.fresh.dto;

import java.io.Serializable;

public class RowNum_DTO implements Serializable{

	private static final long serialVersionUID = 5912217186778872926L;
	private int pageList; // 출력할 페이지 번호 갯수
	private int index;    // 출력할 페이지들 번호
	private int pageNum;  // 출력할 페이지 시작 번호
	private int listNum;  // 출력할 리스트 갯수
	private int total;    // 리스트의 총 갯수
	
	{
		pageList = 5;
		index = 0;
		pageNum = 1;
		listNum = 5;
	}
	
	@Override
	public String toString() {
		return "RowNum_DTO [출력할 페이지 번호 갯수=" + pageList + ", 출력할 페이지들 번호=" + index + ", 출력할 페이지 시작 번호=" + pageNum + ", 출력할 리스트 갯수=" + listNum
				+ ", 리스트의 총 갯수=" + total + "]";
	}
	
	public RowNum_DTO() {
	
	}
	
	public RowNum_DTO(String index, String pageNum,String listNum) {
		if (index != null) {
			this.index = Integer.parseInt(index);
		}
		if (pageNum != null) {
			this.pageNum = Integer.parseInt(pageNum);
		}
		if (listNum != null) {
			this.listNum = Integer.parseInt(listNum);
		}
	}
	
	// 시작 페이지 번호 (글 리스트 중 시작번호)
	public int getFirst() {
		return index*listNum+1;
	}
	// 끝 페이지 번호  (글 리스트 중 끝번호)
	public int getLast() {
		return (index*listNum)+listNum;
	}
	// 카운트 
	public int getCount() {
		// 전체개수 - 출력 리스트 * (페이지 시작번호 -1)
		int temp = total - listNum*(pageNum-1); // 뿌려질 남은 게시글의 수
		//  18  =   90  /  5  
		int min = temp/listNum; // 페이지의 장수
		
		if (temp%listNum != 0) {
			min++;
		}
		
		int count =0;
		if (temp<=listNum) {
			count = pageNum;
		}else if (min <= pageList) {
			count = min+pageNum-1;
		}else {
			count = pageList+pageNum-1;
		}
		
		return count;
	}

	public int getPageList() {
		return pageList;
	}

	public void setPageList(int pageList) {
		this.pageList = pageList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getListNum() {
		return listNum;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
