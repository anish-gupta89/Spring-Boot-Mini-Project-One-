package com.ag.utils;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ag.dto.SearchRequest;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {

	private List<SearchRequest> insuranceReportData;

	public PdfGenerator(List<SearchRequest> insuranceReportData) {
		this.insuranceReportData = insuranceReportData;
	}

	private void writeTableHeader(PdfPTable table) {
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("ID", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Gender", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Plan", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Status", font));
		table.addCell(cell);
	}

	private void writeTableData(PdfPTable table) {
		for (SearchRequest requestedData : insuranceReportData) {
			table.addCell(String.valueOf(requestedData.getId()));
			table.addCell(requestedData.getCitizenName());
			table.addCell(requestedData.getGender());
			table.addCell(requestedData.getPlanName());
			table.addCell(requestedData.getPlanStatus());
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("Insurance Report", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f, 1.5f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		document.close();
		

	}
}
