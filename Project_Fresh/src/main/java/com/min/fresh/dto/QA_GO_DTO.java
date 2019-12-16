package com.min.fresh.dto;

import java.io.Serializable;
import java.util.Date;

public class QA_GO_DTO implements Serializable{

	private static final long serialVersionUID = -1177410309995802513L;
	private String seq;
	private String id;
	private Date regdate;
	private String title;
	private String content;
	private String gubun;
	
	//FileImg 테이블 컬럼
	private String fileseq;
	private String filename;
	private String savename;
	private String filepath;
	private Date savedate;
	
	//Answer 테이블 컬럼
	private String acontent;
	private Date aregdate;
	
	public QA_GO_DTO() {}
	/**
	 * @author ChoiWooSeong
	 * 파일없이 질문만 입력
	 * @param seq
	 * @param id
	 * @param regdate
	 * @param title
	 * @param content
	 * @param gubun
	 * @since 2019-12-04
	 */
	public QA_GO_DTO(String seq, String id, Date regdate, String title, String content, String gubun) {
		super();
		this.seq = seq;
		this.id = id;
		this.regdate = regdate;
		this.title = title;
		this.content = content;
		this.gubun = gubun;
	}

	/**
	 * @author ChoiWooSeong
	 * 파일과 질문을 같이 입력
	 * @param seq
	 * @param id
	 * @param regdate
	 * @param title
	 * @param content
	 * @param gubun
	 * @param fileseq
	 * @param filename
	 * @param savename
	 * @param filepath
	 * @param savedate
	 * @since 2019-12-04
	 */
	public QA_GO_DTO(String seq, String id, Date regdate, String title, String content, String gubun, String fileseq,
			String filename, String savename, String filepath, Date savedate) {
		super();
		this.seq = seq;
		this.id = id;
		this.regdate = regdate;
		this.title = title;
		this.content = content;
		this.gubun = gubun;
		this.fileseq = fileseq;
		this.filename = filename;
		this.savename = savename;
		this.filepath = filepath;
	}

	@Override
	public String toString() {
		return "QA_GO_DTO [seq=" + seq + ", id=" + id + ", regdate=" + regdate + ", title=" + title + ", content="
				+ content + ", gubun=" + gubun + ", fileseq=" + fileseq + ", filename=" + filename + ", savename="
				+ savename + ", filepath=" + filepath + ", savedate=" + savedate + "]";
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getFileseq() {
		return fileseq;
	}

	public void setFileseq(String fileseq) {
		this.fileseq = fileseq;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSavename() {
		return savename;
	}

	public void setSavename(String savename) {
		this.savename = savename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Date getSavedate() {
		return savedate;
	}

	public void setSavedate(Date savedate) {
		this.savedate = savedate;
	}
	public String getaContent() {
		return acontent;
	}
	public void setaContent(String acontent) {
		this.acontent = acontent;
	}
	public Date getaRegdate() {
		return aregdate;
	}
	public void setaRegdate(Date aregdate) {
		this.aregdate = aregdate;
	}
	
	

	
}
