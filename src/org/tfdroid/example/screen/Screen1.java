/*
 * Copyright 2011 tfdroid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tfdroid.example.screen;

import org.tfdroid.screen.ScrollScreen;
import org.tfdroid.screen.ScrollScreenActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Screen1 extends ScrollScreenActivity 
		implements ScrollScreen.ScreenContentFactory, ScrollScreen.OnScreenChangeListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ScrollScreen scrollScreen = getScrollScreen();
		scrollScreen.addScreen(4, this);
		scrollScreen.setOnScreenChangedListener(this);
	}
	
	@Override
	public View createScreenContent(int index) {
		ListView listView = new ListView(this);
		ArrayAdapter<String> adapter = null;
		
		switch (index) {
		case 0:
			adapter = new ArrayAdapter<String>(this, 
					android.R.layout.simple_list_item_1, android.R.id.text1, 
					new String[]{"百度","谷歌"});			
			break;
		case 1:
			adapter = new ArrayAdapter<String>(this, 
					android.R.layout.simple_list_item_1, android.R.id.text1, 
					new String[]{"163","腾讯","搜狐"});			
			break;
		case 2:
			adapter = new ArrayAdapter<String>(this, 
					android.R.layout.simple_list_item_1, android.R.id.text1, 
					new String[]{"优酷","土豆"});			
			break;
		case 3:
			adapter = new ArrayAdapter<String>(this, 
					android.R.layout.simple_list_item_1, android.R.id.text1, 
					new String[]{"CSDN"});			
			break;			
		default:
			break;
		}
		listView.setAdapter(adapter);
		
		return listView;
	}

	@Override
	public void onScreenChanged(int index) {
		Toast.makeText(this, String.valueOf(index), Toast.LENGTH_SHORT).show();
	}
}
