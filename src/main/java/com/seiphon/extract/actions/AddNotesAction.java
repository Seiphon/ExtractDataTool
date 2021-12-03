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

package com.seiphon.extract.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

import com.seiphon.extract.dialog.AddNoteDialog;
import com.seiphon.extract.note.DataCenter;

/**
 * @author Seiphon Wang
 */
public class AddNotesAction extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent actionEvent) {
		Editor editor = actionEvent.getRequiredData(CommonDataKeys.EDITOR);

		SelectionModel selectionModel = editor.getSelectionModel();

		DataCenter.selectedText = selectionModel.getSelectedText();

		PsiFile psiFile = actionEvent.getRequiredData(CommonDataKeys.PSI_FILE);

		VirtualFile virtualFile = psiFile.getVirtualFile();

		DataCenter.fileName = virtualFile.getName();

		AddNoteDialog addNoteDialog = new AddNoteDialog();

		addNoteDialog.show();
	}

}