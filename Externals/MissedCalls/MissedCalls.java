import java.util.*;
import java.text.SimpleDateFormat;

class Call
{
	public String name, time, phno;

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

	public void show()
	{
			for(Call c : missed)
					System.out.println(c.toString());
	}

	public void display() {

		Scanner sc = new Scanner(System.in);
		for( int i = 0; i < missed.size(); i++ ) {
			Call c = missed.get(i);
			System.out.println("Missed Call " + (i+1)+ "\nActions:");
			System.out.println("1)Next Call\n2)Delete\n3)Display Details\n4)Exit");
			int choice = sc.nextInt();
			switch(choice) {
					case 1:
							break;
					case 2:
						missed.remove(c);
            i--;
						System.out.println("Deleted " + c.phno);
						break;
					case 3:
						System.out.println("Details " + c.toString());
						break;
					case 4:
						return;
					default:
						System.out.println("Wrong Choice, Enter Again");
            i--;
            break;
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
						mc.add(new Call(phoneNumber, "Private Caller"));
				else
					 	mc.add(new Call(phoneNumber, names[r.nextInt(10)]));
		}
    mc.show();
		mc.display();
		System.out.println("Showing Call Log:");
		mc.show();
  }
}
