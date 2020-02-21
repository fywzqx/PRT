package fywzqx.inst.sy7;
4444444444444444444444444444444444444444444444444444444444
package fywzqx.inst.sy71;
package fywzqx.inst.sy72;
package fywzqx.inst.sy73;
package fywzqx.inst.sy74;
package fywzqx.inst.sy75;
import java.io.Serializable;

/*
 * 头文件1   yuan test
 */

public class P_SY7_Head1  implements Serializable
{
	private static final long serialVersionUID = 1L;
	public static final String strFileVerFinaL = "V1.0.01207";
	public String strXieYi;	//	协议版本	String	3
	public byte byDataType;	//	数据包类型	Byte	1
	public String strInst;		//	测试仪的编号	String	24
	public String strLiuShui;	//	流水号	String	24
	public String strPile;		//	试桩编号	String	16
	public String strProfile;	//	剖面列表	String	40     剖面列表，以逗号分隔。  比如：1-2,1-3，2-3。同一个实验同一根桩上实验，但是剖面分批上传，因此需要增加一个标志，即除了流水号、设备号、桩号外还须增加一个字段，去区分分批上传剖面的数据。
	public byte bySendContent;	//	传输的内容	Byte	1   0：原始数据;10：分析数据 120
	public byte byTestMethod;	//	实验方法	Byte	1    0：单桩竖向抗压, 单桩竖向抗拔, 岩石锚杆抗拔, 自平衡, 复合地基, 浅层平板, 深层平板, 原位试验_土层, 原位试验_岩基, 岩基荷载,10：H0,H1,H2,H3,H4,H5,H6,H7,H8,H9,20：平测,:21：扇测, 22：斜测,W3,W4,W5,W6,W7,W8,W9
	public byte byID;			//	头包序号	Byte	1
	public byte byTestGuiFan;	//	测试规范	Byte	1 1：DGJ08–-2003；2：JGJ106-2003；3：JTG/TF81-01-2004；5：SJG09-2007；6：TB10218-2008；7：CECS21:2000；8：DBJ15-60-2008
	public String strDateFile;	//	文件生成时间	time	8 文件创建时的系统时间
	public String strDateTest;	//	测试日期	time	8 （分析结果文件）
	public String strDateJiaoZhu;	//	浇铸日期	time	8
	public String strFileName;	//	文件名	String	60
	public float fPileD;		//	桩径	float	4
	public float fPileLen;		//	桩长	float	4
	public float fMove;			//	移距	Float	4
	public int iPileNum;		//	管数	int	4
	public int iProfileNum;		//	剖面数	int	4
	public float fRate;			//	采样频率	float	4
	public int iSampleLen;		//	采样长度	int	4
	public float fGPSX;			//	经度	Float	4
	public float fGPSY;			//	纬度	Float	4
	public byte byWaveEnhance;	//	首波增强	Byte	1
	public byte bySoftFilt;		//	软件虑波	Byte	1
	public float fV;			//	声测管材料速度	float	4
	public float fPipeOutD;		//	声测管外径	float	4
	public float fPipeInD;		//	声测管内径	float	4
	public float fSenseOutD;	//	探头外径	float	4
	public int iAngle;			//	方位角	int	4
	public float fWheelD;		//	轮径	float	4
	public float fLineD;		//	线径	float	4

	public String strFileVer;	//文件版本号，用于读取时的校验
	public String strFileVer1;	//文件版本号，用于读取时的校验


	public P_SY7_Head1()
	{
		SetDefault();
	}
	
	public void SetDefault()
	{
		strXieYi = "002";	//	协议版本	String	3
		byDataType = 0x0B;	//	数据包类型	Byte	1
		strInst = "";		//	测试仪的编号	String	24
		strLiuShui = "";	//	流水号	String	24
		strPile = "";		//	试桩编号	String	16
		strProfile = "";	//	剖面列表	String	40
		bySendContent = 0;	//	传输的内容	Byte	1
		byTestMethod = 20;	//	实验方法	Byte	1
		byID = 1;			//	头包序号	Byte	1
		byTestGuiFan = 1;;	//	测试规范	Byte	1
		strDateFile = "2017-08-28 18:38:58";	//	文件生成时间	time	8
		strDateTest = "2017-08-28 08:28:48";	//	测试日期	time	8
		strDateJiaoZhu = "2017-08-28 18:28:38";	//	浇铸日期	time	8
		strFileName = "";	//	文件名	String	60
		fPileD = 20;		//	桩径	float	4  (mm)
		fPileLen = 40;		//	桩长	float	4 (m)
		fMove = 0.1f;		//	移距	Float	4 （m)
		iPileNum = 4;		//	管数	int	4
		iProfileNum = 3;	//	剖面数	int	4
		fRate = 1.0f;		//	采样频率	float	4
		iSampleLen = 512;		//	采样长度	int	4
		fGPSX = 0.0f;		//	经度	Float	4
		fGPSY = 0.0f;		//	纬度	Float	4
		byWaveEnhance = 0;	//	首波增强	Byte	1
		bySoftFilt = 1;	//	软件虑波	Byte	1
		fV = 1.0f;			//	声测管材料速度	float	4
		fPipeOutD = 1.0f;	//	声测管外径	float	4
		fPipeInD = 1.0f;		//	声测管内径	float	4
		fSenseOutD = 1.0f;	//	探头外径	float	4
		iAngle = 0;			//	方位角	int	4
		fWheelD = 1.0f;		//	轮径	float	4
		fLineD = 1.0f;		//	线径	float	4
		strFileVer = strFileVerFinaL;
	}


}
