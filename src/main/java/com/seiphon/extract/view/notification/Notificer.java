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

package com.seiphon.extract.view.notification;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;

import javax.annotation.Nullable;

/**
 * @author Seiphon Wang
 */
public class Notificer {

	public static String getDisplayId() {
		NotificationGroupManager notificationGroupManager = NotificationGroupManager.getInstance();

		NotificationGroup notificationGroup = notificationGroupManager.getNotificationGroup(
			"Notification Group of EDT");

		notificationGroup.getTitle();

		return notificationGroup.getTitle();
	}

	public static <notificationGroup> void notifyError(@Nullable Project project, String content) {
		NotificationGroupManager notificationGroupManager = NotificationGroupManager.getInstance();

		NotificationGroup notificationGroup = notificationGroupManager.getNotificationGroup(
			"Notification Group of EDT");

		Notification notification = notificationGroup.createNotification(content, NotificationType.ERROR);

		notification.notify(project);
	}

	public static void notifyInfo(@Nullable Project project, String content) {
		NotificationGroupManager notificationGroupManager = NotificationGroupManager.getInstance();

		NotificationGroup notificationGroup = notificationGroupManager.getNotificationGroup(
			"Notification Group of EDT");

		Notification notification = notificationGroup.createNotification(content, NotificationType.INFORMATION);

		notification.notify(project);
	}

	public static void notifyWarning(@Nullable Project project, String content) {
		NotificationGroupManager notificationGroupManager = NotificationGroupManager.getInstance();

		NotificationGroup notificationGroup = notificationGroupManager.getNotificationGroup(
			"Notification Group of EDT");

		Notification notification = notificationGroup.createNotification(content, NotificationType.WARNING);

		notification.notify(project);
	}

}