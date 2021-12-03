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

package com.seiphon.extract.view.windows;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageDialogBuilder;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;

import com.seiphon.extract.note.DataCenter;
import com.seiphon.extract.processor.DefaultSourceNoteData;
import com.seiphon.extract.processor.MDFreeMarkProcessor;
import com.seiphon.extract.processor.Processor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author Seiphon Wang
 */
public class NoteListWindow {

	public NoteListWindow(Project project, ToolWindow toolWindow) {
		_init();

		_generateDocButton.addActionListener(
			new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String topicTitleText = _topicTitle.getText();

					String fileName = topicTitleText + ".md";

					if (Objects.isNull(topicTitleText) || Objects.equals(topicTitleText, "")) {
						MessageDialogBuilder.yesNo(
							"Warning", "not input document title yet"
						).show();

						return;
					}

					VirtualFile virtualFile = FileChooser.chooseFile(
						FileChooserDescriptorFactory.createSingleFileDescriptor(), project, project.getBaseDir());

					if (virtualFile != null) {
						String path = virtualFile.getPath();

						String fileFullPath = path + File.separator + fileName;

						Processor processor = new MDFreeMarkProcessor();

						try {
							processor.process(
								new DefaultSourceNoteData(fileFullPath, topicTitleText, DataCenter.noteData));

							NotificationGroup notificationGroup = new NotificationGroup(
								"note_id", NotificationDisplayType.BALLOON, true);

							Notification notification = notificationGroup.createNotification(
								"Successfully generated document: " + fileFullPath, MessageType.INFO);

							Notifications.Bus.notify(notification);
						}
						catch (Exception exception) {
							exception.printStackTrace();
						}
					}
				}

			});
		_clearTheListButton.addActionListener(
			new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DataCenter.reset();
				}

			});
		_closeButton.addActionListener(
			new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					toolWindow.hide();
				}

			});
	}

	public JPanel getMainPanel() {
		return _mainPanel;
	}

	private void _init() {
		_contentTable.setModel(DataCenter.tableModel);

		_contentTable.setEnabled(true);
	}

	private JButton _clearTheListButton;
	private JButton _closeButton;
	private JTable _contentTable;
	private JButton _generateDocButton;
	private JPanel _mainPanel;
	private JTextField _topicTitle;

}