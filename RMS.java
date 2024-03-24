import java.util.Scanner;
class ABC {
    int cid, amt;
    String name, phno, date;
    ABC() {
        cid = 0;
        amt = 0;
        name = "";
        phno = "";
        date = "";
    }
}
class MenuItem {
    int id;
    String iname;
    double price;
    MenuItem(int id, String iname, double price) {
        this.id = id;
        this.iname = iname;
        this.price = price;
    }
}
public class RMS {
    static ABC cust = new ABC();
    static ABC[] a = new ABC[100];
    static MenuItem[] menu = {
            new MenuItem(1, "Veg Biryani", 200.0),
            new MenuItem(2, "Biryani", 130.0),
            new MenuItem(3, "Masala Kulcha", 110.0),
            new MenuItem(4, "Mater Paneer", 250.0),
            new MenuItem(5, "Palak Paneer", 210.0),
            new MenuItem(6, "Chilli Paneer", 280.0),
            new MenuItem(7, "Plane Dosa", 60.0),
            new MenuItem(8, "Paneer Dosa", 90.0),
            new MenuItem(9, "Masala Dosa", 120.0),
            new MenuItem(10, "Haaka Noodles", 220.0),
            new MenuItem(11, "Ice Cream", 90.0),
            new MenuItem(12, "Soft Drink", 59.0)
    };
    static int[] t = new int[7];
    static void Choices() {
        System.out.println("\n Enter your choice according to the given menu");
        String[] menuOptions = {
            "Book a Table", "Check Table Availability", "Collection of the Day", "Total Customer of the Day",
            "Highest Bill of the Day", "Customer Details", "Food Menu", "Exit"
        };
        for (int i = 0; i < 8; i++) {
            System.out.println((i + 1) % 8 + " = " + menuOptions[i]);
        }
    }
    static void space(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(" ");
        }
    }
    static void Slots() {
        int j = 0;
        System.out.println("-------------------TIME SLOT--------------------");
        for (int i = 11; i <= 22; i++) {
            System.out.print((j + 1) + "=" + i + ":00-" + (i + 1) + ":00\t");
            j++;
            if (j % 2 == 0) {
                System.out.println();
            }
        }
    }
    static void Menu() {
        System.out.println("\n--------------------MENU--------------------");
        int j = 0;
        int ch1, plate, o, ans;
        for (int i = 0; i < 12; i++) {
            System.out.print(i + 1 + "=" + menu[i].iname);
            space(20 - menu[i].iname.length());
            System.out.print("Rs." + menu[i].price);
            System.out.println();
        }
    }
    static void TotalCust(int c) {
        System.out.println("Total No of customers are: " + c);
    }
    static void CustDt(int c) {
        for (int i = 0; i < c; i++) {
            System.out.println("\nCustomer ID : " + a[i].cid);
            System.out.println("Name : " + a[i].name);
            System.out.println("Phone Number : " + a[i].phno);
            System.out.println("Date : " + a[i].date);
            System.out.println("Customer Bill : " + a[i].amt);
        }
    }
    public static void main(String[] args) {
        int choice, ch1, plate, cid = 101,  slot, i, c = 0, tot = 0, bill = 0, max = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n------------------------RESTAURANT------------------------");
            Choices();
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            if (choice == 1) {
                bill = 0;
                System.out.print("Name : ");
                cust.name = sc.nextLine();
                System.out.print("Phone No: ");
                cust.phno = sc.nextLine();
                System.out.print("Date : ");
                cust.date = sc.nextLine();
                Menu();
                do {
                    System.out.print("\nEnter your choice: ");
                    ch1 = sc.nextInt();
                    System.out.print("Plate: ");
                    plate = sc.nextInt();
                    System.out.print("Order more dish (Y=yes N=no): ");
                    char ans = sc.next().charAt(0);
                    bill += plate * menu[ch1 - 1].price;
                    if (ans=='N') {
                        break;
                    }
                    else{
                        System.out.println("...Invalid choice...");
                        System.out.println("...Please chooce again...");
                        System.out.print("Order more dish (Y=yes N=no): ");
                        ans = sc.next().charAt(0);
                    }
                } while (true);
                Slots();
                System.out.print("\nEnter Slot: ");
                slot = sc.nextInt();
                t[slot - 1]++;
                System.out.println("\n------------------");
                System.out.println("SUCCESSFUL!!");
                System.out.println("Customer ID : " + cid);
                System.out.println("Table : " + t[slot - 1]);
                cust.cid = cid;
                cust.amt = bill;
                cid++;
                a[c++] = cust;
                tot = tot + bill;
                if (max < bill) {
                    max = bill;
                }
            } else if (choice == 2) {
                Slots();
                System.out.print("\n Enter Slot: ");
                slot = sc.nextInt();
                System.out.println("\n----------------------");
                for (i = 1; i <= 7; i++) {
                    System.out.print("\n Table Number -" + i);
                    System.out.print("\tStatus :");
                    if (i <= t[slot - 1]) {
                        System.out.print("Booked");
                        System.out.print("\tCustomer ID : " + cust.cid);
                    } else {
                        System.out.print("Empty");
                    }
                }
            } else if (choice == 3) {
                System.out.println("\n Collection of the day : " + tot);
            } else if (choice == 4) {
                TotalCust(c);
            } else if (choice == 5) {
                System.out.println("\n Highest bill = " + max);
            } else if (choice == 6) {
                CustDt(c);
            } else if (choice == 7) {
                Menu();
            } else if (choice == 0) {
                System.out.println("\nEXIT");
                break;
            } else {
                System.out.println("\nINVALID CHOICE");
            }
        } while (true);
    }
}
