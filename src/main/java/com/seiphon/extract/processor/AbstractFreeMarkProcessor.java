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

import freemarker.template.Template;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Seiphon Wang
 */
public abstract class AbstractFreeMarkProcessor implements Processor {

	@Override
	public final void process(SourceNoteData sourceNoteData) throws Exception {
		Template template = getTemplate();

		template.process(getModel(sourceNoteData), getWriter(sourceNoteData));
	}

	protected abstract Object getModel(SourceNoteData sourceNoteData);

	protected abstract Template getTemplate() throws IOException;

	protected abstract Writer getWriter(SourceNoteData sourceNoteData) throws Exception, FileNotFoundException;

}