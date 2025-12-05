package bank1;
import java.util.Date;

public class operation {
	private int ОперацияАйди;
	private int СчётАйди;
	private String ТипОперации;
	private Date Дата;
	private double Сумма;

	public operation (int ОперацияАйди, int СчётАйди, String ТипОперации, Date Дата, double Сумма)
	{
		this.ОперацияАйди = ОперацияАйди;
		this.СчётАйди = СчётАйди;
		this.ТипОперации = ТипОперации;
		this.Дата = Дата;
		this.Сумма = Сумма;
	}

	public int getОперацияАйди() { return ОперацияАйди; }
	public int getСчётАйди() { return СчётАйди; }
	public String getТипОперации() { return ТипОперации; }
	public Date getДата() {return Дата; }
	public double getСумма() {return Сумма; }

}
