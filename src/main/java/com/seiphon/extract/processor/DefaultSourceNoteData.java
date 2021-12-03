/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

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