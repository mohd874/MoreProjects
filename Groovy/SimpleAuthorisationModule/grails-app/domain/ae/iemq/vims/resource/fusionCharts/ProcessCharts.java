package ae.iemq.vims.resource.fusionCharts;

import org.apache.log4j.Logger;

import ae.iemq.vims.domain.developprocess.Process;
import ae.iemq.vims.resource.ViMSColorUtil;

public class ProcessCharts {

	/** The internal logger. */
	static Logger LOG = Logger.getLogger(ProcessCharts.class);
	
	/**
	 * Constructor for MeasureCharts.
	 */
	public ProcessCharts() {
		super();
	}
	
	/**
	 * This Method constructs the XML for building a Bulb Guage.
	 * 
	 * @return Sting The XML input to construct the guage.
	 */
	public static String generateBulbChart(Process process, String bgcolor){
		String xmlString = "";
		StringBuffer sb = new StringBuffer();
		
		final int MAX_VALUE = 100;
		final int MID_VALUE = 50;
		final int MIN_VALUE = 0;
		final int EMPTY_VALUE=-100;

		

		
		sb.append("<chart upperLimit='"+MAX_VALUE+"' lowerLimit='"+MIN_VALUE+"' numberSuffix='%25' " +
				"placeValuesInside='1' showGaugeBorder='1' gaugeFillAlpha='100' gaugeBorderColor='666666' bgAlpha='100' borderAlpha='100' bgColor='"+bgcolor+"' borderColor='"+bgcolor+"'"+
				"gaugeBorderThickness='1' gaugeBorderAlpha='100' useColorNameAsValue='1'>");
		
		sb.append("<colorRange>");
		sb.append("<color minValue='"+(EMPTY_VALUE-1)+"' maxValue='"+(EMPTY_VALUE+1)+"' label='' code='"+ViMSColorUtil.WHITE+"' alpha='100'/>");
		sb.append("<color minValue='"+(MIN_VALUE-1)+"' maxValue='"+(MIN_VALUE+1)+"' label='' code='"+ViMSColorUtil.ROBOT_RED+"' alpha='100'/>");
		sb.append("<color minValue='"+(MID_VALUE-1)+"' maxValue='"+(MID_VALUE+1)+"' label='' code='"+ViMSColorUtil.ROBOT_YELLOW+"' alpha='100'/>");
		sb.append("<color minValue='"+(MAX_VALUE-1)+"' maxValue='"+(MAX_VALUE+1)+"' label='' code='"+ViMSColorUtil.ROBOT_GREEN+"' alpha='100'/>");
		sb.append("</colorRange>");
		
		if(process != null){
			sb.append("<value>"+MAX_VALUE+"</value>");			
		}else{
			sb.append("<value>"+EMPTY_VALUE+"</value>");
		}
		
		sb.append("</chart>");
		
		xmlString = sb.toString();
		LOG.debug("xmlString--->"+xmlString);
		
		return xmlString;
	}
}
