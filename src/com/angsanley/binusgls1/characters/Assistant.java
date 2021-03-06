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
package com.angsanley.binusgls1.characters;

import com.angsanley.binusgls1.interfaces.*;

public class Assistant extends BaseCharacter implements IWorker, IDriver {

	public Assistant(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void doDrive() {
		System.out.println(getName() + " menyetir");
		
	}

	@Override
	public void doWork() {
		System.out.println(getName() + " bekerja");
		
	}

}
