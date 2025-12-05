package bank1;
import java.util.Date;

public class account {
	private int КлиентАйди;
	private Date ДатаОткрытия;
	private String Валюта;
	private String ТипСчёта;
	private double Баланс;
	private int СчётАйди;
	private String Статус;

			public account (int КлиентАйди, Date ДатаОткрытия, String Валюта, String ТипСчёта, double Баланс, int СчётАйди, String Статус)
			{
				this.КлиентАйди = КлиентАйди;
				this.ДатаОткрытия = ДатаОткрытия;
				this.Валюта = Валюта;
				this.ТипСчёта = ТипСчёта;
				this.Баланс = Баланс;
				this.СчётАйди = СчётАйди;
				this.Статус = Статус;
			}

			public int getКлиентАйди() { return КлиентАйди; }
			public Date getДатаОткрытия() { return ДатаОткрытия; }
			public String getВалюта() { return Валюта; }
			public String getТипСчёта() {return ТипСчёта; }
			public double getБаланс() {return Баланс; }
			public int getСчётАйди() {return СчётАйди; }
			public String getСтатус() {return Статус; }
	}

