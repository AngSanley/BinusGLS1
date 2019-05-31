/*******************************************************************************
 * Copyright 2019 Stanley
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.angsanley.binusgls1;

import java.util.Scanner;
import com.angsanley.binusgls1.characters.*;
import com.angsanley.binusgls1.interfaces.*;

public class Main {
	
	public Main() {
		String choice;
		
		Scanner input = new Scanner(System.in);
		
		BaseCharacter[] arr = new BaseCharacter[6];
		
		arr[0] = new Administrator("Budi", "adalah seorang yang bisa melakukan segalanya");
		arr[1] = new Artist("Agus", "adalah seorang yang kreatif");
		arr[2] = new Assistant("Leo", "adalah seorang asisten");
		arr[3] = new Customer("Nia", "adalah seroang customer");
		arr[4] = new Kanglang("Inem", "adalah seorang pembantu rumah tangga");
		arr[5] = new Worker("Udin", "adalah seorang pekerja");
		
		System.out.println("Simulasi kelompok kemampuan");
		
		for(int x=0; x<5; ++x) {
			System.out.println(x + ":" + arr[x].getName());
		}
		
		System.out.print("Input [Info/Cook/Drive/Work/Paint ID (contoh Cook 4,0)] -> ");
		
		choice = input.nextLine();
		
		String[] action = choice.split(" ");
		String[] indexes = action[1].split(",");
		
		switch(action[0].toUpperCase()) {
		
		case "INFO":
			for (String i : indexes) {
				arr[Integer.parseInt(i)].printInfo();
			}
			break;
			
		case "COOK":
			for (String i : indexes) {
				if (arr[Integer.parseInt(i)] instanceof IChef == false) {
					System.out.println("Pesan eror karena karakter ID " + i + " (" + arr[Integer.parseInt(i)].getName() + ") tidak mengimplementasi IWorker");
				} else {
					if (arr[Integer.parseInt(i)] instanceof Kanglang) {
						Kanglang newKanglang = (Kanglang) arr[Integer.parseInt(i)];
						newKanglang.doCook();
					} else {
						Administrator newAdmin = (Administrator) arr[Integer.parseInt(i)];
						newAdmin.doCook();
					}
				}
			}
			break;
			
		case "DRIVE":
			for (String i : indexes) {
				if (arr[Integer.parseInt(i)] instanceof IDriver == false) {
					System.out.println("Pesan eror karena karakter ID " + i + " (" + arr[Integer.parseInt(i)].getName() + ") tidak mengimplementasi IDriver");
				} else {
					if (arr[Integer.parseInt(i)] instanceof Assistant) {
						Assistant newObj = (Assistant) arr[Integer.parseInt(i)];
						newObj.doDrive();
					} else {
						Administrator newAdmin = (Administrator) arr[Integer.parseInt(i)];
						newAdmin.doDrive();
					}
				}
			}
			break;
			
		case "WORK":
			for (String i : indexes) {
				if (arr[Integer.parseInt(i)] instanceof IWorker == false) {
					System.out.println("Pesan eror karena karakter ID " + i + " (" + arr[Integer.parseInt(i)].getName() + ") tidak mengimplementasi IWorker");
				} else {
					if (arr[Integer.parseInt(i)] instanceof Kanglang) {
						Kanglang newObj = (Kanglang) arr[Integer.parseInt(i)];
						newObj.doWork();
					} else if (arr[Integer.parseInt(i)] instanceof Worker) {
						Worker newObj = (Worker) arr[Integer.parseInt(i)];
						newObj.doWork();
					} else if (arr[Integer.parseInt(i)] instanceof Assistant) {
						Assistant newObj = (Assistant) arr[Integer.parseInt(i)];
						newObj.doWork();
					} else {
						Administrator newAdmin = (Administrator) arr[Integer.parseInt(i)];
						newAdmin.doWork();
					}
				}
			}
			break;
			
		case "PAINT":
			for (String i : indexes) {
				if (arr[Integer.parseInt(i)] instanceof IArtist == false) {
					System.out.println("Pesan eror karena karakter ID " + i + " (" + arr[Integer.parseInt(i)].getName() + ") tidak mengimplementasi IArtist");
				} else {
					if (arr[Integer.parseInt(i)] instanceof Artist) {
						Artist newObj = (Artist) arr[Integer.parseInt(i)];
						newObj.doPaint();
					} else {
						Administrator newAdmin = (Administrator) arr[Integer.parseInt(i)];
						newAdmin.doPaint();
					}
				}
			}
			break;
		}
		
		input.close();
		
	}

	public static void main(String[] args) {
		new Main();
	}

}
