import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class PatternEvolver {
	 static char[][] jhimy = new char[0][0];
	 static int m=0,n=0;
	public static BufferedReader getBuffered(String link){

	    FileReader lector  = null;
	    BufferedReader br = null;
	    try {
	         File Arch=new File(link);
	        if(!Arch.exists()){
	           System.out.println("It is not possible to find the file :(");
	        }else{
	           lector = new FileReader(link);
	           br = new BufferedReader(lector);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return br;
	}
	public static void readTxt(){
	    try {
	        //path file
	        String ruta = "input.txt";
	        BufferedReader br = getBuffered(ruta); 
	        while( br.readLine()!=null){
	        	m++;
	        }//get the num rows
	        BufferedReader br1 = getBuffered(ruta);
	        //read the first line and initializate the matrix
	        String linea =  br1.readLine();
	        int contador = 0;
	        String[] values1 = linea.split(",");
	        n=values1.length;
	        jhimy = new char[m][n];
	        int conta = 0;
	        while(linea != null){
	        	String[] values = linea.split(",");
	            //recorremos el arrar de string
	            for (int i = 0; i<values.length; i++) {
	                //se obtiene el primer caracter de el arreglo de strings
	                jhimy[conta][i] = values[i].charAt(0);
	                
	            }
	            conta++;
	            linea = br1.readLine();
	        }
	            
	       
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	/**********************************/
	 public static void printTable(char tabla[][]) {
		  for (int i = 0; i < m; i++) {
			   for (int j = 0; j < n; j++){
				   System.out.print(tabla[i][j]+",");
				}System.out.println();    
		}
	}	
	public static void verify(char table[][]){
		int op=0,w=0,d=0;
		for (int i = 0; i < m; i++) {
			   for (int j = 0; j < n; j++){ /**restart values*/w=0;d=0;
				   if(i==0){//first  of the table
					   if(j==0){//primera fila
						   if(table[i][j]=='W'){//case 1 first element
							   if(table[i][j+1]=='D' && table[i+1][j]=='D'&& table[i+1][j]=='D'){table[i][j]='D';}
						   }
						   if(table[i][j]=='D'){//case 1
							   if(table[i][j+1]=='D' && table[i+1][j]=='D'&& table[i+1][j]=='D'){table[i][j]='D';}
							   else if(table[i][j+1]=='W'|| table[i+1][j]=='W'|| table[i+1][j+1]=='W'){table[i][j]='W';}
							   //else {table[i][j]='W';}
								  // if(table[i][j]=='D'){}
						   }
					   }
					   if(j==n-1){//case 2
						   if(table[i][j]=='W'){//case 1 last element
							   if(table[i+1][j]=='D' && table[i][j-1]=='D'&& table[i+1][j-1]=='D'){table[i][j]='D';}
						   }
						   if(table[i][j]=='D'){//case 1 last element
							   if(table[i+1][j]=='D'&& table[i][j-1]=='D'&& table[i+1][j-1]=='D'){table[i][j]='D';}
							   else if(table[i+1][j]=='W'|| table[i][j-1]=='W'|| table[i+1][j-1]=='W'){table[i][j]='W';}
						   }
					   }
					   if(j>0 && j<n-1){
						   if(table[i][j]=='W'){/********OJO*************/
							   //if(table[i][j-1]=='W'|| table[i][j+1]=='W'||table[i+1][j]=='W'||table[i+1][j+1]=='W'||table[i+1][j-1]=='W')
							   //{table[i][j]='W';}
							   
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(table[i+1][j+1]=='D'){d++;}
							   if(table[i+1][j-1]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   else{table[i][j]='D';}
						   }else if(table[i][j]=='D'){
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(table[i+1][j+1]=='D'){d++;}
							   if(table[i+1][j-1]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   if(d>=4){table[i][j]='W';continue;}
							   
							   //if(table[i][j-1]=='W'|| table[i][j+1]=='W'||table[i+1][j]=='W'||table[i+1][j+1]=='W'||table[i+1][j-1]=='W')
							   //{table[i][j]='W';}
						   }
					   }
				   }//fin primera fila
				   /******************************************************************/
				   if(i==m-1){//ultima fila
					   if(j==0){//primera fila
						   if(table[i][j]=='W'){//case 1 first element
							   if(table[i-1][j]=='D' && table[i][j+1]=='D'&& table[i-1][j+1]=='D'){table[i][j]='D';}
						   }
						   if(table[i][j]=='D'){//case 1
							   if(table[i-1][j]=='D' && table[i][j+1]=='D'&& table[i-1][j+1]=='D'){table[i][j]='D';}
							   else if(table[i-1][j]=='W' || table[i][j+1]=='W' || table[i-1][j+1]=='W'){table[i][j]='W';}
							   //else {table[i][j]='W';}
								  // if(table[i][j]=='D'){}
						   }
					   }
					   if(j==n-1){//case 2
						   if(table[i][j]=='W'){//case 1 last element
							   if(table[i-1][j]=='D' && table[i][j+1]=='D'&& table[i+1][j-1]=='D'){table[i][j]='D';}
						   }
						   if(table[i][j]=='D'){//case 1 last element
							  if(table[i-1][j]=='D' && table[i][j-1]=='D'&& table[i-1][j-1]=='D'){table[i][j]='D';}
							  //if(table[i-1][j]=='D' && table[i][j+1]=='D'&& table[i+1][j-1]=='D'){table[i][j]='D';}
							  else if(table[i-1][j]=='D' || table[i][j-1]=='D'|| table[i-1][j-1]=='D'){table[i][j]='W';}
						   }
					   }
					   if(j>0 && j<n-1){d=0;
						   if(table[i][j]=='W'){/********OJO***********/
							   //if(table[i][j-1]=='W'|| table[i][j+1]=='W'||table[i+1][j]=='W'||table[i+1][j+1]=='W'||table[i+1][j-1]=='W')
							   //{table[i][j]='W';}
							   
							   if(table[i-1][j]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i-1][j-1]=='D'){d++;}
							   if(table[i-1][j+1]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   else{table[i][j]='W';}
							   
						   }else if(table[i][j]=='D'){
							   if(table[i-1][j]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i-1][j-1]=='D'){d++;}
							   if(table[i-1][j+1]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   if(d==2){table[i][j]='D';}
							   if(d>=4){table[i][j]='W';continue;}
							   
							   //if(table[i][j-1]=='W'|| table[i][j+1]=='W'||table[i+1][j]=='W'||table[i+1][j+1]=='W'||table[i+1][j-1]=='W')
							   //{table[i][j]='W';}
						   }
					   }
				   }//fin ultima fila
				   /*************************************************************************/
				   if(i>0 && i<m-1){//operaciones centrales
					   if(j==0){d=0;
						   if(table[i][j]=='W'){
							   if(table[i-1][j]=='D'){d++;}
							   if(table[i-1][j+1]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i+1][j+1]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   else{table[i][j]='W';}
						   }
						  if(table[i][j]=='D'){
							  if(table[i-1][j]=='D'){d++;}
							   if(table[i-1][j+1]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i+1][j+1]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   if(d==2){table[i][j]='D';}
							   if(d>=4){table[i][j]='W';continue;}
						   }
					   }
					   if(j==n-1){d=0;
						   if(table[i][j]=='W'){d=0;
							   if(table[i-1][j]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(table[i+1][j-1]=='D'){d++;}
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i-1][j-1]=='D'){d++;}
							   //if(d==3){table[i][j]='D';}
							   else{table[1][2]='W';}
						   }
						   if(table[i][j]=='D'){d=0;
							   if(table[i-1][j]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(table[i+1][j-1]=='D'){d++;}
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i-1][j-1]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   if(d==2){table[i][j]='D';}
							   if(d>=4){table[i][j]='W';continue;}
						   }
					   }
					   if(j>0 && j<n-1){
						   if(table[i-1][j]=='W'){d=0;
							   if(table[i-1][j+1]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i+1][j+1]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(table[i+1][j-1]=='D'){d++;}
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i-1][j-1]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   else{table[1][2]='W';}
						   }
						   if(table[i-1][j]=='D'){d=0;
							   if(table[i-1][j+1]=='D'){d++;}
							   if(table[i][j+1]=='D'){d++;}
							   if(table[i+1][j+1]=='D'){d++;}
							   if(table[i+1][j]=='D'){d++;}
							   if(table[i+1][j-1]=='D'){d++;}
							   if(table[i][j-1]=='D'){d++;}
							   if(table[i-1][j-1]=='D'){d++;}
							   if(d==3){table[i][j]='D';}
							   if(d==2){table[i][j]='D';}
							   if(d==1){table[i][j]='W';}
							   if(d==0){table[i][j]='W';}
							   if(d>=4){table[i][j]='W';continue;}
						   }
					   }
					   
				   }
				   //System.out.print(table[i][j]+",");
				}//System.out.println();
				    
		}
		
	} 
	 public static boolean isValid(char tabla[][]) {
		 boolean bandera=true;
		  for (int i = 0; i < m; i++) {
			   for (int j = 0; j < n; j++){
				   if(tabla[i][j]=='W' || tabla[i][j]=='D'){bandera=true;}
				   else{bandera=false;break;}
				}System.out.println();
				    
			  }
		  return bandera;
	}	
	public static void main(String[] args) throws IOException{
		readTxt();
		if(isValid(jhimy)){
			verify(jhimy);
			printTable(jhimy);
		}else{
			System.out.println("Format Error!!");
		}
	}

}

