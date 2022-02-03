package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.bank.Exception.NameInvalidException;


public class DBOperations {

Scanner sc=new Scanner(System.in);
	
	
	public void createTable() throws Exception {
			Connection con = DBUtil.getConnection();
			
			String createtable="create table acount(acno long,name varchar(40),addres varchar(40),balance double,panno varchar(40))";
					Statement stmt = con.createStatement();
					stmt.execute(createtable);
					stmt.close();
					con.close();
					System.out.println("Table Created");
	}
	
	public void insertAccount(long acno, String add, double b, String name, String panno) throws Exception {
		Connection con=DBUtil.getConnection();		
	String insertEmployee="insert into acount values("+acno+",'"+name+"','"+add+"',"+b+",'"+panno+"')";
					Statement stmt = con.createStatement();
					stmt.execute(insertEmployee);				
					con.close();
					stmt.close();
					System.out.println("data added..");
}
	public void selectAllRecord() throws Exception 
	{
						Connection con = DBUtil.getConnection();
						String select="select * from acount";
						Statement stmt = con.createStatement();
						ResultSet resultSet = stmt.executeQuery(select);
						while(resultSet.next()) {
								//here sequence not matter but index matter.
									long acno = resultSet.getLong(1);
									String name=resultSet.getString(2);
									String add=resultSet.getString(3);
									double bal=resultSet.getDouble(4);
									String pan=resultSet.getString(5);
									System.out.println();			
									System.out.println("acno: "+acno+" name: "+name+" addrres: "+add+" balance: "+bal+" panno: "+pan);
						}	
	}
	public void updateBalance() throws Exception {
		Connection con = DBUtil.getConnection();
		System.out.println("enter acno to deposite balance");
		long acno=sc.nextLong();
		System.out.println("enter amount to deposite");
		double dbal=sc.nextDouble();
		String selectbalance="select balance from acount where acno="+acno+"";
		Statement stmt = con.createStatement();
					ResultSet resultSet = stmt.executeQuery(selectbalance);
					resultSet.next();
					double bal = resultSet.getDouble(1);
					dbal=bal+dbal;
					
					String update="update acount set balance="+dbal+" where acno="+acno+"";
					//Statement stmt = con.createStatement();
						 stmt.executeUpdate(update);
					
			 //stmt.executeUpdate(deleteemployee);
			 stmt.close();
			 con.close();
			 System.out.println("Balance Updated where Account No="+acno+".......");
	}
	public void withDrawal() throws Exception {
		System.out.println("Enter Account no to WithDrawal..");
		long acno=sc.nextLong();
		System.out.println("Enter Balnce for WithDrawal..");
		double wbal=sc.nextDouble();
				Connection con = DBUtil.getConnection();			
				String selectbalance="select balance from acount where acno="+acno+"";
				Statement stmt = con.createStatement();
							ResultSet resultSet = stmt.executeQuery(selectbalance);
							resultSet.next();
							double bal = resultSet.getDouble(1);
							if(bal>=wbal) {
							        wbal=bal-wbal;
							        String update="update acount set balance="+wbal+" where acno="+acno+"";
										 stmt.executeUpdate(update);
										 System.out.println("Mony WithDrawal from Account No="+acno+".......");
							} 
							else {
								System.out.println("Insufitiant balance");
							}
							
							
					 //stmt.executeUpdate(deleteemployee);
					 stmt.close();
					 con.close();				
	}

	public void upadteAccount() throws Exception {
		
		
		boolean flag=true;
		
		while(flag) {
			Connection con = DBUtil.getConnection();
			System.out.println("1: Update AccountNo");
			System.out.println("2: Upadte Name");
			System.out.println("3: Update Addres");
			System.out.println("4: Update PanNo:");
			System.out.println("5: Exite");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter your  AccountNo That you Want To Change Acno");
				long acno=sc.nextLong();
				String selectacno="select acno from acount where acno="+acno+"";
				Statement stmt = con.createStatement();
							ResultSet resultSet = stmt.executeQuery(selectacno);
							resultSet.next();
							if(resultSet.getRow()>0) {
							    long uacno = resultSet.getLong(1);
				                System.out.println("Enter New Account No For Updation");
				                long nacno=sc.nextLong();
							    if(acno==uacno) 
							  {
							        String update="update acount set acno="+nacno+" where acno="+uacno+"";
										 stmt.executeUpdate(update);
										 System.out.println("Account no Updated...");
							  } 
							}
							else
							{
								System.out.println("Account No Not Match.....");
							}
							con.close();
						stmt.close();
				break;
				
			case 2:
				System.out.println("Enter Your  AccountNo That you Want To Change Name");
				long nameacno=sc.nextLong();
				String selectname="select acno from acount where acno="+nameacno+"";
				Statement stmt1 = con.createStatement();
							ResultSet resultSet1 = stmt1.executeQuery(selectname);
							resultSet1.next();
							//System.out.println(resultSet1);
							if(resultSet1.getRow()>0)
							{
								long uacno1 = resultSet1.getLong(1);
								if(uacno1==nameacno||uacno1>0) 
								{	
									System.out.println("Enter the Account Holder New Name For Update..");
									String name=sc.next();
									name=name+sc.nextLine();
									String p=name.substring(0,2);
									if(p.equals("Mr")||p.equals("Ms")||p.equals("mr"))
									{		
										String update1="update acount set name='"+name+"' where acno="+uacno1+"";
								        //System.out.println(update1);
											 stmt1.executeUpdate(update1);
											 System.out.println("Account No Name Updated...");			
									}
									else 
									{
											System.out.println("Enter Mr or Mis");
									}									 
								} 
							}
							else 
							{
								System.out.println("Account No Not Match.....");
							}
							con.close();
    						 stmt1.close();	
			break;
			
			case 3:
				System.out.println("Enter Your  AccountNo That you Want To Change Addres");
				long addacno=sc.nextLong();	
				String selectaddres="select acno from acount where acno="+addacno+"";//select acno here
				Statement stmt2 = con.createStatement();
							ResultSet resultSet2 = stmt2.executeQuery(selectaddres);
							resultSet2.next();
							if(resultSet2.getRow()>0)
							{
				               System.out.println("Enter The Account Holder New Addres..");
				                String addres=sc.next();
				
							 long uacno2 = resultSet2.getLong(1);
							   if(uacno2==addacno)
							  {		
							        String update2="update acount set addres='"+addres+"' where acno="+addacno+"";
							        //System.out.println(update1);
										 stmt2.executeUpdate(update2);
										 System.out.println("Account No Addres Updated...");
										
							 } 
							}
							else
							{
								System.out.println("Account No Not Match.....");
							}
							con.close();
							stmt2.close();
			break;
			case 4:
				System.out.println("Enter Your  AccountNo That you Want To Change Panno");
				long panacno=sc.nextLong();	
				System.out.println("Enter The Account Holder New PanNo..");
				String panno=sc.next().toUpperCase();
					String selectacnoforpan="select acno from acount where acno="+panacno+"";//select acno here
					Statement stmt3 = con.createStatement();
							ResultSet resultSet3 = stmt3.executeQuery(selectacnoforpan);
							resultSet3.next();
							long uacno3 = resultSet3.getLong(1);
							if(uacno3==panacno)
							{		
							        String update3="update acount set panno='"+panno+"' where acno="+panacno+"";
							        //System.out.println(update1);
										 stmt3.executeUpdate(update3);
										 System.out.println("Account No PanNo Updated...");
										 break;
							} 
							else {
								System.out.println("Account No Not Match.....");
							}
							con.close();
							stmt3.close();				
				break;
			case 5:
				flag=false;
				break;
			default:
				System.out.println("Invalid Choice");
				break;			
			}
			con.close();
		}
		
	}
	public void viewSigleRecord() throws Exception
	{
		Connection con = DBUtil.getConnection();
		System.out.println("Enter Account No..");
		long vacno=sc.nextLong();
		String select="select * from acount where acno="+vacno+"";
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery(select);
		while(resultSet.next()) {
				//here sequence not matter but index matter.
					long acno = resultSet.getLong(1);
					if(vacno==acno) 
					{
					  String name=resultSet.getString(2);
					  String add=resultSet.getString(3);
					  double bal=resultSet.getDouble(4);
					  String pan=resultSet.getString(5);				
					  System.out.println("acno: "+acno+" name: "+name+" addrres: "+add+" balance: "+bal+" panno: "+pan);
					}
					else
					{
					  System.out.println("This Account no: "+vacno+" Not Found");
					}
		}
		con.close();
		stmt.close();
	}
	
	
}