package com.seiphon.extract.note;

/**
 * @author Seiphon Wang
 */
public class NoteData {

	public NoteData(String title, String mark, String content, String fileName, String fileType) {
		_title = title;
		_mark = mark;
		_content = content;
		_fileName = fileName;
		_fileType = fileType;
	}

	public String getContent() {
		return _content;
	}

	public String getFileName() {
		return _fileName;
	}

	public String getFileType() {
		return _fileType;
	}

	public String getMark() {
		return _mark;
	}

	public String getTitle() {
		return _title;
	}

	public void setContent(String content) {
		_content = content;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public void setFileType(String fileType) {
		_fileType = fileType;
	}

	public void setMark(String mark) {
		_mark = mark;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private String _content;
	private String _fileName;
	private String _fileType;
	private String _mark;
	private String _title;

}