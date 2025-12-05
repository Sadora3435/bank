package bank1;
import java.util.Date;

public class client {
	private String Фамилия;
	private String Имя;
	private String Отчество;
	private int КлиентАйди;
	private long ИНН;
	private int НомерПаспорта;
	private int СерияПаспорта;
	private long НомерТелефона;

		public client (String Фамилия, String Имя, String Отчество, int КлиентАйди, long ИНН, int НомерПаспорта, int СерияПаспорта, long НомерТелефона)
		{
			this.Фамилия = Фамилия;
			this.Имя = Имя;
			this.Отчество = Отчество;
			this.КлиентАйди = КлиентАйди;
			this.ИНН = ИНН;
			this.НомерПаспорта = НомерПаспорта;
			this.СерияПаспорта = СерияПаспорта;
			this.НомерТелефона = НомерТелефона;
		}

		public String getФамилия() { return Фамилия; }
		public String getИмя() { return Имя; }
		public String getОтчество() { return Отчество; }
		public int getКлиентАйди() {return КлиентАйди; }
		public long getИНН() {return ИНН; }
		public int getНомерПаспорта() {return НомерПаспорта; }
		public int getСерияПаспорта() {return СерияПаспорта; }
		public long getНомерТелефона() {return НомерТелефона; }
}

