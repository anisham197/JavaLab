import java.util.*;
import java.text.SimpleDateFormat;

class Call
{
	public String name, time, phno;

  public Call (String phno)
	{
		this.phno = phno;
		this.name = "Private Caller";
	  SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	  Date date = new Date();
		this.time = df.format(date);
	}

	public Call(String phno ,String name)
 	{
		this.phno = phno;
		this.name = name;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		this.time = sdf.format(date);
 	}

	public String toString()
	{
		return "Name: " + name + " Number: " + phno + " Time: " + time;
	}
}

public class MissedCalls
{
	ArrayList<Call> missed = new ArrayList<>(10);

  public void add(Call c) {
    if (missed.size() == 10)
      missed.remove(0);
    missed.add(c);
  }

	public void delete(String ph)
	{
			for(Call c : missed)
			{
					if(c.phno.equals(ph)){
							missed.remove(c);
							break;
					}
			}
	}

	public void show()
	{
			for(Call c : missed)
					System.out.println(c.toString());
	}

	public void display() {
		Scanner sc = new Scanner(System.in);
		for( int i = 0; i < missed.size(); i++ ) {
			Call c = missed.get(i);
			System.out.println("Missed call from: " + c.phno + "\nActions:");
			System.out.println("1)Next Call\n2)Delete\n3.Display Details\n4.Delete Specific\n5)Exit");
			int choice = sc.nextInt();
			switch(choice) {
					case 1:
							break;
					case 2:
						missed.remove(c);
						System.out.println("Deleted " + c.toString());
						break;
					case 3:
						System.out.println("Details " + c.toString());
						break;
					case 4:
						System.out.println("Enter number to delete:");
						sc.nextLine();
						String pn = sc.nextLine();
						delete(pn);
						System.out.println("Deleted calls from " + pn);
						break;
					case 5:
						return;
					default:
						System.out.println("Wrong Choice, Enter Again");
			}
		}
	}

  public static void main (String args[]){

    MissedCalls mc = new MissedCalls();
		String[] names = {"John","Joe","Harry","Potter","William","Gates","Ben","Bob","Margret","Mary"};
		Random r = new Random();
		for(int i = 0; i < 12; i++)
		{
				int phno = r.nextInt(99999);
				String phoneNumber = "" + phno;
				if(r.nextInt()%2 == 0)
						mc.add(new Call(phoneNumber));
				else
					 	mc.add(new Call(phoneNumber, names[r.nextInt(10)]));
		}
		mc.display();
		System.out.println("Showing Call Log:");
		mc.show();
  }
}
