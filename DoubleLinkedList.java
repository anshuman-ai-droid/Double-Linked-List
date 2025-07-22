//Menu based program of Double Linked List
import java.util.*;
public class dll
{
    class Node1
    {
        int a;
        Node1 prev;
        Node1 next;
        Node1(int n)
        {
            a=n;
            prev=null;
            next=null;
        }
    }
    Node1 head,tail,tmp;
    public void addFirst(int a)//To add an element in the first position
    {
        System.out.println("calling add first");
        Node1 obj=new Node1(a);
        if(head==null)
        {
            head=obj;
            tail=obj;        
        }
        else
        {
            obj.next=head;
            head.prev=obj;
            head=obj;
        }
    }
    public void addLast(int a)//To add an element in the last position
    {
        Node1 obj=new Node1(a);
        if(tail==null)
        head=tail=obj;
        else
        {
            tail.next=obj;
            obj.prev=tail;
            tail=obj;
        }
    }
    public void removeFirst()//To remove the first element from the list
    {
        if(head==null)
        return;
        if(head==tail)
        head=tail=null;
        else
        {
            head=head.next;
            head.prev=null;
        }
    }
    public void removeLast()//To remove the last element fromt the list
    {
        if(tail==null)
        return;
        if(head==tail)
        head=tail=null;
        else
        {
            tail=tail.prev;
            tail.next=null;
        }
    }
    public void displayf()//To display the current list in Forward Oder
    {
        Node1 tmp=new Node1(0);       
        tmp=head;       
        while(tmp!=null)
        {
            System.out.print(tmp.a+"<->");
            tmp=tmp.next;
        }
        System.out.print("null");
        System.out.println(" ");
    }
    public void displayb()//To display the current list in Backward Oder
    {
        Node1 tmp=new Node1(0);       
        tmp=tail;       
        while(tmp!=null)
        {
            System.out.print(tmp.a+"<->");
            tmp=tmp.prev;
        }
        System.out.print("null");
        System.out.println(" ");
    }
    int countNode()//To count number of elements in the list
    {
        Node1 tmp=new Node1(0);
        tmp=head;
        int c=0;
        while(tmp!=null)
        {
            c++;
            tmp=tmp.next;
        }
        return c;
    }
    public void search(int n)//To search an element in the list
    {
        Node1 tmp=new Node1(0);
        tmp=head;
        int c=0,f=0;
        while(tmp!=null)
        {
            if(tmp.a==n)
            {
                f=1;
                break;
            }
            else
            {
                tmp=tmp.next;
                c++;    
            }
        }
        if(f==1)
        System.out.println("Number found, Position : "+(c+1));
        else
        System.out.println("Number not present");
    }
    void sort()//To sort the current list
    {
        Node1 x=new Node1(0);
        Node1 y=new Node1(0);
        Node1 tmp=new Node1(0);
        x=head;
        while(x!=null)
        {
            y=x.next;
            while(y!=null)
            {
                if(y.a<x.a)
                {
                    tmp.a=y.a;
                    y.a=x.a;
                    x.a=tmp.a;
                }
                y=y.next;
            }
            x=x.next;
        }
        System.out.println("List Sorted, Press 5 to see");
    }
    void insert_a(int p,int n)//To insert a Node after the given value
    {
        Node1 tmp=new Node1(0);
        Node1 x=new Node1(0);
        tmp=head;
        Node1 t=new Node1(0);
        t.a=n;
        t.next=null;
        t.prev=null;
        while(tmp!=null)
        {
            if(tmp.a==p)
            {
                x=tmp.next;
                tmp.next=t;
                t.prev=tmp;
                t.next=x;
                x.prev=t;
                break;
            }
            else
            {
                tmp=tmp.next;
            }
        }
        System.out.println("Node Added! Press 5 to see");
    }
    void insert_b(int p,int n)//To insert a Node before the given value
    {
        Node1 tmp=new Node1(0);
        Node1 x=new Node1(0);
        tmp=head;
        Node1 t=new Node1(0);
        t.a=n;
        t.next=null;
        t.prev=null;
        while(tmp!=null)
        {
            if(tmp.a==p)
            {
                x=tmp.prev;
                x.next=t;
                t.prev=x;
                t.next=tmp;
                tmp.prev=t;
                break;
            }
            else
            {
                tmp=tmp.next;
            }
        }
        System.out.println("Node Added! Press 5 to see");
    }
    public static void main(String ab[])
    {
        Scanner sc=new Scanner(System.in);  
        dll obj1=new dll();
        int ch;
        do
        {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Input Choice : ");
            System.out.print("0.Exit \n1.Add at first position \n2.Add at last position \n3.Remove first element");
            System.out.print("\n4.Remove last element \n5.Diplay the current list(Forward/Backward Order) \n6.Count elements");
            System.out.println("\n7.Search element \n8.Sort the list \n9.Insert a Node(After/Before the given value)");
            ch=sc.nextInt();
            
            if(ch==1)
            {
                System.out.println("Enter number to be added :");
                int n=sc.nextInt();
                obj1.addFirst(n);
            }
            else if(ch==2)
            {
                System.out.println("Enter number to be added :");
                int n=sc.nextInt();
                obj1.addLast(n);
            }
            else if(ch==3)
            obj1.removeFirst();
            else if(ch==4)
            obj1.removeLast();
            else if(ch==5)
            {
                System.out.println("1.To display in Forward Order , 2.To display in Backward Order");
                int k=sc.nextInt();
                if(k==1)
                obj1.displayf();
                else if(k==2)
                obj1.displayb();
                else
                System.out.println("Invalid Input");
            }
            else if(ch==6)
            System.out.println("Number of elements : "+obj1.countNode());
            else if(ch==7)
            {
                System.out.println("Enter number to be searched :");
                int k=sc.nextInt();
                obj1.search(k);
            }
            else if(ch==8)
            obj1.sort();
            else if(ch==9)
            {
                System.out.println("1.To insert after a value , 2.To insert before a value");
                int k=sc.nextInt();
                System.out.println("Enter position :");
                int p=sc.nextInt();
                System.out.println("Enter number to be inserted :");
                int n=sc.nextInt();
                if(k==1)
                obj1.insert_a(p,n);
                if(k==2)
                obj1.insert_b(p,n);
                else
                System.out.println("Invalid Input");
            }
        }
        while(ch!=0);
        System.out.println("Thank You!");
    }
}
