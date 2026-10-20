package store;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Database_map_file {

	public String Sort(int count, File file, String m) throws IOException {

		int minnum = 100;
		String name = null;
		int maxmum = 0;

		BufferedReader breader = new BufferedReader(new FileReader(file));
		Map<String, Integer> map = new HashMap<String, Integer>();

		String line;
		while ((line = breader.readLine()) != null) {
			if (count == 0) {
				if (map.get(line) != null) {
					map.put(line, map.get(line) + 1);
				} else {
					map.put(line, 1);
				}

			}
			count++;
			if (count == 5) {
				count = 0;
			}

		}

		if (m.equals("MAX")) {

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() > maxmum) {
					maxmum = entry.getValue();
					name = entry.getKey();
				}

			}
		} else

		{
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() < minnum) {
					minnum = entry.getValue();
					name = entry.getKey();

				}

			}
		}
		return name;

	}

}
