package com.seiphon.extract.processor;

import com.seiphon.extract.note.NoteData;

import java.util.List;

/**
 * @author Seiphon Wang
 */
public interface SourceNoteData {

	public String getFileName();

	public List<NoteData> getNoteList();

	public String getTopic();

}