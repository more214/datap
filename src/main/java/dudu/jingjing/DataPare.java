package dudu.jingjing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class DataPare {
	
	public static List<String[]> getFile(String filepath)
	{
		List<String[]> ls = new ArrayList<String[]>();
		InputStream in =null;
		BufferedReader br=null;
		
		
		try 
		{
			in = new FileInputStream(filepath);
			br = new BufferedReader(new InputStreamReader(in));
			String tem;
			while (!(tem=StringUtils.trimToEmpty(br.readLine())).equals(""))
			{
				String user[]=tem.split(",");
				ls.add(user);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try {
			br.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}

}
