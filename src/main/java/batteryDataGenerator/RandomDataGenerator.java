package batteryDataGenerator;

import java.util.Random;

public class RandomDataGenerator implements DataGenerator {

	@Override
	public Float getBatteryParameterValues(Float minValueOfBatteryParameter, Float maxValueOfBatteryParameter) {
		Random randomParameterValue = new Random();
		return minValueOfBatteryParameter + randomParameterValue.nextFloat() * (maxValueOfBatteryParameter - minValueOfBatteryParameter);
	}

}
