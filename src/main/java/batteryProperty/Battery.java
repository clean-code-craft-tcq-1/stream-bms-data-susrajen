package batteryProperty;

public class Battery {
	private Float temperature;
	private Float soc;
	private Float chargeRate;
	
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Float getSoc() {
		return soc;
	}
	public void setSoc(Float soc) {
		this.soc = soc;
	}
	public Float getChargeRate() {
		return chargeRate;
	}
	public void setChargeRate(Float chargeRate) {
		this.chargeRate = chargeRate;
	}
	
}
