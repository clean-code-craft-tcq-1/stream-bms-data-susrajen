package batterystreamer;

import com.fasterxml.jackson.core.JsonProcessingException;

import batterydatagenerator.DataGenerator;
import batteryproperty.Battery;
import batteryproperty.BatteryPropertyBoundaries;
import batterypropertyreporter.PropertyReporter;

public class BatteryPropertyStreamer {
	private DataGenerator dataGenerator;
	private PropertyReporter propertyReporter;

	public PropertyReporter getPropertyReporter() {
		return propertyReporter;
	}

	public void setPropertyReporter(PropertyReporter propertyReporter) {
		this.propertyReporter = propertyReporter;
	}

	public DataGenerator getDataGenerator() {
		return dataGenerator;
	}

	public void setDataGenerator(DataGenerator dataGenerator) {
		this.dataGenerator = dataGenerator;
	}

	public void getDataStream() throws InterruptedException, JsonProcessingException {
		for (int i = 0; i < 50; i++) {
			Thread.sleep(1000);

			Battery battery = new Battery();

			battery = setGeneratedTemperature(battery);
			battery = setGeneratedSoc(battery);
			battery = setGeneratedChargeRate(battery);

			propertyReporter.printReport(battery);

		}
	}

	public Battery setGeneratedChargeRate(Battery battery) {
		if (null != battery) {
			Float chargeRate = dataGenerator.getBatteryParameterValues(BatteryPropertyBoundaries.MIN_CHANGE_RATE,
					BatteryPropertyBoundaries.MAX_CHANGE_RATE);
			battery.setChargeRate(chargeRate);
		}

		return battery;
	}

	public Battery setGeneratedSoc(Battery battery) {
		if (null != battery) {
			Float stateOfCharge = dataGenerator.getBatteryParameterValues(BatteryPropertyBoundaries.MIN_SOC,
					BatteryPropertyBoundaries.MAX_SOC);
			battery.setSoc(stateOfCharge);
		}

		return battery;
	}

	public Battery setGeneratedTemperature(Battery battery) {
		if (null != battery) {
			Float temperature = dataGenerator.getBatteryParameterValues(BatteryPropertyBoundaries.MIN_TEMPERATURE,
					BatteryPropertyBoundaries.MIN_TEMPERATURE);
			battery.setTemperature(temperature);
		}
		return battery;
	}

}
