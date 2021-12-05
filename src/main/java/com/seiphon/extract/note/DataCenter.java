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

package com.seiphon.extract.note;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 * @author Seiphon Wang
 */
public class DataCenter {

	public static String[] columHheader = {"Title", "Annotation", "File Name", "Code Fragment"};
	public static String fileName;
	public static List<NoteData> noteData = new LinkedList<>();
	public static String selectedText;
	public static DefaultTableModel tableModel = new DefaultTableModel(null, columHheader);

	public static void reset() {
		noteData.clear();

		tableModel.setDataVector(null, columHheader);
	}

}