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

package com.seiphon.extract.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.ui.EditorTextField;

import com.seiphon.extract.note.DataCenter;
import com.seiphon.extract.note.NoteData;
import com.seiphon.extract.util.DataConvertUtil;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import org.jetbrains.annotations.Nullable;

/**
 * @author Seiphon Wang
 */
public class AddNoteDialog extends DialogWrapper {

	public AddNoteDialog() {
		super(true);

		setTitle("Add Annotation");

		init();
	}

	@Nullable
	@Override
	protected JComponent createCenterPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		_noteTitle = new EditorTextField("Note Title");

		_noteMark = new EditorTextField("Note Content");

		_noteMark.setPreferredSize(new Dimension(200, 100));

		panel.add(_noteTitle, BorderLayout.NORTH);
		panel.add(_noteMark, BorderLayout.CENTER);

		return panel;
	}

	@Override
	protected JComponent createSouthPanel() {
		JPanel panel = new JPanel();

		JButton addButton = new JButton("Add Note to Node List");

		addButton.addActionListener(
			e -> {
				String fileType = DataCenter.fileName.substring(DataCenter.fileName.lastIndexOf(".") + 1);

				NoteData noteData = new NoteData(
					_noteTitle.getText(), _noteMark.getText(), DataCenter.selectedText, DataCenter.fileName, fileType);

				DataCenter.noteData.add(noteData);

				DataCenter.tableModel.addRow(DataConvertUtil.convertTOStringArray(noteData));

				MessageDialogBuilder.yesNo("Opreation Result", "Successfully added");

				AddNoteDialog.this.dispose();
			});

		panel.add(addButton);

		return panel;
	}

	private EditorTextField _noteMark;
	private EditorTextField _noteTitle;

}