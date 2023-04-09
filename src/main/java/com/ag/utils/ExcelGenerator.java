package com.ag.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ag.dto.SearchRequest;
import com.opencsv.CSVWriter;

@Component
public class ExcelGenerator {

	public void writeDataLineByLine(String filePath, List<SearchRequest> dataToWrite)
	{
		// first create file object for file placed at location
		// specified by filepath
		File file = new File(filePath);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			String[] header = {"ID", "Name", "Gender","Plan","Status" };
			writer.writeNext(header);
			
				for (SearchRequest data : dataToWrite) {
					String[] csvWritableDataObj = { String.valueOf(data.getId()),
							data.getCitizenName(), 
							data.getGender(),
							data.getPlanName(),
							data.getPlanStatus()};
					writer.writeNext(csvWritableDataObj);
				}

			// closing writer connection
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
