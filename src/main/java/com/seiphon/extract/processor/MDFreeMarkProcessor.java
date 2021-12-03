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

import com.intellij.ide.fileTemplates.impl.UrlUtil;

import freemarker.cache.StringTemplateLoader;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Seiphon Wang
 */
public class MDFreeMarkProcessor extends AbstractFreeMarkProcessor {

	@Override
	protected Object getModel(SourceNoteData sourceNoteData) {
		Map<String, Object> model = new HashMap<>();

		model.put("noteList", sourceNoteData.getNoteList());
		model.put("topic", sourceNoteData.getTopic());

		return model;
	}

	@Override
	protected Template getTemplate() throws IOException {
		Configuration configuration = new Configuration();

		String templateContent = UrlUtil.loadText(MDFreeMarkProcessor.class.getResource("/templates/md.ftl"));

		StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();

		stringTemplateLoader.putTemplate("MDTemplate", templateContent);

		configuration.setTemplateLoader(stringTemplateLoader);

		return configuration.getTemplate("MDTemplate");
	}

	@Override
	protected Writer getWriter(SourceNoteData sourceNoteData) throws Exception {
		String fileName = sourceNoteData.getFileName();

		File file = new File(fileName);

		return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
	}

}