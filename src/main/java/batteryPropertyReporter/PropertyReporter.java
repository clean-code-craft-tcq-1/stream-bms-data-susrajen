package batterypropertyreporter;

import com.fasterxml.jackson.core.JsonProcessingException;

import batteryproperty.Battery;

public interface PropertyReporter {
	void printReport(Battery battery) throws JsonProcessingException;
}
