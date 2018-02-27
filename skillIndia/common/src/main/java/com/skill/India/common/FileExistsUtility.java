/**
 * 
 */
package com.skill.India.common;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Ruchi
 *
 */
@Service
public class FileExistsUtility {
	
	@Autowired
	private ReadApplicationConstants readApplicationConstants;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileExistsUtility.class);

	/**
	 * Checks if file exists given filePath, fileName and fileExtension
	 * @param filePath Path of folder where file needs to be searched
	 * @param fileNameWithExtension Name of file that needs to be searched
	 * @param fileExtension Extension of file that needs to be searched
	 * @return returns 1 if file found and 0 if not . returns -1 if path is empty and -2 if exception occured
	 */
	public int checkFileExistence(String filePath , String fileNameWithExtension)
	{
		int fileExists = -10;
		try 
		{
			
			LOGGER.debug("Trying to construct path of file" + fileNameWithExtension);
			if ((filePath != null && fileNameWithExtension != null) && !(filePath.isEmpty()&&fileNameWithExtension.isEmpty()))
			{
				LOGGER.debug("Trying to look for a file with name " +filePath +fileNameWithExtension);
				String absolutefilePath = filePath +fileNameWithExtension;
				File file = new File(absolutefilePath);
				if(file.exists())
				{
					LOGGER.debug("File Exists with the name " + fileNameWithExtension);
					fileExists = 1;
				}
				else
				{
					LOGGER.debug("File with the name "+fileNameWithExtension+ "does not exists");
					fileExists = 0;
				}
			}
			else
			{
				fileExists = -1;
				LOGGER.debug("File path is empty.Can not look for a file with name "+ filePath +fileNameWithExtension);
			}
			
			
		}
		catch(Exception e)
		{
			LOGGER.debug("An exception occured while finding if file exists or not " +e);
			fileExists = -2;
		}
		return fileExists;
	}
}
