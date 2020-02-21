package fywzqx.inst.sy7;

import55555555555555555555555 java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date1;
import java.util.Date2;

import java.util.Date3;
import java.util.Date4;
import java.util.Date5;
import java.util.Date6;


import fywzqx.global.*;

/*
 * 解析SY7的各种包数据：
 */
public class CSY7UnPack 
{
	//解析文件头1：
	public static P_SY7_Head1 UnPackHead1(byte[] data)
	{
		P_SY7_Head1 pRet = new P_SY7_Head1();	
		byte[] tmp;
		String strTmp;
		float fValue;
		int iValue;
		
		{
			//协议：
			tmp = new byte[3];
			System.arraycopy(data, 11, tmp, 0, 3); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strXieYi = strTmp;
		}
		
		//数据表类型：
		pRet.byDataType = data[14];
			
		{
			//测试仪编号：
			tmp = new byte[24];
			System.arraycopy(data, 15, tmp, 0, 24); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strInst = strTmp;
		}
		
		{
			//流水号：
			tmp = new byte[24];
			System.arraycopy(data, 39, tmp, 0, 24); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strLiuShui = strTmp;
		}
		
		{
			//试桩编号：
			tmp = new byte[16];
			System.arraycopy(data, 63, tmp, 0, 16); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strPile= strTmp;
		}
		
		{
			//剖面列表：
			tmp = new byte[40];
			System.arraycopy(data, 79, tmp, 0, 40); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strProfile = strTmp;
		}
		
		//传输内容：
		pRet.bySendContent = data[119];
		
		//试验方法：
		pRet.byTestMethod = data[120];
		
		//头包序号:
		pRet.byID = data[121];
		
		//测试规范:
		pRet.byTestGuiFan = data[122];
		
		//文件生成时间:
		{
			byte[] bValue={data[123],data[124],data[125],data[126],data[127],data[128],data[129],data[130]};
			double dValue = G_PUBLIC_FUN.ByteToDouble(bValue);
			long lValue = (long)(dValue*86400000l); //得到ms级别的数，1899年开始算的
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
			//String strDate = "1899-12-30 00:00:00";
			try
			{
				Date d1 = df.parse("1899-12-30 00:00:00");
	
				lValue = lValue- d1.getTime()*(-1);
				java.util.Date  jj = new java.util.Date(lValue);

				strTmp = df.format(jj);	
				pRet.strDateFile = strTmp;
			}
			catch (Exception e)
			{
			} 
		}
		
		//测试日期:
		{
			byte[] bValue={data[131],data[132],data[133],data[134],data[135],data[136],data[137],data[138]};
			double dValue = G_PUBLIC_FUN.ByteToDouble(bValue);
			long lValue = (long)(dValue*86400000l); //得到ms级别的数，1899年开始算的
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
			//String strDate = "1899-12-30 00:00:00";
			try
			{
				Date d1 = df.parse("1899-12-30 00:00:00");
	
				lValue = lValue- d1.getTime()*(-1);
				java.util.Date  jj = new java.util.Date(lValue);

				strTmp = df.format(jj);	
				pRet.strDateTest = strTmp;
			}
			catch (Exception e)
			{
			} 
		}
		
		//浇铸日期:
		{
			byte[] bValue={data[139],data[140],data[141],data[142],data[143],data[144],data[145],data[146]};
			double dValue = G_PUBLIC_FUN.ByteToDouble(bValue);
			long lValue = (long)(dValue*86400000l); //得到ms级别的数，1899年开始算的
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
			//String strDate = "1899-12-30 00:00:00";
			try
			{
				Date d1 = df.parse("1899-12-30 00:00:00");
	
				lValue = lValue- d1.getTime()*(-1);
				java.util.Date  jj = new java.util.Date(lValue);

				strTmp = df.format(jj);	
				pRet.strDateJiaoZhu = strTmp;
			}
			catch (Exception e)
			{
			} 
		}	
		
		{
			//文件名：
			tmp = new byte[60];
			System.arraycopy(data, 147, tmp, 0, 60); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strFileName = strTmp;
		}
		
		//桩径：
		{
			byte[] value={data[207],data[208],data[209],data[210]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fPileD = fValue;
		}

		//桩长：
		{
			byte[] value={data[211],data[212],data[213],data[214]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fPileLen = fValue;
		}	
		
		//移距：
		{
			byte[] value={data[215],data[216],data[217],data[218]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fMove = fValue;
		}
		
		//管数：
		{
			byte[] value={data[219],data[220],data[221],data[222]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.iPileNum = iValue;
		}	
		
		//剖面数：
		{
			byte[] value={data[223],data[224],data[225],data[226]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.iProfileNum = iValue;
		}
		
		//采样频率：
		{
			byte[] value={data[227],data[228],data[229],data[230]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fRate = fValue;
		}	
		
		//采样长度：
		{
			byte[] value={data[231],data[232],data[233],data[234]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.iSampleLen = iValue;
		}

		//经度：
		{
			byte[] value={data[235],data[236],data[237],data[238]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fGPSX = fValue;
		}
		
		//纬度：
		{
			byte[] value={data[239],data[240],data[241],data[242]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fGPSY = fValue;
		}
		
		//首波增强:
		pRet.byWaveEnhance = data[243];
		
		//软件虑波:
		pRet.bySoftFilt = data[244];

		//声测管材料速度：
		{
			byte[] value={data[245],data[246],data[247],data[248]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fV = fValue;
		}
		
		//声测管外径：
		{
			byte[] value={data[249],data[250],data[251],data[252]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fPipeOutD = fValue;
		}
		
		//声测管内径：
		{
			byte[] value={data[253],data[254],data[255],data[256]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fPipeInD = fValue;
		}
		
		//探头外径：
		{
			byte[] value={data[257],data[258],data[259],data[260]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fSenseOutD = fValue;
		}
		
		//方位角：
		{
			byte[] value={data[261],data[262],data[263],data[264]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.iAngle = iValue;
		}
		
		//轮径：
		{
			byte[] value={data[265],data[266],data[267],data[268]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fWheelD = fValue;
		}
		
		//线径：
		{
			byte[] value={data[269],data[270],data[271],data[272]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fLineD = fValue;
		}	
		
		
		return pRet;
	}
	
	//解析文件头2：
	public static P_SY7_Head2 UnPackHead2(byte[] data)
	{
		P_SY7_Head2 pRet = new P_SY7_Head2();
		byte[] tmp;
		String strTmp;
		float fValue;
		int iValue;
		
		{
			//协议：
			tmp = new byte[3];
			System.arraycopy(data, 11, tmp, 0, 3); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strXieYi = strTmp;
		}
		
		//数据类型：
		pRet.byDataType = data[14];
			
		{
			//测试仪编号：
			tmp = new byte[24];
			System.arraycopy(data, 15, tmp, 0, 24); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strInst = strTmp;
		}
		
		{
			//流水号：
			tmp = new byte[24];
			System.arraycopy(data, 39, tmp, 0, 24); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strLiuShui = strTmp;
		}
		
		{
			//试桩编号：
			tmp = new byte[16];
			System.arraycopy(data, 63, tmp, 0, 16); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strPile= strTmp;
		}
		
		{
			//剖面列表：
			tmp = new byte[40];
			System.arraycopy(data, 79, tmp, 0, 40); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strProfileList = strTmp;
		}
		
		//传输内容：
		pRet.bySendContent = data[119];
		
		//试验方法：
		pRet.byTestMethod = data[120];
		
		//头包序号:
		pRet.byID = data[121];
		
		for(int i=0;i<10;i++)
		{
			//剖面：
			tmp = new byte[3];
			System.arraycopy(data, 122+35*i, tmp, 0, 3); 
			strTmp =  new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			pRet.strPro[i] = strTmp;
			
			//测试深度:
			{
				byte[] value={data[122+35*i+3],data[122+35*i+4],data[122+35*i+5],data[122+35*i+6]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fHeight[i] = fValue;
			}
			
			//传感器高差:
			{
				byte[] value={data[122+35*i+7],data[122+35*i+8],data[122+35*i+9],data[122+35*i+10]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fDH[i] = fValue;
			}
			
			//跨距:
			{
				byte[] value={data[122+35*i+11],data[122+35*i+12],data[122+35*i+13],data[122+35*i+14]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fSpan[i] = fValue;
			}
			
			//增益：
			{
				byte[] value={data[122+35*i+15],data[122+35*i+16],data[122+35*i+17],data[122+35*i+18]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fGain[i] = fValue;
			}
			
			//校零：
			{
				byte[] value={data[122+35*i+19],data[122+35*i+20],data[122+35*i+21],data[122+35*i+22]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fAdjust[i] = fValue;
			}
			
			//延迟时间：
			{
				byte[] value={data[122+35*i+23],data[122+35*i+24],data[122+35*i+25],data[122+35*i+26]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fDelay[i] = fValue;
			}
			
			//高通
			{
				byte[] value={data[122+35*i+27],data[122+35*i+28],data[122+35*i+29],data[122+35*i+30]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fHPass[i] = fValue;
			}
			
			//低通：
			{
				byte[] value={data[122+35*i+31],data[122+35*i+32],data[122+35*i+33],data[122+35*i+34]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fLPass[i] = fValue;
			}
		}
		
		return pRet;
	}
	
	//解析数据包-数据表：
	public static P_SY7_Table UnPackTable(byte[] data)
	{
		P_SY7_Table pRet = new P_SY7_Table();
		byte[] tmp;
		String strTmp;
		float fValue;
		int iValue;
		
		{
			//协议：
			tmp = new byte[3];
			System.arraycopy(data, 11, tmp, 0, 3); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strXieYi = strTmp;
		}
		
		//数据类型：
		pRet.byDataType = data[14];
			
		{
			//测试仪编号：
			tmp = new byte[24];
			System.arraycopy(data, 15, tmp, 0, 24); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strInst = strTmp;
		}
		
		{
			//流水号：
			tmp = new byte[24];
			System.arraycopy(data, 39, tmp, 0, 24); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strLiuShui = strTmp;
		}
		
		{
			//试桩编号：
			tmp = new byte[16];
			System.arraycopy(data, 63, tmp, 0, 16); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strPile= strTmp;
		}
		
		{
			//剖面列表：
			tmp = new byte[40];
			System.arraycopy(data, 79, tmp, 0, 40); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strProfileList = strTmp;
		}
		
		//传输内容：
		pRet.bySendContent = data[119];
		
		//包序号：
		{
			byte[] value={data[120],data[121],data[122],data[123]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.lID = iValue;
		}
		
		//深度：
		{
			byte[] value={data[124],data[125],data[126],data[127]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fHeight = fValue;
		}
		
		for(int i=0;i<10;i++)
		{	
			//剖面列表:
			tmp = new byte[3];
			System.arraycopy(data, 128+(6*4+3)*i, tmp, 0, 3); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			pRet.strPro[i] = strTmp;

			//跨距:
			{
				byte[] value={data[128+(6*4+3)*i+3],data[128+(6*4+3)*i+3+1],data[128+(6*4+3)*i+3+2],data[128+(6*4+3)*i+3+3]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fSpan[i] = fValue;
			}
			
			//声时:
			{
				byte[] value={data[128+(6*4+3)*i+7],data[128+(6*4+3)*i+7+1],data[128+(6*4+3)*i+7+2],data[128+(6*4+3)*i+7+3]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fT[i] = fValue;
			}	
			//波幅:
			{
				byte[] value={data[128+(6*4+3)*i+11],data[128+(6*4+3)*i+11+1],data[128+(6*4+3)*i+11+2],data[128+(6*4+3)*i+11+3]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fA[i] = fValue;
			}
			
			//主频:
			{
				byte[] value={data[128+(6*4+3)*i+15],data[128+(6*4+3)*i+15+1],data[128+(6*4+3)*i+15+2],data[128+(6*4+3)*i+15+3]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fFre[i] = fValue;
			}
				
			//PSD:
			{
				byte[] value={data[128+(6*4+3)*i+19],data[128+(6*4+3)*i+19+1],data[128+(6*4+3)*i+19+2],data[128+(6*4+3)*i+19+3]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fPSD[i] = fValue;
			}
			
			//I:
			{
				byte[] value={data[128+(6*4+3)*i+23],data[128+(6*4+3)*i+23+1],data[128+(6*4+3)*i+23+2],data[128+(6*4+3)*i+23+3]};
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fI[i] = fValue;
			}
		}
		
		
		return pRet;
	}
	
		//解析数据包-临界值：
		public static P_SY7_Critical UnPackCritical(byte[] data)
		{
			P_SY7_Critical pRet = new P_SY7_Critical();
			byte[] tmp;
			String strTmp;
			float fValue;
			int iValue;
			
			{
				//协议：
				tmp = new byte[3];
				System.arraycopy(data, 11, tmp, 0, 3); 
				strTmp= new String(tmp).trim();
				if(strTmp.indexOf(0x0)>=0)
				{
					strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
				}	

				pRet.strXieYi = strTmp;
			}
			
			//数据类型：
			pRet.byDataType = data[14];
				
			{
				//测试仪编号：
				tmp = new byte[24];
				System.arraycopy(data, 15, tmp, 0, 24); 
				strTmp= new String(tmp).trim();
				if(strTmp.indexOf(0x0)>=0)
				{
					strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
				}	

				pRet.strInst = strTmp;
			}
			
			{
				//流水号：
				tmp = new byte[24];
				System.arraycopy(data, 39, tmp, 0, 24); 
				strTmp = new String(tmp).trim();
				if(strTmp.indexOf(0x0)>=0)
				{
					strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
				}
				
				pRet.strLiuShui = strTmp;
			}
			
			{
				//试桩编号：
				tmp = new byte[16];
				System.arraycopy(data, 63, tmp, 0, 16); 
				strTmp = new String(tmp).trim();
				if(strTmp.indexOf(0x0)>=0)
				{
					strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
				}
				
				pRet.strPile= strTmp;
			}
			
			{
				//剖面列表：
				tmp = new byte[40];
				System.arraycopy(data, 79, tmp, 0, 40); 
				strTmp = new String(tmp).trim();
				if(strTmp.indexOf(0x0)>=0)
				{
					strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
				}
				
				pRet.strProfileList = strTmp;
			}
			
			//传输内容：
			pRet.bySendContent = data[119];
			
			//包序号：
			{
				byte[] value={data[120],data[121],data[122],data[123]};
				iValue = G_PUBLIC_FUN.ByteToInt(value);
				pRet.lID = iValue;
			}
			
			
			for(int i=0;i<5;i++)
			{
				//平均声速:
				{
					byte[] value={data[124+34*i+0],data[124+34*i+1],data[124+34*i+2],data[124+34*i+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fSpeedAvg[i] = fValue;
				}
				
				//声速异常判定值（临界值）:
				{
					byte[] value={data[124+34*i+0+4],data[124+34*i+0+4+1],data[124+34*i+0+4+2],data[124+34*i+0+4+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fSpeedExp[i] = fValue;
				}
				
				//声速标准差:
				{
					byte[] value={data[124+34*i+8],data[124+34*i+8+1],data[124+34*i+8+2],data[124+34*i+8+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fSpeedStard[i] = fValue;
				}
				
				//离散系数:
				{
					byte[] value={data[124+34*i+12],data[124+34*i+12+1],data[124+34*i+12+2],data[124+34*i+12+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fXiShu[i] = fValue;
				}
				
				//均匀性等级:
				pRet.byDengJi[i] = data[124+34*i+16];
				
				//类别:
				pRet.byType[i] = data[124+34*i+17];
				
				//波速最小值:
				{
					byte[] value={data[124+34*i+18],data[124+34*i+18+1],data[124+34*i+18+2],data[124+34*i+18+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fSpeedMin[i] = fValue;
				}
				
				//平均波幅:
				{
					byte[] value={data[124+34*i+22],data[124+34*i+22+1],data[124+34*i+22+2],data[124+34*i+22+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fAMPAvg[i] = fValue;
				}
				
				//波幅临界值:
				{
					byte[] value={data[124+34*i+26],data[124+34*i+26+1],data[124+34*i+26+2],data[124+34*i+26+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fAMPSide[i] = fValue;
				}
				
				//波幅最小值:
				{
					byte[] value={data[124+34*i+30],data[124+34*i+30+1],data[124+34*i+30+2],data[124+34*i+30+3]};
					fValue = G_PUBLIC_FUN.ByteToFloat(value);
					pRet.fAMPMin[i] = fValue;
				}
			}
			
			return pRet;
		}
	
	//解析数据包-缺陷值：
	public static P_SY7_Defect UnPackDefect(byte[] data)
	{
		P_SY7_Defect pRet = new P_SY7_Defect();
		byte[] tmp;
		String strTmp;
		float fValue;
		int iValue;
		
		{
			//协议：
			tmp = new byte[3];
			System.arraycopy(data, 11, tmp, 0, 3); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strXieYi = strTmp;
		}
		
		//数据类型：
		pRet.byDataType = data[14];
			
		{
			//测试仪编号：
			tmp = new byte[24];
			System.arraycopy(data, 15, tmp, 0, 24); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	

			pRet.strInst = strTmp;
		}
		
		{
			//流水号：
			tmp = new byte[24];
			System.arraycopy(data, 39, tmp, 0, 24); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strLiuShui = strTmp;
		}
		
		{
			//试桩编号：
			tmp = new byte[16];
			System.arraycopy(data, 63, tmp, 0, 16); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strPile= strTmp;
		}
		
		{
			//剖面列表：
			tmp = new byte[40];
			System.arraycopy(data, 79, tmp, 0, 40); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strProfileList = strTmp;
		}
		
		//传输内容：
		pRet.bySendContent = data[119];
		
		//包序号：
		{
			byte[] value={data[120],data[121],data[122],data[123]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.lID = iValue;
		}
		
		//剖面1缺陷：
		for(int i=0;i<9;i+=4)
		{
			byte[] value={data[124+i],data[124+i+1],data[124+i+2],data[124+i+3]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fDefect1[i] = fValue;
		}
		
		//剖面2缺陷：
		for(int i=0;i<9;i+=4)
		{
			byte[] value={data[164+i],data[168+i+1],data[168+i+2],data[168+i+3]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fDefect2[i] = fValue;
		}
		
		//剖面3缺陷：
		for(int i=0;i<9;i+=4)
		{
			byte[] value={data[204+i],data[204+i+1],data[204+i+2],data[204+i+3]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fDefect3[i] = fValue;
		}
		
		//剖面4缺陷：
		for(int i=0;i<9;i+=4)
		{
			byte[] value={data[244+i],data[244+i+1],data[244+i+2],data[244+i+3]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fDefect3[i] = fValue;
		}
		
		//剖面5缺陷：
		for(int i=0;i<9;i+=4)
		{
			byte[] value={data[284+i],data[284+i+1],data[284+i+2],data[284+i+3]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fDefect3[i] = fValue;
		}
		
		return pRet;
	}
	
	//解析数据包-数据点：
	public static P_SY7_Wave UnPackWave(byte[] data,int len)
	{
		P_SY7_Wave pRet = new P_SY7_Wave();
		byte[] tmp;
		String strTmp;
		float fValue;
		int iValue;
		
		{
			//协议：
			tmp = new byte[3];
			System.arraycopy(data, 11, tmp, 0, 3); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	
	
			pRet.strXieYi = strTmp;
		}
		
		//数据类型：
		pRet.byDataType = data[14];
			
		{
			//测试仪编号：
			tmp = new byte[24];
			System.arraycopy(data, 15, tmp, 0, 24); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	
	
			pRet.strInst = strTmp;
		}
		
		{
			//流水号：
			tmp = new byte[24];
			System.arraycopy(data, 39, tmp, 0, 24); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strLiuShui = strTmp;
		}
		
		{
			//试桩编号：
			tmp = new byte[16];
			System.arraycopy(data, 63, tmp, 0, 16); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strPile= strTmp;
		}
		
		{
			//剖面列表：
			tmp = new byte[40];
			System.arraycopy(data, 79, tmp, 0, 40); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strProfileList = strTmp;
		}
		
		//传输内容：
		pRet.bySendContent = data[119];
		
		//包序号：
		{
			byte[] value={data[120],data[121],data[122],data[123]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.lID = iValue;
		}
		
		//大序号：
		{
			byte[] value={data[124],data[125],data[126],data[127]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.lIDTotal = iValue;
		}	
		
		//深度：
		{
			byte[] value={data[128],data[129],data[130],data[131]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fHeight = fValue; 
		}
		
		//剖面号：
		{
			tmp = new byte[3];
			System.arraycopy(data, 132, tmp, 0, 3); 
			strTmp =  new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			pRet.strProfile = strTmp;
		}
		
		//跨距
		{
			byte[] value={data[135],data[136],data[137],data[138]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fSpan = fValue;
		}
		
		//接收高度
		{
			byte[] value={data[139],data[140],data[141],data[142]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fRevHeight = fValue;
		}
		
		//增益
		{
			byte[] value={data[143],data[144],data[145],data[146]};
			//fValue = G_PUBLIC_FUN.ByteToFloat(value);
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.fGain = (iValue+0.0f);
			if(pRet.fGain < 0.9 || pRet.fGain > 8000)
			{
				fValue = G_PUBLIC_FUN.ByteToFloat(value);
				pRet.fGain = fValue;
			}
		}
		
		//延时
		{
			byte[] value={data[147],data[148],data[149],data[150]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fDelay = fValue;
		}
		
		//声时的索引值
		{
			byte[] value={data[151],data[152],data[153],data[154]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.iTIndex = iValue;
		}	
		
		//首波峰的索引值
		{
			byte[] value={data[155],data[156],data[157],data[158]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.iAIndex = iValue;
		}	
		
		//波形数据  	Data0	unsigned	2	（2048为零点）...	Data127	unsigned	2	159+128*2 = 415
		short sValue = 0;
		int m=0;
		int iDataSise = 128;
		if(len == 1195)
		{
			iDataSise = 512;
			if(pRet.pData.length !=512)
			{
				pRet.pData = new short[512];
			}
		}
		else if(len == 2219)
		{
			iDataSise = 1024;
			if(pRet.pData.length !=1024)
			{
				pRet.pData = new short[1024];
			}
		}
		
		for(int i=0;i<iDataSise*2;i+=2)
		{
			byte[] value={data[159+i],data[160+i]};
			sValue = G_PUBLIC_FUN.ByteToShort(value);
			//pRet.pData[(int) ((pRet.lID-1)*128+m)] = sValue;
			pRet.pData[m++] = sValue;
		}
			
		return pRet;
	}	
	
	//解析数据包-波列图：
	
	
	//解析结束包:
	public static P_SY7_Finish UnPackFinish(byte[] data)
	{
		P_SY7_Finish pRet = new P_SY7_Finish();
		byte[] tmp;
		String strTmp;
		float fValue;
		int iValue;
		
		{
			//协议：
			tmp = new byte[3];
			System.arraycopy(data, 11, tmp, 0, 3); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	
	
			pRet.strXieYi = strTmp;
		}
		
		//数据类型：
		pRet.byDataType = data[14];
			
		{
			//测试仪编号：
			tmp = new byte[24];
			System.arraycopy(data, 15, tmp, 0, 24); 
			strTmp= new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}	
	
			pRet.strInst = strTmp;
		}
		
		{
			//流水号：
			tmp = new byte[24];
			System.arraycopy(data, 39, tmp, 0, 24); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strLiuShui = strTmp;
		}
		
		{
			//试桩编号：
			tmp = new byte[16];
			System.arraycopy(data, 63, tmp, 0, 16); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strPile= strTmp;
		}
		
		{
			//剖面列表：
			tmp = new byte[40];
			System.arraycopy(data, 79, tmp, 0, 40); 
			strTmp = new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			
			pRet.strProfileList = strTmp;
		}
		
		//传输内容：
		pRet.bySendContent = data[119];
		
		//状态：
		{
			byte[] value={data[120],data[121],data[122],data[123]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.lState = iValue;
		}	
		
		
		//包序号：
		{
			byte[] value={data[124],data[125],data[126],data[127]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.lID = iValue;
		}
		
		//大序号：
		{
			byte[] value={data[128],data[129],data[130],data[131]};
			iValue = G_PUBLIC_FUN.ByteToInt(value);
			pRet.lIDTotal = iValue;
		}	
		
		//深度：
		{
			byte[] value={data[132],data[133],data[134],data[135]};
			fValue = G_PUBLIC_FUN.ByteToFloat(value);
			pRet.fHeight = fValue;
		}
		
		//剖面号：
		{
			tmp = new byte[3];
			System.arraycopy(data, 136, tmp, 0, 3); 
			strTmp =  new String(tmp).trim();
			if(strTmp.indexOf(0x0)>=0)
			{
				strTmp = strTmp.substring(0, strTmp.indexOf(0x0));
			}
			pRet.strProfile = strTmp;
		}
		
		return pRet;
	}
	
	
	public static int GetProfileNum(String strProfileList)
	{
		//根据剖面列表来计算剖面数：
		int num=0;
		
		String[] data = strProfileList.split(",");
		
		for(int i=0;i<data.length;i++)
		{
			if(data[i].trim().length()>=3 && data[i].trim().indexOf('*')<0)
			{
				num++;
			}
		}
		
		return num;
	}
		
	
	

	
}
