package ae.iemq.vims.util;

import java.awt.Color;
import java.util.StringTokenizer;

public final class ColorUtil {
	
	public static String PERSPECTIVE_1="#a6f8b0";
	public static String PERSPECTIVE_2="#ebebaf";
	public static String PERSPECTIVE_3="#9eb2f9";
	public static String PERSPECTIVE_4="#cd853f";
	
//	these static variables will be used to set 
//	the tables header class and the cells bgcolor in all the matrixes
	public static String StrategicFrameworkHeaderCssClass = "SFHeader";
	public static String StrategicFrameworkCellLightBG = "#CBCBCB";
	public static String StrategicFrameworkCellDarkBG = "#FFFFE1";
	
	public static String BusinessPlanHeaderCssClass = "BPHeader";
	public static String BusinessPlanCellLightBG = "#DADFE2";
	public static String BusinessPlanCellDarkBG = "#FFFFE1";
	
	public static String BalancedScorecardHeaderCssClass = "MHeader";
	public static String BalancedScorecardCellLightBG = "#E8FAB0";
	public static String BalancedScorecardCellDarkBG = "#FFFFE1";
	
	public static String BusinessProcessHeaderCssClass = "PHeader";
	public static String BusinessProcessCellLightBG = "#EDDFD7";
	public static String BusinessProcessCellDarkBG = "#FFFFE1";
	
	public static String RiskManagementHeaderCssClass = "RHeader";
	public static String RiskManagementCellLightBG = "#E6DED2";
	public static String RiskManagementCellDarkBG = "#FFFFE1";
	
	public static String ProjectMonitoringHeaderCssClass = "PMHeader";
	public static String ProjectMonitoringCellLightBG = "#F8F3B2";
	public static String ProjectMonitoringCellDarkBG = "#FFFFE1";
	
	public static String TakeActionHeaderCssClass = "TAHeader";
	public static String TakeActionCellLightBG = "#CBCBCB";
	public static String TakeActionCellDarkBG = "#FFFFE1";
	
	public static final int StrategicFramework = 1;
	public static final int BusinessPlan = 2;
	public static final int BalancedScorecard = 3;
	public static final int BusinessProcess = 4;
	public static final int RiskManagement = 5;
	public static final int ProjectMonitoring = 6;
	public static final int TakeAction = 7;
	
	public static String defaultStyle = "DisplayTableHeader";
	
	public Color getColorColor(String rgbColor) {

		int r, g, b;
		StringTokenizer st = new StringTokenizer(rgbColor);
		r = Integer.parseInt(st.nextToken("."));
		g = Integer.parseInt(st.nextToken("."));
		b = Integer.parseInt(st.nextToken("."));
		Color c = new Color(r, g, b);

		return c;
	}

	public String getHexColor(String rgbColor) {

		int r, g, b;
		StringTokenizer st = new StringTokenizer(rgbColor);
		r = Integer.parseInt(st.nextToken("."));
		g = Integer.parseInt(st.nextToken("."));
		b = Integer.parseInt(st.nextToken("."));
		Color c = new Color(r, g, b);
		String hex = Integer.toHexString(c.getRGB() & 0x00ffffff);
		if (hex.length() < 6)
			hex = "#0" + hex;
		else
			hex = "#" + hex;

		return hex;
	}

	public String getHexFromColor(Color color) {

		String hex = Integer.toHexString(color.getRGB() & 0x00ffffff);
		if (hex.length() < 6)
			hex = "#0" + hex;
		else
			hex = "#" + hex;

		return hex;
	}

	public static String getObjShadeColor(int perspective, int type,
			boolean shade) {
		// type 0 for objective....1 for Measure, Activity, Risk, etc.
		// shade 0 light 1 dark

		switch (perspective) {
		case 0: //zero for regular (non-objective cells)
			switch (type) {
			case 0:
				if (!shade){
					return ("#e5e5e5");
				}
				if (shade) {
					return ("#cccccc");
				}
			case 1:
				if (!shade){
					return ("#fff000");
				}
				if (shade) {
					return ("#999000");
				}
			}
		case 1:
			switch (type) {
			case 0:
				if (!shade) {
					return ("#a6f8b0");
				}
				if (shade) {
					return ("#8bd093");
				}
			case 1:
				if (!shade) {
					return ("#d0fcd5");
				}
				if (shade) {
					return ("#e1fce4");
				}
			}
		case 2:
			switch (type) {
			case 0:
				if (!shade) {
					return ("#cecd99");
				}
				if (shade) {
					return ("#ebebaf");
				}
			case 1:
				if (!shade) {
					return ("#fefdd8");
				}
				if (shade) {
					return ("#fefec9");
				}
			}
		case 3:
			switch (type) {
			case 0:
				if (!shade) {
					return ("#7a8ac0");
				}
				if (shade) {
					return ("#9eb2f9");
				}
			case 1:
				if (!shade) {
					return ("#bac8fa");
				}
				if (shade) {
					return ("#dce3fd");
				}
			}
		case 4:
			switch (type) {
			case 0:
				if (!shade) {
					return ("#845528");
				}
				if (shade) {
					return ("#cd853f");
				}
			case 1:
				if (!shade) {
					return ("#d59a60");
				}
				if (shade) {
					return ("#e6c3a1");
				}
			}

		}
		return "";

	}
	
	public static String getGrayTableColor(boolean shade){
		if (!shade) {
			return ("#CCCCCC");
		}
		else
			return ("#E9E9E9");
	}
	
	public static String getMainShade(int index, int m){
		switch(m){
		case StrategicFramework:
			if(index%2 == 0){
//				Dark color
				return StrategicFrameworkCellDarkBG;
			}else{
//				Light color
				return StrategicFrameworkCellLightBG;
			}
		case BusinessPlan:
			if(index%2 == 0){
//				Dark color
				return BusinessPlanCellDarkBG;
			}else{
//				Light color
				return BusinessPlanCellLightBG;
			}
		case BalancedScorecard:
			if(index%2 == 0){
//				Dark color
				return BalancedScorecardCellDarkBG;
			}else{
//				Light color
				return BalancedScorecardCellLightBG;
			}
		case BusinessProcess:
			if(index%2 == 0){
//				Dark color
				return BusinessProcessCellDarkBG;
			}else{
//				Light color
				return BusinessProcessCellLightBG;
			}
		case ProjectMonitoring:
			if(index%2 == 0){
//				Dark color
				return ProjectMonitoringCellDarkBG;
			}else{
//				Light color
				return ProjectMonitoringCellLightBG;
			}
		case RiskManagement:
			if(index%2 == 0){
//				Dark color
				return RiskManagementCellDarkBG;
			}else{
//				Light color
				return RiskManagementCellLightBG;
			}
		case TakeAction:
			if(index%2 == 0){
//				Dark color
				return TakeActionCellDarkBG;
			}else{
//				Light color
				return TakeActionCellLightBG;
			}
		
		}
		
		if(index%2 == 0){
//			Dark color
			return "#E1E1E1";
		}else{
//			Light color
			return "#F0F0F0";
		}
	}
	
	public static String getSubShade(int index){
		if(index%2 == 0){
//			Dark color
			return "#E1E1E1";
		}else{
//			Light color
			return "#FFFFFF";
		}
	}
	
	public static String getHeaderCssClass(int module){
		switch(module){
			case StrategicFramework:
				return StrategicFrameworkHeaderCssClass;
			case BusinessPlan:
				return BusinessPlanHeaderCssClass;
			case BalancedScorecard:
				return BalancedScorecardHeaderCssClass;
			case BusinessProcess:
				return BusinessProcessHeaderCssClass;
			case ProjectMonitoring:
				return ProjectMonitoringHeaderCssClass;
			case RiskManagement:
				return RiskManagementHeaderCssClass;
			case TakeAction:
				return TakeActionHeaderCssClass;
		}
		return defaultStyle;
	}
}
