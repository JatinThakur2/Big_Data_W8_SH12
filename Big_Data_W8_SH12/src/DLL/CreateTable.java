package DLL;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableExistsException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class CreateTable {
	
	
	public static void main(String[] args) throws IOException{
		
		Configuration config = HBaseConfiguration.create();
		@SuppressWarnings({ "deprecation" })
		HBaseAdmin admin = new HBaseAdmin(config);
		
		
		// Get name of table to be created
		Scanner scan = new Scanner(System.in);
		System.out.println("Create Table\nEnter Table Name: ");
		String name = scan.nextLine();
		scan.close();
		
		HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(name));
		
		tableDescriptor.addFamily(new HColumnDescriptor("personal"));
		tableDescriptor.addFamily(new HColumnDescriptor("professional"));
		
		try{
			admin.createTable(tableDescriptor);
			System.out.println("Table Created");
			}
			catch(TableExistsException e){
				System.out.println("A table with this name already exist.\n" + e.toString());
			}
			admin.close();
		
	}

}
