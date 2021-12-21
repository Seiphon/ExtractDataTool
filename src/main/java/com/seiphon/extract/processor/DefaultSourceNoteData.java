package com.seiphon.extract.processor;

import com.seiphon.extract.note.NoteData;

import java.util.List;

/**
 * @author Seiphon Wang
 */
public class DefaultSourceNoteData implements SourceNoteData {

	public DefaultSourceNoteData(String fileName, String topic, List<NoteData> noteDataList) {
		_fileName = fileName;
		_topic = topic;
		_noteDataList = noteDataList;
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public List<NoteData> getNoteList() {
		return _noteDataList;
	}

	@Override
	public String getTopic() {
		return _topic;
	}

	private String _fileName;
	private List<NoteData> _noteDataList;
	private String _topic;

}