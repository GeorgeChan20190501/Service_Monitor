package com.cognizant.ams.common.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.cognizant.ams.common.DBConn;

public class DateCal {
	
	
	 static Connection connection=DBConn.getConn();
	 
	 static String yearGlobal="";
	 static String holiday="";
	 static String overtimeDay="";
	 //思路：1-任意时间，先计算截至日是否未工作日。如果不是工作日，往后累加到工作日9点开始计算。即起始时间必为工作日或加班日,如果是工作时间，直接取
    //            2-计算两个时间的工作日时长，不包括节假日，周末，18：00（前一个工作日）- 9：00（后一个工作日）
	public String getHoliday(String year) {
		//System.out.println("yearGlobal==="+yearGlobal+"year==="+year);
		if (yearGlobal.equals(year)) {
			//System.out.println("直接取值"+holiday);
			return holiday;
		}
		yearGlobal=year;
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("  select cval4 from sm_config where type='workday' and ckey='holiday' and cval1='"+year+"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				holiday=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return holiday;
	}
	public String overtimeDay(String year) {
		PreparedStatement ps;
		//System.out.println("yearGlobal==="+yearGlobal+"year==="+year);
		if (yearGlobal.equals(year)) {
			//System.out.println("直接取值"+overtimeDay);
			return overtimeDay;
		}
		yearGlobal=year;
		try {
			ps = connection.prepareStatement("  select cval4 from sm_config where type='workday' and ckey='overtimeDay' and cval1='"+year+"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				overtimeDay=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return overtimeDay;
	}
	

	// 工作时间
	private final int morningBegin = 9;// 上午开始时间 8点
	private final int morningEnd = 12;// 上午结束时间 12点

	private final int afternoonBegin = 12;// 下午开始时间 14点
	private final int afternoonEnd = 18;// 结束时间 18点

	public static void main(String[] args) {
		try {
			String strDateStart = "2020-05-22 17:03";
			DateCal app = new DateCal();
			SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dateFormat.parse(strDateStart);
			System.out.println(app.getPluseHourDate(dateFormat.parse(strDateStart), 1));    //N小时后的工作日
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// 判断是否是法定节假日
	private boolean isHodliDays(Calendar d1) {
		/*
		 * 关于法定节假日，这里还有一个问题需要提前考虑下 例如：
		 * 国庆10月1号到10月7号，那10月8号正式上班，但是如果10月8号是周日，在计算的时候，也会不考虑进去。这就比较尴尬。
		 * 另外就是10月8号是不是周末，不同年份又不同。 处理办法：
		 * 把可能产生上述问题的日期，都单独拎出来，在计算的时候，先判断是否满足这些日期，再判断这些日期是否是周末
		 * 如果不是周末，正常计算，如果是周末，还要加上当天的时间。
		 */
		String date = DateFormatUtils.fromCalendarToDateMMDD(d1);
		//String str = String.valueOf(d1.get(Calendar.MONTH) + 1) + "-" + String.valueOf(d1.get(Calendar.DAY_OF_MONTH));
		
		String year =  String.valueOf(d1.get(Calendar.YEAR));
		if (getHoliday(year).contains(date)) {
			return true;
		}
		return false;
	}

	// 判断是否是加班日
	private boolean isPlusDay(Calendar d1) {
		//String str = String.valueOf(d1.get(Calendar.MONTH) + 1) + "-" + String.valueOf(d1.get(Calendar.DAY_OF_MONTH));
		String date = DateFormatUtils.fromCalendarToDateMMDD(d1);
		String year =  String.valueOf(d1.get(Calendar.YEAR));
		if (overtimeDay(year).contains(date)) {
			return true;
		}
		return false;
	}

	// 判断是否是周末
	private boolean isWeek(Calendar d1) {
		if (d1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || d1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return true;
		}
		return false;
	}

	// 预处理开始时间
	private Calendar getBeginDay(Calendar d1) {
		if (isHodliDays(d1)) {
			// 如果是节假日,往后延一天，并且从这一天的09:00:00开始
			d1 = addCalendar(d1, 1);
			return getBeginDay(d1);
		} else {
			// 再判断是否是周末，如果是周末，判断是否是加班日
			if (isWeek(d1)) {
				if (!isPlusDay(d1)) {
					d1 = addCalendar(d1, 1);
					return getBeginDay(d1);
				} else {
					return d1;
				}
			} else {
				return d1;
			}
		}
	}

	// 预处理结束时间
	private Calendar getEndDay(Calendar d2) {
		if (isHodliDays(d2)) {
			// 如果是节假日,往前提一天，并且从这一天的00:00:00开始
			d2 = addCalendar(d2, -1);
			return getEndDay(d2);
		} else {
			// 不是节假日
			if (isWeek(d2)) {
				if (!isPlusDay(d2)) {
					d2 = addCalendar(d2, -1);
					return getEndDay(d2);
				} else {
					return d2;
				}
			} else {
				return d2;
			}
		}
	}

	// 预处理重置时分秒
	private Calendar addCalendar(Calendar d, int m) {
		if (m == 1) {
			d.add(Calendar.DATE, 1);
			d.set(Calendar.HOUR_OF_DAY, 9);      // 也可直接设置为beginHour
			d.set(Calendar.MINUTE, 0);
			d.set(Calendar.SECOND, 0);
		} else {
			d.add(Calendar.DATE, -1);
			d.set(Calendar.HOUR_OF_DAY, 23);// 也可直接设置为endHour
			d.set(Calendar.MINUTE, 59);
			d.set(Calendar.SECOND, 59);
		}
		return d;
	}

	// 获取当天实际的工作时间
	private long getDayMiLLI(Calendar d, boolean isBegin) {
		long rv = 0;
		int h = d.get(Calendar.HOUR_OF_DAY);
		if (isBegin) {
			if (h < afternoonEnd) {
				if (h >= morningBegin) {
					if (h >= afternoonBegin) {
						// 计算开始那一天的时间长度
						rv += (afternoonEnd - h) * 60 * 60 * 1000;
						rv -= d.get(Calendar.MINUTE) * 60 * 1000;
						rv -= d.get(Calendar.SECOND) * 1000;
						rv -= d.get(Calendar.MILLISECOND);
					} else if (h >= morningEnd && h < afternoonBegin) {
						rv += (afternoonEnd - afternoonBegin) * 60 * 60 * 1000;
					} else {
						rv += ((afternoonEnd - afternoonBegin) + (morningEnd - h)) * 60 * 60 * 1000;
						rv -= d.get(Calendar.MINUTE) * 60 * 1000;
						rv -= d.get(Calendar.SECOND) * 1000;
						rv -= d.get(Calendar.MILLISECOND);
					}
				} else {
					rv = ((afternoonEnd - afternoonBegin) + (morningEnd - morningBegin)) * 60 * 60 * 1000;
				}
			}
		} else {
			if (h >= morningBegin) {
				if (h < afternoonEnd) {
					if (h >= afternoonBegin) {
						rv += ((morningEnd - morningBegin) + (h - afternoonBegin)) * 60 * 60 * 1000;
						rv += d.get(Calendar.MINUTE) * 60 * 1000;
						rv += d.get(Calendar.SECOND) * 1000;
						rv += d.get(Calendar.MILLISECOND);
					} else if (h >= morningEnd && h < afternoonBegin) {
						rv += (morningEnd - morningBegin) * 60 * 60 * 1000;
					} else {
						rv += (h - morningBegin) * 60 * 60 * 1000;
						rv += d.get(Calendar.MINUTE) * 60 * 1000;
						rv += d.get(Calendar.SECOND) * 1000;
						rv += d.get(Calendar.MILLISECOND);
					}
				} else {
					rv = ((afternoonEnd - afternoonBegin) + (morningEnd - morningBegin)) * 60 * 60 * 1000;
				}
			}
		}
		return rv;
	}

	// 核心计算函数，返回毫秒
	long getDayMiLLI(Calendar c1, Calendar c2) {
		long beginL = 0;// 开始天时间
		long endL = 0;// 结束天时间
		long rv = 0;
		// 如果开始日期和结束日期不是同一天，开始往前计算
		if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR) || c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)
				|| c1.get(Calendar.DAY_OF_MONTH) != c2.get(Calendar.DAY_OF_MONTH)) {
			// 不是同一天
			beginL = getDayMiLLI(c1, true);
			endL = getDayMiLLI(c2, false);
			rv = beginL + endL;
			c1.add(Calendar.DATE, 1);
			if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR) || c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)
					|| c1.get(Calendar.DAY_OF_MONTH) != c2.get(Calendar.DAY_OF_MONTH)) {
				if (!isHodliDays(c1)) {
					if (!isWeek(c1)) {
						rv += ((afternoonEnd - afternoonBegin) + (morningEnd - morningBegin)) * 60 * 60 * 1000;
					} else {
						if (isPlusDay(c1)) {
							rv += ((afternoonEnd - afternoonBegin) + (morningEnd - morningBegin)) * 60 * 60 * 1000;
						}
					}
				}
				c1.add(Calendar.DATE, 1);
			}
		} else {
			// 是同一天
			int bh = c1.get(Calendar.HOUR_OF_DAY);// 开始
			int eh = c2.get(Calendar.HOUR_OF_DAY);// 结束
			if (bh < morningBegin) {
				// 开始时间小于早上开始时间，就等于说及计算结束时间在这一天的实际时间
				rv += getDayMiLLI(c2, false);
			} else {
				if (eh >= afternoonEnd) {
					// 结束时间大于下午结束时间，等于就是计算开始时间在这一天的实际时间
					rv += getDayMiLLI(c1, true);
				} else {
					/**
					 * 开始和结束都在中间时间段 1.开始和结束都在上午 2.开始和结束都在下午 3.开始在上午，结束在下午 4.开始在中间，结束不在 5.结束在中间，开始不在
					 * 6.开始和结束都在中间
					 */

					if (eh < morningEnd || bh >= afternoonBegin) {
						// 都在上午或者都在下午
						rv += (eh - bh) * 60 * 60 * 1000;
						rv -= c1.get(Calendar.MINUTE) * 60 * 1000;
						rv -= c1.get(Calendar.SECOND) * 1000;
						rv -= c1.get(Calendar.MILLISECOND);
						rv += c2.get(Calendar.MINUTE) * 60 * 1000;
						rv += c2.get(Calendar.SECOND) * 1000;
						rv += c2.get(Calendar.MILLISECOND);
					} else if (bh < morningEnd && eh >= afternoonBegin) {
						// 开始在上午，结束在下午
						rv += ((eh - bh) - (afternoonBegin - morningEnd)) * 60 * 60 * 1000;
						rv -= c1.get(Calendar.MINUTE) * 60 * 1000;
						rv -= c1.get(Calendar.SECOND) * 1000;
						rv -= c1.get(Calendar.MILLISECOND);
						rv += c2.get(Calendar.MINUTE) * 60 * 1000;
						rv += c2.get(Calendar.SECOND) * 1000;
						rv += c2.get(Calendar.MILLISECOND);
					} else if (bh < morningEnd && eh < afternoonBegin) {
						// 开始在上午，结束在中间
						rv += (morningEnd - bh) * 60 * 60 * 1000;
						rv -= c1.get(Calendar.MINUTE) * 60 * 1000;
						rv -= c1.get(Calendar.SECOND) * 1000;
						rv -= c1.get(Calendar.MILLISECOND);
					} else if (bh > morningEnd && eh >= afternoonBegin) {
						// 开始在中间，结束在下午
						rv += (eh - afternoonBegin) * 60 * 60 * 1000;
						rv += c2.get(Calendar.MINUTE) * 60 * 1000;
						rv += c2.get(Calendar.SECOND) * 1000;
						rv += c2.get(Calendar.MILLISECOND);
					} else {
						System.out.println("the begin time c1 " + c1.toString() + " and the end time c2 "
								+ c2.toString() + " in not work day!");
					}
				}
			}
		}
		return rv;
	}

	private Calendar getNew(Calendar begin) {
		begin.add(Calendar.DATE, 1);
		begin.set(Calendar.HOUR_OF_DAY, morningBegin);
		begin.set(Calendar.MINUTE, 0);
		begin.set(Calendar.SECOND, 0);
		return begin;
	}

	// 核心计算函数，返回日期
	private Date func(Calendar begin, double hours) {
		begin = getBeginDay(begin);  //开始工作日
		int h = begin.get(Calendar.HOUR_OF_DAY); //传入日期的小时
		if (h < morningBegin) {
			// 全天
			if (hours > ((afternoonEnd - afternoonBegin) + (morningEnd - morningBegin))) {
				begin = getNew(begin);
				hours = hours - ((afternoonEnd - afternoonBegin) + (morningEnd - morningBegin));
				return func(begin, hours);
			} else {
				/**
				 * 这里要判断下，这个小时是否大于上午的工作时间，大于的话，时间就的到下午去了
				 */
				if (hours > (morningEnd - morningBegin)) {
					begin.set(Calendar.HOUR_OF_DAY, afternoonBegin);
					hours = hours - (morningEnd - morningBegin);
				} else {
					begin.set(Calendar.HOUR_OF_DAY, morningBegin);
				}
				begin.set(Calendar.MINUTE, 0);
				begin.set(Calendar.SECOND, 0);
				begin.set(Calendar.MILLISECOND, 0);
				long time = begin.getTime().getTime();
				hours = hours * 60 * 60 * 1000;
				time += hours;
				return new Date(time);
			}
		} else if (h >= afternoonEnd) {
			// 过期，新增一天，重新算
			begin.add(Calendar.DATE, 1);
			return func(begin, hours);
		} else {
			// 计算
			long tm = getDayMiLLI(begin, true);// 今天工作时间
			double houts_m = hours * 60 * 60 * 1000;   //追加的毫秒数
			if (tm >= houts_m) {
				// 不跨天，计算今天的
				if (h < morningEnd) {
					// 在上午
					long rv = 0;
					rv += (morningEnd - h) * 60 * 60 * 1000;
					rv -= begin.get(Calendar.MINUTE) * 60 * 1000;
					rv -= begin.get(Calendar.SECOND) * 1000;
					rv -= begin.get(Calendar.MILLISECOND);
					if (houts_m > rv) {
						// 到下午
						begin.set(Calendar.HOUR_OF_DAY, afternoonBegin);
						begin.set(Calendar.MINUTE, 0);
						begin.set(Calendar.SECOND, 0);
						begin.set(Calendar.MILLISECOND, 0);
						long time = begin.getTime().getTime();
						time += (houts_m - rv);
						return new Date(time);
					} else {
						// 还在上午
						long time = begin.getTime().getTime();
						time += houts_m;
						return new Date(time);
					}
				} else if (h >= afternoonBegin) {
					// 在下午
					long time = begin.getTime().getTime();
					time += houts_m;
					return new Date(time);
				} else {
					// 在中间
					begin.set(Calendar.HOUR_OF_DAY, afternoonBegin);
					begin.set(Calendar.MINUTE, 0);
					begin.set(Calendar.SECOND, 0);
					begin.set(Calendar.MILLISECOND, 0);
					long time = begin.getTime().getTime();
					time += houts_m;
					return new Date(time);
				}
			} else {
				// 跨天，到第二天
				begin = getNew(begin);
				hours = (houts_m - tm) / 1000 / 60 / 60;
				return func(begin, hours);
			}
		}
	}

	/**
	 * 计算两个日期之间的时间差，不算节假日、不算周末、不算非正常工作时间
	 * <p>
	 * 设计思路： 取开始时间，判断是否是节假日、是否是周末、是否是加班日 如果是节假日： 往后+1天，再继续判断 如果是周末：
	 * 判断是否是加班日，如果不是加班日，往后+1天
	 *
	 * @param begin 开始时间
	 * @param end   结束时间
	 * @return 时间差，单位是毫秒
	 */
	public long getMinusofTowDate(Calendar begin, Calendar end) {
		long midL = 0;// 中间差值时间
		// 0.预处理
		begin = getBeginDay(begin);
		end = getEndDay(end);
		// 1.如果开始时间大于结束时间，交换下，同时结果返回负数即可
		if (begin.after(end)) {
			Calendar swap = begin;
			begin = end;
			end = swap;
			midL = -getDayMiLLI(begin, end);
		} else {
			midL = getDayMiLLI(begin, end);
		}
		// 2.计算开始
		return midL;
	}

	/**
	 * 根据日期计算xx小时后对应日期，刨除工作日、节假日
	 *
	 * @param d
	 * @param hours
	 * @return
	 */
	public Date getPluseHourDate(Date d, double hours) {
		Calendar cal_start = Calendar.getInstance();
		cal_start.setTime(d);
		return func(cal_start, hours);
	}
}
