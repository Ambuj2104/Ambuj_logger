package com.epam.Logger;
import java.io.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Ambuj_log {
		int choice;
		double houseArea;
		double constructionCost;
		boolean fullyAutomated=false;
		private static final Logger logger = LogManager.getLogger(Ambuj_log.class);
		
		public void inputData() throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			logger.info("Select the Material Standard:\n"
					+ "1.Standard Material\n"
					+ "2.Above Standard Material\n"
					+ "3.High Standard Material\n");
			
			choice = Integer.parseInt(br.readLine());
			
			try {
				if(choice>3 || choice<1) {
					throw new IOException("Wrong Choice");
				}
			}
			catch(IOException e) {
				logger.error(e.getMessage());
				return ;
			}
			if(choice==3) {
				logger.info("Do you want your home to be funny Automated?(y/n)\n");
				String ans = br.readLine();
				if(ans.equals("y") || ans.equals("Y")) {
					fullyAutomated = true;
				}
			}
			
			logger.info("Enter total house Area:\n");
			houseArea = Double.parseDouble(br.readLine());
		}
		
		public void processData() {
			switch(choice) {
			case 1: constructionCost = houseArea * 1200;
					break;
			case 2: constructionCost = houseArea * 1500;
					break;
			
			}
			if(choice==3 && !fullyAutomated) {
				constructionCost = houseArea * 1800;
			}
			else if(choice==3 && fullyAutomated) {
				constructionCost = houseArea * 2500;
			}

		}
		
		public void outputData() throws IOException {
			logger.info("Total cost of construction of house is:" + constructionCost + "INR");
		}
		
		public static void main(String args[]) throws IOException{
			BasicConfigurator.configure();
			Ambuj_log mainObject = new Ambuj_log();
			mainObject.inputData();
			mainObject.processData();
			mainObject.outputData();
		}

		

	}

