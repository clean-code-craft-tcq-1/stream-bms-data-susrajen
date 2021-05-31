package batteryPropertyReporter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import batteryProperty.Battery;

public class ConsolePropertyReporter implements PropertyReporter {

	@Override
	public void printReport(Battery battery) throws JsonProcessingException {
		ObjectMapper jsonMapper = new ObjectMapper();
		String batteryProperties = jsonMapper.writeValueAsString(battery);
		System.out.println(batteryProperties);
	}
}
