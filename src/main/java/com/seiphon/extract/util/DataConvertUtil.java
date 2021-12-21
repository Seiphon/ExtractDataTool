package com.seiphon.extract.util;

import com.seiphon.extract.note.NoteData;

/**
 * @author Seiphon Wang
 */
public class DataConvertUtil {

	public static String[] convertTOStringArray(NoteData noteData) {
		String[] raws = new String[4];

		raws[0] = noteData.getTitle();
		raws[1] = noteData.getMark();
		raws[2] = noteData.getFileName();
		raws[3] = noteData.getContent();

		return raws;
	}

}