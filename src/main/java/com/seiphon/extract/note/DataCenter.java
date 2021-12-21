package com.seiphon.extract.note;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

/**
 * @author Seiphon Wang
 */
public class DataCenter {

	public static String[] columHheader = {"Title", "Annotation", "File Name", "Code Fragment"};
	public static String fileName;
	public static List<NoteData> noteData = new LinkedList<>();
	public static String selectedText;
	public static DefaultTableModel tableModel = new DefaultTableModel(null, columHheader);

	public static void reset() {
		noteData.clear();

		tableModel.setDataVector(null, columHheader);
	}

}