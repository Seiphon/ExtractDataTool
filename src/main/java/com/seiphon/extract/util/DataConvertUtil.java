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