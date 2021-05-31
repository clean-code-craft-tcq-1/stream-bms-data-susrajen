import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import batteryDataGenerator.DataGenerator;
import batteryDataGenerator.RandomDataGenerator;
import batteryProperty.Battery;
import batteryPropertyReporter.ConsolePropertyReporter;
import batteryPropertyReporter.PropertyReporter;
import batteryStreamer.BatteryPropertyStreamer;

public class TestBatteryPropertyStreamer {
	BatteryPropertyStreamer propertyStreamer;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	@Before
	public void setup() {
		DataGenerator randomDataGenerator = new RandomDataGenerator();
		PropertyReporter consoleReporter = new ConsolePropertyReporter();
		
		propertyStreamer = new BatteryPropertyStreamer();
		
		propertyStreamer.setDataGenerator(randomDataGenerator);
		propertyStreamer.setPropertyReporter(consoleReporter);
	}
	
	@Test
	public void givenBatteryisNull_whenGeneratingTemperature_thenReturnNull() {
		BatteryPropertyStreamer propertyStreamer = new BatteryPropertyStreamer();
		assertNull(propertyStreamer.setGeneratedTemperature(null));
	}
	
	@Test
	public void givenBatteryisNull_whenGeneratingSoc_thenReturnNull() {
		BatteryPropertyStreamer propertyStreamer = new BatteryPropertyStreamer();
		assertNull(propertyStreamer.setGeneratedSoc(null));
	}
	
	@Test
	public void givenBatteryisNull_whenGeneratingChargeRate_thenReturnNull() {
		BatteryPropertyStreamer propertyStreamer = new BatteryPropertyStreamer();
		assertNull(propertyStreamer.setGeneratedChargeRate(null));
	}
	
	
	@Test
	public void givenBattery_whenGeneratingTemperature_thenReturnFloat() {
		
		Battery battery = propertyStreamer.setGeneratedTemperature(new Battery());
		assertTrue(battery.getTemperature() instanceof Float);
	}
	
	@Test
	public void givenBattery_whenGeneratingSoc_thenReturnFloat() {
		Battery battery = propertyStreamer.setGeneratedSoc(new Battery());
		assertTrue(battery.getSoc() instanceof Float);
	}
	
	@Test
	public void givenBattery_whenGeneratingChargeRate_thenReturnFloat() {
		Battery battery = propertyStreamer.setGeneratedChargeRate(new Battery());
		assertTrue(battery.getChargeRate() instanceof Float);
	}
	
	@Test
	public void givenBattery_whenStreamingData_thenReturnData() throws JsonProcessingException, InterruptedException {
		propertyStreamer.getDataStream();
		assertNotNull(outputStreamCaptor.toString());
	}

}
