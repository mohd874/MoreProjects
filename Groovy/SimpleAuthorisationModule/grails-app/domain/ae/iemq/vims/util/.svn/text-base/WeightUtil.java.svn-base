package ae.iemq.vims.util;

import org.apache.log4j.Logger;

public class WeightUtil {

	/** Logger. */
	static Logger LOG = Logger.getLogger(WeightUtil.class);
	
	public static enum Weight {
		ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10);
		
		private final int value;
		Weight(int value){
			this.value = value;
		}
		public int getValue(){
			return this.value;
		}
		/**
		 * return int[] representing the Weight enum
		 */
		public int[] getIntValues(){
			int [] values = new int[Weight.values().length];
			Weight[] enumValues = Weight.values();
			for(int i=0;i<enumValues.length;i++){
				values[i] = enumValues[i].getValue();
			}
			return values;
		}
		/**
		 * Convert the value into Weight enum
		 * @param Weight
		 */
		public Weight getWeightFromValue(int value){
			Weight[] enumValues = Weight.values();
			for(int i=0;i<enumValues.length;i++){
				if(enumValues[i].getValue() == value){
					return enumValues[i];
				}
			}
			return null;
		}
	}	
}
