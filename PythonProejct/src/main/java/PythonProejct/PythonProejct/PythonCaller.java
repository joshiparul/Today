package PythonProejct.PythonProejct;
import java.io.*;

import org.python.util.PythonInterpreter;
public class PythonCaller {

	/**
	* @param args
	* @throws IOException
	*/
	public static void main(String[] args) throws IOException {
//	// set up the command and parameter
//	String pythonScriptPath = "/home/SelfServiceBI/timeseries.py";
//	String[] cmd = new String[2];
//	cmd[0] = "Python 2.7.6"; // check version of installed python: python -V
//	cmd[1] = pythonScriptPath;
//	
//	// create runtime to execute external command
//	Runtime rt = Runtime.getRuntime();
//	Process pr = rt.exec(cmd);
//	// retrieve output from python script
//	BufferedReader bfr = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//	String line = "";
//	while((line = bfr.readLine()) != null) {
//	// display each output line form python script
//	System.out.println(line);
//	}
//	}
//	 
//		try {
//	        Process p = Runtime.getRuntime().exec("Python 2.7.6 /home/SelfServiceBI/timeseries.py");
//	        System.out.println("coming till here");
//	        BufferedReader in = new BufferedReader(new InputStreamReader(
//	                p.getInputStream()));
//	        System.out.println("check for right output");
//	        System.out.println(in.readLine());
//	    } catch (Exception e) {
//	    }
//}
//}


		try
		{
			PythonInterpreter.initialize(System.getProperties(), System.getProperties(), new String[0]);
			PythonInterpreter interp = new PythonInterpreter();
			//interp.set("firstName", args[0]);
			//interp.set("lastName", args[1]);
			interp.execfile("D://parul//2018 IPs//HealthcareHub//json_file_of_patient.py");
			//interp.execfile("D://parul//2018 IPs//HealthcareHub//json_prediction_disease.py");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}