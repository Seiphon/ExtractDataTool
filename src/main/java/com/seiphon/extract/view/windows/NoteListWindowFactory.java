package com.seiphon.extract.view.windows;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;

import org.jetbrains.annotations.NotNull;

/**
 * @author Seiphon Wang
 */
public class NoteListWindowFactory implements ToolWindowFactory {

	@Override
	public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
		NoteListWindow noteListWindow = new NoteListWindow(project, toolWindow);

		ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();

		Content content = contentFactory.createContent(noteListWindow.getMainPanel(), "", false);

		ContentManager contentManager = toolWindow.getContentManager();

		contentManager.addContent(content);
	}

}