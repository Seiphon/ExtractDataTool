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