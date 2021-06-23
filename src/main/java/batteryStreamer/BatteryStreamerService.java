package batterystreamer;
import com.fasterxml.jackson.core.JsonProcessingException;

import batterydatagenerator.DataGenerator;
import batterydatagenerator.RandomDataGenerator;
import batterypropertyreporter.ConsolePropertyReporter;
import batterypropertyreporter.PropertyReporter;

public class BatteryStreamerService {
	public static void main(String args[]) throws JsonProcessingException, InterruptedException {
		
		DataGenerator randomDataGenerator = new RandomDataGenerator();
		PropertyReporter consoleReporter = new ConsolePropertyReporter();
		
		BatteryPropertyStreamer propertyStreamer = new BatteryPropertyStreamer();
		
		propertyStreamer.setDataGenerator(randomDataGenerator);
		propertyStreamer.setPropertyReporter(consoleReporter);
		
		propertyStreamer.getDataStream();
		
	}

}
