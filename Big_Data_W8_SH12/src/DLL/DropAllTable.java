package DLL;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableNotFoundException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DropAllTable {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MasterNotRunningException, IOException {
		
		Configuration config = HBaseConfiguration.create();
		HBaseAdmin admin = new HBaseAdmin(config);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Drop Tables\n Enter Table Regex: ");
		String regex = scan.nextLine();
		scan.close();
		
		try{
			for(String name : admin.getTableNames(regex)){
				if(admin.isTableEnabled(name))
					admin.disableTable(name);
				admin.deleteTable(name);
				System.out.println(name + " dropped successfully");
			}
		} catch(TableNotFoundException e){
			System.out.println("Table not found\n" + e.toString());
		}
		
		admin.close();
	}

}
