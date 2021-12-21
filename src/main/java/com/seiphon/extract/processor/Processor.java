package com.seiphon.extract.processor;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * @author Seiphon Wang
 */
public interface Processor {

	public void process(SourceNoteData sourceNoteData) throws Exception, IOException, TemplateException;

}