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