package batteryPropertyReporter;

import com.fasterxml.jackson.core.JsonProcessingException;

import batteryProperty.Battery;

public interface PropertyReporter {
	void printReport(Battery battery) throws JsonProcessingException;
}
