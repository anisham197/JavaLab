import java.util.*;
import java.text.SimpleDateFormat;

class Call{
    String phoneNumber;
    String callerID;
    String timestamp;
    
    //Call without Name
    Call(String p)
    {
        phoneNumber = p;
        callerID = "Private Caller";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        timestamp = sdf.format(date);
    }
     Call(String p,String c)
    {
        phoneNumber = p;
        callerID = c;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        timestamp = sdf.format(date);
    }
    public String toString()
    {
        return "Missed Call from "+callerID+"("+phoneNumber+") at "+timestamp;
    }
}

class CallLog{
    LinkedList<Call> log = new LinkedList<>();
    
    private void sp(String s){System.out.print(s);}
    public void add(Call c)
    {
        sp("\nIncoming Call from "+c.phoneNumber);
        if(log.size()==10)
        {
            log.poll();
        }
        log.addLast(c);
    }
    public void delNo(String ph)
    {
        for(Call c : log)
        {
            if(c.phoneNumber.equals(ph)){
                log.remove(c);
                sp("\nDeleted "+c.toString());
                break;
            }
        }
        sp("\nNumber not found!\n");
    }

    public void show()
    {
        Scanner in = new Scanner(System.in);
        sp("\nCall History:\n");
        int ch;
        for(int i=0;i<log.size();i++)
        {
            Call c = log.get(i);
            sp("\nMissed call from: "+c.phoneNumber+"\nActions:");
            sp("\n1.Delete\n2.Go to next call\n3.display\n4.Delete Specific\n5.Done\nSelection:");
            ch = in.nextInt();
            switch(ch)
            {
                case 1:
                    log.remove(c);
                    sp("\nDeleted "+c.toString());
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println(c);
                    break;
                case 4:
                    sp("Enter number to delete:");
                    in.nextLine();
                    String pn= in.nextLine();
                    delNo(pn);
                    break;

                default:
                    break;
            }
            if(ch==5)break;
        }
    }
    public String toString()
    {
        String disp="";
        for (Call c:log)
        {
            disp+=c.toString()+"\n";
        }
        return disp;
    }
}

public class TestTelephony
{
    public static void main(String[] args) {
        Random r = new Random();
        CallLog l = new CallLog();
        String[] names = {"John","Joe","Harry","Potter","William","Gates","Ben","Bob","Margret","Mary","Lupin","Lily"};
        for(int i = 0; i<12;i++)
        {
            int i1 = r.nextInt(4)+5; // returns random number between 1 and 8
            int i2 = r.nextInt(8);
            int i3 = r.nextInt(8);
            int i4 = r.nextInt(742); // returns random number between 0 and 741
            int i5 = r.nextInt(10000); // returns random number between 0 and 9999

            String phoneNumber = String.format("%d%d%d%03d%04d", i1, i2, i3, i4, i5);
            if(r.nextInt()%2==0)
            {
                
                l.add(new Call(phoneNumber));
            }
            else
            {
                 l.add(new Call(phoneNumber,names[r.nextInt(12)]));
            }
        }
        l.show();
        System.out.println("Showing Call Log:");
        System.out.println(l);
        
    }
}
