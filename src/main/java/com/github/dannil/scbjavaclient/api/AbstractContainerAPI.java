/*
 * Copyright 2014 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class AbstractContainerAPI extends AbstractAPI {

	protected List<AbstractAPI> apis;

	protected AbstractContainerAPI() {
		super();

		this.apis = new ArrayList<AbstractAPI>();
	}

	@Override
	public void setLocale(Locale locale) {
		super.locale = locale;

		for (AbstractAPI api : this.apis) {
			api.setLocale(super.locale);
		}
	}

}