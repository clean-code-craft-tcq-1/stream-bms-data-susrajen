package batteryStreamer;
import com.fasterxml.jackson.core.JsonProcessingException;

import batteryDataGenerator.DataGenerator;
import batteryDataGenerator.RandomDataGenerator;
import batteryPropertyReporter.ConsolePropertyReporter;
import batteryPropertyReporter.PropertyReporter;

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
